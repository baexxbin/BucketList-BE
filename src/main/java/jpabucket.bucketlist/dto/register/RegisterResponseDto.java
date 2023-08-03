package jpabucket.bucketlist.dto.register;

import lombok.Data;

@Data
public class RegisterResponseDto {

    private Long registerId;

    public RegisterResponseDto(Long registerId) {
        this.registerId = registerId;
    }
}
