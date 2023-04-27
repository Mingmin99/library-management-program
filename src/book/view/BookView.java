package book.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import book.model.Book;
import member.model.Member;

public class BookView {

	Scanner sc = new Scanner(System.in);

	public BookView() {

	}

	public int showBookMenu() {

		System.out.println("--------도서  관리 프로그램 -------");
		System.out.println(" 0.종료  1.도서조회  2.도서등록  3.도서수정  4.도서삭제 ");
		System.out.println("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}

	public Book registerBook() {
		Book book = new Book();

		System.out.println("책번호를 입력하세요 : "); // SELECT
		book.setBOOK_NO(sc.nextInt());

		System.out.println("제목을 입력하세요  : "); // SELCET
		book.setTITLE(sc.next());

		System.out.println("저자를 입력하세요 : "); // SELECT
		book.setAUTHOR(sc.next());

		System.out.println("출판사를 입력하세요 : "); // SELECT
		book.setPUBLISHER(sc.next());

		System.out.println("출판일을 입력하세요  : "); // SELECT
		book.setPUBLISH_DATE(sc.next());

		book.setAVAILABLE_STATUS(1);
		return book;
	}

	public int selectOneBook() {
		System.out.println("변경할 책 번호를 입력하세요 : ");
		return sc.nextInt();
	}

	public Book updateBook(Book book) {
		System.out.println("책번호를 입력하세요 : "); // SELECT
		book.setBOOK_NO(sc.nextInt());

		System.out.println("제목을 입력하세요  : "); // SELCET
		book.setTITLE(sc.next());

		System.out.println("저자를 입력하세요 : "); // SELECT
		book.setAUTHOR(sc.next());

		System.out.println("출판사를 입력하세요 : "); // SELECT
		book.setPUBLISHER(sc.next());

		System.out.println("출판일을 압력하세요  : "); // SELECT
		book.setPUBLISH_DATE(sc.next());

		System.out.println("대출가능여부를 입력하세요 (1/0): "); // SELECT
		int AVAILABLE_STATUS = sc.nextInt();

		return book;
	}
}
