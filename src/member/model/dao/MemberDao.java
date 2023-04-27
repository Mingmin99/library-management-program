package member.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Util.JdbcUtil;
import member.model.Member;

//DB관련 코드
//DB에 접근하는 요청이 있다면 여기에서 처리
public class MemberDao {
	Connection conn = JdbcUtil.getConnection(); // DBMS 연결용 객체
	Statement st; // SQL구문을 실행하고 결과를 받아오는 객체
	ResultSet rs; // SELECT실행 결과를 저장하는 객체
	ArrayList<Member> list = new ArrayList<Member>(); // 전체 회원정보를 저장할 객체

	
//	pstmt = conn.prepareStatement(selectsql);
//	rs = pstmt.executeQuery();

	
	
	// 모든 회원을 조회하여 배열에 넣는 
	
	public ArrayList<Member> seletAllMember() {
		String query = "select * from MEMBER"; // 쿼리문 작성시 ;포함x
		try {
			// 4. 쿼리문전송
			// SELET를 수행하기 떄문에 executeQuery()메소드를 호출
			st=conn.createStatement();
			rs = st.executeQuery(query);
//			System.out.println("!1");
			// 5. 쿼리문 수행결과 저장
			// SELECT 수행결과는ResultSet 객체로 리턴

			// 4. 쿼리 결과를 처리
			while (rs.next()) {
				Member member = new Member();

				member.setMEMBER_NO(rs.getInt("MEMBER_NO"));
				member.setNAME(rs.getString("NAME"));
				member.setADDRESS(rs.getString("ADDRESS"));
				member.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
				member.setBIRTH(rs.getString("BIRTH"));
				member.setJOIN_DATE(rs.getString("JOIN_DATE"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Member selectOneMember(int MEMBER_NO) {
		Member member = new Member();
		String query = "select * from Member where MEMBER_NO = "+MEMBER_NO;
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				member.setMEMBER_NO(rs.getInt("MEMBER_NO"));
				member.setNAME(rs.getString("NAME"));
				member.setADDRESS(rs.getString("ADDRESS"));
				member.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
				member.setBIRTH(rs.getString("BIRTH"));
				member.setJOIN_DATE(rs.getString("JOIN_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	//회원등록
	
	public int registerMember(Member member) {
		int result = 0;
		try {
			String query = "insert into Member values('" + member.getMEMBER_NO() + "','" + member.getNAME() + "','"
	                + member.getADDRESS() + "','" + member.getPHONE_NUMBER() + "','" + member.getBIRTH() + "','"
	                + member.getJOIN_DATE() + "')"; // 쿼리문
			// ;포함x

			st = conn.createStatement();
			result = st.executeUpdate(query);
			conn.setAutoCommit(false); // 자동 커밋 해제
			if (result > 0) {
				// 성공한 경우(적용된 행의 갯수가 0개보다 크면)
				conn.commit();
			} else {
				// 실패한 경우(작용된 행의 갯수가 0이면)
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//회원수정
	
	public int updateMember(Member member, int MEMBER_NO) {
		int result = 0;
		try {
			String query = "update MEMBER set NAME='" + member.getNAME() + "',ADDRESS='" + member.getADDRESS()
					+ "',PHONE_NUMBER='" + member.getPHONE_NUMBER() + "',BIRTH='" + member.getBIRTH() + "',JOIN_DATE='"
					+ member.getJOIN_DATE() + "' where MEMBER_NO='" + MEMBER_NO + "'"; // 쿼리문
			// ;포함x
			st = conn.createStatement();
			result = st.executeUpdate(query);
			conn.setAutoCommit(false); // 자동 커밋 해제
			if (result > 0) {
				// 성공한 경우(적용된 행의 갯수가 0개보다 크면)
				conn.commit();
			} else {
				// 실패한 경우(작용된 행의 갯수가 0이면)
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//회원삭제 
	public int deleteMember(int MEMBER_NO) {
		int result = 0;
		try {
			String query = "delete from MEMBER where MEMBER_NO =" +MEMBER_NO;
			st = conn.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void close() {
		try {
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
