package com.kh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.AttachMent;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/betail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		//조회수 증가  / 게시글 조회 / 첨부파일 조회
		
		BoardService service = new BoardService();
		int result = service.increaseCount(boardNo);
		Board b = service.selectBoard(boardNo);
		AttachMent at = service.selectAttachMent(boardNo);
		
		
		
		if(result>0) {
//			System.out.println(b);
			request.setAttribute("board", b);
			request.setAttribute("attachment", at);
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "게시글 조회에 실패하였습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
	}

}
