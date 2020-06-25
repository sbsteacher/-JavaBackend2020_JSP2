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
	
	public static List<BoardVO> selectBoardList() { //0~100
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT title, bid, r_dt FROM t_board ORDER BY bid DESC ";
		
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
	
	public static BoardVO selectBoard(BoardVO param) { //0~1
		BoardVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT title, ctnt "
				+ " , TO_CHAR(r_dt ,'yyyy.mm.dd') as r_dt "
				+ " FROM t_board "
				+ " WHERE bid = ? ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getBid());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBid(param.getBid());
				vo.setTitle(rs.getNString("title"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getNString("r_dt"));				
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}
		
	
		return vo;
	}
}









