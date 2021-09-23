package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.service.NoticeServiceImpl;
import com.itpm.service.INoticeService;
/**
 * Servlet implementation class DeleteNoticeServlet
 */
@WebServlet("/DeleteNoticeServlet")
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1871871796669342804L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoticeServlet() {
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
		String NoticeId = request.getParameter("NoticeId");
		
		INoticeService iNoticeService = new NoticeServiceImpl();
		iNoticeService.removeNotice(NoticeId);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListNotices.jsp");
		dispatcher.forward(request, response);
	}

}
