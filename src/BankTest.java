import java.util.Scanner;

/**
 * This is the driver class (test class), which means this class has the main
 * method. display the menu
 * 
 * @author LC PC
 */
public class BankTest {
	/**
	 * main method This method read the name of the bank (example: “Spectrum”) A
	 * Bank object will be created with the name provided Displays all the menus and
	 * submenus listed in the sample output below Handles most of Controller part of
	 * the MVC design pattern but shares some as well with Bank class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name of bank: ");
		String bankName = input.nextLine();
		Bank bank = new Bank(bankName);// A Bank object will be created with the name
		int n = 0;
		do {
			try {
				System.out.println("1. Create Account\r\n" + "2. Transactions\r\n" + "3. Print all Accounts\r\n"
						+ "4. Apply for Credit Card\r\n" + "5. Exit");
				n = input.nextInt();
				input.nextLine();
				switch (n) {
				case 1:// Create Account
					bank.readInfo(input);
					break;
				case 2:// Transactions
					try {
						bank.Transactions(input);
					} catch (AccountNotFoundException ae) {
						System.out.println(ae.getMessage());
					} catch (TransationAmountCannotBeNegative te) {
						System.out.println(te.getMessage());
					} catch (InsufficientFundException ie) {
						System.out.println(ie.getMessage());
					} catch (Exception e) {
						System.out.println("Enter a number");
					}
					break;
				case 3:// Print all Accounts
					bank.printAll();
					break;
				case 4:// Apply for Credit Card
					try {
						bank.cCardApp(input);
					} catch (Exception e) {
						System.out.println("Enter a number");
					}
					break;
				case 5:// Exit
					System.out.println("Good bye\r\n" + "Program by Chang Liu");
					//default
				}
			} catch (Exception e) {
				System.out.println("Invalid menu option. Try again...");
				input.nextLine();
			}
		} while (n != 5);

	}
}
