package member.view;

import java.util.Scanner;

import member.model.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);

	public MemberView() {

	}

	public int showMenu() {
		System.out.println("------- 도서대출 관리 프로그램 -------");
		System.out.println(" 0.종료  1.회원관리  2.도서관리 3.대출관리  ");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}

	public int showMemberMenu() {
		System.out.println("------- 회원 관리 프로그램 -------");
		System.out.println(" 0.종료  1.회원조회  2.회원등록  3.회원수정  4.회원삭제 ");
		int sel = sc.nextInt();
		return sel;
		
		
	}

	public Member registerMember() {
		Member member = new Member();

		System.out.println("번호를 입력하세요 : "); // SELECT
		member.setMEMBER_NO(sc.nextInt());

		System.out.println("이름을 입력하세요  : "); // SELCET
		member.setNAME(sc.next());

		System.out.println("주소를 입력하세요 : "); // SELECT
		member.setADDRESS(sc.next());

		System.out.println("전화번호를 입력하세요 : "); // SELECT
		member.setPHONE_NUMBER(sc.next());

		System.out.println("생일을 입력하세요  : "); // SELECT
		member.setBIRTH(sc.next());

		System.out.println("가입날짜를 입력하세요"); // SELECT
		member.setJOIN_DATE(sc.next());
		return member;
	}

	public int selectOneMember() {
		System.out.println("변경할 번호를 입력하세요 : ");
		return sc.nextInt();
	}

	public Member updateMember(Member member) {
		System.out.println("번호를 입력하세요: "); // SELECT
		member.setMEMBER_NO(sc.nextInt());

		System.out.println("이름을 입력하세요  : "); // SELCET
		member.setNAME(sc.next());

		System.out.println("주소를 입력하세요 : "); // SELECT
		member.setADDRESS(sc.next());

		System.out.println("전화번호를 입력하세요 : "); // SELECT
		member.setPHONE_NUMBER(sc.next());

		System.out.println("생일을 입력하세요  : "); // SELECT
		member.setBIRTH(sc.next());

		System.out.println("가입날짜를 입력하세요"); // SELECT
		member.setJOIN_DATE(sc.next());
		return member;
	}
}
