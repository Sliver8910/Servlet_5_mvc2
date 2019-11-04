package com.ruda.notice;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	
	public ActionFoward write(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
	
			String method = request.getMethod();
			
			
			if(method.equals("POST")) {
				try {
					Connection con = DBConnector.getConnection();
					NoticeDTO noticeDTO = new NoticeDTO();
					noticeDTO.setTitle(request.getParameter("title"));
					noticeDTO.setWriter(request.getParameter("writer"));
					noticeDTO.setContents(request.getParameter("contents"));
					
					
					int result = noticeDAO.noticeWrite(con, noticeDTO);
							con.close();
							String message = null;
							String path = null;
					if(result>0) {
						message = "Write Success";
					}else {
						message= "Write Fail";
					}
					actionFoward.setFlag(true);
					path = "./noticeList.notice";
					request.setAttribute("msg", message);
					request.setAttribute("path", path);
					actionFoward.setPath("../common/common_result.jsp");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}else {
				actionFoward.setFlag(true);
				actionFoward.setPath("./noticeWrite.jsp");
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
