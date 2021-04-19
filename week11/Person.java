public class Person{

    private String 	firstName;
    private String 	lastName;
    private String 	phoneNumber;
	private Date	DOB;

    public Person(){}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 */
    public Person(String firstName, String lastName) {
        this.firstName  = firstName;
        this.lastName   = lastName;
    }

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
    public Person(String firstName, String lastName, String phoneNumber) {
        this(firstName, lastName);
        this.setPhoneNumber(phoneNumber);
    }

	public Person(String firstName, String lastName, String phoneNumber, Date DOB) {
        this(firstName, lastName);
        this.setPhoneNumber(phoneNumber);
		this.setDOB(DOB);
    }

	/**
	 * Copy Constructor
	 * @param toCopy Person object to copy
	 */
	public Person(Person toCopy){
		this(toCopy.firstName, toCopy.lastName, toCopy.phoneNumber, toCopy.DOB);
	}

	/**
	 * 
	 * @param DOB
	 */
	public void setDOB(Date DOB){
		this.DOB = new Date(DOB);
	}

	/**
	 * 
	 * @return The Person's Date of Birth
	 */
	public Date getDOB(){
		return new Date(this.DOB);
	}

	/**
	 * 
	 * @return Person's first name
	 */
    public String getFirstName() {
        return firstName;
    }

	/**
	 * 
	 * @param firstName
	 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	/**
	 * 
	 * @return Person's last name
	 */
    public String getLastName() {
        return lastName;
    }

	/**
	 * 
	 * @param lastName
	 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	/**
	 * 
	 * @return Person's full name
	 */
	public String getName(){
		return this.firstName + " " + this.lastName;
	}

	/**
	 * 
	 * @return Person's formatted phone number
	 */
    public String getPhoneNumber() {
        String area     = phoneNumber.substring(0, 3);
        String prefix   = phoneNumber.substring(3, 6);
        String route    = phoneNumber.substring(6);
        return "(" + area + ")" + prefix + "-" + route;
    }

	/**
	 * 
	 * @param phoneNumber
	 */
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 10)
        	this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  "Name: " 	+ firstName + " " + lastName + "\n" +
                "Phone: " 	+ getPhoneNumber() + "\n" +
				"DOB: " 	+  DOB;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;					// identity check
        if (obj == null)    return false;					// null check
        if (getClass() != obj.getClass())   return false;	// origin check

        Person other = (Person) obj;						// down cast

		// check each field, be mindful of null pointers
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;

        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;

        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;

		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;

        return true;
    }
}