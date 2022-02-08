package edu.kh.tteutto.classRoom.model.vo;

public class ClassReview {

	//후기 테이블 
		private int reviewNo; // 후기번호
		private int reviewStar; //후기별점
		private String reviewContent; //후기 내용
		private String reviewDt; // 후기 작성일자
		private String reviewStatus; //후기 상태
		
		private int regNo; //수강번호
		private int reviewAvg; //별점평균
	
		private String className; // 클래스명
		private int epCount; // 클래스 회차
		private String memberName; // 강사명
		
		
		public ClassReview() {
			// TODO Auto-generated constructor stub
		}

		
		
		

		public String getClassName() {
			return className;
		}





		public void setClassName(String className) {
			this.className = className;
		}





		public int getEpCount() {
			return epCount;
		}





		public void setEpCount(int epCount) {
			this.epCount = epCount;
		}





		public String getMemberName() {
			return memberName;
		}





		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}





		public int getReviewNo() {
			return reviewNo;
		}


		public void setReviewNo(int reviewNo) {
			this.reviewNo = reviewNo;
		}


		public int getReviewStar() {
			return reviewStar;
		}


		public void setReviewStar(int reviewStar) {
			this.reviewStar = reviewStar;
		}


		public String getReviewContent() {
			return reviewContent;
		}


		public void setReviewContent(String reviewContent) {
			this.reviewContent = reviewContent;
		}


		public String getReviewDt() {
			return reviewDt;
		}


		public void setReviewDt(String reviewDt) {
			this.reviewDt = reviewDt;
		}


		public String getReviewStatus() {
			return reviewStatus;
		}


		public void setReviewStatus(String reviewStatus) {
			this.reviewStatus = reviewStatus;
		}

		

		public int getRegNo() {
			return regNo;
		}


		public void setRegNo(int regNo) {
			this.regNo = regNo;
		}
		
		


		public int getReviewAvg() {
			return reviewAvg;
		}


		public void setReviewAvg(int reviewAvg) {
			this.reviewAvg = reviewAvg;
		}





		@Override
		public String toString() {
			return "ClassReview [reviewNo=" + reviewNo + ", reviewStar=" + reviewStar + ", reviewContent="
					+ reviewContent + ", reviewDt=" + reviewDt + ", reviewStatus=" + reviewStatus + ", regNo=" + regNo
					+ ", reviewAvg=" + reviewAvg + ", className=" + className + ", epCount=" + epCount + ", memberName="
					+ memberName + "]";
		}


		
		
		
		
}
