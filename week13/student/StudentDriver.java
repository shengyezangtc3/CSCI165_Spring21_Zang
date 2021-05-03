import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class StudentDriver{

	// constants for indexing the split array
    final static int ID    = 0;
    final static int FIRST = 1;
    final static int LAST  = 2;
    final static int DOB   = 3;
    final static int CLASS = 4;
	final static int GPA   = 5;
    final static int MONTH = 0;
    final static int DAY   = 1;
    final static int YEAR  = 2;

    public static void main(String[] args){

        try{
            Student[] students 	= new Student[100];
            int index 			= 0;
            Scanner scanner 	= new Scanner(new File("MOCK_DATA.csv"));

            while(scanner.hasNext()){
                String line     = scanner.nextLine();								// read the line
                String[] tokens = line.split(",");									// split the line
                String[] date   = tokens[DOB].split("/");							// split the date

                Date dob      	= new Date(Integer.parseInt(date[MONTH]), 			// build Date instance
										   Integer.parseInt(date[DAY]), 
										   Integer.parseInt(date[YEAR]));

                Student s   	= new Student(tokens[FIRST], tokens[LAST], 			// build Student instance
											  dob, tokens[ID], 
								  			  Student.CLASS_LEVEL.valueOf(tokens[CLASS]), 
											  Double.parseDouble(tokens[5]));

                students[index++] = s;												// assign Student instance to array
            }

			// call the sort method. Sort only works on "Comparable" objects
            Arrays.sort(students);
           for(Student student : students)
				System.out.println(student);

        }catch(IOException ie){
            System.out.println("There was a problem with the file: " + ie.getMessage());
        }
    }
}

