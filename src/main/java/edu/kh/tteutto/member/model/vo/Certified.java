package edu.kh.tteutto.member.model.vo;

public class Certified {
	
	private String memberEmail;
	private String certCd;
	private String certEndDt;
	
	public Certified() { }

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getCertCd() {
		return certCd;
	}

	public void setCertCd(String certCd) {
		this.certCd = certCd;
	}

	public String getCertEndDt() {
		return certEndDt;
	}

	public void setCertEndDt(String certEndDt) {
		this.certEndDt = certEndDt;
	}

	@Override
	public String toString() {
		return "Certified [memberEmail=" + memberEmail + ", certCd=" + certCd + ", certEndDt=" + certEndDt + "]";
	}
	
	
}
