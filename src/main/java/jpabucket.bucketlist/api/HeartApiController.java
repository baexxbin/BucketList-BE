package jpabucket.bucketlist.api;

import io.swagger.v3.oas.annotations.Operation;
import jpabucket.bucketlist.dto.bucket.BaseBucketDto;
import jpabucket.bucketlist.service.HeartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heart")
public class HeartApiController {

    private final HeartService heartService;

    @PostMapping
    @Operation(summary = "좋아요 수 업데이트")
    public ResponseEntity<BaseBucketDto> pressHeart(@RequestBody @Valid BaseBucketDto baseBucketDto) {


        // 리펙토링 예정 : 로그인 구현 시, 사용자 인증 확인 코드 추가

        heartService.pressHeart(baseBucketDto);
        return new ResponseEntity<>(baseBucketDto, HttpStatus.CREATED);
    }


    @DeleteMapping
    public ResponseEntity<BaseBucketDto> unPressHeart(@RequestBody @Valid BaseBucketDto baseBucketDto) {


        // 리펙토링 예정 : 로그인 구현 시, 사용자 인증 확인 코드 추가

        heartService.unPressHeart(baseBucketDto);
        return new ResponseEntity<>(baseBucketDto, HttpStatus.OK);
    }

}
