public class RegistosEMPAdapter implements EmployeeAdapter{
    private Empregado empregado;
    public RegistosEMPAdapter(Empregado empregado) {
        this.empregado = empregado;
    }

    @Override
    public String getName() {
        return empregado.nome()+ " " +empregado.apelido();
    }   

    @Override
    public long getEmpNum() {
        return empregado.codigo();
    }

    @Override
    public double getSalary() {
        return empregado.salario();
    }  
}
