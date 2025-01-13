package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int s_id;
	private String S_name;
	@OneToOne
	private Laptop laptop;
	public Student(int s_id, String s_name, Laptop laptop) {
		super();
		this.s_id = s_id;
		S_name = s_name;
		this.laptop = laptop;
	}
	public Student() {
		
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", S_name=" + S_name + ", laptop=" + laptop + "]";
	}
	
	
	
	
	
}
