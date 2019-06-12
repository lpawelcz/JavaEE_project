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

@WebServlet("/AddQuestionToTest")
public class AddQuestionToTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageQuestion manageQuestion = new ManageQuestion();
	private ManageQuestionInTest manageQuestionInTest = new ManageQuestionInTest();
	private ManageTest manageTest = new ManageTest();
	public Test test;
	public Question question;
	public QuestionInTest questionInTest;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String question_ID = request.getParameter("question_ID");								// pobierz z requesta id testu
		String test_ID = request.getParameter("test_ID");
		
		
		System.out.println("Otrzymane dane: " + question_ID + ", " + test_ID );
		System.out.println("# Rozpoczêcie dodawania pytañ do testu.");
		try
		{
			test = manageTest.GetTest(Integer.parseInt(test_ID));
		}catch(Exception e){
			System.out.println("@ Problem z pobranie testu z bazy.");
		}
		try
		{
			question = manageQuestion.GetQuestion(Integer.parseInt(question_ID));
		}catch(Exception e){
			System.out.println("@ Problem z pobranie pytania z bazy.");
		}
		try
		{
			//Test test, Question question
			questionInTest = new QuestionInTest(test, question);
			manageQuestionInTest.InsertQuestionInTest(test, question);
		}catch(Exception e){
			System.out.println("@ Problem tworzeniem pytania w tescie.");
		}

		//tutaj jakieœ przekierowanie do strony z list¹ pytañ
		request.getRequestDispatcher("ChooseQuestionToTest.jsp").forward(request, response);
	}
}