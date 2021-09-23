package com.itpm.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.itpm.model.Student;
import com.itpm.utill.CommonConstants;
import com.itpm.utill.CommonUtil;
import com.itpm.utill.DBConnectionUtil;
import com.itpm.utill.QueryUtil;


public class StudentServiceImpl implements IStudentService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createStudentTable();
	}

	private PreparedStatement preparedStatement;


	public static void createStudentTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new Students table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}


	@Override
	public void addStudent(Student student) {

		String InNo = CommonUtil.generateIDs(getInNos());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_STUDENTS));
			connection.setAutoCommit(false);
			
			//Generate student IDs
			student.setInNo(InNo);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, student.getInNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, student.getFname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, student.getIName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, student.getBirthday());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, student.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, student.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, student.getGuardian());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, student.getMobile());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, student.getADate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, student.getComment());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, student.getPosition());
			// Add student
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}


	@Override
	public Student getStudentByID(String InNo) {

		return actionOnStudent(InNo).get(0);
	}
	

	@Override
	public ArrayList<Student> getStudents() {
		
		return actionOnStudent(null);
	}


	@Override
	public void removeStudent(String InNo) {

		// Before deleting check whether student ID is available
		if (InNo != null && !InNo.isEmpty()) {
			/*
			 * Remove student query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STUDENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, InNo);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	private ArrayList<Student> actionOnStudent(String InNo) {

		ArrayList<Student> studentList = new ArrayList<Student>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (InNo != null && !InNo.isEmpty()) {
			
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, InNo);
			}
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_STUDENTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Student student = new Student();
				student.setInNo(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				student.setFname(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				student.setIName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				student.setBirthday(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				student.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				student.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				student.setGuardian(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				student.setMobile(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				student.setADate(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				student.setComment(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				student.setPosition(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				
				studentList.add(student);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return studentList;
	}


	@Override
	public Student updateStudent(String InNo, Student student) {

		
		if (InNo != null && !InNo.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STUDENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, student.getFname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, student.getIName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, student.getBirthday());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, student.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, student.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, student.getGuardian());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, student.getMobile());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, student.getADate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, student.getComment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, student.getPosition());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, student.getInNo());
				
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated student
		return getStudentByID(InNo);
	}

	private ArrayList<String> getInNos(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
	
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
