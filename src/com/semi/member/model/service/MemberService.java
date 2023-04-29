package com.semi.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.common.JDBCTemplate;
<<<<<<< HEAD
import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Member;
import com.semi.member.model.vo.Payment;
=======
import com.semi.common.vo.PageInfo;
import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Coupon;
import com.semi.member.model.vo.Member;
import com.semi.order.model.vo.Payment;
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d

public class MemberService {


	public Member loginMember(String memberId, String memberPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().loginMember(conn,memberId,memberPwd);
		
		//조회는 commit  / rollback 할필요 x
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	public int checkId(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int idCheck = new MemberDao().checkId(conn,memberId);
		
		JDBCTemplate.close(conn);
				
		
		
		return idCheck;
	}
	
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	public String selectId(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		
		String srcIdM = new MemberDao().selectId(conn,m);
		
		
		
		JDBCTemplate.close(conn);
		return srcIdM;
	}
	
	public Member searchPwd(Member srcPwdM) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member pwdM = new MemberDao().searchPwd(conn,srcPwdM);
		
		 
		
		
		
		JDBCTemplate.close(conn);
		return pwdM;
	}
	
<<<<<<< HEAD
	public ArrayList<Payment> selectShoppingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Payment> list = new MemberDao().selectShoppingList(conn);
		
		JDBCTemplate.close(conn);

		
		return list;
	}
	
	//회원 관리 조회
	public ArrayList<Member> selectMemberAdmin() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectMemberAdmin(conn);
=======
	//총 회원 수
	public int selMemberAdminCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new MemberDao().selMemberAdminCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	//상세 검색 회원 수
	public int searchAdminCount(int num, String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new MemberDao().searchAdminCount(conn,num,search);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	//회원 관리 조회
	public ArrayList<Member> selectMemberAdmin(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectMemberAdmin(conn,pi);
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	//회원 상세조회
	public Member detailMemberAdmin(int umno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().detailMemberAdmin(conn,umno);
		
		JDBCTemplate.close(conn);
				
		return m;
	}
	
<<<<<<< HEAD
	//아이디로 검색
	public ArrayList<Member> searchIdAdmin(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchIdAdmin(conn,search);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//이름으로 검색
	public ArrayList<Member> searchNameAdmin(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchNameAdmin(conn,search);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//생년월일로 검색
	public ArrayList<Member> searchBirthAdmin(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchBirthAdmin(conn,search);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//전화번호로 검색
	public ArrayList<Member> searchPhoneAdmin(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchPhoneAdmin(conn,search);
		
		JDBCTemplate.close(conn);
		
		return list;		
	}

	//이메일로 검색
	public ArrayList<Member> searchEmailAdmin(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchEmailAdmin(conn,search);
		
		JDBCTemplate.close(conn);
		
		return list;	
	}

	//주소로 검색
	public ArrayList<Member> searchAddressAdmin(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchAddressAdmin(conn,search);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//회원등급으로 검색
	public ArrayList<Member> searchGradeAdmin(String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchGradeAdmin(conn,search);
=======
	//회원 상세검색
	public ArrayList<Member> searchIdAdmin(String search, PageInfo pi, int num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().searchIdAdmin(conn,search,pi,num);
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//회원 수정
	public int updateMemberAdmin(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMemberAdmin(conn,m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//회원 삭제
	public int deleteMemberAdmin(int delMno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMemberAdmin(conn,delMno);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
<<<<<<< HEAD
=======
	
	//쿠폰 조회
	public ArrayList<Coupon> selectCoupon(int memNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Coupon> clist = new MemberDao().selectCoupon(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return clist;
	}
	
	//주문 조회
	public ArrayList<Payment> selectShoppingList(int memNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Payment> list = new MemberDao().selectShoppingList(conn,memNo);
		
		JDBCTemplate.close(conn);

		
		return list;
	}
	
	//주문 상세 조회 모달
	public ArrayList<Payment> selectModal(int orderNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Payment> plist = new MemberDao().selectModal(conn,orderNo);

		JDBCTemplate.close(conn);
		
		return plist;
	}
	
	//회원 탈퇴
	public int deleteMember(String loginId, String loginPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, loginId, loginPwd);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	//회원 정보 수정
	public Member updateMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn,m);
		
		Member memUpdate = null;
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			memUpdate = new MemberDao().selectMember(conn,m.getMemberId());
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return memUpdate;
	}
	
	//회원 주소 수정
		public Member updateAddress(String memberId, String address) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new MemberDao().updateAddress(conn,memberId, address);
			
			Member updateAddr = null;
			
			if(result>0) {
				JDBCTemplate.commit(conn);
				updateAddr = new MemberDao().selectMember(conn,memberId);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return updateAddr;
		}
>>>>>>> 3873b6c695f5c7fca6f249ff83c5e079ae12780d
}
