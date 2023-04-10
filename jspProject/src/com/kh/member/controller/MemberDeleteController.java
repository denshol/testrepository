package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		Member m = null;
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberService().deleteMember(userId,userPwd);
		
		HttpSession session = request.getSession();
		
		if(result>0) { //성공
			session.setAttribute("alertMsg", "회원탈퇴에 성공하였습니다.");
			session.removeAttribute("loginUser");  //로그인된 회원정보 삭
			response.sendRedirect(request.getContextPath());  // 메인 화면으로 재요청
		}else { //실패
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request ,response);
//			request.setAttribute("errorMsg", "회원탈퇴에 실패하였습니다.");
		}
		
		
		
		
		
	}

}
