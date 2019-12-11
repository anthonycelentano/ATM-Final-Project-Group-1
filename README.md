# ATM-Final-Project-Group-1

Group 1: Marvin Ospina, Anthony Celentano, Julianna Rossano, Ross Krachman





I. Brief Summary:

The project aims to replicate using an Automated Teller Machine. The program is comprised of 3 classes: BankOperations, Transactions, and Main. The Transactions class extends BankOperations and these two classes contain the logic behind this program. The Main class is the driver for this program.

II. Features:

Withdraw, Balance, Deposit

The program has limits on the withdraw and deposit functions (i.e. maximum deposit and withdraw amount is $5000). The program collects data about users including their PINs and account numbers from the user_data.csv file. Following any transactions, account balances are updated and written to the user_data_total.csv file to reflect the changes.

III. Instructions    

A. Before running the code, you must change 2 path files found on line 18 and 19 to reflect the file locations of user_data.csv and user_data_total.csv. Your path should look similar to this if you have a machine running Microsoft Windows: File file = new File("C:\\Users\username\Desktop\userfolder\userdata.csv"); 
File file2 = new File("C:\\Users\username\Desktop\temp.csv"); 

B. Upon completion of step 'A', run the code. 

C. Be sure to use an account number and pin from the user_data.csv file. 

D. Upon successful authentication, type in one of three commands: Deposit, Withdraw, Balance 

E. After selecting an action and inputing an amount (note: you do not input amount for balance) the program will ask you if you want to do another transaction. Type yes or no. 

F. If you select yes, steps D-E will start again until you answer 'no'. 

G. ATM says "goodbye" and your final balance is displayed to you.

*Please Note: If you have a balance that reaches the threshold of -5000, the program will tell you to contact the teller. In order to proceed, you must deposit an amount that ensures the balance is above -5000.

     

