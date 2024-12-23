package com.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Employee e1=new Employee();
        Employee e2=new Employee();
        e1.setEid(34);
        e1.setName("Nicky");
        
        e2.setEid(38);
        e2.setName("Ajay");
        
        Projects p1=new Projects();
        Projects p2=new Projects();
        p1.setPid(1111);
        p1.setPname("Hibernate project");
        p2.setPid(4444);
        p2.setPname("chatbot");
        
        List<Employee> emp=new ArrayList<>();
        List<Projects> proj=new ArrayList<>();
        emp.add(e1);
        emp.add(e2);
        proj.add(p1);
        proj.add(p2);
        e1.setProjects(proj);
        p2.setEmp(emp);
        Session session=sf.openSession();
        Transaction tc=session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        tc.commit();
        session.close();
        sf.close();
	}

}
