import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class manipulates the bank accounts. A bank object should not exist
 * without its name. has the method to read all the attributes, print all info,
 * create the accounts and person object handles the custom exceptions
 * 
 * @author LC PC
 *
 */
public class Bank {
	// a name (String) which is the name of the bank, and an ArrayList named
	// accounts, which is an ArrayList of Account objects as instance variables.
	private String bankName;
	private ArrayList<Account> accounts;
	private boolean noCard = true;

	/**
	 * parameterized constructor create the bank object with the bank name create
	 * the arraylist with Account object
	 * 
	 * @param bankName
	 * 
	 */
	Bank(String bankName) {
		this.bankName = bankName;
		accounts = new ArrayList<Account>();
	}

	// getter and setter
	public String getBankName() {
		return bankName;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * read account info create the person object with the user inputs prompt the
	 * user to choose account type create the account object based on the user's
	 * choice exception handled if the user input is a wrong type
	 * 
	 * @param input takes user input
	 */
	public void readInfo(Scanner input) {
		System.out.println("Let's get to know our new customer");
		System.out.print("Enter first name: ");
		String firstName = input.nextLine();
		System.out.print("Enter last name: ");
		String lastName = input.nextLine();
		System.out.print("Enter email: ");
		String email = input.next();
		input.nextLine();
		System.out.print("Enter phone number: ");
		long phone = input.nextLong();
		input.nextLine();
		Person accHolder = new Person(firstName, lastName, email, phone);
		int option = 0;
		do {
			System.out.println("1. chequing");
			System.out.println("2. saving");
			System.out.print("Enter the type of account you want to create: ");
			try {
				option = input.nextInt();
				input.nextLine();
				if ((option != 1) && (option != 2)) {
					System.out.println("Invalid option, please re-enter");
				}
				switch (option) {
				case 1:
					Chequing c = new Chequing(accHolder);
					accounts.add(c);
					this.printTitle();
					System.out.println(c.toString());
					break;
				case 2:
					Saving s = new Saving(accHolder);
					accounts.add(s);
					this.printTitle();
					System.out.println(s.toString());
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter a number!");
				input.nextLine();
			}
		} while ((option != 1) && (option != 2));
	}

	/**
	 * exception handle here. throws all the custom exception classes. prompt the
	 * user to choose the transaction actions. if statement to decide the account
	 * numbers, if arraylist.size = 0, then tell the user to create account first.
	 * 
	 * @param input
	 * @throws AccountNotFoundException exception handle for not found account
	 * @throws TransationAmountCannotBeNegative exception handle for negative transaction fund
	 * @throws InsufficientFundException exception handle for transaction fund not correct
	 */
	public void Transactions(Scanner input)
			throws AccountNotFoundException, TransationAmountCannotBeNegative, InsufficientFundException {
		if (this.getAccounts().size() == 0) {
			System.out.println("Create account first");
		} else {
			System.out.println("Enter account number");
			int accNumber = input.nextInt();
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getAccNum() == accNumber) {
					System.out.println("\n" + "Found it!\n" + "(Ignore the error messages)");
					System.out.println("1 Deposit");
					System.out.println("2 Withdraw");
					System.out.println("3 balance");
					int o = input.nextInt();
					switch (o) {
					case 1:
						System.out.println("Enter amount to deposit");
						double amount1 = input.nextDouble();
						if (amount1 < 0) {
							throw new TransationAmountCannotBeNegative("Transaction amount cannot be negative");
							// System.out.println("Transaction amount cannot be negative");
						} else {
							accounts.get(i).deposit(amount1);
						}
						break;
					case 2:
						System.out.println("Enter amount to withdraw");
						double amount2 = input.nextDouble();
						if (amount2 <= accounts.get(i).getBalance() && (amount2 >= 0)) {
							accounts.get(i).withdraw(amount2);
						} else {
							throw new InsufficientFundException("Invalid withdrawal amount");
							// System.out.println("Transaction amount cannot be negative");
						}
						break;
					case 3:
						System.out.println("The available balance is: " + accounts.get(i).getBalance());
						break;
					}
				} else {
					System.out.println("Account number not found");
				}
			}
		}
	}

	/**
	 * this is credit card application method prompt the user to choose between mc
	 * and visa and create the object with pattern number the boolean will be
	 * switched to false if a card is created. if statement to decide the account
	 * numbers, if arraylist.size = 0, then tell the user to create account first
	 * 
	 * @param input take the user input
	 */
	public void cCardApp(Scanner input) {
		if (accounts.size() == 0) {
			System.out.println("Create account first");
		} else {
			System.out.println("Enter account number");
			int accountNumber = input.nextInt();
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getAccNum() == accountNumber) {
					System.out.println("Found it!\n" + "(Ignore the error messages)");
					System.out.println("1 MasterCard");
					System.out.println("2 Visa");
					int menuOp = input.nextInt();
					if (menuOp == 1) {
						MasterCard mCard = new MasterCard();
						accounts.get(i).setCc(mCard);
						// my solution which is not allowed in this lab(why we have only one method in
						// interface)
						// accounts.get(i).getCc().cardNum();
						noCard = false;
						this.printTitle();
						System.out.println(accounts.get(i).toString() + accounts.get(i).getCc().CreditNum());
					}
					if (menuOp == 2) {
						Visa vCard = new Visa();
						accounts.get(i).setCc(vCard);
						// accounts.get(i).getCc().cardNum();
						noCard = false;
						this.printTitle();
						System.out.println(accounts.get(i).toString() + accounts.get(i).getCc().CreditNum());
					}
				} else {
					System.out.println("Account not found");
				}
			}
		}
	}

	/**
	 * method to print stars
	 */
	public void printStars() {
		System.out.println(
				"***********************************************************************************************************************************************************");
	}

	/**
	 * print bank name to uppercase
	 */
	public void printBankName() {
		this.printStars();
		System.out.println("          " + this.bankName.toUpperCase() + " BANK");// While printing the title, see that
		// it is printed in uppercase
	}

	/**
	 * print title has a boolean to tell when to print credit card title
	 */
	public void printTitle() {
		this.printStars();
		if (noCard) {
			System.out.printf(" %20s | %20s | %20s | %20s | %20s |%n", "Acc Number", "Name", "Email", "Phone",
					"Balance");
		} else {
			System.out.printf(" %20s | %20s | %20s | %20s | %20s | %30s |%n", "Acc Number", "Name", "Email", "Phone",
					"Balance", "Credit Card");
		}
		this.printStars();
	}

	/**
	 * print the accounts attributes has a boolean to tell when to print the credit
	 * card number
	 */
	public void printInfo() {
		for (int i = 0; i < accounts.size(); i++) {
			if (noCard) {
				System.out.println(accounts.get(i).toString());
			} else {
				System.out.println(accounts.get(i).toString() + accounts.get(i).getCc().CreditNum());
			}

		}
	}

	/**
	 * this method prints all the things including bank name, the title and account
	 * attributes by calling each method if statement to decide the account numbers,
	 * if arraylist.size = 0, then tell the user to create account first
	 */
	public void printAll() {
		if (this.getAccounts().size() == 0) {
			System.out.println("Create account first");
		} else {
			// should be in only one method
			this.printBankName();
			this.printTitle();
			this.printInfo();
		}

	}
}
