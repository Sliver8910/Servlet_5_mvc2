package com.ruda.notice;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruda.action.ActionFoward;
import com.ruda.util.DBConnector;

/**
 * @author a
 *
 */
public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	public ActionFoward selectList(HttpServletRequest request, HttpServletResponse response)  {
		//DAO 보내기전 전처리 작업
		//DAO 호출 후 후처리 작업
		ActionFoward actionFoward = new ActionFoward();
		try {
		Connection con = DBConnector.getConnection();
		ArrayList<NoticeDTO> ar = noticeDAO.noticeList(con);
		con.close();
		request.setAttribute("list", ar);
		actionFoward.setFlag(true);
		actionFoward.setPath("./noticeList.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return actionFoward;
		
	}
	
	public ActionFoward selectOne(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		try {
		Connection con = DBConnector.getConnection();
		int num = Integer.parseInt(request.getParameter("num"));
		NoticeDTO noticeDTO = noticeDAO.noticeSelect(con, num);
		if(noticeDTO !=null) {
			request.setAttribute("dto", noticeDTO);
			actionFoward.setFlag(true);
			actionFoward.setPath("./noticeSelect.jsp");
		}else {
			actionFoward.setFlag(false);
			actionFoward.setPath("./noticeList.notice");
		}
		
		con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return actionFoward;
	}
	

}
