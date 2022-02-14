package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailImage;
import edu.kh.tteutto.classRoom.model.vo.Episode;
import edu.kh.tteutto.classRoom.model.vo.EpisodeSchedule;
import edu.kh.tteutto.classRoom.model.vo.IntroImg;

@Repository
public class ClassRegisterDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 클래스 등록
	 * @param cdt
	 * @return classNo
	 */
	public int classInsert(ClassDetail cdt) {
		int result = sqlSession.insert("classMapper.classInsert", cdt);
		
		if(result > 0)  return cdt.getClassNo();
		else			return 0;
		
	}

	/** 클래스 이미지 등록
	 * @param imgList
	 * @return result
	 */
	public int insertImgList(List<ClassDetailImage> imgList) {
		return sqlSession.insert("classMapper.classImageInsert", imgList);
	}

	/** 클래스 스케쥴 등록 (EPISODE)
	 * @param episode
	 * @return epNo
	 */
	public int insertEpisode(Episode episode) {
		int result = sqlSession.insert("classMapper.insertEpisode", episode);
		
		if(result > 0)  return episode.getEpNo();
		else			return 0;
	}

	/** 클래스 스케쥴 등록 (EP_SCHEDULE)
	 * @param episodeSd
	 * @return result
	 */
	public int insertEpisodeSchedule(EpisodeSchedule episodeSd) {
		return sqlSession.insert("classMapper.insertEpisodeSchedule", episodeSd);

	}

	/** 클래스의 선생 번호 가져오기
	 * @param no
	 * @return teacherNo
	 */
	public int teacherNo(int no) {
		return sqlSession.selectOne("classMapper.teacherNo", no);
	}

	/** 클래스 가져오기
	 * @param no
	 * @return cdt
	 */
	public ClassDetail classSelect(int no) {
		return sqlSession.selectOne("classMapper.classSelect", no);
	}

	
	/** 수업 회차 추가 검사용
	 * @param classNo
	 * @return epCount
	 */
	public int checkEpCount(int classNo) {
		return sqlSession.selectOne("classMapper.checkEpCount", classNo);
	}

	/** 원데이 회차 등록
	 * @param episode
	 * @param ec
	 * @return epNo
	 */
	public int insertOneEpisode(Episode episode) {
		int result = sqlSession.insert("classMapper.insertOneEpisode", episode);
		
		if(result > 0)  return episode.getEpNo();
		else			return 0;
	}

	/** 썸머노트 이미지 DB저장
	 * @param it
	 */ 
	public int InsertIntroImg(IntroImg it) {
		return sqlSession.insert("classMapper.insertIntroImg", it);
		
	}

	/** 클래스가 존재하는지
	 * @param no
	 * @return classUse
	 */
	public int classUse(int no) {
		return sqlSession.selectOne("classMapper.classUse", no);
	}
	
}
