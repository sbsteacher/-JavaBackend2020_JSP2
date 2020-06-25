package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;

@WebServlet("/boardDel")
public class BoardDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		int intBid = Integer.parseInt(bid);
		
		BoardDAO.deleteBoard(intBid);
		
		response.sendRedirect("/boardList");		
	}
}
