package classes;

public class Student extends Person {
	int groupNumber;
	int grade;

	public Student(){
		super();
	}

	public Student(String firstName, String lastName, int groupNumber, int grade){
		super();
		this.name = firstName;
		this.surname = lastName;
		this.groupNumber = groupNumber;
		this.grade = grade;
	}

	@Override
	public String toString(){
		return "Student{" + "firstName=" + name + ", lastName=" + surname + ", groupNumber=" + groupNumber + '}';
	}

	public String getFirstName(){
		return name;
	}

	public void setFirstName(String firstName){
		this.name = firstName;
	}

	public String getLastName(){
		return surname;
	}

	public void setLastName(String lastName){
		this.surname = lastName;
	}

	public int getGroupNumber(){
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber){
		this.groupNumber = groupNumber;
	}

	public String getFullName(){
		return name + " " + surname;
	}

}