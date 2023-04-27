package member.controller;

import java.util.ArrayList;
import member.model.Member;
import member.model.dao.MemberDao;
import member.view.MemberView;



//사용자로부터의 입력에 대한 응답으로 모델 및/또는 뷰를 업데이트하는 로직을 포함
public class MemberController {
	MemberView view;
	MemberDao dao;

	public MemberController() {
		
		view = new MemberView();
		dao = new MemberDao();

	}

	public void main() {
		while(true) {
			int sel = view.showMemberMenu();
			switch(sel) {
			case 0:
				dao.close();
				return;

			  case 1:
                  // 회원전체조회
                  printAllUser();
                  break;
              case 2:
                  // 회원가입
            	  registerMember();
                  break;
              case 3:
                  // 회원 정보 변경
                  updateMember();
                  break;
              case 4:
                  // 회원 탈퇴
                  deleteMember();
                  break;
                  
          }
          //close
		}
	}

	private void deleteMember() {
		int member = view.selectOneMember();
		dao.deleteMember(member);

		System.out.println("삭제가 완료되었습니다.");

	}

	private void updateMember() {
		int MEMBER_NO = view.selectOneMember();
		// 번호 찾기
		System.out.println("MEMBER_NO____"+MEMBER_NO);
		Member member = dao.selectOneMember(MEMBER_NO);
		System.out.println("member"+member);
		Member updateMember = view.updateMember(member);
		System.out.println("updateMember"+updateMember);
		// 회원정보변경
		dao.updateMember(updateMember, MEMBER_NO);
		System.out.println("sss");

	}

	private void registerMember() {
		Member member = view.registerMember();
		dao.registerMember(member);
	}
	
	
	//모든 회원 조회 
	private void printAllUser() {
		ArrayList<Member> list = dao.seletAllMember();
		System.out.println("NO\tNAME\tADDRESS\tPHONENUMBER\tBIRTH\t\tJOIN_DATE");
		if (list.size() == 0) {
			System.out.println("회원이 없음");
			// 회원이 한명도 없는경우
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getMEMBER_NO() + "\t" + list.get(i).getNAME() + "\t"
						+ list.get(i).getADDRESS() + "\t" + list.get(i).getPHONE_NUMBER() + "\t" + list.get(i).getBIRTH().substring(0,10)
						+ "\t" + list.get(i).getJOIN_DATE().substring(0,10));
			}
		}
		list.clear();
	}

}
