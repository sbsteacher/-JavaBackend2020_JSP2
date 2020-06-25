package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;
import com.koreait.board.model.BoardVO;

@WebServlet("/boardMod")
public class BoardModSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		System.out.println("bid : " + bid);
		
		int intBid = Integer.parseInt(bid);
		BoardVO vo = new BoardVO();
		vo.setBid(intBid);
				
		BoardVO data = BoardDAO.selectBoard(vo);
		request.setAttribute("data", data);
		
		request.getRequestDispatcher("/WEB-INF/jsp/boardMod.jsp")
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		int intBid = Integer.parseInt(bid);
		System.out.println("bid : " + bid);
		System.out.println("title : " + title);
		System.out.println("ctnt : " + ctnt);
		
		BoardVO param = new BoardVO();
		param.setBid(intBid);
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		BoardDAO.updateBoard(param);
		
		response.sendRedirect("/boardDetail?bid=" + bid);
	}

}
