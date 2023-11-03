package classes;

public class Professor{
	String firstName;
	String lastName;

	@Override
	public String toString(){
		return "Professor{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
	}

	public Professor(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFullName(){
		return firstName + " " + lastName;
	}
}