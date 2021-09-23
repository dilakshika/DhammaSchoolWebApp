package com.itpm.service;

import java.util.ArrayList;

import com.itpm.model.Notice;
import java.util.logging.Logger;

public interface INoticeService {
	
		public static final Logger log = Logger.getLogger(INoticeService.class.getName());
		
		public void addNotice(Notice notice);
		
		public Notice getNoticeByID(String NoticeId);
		
		public ArrayList<Notice> getNotices();
		
		public Notice updateNotice(String NoticeId, Notice notice);
		
		public void removeNotice(String NoticeId);
		
}
