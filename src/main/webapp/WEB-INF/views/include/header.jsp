<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css">
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
	<table width="100%" cellspacing="0" border="0" cellpadding="0">
		<tr height="50" bgcolor="#404040">
			<td width="30%">&nbsp;</td>
			<td class="header_menu">
				<a href="index">Home</a>
			</td>
			<td class="header_menu">
				<%
					//session값 가져오기(Controller에서 셋팅한 session 값)
					String sessionId = (String)session.getAttribute("sid");
					if(sessionId == null) {
				%>
				<a href="login">Login</a>
				<%
					}else {
				%>
				<a href="logout">Logout</a>
				<%
					}
				%>
			</td>
			<td class="header_menu">
				<%
					if(sessionId == null) {
				%>
				<a href="join">Join</a>
				<%
					}else {
				%>
				<a href="infoModify">Modify</a> <%-- 가입 성공하면 Modify로 바뀜 --%>
				<%
					}
				%>
			</td>
			<td class="header_menu">
				<a href="profile">Profile</a>
			</td>
			<td class="header_menu">
				<a href="question">Question</a>
			</td>
			<td class="header_menu">
				<a href="contact">Contact</a>
			</td>			
		</tr>
		<tr height="40"><!-- 여백 조절 -->
			<%
				//session 값 하나만 가져올때(문자열이므로 업캐스팅)
				//Controller에서 저장한 session값 가져오기
				String sname = (String)session.getAttribute("sname");
				if(sname != null) {
			%>
			<td colspan="8" align="right">			
				<span class="login_text"><b><%= sessionId %></b>님 로그인 중입니다.&nbsp;&nbsp;&nbsp;</span>
			</td>
			<%
				}
			%>
		</tr>
	</table>
</body>
</html>