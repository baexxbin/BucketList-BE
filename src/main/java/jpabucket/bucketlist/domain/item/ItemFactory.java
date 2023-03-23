package jpabucket.bucketlist.domain.item;

public class ItemFactory {
	public static Item createItem(ItemType type, String goal, String detail, int price) {
		switch (type) {
			case DO:
				ToDo doItem = new ToDo();
				doItem.setGoal(goal);
				doItem.setHeart(0);
				doItem.setWay(detail);
				return doItem;

			case WANT:
				ToWant wantItem = new ToWant();
				wantItem.setGoal(goal);
				wantItem.setHeart(0);
				wantItem.setReason(detail);
				wantItem.setPrice(price);
				return wantItem;

			default:
				throw new IllegalArgumentException("Unknown type: " + type);
		}
	}
}
