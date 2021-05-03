public class Student extends Person implements Comparable<Student>{

    public static enum CLASS_LEVEL {FR, SO, JR, SR};

    private CLASS_LEVEL level;
    private String id;
	private double gpa;

    public Student(String fName, String lName, Date dob, String id, Student.CLASS_LEVEL level, double gpa) {
		super(fName, lName, dob);
		this.level = level;
		this.id = id;
		this.gpa = gpa;
	}

    public Student(Student toCopy) {
        this(toCopy.getName().split(" ")[0], toCopy.getName().split(" ")[1], toCopy.getBirthDate(), toCopy.getId(), toCopy.getLevel(), toCopy.getGpa());
    }

	public CLASS_LEVEL getLevel() {
        return level;
    }

    public void setLevel(CLASS_LEVEL level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

    @Override
    public int compareTo(Student other) {
        if(getLevel() == other.getLevel()) return 0;
        if(getLevel() == CLASS_LEVEL.FR) return -1;
        if(getLevel() == CLASS_LEVEL.SO && other.getLevel() == CLASS_LEVEL.FR) return 1;
        if(getLevel() == CLASS_LEVEL.SO) return -1;
        if(getLevel() == CLASS_LEVEL.JR && other.getLevel() == CLASS_LEVEL.SR) return -1;
        if(getLevel() == CLASS_LEVEL.JR) return 1;
        return 1;
    }

	@Override
    public String toString() {
        return  super.toString()    +
                "\nID: " + id       +
                "\nYear: " + level	+
				"\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)        return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass())   return false;
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (level != other.level)
            return false;
        return true;
    }
}
