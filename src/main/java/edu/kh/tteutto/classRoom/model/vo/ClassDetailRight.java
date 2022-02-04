package edu.kh.tteutto.classRoom.model.vo;

import edu.kh.tteutto.member.model.vo.Member;


public class ClassDetailRight {

	private ClassDetail cdt;
	private Member member;
	private Episode ep;
	
	public ClassDetailRight() {
		// TODO Auto-generated constructor stub
	}

	public ClassDetail getCdt() {
		return cdt;
	}

	public void setCdt(ClassDetail cdt) {
		this.cdt = cdt;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Episode getEp() {
		return ep;
	}

	public void setEp(Episode ep) {
		this.ep = ep;
	}

	@Override
	public String toString() {
		return "ClassDetailRight [cdt=" + cdt + ", member=" + member + ", ep=" + ep + "]";
	}
	
	
	
}
