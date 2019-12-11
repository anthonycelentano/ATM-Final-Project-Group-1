//
//
//SUBCLASS
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountTransactions extends BankOperations {
	// Variables & Properties for subclass
	private int pin;
	private Long accountnum;// 10-12 digits length
	private String pinS = null;
	private String acnS = null;
	public boolean error2 = false;
	public boolean found = false;
	public String linecontent2 = "";
	
	File file = new File("/Users/marvinospina/Desktop/junk_folder/user_data.csv");
	File file2 = new File("/Users/marvinospina/Desktop/junk_folder/user_data_total.csv");
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> newlist = new ArrayList<String>();
	
	public AccountTransactions(double total, int pin, Long accountnum, String pinS, String acnS, boolean error2, boolean found) {
		//super();
		this.getTotal();
		this.setPin(pin);
		this.setAccountnum(accountnum);
		this.pinS =pinS;
		this.acnS =acnS;
		this.error2 = error2;
		this.found =found;
	}
	
	public AccountTransactions(){
		super();
	}
  
	public void userInputInfo() {
			// Exception handling for input error if user enters invalid account
			// number entry
			// i.e string or decimal. Will loop until correct
			System.out.println("Enter Account Number: ");
			do {
				try {
					acnS = keyboard.nextLine();
					accountnum = Long.parseLong(acnS);
					error2 = false;
				} catch (Exception e) {
					error2 = true;
					System.out.println("Invalid Input, Try account number again: ");
				}
			} while (error2 == true);

			// Exception handling for input error if user enters invalid pin
			// entry
			// i.e string or decimal. Will loop until correct
			System.out.println("Please Type In Your Pin: ");
			do {
				try {
					pinS = keyboard.nextLine();
					pin = Integer.parseInt(pinS);
					error2 = false;
				} catch (Exception e) {
					error2 = true;
					System.out.println("Invalid Input, Try pin again: ");
				}
			} while (error2 == true);

		}
	
	public boolean readMasterFile(){
		try {
			Scanner filereader = new Scanner(file);
			while (filereader.hasNextLine()) {
				String linecontent = filereader.nextLine();
				String[] row = linecontent.split(",");
				if (acnS.equalsIgnoreCase(row[0]) && pinS.equalsIgnoreCase(row[1])) {
					setTotal(Double.parseDouble(row[2]));
					System.out.println("Authentication Succesful.");
					found = true;

					filereader.close();
					break;
				} else {
					found = false;
				}
			}
			if (found == false) {
				System.out.println("User Not Found. Try Again: ");
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return found;
			
	}
  
	public void authenticationloop(){
		while(found == false){
			userInputInfo();
			readMasterFile();	
		}
	}
  
	public void updateaccount(){
		// Reads original file and updates newline with updated balance adding it into list
				try {
					Scanner filereader = new Scanner(file);

					while (filereader.hasNextLine()) {
						linecontent2 = filereader.nextLine();
						if (linecontent2.contains(acnS)) {
							linecontent2 = acnS + "," + pinS + "," + total;
							list.add(linecontent2);
						}

						else if (!linecontent2.contains(acnS)) {
							list.add(linecontent2);
						}
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	}
	
	public void writeToTempFile(){
		// writes updated file content from list into new file.
				try {
					Scanner filereader = new Scanner(file2);
					FileWriter writer = new FileWriter(file2);

					for (int i = 0; i < list.size(); i++) {
						writer.append(list.get(i) + "\n");
					}
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	public void readUpdatedTempFile(){
		//ArrayList<String> newlist = new ArrayList<String>();
		try {
			Scanner filereader = new Scanner(file2);
			while (filereader.hasNextLine()) {
				linecontent2 = filereader.nextLine();
				newlist.add(linecontent2);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToMasterFile(){
		// finally writes updated file content back into original master file
		try {
			Scanner filereader = new Scanner(file2);
			FileWriter writer = new FileWriter(file);

			for (int i = 0; i < newlist.size(); i++) {
				writer.append(newlist.get(i) + "\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setacnS(String acnS) {
		this.acnS = acnS;
	}

	public String getacnS(String acnS) {
		return acnS;
	}

	public void setpinS(String pinS) {
		this.pinS = pinS;
	}

	public String getpinS(String pinS) {
		return pinS;
	}

	public void setAccountnum(Long accountnum) {
		this.accountnum = accountnum;
	}

	public Long getAccountnum(Long accountnum) {
		return accountnum;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}
}