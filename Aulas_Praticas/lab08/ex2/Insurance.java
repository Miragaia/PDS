import java.util.ArrayList;
import java.util.List;

public class Insurance {
    private List < Employee > employees;

    public Insurance() {
        employees = new ArrayList < Employee > ();
    }

    public void register(Employee e) {
       if(!employees.contains(e)){
            employees.add(e);
        }
        return;
    }

    public List < Employee > getEmployees() {
        return employees;
    } 
}
