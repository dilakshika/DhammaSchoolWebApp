package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Timetable;
import com.itpm.service.ITimetableService;
import com.itpm.service.TimetableServiceImpl;

/**
 * Servlet implementation class GetUpdateTimetable
 */
@WebServlet("/GetUpdateTimetable")
public class GetUpdateTimetable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUpdateTimetable() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String TimetableId = request.getParameter("TimetableId");
		ITimetableService iTimetableService = new TimetableServiceImpl();
		Timetable timetable = iTimetableService.getTimetableByID(TimetableId);
		
		request.setAttribute("timetable", timetable);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetUpdateTimeTable.jsp");
		dispatcher.forward(request, response);
	}

}
