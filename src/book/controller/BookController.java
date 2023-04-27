package book.controller;

import java.util.ArrayList;

import book.model.Book;
import book.model.dao.BookDao;
import book.view.BookView;

//사용자로부터의 입력에 대한 응답으로 모델 및/또는 뷰를 업데이트하는 로직을 포함
public class BookController {
	BookView view;
	BookDao dao;

	public BookController() {

		view = new BookView();
		dao = new BookDao();

	}

	public void main() {
		while (true) {
			int sel = view.showBookMenu();
			switch (sel) {
			case 0:
				dao.close();
				return;

			case 1:
				//전체도서조회 
				printAllBook();
				break;
			case 2:
				// 책 등록 
				registerBook();
				break;
			case 3:
				//책 수정 
				updateBook();
				break;
			case 4:
				// 책 삭제 
				deleteBook();
				break;

			}
			// close
		}
	}

	private void deleteBook() {
		int book = view.selectOneBook();

		dao.deleteBook(book);
		System.out.println("삭제가 완료되었습니다.");

	}

	private void updateBook() {
		int BOOK_NO = view.selectOneBook();
		// 번호 찾기
		Book book = dao.selectOneBook(BOOK_NO);
		Book updateBook = view.updateBook(book);
		// 회원정보변경
		dao.updateBook(updateBook, BOOK_NO);

	}

	private void registerBook() {
		Book book = view.registerBook();
		dao.registerBook(book);
	}
	
	//도서 목록 전체 조회 
	private void printAllBook() {
		ArrayList<Book> list = dao.seletAllBook();
		System.out.println("NO\tTITLE\tAUTHOR\tPUBLISHER\tPUBLISH_DATE\tAVAILABLE_STATUS");
		if (list.size() == 0) {
			System.out.println("도서 없음");
			// 회원이 한명도 없는경우
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getBOOK_NO() + "\t" + list.get(i).getTITLE() + "\t"
						+ list.get(i).getAUTHOR() + "\t" + list.get(i).getPUBLISHER() + "\t\t"
						+ list.get(i).getPUBLISH_DATE().substring(0,10) + "\t" + list.get(i).getAVAILABLE_STATUS());
			}
		}
		list.clear();
	}

}
