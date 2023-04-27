package loan.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.model.Book;
import loan.model.Loan;
import member.model.Member;

public class LoanView {
	Scanner sc = new Scanner(System.in);

	public int showLoanMenu() {

		System.out.println("-------대출 관리 프로그램 -------");
		System.out.println("0.뒤로  1.대출이력  2.대출하기  3.연장하기  4.반납하기  ");
		System.out.println("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}

	public int LoanView() {
		System.out.println("대출이력을 볼 회원번호를 입력하세요");
		int MEMBER_NO = sc.nextInt();
		return MEMBER_NO;

	}
	// 대출이력코드가 없음

	public int[] loanBook(ArrayList<Book> list) {
		System.out.println("NO\tTITLE\tAUTHOR\tPUBLISHER\tPUBLISH_DATE\tAVAILABLE_STATUS");
		int[] temp = new int[2];
		if (list.size() == 0) {
			System.out.println("대출가능한 도서가 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getBOOK_NO() + "\t" + list.get(i).getTITLE() + "\t"
						+ list.get(i).getAUTHOR() + "\t" + list.get(i).getPUBLISHER() + "\t\t"
						+ list.get(i).getPUBLISH_DATE().substring(0, 10) + "\t" + list.get(i).getAVAILABLE_STATUS());
			}
		}
		System.out.print("회원번호와 대출 할 도서번호를 입력하세요 > ");
		temp[0] = sc.nextInt();
		temp[1] = sc.nextInt();

		return temp;
	}

	// 연장하기
	public int extendLoan(ArrayList<Loan> list) {
		System.out.println("NO\tMEMBER_NO\tBOOK_NO\tLOAN_DATE\tRETURN_DATE\tRETURN_STATUS\tEXTENDIBLE");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getLOAN_NO() + "\t" + list.get(i).getMEMBER_NO() + "\t\t"
					+ list.get(i).getBOOK_NO() + "\t" + list.get(i).getLOAN_DATE().substring(0, 10) + "\t"
					+ list.get(i).getRETURN_DATE().substring(0, 10) + "\t\t" + list.get(i).getRETURN_STATUS() + "\t"
					+ list.get(i).getEXTENDIBLE());
		}
		// 연장시 연장할 대출번호를 입력
		System.out.print("연장할 책번호를 입력하세요 > ");
		int BOOK_NO = sc.nextInt();
		return BOOK_NO;
		// extendible 를 0으로 업데이트 후에 end_date를 7늘린다.
	}
	// 반납하기

//	public int updateReturn() {
//		System.out.print("반납할 번호 입력하세요 > ");
//		int BOOK_NO = sc.nextInt();
//		return BOOK_NO;
//	}

	public int[] updateReturn(ArrayList<Loan> list) {
		int[] temp = new int[2];
		System.out.println("NO\tMEMBER_NO\tBOOK_NO\tLOAN_DATE\tRETURN_DATE\tRETURN_STATUS\tEXTENDIBLE");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getLOAN_NO() + "\t" + list.get(i).getMEMBER_NO() + "\t\t"
					+ list.get(i).getBOOK_NO() + "\t" + list.get(i).getLOAN_DATE().substring(0, 10) + "\t"
					+ list.get(i).getRETURN_DATE().substring(0, 10) + "\t\t" + list.get(i).getRETURN_STATUS() + "\t"
					+ list.get(i).getEXTENDIBLE());

		}
		System.out.print("회원번호의 반납 할 도서번호를 입력하세요 > ");
		temp[0] = sc.nextInt();
		temp[1] = sc.nextInt();

		return temp;
	}

}
