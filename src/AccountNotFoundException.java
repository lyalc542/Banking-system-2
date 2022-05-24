/**
 * All custom exception classes should have Exception as their parent. They all
 * need to only have their respective constructor that takes a String message.
 * 
 * @author LC PC
 *
 */
public class AccountNotFoundException extends Exception {

	AccountNotFoundException(String message) {
		super(message);
	}

}
