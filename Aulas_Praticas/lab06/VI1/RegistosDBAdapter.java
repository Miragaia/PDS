import java.util.ArrayList;
import java.util.stream.Stream;

public class RegistosDBAdapter implements DatabaseAdapter{
    private Registos database;

    public RegistosDBAdapter() {
        database = new Registos();
    }
    public RegistosDBAdapter(Registos database) {
        this.database = new Registos();
    }
    @Override
    public void addEmployee(EmployeeAdapter employee) {
        String [] names = employee.getName().split(" ");
        String firstName = names[0];
        String lastName = names[1];
        database.insere(new Empregado(firstName, lastName, employee.getEmpNum(), employee.getSalary()));
    }

    @Override
    public void removeEmploye(long emp_num) {
        database.remove((int) emp_num);
    }

    @Override
    public EmployeeAdapter[] getAllEmployees() {
        Empregado[] employees = database.listaDeEmpregados().toArray(new Empregado[0]);
        RegistosEMPAdapter[] employeesAdapted = Stream.of(employees).map(RegistosEMPAdapter::new)
        .toArray(RegistosEMPAdapter[]::new);

        return employeesAdapted;    }
    @Override
    public boolean isEmployee(long emp_num) {
        for (Empregado e : database.listaDeEmpregados()) {
            if (e.codigo() == emp_num) {
                return true;
            }
        }
        return false;
    }
}
