//
//
//MAIN CLASS
import java.util.Date;
//import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {

		// Date output, decimal format, and Welcome prompt
		DecimalFormat df = new DecimalFormat("0.00");
		//df.setRoundingMode(RoundingMode.DOWN);
		Date date = new Date();
		System.out.println(date.toString() + "\n");
		System.out.println("Welcome!");
		
		// Calling account object functions
		AccountTransactions account = new AccountTransactions();
		account.userInputInfo();
		account.readMasterFile();
		account.authenticationloop();
		account.chooseTransaction();
		account.transactionProcess();
		account.transactionLoop();
		System.out.println("Your Final Current balance is: $" + account.getTotal());
		account.updateaccount();
		account.writeToTempFile();
		account.readUpdatedTempFile();
		account.writeToMasterFile();
	}
}