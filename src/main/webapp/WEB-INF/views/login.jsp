<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/titletext.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/login.js"></script>
<meta charset="UTF-8">
<title>Profile Web</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<center>
	<!-- cellspacing : 셀 간의 간격, cellpadding: 셀과 글자 사이의 간격 -->
	<table width="70%" cellspacing="0" border="0" cellpadding="10">
		<tr>
			<td align="center">
				<!-- class 선택자명 -->
				<span class="index_title01">HaEun's Profile</span>
			</td>	
		</tr>
		<tr>
			<td align="center">
				<span class="index_title02">I'm HaEun Jo. Please call me back.</span>
			</td>
		</tr>
		<tr>
			<table width="70%" cellspacing="0" border="0" cellpadding="10">
				<tr height="534">
					<td bgcolor="#f5d6eb" align="center">
						<table border="0" cellspacing="0" cellpadding="10">
							<form action="loginOk" method="post" name="login_form">
								<tr>
									<td><span class="content_text">MEMBER ID : </span></td>
									<td><input class="input_box" type="text" name="mid"></td>
								</tr>
								<tr>
									<td><span class="content_text">PASSWORD : </span></td>
									<td><input class="input_box" type="password" name="mpw"></td>
								</tr>
								<tr>
									<td colspan="2">
										<input class="button" type="button" value="LOGIN" onclick="loginCheck()">&nbsp;&nbsp;
										<input class="button" type="button" value="SIGNUP" onclick="location.href='join'">
									</td>
								</tr>
							</form>
						</table>
					</td>
				</tr>
			</table>
		</tr>	
	</table>
	</center>
	<%@ include file="include/footer.jsp" %>
</body>
</html>