package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manage.*;
import database.entities.*;

@WebServlet("/CreateQuestionNew")
public class CreateQuestionNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageAnswer answerManager = new ManageAnswer();
	private ManageQuestion manageQuestion = new ManageQuestion();
	private ManageUser manageUser = new ManageUser();
	public Question questionQ;
	public Answer answerA;
	public Answer answerB;
	public Answer answerC;
	public Answer answerD;
	public User user;
	public Description description;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String question = request.getParameter("question");								// pobierz z requesta id testu
		String rodzaj = request.getParameter("rodzaj");
		String odpA = request.getParameter("odpA");
		String odpB = request.getParameter("odpB");
		String odpC = request.getParameter("odpC");
		String odpD = request.getParameter("odpD");
		String userID = request.getParameter("user_ID");
		List<Answer> answers = new ArrayList<Answer>();
		Answer CorrectAnswer = null;
		Answer Answer2 = null;
		Answer Answer3 = null;
		Answer Answer4 = null;
		boolean isPublic = false;
		int dType = 1;
		
		if(rodzaj == "open")
			dType = 2;
		
		try
		{
			user = manageUser.GetUser(Integer.parseInt(userID));
			out.println("User from base: " + user.getName() + ", ID: " + user.getUserID() + ".\n");
		}catch(Exception e){
			System.out.println("Problem ze znalezieniem usera.");
		}
		
		try
		{
			//String answer, Question question
			answerManager.InsertAnswer(odpA,null);
			answerManager.InsertAnswer(odpB,null);
			answerManager.InsertAnswer(odpC,null);
			answerManager.InsertAnswer(odpD,null);
			
			CorrectAnswer = answerManager.GetAnswer(odpA);
			Answer2 = answerManager.GetAnswer(odpB);
			Answer3 = answerManager.GetAnswer(odpC);
			Answer4 = answerManager.GetAnswer(odpD);
			
			answers.add(CorrectAnswer);
			answers.add(Answer2);
			answers.add(Answer3);
			answers.add(Answer4);
			
			
//			manageAnswer.InsertAnswer(answerA.getAnswer(), questionQ);
//			manageAnswer.InsertAnswer(answerB.getAnswer(), questionQ);
//			manageAnswer.InsertAnswer(answerC.getAnswer(), questionQ);
//			manageAnswer.InsertAnswer(answerD.getAnswer(), questionQ);
//			
//			answerA = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerA.getAnswer());
//			answerB = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerB.getAnswer());
//			answerC = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerC.getAnswer());
//			answerD = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerD.getAnswer());
//			
//			
//			questionQ.setAnswers(answers);
//			questionQ.setCorrectID(answerA.getAnswerID());
//			
//			manageQuestion.UpdateQuestion(questionQ.getQuestionID(), questionQ.getQuestion(), questionQ.getAnswers(), questionQ.getCorrectID());
			
		}catch(Exception e){
			System.out.println("Problem z stworzeniem nowych odpowiedzi w bazie."+e.getMessage());
		}
		
	//	try
	//	{
			//int DTYPE, User author, String question, List<Answer> answers, int correctID
			manageQuestion.InsertQuestion(dType, user, question, answers, CorrectAnswer.getAnswerID());
			questionQ = manageQuestion.GetQuestion(question, CorrectAnswer.getAnswerID());
			
			answerManager.UpdateAnswer(CorrectAnswer.getAnswerID(), questionQ);
			answerManager.UpdateAnswer(Answer2.getAnswerID(), questionQ);
			answerManager.UpdateAnswer(Answer3.getAnswerID(), questionQ);
			answerManager.UpdateAnswer(Answer4.getAnswerID(), questionQ);
			
			
			
			
	//	}catch(Exception e){
	//		System.out.println("Problem z stworzeniem nowego pytania w bazie."+e.);
	//	}
		
		//try
		//{
			List<Question> l = manageQuestion.ListUserQuestions(user.getName());
			
			for(int i=0;i<l.size();i++)//pobieram stworzone pytanie z bazy
			{
				if(l.get(i).getQuestion() == questionQ.getQuestion() && l.get(i).getDTYPE() == questionQ.getDTYPE())
				{
					questionQ = l.get(i);
				}
			}
		//}catch(Exception e){
		//	System.out.println("Problem z odczytaniem pytania w bazie."+e.getMessage());
		//}
		
		
		
		
		//tutaj jakieœ przekierowanie do strony z list¹ pytañ
		request.getRequestDispatcher("CreateNewQuestion.jsp").forward(request, response);
	}
}