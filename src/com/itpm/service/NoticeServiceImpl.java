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

import com.itpm.model.Notice;
import com.itpm.utill.CommonConstants;
import com.itpm.utill.CommonUtil;
import com.itpm.utill.DBConnectionUtil;
import com.itpm.utill.QueryUtil;

public class NoticeServiceImpl implements INoticeService{
	public static final Logger log = Logger.getLogger(NoticeServiceImpl.class.getName());
//	private static final String NoticeId = null;
	private static Connection connection;
	private static Statement statement;
	
	static{
		createNoticeTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createNoticeTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_NOTICE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_NOTICE));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	public void addNotice(Notice notice) {
		String NoticeId = CommonUtil.generateNoticeIDs(getNoticeIds());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_NOTICES));
			connection.setAutoCommit(false);
			
			notice.setNoticeId(NoticeId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, notice.getNoticeId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, notice.getNname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, notice.getNdate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, notice.getNowner());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, notice.getNotice());

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
	
	public Notice getNoticeByID(String NoticeId) {
		return actionOnNotice(NoticeId).get(0);
	}
	
	public ArrayList<Notice> getNotices(){
		return actionOnNotice(null);
	}
	
	public void removeNotice(String NoticeId) {
		if(NoticeId != null && !NoticeId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_NOTICE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, NoticeId);
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
	
	private ArrayList<Notice> actionOnNotice(String NoticeId){
		ArrayList<Notice> userList = new ArrayList<Notice>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (NoticeId != null && !NoticeId.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_NOTICE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, NoticeId);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_NOTICES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Notice notice = new Notice();
				notice.setNoticeId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				notice.setNname(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				notice.setNdate(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				notice.setNowner(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				notice.setNotice(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				
				userList.add(notice);
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
	public Notice updateNotice(String NoticeId, Notice notice) {
		if (NoticeId != null && !NoticeId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_NOTICE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, notice.getNname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, notice.getNdate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, notice.getNowner());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, notice.getNotice());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, notice.getNoticeId());
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
		return getNoticeByID(NoticeId);
	}
	
	private ArrayList<String> getNoticeIds(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_NOTICE_IDS));
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
