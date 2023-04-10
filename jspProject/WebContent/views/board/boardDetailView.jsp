<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.*"%>
    
    <%
    
    	Board b = (Board)request.getAttribute("board");
    	AttachMent at = (AttachMent)request.getAttribute("attachment");
    	
    	
    %>
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

<style>
.outer{
    background-color: black;
    color: aliceblue;
   



}

    
</style>

</head>
<body>

	<%@include file = "../common/menubar.jsp" %>
    <div class="outer">
			<h2 align="center">일반게시판 상세보기</h2>
			<br><br>
        <table border="3"  align="center" border="1">
            <%--  --%>
            <%--  --%>
            <thead>
                <tr>
                    <th width="100">카테고리</th>   
                    <td width="100"><%=b.getCategory() %></td>
                    <th width="100">제목</th>
                    <td width="300"><%=b.getBoardTitle() %></td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>작성자</th>
                    <td><%=b.getBoardWriter() %></td>
                    <th>작성일</th>
                    <td><%=b.getCreateDate() %></td>
                </tr>
                <tr>
                    <th height="200">내용</th>
                    <td colspan="3"><%=b.getBoardContent() %></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
            		<th>첨부파일</th>
                    <td colspan="3">
                    <%if(at==null) { %>	
                    	첨부파일이 없습니다
            		<%}else{ %>
                        <a href="<%=contextPath + at.getFilePath()+"/"+at.getChangeName()%>"  download="<%=at.getOriginName()%>" ><%=at.getOriginName() %></a>
                        <%} %>
                    </td>
                </tr>
            </tfoot>
        </table>
            
        <br>
        <br>
        <%if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) {%>
        <div align="center">
        	<button onclick="location.href='<%=contextPath%>/update.bo?bno=<%=b.getBoardNo() %>'" class="btn btn-outline-warning">수정하기</button>
        	<button onclick="location.href='<%=contextPath%>/delete.bo?bno=<%=b.getBoardNo() %>'" class="btn btn-outline-danger">삭제하기</button>
        	<%-- <a href="<%=contextPath%>/delete.bo?bno=<%=b.getBoardNo() %>" class="btn btn-outline-danger">삭제하기</a> --%>
        
        </div> 
        <%} %>
        
        
        
        
        
        
        
    </div>
  </body>
</html>