package member.controller;

import java.util.Scanner;

public class MemberRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberController memberController = new MemberController();

		// 처음 실행
		System.out.println("1.회원관리  2.도서관리  3대출  4.종료");
	
			
			switch (sc.nextInt()) {
			case 0:
				return;

			case 1:
				memberController.main();
				break;
			case 2:

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

