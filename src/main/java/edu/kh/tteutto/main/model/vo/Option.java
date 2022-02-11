package edu.kh.tteutto.main.model.vo;

import java.util.Arrays;
import java.util.List;

public class Option {
	private List<String> price;
	private String classSort;
	private String classType;
	private String sido;
	private String sigoon;
	
	public Option() {}

	public List<String> getPrice() {
		return price;
	}

	public void setPrice(List<String> price) {
		this.price = price;
	}

	public String getClassSort() {
		return classSort;
	}

	public void setClassSort(String classSort) {
		this.classSort = classSort;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
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

	@Override
	public String toString() {
		return "Option [price=" + price + ", classSort=" + classSort + ", classType=" + classType + ", sido=" + sido
				+ ", sigoon=" + sigoon + "]";
	}

	
	
	
}
