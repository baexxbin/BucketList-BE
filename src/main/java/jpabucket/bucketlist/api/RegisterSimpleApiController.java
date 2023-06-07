package jpabucket.bucketlist.api;


import jpabucket.bucketlist.domain.Register;
import jpabucket.bucketlist.repository.RegisterRepository;
import jpabucket.bucketlist.repository.register.simplequery.RegisterSimpleQueryDto;
import jpabucket.bucketlist.repository.register.simplequery.RegisterSimpleQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xToOne (ManyToOne, OneToOne)
 * Register
 * Register -> Member
 * Register -> Item
 */

@RestController
@RequiredArgsConstructor
public class RegisterSimpleApiController {

    private final RegisterRepository registerRepository;
    private final RegisterSimpleQueryRepository registerSimpleQueryRepository;

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
