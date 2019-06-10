package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manage.*;
import database.entities.Test;
import database.entities.User;

@WebServlet("/SignUpForTest")
public class SignUpForTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageTest manageTests = new ManageTest();
	private ManageUser manageUser = new ManageUser();
	public Test test;
	public User user;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user_ID = request.getParameter("user_ID");								// pobierz z requesta id testu
		String test_ID = request.getParameter("test_ID");
		String question = "0";
		out.print("Hello World " + user_ID + ", " + test_ID);
		
		test = manageTests.GetTest(Integer.parseInt(test_ID));
		user = manageUser.GetUser(Integer.parseInt(user_ID));
		
		request.setAttribute("user", user);
		request.setAttribute("test", test);
		
		//request.setAttribute("question", question);
		
		
		request.getRequestDispatcher("ViewQuestion.jsp").forward(request, response);
	}
}