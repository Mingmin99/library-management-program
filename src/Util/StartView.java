package Util;


import java.sql.Connection;
import java.sql.SQLException;

import book.controller.BookController;
import loan.controller.LoanController;
import member.controller.MemberController;
import member.view.MemberView;

public class StartView {
	
	Connection conn = JdbcUtil.getConnection(); // DBMS 연결용 객체
	MemberView view;
	MemberController memberController;
	BookController bookController;
	LoanController loanController;

	public StartView() {
		view = new MemberView();
		memberController = new MemberController();
		bookController = new BookController();
		loanController = new LoanController();

	}

	public void main() throws SQLException {

		while (true) {
			int sel = view.showMenu();
			switch (sel) {
			case 0:
				return;
			case 1:
				memberController.main();
				break;
			case 2:
				bookController.main();
				break;
			case 3:
				int MEMBER_NO = 0;
				loanController.main(MEMBER_NO);
			}
			break;

		}

	}

}
