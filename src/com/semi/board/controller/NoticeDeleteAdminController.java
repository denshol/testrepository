package com.semi.board.controller;

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
import com.semi.board.model.service.BoardService;

>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
/**
 * Servlet implementation class NoticeDeleteAdminController
 */
@WebServlet("/deleteNotice.admin")
public class NoticeDeleteAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		
		
=======

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		int result = new BoardService().deleteNoticeAdmin(bno);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "공지사항 삭제 완료");
			response.sendRedirect(request.getContextPath()+"/notice.admin");
		}else {
			request.setAttribute("errorMsg", "공지사항 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
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
