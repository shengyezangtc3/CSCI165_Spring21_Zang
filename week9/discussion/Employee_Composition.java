public class Employee_Composition {
    private Person person;
    private String employeeID;

    // Constructors
    public Employee_Composition(){}

    public Employee_Composition(String firstName, String lastName, String phoneNumber, String employeeID) {
        person = new Person(firstName, lastName, phoneNumber);
        this.employeeID = employeeID;
    }

    // I just realized that getPhoneNumber does not simply return the phone number as a string, so I can't use it as an argument.
    /*
    public Employee_Composition(Employee_Composition toClone) {
        person = new Person(toClone.person.getFirstName(), toClone.person.getLastName(), toClone.person.getPhoneNumber());
        this.employeeID = toClone.employeeID;
    }
    */

    // getters and setters
    public String getFirstName() {
        return person.getFirstName();
    }

    public void setFirstName(String firstName) {
        person.setFirstName(firstName);
    }

    public String getLastName() {
        return person.getLastName();
    }

    public void setLastName(String lastName) {
        person.setLastName(lastName);
    }

    public String getPhoneNumber() {
        return person.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        person.setPhoneNumber(phoneNumber);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    // other behaviors
    public boolean equals(Employee_Composition otherEmployee) {
        return person.equals(otherEmployee.person) && this.employeeID.equals(otherEmployee.employeeID);
    }

    public String toString() {
        return person.toString() + "\nEmployee ID: " + employeeID;
    }
}
