package com.telusko.DemoRest5;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.geaks.beans.Employee;
import com.geaks.dao.HibernateDAO;

@Path("employee")
public class ActionClass {
	
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "hello world!";
    }
	
	HibernateDAO hdao=new HibernateDAO();
	@POST
	@Path("alien")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee createAlien(Employee e) throws SQLException
	{	
		hdao.create(e);
		
		return e;
		
	}
	
	@GET
	@Path("/viewEmployees")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees()
	{
		HibernateDAO hdao=new HibernateDAO();
		hdao.getEmployeesMethod();
		List<Employee> listemployee=hdao.getEmployeesMethod();
//		for(int i=0;i<=listemployee.size();i++)
//		{
//			System.out.println(listemployee.get(i));
//		}
//		
		return listemployee;
		
	}
	
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id")int id)
	{
		HibernateDAO hdao=new HibernateDAO();
		Employee r=hdao.getValueById(id);
		
		return r;
			
	}
	
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(Employee e)
	{
		
		HibernateDAO hdao=new HibernateDAO();
		Employee employee=hdao.updateEmployee(e);
		
		return e;
	
	}
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String  delete( @PathParam("id") int e)
	{
		HibernateDAO hdao=new HibernateDAO();
		
		hdao.deleteEmployeeMethod(e);
		
		return "deleted";

	}
	

}
