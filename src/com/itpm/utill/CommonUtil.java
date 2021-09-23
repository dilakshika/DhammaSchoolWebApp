package com.itpm.utill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itpm.service.IResultService;
import com.itpm.service.IStudentService;
import com.itpm.utill.CommonConstants;
import com.itpm.service.IAttendanceService;
import com.itpm.service.IEventService;
import com.itpm.service.IUserService;
import com.itpm.service.ITimetableService;
import com.itpm.service.INoticeService;


public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IStudentService.class.getName());
	public static final Logger logResult = Logger.getLogger(IResultService.class.getName());
	public static final Logger logNotice = Logger.getLogger(INoticeService.class.getName());
	public static final Logger logTimetable = Logger.getLogger(ITimetableService.class.getName());
	public static final Logger logUser = Logger.getLogger(IUserService.class.getName());
	public static final Logger logEvent = Logger.getLogger(IEventService.class.getName());
	public static final Logger logAttendance = Logger.getLogger(IAttendanceService.class.getName());
	
	public static final Properties properties = new Properties();

	static {
		try {
			
		
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	//student
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.STUDENT_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.STUDENT_ID_PREFIX + next;
		}
		return id;
	}
	//result
	public static String generateResultIDs(ArrayList<String> arrayList) {
		String ResultId;
		int next = arrayList.size();
		next++;
		ResultId = CommonConstants.RESULT_ID_PREFIX + next;
		if(arrayList.contains(ResultId)) {
			next++;
			ResultId = CommonConstants.RESULT_ID_PREFIX + next;
		}
		return ResultId;
	}
	public static String generateNoticeIDs(ArrayList<String> arrayList) {
		String NoticeId;
		int next = arrayList.size();
		next++;
		NoticeId = CommonConstants.NOTICE_ID_PREFIX + next;
		if(arrayList.contains(NoticeId)) {
			next++;
			NoticeId = CommonConstants.NOTICE_ID_PREFIX + next;
		}
		return NoticeId;
	}
	
	public static String generateTimetableIDs(ArrayList<String> arrayList) {
		String TimetableId;
		int next = arrayList.size();
		next++;
		TimetableId = CommonConstants.TIMETABLE_ID_PREFIX + next;
		if(arrayList.contains(TimetableId)) {
			next++;
			TimetableId = CommonConstants.TIMETABLE_ID_PREFIX + next;
		}
		return TimetableId;
	}
	public static String generateUserIDs(ArrayList<String> arrayList) {
		String UserId;
		int next = arrayList.size();
		next++;
		UserId = CommonConstants.USER_ID_PREFIX + next;
		if(arrayList.contains(UserId)) {
			next++;
			UserId = CommonConstants.USER_ID_PREFIX + next;
		}
		return UserId;
	}
	public static String generateEventIDs(ArrayList<String> arrayList) {
		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.EVENT_ID_PREFIX + next;
		if(arrayList.contains(id)) {
			next++;
			id = CommonConstants.EVENT_ID_PREFIX + next;
		}
		return id;
	}
	public static String generateAttendanceIDs(ArrayList<String> arrayList) {
		String AttendanceId;
		int next = arrayList.size();
		next++;
		AttendanceId = CommonConstants.ATENDANCE_ID_PREFIX + next;
		if(arrayList.contains(AttendanceId)) {
			next++;
			AttendanceId = CommonConstants.ATENDANCE_ID_PREFIX + next;
		}
		return AttendanceId;
	}
}
