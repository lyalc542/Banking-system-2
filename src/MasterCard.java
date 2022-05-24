/**
 * MasterCard class implements CreditCard interface this is to print the card
 * number the abstract method will be override in this class
 * 
 * @author LC PC
 *
 */
public class MasterCard implements CreditCard {
	private static int lastCardNum;
	private static int cardNum;

//	this is how i want to resolve the logic error.
//  However we have only one method allowed in the interface, this is logically right
//  but to be discussed with Prof. Howard
//	private String pattern = "5522123456781";
//	private String mc = "";
//
//	public String cardNum() {
//		cardNum++;
//		mc = "" + cardNum;
//		while (mc.length() < 3) {
//			mc = "0" + mc;
//		}
//		return mc;
//	}
	/**
	 * non-ar constructor add card number when creating a card object
	 */
	MasterCard() {
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
		String pattern = "5522123456781";
		String mc = "";
		mc = "" + cardNum;
		while (mc.length() < 3) {
			mc = "0" + mc;
		}

		return String.format(" %30s |", pattern + mc + "(MC)");
	}

}
