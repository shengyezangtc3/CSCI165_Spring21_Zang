/**
* Class to encapsulate a Faculty member
*
* @version  1.0 Beta
* @author   Ken Whitener
* @since    3/23/2021
*/
public class Faculty {

    public static String[] departments = {"Computer Science", "Math", "Humanities",
                                          "Basket Weaving", "Sports"};
    private String name;
    private String department;
    private String title;
    private String email;

    /**
     * creates a faculty object with all default values
     */
    public Faculty(){}

    /**
     * Creates a faculty object with the following parameters
     * @param name
     * @param department
     * @param title
     * @param email
     */
    public Faculty(String name, String department, String title, String email) {
        this.name       = name;
        this.department = department;
        this.title      = title;
        this.email      = email;
    }

    /**
     * Creates a faculty object with the following parameters
     * @param name
     * @param department
     * @param title
     */
    public Faculty(String name, String department, String title) {
        this.name       = name;
        this.department = department;
        this.title      = title;
    }

    /**
     * Creates a faculty object with the following parameters
     * @param name
     * @param department
     */
    public Faculty(String name, String department) {
        this.name       = name;
        this.department = department;
    }

    public Faculty(Faculty toClone) {
        this.name = toClone.name;
        this.department = toClone.department;
        this.title = toClone.title;
        this.email = toClone.email;
    }

    /**
     * Returns the faculty member's name
     * @return name: String
     */
    public String getName() {
        return name;
    }

    /**
     * Changes a faculty member's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the faculty member's department
     * @return department: String
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Changes a faculty member's department
     * Validated against the available departments
     * @param department
     */
    public void setDepartment(String department) {
        for(String dept : departments)
            if(dept.equalsIgnoreCase(department))
                this.department = department;
    }

    /**
     * Returns a facult member's title
     * @return tttle: String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Changes a faculty member's title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns a faculty member's email address
     * @return email: String
     */
    public String getEmail() {
        return email;
    }

    /**
     * changes a faculty members email address
     * not validated at the moment
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return title + " " + name + ": " + department + ", email: " + email;
    }

    public boolean equals(Faculty other) {
        if (this == other)        return true;
        if (other == null)        return false;
    
        if (department == null) {
            if (other.department != null)
                return false;
        } else if (!department.equals(other.department))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }  
}
