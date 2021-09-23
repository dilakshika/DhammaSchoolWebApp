package com.itpm.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Notice;
import com.itpm.service.NoticeServiceImpl;
import com.itpm.service.INoticeService;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/UpdateNoticeServlet")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
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
		
		Notice notice =new Notice();
		String NoticeId = request.getParameter("NoticeId");
		notice.setNoticeId(NoticeId);
		notice.setNname(request.getParameter("Nname"));
		notice.setNdate(request.getParameter("Ndate"));
		notice.setNowner(request.getParameter("Nowner"));
		notice.setNotice(request.getParameter("Notice"));
	
		
		
		INoticeService iNoticeService = new NoticeServiceImpl();
		iNoticeService.updateNotice(NoticeId, notice);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListNotices.jsp");
		dispatcher.forward(request, response);
	}
	

}
