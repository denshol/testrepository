package com.semi.board.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.board.review.model.dao.ReviewDao;
import com.semi.board.review.model.vo.Review;
import com.semi.common.JDBCTemplate;
import com.semi.event.point.model.service.PointService;

public class ReviewService {
	
	//댓글 작성
		public int insertReview(Review r) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new ReviewDao().insertReview(conn,r);
			
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}

		//댓글 목록 조회
		public ArrayList<Review> selectReview(int productNo) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			ArrayList<Review> rlist = new ReviewDao().selectReview(conn,productNo);
			
			JDBCTemplate.close(conn);
			
			return rlist;
		}
		
		//구매한 사람만 댓글버튼 보여주기
		public int rBtnCk(String productNo) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int count = new ReviewDao().rBtnCk(conn,productNo);
			
			JDBCTemplate.close(conn);
			
			return count;
		}

}
