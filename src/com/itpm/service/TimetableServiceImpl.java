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

import com.itpm.model.Timetable;
import com.itpm.utill.CommonConstants;
import com.itpm.utill.CommonUtil;
import com.itpm.utill.DBConnectionUtil;
import com.itpm.utill.QueryUtil;


public class TimetableServiceImpl implements ITimetableService{
	public static final Logger log = Logger.getLogger(TimetableServiceImpl.class.getName());
//	private static final String TimetableId = null;
	private static Connection connection;
	private static Statement statement;
	
	static{
		createTimetableTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createTimetableTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_TIMETABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_TIMETABLE));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	public void addTimetable(Timetable timetable) {
		String TimetableId = CommonUtil.generateTimetableIDs(getTimetableIds());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_TIMETABLES));
			connection.setAutoCommit(false);
			
			timetable.setTimetableId(TimetableId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, timetable.getTimetableId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, timetable.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, timetable.getYear());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, timetable.getFirstSubject());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, timetable.getFirstLecturer());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, timetable.getSecondSubject());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, timetable.getSecondLecturer());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, timetable.getThirdSubject());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, timetable.getThirdLecturer());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, timetable.getFourthSubject());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, timetable.getFourthLecturer());
		
		
			
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
	
	public Timetable getTimetableByID(String TimetableId) {
		return actionOnTimetable(TimetableId).get(0);
	}
	
	public ArrayList<Timetable> getTimetables(){
		return actionOnTimetable(null);
	}
	
	public void removeTimetable(String TimetableId) {
		if(TimetableId != null && !TimetableId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_TIMETABLE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, TimetableId);
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
	
	private ArrayList<Timetable> actionOnTimetable(String TimetableId){
		ArrayList<Timetable> timetableList = new ArrayList<Timetable>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (TimetableId != null && !TimetableId.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TIMETABLE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, TimetableId);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_TIMETABLES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Timetable timetable = new Timetable();
				timetable.setTimetableId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				timetable.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				timetable.setYear(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				timetable.setFirstSubject(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				timetable.setFirstLecturer(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				timetable.setSecondSubject(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				timetable.setSecondLecturer(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				timetable.setThirdSubject(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				timetable.setThirdLecturer(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				timetable.setFourthSubject(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				timetable.setFourthLecturer(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				
				timetableList.add(timetable);
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
		return timetableList;
	}
	public Timetable updateTimetable(String TimetableId, Timetable timetable) {
		if (TimetableId != null && !TimetableId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_TIMETABLE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, timetable.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, timetable.getYear());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, timetable.getFirstSubject());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, timetable.getFirstLecturer());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, timetable.getSecondSubject());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, timetable.getSecondLecturer());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, timetable.getThirdSubject());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, timetable.getThirdLecturer());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, timetable.getFourthSubject());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, timetable.getFourthLecturer());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, timetable.getTimetableId());
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
		return getTimetableByID(TimetableId);
	}
	
	private ArrayList<String> getTimetableIds(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TIMETABLE_IDS));
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
