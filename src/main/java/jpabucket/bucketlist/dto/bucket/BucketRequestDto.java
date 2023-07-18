package jpabucket.bucketlist.dto.bucket;

import jpabucket.bucketlist.domain.item.ItemType;
import lombok.Data;

import java.time.LocalDate;


// 프레젠테이션 계층에서 받아온 데이터를 컨트롤러와 통신하기 위한 DTO
@Data
public class BucketRequestDto {
    private Long memberId;  // 등록인 id도 DTO에 같이 넣어줌
    private ItemType itemType;
    private String goal;
    private LocalDate targetDate;
    private String way;
    private String reason;
    private int price;

    public BucketRequestDto(Long memberId, ItemType itemType, String goal, LocalDate targetDate, String way, String reason, int price) {
        this.memberId = memberId;
        this.itemType = itemType;
        this.goal = goal;
        this.targetDate = targetDate;
        this.way = way;
        this.reason = reason;
        this.price = price;
    }


    /**
     * 컨트롤러와 서비스 사이 통신용 ServiceDto로 변환하여 전달
     * ItemType에 따라 service에서 처리할 수 있도록 전달
     */
    public ItemDto toServicItemDto() {
        if (ItemType.DO.equals(itemType)) {
            return new ItemDto.TodoDto(goal, targetDate, way);
        } else if (ItemType.WANT.equals(itemType)) {
            return new ItemDto.ToWantDto(goal, targetDate, reason, price);
        }
        return null;
    }
}
