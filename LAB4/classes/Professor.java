package classes;

public class Professor extends Person {
	@Override
	public String toString(){
		return "Professor{" + "firstName=" + name + ", lastName=" + surname + '}';
	}

	public Professor(){
		super();
	}

	public Professor(String firstName, String lastName){
		super();
		this.name = firstName;
		this.surname = lastName;
	}

	public String getFullName(){
		return name + " " + surname;
	}
}