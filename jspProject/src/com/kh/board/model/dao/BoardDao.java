package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.AttachMent;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		String filePath = BoardDao.class.getResource("/sql/board/board-mapper.xml").getPath();
			try {
		
				prop.loadFromXML(new FileInputStream(filePath));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	//총 게시글 개수 구하는 메소드
	public int selectListCount(Connection conn) {
		int listCount = 0;
		ResultSet rset = null;
		
		Statement stmt = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(conn);
		}
		
		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Board> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			/*
			 * boardLimit (한페이지에 보여져야할 게시글개수)가 10일때
			 * currentPage : 1 - 시작값 : 1 - 끝값 : 10
			 * currentPage : 2 - 시작값 : 11 - 끝값 : 20
			 *
			 * 시작값은 (currentPage - 1) * boardLibit + 1
			 * 끝값 (시작값 + boardLimit) - 1
			 * */
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1; 
			int endRow = (startRow+pi.getBoardLimit()) - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO")
						 		   ,rset.getString("CATEGORY_NAME")
						 		   ,rset.getString("BOARD_TITLE")
						 		   ,rset.getString("USER_ID")
						 		   ,rset.getInt("COUNT")
						 		   ,rset.getDate("CREATE_DATE")));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		

		return list;
	}

	public ArrayList<Category> categoryList(Connection conn){
		ArrayList<Category> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("categoryList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Category(rset.getInt(1)
									 ,rset.getString(2)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	
	
	public int insertBoard(Connection conn, Board b) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, Integer.parseInt(b.getBoardWriter()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return result;
	}

	public int insertAttachMent(Connection conn, AttachMent at) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachMent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int increaseCount(Connection conn , int boardNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public Board selectBoard(Connection conn, int boardNo) {
		Board b = null;
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_NO")
						      ,rset.getString("CATEGORY_NAME")
							  ,rset.getString("BOARD_TITLE")
							  ,rset.getString("BOARD_CONTENT")
							  ,rset.getString("USER_ID")
							  ,rset.getDate("CREATE_DATE"));
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}

	//첨부파일 정보 조회
	public AttachMent selectAttachment(Connection conn, int boardNo) {
		AttachMent at = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
		
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new AttachMent(rset.getInt("FILE_NO")
								   ,rset.getString("ORIGIN_NAME")
								   ,rset.getString("CHANGE_NAME")
								   ,rset.getString("FILE_PATH"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
//		
//		 ,rset.getDate("UPLOAD_DATE")
//		   ,rset.getInt("FILE_LEVEL")
//		   ,rset.getString("STATUSA")
//		
		
		return at;
	}

	public int deleteBoard(Connection conn, int bno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	//게시글 수정 메소드
	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, b.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//기존파일 정보 수정하기
	public int updateAttachMent(Connection conn, AttachMent at) {
		int result = 0 ; 
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAttachMent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getFileNo());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//새로운 파일정보 넣기
	public int newInsertAttachMent(Connection conn, AttachMent at) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("newInsertAttachMent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, at.getRefNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
