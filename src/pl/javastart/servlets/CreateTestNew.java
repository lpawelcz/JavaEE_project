package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manage.*;
import database.entities.*;

@WebServlet("/CreateTestNew")
public class CreateTestNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageTest manageTests = new ManageTest();
	private ManageDescription manageDescription = new ManageDescription();
	private ManageUser manageUser = new ManageUser();
	public Test test;
	public User user;
	public Description description;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String test_topic = request.getParameter("topic");								// pobierz z requesta id testu
		String test_description = request.getParameter("description");
		String test_isPublic = request.getParameter("isPublic");
		String userID = request.getParameter("user_ID");
		boolean isPublic = false;
		
		out.print("Otrzymane dane: " + test_topic + ", " + test_description + " " + test_isPublic + ", user id: " + userID);
		if(test_isPublic == "True" || test_isPublic == "true" || test_isPublic == "T" || test_isPublic == "t" || test_isPublic == "TRUE" || test_isPublic == "Tak" || test_isPublic == "tak")
			isPublic = true;
		try
		{
			user = manageUser.GetUser(Integer.parseInt(userID));
		}catch(Exception e){
			System.out.println("Problem ze znalezieniem usera.");
		}
		
		
		try
		{
			//String topic, String description
			description = new Description(test_topic, test_description);
			manageDescription.InsertDescription(test_topic, test_description);
		}catch(Exception e){
			System.out.println("Problem z stworzeniem nowego opisu w bazie.");
		}
		
		try
		{
			description = manageDescription.GetDescription(description.getTopic(), description.getDescription());
		}catch(Exception e){
			System.out.println("Problem ze znalezieniem opisu w bazie.");
		}
		
		try
		{
			//User author, Description description, boolean isPublic
			test = new Test(user, description, isPublic);
			manageTests.InsertTest(user, description, isPublic);
		}catch(Exception e){
			System.out.println("Problem z stworzeniem nowego testu w bazie.");
		}
		
		try
		{
			//User author, Description description, boolean isPublic
			test = manageTests.GetTest(user, description);
		}catch(Exception e){
			System.out.println("Problem ze znalezieniem testu w bazie.");
		}

		request.setAttribute("test", test);
		
		//tutaj jakieœ przekierowanie do strony z list¹ pytañ
		//request.getRequestDispatcher("ViewQuestion.jsp").forward(request, response);
	}
}