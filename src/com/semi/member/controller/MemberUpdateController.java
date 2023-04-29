package com.semi.member.controller;

import java.io.IOException;
<<<<<<< HEAD
=======

>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
		request.getRequestDispatcher("views/member/updateProfile.jsp").forward(request, response);
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		
		//post 요청이기 때문에 인코딩 처리하기
		request.setCharacterEncoding("UTF-8");
		
		//변경된 정보 수정하기
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		
	}

=======
		request.setCharacterEncoding("UTF-8");

		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		String memberId = loginUser.getMemberId();
		String memberPwd = request.getParameter("memberPwd");
		
		if(memberPwd.isEmpty()) {
			memberPwd = loginUser.getMemberPwd();
		}
		
		String phone = request.getParameter("phone");
		
		if(phone.isEmpty()) {
			phone = loginUser.getPhone();
		}

		String email = request.getParameter("email");
		String dotCom = request.getParameter("dotCom");
		
		String memEmail = loginUser.getEmail();
		int sign = memEmail.indexOf("@");
		String emailAdd = loginUser.getEmail().substring(sign+1);
		
		if(dotCom == null) {
			email = email + "@" +emailAdd;
		}else {
			email = email + "@" + dotCom;
		}
		
		String birthYear = request.getParameter("birthYear");
		String birthMonth = request.getParameter("birthMonth");
		String birthDay = request.getParameter("birthDay");
		
		String memberBirth = "";
		
		if(Integer.parseInt(birthMonth)<10) {
			birthMonth="0"+(String)birthMonth;
		}else {
			birthMonth=(String)birthMonth;
		}
		if(Integer.parseInt(birthDay)<10) {
			birthDay= "0"+(String)birthDay;
		}else {
			birthDay= (String)birthDay;
		}
		
		memberBirth = birthYear+"/"+birthMonth+"/"+birthDay;
		
		Member m = new Member(memberId, memberPwd, memberBirth, phone, email);
		
		Member memUpdate = new MemberService().updateMember(m);
		
		HttpSession session = request.getSession();
		
		if(memUpdate != null) {
			session.setAttribute("alertMsg", "회원 정보가 수정되었습니다.");
			session.setAttribute("loginUser", memUpdate);
			response.sendRedirect(request.getContextPath()+"/myPage.me");
		}else {
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
}
