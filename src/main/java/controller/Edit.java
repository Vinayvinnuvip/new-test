package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Person;
import service.PersonService;


public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Person p=null;
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		PersonService ps=new PersonService();
		try {
			p=ps.getPersonById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write("<form action='update'>\r\n"
				+ "Name: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='name' placeholder='"+p.getName()+"'> <br> <br>\r\n"
				+"Id:&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='id' placeholder='"+p.getId()+"'> <br> <br>"
				+ "Email:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='email' placeholder='"+p.getEmail()+"'> <br> <br>\r\n"
				+ "Password:&nbsp <input type='text' name='password' placeholder='"+p.getPassword()+"'> <br> <br>\r\n"
				+ "<input type='submit' value='Update'>\r\n"
				+ "</form>");
	
	
	}

}
