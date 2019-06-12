package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
	private ManageAnswer manageAnswer = new ManageAnswer();
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
		boolean isPublic = false;
		List<Answer> answers = null;
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
			//int DTYPE, User author, String question, List<Answer> answers, int correctID
			questionQ = new Question(dType, user, question, answers, 0);
			manageQuestion.InsertQuestion(dType, user, question, answers, 0);
		}catch(Exception e){
			System.out.println("Problem z stworzeniem nowego pytania w bazie.");
		}
		
		try
		{
			List<Question> l = manageQuestion.ListUserQuestions(user.getName());
			
			for(int i=0;i<l.size();i++)//pobieram stworzone pytanie z bazy
			{
				if(l.get(i).getQuestion() == questionQ.getQuestion() && l.get(i).getDTYPE() == questionQ.getDTYPE())
				{
					questionQ = l.get(i);
				}
			}
		}catch(Exception e){
			System.out.println("Problem z odczytaniem pytania w bazie.");
		}
		
		
		try
		{
			//String answer, Question question
			answerA = new Answer(odpA, questionQ);
			answerB = new Answer(odpB, questionQ);
			answerC = new Answer(odpC, questionQ);
			answerD = new Answer(odpD, questionQ);
			
			manageAnswer.InsertAnswer(answerA.getAnswer(), questionQ);
			manageAnswer.InsertAnswer(answerB.getAnswer(), questionQ);
			manageAnswer.InsertAnswer(answerC.getAnswer(), questionQ);
			manageAnswer.InsertAnswer(answerD.getAnswer(), questionQ);
			
			answerA = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerA.getAnswer());
			answerB = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerB.getAnswer());
			answerC = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerC.getAnswer());
			answerD = manageAnswer.GetAnswer(questionQ.getQuestionID(), answerD.getAnswer());
			
			answers.add(answerA);
			answers.add(answerB);
			answers.add(answerC);
			answers.add(answerD);
			
			questionQ.setAnswers(answers);
			questionQ.setCorrectID(answerA.getAnswerID());
			
			manageQuestion.UpdateQuestion(questionQ.getQuestionID(), questionQ.getQuestion(), questionQ.getAnswers(), questionQ.getCorrectID());
			
		}catch(Exception e){
			System.out.println("Problem z stworzeniem nowych odpowiedzi w bazie.");
		}
		
		//tutaj jakieœ przekierowanie do strony z list¹ pytañ
		request.getRequestDispatcher("CreateNewQuestion.jsp").forward(request, response);
	}
}