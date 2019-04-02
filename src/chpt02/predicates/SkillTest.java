package chpt02.predicates;

import java.util.function.Predicate;

public class SkillTest {

	public static void main(String[] args) {
		Student paul = new Student(11, "Paul");
		Student terry = new Student(31, "Terry");
		Student ron = new Student(99, "Ron");
				
		SetupStudent.setup(paul);
		SetupStudent.setup(terry);
		SetupStudent.setup(ron);
		
		print(paul, test -> test.hasSkill());
		print(terry, test -> test.hasSkill());
		print(ron, test -> test.hasSkill());
	}
	
	private static void print(Student student, Predicate<Student> skill) {
		if (skill.test(student)) {
			System.out.println(student.getName());
		}
			
		
	}
	
}
