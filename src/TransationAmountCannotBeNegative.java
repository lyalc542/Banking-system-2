/**
 * All custom exception classes should have Exception as their parent. They all
 * need to only have their respective constructor that takes a String message.
 * 
 * @author LC PC
 *
 */
public class TransationAmountCannotBeNegative extends Exception {

	TransationAmountCannotBeNegative(String message) {
		super(message);
	}
}
