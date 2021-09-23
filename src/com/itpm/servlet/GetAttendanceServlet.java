package com.itpm.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Attendance;
import com.itpm.service.AttendanceServiceImpl;
import com.itpm.service.IAttendanceService;
/**
 * Servlet implementation class GetAttendanceServlet
 */
@WebServlet("/GetAttendanceServlet")
public class GetAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAttendanceServlet() {
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
		String AttendanceId = request.getParameter("AttendanceId");
		IAttendanceService iAttendanceService = new AttendanceServiceImpl();
		Attendance attendance = iAttendanceService.getAttendanceByID(AttendanceId);
		
		request.setAttribute("attendance", attendance);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetAttendance.jsp");
		dispatcher.forward(request, response);
	}

}
