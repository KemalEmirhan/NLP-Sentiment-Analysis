package com.emirhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sentiment")
public class SentimentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = request.getParameter("message");
		double sentimentScore,veryPositive, positive, neutral, negative, veryNegative;
		String sentimentType;
		
		SentimentResult result = SentimentAnalyzer.getSentimentResult(message);
		
		sentimentType = result.getSentimentType();
		sentimentScore = result.getSentimentScore();
		veryPositive = result.getSentimentClass().getVeryPositive();
		positive = result.getSentimentClass().getPositive();
		neutral = result.getSentimentClass().getNeutral();
		negative = result.getSentimentClass().getNegative();
		veryNegative = result.getSentimentClass().getVeryNegative();
		
		
		request.setAttribute("type",sentimentType);
		request.setAttribute("score", sentimentScore);
		request.setAttribute("veryPositive", veryPositive);
		request.setAttribute("positive", positive);
		request.setAttribute("neutral", neutral);
		request.setAttribute("negative", negative);
		request.setAttribute("veryNegative", veryNegative);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
//		response.sendRedirect("index.jsp");

	}

}
