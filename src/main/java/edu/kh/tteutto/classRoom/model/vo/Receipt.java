package edu.kh.tteutto.classRoom.model.vo;

public class Receipt {

	private int receiptNo;
	private String classNm;
	private String teacherNm;
	private String studentNm;
	private int price;
	private String calDate;
	
	public Receipt() {	}

	public String getClassNm() {
		return classNm;
	}

	public int getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public void setClassNm(String classNm) {
		this.classNm = classNm;
	}

	public String getTeacherNm() {
		return teacherNm;
	}

	public void setTeacherNm(String teacherNm) {
		this.teacherNm = teacherNm;
	}

	public String getStudentNm() {
		return studentNm;
	}

	public void setStudentNm(String studentNm) {
		this.studentNm = studentNm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCalDate() {
		return calDate;
	}

	public void setCalDate(String calDate) {
		this.calDate = calDate;
	}

	@Override
	public String toString() {
		return "Receipt [receiptNo=" + receiptNo + ", classNm=" + classNm + ", teacherNm=" + teacherNm + ", studentNm="
				+ studentNm + ", price=" + price + ", calDate=" + calDate + "]";
	}

	
}
