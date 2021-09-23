package com.itpm.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Result;
import com.itpm.service.ResultServiceImpl;
import com.itpm.service.IResultService;

@WebServlet("/GetResultServlet")
public class GetResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String ResultId = request.getParameter("ResultId");
		IResultService iResultService = new ResultServiceImpl();
		Result result = iResultService.getResultByID(ResultId);
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetResult.jsp");
		dispatcher.forward(request, response);
	}

}
