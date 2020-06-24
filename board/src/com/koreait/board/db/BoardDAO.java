package com.koreait.board.db;

import java.sql.*;
import com.koreait.board.model.BoardVO;

public class BoardDAO {
	public static void insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board "
				+ " (bid, title, ctnt) "
				+ " VALUES "
				+ " ((select nvl(max(bid), 0) + 1 from t_board), ?, ?) ";
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.executeUpdate();			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		
		
		
	}
}
