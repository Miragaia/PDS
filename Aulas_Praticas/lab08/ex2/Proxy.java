public class Proxy implements BankAccount {

    BankAccount _account;

    public Proxy(BankAccount account) {
        this._account = account;
    }

    @Override
    public void deposit(double amount) {
        this._account.deposit(amount);
    }
       

    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return this._account.withdraw(amount);
        }
        return false;
    }

    @Override
    public double balance() {
        if (Company.user == User.OWNER) {
            return this._account.balance();
        }
        return 0;
    }
    
}
