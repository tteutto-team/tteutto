package edu.kh.tteutto.member.model.vo;

public class Member {
	
	private int memberNo;
	private int memberGrade;
	private int memberSt;
	private String memberEmail;
	private String memberPw;
	private String memberNm;
	private String memberBirth;
	private String memberGender;
	private String memberPno;
	private String memberImg;
	private String memberRegDt;
	private String memberSecDt;
	private String teacherEnroll;
	
	public Member() {}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public int getMemberSt() {
		return memberSt;
	}

	public void setMemberSt(int memberSt) {
		this.memberSt = memberSt;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberPno() {
		return memberPno;
	}

	public void setMemberPno(String memberPno) {
		this.memberPno = memberPno;
	}

	public String getMemberImg() {
		return memberImg;
	}

	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

	public String getMemberRegDt() {
		return memberRegDt;
	}

	public void setMemberRegDt(String memberRegDt) {
		this.memberRegDt = memberRegDt;
	}

	public String getMemberSecDt() {
		return memberSecDt;
	}

	public void setMemberSecDt(String memberSecDt) {
		this.memberSecDt = memberSecDt;
	}

	public String getTeacherEnroll() {
		return teacherEnroll;
	}

	public void setTeacherEnroll(String teacherEnroll) {
		this.teacherEnroll = teacherEnroll;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberGrade=" + memberGrade + ", memberSt=" + memberSt
				+ ", memberEmail=" + memberEmail + ", memberPw=" + memberPw + ", memberNm=" + memberNm
				+ ", memberBirth=" + memberBirth + ", memberGender=" + memberGender + ", memberPno=" + memberPno
				+ ", memberImg=" + memberImg + ", memberRegDt=" + memberRegDt + ", memberSecDt=" + memberSecDt
				+ ", teacherEnroll=" + teacherEnroll + "]";
	}

	
	
}
