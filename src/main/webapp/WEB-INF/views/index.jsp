<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/titletext.css">
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
			<table width="75%" cellspacing="0" border="0" cellpadding="20">
				<tr>
					<td bgcolor="#f5d6eb"><span class="index_skill01">J</span><span class="index_skill02">AVA</span></td>
					<td align="center" rowspan="6" bgcolor="#e6ccff"><img class="index_img" src="${pageContext.request.contextPath }/resources/img/flower.jpg"></td>
				</tr>
				<tr>
					<td bgcolor="#f5d6eb"><span class="index_skill01">J</span><span class="index_skill02">SP</span></td>
				</tr>
				<tr>
					<td bgcolor="#f5d6eb"><span class="index_skill01">S</span><span class="index_skill02">PRING</span></td>
				</tr>
				<tr>
					<td bgcolor="#f5d6eb"><span class="index_skill01">J</span><span class="index_skill02">AVASCRIPT</span></td>
				</tr>
				<tr>
					<td bgcolor="#f5d6eb"><span class="index_skill01">H</span><span class="index_skill02">TML5</span></td>
				</tr>
				<tr>
					<td bgcolor="#f5d6eb"><span class="index_skill01">D</span><span class="index_skill02">ATABASE</span></td>
				</tr>
			</table>
		</tr>	
	</table>
	</center>
	<%@ include file="include/footer.jsp" %>
</body>
</html>