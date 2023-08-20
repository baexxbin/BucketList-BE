package jpabucket.bucketlist.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /* 200 */
    SUCCESS(HttpStatus.OK, "OK"),

    /* 400 BAD_REQUEST : 잘못된 요청 */
    WRONG_OBJECT(HttpStatus.BAD_REQUEST, "객체 변환이 되지 않습니다. 올바른 형식을 보내주세요."),
    INVALID_FIELD(HttpStatus.BAD_REQUEST, "인자 형식이 맞지 않습니다."),
    NOT_SUPPORTED_HTTP_METHOD(HttpStatus.BAD_REQUEST,"지원하지 않는 Http Method 방식입니다."),
    NOT_VALID_METHOD_ARGUMENT(HttpStatus.BAD_REQUEST,"유효하지 않은 Request Body 혹은 Argument입니다."),



    HEART_NOT_FOUND(HttpStatus.BAD_REQUEST, "하트를 누르지 않은 상태입니다."),
    ALREADY_HEARTED(HttpStatus.BAD_REQUEST, "이미 하트를 누른 상태입니다."),


    /* 401 UNAUTHORIZED : 잘못된 요청 */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "유효한 인증 자격 증명이 없습니다."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 사용자를 찾을 수 없습니다."),
    ITEM_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 버킷을 찾을 수 없습니다.");


    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */

    /* 500 SERVER_ERROR */

    private final HttpStatus httpStatus;
    private final String message;
}
