/**
 * This is a specific type of account that has an auto incremented account
 * number for every Savings account created This class takes care of the
 * withdrawal and deposit process
 * 
 * @author LC PC
 *
 */
public class Saving extends Account {
	private final double FEE = 0.5;// final double transaction fee;

	/**
	 * cosntractor
	 * 
	 * @param accHolder
	 */
	Saving(Person accHolder) {
		super(accHolder);
	}

	/**
	 * this method overrides the abstract method calculate the transaction amount if
	 * the balance, at the time of the transaction, is greater than $3000 No
	 * transfer fee will be deducted
	 * 
	 * @return double
	 */
	@Override
	public double deposit(double input) {
		if (balance < 3000) {
			balance += input - FEE;
		} else {
			balance += input;
		}
		return balance;
	}

	/**
	 * this method override the abstract method calculate the transaction amount if
	 * the balance, at the time of the transaction, is greater than $3000 No
	 * transfer fee will be deducted
	 * 
	 * @return double
	 */
	@Override
	public double withdraw(double input) {
		if (balance < 3000) {
			balance -= input - FEE;
		} else {
			balance -= input;
		}
		return balance;
	}

}
