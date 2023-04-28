package com.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.vo.PageInfo;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class memberSearchController
 */
@WebServlet("/searchMember.admin")
public class MemberSearchAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//select의 value값
		int num = Integer.parseInt(request.getParameter("ms_select"));
		
		//입력한 검색값
		String search = request.getParameter("memberSearch");
		
		int listCount; //총 게시글 개수
		int currentPage; // 현재 페이지
		int pageLimit; //페이징 바 최대 개수
		int boardLimit; // 한 페이지 게시글 최대 개수
		int maxPage; //마지막 페이지 
		int startPage; //페이징 바의 시작 수
		int endPage; // 페이징바의 마지막 수
		
		listCount = new MemberService().searchAdminCount(num,search);
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 10;
		boardLimit = 10;
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage-1)/pageLimit * pageLimit+1;
		endPage = startPage+pageLimit-1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		request.setAttribute("pi", pi);
		
		//select의 value값에 따른 반환값을 list에 담아주기
		ArrayList<Member> list = new ArrayList<>();
		
		list = new MemberService().searchIdAdmin(search,pi,num);
		
		if(list.isEmpty()) {
			request.getSession().setAttribute("alertMsg", "다시 입력해주세요");
			response.sendRedirect(request.getContextPath()+"/member.admin?currentPage=1");
			
		}else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/member.admin?currentPage=1").forward(request, response);
		}
	}

}
