package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseManager{
	Course[] courses;

	public CourseManager(){
		Connection conn = null;
		courses = new Course[0];
	}

	public void addCourse(Course course){
		int newLength = courses.length + 1;
		Course[] aux = new Course[newLength];
		int index = 0;

		for(Course c : courses){
			aux[index++]=c;
		}
		aux[index] = course;
		this.courses = new Course[newLength];
		System.arraycopy(aux, 0, courses, 0, newLength);
	}

	public void updateCourse(Course course){
		int indexToUpdate = -69;
		for(int i = 0; i < courses.length; i++){
			if(courses[i].equals(course)){
				indexToUpdate = i;
				break;
			}

		}

		if (indexToUpdate != -69) {
            courses[indexToUpdate] = course;
        }
	}

	public void removeCourse(Course course){
		int indexOfCourseToRemove = -69;
		for(int i=0; i < courses.length; i++){
			if(courses[i].equals(course)){
				indexOfCourseToRemove = i;
				break;
			}
		}

		if(indexOfCourseToRemove != -69){
            Course[] newCourseArray = new Course[courses.length - 1];
            System.arraycopy(courses, 0, newCourseArray, 0, indexOfCourseToRemove);
            System.arraycopy(courses, indexOfCourseToRemove + 1, newCourseArray, indexOfCourseToRemove, courses.length - indexOfCourseToRemove - 1);
            courses = newCourseArray;
		}
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
	            Student[] studentsInCourse = course.students;

	            if (studentsInCourse.length == 0) {
	                System.out.println("Nu exista nici un student in cursul " + course.name);
	            }
	            int totalGrade = 0;

	            for (Student student : studentsInCourse) {
	                totalGrade += student.grade;
	            }
	            System.out.println("Media cursului " + course.name + " este: " + (double) totalGrade / studentsInCourse.length);
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
	            Student[] studentsInCourse = course.students;
	            totalStudents += studentsInCourse.length;

	            for (Student student : studentsInCourse) {
	                totalGrade += student.grade;
	            }
	        }
	    }

	    System.out.println("Media tuturor cursurilor ale profesorului " + professor.getFullName() + " este: " + (double) totalGrade / totalStudents);
	}
}