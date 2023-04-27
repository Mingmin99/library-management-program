package member.model;

import java.util.Date;

public class Member {

	private int MEMBER_NO;
	private String NAME;
	private String ADDRESS;
	private String PHONE_NUMBER;
	private String BIRTH;
	private String JOIN_DATE;

	public Member() {
	}

	public Member(int MEMBER_NO, String NAME, String ADDRESS, String PHONE_NUMBER, String BIRTH, String JOIN_DATE) {
		super();
		this.MEMBER_NO = MEMBER_NO;
		this.NAME = NAME;
		this.ADDRESS = ADDRESS;
		this.PHONE_NUMBER = PHONE_NUMBER;
		this.BIRTH = BIRTH;
		this.JOIN_DATE = JOIN_DATE;

	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public void setMEMBER_NO(int MEMBER_NO) {
		this.MEMBER_NO = MEMBER_NO;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String ADDRESS) {
		this.ADDRESS = ADDRESS;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String PHONE_NUMBER) {
		this.PHONE_NUMBER = PHONE_NUMBER;
	}

	public String getBIRTH() {
		return BIRTH;
	}

	public void setBIRTH(String BIRTH) {
		this.BIRTH = BIRTH;
	}

	public String getJOIN_DATE() {
		return JOIN_DATE;
	}

	public void setJOIN_DATE(String JOIN_DATE) {
		this.JOIN_DATE = JOIN_DATE;
	}

}