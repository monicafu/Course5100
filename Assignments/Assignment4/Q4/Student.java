package INFO5100.Assignment4;

public class Student {
	private String studentName;
	private int studentId;
	
	public Student() {
		super();
	}
	
	public Student(String name, int studentId) {
		this.studentName = name;
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}	
}
