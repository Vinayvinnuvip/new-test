package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Person;
import service.PersonService;
@WebServlet("/control")
public class Control extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int id=Integer.parseInt(req.getParameter("id"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Person p=new Person();
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		p.setName(name);
		p.setId(id);
		p.setEmail(email);
		p.setPassword(password);
		PersonService ps=new PersonService();
		try {
			int i=ps.savePerson(p);
			if(i>0) {
				
				out.println("<h1>Sucessfully inserted...!</h1><br>");
				
				
				req.getRequestDispatcher("register.html").include(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
