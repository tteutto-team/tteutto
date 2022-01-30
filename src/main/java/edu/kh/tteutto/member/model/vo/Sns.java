package edu.kh.tteutto.member.model.vo;

public class Sns {

	private int snsNo;
	private String snsLink;
	private int memberNo;
	private int snsDiv;
	
	
	public Sns() {
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

	@Override
	public String toString() {
		return "Sns [snsNo=" + snsNo + ", snsLink=" + snsLink + ", memberNo=" + memberNo + ", snsDiv=" + snsDiv + "]";
	}

}
