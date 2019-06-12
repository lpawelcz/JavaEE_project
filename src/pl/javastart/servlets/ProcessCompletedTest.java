package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manage.*;
import database.entities.*;

@WebServlet("/ProcessCompletedTest")
public class ProcessCompletedTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ProcessCompletedTest() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManageCompletedTest CompletedTestManager = new ManageCompletedTest();
		ManageResult ResultManager = new ManageResult();
		ManageTest TestManager = new ManageTest();
		ManageUser UserManager = new ManageUser();
		//ManageQuestionInTest QuestionInTestManager = new ManageQuestionInTest();
		ManageQuestion QuestionManager = new ManageQuestion();
		ManageAnswer AnswerManager = new ManageAnswer();
		 
		
       // PrintWriter out = response.getWriter();
        //response.setContentType("text/plain");
        
		Enumeration<String> parameterNames = request.getParameterNames();
		HttpSession session = request.getSession(true);
		String userID = session.getAttribute("userID").toString();
		String testID;
		String paramValue = null;
		int question_cnt = 0;
		ArrayList<String> questionID = new ArrayList<String>();
		ArrayList<String> Values = new ArrayList<String>();
        while (parameterNames.hasMoreElements()) {
 
            String paramName = parameterNames.nextElement();
            questionID.add(paramName);
        //    out.write("paramName: " + paramName);
        //    out.write("\nparamValues: ");
 
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                paramValue = paramValues[i];
        //        out.write(paramValue);
        //        out.write(" ");
            }
            Values.add(paramValue);
        //    out.write("\n\n");
            question_cnt++;
        }
        testID = paramValue;
        
        Test test = TestManager.GetTest(Integer.parseInt(testID));
       // out.println(test);
        List<Question> questions = new ArrayList<Question>();
        for(int i=0;i<question_cnt-1;i++){
        	questions.add(QuestionManager.GetQuestion(Integer.parseInt(questionID.get(i))));
        //	out.println(questions.get(i).getQuestionID());
        }
//        List<QuestionInTest> questionInTest = QuestionInTestManager.ListTestQuestionInTest(Integer.parseInt(testID));
//        for (int i=0;i<questionInTest.size();i++) {
//        	questions.add(questionInTest.get(i).getQuestion());
//        }
//        List<Question> questions = test.getQuestions();
        //out.println(questions);
        float points = 0;
        float prcntgOfUnderstanding;
        int maxPoints = questions.size();
        boolean[] questionMap = new boolean[questions.size()];
        for(int i=0; i < questions.size();i++)
        {
        	if(questions.get(i).getDTYPE()==1)	// pytanie zamkniête
        	{
        		if(questions.get(i).getCorrectID() == Integer.parseInt(Values.get(i)))	// poprawna odpowiedz
        		{
        			points++;
        			questionMap[i]=true;
        			//out.println("poprawna");
        		}
        		else
        		{
        			//out.println("bledna");
        		}
        	}
        	else								// pytanie otwarte
        	{
        		Answer correctOpenQuestionAnswer = AnswerManager.GetAnswer(questions.get(i).getCorrectID());
        		//out.println("\""+Values.get(i)+"\" odpowiedz poprawna: \""+correctOpenQuestionAnswer.getAnswer()+"\"question id: "+questions.get(i).getQuestionID()+"\"correct id: "+questions.get(i).getCorrectID());
        		if(Values.get(i).equals(correctOpenQuestionAnswer.getAnswer()))	// poprawna odpowiedz -  string odpowiedzi zawiera siê w poprawnej odpowiedzi
        		{
        			points++;
        			questionMap[i]=true;
        			
        			//out.println("poprawna");
        		}
        		else
        		{
        			//out.println("bledna");
        		}
        	}
        	//out.println(Values.get(i)+" "+questions.get(i).getAnswers().get(0).getAnswer()+" "+questions.get(i).getAnswers().get(0).getAnswerID());
        }
        prcntgOfUnderstanding = 100*points/maxPoints;
        Result result = new Result(points, prcntgOfUnderstanding);
        ResultManager.InsertResult(result);
        User user = UserManager.GetUser(Integer.parseInt(userID));
        CompletedTestManager.InsertCompletedTest(user,test,result);
        
        request.setAttribute("Result", result);
        request.setAttribute("TestID", testID);
        request.setAttribute("Questions", questions);
        request.setAttribute("QuestionMap", questionMap);
        request.getRequestDispatcher("CompletedTest.jsp").forward(request, response);
        
        //out.write("paramName: userID" );
        //out.write("\nparamValues: " + userID);
        //out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}