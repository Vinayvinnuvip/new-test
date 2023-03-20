package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Person;
import service.PersonService;
@WebServlet("/update")

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name=req.getParameter("name");
		int id=Integer.parseInt(req.getParameter("id"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		PersonService ps=new PersonService();
		Person p=new Person();
		p.setId(id);
		p.setEmail(email);
		p.setName(name);
		p.setPassword(password);
		
		int i=0;
		try {
			i=ps.updatePerson(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			System.out.println("Sucessfully Updated");
			req.getRequestDispatcher("viewall").include(req, response);
			
		}else {
			System.out.println("not Updated");
			req.getRequestDispatcher("viewall").include(req, response);
		}
		
		
	}

}
