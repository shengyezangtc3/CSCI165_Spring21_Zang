public class Person{

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(){}

    public Person(String firstName, String lastName) {
        this.firstName  = firstName;
        this.lastName   = lastName;
    }

    public Person(String firstName, String lastName, String phoneNumber) {
        this(firstName, lastName);
        this.setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        String area     = phoneNumber.substring(0, 3);
        String prefix   = phoneNumber.substring(3, 6);
        String route    = phoneNumber.substring(6);
        return "(" + area + ") " + prefix + "-" + route;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() != 10) return;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  "Name: " + firstName + " " + lastName + "\n" +
                "Phone: " + getPhoneNumber();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;
        if (obj == null)    return false;
        if (getClass() != obj.getClass())   return false;

        Person other = (Person) obj;
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
        return true;
    } 
}