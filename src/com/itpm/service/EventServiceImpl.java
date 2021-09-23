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

import com.itpm.model.Event;
import com.itpm.utill.CommonConstants;
import com.itpm.utill.CommonUtil;
import com.itpm.utill.DBConnectionUtil;
import com.itpm.utill.QueryUtil;



/**
 * Contract for the implementation of Event Service .
 */
public class EventServiceImpl implements IEventService{
	public static final Logger logEvent = Logger.getLogger(EventServiceImpl.class.getName());
//	private static final String id = null;
	private static Connection connection;
	private static Statement statement;
	
	static{
		createEventTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createEventTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_EVENT));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_EVENT));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			logEvent.log(Level.SEVERE, e.getMessage());
		}
	}
	
	@Override
	public void addEvent(Event event) {
		String id = CommonUtil.generateEventIDs(getids());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_EVENTS));
			connection.setAutoCommit(false);
			
			event.setId(id);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, event.getId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, event.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, event.getPlace());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, event.getDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, event.getStime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, event.getDuration());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, event.getIncharg_id());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, event.getParticipants());
			
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			logEvent.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logEvent.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	public Event getEventByID(String id) {
		return actionOnEvent(id).get(0);
	}
	
	public ArrayList<Event> getEvents(){
		return actionOnEvent(null);
	}
	
	public void removeEvent(String id) {
		if(id != null && !id.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_EVENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				logEvent.log(Level.SEVERE, e.getMessage());
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					logEvent.log(Level.SEVERE, e.getMessage());
				}
				
			}
		}
	}
	
	private ArrayList<Event> actionOnEvent(String id){
		ArrayList<Event> eventList = new ArrayList<Event>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (id != null && !id.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_EVENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_EVENTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Event event = new Event();
				event.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				event.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				event.setPlace(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				event.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				event.setStime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				event.setDuration(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				event.setIncharg_id(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				event.setParticipants(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				eventList.add(event);
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			logEvent.log(Level.SEVERE, e.getMessage());
		}  finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logEvent.log(Level.SEVERE, e.getMessage());
			}
		}
		return eventList;
	}
	public Event updateEvent(String id, Event event) {
		if (id != null && !id.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_EVENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, event.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, event.getPlace());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, event.getDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, event.getStime());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, event.getDuration());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, event.getIncharg_id());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, event.getParticipants());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, event.getId());
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				logEvent.log(Level.SEVERE, e.getMessage());
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					logEvent.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		return getEventByID(id);
	}
	
	private ArrayList<String> getids(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_EVENT_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			logEvent.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logEvent.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}


	
}
