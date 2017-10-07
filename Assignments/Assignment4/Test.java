package INFO5100.Assignment4;

public class Test {

	public static void main(String[] args) {
		
		Student a = new Student("AA",10001);
		Student b = new Student("BB",10002);
		Student c = new Student("CC",10003);
		Student d = new Student("DD",10004);
		Student e = new Student("EE",10005);
		Student f = new Student("FF",10006);
		Student g = new Student("GG",10007);
		Student h = new Student("HH",10008);
		Student i = new Student("II",10009);	
		Student j = new Student("JJ",10010);
		Course course = new Course("Java");
		course.setNumberOfStudent(0);
		//9 student register course Java
		course.registerStudent(a);
		course.registerStudent(b);
		course.registerStudent(c);
		course.registerStudent(d);
		course.registerStudent(e);
		course.registerStudent(f);
		course.registerStudent(g);
		course.registerStudent(h);
		course.registerStudent(i);
		//course.registerStudent(j);
		//monica want to register, when course is full 
		Student monica = new Student("Monica",10011);
		course.registerStudent(monica);

		// when JJ duplicate register "JAVA"
		course.registerStudent(j);
		
	}

}
