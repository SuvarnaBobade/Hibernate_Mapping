package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Courses;
import com.entity.Student;

public class MainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Courses.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Courses c = new Courses();
		c.setC_id(1);
		c.setC_name("fullstack java ");

		Courses c1 = new Courses();
		c1.setC_id(2);
		c1.setC_name("fullstack python ");

		Student s1 = new Student();
		s1.setName("ram");
		s1.setS_id(100);
		ss.persist(s1);

		Student s2 = new Student();
		s2.setName("sham");
		s2.setS_id(101);
		ss.persist(s2);

		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		c1.setStudent(list);
		c.setStudent(list);
		ss.persist(c1);
		ss.persist(c);
		
		List<Courses> list2 = new ArrayList<Courses>();
		list2.add(c);
		list2.add(c1);
		s1.setCour(list2);
		s2.setCour(list2);
		ss.persist(s1);
		ss.persist(s2);
		tr.commit();
		ss.close();
	}

}
