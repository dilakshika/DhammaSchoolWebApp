package com.itpm.service;

import java.util.ArrayList;

import com.itpm.model.Timetable;
import java.util.logging.Logger;

public interface ITimetableService {
	
		public static final Logger log = Logger.getLogger(ITimetableService.class.getName());
		
		public void addTimetable(Timetable timetable);
		
		public Timetable getTimetableByID(String TimetableId);
		
		public ArrayList<Timetable> getTimetables();
		
		public Timetable updateTimetable(String TimetableId, Timetable timetable);
		
		public void removeTimetable(String TimetableId);
		
}
