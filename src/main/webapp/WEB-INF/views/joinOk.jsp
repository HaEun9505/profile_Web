<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/titletext.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
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
						<%
							int checkId = Integer.parseInt(request.getAttribute("checkId").toString());
							if(checkId == 0) {
						%>
							<span class="content_text">
								${mname }님 회원가입을 축하드립니다.<br>
								가입하신 아이디는 ${mid } 입니다.<br>
							</span>
						<%
							}else {
						%>
						<script type="text/javascript">
							//경고창 띄우기
							alert("가입하시려는 아이디는 이미 사용중입니다. 다른 아이디를 입력하세요.");
							history.go(-1);	//이전페이지로 돌려보냄
						
						</script>
						<%
							}
						%>
					</td>
				</tr>
			</table>
		</tr>	
	</table>
	</center>
	<%@ include file="include/footer.jsp" %>
</body>
</html>