import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {
    private List < Employee > employees;

    public SocialSecurity() {
        employees = new ArrayList < Employee > ();
    }

    public void register(Employee name) {
       if(!employees.contains(name)){
            employees.add(name);
        }
        return;
    }

    public List < Employee > getEmployees() {
        return employees;
    }
}
