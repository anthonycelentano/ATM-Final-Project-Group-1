import java.util.Date;
import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {

		// Date output, decimal format, and Welcome prompt
		DecimalFormat df = new DecimalFormat("0.00");
		Date date = new Date();
		System.out.println(date.toString() + "\n");
		System.out.println("Welcome!");

		// Calling functions
		AccountTransactions account = new AccountTransactions();

		account.userInputInfo();
		account.readMasterFile();
		account.authenticationloop();
		account.chooseTransaction();
		account.transactionProcess();
		account.transactionLoop();
		System.out.println("\nYour Final Current balance is: $" + df.format(account.getTotal()));
		account.updateaccount();
		account.writeToTempFile();
		account.readUpdatedTempFile();
		account.writeToMasterFile();
	}
}
