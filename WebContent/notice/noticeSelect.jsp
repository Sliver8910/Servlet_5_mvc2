<%@page import="com.ruda.notice.NoticeDTO"%>
<%@page import="com.ruda.util.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.ruda.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
NoticeDTO noticeDTO = (NoticeDTO)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/servlet_3_jsp/css/notice_all.css" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<h1 class="title_n">NOTICE</h1> 
	<div class="container" >
		<table class="table ">
			<thead>
				<tr>
					<th class="th1">Title</th><th class="th1">Writer</th><th class="th1">Date</th><th class="th1">Hit</th>
				</tr>
			</thead> 
			<tbody> 
				<tr>
					<td id="title1"><%=noticeDTO.getTitle() %></td><td class="th1"><%=noticeDTO.getWriter() %></td><td class="th1 date"><%=noticeDTO.getReg_date() %></td><td class="th1 hit"><%=noticeDTO.getHit() %></td>
				</tr>
				<tr>
					<td colspan="4"><div class="con1"><%=noticeDTO.getContents() %></div></td>
				</tr>
			</tbody>
		</table>
		
		<a href="./noticeList.notice" class="btn btn-primary">글목록</a>
	</div>

</body>
</html>