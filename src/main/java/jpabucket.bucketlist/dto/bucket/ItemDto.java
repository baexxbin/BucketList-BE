package jpabucket.bucketlist.dto.bucket;

import jpabucket.bucketlist.domain.item.ItemType;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 서비스 dto: 컨트롤러 -> 서비스
 * TodoDto, TownatDto의 베이스 클래스 역할
 */
@Data
public class ItemDto {
    private String goal;
    private LocalDate targetDate;

    public ItemDto(String goal, LocalDate targetDate) {
        this.goal = goal;
        this.targetDate = targetDate;
    }

    @Getter
    public static class TodoDto extends ItemDto {
        private String way;

        public TodoDto(String goal, LocalDate targetDate, String way) {
            super(goal, targetDate);
            this.way = way;
        }
    }


    @Getter
    public static class ToWantDto extends ItemDto {
        private String reason;
        private int price;

        public ToWantDto(String goal, LocalDate targetDate, String reason, int price) {
            super(goal, targetDate);
            this.reason = reason;
            this.price = price;
        }
    }

}
