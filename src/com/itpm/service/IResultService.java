package com.itpm.service;

import java.util.ArrayList;

import com.itpm.model.Result;
import java.util.logging.Logger;

public interface IResultService {
	
		public static final Logger log = Logger.getLogger(IResultService.class.getName());
		
		public void addResult(Result result);
		
		public Result getResultByID(String ResultId);
		
		public ArrayList<Result> getResults();
		
		public Result updateResult(String ResultId, Result result);
		
		public void removeResult(String ResultId);
		
}
