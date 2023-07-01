import java.util.List;

public interface SortingStrategy {
    void sort(List<Phone> phoneList, String sortByProperty);
}