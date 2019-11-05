<%@page import="com.ruda.notice.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 포맷에 관한  -->
<%@ taglib prefix="xml" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%
	ArrayList<NoticeDTO> ar = (ArrayList<NoticeDTO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/servlet_3_jsp/css/notice_all.css" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="../layout/nav.jsp"></c:import>
	<h1 class="title_n">NOTICE</h1>
	<div class="container">
		<table class="table ">
			<thead>
				<tr>
					<th class="th1">NUM</th>
					<th class="th1">Title</th>
					<th class="th1">Writer</th>
					<th class="th1">Date</th>
					<th class="th1">Hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="dto" varStatus="st">
					<!-- for문과 같은 효과  -->
					<tr>
						<td class="th1 num">${pageScope.dto.num}</td>
						<td><a href="./noticeSelect.notice?num=${pageScope.dto.num}">${pageScope.dto.title}</a></td>
						<td class="th1">${pageScope.dto.writer}</td>
						<td class="th1 date">${pageScope.dto.reg_date}</td>
						<td class="th1 hit">${pageScope.dto.hit}:st ${st.last}</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>

		<div>
			<c:forEach begin="1" end="10" var="i" varStatus="st">
				${pageScope.i} : ${st.begin}
			</c:forEach>
		</div>
		<!-- session member, memberDTO   -->
		<c:if test="${not empty sessionScope.member}">
			<!-- if문  -->
			<a class="btn btn-primary" href="./noticeWrite.notice">Write</a>
		</c:if>

	</div>

</body>
</html>