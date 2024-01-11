package classes;

import java.util.ArrayList;

public class Course implements CourseOperations{
	String name;
	String description;
	Professor teacher;
	ArrayList<Student> students;

	public Course(){
		this.name = "";
		this.description = "";
		this.teacher = new Professor();
		this.students = new ArrayList<>();
	}

	public Course(String name, String description, Professor teacher, ArrayList<Student> students){
		this.name = name;
		this.description = description;
		this.teacher = teacher;
		this.students = new ArrayList<>(students);
	}

	public void updateProfessor(Professor teacher){
		this.teacher = teacher;
	}

	public void addStudent(Student student){
		students.add(student);
	}

	public void removeStudent(Student student){
		students.remove(student);
	}

    public void updateStudent(Student student) {
        for (Student existingStudent : students) {
            if (existingStudent.equals(student)) {
                existingStudent.setFirstName(student.getFirstName());
                existingStudent.setLastName(student.getLastName());
                existingStudent.setGroupNumber(student.getGroupNumber());
                existingStudent.setGrade(student.getGrade());
                break;
            }
        }
    }


	public void updateCourse(String name, String description) {
        this.name = name;
        this.description = description;
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