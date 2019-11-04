package com.ruda.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NoticeDAO {
	
	//글작성
	public int noticeWrite(Connection con, NoticeDTO noticeDTO) throws Exception {
		int result = 0;
		String sql = "insert into notice values(board_seq.nextval, ?, ?,?, sysdate,0 )";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		result = st.executeUpdate();
		
		st.close();
		return result;
		
		
	}
	
	//전체조회
	public ArrayList<NoticeDTO> noticeList(Connection con) throws Exception{
		NoticeDTO noticeDTO = null;
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		String sql ="select * from notice order by num desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
		}
		rs.close();
		st.close();
		return ar;	
		
	}
	
	//글 하나
	public NoticeDTO noticeSelect(Connection con, int num) throws Exception{
		NoticeDTO noticeDTO = null;
		String sql="select * from notice where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			
		}
		rs.close();
		return noticeDTO;
	}
	
	//글 수정
	public int noticeUpdate(Connection con, NoticeDTO noticeDTO) throws Exception{
		int result = 0;
		String sql= "update notice set title=?, writer=?, contents=? where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		st.setInt(4, noticeDTO.getNum());
		
		result = st.executeUpdate();
		st.close();
		
		
		return result;
	}
	
	//글 삭제
	public int noticeDelete(Connection con, int num) throws Exception{
		int result =0;
		String sql = "delete notice where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();
		st.close();
		return result;
	}
	
	

}
