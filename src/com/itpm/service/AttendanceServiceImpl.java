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

import com.itpm.model.Attendance;
import com.itpm.utill.CommonConstants;
import com.itpm.utill.CommonUtil;
import com.itpm.utill.DBConnectionUtil;
import com.itpm.utill.QueryUtil;

/**
 * Contract for the implementation of Attendance Service .
 */
public class AttendanceServiceImpl implements IAttendanceService{
	public static final Logger log = Logger.getLogger(AttendanceServiceImpl.class.getName());
//	private static final String AttendanceId = null;
	private static Connection connection;
	private static Statement statement;
	
	static{
		createAttendanceTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createAttendanceTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_ATENDANCE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_ATENDANCE));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	public void addAttendance(Attendance attendance) {
		String AttendanceId = CommonUtil.generateAttendanceIDs(getAttendanceIds());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ATENDANCES));
			connection.setAutoCommit(false);
			
			attendance.setAttendanceId(AttendanceId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendance.getAttendanceId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendance.getStdId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, attendance.getStdGrade());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, attendance.getStdArrivesTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, attendance.getStdArrivesDate());
			
			
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
	
	public Attendance getAttendanceByID(String AttendanceId) {
		return actionOnAttendance(AttendanceId).get(0);
	}
	
	public ArrayList<Attendance> getAttendances(){
		return actionOnAttendance(null);
	}
	
	public void removeAttendance(String AttendanceId) {
		if(AttendanceId != null && !AttendanceId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ATENDANCE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, AttendanceId);
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
	}
	
	private ArrayList<Attendance> actionOnAttendance(String AttendanceId){
		ArrayList<Attendance> userList = new ArrayList<Attendance>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (AttendanceId != null && !AttendanceId.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ATENDANCE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, AttendanceId);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ATENDANCES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Attendance attendance = new Attendance();
				attendance.setAttendanceId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				attendance.setStdId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				attendance.setStdGrade(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				attendance.setStdArrivesTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				attendance.setStdArrivesDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				userList.add(attendance);
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
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
		return userList;
	}
	public Attendance updateAttendance(String AttendanceId, Attendance attendance) {
		if (AttendanceId != null && !AttendanceId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ATENDANCE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendance.getStdId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendance.getStdGrade());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, attendance.getStdArrivesTime());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, attendance.getStdArrivesDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, attendance.getAttendanceId());
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
		return getAttendanceByID(AttendanceId);
	}
	
	private ArrayList<String> getAttendanceIds(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ATENDANCE_IDS));
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
