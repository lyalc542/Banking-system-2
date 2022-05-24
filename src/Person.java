/**
 * Person class with personal attributes parameterized constructor, no non-ar
 * constructor
 * 
 * @author LC PC
 *
 */
public class Person {
	// personal attributes
	private String firstName;
	private String lastName;
	private String email;
	private long phone;

	/**
	 * parameterized constructor
	 * 
	 * a Person cannot exist at any time without its attributes
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 */
	Person(String firstName, String lastName, String email, long phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	// getters and setters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getPhone() {
		return phone;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	/**
	 * override toStrinf method to print the personal attributes
	 */
	public String toString() {
		return String.format("%20s | %20s | %20d |", firstName + " " + lastName, email, phone);
	}

}
