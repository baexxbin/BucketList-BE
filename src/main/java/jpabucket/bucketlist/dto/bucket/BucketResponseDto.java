package jpabucket.bucketlist.dto.bucket;

import lombok.Data;
import lombok.NonNull;

@Data
public class BucketResponseDto {

    @NonNull
    private Long memberId;
    @NonNull
    private Long bucketId;

    public BucketResponseDto(Long memberId, Long bucketId) {
        this.memberId = memberId;
        this.bucketId = bucketId;
    }
}
