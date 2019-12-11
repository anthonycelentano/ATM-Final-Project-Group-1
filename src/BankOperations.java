import java.util.Scanner;
import java.text.DecimalFormat;


public class BankOperations {
	public String choice = "";
	private double cashIn = 0;
	private double cashOut = 0;
	protected double total = 0;
	private String cashInS = "";
	private String cashOutS = "";
	public boolean error = false;
	public String answer = "yes";

	DecimalFormat df = new DecimalFormat("0.00");
	Scanner keyboard = new Scanner(System.in);

	public BankOperations(String choice, double cashIn, double cashOut, double total, String cashInS, String cashOutS,
			boolean error, String answer) {
		this.choice = choice;
		this.setCashIn(cashIn);
		this.setCashOut(cashOut);
		this.setTotal(total);
		this.setCashInS(cashInS);
		this.setCashOutS(cashOutS);
		this.error = error;
		this.answer = answer;
	}

	public BankOperations() {

	}

	public String chooseTransaction() {
		choice = "";
		while (!choice.equalsIgnoreCase("Deposit") && !choice.equalsIgnoreCase("Withdraw")
				&& !choice.equalsIgnoreCase("Balance")) {
			System.out.println("\nDeposit, Withdraw, Balance:");
			choice = keyboard.next();
		}
		return choice;
	}

	public double transactionProcess() {
		// checks the Total current balance
		if (choice.equalsIgnoreCase("Balance")) {
			System.out.println("Your Total Current Balance is: " + df.format(getTotal()));
		}

		/*
		 * Adds the cashIn input to the total, check if amount being inputed is
		 * no less than 0 and no greater than $5000 in a "do/while" loop. With
		 * input exception handling
		 */
		if (choice.equalsIgnoreCase("Deposit")) {
			do {
				try {
					System.out.println("Type in dollar amount (Max $5000): ");
					cashInS = keyboard.next();
					cashIn = Double.parseDouble(cashInS);
					if (cashIn > 0 && cashIn <= 5000) {
						total = cashIn + total;
						setTotal(total);
					}
					error = false;
				} catch (Exception e) {
					error = true;
					System.out.println("Must be a valid dollar amount. Try again.");
				}
			} while (error == true || (cashIn < 0 || cashIn > 5000));
		}

		/*
		 * Subtracts the cashOut input from the total, check if amount being
		 * inputed is no less than 0 and no greater than $5000. With input
		 * exception handling. Also has an "in the red" limit of -5000 where the
		 * withdraw "do/while" loop breaks.
		 */
		else if (choice.equalsIgnoreCase("Withdraw")) {
			do {
				try {
					System.out.println("Type in dollar amount (Max $5000): ");
					cashOutS = keyboard.next();
					cashOut = Double.parseDouble(cashOutS);
					if (cashOut > 0 && cashOut <= 5000) {
						total = total - cashOut;
						setTotal(total);

						if (total < -5000) {
							total = total + cashOut;
							System.out.println("CANT GO UNDER -5000! ");
							break;
						}
					}
					error = false;
				} catch (Exception e) {
					error = true;
					System.out.println("Must be a valid dollar amount. Try again: ");
				}
			} while (error == true || (cashOut < 0 || cashOut > 5000));

		}
		return total;
	}

	public void transactionLoop() {
		// Asks if user wants another transaction
		do {
			if (total == -5000) {
				System.out.println("You have reached your withdraw limit. Must see teller.");
				break;
			}
			
			System.out.println("\nCurrent Balance is: " + df.format(getTotal()));
			System.out.println("Would you like to do another transaction? (yes/no): ");
			answer = keyboard.next();
			if (answer.equalsIgnoreCase("Yes")) {
				chooseTransaction();
				transactionProcess();

			} else if (answer.equalsIgnoreCase("No")) {
				System.out.println("Goodbye.");

			} else {
				System.out.println("Did you mean 'Yes' or 'No'? Try again.");
				transactionLoop();
			}
		} while (answer.equalsIgnoreCase("Yes"));

	}

	public double getCashIn() {
		return cashIn;
	}

	public void setCashIn(double cashIn) {
		this.cashIn = cashIn;
	}

	public double getCashOut() {
		return cashOut;
	}

	public void setCashOut(double cashOut) {
		this.cashOut = cashOut;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCashInS() {
		return cashInS;
	}

	public void setCashInS(String cashInS) {
		this.cashInS = cashInS;
	}

	public String getCashOutS() {
		return cashOutS;
	}

	public void setCashOutS(String cashOutS) {
		this.cashOutS = cashOutS;
	}

}
