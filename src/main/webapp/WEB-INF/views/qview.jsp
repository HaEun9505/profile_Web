<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/titletext.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/question.js"></script>
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
							<form action="qModify" method="post" name="question_form">
							<input type="hidden" name="qnum" value="${contentDto.qnum }">
								<tr>
									<td><span class="content_text">MEMBER ID : </span></td>
									<td><input class="input_box" type="text" name="qid" value="${contentDto.qid }" readonly></td>
								</tr>
								<tr>
									<td><span class="content_text">NAME : </span></td>
									<td><input class="input_box" type="text" name="qname" value="${contentDto.qname }"></td>
								</tr>
								<tr>
									<td valign="top"><span class="content_text">QUESTION : </span></td>
									<td>
										<textarea class="questiontext" rows="5" cols="25" name="qcontent">${contentDto.qcontent }</textarea>
									</td>
								</tr>
								<tr>
									<td><span class="content_text">EMAIL : </span></td>
									<td><input class="input_box" type="eamil" name="qemail" value="${contentDto.qemail }"></td>
								</tr>
								<tr>
									<td><span class="content_text">JOINDATE : </span></td>
									<td><input class="input_box" type="eamil" name="qdate" value="${contentDto.qdate }" readonly></td>
								</tr>
									<!-- 로그인한 사람만 수정과 삭제가 보이게 만들기 -->
								<%
		                           String sid = (String) session.getAttribute("sid");  // 형변환 필요
		                           String qid = request.getAttribute("boardId").toString();   // Model에서 넘어온 값 빼기
                           
                            		if (sid == null) {
                            			sid = "GUEST";
                            		}
		                           if ((sid != null) && (sid.equals(qid)) || (sid.equals("admin")) ) {   // 앞이 참일 경우에만 뒤의 조건을 봄, 아이디가 admin일 경우 모두 다 수정삭제 가능
		                        %>
		                        <tr>
		                           <td colspan="2">
		                              <input class="button" type="button" value="Modify" onclick="boardCheck()"> &nbsp;&nbsp;
		                              <input class="button" type="button" value="Delete" onclick="location.href='delete?qnum='+${contentDto.qnum }">                         
		                           </td>
		                        </tr>
		                        <%
		                           }
		                        %>
								<tr>
									<td colspan="2" align="right">
										<input class="button" type="button" value="LIST" onclick="location.href='list'">
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