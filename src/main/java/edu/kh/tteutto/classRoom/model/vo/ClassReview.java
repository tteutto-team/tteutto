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
	
		
		public ClassReview() {
			// TODO Auto-generated constructor stub
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
					+ ", reveiwAvg=" + reviewAvg + "]";
		}


		


		
		
		
		
}
