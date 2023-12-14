package classes;
public class Course implements CourseOperations{
	String name;
	String description;
	Professor teacher;
	Student[] students;

	public Course(){
		this.name = "";
		this.description = "";
		this.teacher = new Professor();
		this.students = new Student[0];
	}

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

	public void removeStudent(Student student){
		int indexOfStudentToRemove = -69;
		for(int i = 0; i < students.length; i++){
			if(students[i].equals(student)){
				indexOfStudentToRemove = i;
				break;
			}
		}

		if(indexOfStudentToRemove!= -69){
			Student[] newStudentsArray = new Student[students.length - 1];
			System.arraycopy(students, 0, newStudentsArray, 0, indexOfStudentToRemove);
			System.arraycopy(students, indexOfStudentToRemove+1, newStudentsArray, indexOfStudentToRemove, students.length - indexOfStudentToRemove -1);
			students = newStudentsArray;
		}
	}

	public void updateStudent(Student student){
		int indexToUpdate = -69;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -69) {
            students[indexToUpdate] = student;
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