package com.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Payment;
=======
import com.google.gson.Gson;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
import com.semi.order.model.vo.Payment;
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d

/**
 * Servlet implementation class ShoppingListController
 */
@WebServlet("/shoppingList.me")
public class ShoppingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		ArrayList<Payment> list = new MemberService().selectShoppingList();
=======
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		int memNo = loginUser.getMemberNo();
		
		ArrayList<Payment> list = new MemberService().selectShoppingList(memNo);
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/member/myShoppingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		doGet(request, response);
=======
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		
		ArrayList<Payment> plist = new MemberService().selectModal(orderNo);
		
//		System.out.println(plist.get(0).getOrderNo());
//		if(plist.get(0).getOrderNo() == orderNo) {
//			System.out.println("같슈");
//		}
		
		response.setContentType("json/application; charset=UTF-8");
		Gson gson = new Gson();
		
		Payment p = null;
		if(plist.get(0).getOrderNo() == orderNo) {
			for(int i=0; i<plist.size(); i++) {
				p = plist.get(i);
			}
		}else {
			System.out.println("다시");
		}
		gson.toJson(p,response.getWriter());
		
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
	}

}
