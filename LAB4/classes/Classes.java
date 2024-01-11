package classes;

import java.util.ArrayList;

public class Classes{
	public static void main(String[] args){
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Course> courses = new ArrayList<>();
		students.add(new Student("Andrei", "Negoita", 2231, 6));
		students.add(new Student("Ion", "Mateescu", 4221, 6));
		Student dani = new Student("Daniel", "Lazureanu", 2231, 7);
		Professor prof = new Professor("Anton", "Panaitescu");

		Course course = new Course("Material Resistance", "Calculations of Reactions, \n" + "effort diagrams, calculations of geometric characteristics of\n" + "flat surfaces and calculations of resistance elements to simple stresses", prof, students);
		course.addStudent(dani);
		
		CourseManager courseManager = new CourseManager();
		courseManager.addCourse(course);
		courseManager.displayCoursesToConsole();
		courseManager.listStudentsInCourse("Material Resistance");
		courseManager.calculateAverageGradeForCourse("Material Resistance");
		courseManager.calculateAverageGradeByProfessor(prof);
	}
}