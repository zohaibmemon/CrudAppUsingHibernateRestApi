package com.geaks.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.geaks.beans.Employee;

public class HibernateDAO {

	public void create(Employee e) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(e);

		session.getTransaction().commit();
		session.close();		
		
		
	}

	public List<Employee> getEmployeesMethod() {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from Employee");
		List<Employee> listEmployees=query.list();
		
		session.close();
		return listEmployees;
		
	}

	public Employee getValueById(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		Employee employee=new Employee();
			
		employee=session.get(Employee.class, id);
			
		return employee;
	
	}

	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		
		e.setName(e.getName());
		e.setLastName(e.getLastName());
		session.update(e);
		
		session.getTransaction().commit();
		session.close();
		return e;	
	}

		public void deleteEmployeeMethod(int  e) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		Employee id= (Employee) session.get(Employee.class, e);
		
		session.delete(id);
		session.getTransaction().commit();
		session.close();
		
	}
		
		
	/*	public void deleteRegistration(int id)
		{
	Session session=HibernateUtil.getInstance().openSession();
			
			session.beginTransaction();
			
			RegisterationBean rb=(RegisterationBean) session.get(RegisterationBean.class, id);
			session.delete(rb);
			session.getTransaction().commit();
			session.close();
			
		}*/
	
	
	
	
	
	

}
