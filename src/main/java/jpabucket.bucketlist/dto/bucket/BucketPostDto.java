//package jpabucket.bucketlist.dto.bucket;
//
//import jpabucket.bucketlist.domain.item.ItemType;
//
//import java.time.LocalDate;
//
//public class BucketPostDto {
//    public static class Request {
//        private Long memberId;
//        private ItemType itemType;
//        private String goal;
//        private LocalDate targetDate;
//        private String way;
//        private String reason;
//        private int price;
//
//        public Request(Long memberId, ItemType itemType, String goal, LocalDate targetDate, String way, String reason, int price) {
//            this.memberId = memberId;
//            this.itemType = itemType;
//            this.goal = goal;
//            this.targetDate = targetDate;
//            this.way = way;
//            this.reason = reason;
//            this.price = price;
//        }
//
//        // Getters and Setters
//
//        public ItemDto toItemDto() {
//            if (ItemType.DO.equals(itemType)) {
//                ItemDto.TodoDto todoDto = new ItemDto.TodoDto();
//                todoDto.setGoal(this.goal);
//                todoDto.setTargetDate(this.targetDate);
//                todoDto.setWay(this.way);
//                return todoDto;
//            } else if (ItemType.WANT.equals(itemType)) {
//                ItemDto.ToWantDto toWantDto = new ItemDto.ToWantDto();
//                toWantDto.setGoal(goal);
//                toWantDto.setTargetDate(targetDate);
//                toWantDto.setReason(reason);
//                toWantDto.setPrice(price);
//                return toWantDto;
//            }
//            return null;
//        }
//    }
//
//    public static class ServiceDto {
//        // Service-specific fields for TodoDto
//        public static class TodoDto extends ItemDto {
//            private String way;
//
//            // Getters and Setters
//        }
//
//        // Service-specific fields for ToWantDto
//        public static class ToWantDto extends ItemDto {
//            private String reason;
//            private int price;
//
//            // Getters and Setters
//        }
//    }
//
//    public static class Response {
//        private Long id;
//        private String goal;
//        private LocalDate targetDate;
//        // Additional fields for response
//
//        public Response(ItemDto itemDto) {
//            this.id = itemDto.getId();
//            this.goal = itemDto.getGoal();
//            this.targetDate = itemDto.getTargetDate();
//            // Populate additional fields for response
//        }
//
//        // Getters and Setters
//    }
//}
