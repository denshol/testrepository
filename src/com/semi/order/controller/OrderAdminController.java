package com.semi.order.controller;

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
import com.semi.order.model.service.OrderService;
import com.semi.order.model.vo.Order;

>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
/**
 * Servlet implementation class orderController
 */
@WebServlet("/order.admin")
public class OrderAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
<<<<<<< HEAD
		request.getRequestDispatcher("views/admin_order/adminOrder.jsp").forward(request, response);
		
=======
//		ArrayList<Order> list = new OrderService().selectOrderAdmin();
//		
//		if(list.isEmpty()) {
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("views/admin_order/adminOrder.jsp").forward(request, response);
//		}else {
//			request.setAttribute("errorMsg", "주문내역 리스트 조회 실패");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//		}
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
