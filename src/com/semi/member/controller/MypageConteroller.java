package com.semi.member.controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.ArrayList;

>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Coupon;
import com.semi.member.model.vo.Member;


>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
/**
 * Servlet implementation class MypageConteroller
 */
@WebServlet("/myPage.me")
public class MypageConteroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageConteroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
=======
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		int memNo = loginUser.getMemberNo();
		
		ArrayList<Coupon> clist = new MemberService().selectCoupon(memNo);
		
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
		
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		doGet(request, response);
=======
		//doGet(request, response);
		
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
	}

}
