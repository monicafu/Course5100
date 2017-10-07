package INFO5100.Assignment4;

import java.util.*;
public class Course {
	private String courseName;
	private int numberOfStudent;
	private static int MAX_NUMBER_REGISTE= 10;
	private Student[] registeredStu = new Student[MAX_NUMBER_REGISTE];//store registered student
	
	public Course(String courseName){
		this.courseName=courseName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	} 
	
	
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}
	//return the array of registered students
	protected Student[] getStudent() {
		return registeredStu;
		
	}
	//return true if the course is full
	protected boolean isFull() {
		if(this.numberOfStudent >= MAX_NUMBER_REGISTE)
			return true;
		else 
			return false;
		
	}
	
	//if the course is not full, register a student in course.
	protected boolean registerStudent(Student student){
		if(isFull()) 
			System.out.println("The register Student is full, can't register.");  
		else {
			for(int i = 0; i< registeredStu.length;i++ ) {
				if ( registeredStu[i] !=null && registeredStu[i].getStudentId() == student.getStudentId() ) {
					System.out.println(student.getStudentName()+" :is already registed "+getCourseName()); 
					return false;
				}
			}
			registeredStu[numberOfStudent] = student;
			numberOfStudent++;
			System.out.println(student.getStudentName()+" :is successfully registed "+getCourseName()); 
			return true;
		}
		return false;
	}
	
	
	
	

}
