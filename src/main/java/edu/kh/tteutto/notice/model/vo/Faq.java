package edu.kh.tteutto.notice.model.vo;

public class Faq {
	private int faqNo;
	private int faqDiv;
	private String faqQuestion;
	private String faqAnswer;
	
	public Faq() { }

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public int getFaqDiv() {
		return faqDiv;
	}

	public void setFaqDiv(int faqDiv) {
		this.faqDiv = faqDiv;
	}

	public String getFaqQuestion() {
		return faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	public String getFaqAnswer() {
		return faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	
	
}
