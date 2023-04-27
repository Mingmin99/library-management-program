package book.controller;

import java.util.Scanner;

import member.controller.MemberController;

public class BookRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookController bookController = new BookController();

		// 처음 실행
		System.out.println("1.회원관리  2.도서관리  3대출  4.종료");
	
			
			switch (sc.nextInt()) {
			case 0:
				return;

			case 1:
				
				break;
			case 2:
				bookController.main();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				break;
			}

		}

	}

