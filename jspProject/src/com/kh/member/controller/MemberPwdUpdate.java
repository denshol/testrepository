package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberPwdUpdate
 */
@WebServlet("/updatePwd.me")
public class MemberPwdUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdate() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//hidden타입으로 숨겨서 보낸 데이터 id값 꺼내기
//		String userId = request.getParameter("userId");
		
		
		HttpSession session = request.getSession();
		//session에 담겨있는 loginUser에서 id값 꺼내기
		String userId = ((Member)session.getAttribute("loginUser")).getUserId();
		String updatePwd= request.getParameter("updatePwd");
		
		Member updateMem = new MemberService().updatePwd(userId,updatePwd);
		
		if(updateMem == null) { //수정 실패
			request.setAttribute("errorMsg", "비밀번호 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}else {
			session.setAttribute("alertMsg", "비밀번호 수정 완료. 변경된 비밀번호로 재로그인 해주세요.");
			session.setAttribute("loginUser", updateMem);
			session.removeAttribute("loginUser");
			//재요청 
			response.sendRedirect(request.getContextPath());
		}
		
		
		
		
		
		
		
	}

}
