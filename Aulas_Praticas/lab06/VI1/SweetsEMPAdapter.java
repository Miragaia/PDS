public class SweetsEMPAdapter implements EmployeeAdapter{
    private Employee empregado;

    public SweetsEMPAdapter(Employee empregado) {
        this.empregado = empregado;
    }

    @Override
    public String getName() {
        return empregado.getName();
    }

    @Override
    public long getEmpNum() {
        return empregado.getEmpNum();
    }

    @Override
    public double getSalary() {
        return empregado.getSalary();
    }
    
}
