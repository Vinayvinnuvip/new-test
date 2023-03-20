package service;

import java.sql.SQLException;
import java.util.List;

import dao.PersonDao;
import dto.Person;

public class PersonService {
	 PersonDao dao = new PersonDao();
	  
	 public int savePerson(Person person) throws SQLException {
	  return dao.savePerson(person);
	 }

	 public int updatePerson(Person person) throws SQLException {
	  return dao.updatePerson(person);
	 }

	 public int deletePerson(int id) throws SQLException {
	  return dao.deletePerson(id);
	 }

	 public List<Person> getAllPerson() throws SQLException {
	  return dao.getAllPerson();
	 }

	 public Person getPersonById(int id) throws SQLException {
	  return dao.getById(id);
	 }
	}