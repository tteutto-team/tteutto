package edu.kh.tteutto.classRoom.model.vo;

public class Episode {

	private int epNo;
	private int epPrice;
	private int ClassNo;
	private int epSt;
	private int epCount;
	private String epPlace;
	private String classNm;
	
	public Episode() { }

	public int getEpNo() {
		return epNo;
	}

	public void setEpNo(int epNo) {
		this.epNo = epNo;
	}

	public int getEpPrice() {
		return epPrice;
	}

	public void setEpPrice(int epPrice) {
		this.epPrice = epPrice;
	}

	public int getClassNo() {
		return ClassNo;
	}

	public void setClassNo(int classNo) {
		ClassNo = classNo;
	}

	public int getEpSt() {
		return epSt;
	}

	public void setEpSt(int epSt) {
		this.epSt = epSt;
	}

	public int getEpCount() {
		return epCount;
	}

	public void setEpCount(int epCount) {
		this.epCount = epCount;
	}

	public String getEpPlace() {
		return epPlace;
	}

	public void setEpPlace(String epPlace) {
		this.epPlace = epPlace;
	}

	
	public String getClassNm() {
		return classNm;
	}

	public void setClassNm(String classNm) {
		this.classNm = classNm;
	}

	@Override
	public String toString() {
		return "Episode [epNo=" + epNo + ", epPrice=" + epPrice + ", ClassNo=" + ClassNo + ", epSt=" + epSt
				+ ", epCount=" + epCount + ", epPlace=" + epPlace + ", classNm=" + classNm + "]";
	}

}
