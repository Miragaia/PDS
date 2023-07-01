import java.util.List;

public class PhoneList {
    private List<Phone> phones;
    private SortingStrategy sortingStrategy;

    public PhoneList(List<Phone> phones) {
        this.phones = phones;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortPhones(String sortByProperty) {
        sortingStrategy.sort(phones, sortByProperty);
    }
}

