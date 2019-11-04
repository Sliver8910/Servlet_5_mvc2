<%@page import="com.ruda.notice.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	 ArrayList<NoticeDTO> ar = (ArrayList<NoticeDTO>)request.getAttribute("list");
	
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
	<div class="container">
		<table class="table "> 
			<thead>
				<tr><th class="th1">NUM</th><th class="th1">Title</th><th class="th1">Writer</th><th class="th1">Date</th><th class="th1">Hit</th></tr>
			</thead>
			<tbody>
				<%
					for(int i=0;i<ar.size();i++){
						NoticeDTO noticeDTO = ar.get(i); 
				%>
				<tr> 
					<td class="th1 num"><%=noticeDTO.getNum() %></td>
					<td><a href="./noticeSelect.notice?num=<%=noticeDTO.getNum()%>"><%=noticeDTO.getTitle() %></a></td>
					<td class="th1"><%=noticeDTO.getWriter() %></td>
					<td class="th1 date"><%=noticeDTO.getReg_date() %></td>
					<td class="th1 hit"><%=noticeDTO.getHit() %></td> 
				</tr> 
				<%} %>
			</tbody>
		
		
		</table>

	</div>

</body>
</html>