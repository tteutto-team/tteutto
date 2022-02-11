package edu.kh.tteutto.main.model.vo;

import java.util.Arrays;
import java.util.List;

public class Option {
	private String price;
	private String classSort;
	private String classType;

	
	public Option() {
		// TODO Auto-generated constructor stub
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
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


	@Override
	public String toString() {
		return "Option [price=" + price + ", classSort=" + classSort + ", classType=" + classType + "]";
	}
	
}
