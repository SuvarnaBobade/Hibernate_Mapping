package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="students_info")
public class Student {

	@Id
	private int s_id;
	private String name;
	@ManyToMany(mappedBy = "student")
	private List<Courses> cour;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Courses> getCour() {
		return cour;
	}

	public void setCour(List<Courses> cour) {
		this.cour = cour;
	}

	public Student() {

	}

	public Student(int s_id, String name, List<Courses> cour) {
		super();
		this.s_id = s_id;
		this.name = name;
		this.cour = cour;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", name=" + name + ", cour=" + cour + "]";
	}

}
