import java.util.List;

public class InsertionSortStrategy implements SortingStrategy {
    @Override
    public void sort(List<Phone> phoneList, String sortByProperty) {
        System.out.println("Sorting using Insertion Sort by " + sortByProperty + "...");
    }
}

