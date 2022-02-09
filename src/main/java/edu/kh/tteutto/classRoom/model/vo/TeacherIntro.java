package edu.kh.tteutto.classRoom.model.vo;

public class TeacherIntro {

	// 강사 sns 조회
	private int snsNo;
	private String snsLink;
	private int memberNo;
	private int snsDiv;
	private String snsId;
	
	// 강사 테이블
	private String teacherImg;
	private String teacherIntro;
	private String teacherReqDt;
	private String teacherStatus;
	
	//회원 테이블
	private String memberNm;
	
	public TeacherIntro() {
		// TODO Auto-generated constructor stub
	}

	public int getSnsNo() {
		return snsNo;
	}

	public void setSnsNo(int snsNo) {
		this.snsNo = snsNo;
	}

	public String getSnsLink() {
		return snsLink;
	}

	public void setSnsLink(String snsLink) {
		this.snsLink = snsLink;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getSnsDiv() {
		return snsDiv;
	}

	public void setSnsDiv(int snsDiv) {
		this.snsDiv = snsDiv;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public String getTeacherImg() {
		return teacherImg;
	}

	public void setTeacherImg(String teacherImg) {
		this.teacherImg = teacherImg;
	}

	public String getTeacherIntro() {
		return teacherIntro;
	}

	public void setTeacherIntro(String teacherIntro) {
		this.teacherIntro = teacherIntro;
	}

	public String getTeacherReqDt() {
		return teacherReqDt;
	}

	public void setTeacherReqDt(String teacherReqDt) {
		this.teacherReqDt = teacherReqDt;
	}

	public String getTeacherStatus() {
		return teacherStatus;
	}

	public void setTeacherStatus(String teacherStatus) {
		this.teacherStatus = teacherStatus;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	@Override
	public String toString() {
		return "TeacherIntro [snsNo=" + snsNo + ", snsLink=" + snsLink + ", memberNo=" + memberNo + ", snsDiv=" + snsDiv
				+ ", snsId=" + snsId + ", teacherImg=" + teacherImg + ", teacherIntro=" + teacherIntro
				+ ", teacherReqDt=" + teacherReqDt + ", teacherStatus=" + teacherStatus + ", memberNm=" + memberNm
				+ "]";
	}
	
	
	
}
