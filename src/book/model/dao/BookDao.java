package book.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Util.JdbcUtil;
import book.model.Book;

public class BookDao {

	Connection conn = JdbcUtil.getConnection();// DBMS 연결용 객체

	Statement st = null; // SQL구문을 실행하고 결과를 받아오는 객체
	ResultSet rs = null;
	ArrayList<Book> list = new ArrayList<Book>(); // 전체 회원정보를 저장할 객체

	public ArrayList<Book> seletAllBook() {
		String query = "select * from BOOK";
		try {
			// 4. 쿼리문전송
			// SELET를 수행하기 떄문에 executeQuery()메소드를 호출

			st = conn.createStatement();
			rs = st.executeQuery(query);
//			System.out.println("!1");

			// 5. 쿼리문 수행결과 저장
			// SELECT 수행결과는ResultSet 객체로 리턴

			// 4. 쿼리 결과를 처리
			while (rs.next()) {
				Book book = new Book();
				book.setBOOK_NO(rs.getInt("BOOK_NO"));
				book.setTITLE(rs.getString("TITLE"));
				book.setAUTHOR(rs.getString("Author"));
				book.setPUBLISHER(rs.getString("PUBLISHER"));
				book.setPUBLISH_DATE(rs.getString("PUBLISH_DATE"));
				book.setAVAILABLE_STATUS(rs.getInt("AVAILABLE_STATUS"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Book selectOneBook(int BOOK_NO) {
		Book book = new Book();
		String query = "select * from BOOK where BOOK_NO =" + BOOK_NO;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				book.setBOOK_NO(rs.getInt("BOOK_NO"));
				book.setTITLE(rs.getString("TITLE"));
				book.setAUTHOR(rs.getString("Author"));
				book.setPUBLISHER(rs.getString("PUBLISHER"));
				book.setPUBLISH_DATE(rs.getString("PUBLISH_DATE"));
				book.setAVAILABLE_STATUS(rs.getInt("AVAILABLE_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//도서등록 
	public int registerBook(Book book) {
		int result = 0;
		try {
			String query = "insert into Book values('" + book.getBOOK_NO() + "','" + book.getTITLE() + "','"
					+ book.getAUTHOR() + "','" + book.getPUBLISHER() + "','" + book.getPUBLISH_DATE() + "','"
					+ book.getAVAILABLE_STATUS() + "')"; // 쿼리문
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
	// 도서수정 
	public int updateBook(Book book, int BOOK_NO) {
		int result = 0;
		try {
			String query = "update BOOK set TITLE='" + book.getTITLE() + "',AUTHOR='" + book.getAUTHOR()
					+ "',PUBLISHER='" + book.getPUBLISHER() + "',PUBLISH_DATE='" + book.getPUBLISH_DATE()
					+ "',AVAILABLE_STATUS='" + book.getAVAILABLE_STATUS() + "' where BOOK_NO='" + BOOK_NO + "'"; // 쿼리문
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
		
	//도서삭제
	public int deleteBook(int BOOK_NO) {
		int result = 0;
		try {
			String query = "DELETE FROM BOOK WHERE BOOK_NO = '" + BOOK_NO + "'";
			st = conn.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
