package edu.kh.tteutto.admin.model.vo;

import java.util.List;

public class AdminClass {
	private int classNo;
	private String classArea;
	private int classType;
	private int classPerson;
	private int classMinPerson;
	private int classMaxPerson;
	private String className;
	private String classIntro;
	private char classLevel;

	private String categoryName;
	private String categoryDetailName;

	private List<AdminClassThumbnail> thumbnailImg;

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getClassArea() {
		return classArea;
	}

	public void setClassArea(String classArea) {
		this.classArea = classArea;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}

	public int getClassPerson() {
		return classPerson;
	}

	public void setClassPerson(int classPerson) {
		this.classPerson = classPerson;
	}

	public int getClassMinPerson() {
		return classMinPerson;
	}

	public void setClassMinPerson(int classMinPerson) {
		this.classMinPerson = classMinPerson;
	}

	public int getClassMaxPerson() {
		return classMaxPerson;
	}

	public void setClassMaxPerson(int classMaxPerson) {
		this.classMaxPerson = classMaxPerson;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassIntro() {
		return classIntro;
	}

	public void setClassIntro(String classIntro) {
		this.classIntro = classIntro;
	}

	public char getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(char classLevel) {
		this.classLevel = classLevel;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDetailName() {
		return categoryDetailName;
	}

	public void setCategoryDetailName(String categoryDetailName) {
		this.categoryDetailName = categoryDetailName;
	}

	public List<AdminClassThumbnail> getThumbnailImg() {
		return thumbnailImg;
	}

	public void setThumbnailImg(List<AdminClassThumbnail> thumbnailImg) {
		this.thumbnailImg = thumbnailImg;
	}

	@Override
	public String toString() {
		return "AdminClass [classNo=" + classNo + ", classArea=" + classArea + ", classType=" + classType
				+ ", classPerson=" + classPerson + ", classMinPerson=" + classMinPerson + ", classMaxPerson="
				+ classMaxPerson + ", className=" + className + ", classIntro=" + classIntro + ", classLevel="
				+ classLevel + ", categoryName=" + categoryName + ", categoryDetailName=" + categoryDetailName
				+ ", thumbnailImg=" + thumbnailImg + "]";
	}

}
