<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.notice.model.vo.Notice" %>
    
<%
    Notice n = (Notice)request.getAttribute("notice");
    
 %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>

        .outer{
            background-color: rebeccapurple;
            color: beige;
            margin: auto;
            margin-top:  50px;
            width: 1000px;
        }



        
        #update-form>table{border:1px solid white;}
        #update-form input,textarea{
        	width: 100%;
        	box-sizing : border-box;
        	
        }
        
    </style>
</head>
<body>
	<%@include file="../common/menubar.jsp" %>
	<div class="outer">
	

	<h2 align="center">공지사항 수정</h2>
	
	<form id="update-form" action="<%=contextPath%>/update.no" method="post">
		<input type="hidden" name="nno" value="<%=n.getNoticeNo() %>">
		<table align="center">
			
			<tr>
				<td width="50">제목</td>
				<td width="350"><input type="text" name="title" value="<%=n.getNoticeTitle() %>" required></td>
			</tr>
			<tr>
			  	<td>내용</td>
			  	<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" rows="10" cols="20" style="resize:none" required><%=n.getNoticeContent() %></textarea>
				</td>
			</tr>
		</table>
		<br><br>
		<div align="center">
		 	<button type="submit">수정하기</button>
		 	<button type="button" onclick="history.back();">뒤로가기</button>
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	</div>
</body>
</html>