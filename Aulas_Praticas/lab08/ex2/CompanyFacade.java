import java.util.List;

public class CompanyFacade {
    private Company company;
    private Insurance insurance;


    private SocialSecurity socialsecurity;
    private Parking parking;

    public CompanyFacade() {
        company = new Company();
        insurance = new Insurance();
        socialsecurity = new SocialSecurity();
        parking = new Parking();
    }


    public void admitEmployee(Person p, double salary) {
        System.out.println(p.getName());
        EmployeeCard card = new EmployeeCard(p.getName());
        Employee e = new Employee(p, salary, card);
        this.company.admitEmployee(e);
        this.insurance.register(e);
        this.socialsecurity.register(e);
        this.parking.allow(e, this.company.employees());
        System.out.println();
    }


    public void paySalaries(int month) {
        this.company.paySalaries(month);
    }

    public List < Employee > employees() {
        return this.company.employees();
    }

}