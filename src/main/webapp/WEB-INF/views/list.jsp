<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/titletext.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/qlist.css">
<meta charset="UTF-8">
<title>Profile Web</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<center>
	<!-- cellspacing : 셀 간의 간격, cellpadding: 셀과 글자 사이의 간격 -->
	<table width="75%" cellspacing="0" border="0" cellpadding="20">
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
						<table width="85%" border="0" cellspacing="0" cellpadding="10">
							<tr>
								<td class="board_title">NO</td>
								<td class="board_title">ID</td>
								<td class="board_title" width="40%">QUESTION</td>
								<td class="board_title">NAME</td>
								<td class="board_title">DATE</td>
							</tr>
							<tr>
								<td class="board_content">1</td>
								<td class="board_content">tiger</td>
								<td class="board_content"><a href="#" style="color:black;">안녕하세요!!!</a></td>
								<td class="board_content">홍길동</td>
								<td class="board_content">2022-05-13 02:24</td>
							</tr>
							<tr>
								<td class="board_content">1</td>
								<td class="board_content">tiger</td>
								<td class="board_content"><a href="#" style="color:black;">안녕하세요!!!</a></td>
								<td class="board_content">홍길동</td>
								<td class="board_content">2022-05-13 02:24</td>
							</tr>
							<tr>
								<td class="board_content">1</td>
								<td class="board_content">tiger</td>
								<td class="board_content"><a href="#" style="color:black;">안녕하세요!!!</a></td>
								<td class="board_content">홍길동</td>
								<td class="board_content">2022-05-13 02:24</td>
							</tr>
							
							<tr>
								<td colspan="5" align="right">
									<input class="button" type="button" value="WRITE" onclick="location.href='question'">
								
								</td>
							</tr>
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