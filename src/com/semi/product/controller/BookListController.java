package com.semi.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import com.google.gson.Gson;
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
import com.semi.common.vo.PageInfo;
import com.semi.product.model.service.ProductService;
import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class BookListController
 */
@WebServlet("/book.list")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		//페이징바 처리
=======
		
				//페이징바 처리
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
				int listCount; //현재 총 게시글의 개수
				int currentPage; //현재 페이지
				int pageLimit; //페이지 하단에 보여질 페이징바의 페이지 최대 개수
				int boardLimit; //한 페이지에 보여질 게시글 최대 개수
				
				int maxPage; //가장 마지막 페이지가 몇인지 (총 페이지 개수)
				int startPage; //페이지 하단에 보여질 페이징바의 시작수
				int endPage; //페이지 하단에 보여질 페이징바의 끝 수
				
<<<<<<< HEAD
				listCount = new ProductService().selectListCount();
				currentPage = Integer.parseInt(request.getParameter("currentPage").trim());
				pageLimit = 10;
				boardLimit = 8;
				
				maxPage = (int)Math.ceil((double)listCount/boardLimit);
				startPage = (currentPage-1)/pageLimit*pageLimit+1;
				endPage = startPage+pageLimit-1;
				
				if(endPage>maxPage) {
					endPage = maxPage;
				}
				
				PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
				
				//페이지에 보여질 게시글 리스트
				ArrayList<Product> list = new ProductService().selectAttachmentList(pi);
				
=======
				PageInfo pi = null;
				ArrayList<Product> list = null;
				String cate = request.getParameter("cate");

				if(cate==null) {//카테고리에 넘어온게 없으면
					
					listCount = new ProductService().selectListCount(); //전체 도서 목록 리스트 게시글 수
					currentPage = Integer.parseInt(request.getParameter("currentPage").trim());
					pageLimit = 10;
					boardLimit = 8;
					
					maxPage = (int)Math.ceil((double)listCount/boardLimit);
					startPage = (currentPage-1)/pageLimit*pageLimit+1;
					endPage = startPage+pageLimit-1;
					
					if(endPage>maxPage) {
						endPage = maxPage;
					}
					
					pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
					
					list = new ProductService().selectAttachmentList(pi);
					
				}else {//카테고리 클릭시
					
					listCount = new ProductService().selectCListCount(cate); //카테고리 목록 리스트 게시글 수
					currentPage = Integer.parseInt(request.getParameter("currentPage").trim());
					pageLimit = 10;
					boardLimit = 8;
					
					maxPage = (int)Math.ceil((double)listCount/boardLimit);
					startPage = (currentPage-1)/pageLimit*pageLimit+1;
					endPage = startPage+pageLimit-1;
					
					if(endPage>maxPage) {
						endPage = maxPage;
					}
					
					pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
					
					list = new ProductService().selectAttachmentCList(pi,cate);
				
				}

>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);

				request.getRequestDispatcher("views/product/bookList.jsp").forward(request, response);
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
				// TODO Auto-generated method stub
				doGet(request, response);
			}

		}
=======
				
	}
}
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
