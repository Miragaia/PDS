import java.util.List;

public class MergeSortStrategy implements SortingStrategy {
    @Override
    public void sort(List<Phone> phoneList, String sortByProperty) {
        System.out.println("Sorting using Merge Sort by " + sortByProperty + "...");
    }
}
