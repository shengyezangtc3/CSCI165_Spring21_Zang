/**
* Class to encapsulate a Student object
*
* @version  1.0 Beta
* @author   Ken Whitener
* @since    3/17/2021
*/
public class Student{

    /**
     * enumeration used to enforce a Students class level
     */
    public static enum CLASS_LEVEL { 
        /**
         * Freshman
         */
        FR, 
        /**
         * Sophmore
         */
        SO, 
        /**
         * Junior
         */
        JR, 
        /**
         * Senior
         */
        SR
    }; 

    /**
     * array used to enforce a Student's grade point validation
     * includes upper and lower values of range
     */
    public static final double[] GPA_LIMITS = {0.0, 4.0};   
    private static final int LOWER = 0;                     // symbolic constant to use for GPA validation
    private static final int UPPER = 1;                     // symbolic constant to use for GPA validation

    // instance variables with default values
    private String name         = null; 
    private String major        = null;   
    private CLASS_LEVEL year    = CLASS_LEVEL.FR;
    private Date dateEnrolled   = null;
    private Date expectedGrad   = null;
    private String id           = null;
    private double gpa          = 0.0;   
    private Faculty advisor     = null;

    // constructors

    /**
     * Creates a Student with deafult values of 
     * Name     => null, 
     * year     => Freshman, 
     * id       => null, 
     * gpa      => 0.0,
     * advisor  => null 
     */
    public Student(){}                  // no argument constructor

    /** 
     * Creates a Student with the specified name, major and date of enrollment.
     * @param name   The student's name: String
     * @param major  The student's major
     * @param dateEnrolled The date of student enrollment
     */
    public Student(String name, String major, Date dateEnrolled){
        this.name   = name;
        this.major  = major;
        if(dateEnrolled != null){
            this.setDateEnrolled(dateEnrolled);                 // set date enrolled
            Date grad = new Date(dateEnrolled);                 // clone date enrolled
            int gradYear = this.dateEnrolled.getYear() + 4;     // add 4 to the year for graduation
            grad.setYear(gradYear);                             // set the year
            this.setExpectedGrad(grad);                         // set expected graduation
        } 
    }

    /** 
     * Creates an Student with the specified name.
     * @param name   The student's name: String
     * @param major  The student's major
     */
    public Student(String name, String major){
        this.name   = name;
        this.major  = major;
    }

    /** 
     * Creates an Student with the specified name.
     * @param name   The student's name: String
     * @param major  The student's major
     * @param advisor The student's advisor  
     */
    public Student(String name, String major, Faculty advisor){
        this.name   = name;
        this.major  = major;
        this.setAdvisor(advisor);
    }

    /** 
     * Creates an Student with the specified name, year, id and gpa.
     * @param name  The student's name: String
     * @param year  The student's year: CLASS_LEVEL enum
     * @param id    The student's ID: String
     * @param gpa   The student's grade point average: double
    */
    public Student(String name, CLASS_LEVEL year, String id, double gpa, Faculty advisor){
        this.name = name;
        this.year = year;
        setId(id);
        setGPA(gpa);
        setAdvisor(advisor);
    }

    // instance methods
    
    /** 
     * Changes a students name
     * @param name  The new name: String
    */  
    public void setName(String name){
        this.name = name;
    }

    /** 
     * Returns a students name
     * @return name  
    */  
    public String getName(){
        return this.name;
    }

    /** 
     * Returns a students year in school
     * @return year  
    */ 
    public CLASS_LEVEL getYear() {
        return year;
    }

    /** 
     * Changes a students year
     * domain validation is enforced by the enum.
     * the compiler will only allow enum values
     * @param year  The new year: CLASS_LEVEL enum
    */
    public void setYear(CLASS_LEVEL year) {
        this.year = year;
    }

    /** 
     * Returns a students id number
     * @return id
    */ 
    public String getId() {
        return id;
    }

     /** 
     * Changes a students id
     * Access to this could be turned off if needed
     * domain validation should be added
     * @param id  The new id: String
    */  
    public void setId(String id) {
        this.id = id;
    }

    /** 
     * Returns a students grade point average
     * @return gpa
    */ 
    public double getGPA(){
        return this.gpa;
    }

    /** 
     * Changes a students gpa
     * argument validated against GPA_LIMITS
     * @param gpa  The new grade point average: double
    */  
    public void setGPA(double gpa){
        // use domain structures to validate range
        if(gpa >= GPA_LIMITS[LOWER] && gpa <= GPA_LIMITS[UPPER])
            this.gpa = gpa;
    }

    /** 
     * Returns a students advisor
     * @return advisor
    */ 
    public Faculty getAdvisor() {
        return new Faculty(advisor);
    }

    /** 
     * Changes a students advisor
     * argument validated against student major and advisor dept
     * advisor must be in same department as student's major
     * @param advisor  The new advisor: Faculty
    */ 
    public void setAdvisor(Faculty advisor) {
        if(this.major.equalsIgnoreCase(advisor.getDepartment()))
            this.advisor = new Faculty(advisor);
    }

    /** 
     * gets a students graduation Date
     * @return expectedGrad  The date of expected graduation: Date
     **/ 
    public Date getExpectedGrad() {
        return new Date(expectedGrad);
    }

   /** 
     * Changes a students graduation date
     * argument validated against the date of enrollment
     * must be after date of enrollment
     * @param expectedGrad  The new graduation date: Date
    */
    public void setExpectedGrad(Date expectedGrad) {
        if (this.dateEnrolled != null && expectedGrad != null && expectedGrad.compareTo(this.dateEnrolled) > 0)
            this.expectedGrad = new Date(expectedGrad);
    }

    /** 
     * gets a students Date of enrollment
     * @return dateEnrolled  The date of the Student's enrollment: Date
     **/ 
    public Date getDateEnrolled() {
        return new Date(dateEnrolled);
    }

    /** 
     * Changes a students date of enrollment
     * probably should be validated: TBD
     * @param dateEnrolled  The new enrollment date: Date
    */
    public void setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = new Date(dateEnrolled);
    }

    // expected methods

    /** 
     * Returns a nicely formatted String of the object's state
     * @return String
    */ 
    public String toString() {
        return  "Name:\t"       + name  +
                "\nMajor:\t"    + major +
                "\nID:\t"       + id    +
                "\nYear:\t"     + year  +
                "\nGPA:\t"      + gpa   +
                "\nStart:\t"    + dateEnrolled  +
                "\nEnd:\t"      + expectedGrad  +
                "\nAdvisor:\t"  + advisor;
    }

    /** 
     * Defines a deep comparison between two objects
     * NOT COMPLETE at the moment
     * @return  true if objects are equal, false otherwise
     * @param   otherStudent: The student to compare agains this student
    */ 
    public boolean equals(Student otherStudent) {   // define the deep comparison
        // get out quick if we can
        if (this == otherStudent) return true;      // identity check, literally the same student
       
        // check IDs, careful with NULL POINTERS!!
        if (this.id == null) {                      // NULL POINTER CHECKS!!
            if (otherStudent.id != null)
                return false;
        } else if (!this.id.equals(otherStudent.id)) // they both aren't NULL. OK to call .equals()
            return false;
        if (this.year != otherStudent.year)          // year is primitive, use ==
            return false;
        if (this.gpa != otherStudent.gpa)            // GPA is primitive, use ==
            return false;  

        return true;                                 // passed every test. MUST be equal
    }
}
