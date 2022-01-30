package edu.kh.tteutto.admin.model.vo;

public class AdminTeacherSNS {
	private int snsNo;
	private String snsLink;
	private int memberNo;

	public AdminTeacherSNS() {
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

	@Override
	public String toString() {
		return "AdminTeacherSNS [snsNo=" + snsNo + ", snsLink=" + snsLink + ", memberNo=" + memberNo + "]";
	}

}
