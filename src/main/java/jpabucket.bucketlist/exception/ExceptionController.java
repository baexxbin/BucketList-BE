package jpabucket.bucketlist.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static jpabucket.bucketlist.exception.ErrorCode.INVALID_FIELD;
import static jpabucket.bucketlist.exception.ErrorCode.WRONG_OBJECT;

@Slf4j
@RestControllerAdvice       // REST컨트롤러에서 발생하는 예외처리를 담당하는 어드바이스 클래스
public class ExceptionController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)    // (요청 바디, 파라미터의 유효성 검증 실패) 예외 발생시 매서드 호출
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception) {
        ObjectError objectError = Objects.requireNonNull(
                exception.getBindingResult().getAllErrors().stream().findFirst()
                        .orElse(null));
        log.error("handleValidationException throw MethodArgumentNotValidException : {}",       // 예외 처리 중에 발생한 오류 로그 남김
                INVALID_FIELD);
        return ErrorResponse.toResponseEntity(INVALID_FIELD, objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleNotReadableException() {
        log.error("handleNotReadableException throw Exception : {}", WRONG_OBJECT);
        return ErrorResponse.toResponseEntity(WRONG_OBJECT);
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
