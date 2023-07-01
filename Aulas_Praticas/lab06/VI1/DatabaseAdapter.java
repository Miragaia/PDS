public interface DatabaseAdapter {
    public void addEmployee(EmployeeAdapter employee);
    public void removeEmploye(long emp_num);
    public EmployeeAdapter[] getAllEmployees();
    public boolean isEmployee(long emp_num);
}
