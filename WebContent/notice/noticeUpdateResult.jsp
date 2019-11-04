<%@page import="com.ruda.util.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.ruda.notice.NoticeDAO"%>
<%@page import="com.ruda.notice.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	NoticeDTO noticeDTO = new NoticeDTO();
	NoticeDAO noticeDAO = new NoticeDAO();
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	int num = Integer.parseInt(request.getParameter("num"));
	
	noticeDTO.setTitle(title);
	noticeDTO.setWriter(writer);
	noticeDTO.setContents(contents);
	noticeDTO.setNum(num);
	
	Connection con = DBConnector.getConnection();
	
	int result = noticeDAO.noticeUpdate(con, noticeDTO);
	
	con.close();
	
	String message = null;
	
	if(result>0){
		message = "글 수정 성공";
		response.sendRedirect("./noticeList.jsp");
	}else{
		message = "해당하는 글이 없습니다";
		request.setAttribute("msg", message);
		request.setAttribute("path", "./noticeList.jsp");
		RequestDispatcher view = request.getRequestDispatcher("../common/common_result.jsp");
		view.forward(request, response);
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>