package book.model;

public class Book {
	private int BOOK_NO;
	private String TITLE;
	private String AUTHOR;
	private String PUBLISHER;
	private String PUBLISH_DATE;
	private int AVAILABLE_STATUS;

	public Book() {
	}

	public Book(int BOOK_NO, String TITLE, String AUTHOR, String PUBLISHER, String PUBLISH_DATE,
			int AVAILABLE_STATUS) {
		super();
		this.BOOK_NO = BOOK_NO;
		this.TITLE = TITLE;
		this.AUTHOR = AUTHOR;
		this.PUBLISHER = PUBLISHER;
		this.PUBLISH_DATE = PUBLISH_DATE;
		this.AVAILABLE_STATUS = AVAILABLE_STATUS;

	}

	public int getBOOK_NO() {
		return BOOK_NO;
	}

	public void setBOOK_NO(int BOOK_NO) {
		this.BOOK_NO = BOOK_NO;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}

	public String getAUTHOR() {
		return AUTHOR;
	}

	public void setAUTHOR(String AUTHOR) {
		this.AUTHOR = AUTHOR;
	}

	public String getPUBLISHER() {
		return PUBLISHER;
	}

	public void setPUBLISHER(String PUBLISHER) {
		this.PUBLISHER = PUBLISHER;
	}

	public String getPUBLISH_DATE() {
		return PUBLISH_DATE;
	}

	public void setPUBLISH_DATE(String PUBLISH_DATE) {
		this.PUBLISH_DATE = PUBLISH_DATE;
	}

	public int getAVAILABLE_STATUS() {
		return AVAILABLE_STATUS;
	}

	public void setAVAILABLE_STATUS(int AVAILABLE_STATUS) {
		this.AVAILABLE_STATUS = AVAILABLE_STATUS;
	}

}
