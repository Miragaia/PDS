import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("A", 500.0, 8, 12);
        Phone phone2 = new Phone("B", 400.0, 4, 8);
        Phone phone3 = new Phone("C", 600.0, 16, 16);

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);

        PhoneList list = new PhoneList(phoneList);

        list.setSortingStrategy(new BubbleSortStrategy());
        // list.setSortingStrategy(new InsertionSortStrategy());
        // list.setSortingStrategy(new MergeSortStrategy());

        String sortByProperty = "processor";
        list.sortPhones(sortByProperty);
    }
}

