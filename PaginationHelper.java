import java.util.List;
public class PaginationHelper<I> {
    private List<I> items;
    private int itemsPerPage;
    public static void main(String[] args) {
        List<Character> collection = List.of('a', 'b', 'c', 'd', 'e', 'f');
        PaginationHelper<Character> helper = new PaginationHelper<>(collection, 4);
        System.out.println(helper.ItemCount());
        System.out.println(helper.pageCount());
        System.out.println(helper.PageItemCount(1));
        System.out.println(helper.pageIndex(5));
    }

    public PaginationHelper(List<I>collection, int itemsPerPage) {
        this.items = collection;
        this.itemsPerPage = itemsPerPage;
    }

    public int ItemCount() {
        return items.size();
    }

    public int pageCount() {
        return (int)Math.ceil((double) items.size()/itemsPerPage);
    }

    public int PageItemCount(int pageIndex) {
        int pageCount = pageCount();
        if (pageIndex < 0 || pageIndex >= pageCount) {
            return -1;
        }
        if (pageIndex == pageCount - 1) {
            int remainingItems = items.size() % itemsPerPage;
            if (remainingItems == 0) {
                return itemsPerPage;
            } else {
                return remainingItems;
            }
        } else {
            return itemsPerPage;
        }
    }
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= items.size()) {
            return -1;
        }
        return itemIndex/itemsPerPage;
    }
}


