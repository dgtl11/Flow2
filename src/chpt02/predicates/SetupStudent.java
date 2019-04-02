package chpt02.predicates;

public class SetupStudent {

	public SetupStudent(Student student) {
		setup(student);
	}
	
	public static Student setup(Student student) {
		
		if (student.getName() == "Paul") {
			student.setSkill("IT-Basics");
			student.setSkill("Programming Basics");
			student.setSkill("Network Basics");	
		}
		
		else if (student.getName() == "Terry") {
			student.setSkill("IT-Basics");
			student.setSkill("Programming Basics");
			student.setSkill("Advanced Programming");
			student.setSkill("Database Basics");
		}
		
		else {
		
		}
		
		return student;
	}
}
