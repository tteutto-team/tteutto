package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.classRoom.model.vo.OngingClass;
import edu.kh.tteutto.classRoom.model.vo.Receipt;

public interface TeacherService {

	/** 클래스 목록 조회
	 * @param memberNo
	 * @return classList
	 */
	List<ClassDetail> selectClassList(int memberNo);

	/** 회차별 클래스 목록 조회
	 * @param memberNo
	 * @return episodeList
	 */
	List<EpisodeClass> selectClassEpisode(int memberNo);

	/** 영수증 조회
	 * @param epNo
	 * @return receiptList
	 */
	List<Receipt> selectReceipt(String epNo);

	/** 클래스 삭제 가능여부 조회
	 * @param epNo
	 * @return result
	 */
	int selectDeleteClass(String epNo);

	/** 클래스 삭제
	 * @param epNo
	 * @return result
	 */
	int deletClass(String epNo);

	/** 진행중인 클래스 목록 조회
	 * @param epNo
	 * @return ongoingClassList
	 */
	List<OngingClass> selectOngoingClass(int epNo);
	
	
}
