package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;
import com.koreait.board.model.BoardVO;

@WebServlet("/boardList")
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("제목이당!!");
		vo.setCtnt("내용이당!!!");
		
		BoardDAO.insertBoard(vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/boardList.jsp");
		rd.forward(request, response);
	}
}



