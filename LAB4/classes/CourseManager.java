package classes;

import java.util.Set;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseManager{
	ArrayList<Course> courses;

	public CourseManager(){
		Connection conn = null;
		courses = new ArrayList<>();
	}

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(Course course) {
        int indexToUpdate = courses.indexOf(course);
        if (indexToUpdate != -1) {
            courses.set(indexToUpdate, course);
        }
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

	public void displayCoursesToConsole(){
		for(Course course: courses){
			System.out.println(course);
		}
	}

	public void enrollStudentInCourse(String courseName, Student student) {
	    for (Course course : courses) {
	        if (course.name.equals(courseName)) {
	        	course.addStudent(student);
	        	break;
	        }
	    }
	}

	public void listStudentsInCourse(String courseName) {
    	for (Course course : courses) {
      		if (course.name.equals(courseName)) {
      	  		System.out.println("Studentii din cursul " + course.name + " sunt:");

       	     	for(Student student : course.students){
       	     		System.out.println(student.getFullName());
       	     	}
       	    break;
       	  	}  	
       	  	else{
       	  		System.out.println("Nu exista nici un student in cursul " + course.name);
       	  	}
   		}
	}

	public void calculateAverageGradeForCourse(String courseName) {
	    for (Course course : courses) {
	        if (course.name.equals(courseName)) {
	            ArrayList<Student> studentsInCourse = course.students;

	            if (studentsInCourse.isEmpty()) {
	                System.out.println("Nu exista nici un student in cursul " + course.name);
	            }
	            int totalGrade = 0;

	            for (Student student : studentsInCourse) {
	                totalGrade += student.grade;
	            }
	            System.out.println("Media cursului " + course.name + " este: " + (double) totalGrade / studentsInCourse.size());
	        }
	        else{
	        	System.out.println("Cursul " + course.name + " nu exista");
	        }
	    }
	}

	public void calculateAverageGradeByProfessor(Professor professor) {
	    int totalGrade = 0;
	    int totalStudents = 0;

	    for (Course course : courses) {
	        if (course.teacher.equals(professor)) {
	            ArrayList<Student> studentsInCourse = course.students;
	            totalStudents += studentsInCourse.size();

	            for (Student student : studentsInCourse) {
	                totalGrade += student.grade;
	            }
	        }
	    }

	    System.out.println("Media tuturor cursurilor ale profesorului " + professor.getFullName() + " este: " + (double) totalGrade / totalStudents);
	}
}