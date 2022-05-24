/**
 * Visa class implements CreditCard interface this is to print the card number
 * the abstract method will be override in this class
 * 
 * @author LC PC
 *
 */
public class Visa implements CreditCard {
	private static int cardNum;
	private static int lastCardNum;

//	private String pattern = "4422123456781";
//	private String v = "";
//
//	public String cardNum() {
//		cardNum++;
//		v = "" + cardNum;
//		while (v.length() < 3) {
//			v = "0" + v;
//		}
//		return v;
//	}
	/**
	 * non-ar constructor add card number when creating a card object
	 */
	Visa() {
		cardNum = ++lastCardNum;
	}

	/**
	 * override the abstract method print the pattern add on 1 number when it's
	 * called
	 * 
	 * @return String.format
	 */
	@Override
	public String CreditNum() {
		String pattern = "4422123456781";
		String v = "";
		v = "" + cardNum;
		while (v.length() < 3) {
			v = "0" + v;
		}
		return String.format(" %30s |", pattern + v + "(V)");
	}

}
