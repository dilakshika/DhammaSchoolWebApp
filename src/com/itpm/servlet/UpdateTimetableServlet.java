package com.itpm.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Timetable;
import com.itpm.service.TimetableServiceImpl;
import com.itpm.service.ITimetableService;

/**
 * Servlet implementation class UpdateTimetableServlet
 */
@WebServlet("/UpdateTimetableServlet")
public class UpdateTimetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTimetableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		Timetable timetable =new Timetable();
		String TimetableId = request.getParameter("TimetableId");
		timetable.setTimetableId(TimetableId);
		timetable.setName(request.getParameter("name"));
		timetable.setYear(request.getParameter("year"));
		timetable.setFirstSubject(request.getParameter("firstSubject"));
		timetable.setFirstLecturer(request.getParameter("firstLecturer"));
		timetable.setSecondSubject(request.getParameter("secondSubject"));
		timetable.setSecondLecturer(request.getParameter("secondLecturer"));
		timetable.setThirdSubject(request.getParameter("thirdSubject"));
		timetable.setThirdLecturer(request.getParameter("thirdLecturer"));
		timetable.setFourthSubject(request.getParameter("fourthSubject"));
		timetable.setFourthLecturer(request.getParameter("fourthLecturer"));
		
		ITimetableService iTimetableService = new TimetableServiceImpl();
		iTimetableService.updateTimetable(TimetableId, timetable);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListTimetables.jsp");
		dispatcher.forward(request, response);
	}
	

}
