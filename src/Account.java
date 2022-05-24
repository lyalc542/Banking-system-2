/**
 * abstract class No more “no argument” constructor. methods as deposit,
 * withdraw, return an account number and a credit card, as well as adding a
 * credit card to an account object
 * 
 * @author LC PC
 *
 */
public abstract class Account {

	// instance variables to represent the account holder (Person object), the
	// balance, account number and a credit card reference
	private Person accHolder;
	protected double balance;
	private long accNum;
	protected CreditCard cc;
	private static long lastAccId;

	/**
	 * parameterized constructor to create the account holder no account will be
	 * created without an account holder a number count to assign different account
	 * number
	 * 
	 * @param accHolder
	 */
	Account(Person accHolder) {
		this.accHolder = accHolder;
		accNum = ++lastAccId; // return an account number
	}

	// getter and setter
	public Person getAccHolder() {
		return accHolder;
	}

	public double getBalance() {
		return balance;
	}

	public long getAccNum() {
		return accNum;
	}

	public CreditCard getCc() {
		return cc;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public void setCc(CreditCard cc) {
		this.cc = cc;
	}

	/**
	 * methods as deposit, withdraw override by subcalsses saving and chequing
	 * 
	 * @param input
	 * @return double type
	 */
	public abstract double deposit(double input);

	/**
	 * methods as deposit, withdraw override by subcalsses saving and chequing
	 * 
	 * @param input
	 * @return double type
	 */
	public abstract double withdraw(double input);

	/**
	 * display the details. override toString method
	 * 
	 * @return string type string.foramt
	 */
	@Override
	public String toString() {

		return String.format(" %20d | %20s %20.2f |", accNum, accHolder, balance);
	}

}
