package classes;
public class Course{
	String name;
	String description;
	Professor teacher;
	Student[] students;

	public Course(String name, String description, Professor teacher, Student[] students){
		this.name = name;
		this.description = description;
		this.teacher = teacher;
		this.students = students;
	}

	public void updateProfessor(Professor teacher){
		this.teacher = teacher;
	}

	public void addStudent(Student student){
		int newLength = students.length + 1;
		Student[] aux = new Student[newLength];
		int index = 0;
		for(Student s : students){
			aux[index++] = s;
		}

		aux[index] = student;

		this.students = new Student[newLength];
		System.arraycopy(aux, 0, students, 0, newLength);
	}

	@Override
	public String toString(){
		String str = "Course:" + "name=" + name + ", description=" + description + ",\nTeacher=" + teacher + ".\nStudents:\n";
		for(Student s : students){
			str += s + "\n";
		}
		return str;
	}
}