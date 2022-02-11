package edu.kh.tteutto.main.model.vo;

import java.util.List;

public class Option {
	private List<String> price;
	private String sido;
	private String sigoon;
	private String classType;
	private String classSort;
	
	public Option() {}

	public List<String> getPrice() {
		return price;
	}

	public void setPrice(List<String> price) {
		this.price = price;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigoon() {
		return sigoon;
	}

	public void setSigoon(String sigoon) {
		this.sigoon = sigoon;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getClassSort() {
		return classSort;
	}

	public void setClassSort(String classSort) {
		this.classSort = classSort;
	}

	@Override
	public String toString() {
		return "Option [price=" + price + ", sido=" + sido + ", sigoon=" + sigoon + ", classType=" + classType
				+ ", classSort=" + classSort + "]";
	}
}
