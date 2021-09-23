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

import com.itpm.model.Result;
import com.itpm.utill.CommonConstants;
import com.itpm.utill.CommonUtil;
import com.itpm.utill.DBConnectionUtil;
import com.itpm.utill.QueryUtil;


public class ResultServiceImpl implements IResultService{
	public static final Logger log = Logger.getLogger(ResultServiceImpl.class.getName());
//	private static final String ResultId = null;
	private static Connection connection;
	private static Statement statement;
	
	static{
		createResultTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createResultTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_RESULT));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_RESULT));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	public void addResult(Result result) {
		String ResultId = CommonUtil.generateResultIDs(getResultIds());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_RESULTS));
			connection.setAutoCommit(false);
			
			result.setResultId(ResultId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, result.getResultId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, result.getSid());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, result.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, result.getYear());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, result.getGrade());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, result.getExam());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, result.getResult());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, result.getPassword());
			
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
	
	public Result getResultByID(String ResultId) {
		return actionOnResult(ResultId).get(0);
	}
	
	public ArrayList<Result> getResults(){
		return actionOnResult(null);
	}
	
	public void removeResult(String ResultId) {
		if(ResultId != null && !ResultId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_RESULT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, ResultId);
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
	
	private ArrayList<Result> actionOnResult(String ResultId){
		ArrayList<Result> resultList = new ArrayList<Result>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (ResultId != null && !ResultId.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_RESULT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, ResultId);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_RESULTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Result result = new Result();
				result.setResultId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				result.setSid(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				result.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				result.setYear(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				result.setGrade(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				result.setExam(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				result.setResult(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				result.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				resultList.add(result);
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
		return resultList;
	}
	public Result updateResult(String ResultId, Result result) {
		if (ResultId != null && !ResultId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_RESULT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, result.getSid());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, result.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, result.getYear());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, result.getGrade());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, result.getExam());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, result.getResult());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, result.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, result.getResultId());
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
		return getResultByID(ResultId);
	}
	
	private ArrayList<String> getResultIds(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_RESULT_IDS));
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
