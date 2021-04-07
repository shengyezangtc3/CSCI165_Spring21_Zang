public class Driver{
    public static void main(String[] args) {
        // Composition
        Employee_Composition employee1 = new Employee_Composition("Frank", "Stein", "5182548661", "000001");
        Employee_Composition employee2 = new Employee_Composition("Frank", "Stein", "5182548661", "000001");
        System.out.println(employee1.getFirstName());
        System.out.println(employee1.getLastName());
        System.out.println(employee1.getPhoneNumber());
        System.out.println(employee1.getEmployeeID());
        System.out.println(employee1.toString());
        System.out.println(employee1.equals(employee2));
        employee1.setFirstName("Tom");
        employee1.setLastName("Ford");
        employee1.setPhoneNumber("8776936228");
        employee1.setEmployeeID("000002");
        System.out.println(employee1.toString());
        System.out.println(employee1.equals(employee2));

        // Inheritance
        Employee_Inheritance employee3 = new Employee_Inheritance("Frank", "Stein", "5182548661", "000001");
        Employee_Inheritance employee4 = new Employee_Inheritance("Frank", "Stein", "5182548661", "000001");
        System.out.println(employee3.getFirstName());
        System.out.println(employee3.getLastName());
        System.out.println(employee3.getPhoneNumber());
        System.out.println(employee3.getEmployeeID());
        System.out.println(employee3.toString());
        System.out.println(employee3.equals(employee4));
        employee3.setFirstName("Tom");
        employee3.setLastName("Ford");
        employee3.setPhoneNumber("8776936228");
        employee3.setEmployeeID("000002");
        System.out.println(employee3.toString());
        System.out.println(employee3.equals(employee4));
    }
}