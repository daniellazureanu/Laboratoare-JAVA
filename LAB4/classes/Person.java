package classes;

public abstract class Person {
	String name;
	String surname;

	public Person(){
		this.name = "";
		this.surname = "";
	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + ", surname=" + surname + '}';
	}
}