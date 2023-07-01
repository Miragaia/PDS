import java.util.ArrayList;
import java.util.stream.Stream;

public class SweetsDBAdapter implements DatabaseAdapter{
    private Database database;

    public SweetsDBAdapter() {
        this.database = new Database();
    }
    public SweetsDBAdapter(Database database) {
        this.database = database;
    }

    @Override
    public void addEmployee(EmployeeAdapter employee) {
        database.addEmployee(new Employee(employee.getName(), employee.getEmpNum(), employee.getSalary()));
    }

    @Override
    public void removeEmploye(long emp_num) {
        database.deleteEmployee((int) emp_num);
    }

    @Override
    public EmployeeAdapter[] getAllEmployees() {
        Employee[] employees = database.getAllEmployees();
        SweetsEMPAdapter[] employeesAdapted = Stream.of(employees).map(SweetsEMPAdapter::new)
        .toArray(SweetsEMPAdapter[]::new);

        return employeesAdapted;
    }

    @Override
    public boolean isEmployee(long emp_num) {
        for (Employee e : database.getAllEmployees()) {
            if (e.getEmpNum() == emp_num) {
                return true;
            }
        }
        return false;
    }
    
}
