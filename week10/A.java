public class A extends Object{

    private String name;

    public A(String name){
        this.name = name;
    }

	public void setName(String name){
		this.name = name;
	}

    public String getName(){
        return name;
    }

    private void helper(){
        System.out.print("Do something helpful: ");
    }

    @Override
    public String toString(){
		helper();
        return "Class A --> Name is: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        // identity check. Are the references equal
        if (this == obj)                    return true;
        // null check. Is the parameter null?
        if (obj == null)                    return false;
        // origin check. Does obj share the same class as "this"
        if (getClass() != obj.getClass())   return false;

        // We know we have a "non null" instance of class A
        A other = (A) obj;                  // down cast Object to A

        // compare name fields. Avoid potential null pointer exception
        if (name == null) {                 // null checks on fields
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
} // end of A

class B extends A{

    private double weight;

    public B(String name, double weight){
        super(name);            // pass name to superclass A
        this.weight = weight;   // weight stays with "this"
    }

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

     @Override
    public String toString(){
        // call the super class toString, concatenate to "this" toString
        return super.toString() + " Class B --> weight is: " + weight;
    }
} // end of B

class C extends B{

    private String color;

    public C(String name, double weight, String color){
        super(name, weight);    // pass name and weight to superclass B
        this.color = color;     // color stays with "this"
    }

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
    @Override
    public String toString(){
        return super.toString() + " Class C --> color is: " + color;
	}
} // end of C


class InheritanceDriver{
    public static void main(String[] args){

		A[] arrayOfA 	= new A[10];						// array of super class type
		arrayOfA[0]		= new A("Thing One");				// instance of super class type
		arrayOfA[1]		= new B("Thing Two", 199);			// instance of sub class type
		arrayOfA[2]		= new C("Thing Three", 210, "Red"); // instance of sub class type

        C c = new C("warlock mini", 5, "Red");
        B b = new B("wizard mini", 3);
        A a = new A("halfling mini");

        System.out.println("Is C an instance of B? " +      (c instanceof B));
        System.out.println("Is C an instance of A? " +      (c instanceof A));
        System.out.println("Is C an instance of Object? " + (c instanceof Object));

        System.out.println("Was the B constructor called? " + (c.getClass() == b.getClass()));
        System.out.println("Was the A constructor called? " + (c.getClass() == a.getClass()));

        A[] array1 = new A[12];
        array1[0]		= new A("Thing One");				
		array1[1]		= new B("Thing Two", 199);			
		array1[2]		= new C("Thing Three", 210, "Red");
        array1[3]		= new A("Thing Four");				
		array1[4]		= new B("Thing Five", 199);			
		array1[5]		= new C("Thing Six", 210, "Red");
        array1[6]		= new A("Thing Seven");				
		array1[7]		= new B("Thing Eight", 199);			
		array1[8]		= new C("Thing Nine", 210, "Red");
        array1[9]		= new A("Thing Ten");				
		array1[10]		= new B("Thing Eleven", 199);			
		array1[11]		= new C("Thing Twelve", 210, "Red");

        for (A element: array1) {
            System.out.println("Is this an instance of A? " + (element instanceof A));
            System.out.println("Is this an instance of B? " + (element instanceof B));
            System.out.println("Is this an instance of C? " + (element instanceof C));
            System.out.println(element.getClass());
            System.out.println(element.toString());
        }
    }
}
