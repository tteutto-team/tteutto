package edu.kh.tteutto.classRoom.model.vo;

import java.util.List;

import edu.kh.tteutto.member.model.vo.Member;


public class ClassDetailRight {

	private ClassDetail cdt;
	private Member member;
	private Episode ep;
	
	private List<EpisodeSchedule> epSchedule;
	
	private ClassRegister classReg;
	

	
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
	
	

	public List<EpisodeSchedule> getEpSchedule() {
		return epSchedule;
	}

	public void setEpSchedule(List<EpisodeSchedule> epSchedule) {
		this.epSchedule = epSchedule;
	}
	
	

	public ClassRegister getClassReg() {
		return classReg;
	}

	public void setClassReg(ClassRegister classReg) {
		this.classReg = classReg;
	}

	@Override
	public String toString() {
		return "ClassDetailRight [cdt=" + cdt + ", member=" + member + ", ep=" + ep + ", epSchedule=" + epSchedule
				+ ", classReg=" + classReg + "]";
	}

	

	
	
	
	
}
