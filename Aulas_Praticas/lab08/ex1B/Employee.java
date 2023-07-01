
class Employee{

	private Person person;
	private double salary;
	private BankAccount bankAccount;

	
	public Employee(Person name, double s) {
		this.person = name;
		salary = s;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}

	public double getSalary() {
		return salary;
	}

	public BankAccount getBankAccount() {
		return new Proxy(bankAccount);
	}
}