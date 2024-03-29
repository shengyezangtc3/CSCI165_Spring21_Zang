public class Employee extends Person {

    private Date    hireDate;
    private int     id;
    private String  department;

    // no argument
    public Employee() {}

    // overloaded constructor
	/**
	 * 
	 * @param p
	 * @param hired
	 * @param id
	 * @param dept
	 */
    public Employee(Person p, Date hired, int id, String dept) {
        super(p);           // call to super class copy constructor
        setHireDate(hired);
        setId(id);
        setDepartment(dept);
    }

    // copy constructor
	/**
	 * 
	 * @param toCopy
	 */
    public Employee(Employee toCopy){
        this(toCopy, toCopy.hireDate, toCopy.id, toCopy.department);
    }

	/**
	 * 
	 * @return the date the Employee was hired
	 */
    public Date getHireDate() {
        return new Date(hireDate);
    }

	/**
	 * 
	 * @param hireDate
	 */
    public void setHireDate(Date hireDate) {
        this.hireDate = new Date(hireDate);
    }

	/**
	 * 
	 * @return The Employee's ID number
	 */
    public int getId() {
        return id;
    }

	/**
	 * 
	 * @param id
	 */
    public void setId(int id) {
        this.id = id;
    }

	/**
	 * 
	 * @return The Employee's Department
	 */
    public String getDepartment() {
        return department;
    }

	/**
	 * 
	 * @param department
	 */
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHired: " + hireDate + "\nID: " + id + "\nDept: " + department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)                    return true;	// idenitity check
        if (obj == null)                    return false;	// null check
        if (getClass() != obj.getClass())   return false;	// origin check

        Employee other = (Employee) obj;					// downcast

		if (!super.equals(obj))             return false;	// super class check

        if (hireDate == null) {								// date hired
            if (other.hireDate != null)		return false;
        } else if (!hireDate.equals(other.hireDate))
            return false;

        if (id != other.id)					return false;	// id
           
        									return true;
    }
}
