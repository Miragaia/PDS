import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List < Employee > employees;

    public Parking() {
        employees = new ArrayList < Employee > ();
    }

    public void allow(Employee e, List < Employee > employees) {
        double avgSalary = 0;
        for (Employee emp: employees) {
            avgSalary += emp.getSalary();
        }
        avgSalary /= employees.size();

        if (!employees.contains(e) && e.getSalary() > avgSalary) {
            this.employees.add(e);
        }
        else if (employees.contains(e) && e.getSalary() <= avgSalary) {
            System.out.println("Employee has low salary.");
        }
        else{
            System.out.println("Employee already has access.");
        }
    }

    public List < Employee > getEmployees() {
        return employees;
    }

}
