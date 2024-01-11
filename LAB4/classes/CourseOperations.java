package classes;

public interface CourseOperations {
	public void updateProfessor(Professor teacher);
	public void addStudent(Student student);
	public void removeStudent(Student student);
	public void updateStudent(Student student);
	public void updateCourse(String name, String description);
}