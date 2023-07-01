
public class Employee{

	Person person;
	private double salary;
	private BankAccount bankAccount;
	EmployeeCard card;

	
	public Employee(Person name, double s, EmployeeCard card) {
		person = name;
		this.card= card;
		salary = s;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}

	public double getSalary() {
		return salary;
	}

	public BankAccount getBankAccount() {
		if(Company.user == User.COMPANY){
			return new Proxy(bankAccount);
		}
		return bankAccount;
	}
}