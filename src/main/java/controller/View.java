package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Person;
import service.PersonService;

@WebServlet("/viewall")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	PersonService ps=new PersonService();
	List<Person> list;
	try {
		list = ps.getAllPerson();
		out.print("<h1><a href='register.html'>Back to Register</a><h1>");
		out.print("<table border=2 width=100%> <tr> <th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
		for(Person p:list) {
		out.print("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getEmail()+"</td><td>"+p.getPassword()+"</td><td><a href='edit?id="+p.getId()+"'>Edit</a></td><td>"+"<a href='delete?id="+p.getId()+"'>Delete</a></td></tr>");
				
		}
		out.print("</table>");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
