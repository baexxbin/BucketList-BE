package jpabucket.bucketlist.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jpabucket.bucketlist.domain.Register;
import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.domain.item.ItemType;
import jpabucket.bucketlist.domain.item.ToDo;
import jpabucket.bucketlist.domain.item.ToWant;
import jpabucket.bucketlist.dto.bucket.BucketRequestDto;
import jpabucket.bucketlist.dto.bucket.BucketResponseDto;
import jpabucket.bucketlist.dto.register.RegisterResponseDto;
import jpabucket.bucketlist.repository.RegisterRepository;
import jpabucket.bucketlist.repository.register.simplequery.RegisterSimpleQueryDto;
import jpabucket.bucketlist.repository.register.simplequery.RegisterSimpleQueryRepository;
import jpabucket.bucketlist.service.ItemService;
import jpabucket.bucketlist.service.RegisterService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xToOne (ManyToOne, OneToOne)
 * Register
 * Register -> Member
 * Register -> Item
 */

@Tag(name = "Register", description = "버킷리스트 등록 API")
@RestController
@RequiredArgsConstructor
public class RegisterSimpleApiController {

    private final RegisterRepository registerRepository;
    private final RegisterSimpleQueryRepository registerSimpleQueryRepository;
    private final BucketApiController bucketApiController;

    private final RegisterService registerService;


//    버킷리스트 둘러보기(등록된 모든 버킷리스트 보여주기)
    @GetMapping("/api/v3/simple-orders")
    public List<SimpleRegisterDto> registerV3() {
        List<Register> registers = registerRepository.findAllWithMemberItem();
        List<SimpleRegisterDto> result = registers.stream()
                .map(o -> new SimpleRegisterDto(o))
                .collect(Collectors.toList());
        return result;
    }

    @GetMapping("/api/v4/simple-orders")
    public List<RegisterSimpleQueryDto> registerV4() {
        return registerSimpleQueryRepository.findRegisterDtos();
    }


    /**
     *
     * @param requestDto
     * BucketResponseDto 수정해서(버킷객체 + 사용자id)  요청값으로 넣기
     * @return registerId
     */
    @Operation(summary = "버킷리스트 등록", description = "Return registerId")
    @PostMapping("/api/v1/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid BucketRequestDto requestDto) {
        // 버킷 생성 API(bucketApiController) 호출
        ResponseEntity<BucketResponseDto> bucketResponse = bucketApiController.create(requestDto);

        if (bucketResponse.getStatusCode().is2xxSuccessful()) {
            BucketResponseDto bucketResponseDto = bucketResponse.getBody();
            Long memberId = bucketResponseDto.getMemberId();
            Long bucketId = bucketResponseDto.getBucketId();

            // 등록 프로세스 수행
            Long registerId = registerService.register(memberId, bucketId);

            // registerId 반환
            RegisterResponseDto responseDto = new RegisterResponseDto(registerId);
            return ResponseEntity.ok(responseDto);
        }

        // 실패시 응답
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Data
    static class BucketCreateRequestDto {
        private Long memberId;  // 등록인 id도 DTO에 같이 넣어줌
        private ItemType itemType;
        private String goal;
        private LocalDate targetDate;
        private String way;
        private String reason;
        private int price;
    }

    @Data
    static class CreateBucketResponse {
        private Long id;

        public CreateBucketResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class SimpleRegisterDto {
        private Long registerId;
        private String name;
        private String goal;
        private LocalDate targetDate;


        public SimpleRegisterDto(Register register) {
            registerId = register.getId();
            name = register.getMember().getName(); //Lazy 초기화
            goal = register.getItem().getGoal();
            targetDate = register.getItem().getTargetDate(); //Lazy 초기화
        }

    }

}
