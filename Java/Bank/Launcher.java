import com.user.BankAccount;

public class Launcher {

	public static void main(String[] args) {
		BankAccount newAccount = new BankAccount();
		BankAccount newAccount2 = new BankAccount();
		BankAccount newAccount3 = new BankAccount();
		newAccount.display();
		newAccount2.display();
		newAccount3.display();
		newAccount.saveBalance(2000.220);
		newAccount.saveSavingsBalance(200.220);
		System.out.println("Numero de cuentas creadas : "+BankAccount.getTotalAccounts());
		newAccount.display();
		newAccount.withdrawFunds(300.111);
		newAccount.withdrawFunds(1770);
	}

}
