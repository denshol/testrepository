<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../common/header.jsp" %>
<div class="container">
	<h1>카카오 로그인 추가정보 구성창</h1>
	<form action="/blog/oauth/kakao?cmd=joinProc" method="post" class="was-validated">
		<div class="form-group">
			<label for="username">username : </label> 
			<input value="${kakaoProfile.id }_kakao" type="text" class="form-control" id="username" placeholder="Enter username" name="username" required readonly="readonly">
		</div>
		<div class="form-group">
			<label for="email">email : </label> 
			<input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill in this field.</div>
		</div>
		
		<button type="submit" class="btn btn-primary">회원 가입 완료</button>
	</form>

</div>
<%@ include file = "../common/footer.jsp" %>