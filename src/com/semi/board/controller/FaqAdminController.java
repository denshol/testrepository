package com.semi.board.controller;

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
import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;

>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
/**
 * Servlet implementation class faqController
 */
@WebServlet("/faq.admin")
public class FaqAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
<<<<<<< HEAD
=======
		ArrayList<Board> list = new BoardService().selectFaqAdmin();
		
		request.setAttribute("list", list);
		
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
		request.getRequestDispatcher("views/admin_board/adminFaq.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
