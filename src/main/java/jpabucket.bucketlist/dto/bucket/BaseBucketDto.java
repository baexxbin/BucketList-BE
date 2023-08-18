package jpabucket.bucketlist.dto.bucket;

import lombok.Data;
import lombok.NonNull;

@Data
public class BaseBucketDto {

    @NonNull
    private Long memberId;
    @NonNull
    private Long bucketId;

    public BaseBucketDto(Long memberId, Long bucketId) {
        this.memberId = memberId;
        this.bucketId = bucketId;
    }
}
