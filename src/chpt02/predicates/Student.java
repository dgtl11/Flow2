package chpt02.predicates;

import java.util.ArrayList;

public class Student {

	private int id;
	private String name;
	private ArrayList<String> skills = new ArrayList<String>();
	
	public Student(int id, String name) {
		setId(id);
		setName(name);
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSkills() {
		return skills.toString();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSkill(String skill) {
		if (skills.isEmpty()) {
			this.skills.add(skill);
		}
		else if (skills.contains(skill)) {
			System.out.println("Skill schon vorhanden.");
		}
		else {
			this.skills.add(skill);
		}
	}
	
	public boolean hasSkill() {
		if (!this.skills.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
