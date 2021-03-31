/**
 * Author: Shengye Zang 
 * Date: March 30, 2021 
 * Assignment: Week 8 Discussion
 */

public class PrivacyLeakDriver {
    public static void main(String[] args) {
        Date enrolled = new Date(1, 1, 2020);
        Student student1 = new Student("Frank", "Computer Science", enrolled);
        Date graduation = new Date(1, 1, 2024);
        student1.setExpectedGrad(graduation); // Since setExpectedGrad assigns the private field with the public input, the field can easily be
                                              // changed by changing the input object.
        graduation.setYear(2019); 
        Date grad = student1.getExpectedGrad(); // Since getExpectedGrad directly returns the reference to the private object, the field 
                                                      // could easily be changed by assigning a new variable with that Date object and use
                                                      // the setter methods of Date class.
        grad.setYear(2019);

        // getDateEnrolled and setDateEnrolled have the same problem as shown above
        student1.setDateEnrolled(enrolled);
        enrolled.setYear(2024);
        Date enrollment = student1.getDateEnrolled();
        enrollment.setYear(2024);
        
        // setAdvisor and getAdvisor suffer from the same problem
        
        Faculty advisor = new Faculty("Frank", "Computer Science", "Professor", "abc@def.com");
        student1.setAdvisor(advisor);
        System.out.println("Original Department: " + student1.getAdvisor().getDepartment());
        advisor.setDepartment("Math");
        Faculty advisor2 = student1.getAdvisor();
        advisor2.setDepartment("Math");
        System.out.println("Changed Department: " + student1.getAdvisor().getDepartment());
        
    }
}
