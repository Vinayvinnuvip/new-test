package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Person;

public class PersonDao {
	Connection con=null;
	public Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kcea","root","root");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		}
	public int savePerson(Person p) throws SQLException {
		con=connection();
		PreparedStatement pst=con.prepareStatement("insert into user1 values(?,?,?,?) ");
		pst.setInt(1,p.getId());
		pst.setString(2,p.getName());
		pst.setString(3,p.getEmail());
		pst.setString(4,p.getPassword());
		int i=pst.executeUpdate();
		con.close();
		System.out.println(i+" rows are effected");
		return i;
	}
	public int updatePerson(Person p) throws SQLException {
		con=connection();
		PreparedStatement pst=con.prepareStatement("update user1 set name=?,email=?,password=? where id=?");
		pst.setString(1,p.getName());
		pst.setString(2,p.getEmail());
		pst.setString(3,p.getPassword());
		pst.setInt(4,p.getId());
		int i=pst.executeUpdate();
		System.out.println(i+" are effected");
		con.close();
		return i;
	}
	public int deletePerson(int id) throws SQLException {
		con=connection();
		PreparedStatement pst=con.prepareStatement("delete from user1 where id=?");
		pst.setInt(1,id);
		int i=pst.executeUpdate();
		System.out.println(i+" are effected");
		con.close();
		return i;
		
	}
	public List<Person> getAllPerson() throws SQLException{
		con=connection();
		List<Person> list=new ArrayList<>();
		PreparedStatement pst=con.prepareStatement("select * from user1");
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			Person p=new Person();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setEmail(rs.getString(3));
			p.setPassword(rs.getString(4));
			list.add(p);
			
		}
		con.close();
		return list;
	}
public Person getById(int id) throws SQLException {
	Person p=new Person();
	con=connection();
	PreparedStatement pst=con.prepareStatement("select * from user1 where id=?");
	pst.setInt(1, id);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setEmail(rs.getString(3));
		p.setPassword(rs.getString(4));
	}con.close();
	return p;
	}
}
