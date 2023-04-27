package loan.model;

public class Loan {

	private int LOAN_NO;
	private String LOAN_DATE;
	private String RETURN_DATE;
	private int RETURN_STATUS;
	private int EXTENDIBLE;
	private String EXTENDED_DATE;
	private int MEMBER_NO;
	private int BOOK_NO;
	private int AVAILABLE_STATUS;

	public Loan() {
	}

	public int getLOAN_NO() {
		return LOAN_NO;
	}

	public void setLOAN_NO(int LOAN_NO) {
		this.LOAN_NO = LOAN_NO;
	}

	public String getLOAN_DATE() {
		return LOAN_DATE;
	}

	public void setLOAN_DATE(String LOAN_DATE) {
		this.LOAN_DATE = LOAN_DATE;
	}

	public String getRETURN_DATE() {
		return RETURN_DATE;
	}

	public void setRETURN_DATE(String RETURN_DATE) {
		this.RETURN_DATE = RETURN_DATE;
	}

	public int getRETURN_STATUS() {
		return RETURN_STATUS;
	}

	public void setRETURN_STATUS(int RETURN_STATUS) {
		this.RETURN_STATUS = RETURN_STATUS;
	}

	public int getEXTENDIBLE() {
		return EXTENDIBLE;
	}

	public void setEXTENDIBLE(int EXTENDIBLE) {
		this.EXTENDIBLE = EXTENDIBLE;
	}

	public String getEXTENDED_DATE() {
		return EXTENDED_DATE;
	}

	public void setEXTENDED_DATE(String EXTENDED_DATE) {
		this.EXTENDED_DATE = EXTENDED_DATE;
	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public void setMEMBER_NO(int MEMBER_NO) {
		this.MEMBER_NO = MEMBER_NO;
	}

	public int getBOOK_NO() {
		return BOOK_NO;
	}

	public void setBOOK_NO(int BOOK_NO) {
		this.BOOK_NO = BOOK_NO;
	}

	public int getAVAILABLE_STATUS() {
		return AVAILABLE_STATUS;
	}

	public void setAVAILABLE_STATUS(int AVAILABLE_STATUS) {
		this.AVAILABLE_STATUS = AVAILABLE_STATUS;
	}

}
