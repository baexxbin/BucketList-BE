package jpabucket.bucketlist.api;

import io.swagger.v3.oas.annotations.Operation;
import jpabucket.bucketlist.dto.bucket.BucketRequestDto;
import jpabucket.bucketlist.dto.bucket.BucketResponseDto;
import jpabucket.bucketlist.dto.bucket.ItemDto;
import jpabucket.bucketlist.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class BucketApiController {

    private final ItemService itemService;

    @Operation(summary = "버킷 생성", description = "Return BucketId")
    @PostMapping("/api/v1/create")
    public ResponseEntity<BucketResponseDto> create(@RequestBody @Valid BucketRequestDto requestDto) {
        Long memberId = requestDto.getMemberId();
        ItemDto itemDto = requestDto.toServicItemDto();
        Long bucketId = itemService.createBucket(itemDto);
        BucketResponseDto responseDto = new BucketResponseDto(memberId ,bucketId);
        return ResponseEntity.ok(responseDto);
    }

}
