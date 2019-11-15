package com.ashsoft.client;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ashsoft.entity.Employee;

public class ClientApp {
	
	public void insertRecord()
	{
		SessionFactory sf=null;
		Session session=null;
		Transaction tx=null;
		try {
			Configuration cfg= new Configuration();
			cfg.configure("/com/ashsoft/resources/hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder=builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry=builder.build();
			sf=cfg.buildSessionFactory(registry);
			session=sf.openSession();
			tx=session.beginTransaction();
			
			Employee emp= new Employee();
			emp.setEno(333);
			emp.setEname("Virat");
			emp.setEsal(60000);
			emp.setEaddr("Hyd");
			
			session.save(emp);
			tx.commit();
			System.out.println("Employee Inserted Successfully");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Employee Insertion Failure");
			e.printStackTrace();
		}
		finally
		{
			sf.close();
		}
	}
}
