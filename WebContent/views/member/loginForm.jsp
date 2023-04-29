<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import ="com.semi.member.model.vo.Member"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        *{
       	font-size:13px;
       	font-weight:400px;
        
        }
        
        
        
        html,body{
        box-sizing:border-box;
        overflow:auto;
        }
        
        
        *:focus{
        outline: 2px solid  rgb(11, 95, 221);
        
    }
    
	.outer{
<<<<<<< HEAD
	
		
/* 	//line-height: 1.5em; */
		display : none;
=======
/* 	//line-height: 1.5em; */
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
        width: 1400px;
        /* border: 3px solid darkgray; */
        margin: auto;
        padding: 0 20px;
         margin-bottom: 20px; */
        height: 95%;
        margin-top: 20px;
        
	}
	
	.loginBox{
        padding-top: 30px;
        padding-bottom: 20px;
        width: 900px;
        margin: 30px auto;
        border: 3px solid #2c7dc9;
        border-radius: 50px;
        display: flex;
        flex-direction: column;   
        align-items: center;
        /* justify-content: center; */
        
        
        /* vertical-align: top; */
    }
   .outer button:not([type=submit]){
        /* margin: auto; */
        /* flex: 1; */
        padding: 20px;
        margin-bottom: 16px;
        width: 500px;
        /* font-size: x-large; */
        border-radius:30px;
    }
    .loginBox>input{
        width: 500px;
        padding: 30px;
        margin-bottom: 16px;
        margin-top: 0;
        border-radius:30px;
    }
     a{
        text-decoration: none;
        color: #222;
    }

    #memberPwd{
    background:url(./images/images2/icon-01.png) no-repeat center right 15px;
    background-size: 20px;
    background-color: #fff;
}
	
	.foot{
        padding: 50px;
        margin: auto;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding-top: 8px;
<<<<<<< HEAD
        padding-bottom:10px;
=======
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
    }
    
    .outer .btn{
     border-radius : 35px;
     font-size:large;
     font-weight : 400px;
     
    
    }
  
	
	
 
    
    
    </style>
    <title>회원가입</title>
 
</head>
<body>
	
	<%@ include file = "../common/header.jsp" %>
    <div class="outer">
	
        <form action="<%=contextPath%>/login.me" method="post">
          <%-- <a href="<%=contextPath%>">
            <img src="resources/사이트이름.png" alt="logo" class="logo">
          </a> --%>
          <div class="loginBox">
            <input type="text" name="memberId" placeholder="아이디를 입력해주세요">
            <input type="password" name="memberPwd" id="memberPwd" placeholder="비밀번호를 입력해주세요">
<<<<<<< HEAD
            <button type="submit" class="btn btn-primary" id="loginBtn"  style="padding:20px; margin-bottom: 16px; width: 500px;">로그인</button>
=======
            <button type="submit" class="btn btn-primary" id="loginBtn" style="padding:20px; margin-bottom: 16px; width: 500px;">로그인</button>
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
            <a href="<%=contextPath%>/searchid.me">아이디 </a> / <a href="<%=contextPath%>/searchpwd.me"> 비밀번호 찾기</a> 
          </div>
        

<<<<<<< HEAD
        <div class="foot" style="text-align:center;">
=======
        <div class="foot">
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d

              <button type="button" class ="btn btn-outline-primary" style="padding: 12px; " onclick="enrollPage();">회원가입</button>
              
              
              <button class="btn btn-outline-secondary" style="padding: 12px;">비회원 주문 조회</button>
              
<<<<<<< HEAD
              <a href="https://kauth.kakao.com/oauth/authorize?client_id=2524b0545c3c64102fa729ad66959efa&redirect_uri=http://localhost:8888/SemiProject/oauth/kakao?cmd=callback&response_type=code"
              style="display:block; width:500px; height:50px; border-radius:50px;"
              >
              <img src="resources/memberPage_files/iconFolder/kakao_login_large_wide.png" alt="카카오로그인"
                   style="display:flex; width:inherit; height:100%; border-radius:50px;">
              </a>
=======
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
        </div>



<<<<<<< HEAD
    </form>    
</div>
<script>
$(document).ready(function(){

	$(".outer")
	   	.css('opacity',0)
		.slideDown(650 ,'swing' )
		.animate(
		{ opacity : 1 }
		,{ queue : false , duration : 900}
		);
});

  
function enrollPage(){

//웹 애플리케이션의 디렉토리 구조가 그대로 url에 노출되어 보안에 취약해진다.
//단순 페이지 이동이여도 servlet을 거쳐서 매핑값이 노출되어 갈수있도록 작업하기.

location.href ="'<%=contextPath%>/enrollForm.me'";
	
}
</script>
		<%@ include file = "../common/footer.jsp"%>
=======
        </form>    
    </div>
    <script>
    function enrollPage(){
		//location.href = "<%=contextPath%>/semiViews/member/memberEnrollForm.jsp";
		//웹 애플리케이션의 디렉토리 구조가 그대로 url에 노출되어 보안에 취약해진다.
		//단순 페이지 이동이여도 servlet을 거쳐서 매핑값이 노출되어 갈수있도록 작업하기.
		
		location.href ="<%=contextPath%>/enrollForm.me";
		
	}
    </script>
       <%@ include file = "../common/footer.jsp"%>
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
</body>
</html>