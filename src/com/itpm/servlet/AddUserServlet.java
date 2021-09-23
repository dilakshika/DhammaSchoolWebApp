package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.User;
import com.itpm.service.UserServiceImpl;
import com.itpm.service.IUserService;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		response.setContentType("text/html");
		User user = new User();
		
		user.setFName(request.getParameter("FName"));
		user.setLName(request.getParameter("LName"));
		user.setEmail(request.getParameter("Email"));
		user.setContactNumber(request.getParameter("ContactNumber"));
		user.setUserType(request.getParameter("UserType"));
		user.setUsername(request.getParameter("Username"));
		user.setPassword(request.getParameter("Password"));

		IUserService iUserService = new UserServiceImpl();
		iUserService.addUser(user);

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListUsers.jsp");
		dispatcher.forward(request, response);
	}

}
