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
	
	noticeDTO.setTitle(title);
	noticeDTO.setWriter(writer);
	noticeDTO.setContents(contents);
	
	Connection con = DBConnector.getConnection();
	
	int result = noticeDAO.noticeWrite(con, noticeDTO);
	
	con.close();
	
	
	if(result>0){
		response.sendRedirect("./noticeList.jsp");
	}else{
		String message = "Write Fail";
		request.setAttribute("msg", message);
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