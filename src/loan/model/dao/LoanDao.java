package loan.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Util.JdbcUtil;
import book.model.Book;
import loan.model.Loan;

public class LoanDao {

   Connection conn = JdbcUtil.getConnection(); // DBMS 연결용 객체
   Statement st = null; // SQL구문을 실행하고 결과를 받아오는 객체
   ResultSet rs = null; // SELECT실행 결과를 저장하는 객체
   ArrayList<Loan> list = new ArrayList<Loan>(); // 전체 도서정보를 저장할 객체
   ArrayList<Book> list2 = new ArrayList<Book>(); // 전체 도서정보를 저장할 객체
   
   

   // 내 대출 이력
   public ArrayList<Loan> selectAllLoanBook(int MEMBER_NO) {
      String query = "select * from LOAN where MEMBER_NO ='" + MEMBER_NO + "'";
      try {
         st=conn.createStatement();
         rs = st.executeQuery(query);
         while (rs.next()) {
            Loan loan = new Loan();
            loan.setLOAN_NO(rs.getInt("LOAN_NO"));
            loan.setMEMBER_NO(rs.getInt("MEMBER_NO"));
            loan.setBOOK_NO(rs.getInt("BOOK_NO"));
            loan.setLOAN_DATE(rs.getString("LOAN_DATE"));
            loan.setRETURN_DATE(rs.getString("RETURN_DATE"));
            loan.setRETURN_STATUS(rs.getInt("RETURN_STATUS"));
            loan.setEXTENDIBLE(rs.getInt("EXTENDIBLE"));

            list.add(loan);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   // 대출하기 (대출 테이블에 넣음) + BOOK 테이블 AVALABLE_STATE 0으로 변경
   public void loanBook(int MEMBER_NO, int BOOK_NO) throws SQLException {
   int result = 0;
   String query = "insert into LOAN(LOAN_NO,MEMBER_NO,BOOK_NO) values(LOAN_SEQ.nextval,'" + MEMBER_NO + "','" + BOOK_NO
         + "')";
   
   st = conn.createStatement();
   st.executeUpdate(query);
   
   
   String updatequery = "UPDATE BOOK SET AVAILABLE_STATUS= 0 WHERE BOOK_NO= "+BOOK_NO;
   st = conn.createStatement();
   st.executeUpdate(updatequery);
         
      
      
   }

   // 미반납인 도서 정보를 가져온다. => 내가 현재 대출한 책 정보들을 가지고 오는 것
   public ArrayList<Book> getBookInfo(int MEMBER_NO) {
      String query = "SELECT BOOK_NO, TITLE, AVAILABLE_STATUS " + "FROM BOOK " + "WHERE BOOK_NO = (SELECT BOOK_NO "
            + "FROM LOAN " + "WHERE LOAN.MEMBER_NO = " + MEMBER_NO + "  AND LOAN.RETURN_STATUS = 0)";
      try {
         st=conn.createStatement();
         rs = st.executeQuery(query);
         while (rs.next()) {
            Book book = new Book();
            Loan loan = new Loan();
            book.setBOOK_NO(rs.getInt("BOOK_NO"));
            book.setTITLE(rs.getString("TITLE"));
            book.setAVAILABLE_STATUS(rs.getInt("AVAILABLE_STATUS"));
            loan.setMEMBER_NO(rs.getInt("MEMBER_NO"));
            loan.setRETURN_STATUS(rs.getInt("RETURN_STATUS"));
            list2.add(book);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list2;
   }

   // 연장하기 상태 바꾸기
   public int extendLoan(int BOOK_NO) throws SQLException {
   int result = 0;
   
   String extendsql = "UPDATE LOAN SET EXTENDIBLE=0, RETURN_DATE = RETURN_DATE+7 WHERE BOOK_NO = "+BOOK_NO;
      
         
   // ;포함x
   st = conn.createStatement();
   result = st.executeUpdate(extendsql);
   return result;
   }
   
   
   
   // 반납하기 + 반납한 책 책 테이블에서 available_satatus 1로 변경
   public void returnBook(int MEMBER_NO, int BOOK_NO) throws SQLException {
      int result = 0;
      String query = "UPDATE LOAN SET RETURN_STATUS = 1 WHERE MEMBER_NO = " + MEMBER_NO + " AND BOOK_NO = " + BOOK_NO;

      st = conn.createStatement();
      st.executeUpdate(query);
      
      String updatequery="UPDATE BOOK SET AVAILABLE_STATUS = 1 WHERE BOOK_NO = "+BOOK_NO;
         
      st = conn.createStatement();
      st.executeUpdate(updatequery);
      
   }
   
   
   // 해당 멤버가 대여 목록에 있는지 확인
   public ArrayList<Loan> availableReturnInfo(int MEMBER_NO) {
      String query = "select * from LOAN where MEMBER_NO = "+MEMBER_NO;
      try {
         st=conn.createStatement();
         rs = st.executeQuery(query);
         while (rs.next()) {

            Loan loan = new Loan();
            loan.setLOAN_NO(rs.getInt("LOAN_NO"));
            loan.setMEMBER_NO(rs.getInt("MEMBER_NO"));
            loan.setBOOK_NO(rs.getInt("BOOK_NO"));
            loan.setLOAN_DATE(rs.getString("LOAN_DATE"));
            loan.setRETURN_DATE(rs.getString("RETURN_DATE"));
            loan.setRETURN_STATUS(rs.getInt("RETURN_STATUS"));
            loan.setEXTENDIBLE(rs.getInt("EXTENDIBLE"));
            

            list.add(loan);
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }
   
   //대출가능한 책 정보 
   public ArrayList<Book> availableBookInfo() {
      String query = "select * from BOOK where AVAILABLE_STATUS = '1' ";
      try {
         st=conn.createStatement();
         rs = st.executeQuery(query);
         while (rs.next()) {
            Book book = new Book();
            book.setBOOK_NO(rs.getInt("BOOK_NO"));
            book.setTITLE(rs.getString("TITLE"));
            book.setAUTHOR(rs.getString("Author"));
            book.setPUBLISHER(rs.getString("PUBLISHER"));
            book.setPUBLISH_DATE(rs.getString("PUBLISH_DATE"));
            book.setAVAILABLE_STATUS(rs.getInt("AVAILABLE_STATUS"));
            list2.add(book);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list2;
   }
   
   

}
