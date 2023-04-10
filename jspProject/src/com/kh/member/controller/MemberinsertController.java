package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberinsertMember
 */
@WebServlet ("/insert.me")
public class MemberinsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberinsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//넘겨받은 데이터 가공처리 후 service - dao 돌아오기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interests = request.getParameterValues("interest");
		String interest ="";
		
		if(interests != null) {
			interest = String.join(",", interests);
		}
		
		Member m = new Member(userId,userPwd,userName,phone,email,address,interest);
		
		//insert는 dml구문이니까 결과값이 처리된 행수 (int)로 넘어올것
		int result = new MemberService().insertMember(m);
		
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "회원가입을 환영합니다");
			response.sendRedirect(request.getContextPath());
			//성공시 index로 들어가서 (재요청) alertMsg로 회원가입을 환영합니다., 메세지 띄우기
		}else {
			
			//실패시 errorPage가서 (위임) 회원가입에 실패하였습니다 메세지 띄우기
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request , response);
		}
		
		
		
	}

}
