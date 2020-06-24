package com.koreait.board.db;

//import static com.koreait.board.db.DbCon.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



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
	
	public static List<BoardVO> selectBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT bid, title, r_dt FROM t_board ORDER BY bid DESC ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String title = rs.getString("title");			
				String r_dt = rs.getString("r_dt");
				
				BoardVO vo = new BoardVO();
				vo.setBid(bid);
				vo.setTitle(title);				
				vo.setR_dt(r_dt);
				
				list.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}		
		return list;
	}
	
	public static BoardVO selectBoard() {
		BoardVO vo = new BoardVO();
		
		return vo;
	}
}









