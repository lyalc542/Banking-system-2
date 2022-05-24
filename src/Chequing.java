/**
 * This is a specific type of account that has a specific fee of $1.5 for every
 * transaction This class takes care of the withdrawal and deposit process
 * 
 * @author LC PC
 *
 */
public class Chequing extends Account {
	private final double FEE = 1.5;// constant transaction fee

	/**
	 * parameterized constructor
	 * 
	 * @param accHolder
	 */
	Chequing(Person accHolder) {
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
