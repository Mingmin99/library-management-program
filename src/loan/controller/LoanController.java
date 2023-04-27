package loan.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import book.model.Book;
import book.model.dao.BookDao;
import loan.model.Loan;
import loan.model.dao.LoanDao;
import loan.view.LoanView;

public class LoanController {
	LoanView view;
	LoanDao dao;

	public LoanController() {
		super();
		view = new LoanView();
		dao = new LoanDao();
	}

	public void main(int MEMBER_NO) throws SQLException {

		while (true) {
			int sel = view.showLoanMenu();
			switch (sel) {
			case 0:
				// 뒤로가기

				return;
			// 대출이력 = loan
			case 1:
				loanAndReturnInfo();
				break;
			// 대출
			case 2:
				loanBook(MEMBER_NO);
				break;
			// 연장하기
			case 3:
				extendLoan(MEMBER_NO);
				break;

			// 반납하기
			case 4:
				returnLoan(MEMBER_NO);
				break;
			}
		}
	}

	private void extendLoan(int MEMBER_NO) throws SQLException {

		int memberno = view.LoanView();

		// 대출 테이블에 해당 멤버의 대여정보가 있는지 확인
		ArrayList<Loan> loan1 = dao.availableReturnInfo(memberno);

		// 해당 멤버에게 어떤 책을 연장할건지 답변을 받아옴
		int BOOK_NO = view.extendLoan(loan1);

		if (dao.extendLoan(BOOK_NO) > 0) {
			System.out.println("연장이 완료되었습니다.");
		} else {
			System.out.println("연장에 실패했습니다.");
		}

	}

// 도서대출
	private void loanBook(int BOOK_NO) throws SQLException {

		// 빌릴 수 있는 책 조회
		BookDao bookDao = new BookDao();
		ArrayList<Book> book1 = dao.availableBookInfo();

		int[] BOOK_NO1 = view.loanBook(book1);

		for (int i = 0; i < book1.size(); i++) {
			if (book1.get(i).getBOOK_NO() == (BOOK_NO1[1])) {
				dao.loanBook(BOOK_NO1[0], BOOK_NO1[1]);
				System.out.println("대출실행이 완료되었습니다.");
				break;

			}

		}

//		System.out.println("대출을 실패했습니다.");
		book1.clear();

	}

	// 해당회원의 대여 정보
	private void loanAndReturnInfo() {

		int MEMBER_NO = view.LoanView();
		ArrayList<Loan> list = dao.selectAllLoanBook(MEMBER_NO);
		System.out.println();
		System.out.println("NO\tMEMBER_NO\tBOOK_NO\tLOAN_DATE\tRETURN_DATE\tRETURN_STATUS\tEXTENDIBLE");

		// 대출이 하나도 없는 경우
		if (list.size() == 0) {
			System.out.println("대출내역이 존재하지 않습니다.");

		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getLOAN_NO() + "\t" + list.get(i).getMEMBER_NO() + "\t\t"
						+ list.get(i).getBOOK_NO() + "\t" + list.get(i).getLOAN_DATE().substring(0, 10) + "\t"
						+ list.get(i).getRETURN_DATE().substring(0, 10) + "\t\t" + list.get(i).getRETURN_STATUS() + "\t"
						+ list.get(i).getEXTENDIBLE());
			}
		}
		list.clear();

	}

	// 반납
	private void returnLoan(int MEMBER_NO) throws SQLException {

		int memberno = view.LoanView();

		// 대출 테이블에 해당 멤버의 대여정보가 있는지 확인
		ArrayList<Loan> loan1 = dao.availableReturnInfo(memberno);

		// 해당 멤버에게 어떤 책을 반납할건지 답변을 받아옴
		int[] LOAN_NO1 = view.updateReturn(loan1);

		for (int i = 0; i < loan1.size(); i++) {
			if (loan1.get(i).getBOOK_NO() == LOAN_NO1[1]) {
				dao.returnBook(LOAN_NO1[0], LOAN_NO1[1]);
				System.out.println("반납이 완료되었습니다.");
				break;
			}
		}
		loan1.clear();

//				System.out.println("대출을 실패했습니다.");

//		int BOOK_NO = view.updateReturn();
//		if (BOOK_NO > 0) {
//			System.out.println("반납이 완료되었습니다.");
//		} else {
//			System.out.println("반납에 실패했습니다.");
//		}

	}
}
