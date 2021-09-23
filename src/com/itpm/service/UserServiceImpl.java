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

import com.itpm.model.User;
import com.itpm.utill.CommonConstants;
import com.itpm.utill.CommonUtil;
import com.itpm.utill.DBConnectionUtil;
import com.itpm.utill.QueryUtil;


public class UserServiceImpl implements IUserService{
	public static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());
//	private static final String UserId = null;
	private static Connection connection;
	private static Statement statement;
	
	static{
		createUserTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createUserTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_USER));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_USER));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	public void addUser(User user) {
		String UserId = CommonUtil.generateUserIDs(getUserIds());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USERS));
			connection.setAutoCommit(false);
			
			user.setUserId(UserId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getUserId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getFName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getLName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, user.getContactNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, user.getUserType());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, user.getUsername());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, user.getPassword());
			
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
	
	public User getUserByID(String UserId) {
		return actionOnUser(UserId).get(0);
	}
	
	public ArrayList<User> getUsers(){
		return actionOnUser(null);
	}
	
	public void removeUser(String UserId) {
		if(UserId != null && !UserId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_USER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, UserId);
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
	
	private ArrayList<User> actionOnUser(String UserId){
		ArrayList<User> userList = new ArrayList<User>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (UserId != null && !UserId.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_USER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, UserId);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_USERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				user.setFName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setLName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				user.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				user.setContactNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				user.setUserType(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				user.setUsername(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				user.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				userList.add(user);
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
	public User updateUser(String UserId, User user) {
		if (UserId != null && !UserId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_USER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getFName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getLName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getContactNumber());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, user.getUserType());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, user.getUsername());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, user.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, user.getUserId());
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
		return getUserByID(UserId);
	}
	
	private ArrayList<String> getUserIds(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_USER_IDS));
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
