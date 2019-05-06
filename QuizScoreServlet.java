package com.cal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizScoreServlet
 */
@WebServlet("/QuizScoreServlet")
public class QuizScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String[] questions = {
			"3,1,4,1,5",
			"1,1,2,3,5",
			"1,4,9,16,25",
			"2,3,5,7,11",
			"1,2,4,8,16"
	};
	
	private static int[] answers = {9,8,36,13,32};
	
	private static int questionIndex = 0;
	
	private static int score = 0;

    /**
     * Default constructor. 
     */
    public QuizScoreServlet() {
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
//		doGet(request, response);
		String answer = request.getParameter("answer");
		System.out.println("answer" + answer); 
		System.out.println("questionIndex:" + questionIndex);
		
			if (Integer.valueOf(answer) == answers[questionIndex]) {	
				questionIndex++;
				score++;
			} else {
				questionIndex++;
			}
			
			if (questionIndex > questions.length - 1) {
				response.setContentType("text/html");
				PrintWriter out =  response.getWriter();	
				out.print("<strong>Quiz over</strong>");
			} else {
				
			
			
				response.setContentType("text/html");
				PrintWriter out =  response.getWriter();	
				out.print("<form method=\"post\" action=\"QuizScoreCal.do\">\n" + 
						"        \n" + 
						"            <strong>The Number Quiz</strong><br>\n" + 
						"            \n" + 
						"            <input readonly=\"readonly\" type=\"text\" name=\"currentScore\" value=\"Your current score is " + score + "\"><br>\n" + 
						"            \n" + 
						"            Guess the next number is the sequence\n" + 
						"            \n" + 
						"            <input readonly=\"readonly\" type=\"text\" name=\"questionNums\" value=\"" + questions[questionIndex] + "\"><br>\n" + 
						"            \n" + 
						"            <p>Your answer : <input type=\"text\" name=\"answer\"></p>\n" + 
						"            <input type=\"submit\">\n" + 
						"        \n" + 
						"        </form>");
			}
	}

}
