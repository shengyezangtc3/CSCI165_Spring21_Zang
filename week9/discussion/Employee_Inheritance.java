public class Employee_Inheritance extends Person{
    private String employeeID;

    //Constructors
    public Employee_Inheritance() {}
    
    public Employee_Inheritance(String firstName, String lastName, String phoneNumber, String employeeID) {
        super(firstName, lastName, phoneNumber);
        this.employeeID = employeeID;
    }

    /*
    public Employee_Inheritance(Employee_Inheritance toClone) {
        super(toClone.getFirstName(), toClone.getLastName(), toClone.getPhoneNumber());
        this.employeeID = toClone.employeeID;
    }
    */

    // getters and setters
    public String getFirstName() {
        return super.getFirstName();
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getLastName() {
        return super.getLastName();
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    // other behaviors
    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;
        if (obj == null)    return false;
        if (getClass() != obj.getClass())    return false;

        Employee_Inheritance otherEmployee = (Employee_Inheritance) obj;
        if (super.equals(obj)) {
            if (employeeID == null) {
                if(otherEmployee.employeeID != null)    
                    return false;
            } else if (!employeeID.equals(otherEmployee.employeeID)) 
                return false;
            return true;
        }
        return false;
    }

    public String toString() {
        return super.toString() + "\nEmployee ID: " + employeeID;
    }
}
