package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.service.TimetableServiceImpl;
import com.itpm.service.ITimetableService;
/**
 * Servlet implementation class DeleteTimetableServlet
 */
@WebServlet("/DeleteTimetableServlet")
public class DeleteTimetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1871871796669342804L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTimetableServlet() {
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
		String TimetableId = request.getParameter("TimetableId");
		
		ITimetableService iTimetableService = new TimetableServiceImpl();
		iTimetableService.removeTimetable(TimetableId);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListTimetables.jsp");
		dispatcher.forward(request, response);
	}

}
