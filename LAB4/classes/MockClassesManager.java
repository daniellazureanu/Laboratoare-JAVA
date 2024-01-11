package classes;

import java.util.ArrayList;
import java.util.List;

public class MockClassesManager implements ManagerCourseOperations{
	public List<Course> courses;

	public MockClassesManager(){
		this.courses = generateCourses();
	}

	@Override
	public void addCourse(Course course){
		courses.add(course);
	}

	@Override
	public void updateCourse(Course course){
		int indexToUpdate = courses.indexOf(course);
        if (indexToUpdate != -1) {
            courses.set(indexToUpdate, course);
        }
	}

	@Override
	public void deleteCourse(Course course){
		courses.remove(course);
	}

	public List<Course> getCourses() {
        return courses;
    }

	public ArrayList<Course> generateCourses(){
		ArrayList<Course> courses = new ArrayList<>();

		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Andrei", "Negoita", 2231, 6));
		students.add(new Student("Ion", "Mateescu", 4221, 6));

		Professor prof = new Professor("Anton", "Panaitescu");

		courses.add(new Course("Material Resistance", "Calculations of Reactions, \n" + "effort diagrams, calculations of geometric characteristics of\n" + "flat surfaces and calculations of resistance elements to simple stresses", prof, students));
		return courses;
	}
}	