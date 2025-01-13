package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Department dep = new Department();
		dep.setDep_name("java devloper");
		ss.persist(dep);

		Employee emp1 = new Employee();
		emp1.setEmp_name("raj");
		emp1.setDep(dep);
		ss.persist(emp1);

		Employee emp2 = new Employee();
		emp2.setEmp_name("rutuja");
		emp2.setDep(dep);
		ss.persist(emp2);

		Employee emp3 = new Employee();
		emp3.setEmp_name("prachi");
		emp3.setDep(dep);
		ss.persist(emp3);

		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		dep.setEmp(list);
		ss.persist(dep);
		tr.commit();
		ss.close();
	}
}
