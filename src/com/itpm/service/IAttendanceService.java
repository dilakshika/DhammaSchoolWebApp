package com.itpm.service;

import java.util.ArrayList;

import com.itpm.model.Attendance;
import java.util.logging.Logger;

public interface IAttendanceService {
	
		public static final Logger log = Logger.getLogger(IAttendanceService.class.getName());
		
		public void addAttendance(Attendance attendance);
		
		public Attendance getAttendanceByID(String AttendanceId);
		
		public ArrayList<Attendance> getAttendances();
		
		public Attendance updateAttendance(String AttendanceId, Attendance attendance);
		
		public void removeAttendance(String AttendanceId);
		
}
