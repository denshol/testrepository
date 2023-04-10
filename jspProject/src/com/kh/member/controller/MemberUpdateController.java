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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//변경된 정보 수정하기
			
			
			String userId = request.getParameter("userId");
			String userName = request.getParameter("userName");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String[] interests = request.getParameterValues("interest");
			
			String interest = "";
			
			if(interests != null) {
					interest = String.join(",", interests);
			}
			
			
			Member m = new Member(userId,userName,phone,email,address,interest);
			
			
//			updateMember.setUserPwd(userId);
//			updateMember.setUserName(userName);
//			updateMember.setPhone(phone);
//			updateMember.setEmail(email);
//			updateMember.setAddress(address);
//			updateMember.setInterest(interests);
			
			
			//service에게 요청전달
			Member updateMem = new MemberService().updateMember(m);
			//조회된 유저 정보객체를 담아주기
			
			//session에 담으려면 Session 객체를 먼저 가지고 와야한다
			HttpSession session = request.getSession();
			//수정 완료 후 성공시 정보변경 완료되었습니다. 알림메세지 후  마이페이지로 이동 (변경정보 적용) (재요청)
			//수정 완료 후 성공시 정보변경 완료되었습니다. 알림메세지 후 마이페이지로 이동 (변경정보 적용) (재요청)
			if(updateMem != null) { //updateMem이 null이 아니면 (조회결과가 있다면) - 성공
				session.setAttribute("alertMsg", "성공적으로 정보변경 되었습니다.");
				session.setAttribute("loginUser", updateMem);   // 동일 key값을 중복해서 쓴다면 갱신된다 덮어쓰기 like Map
				//루트 뒤에 마이페이지 요청 매핑주소 넣기
				response.sendRedirect(request.getContextPath()+"/myPage.me");
			}else { //없다면 실패
				//실패시 에러페이지로 포워딩 (위임)
				//응답페이지 jsp에 위임할때 필요한 객체 (RequestDispatcher)
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				request.setAttribute("errorMsg", "정보변경에 실패하였습니다.");
			}
		
		
		
	}

}
