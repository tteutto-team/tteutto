package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailImage;

@Repository
public class ClassRegisterDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 클래스 등록
	 * @param cdt
	 * @return
	 */
	public int classInsert(ClassDetail cdt) {
		return sqlSession.insert("classMapper.classInsert", cdt);
	}

	/** 클래스 이미지 등록
	 * @param imgList
	 * @return
	 */
	public int insertImgList(List<ClassDetailImage> imgList) {
		return sqlSession.insert("classMapper.classImageInsert", imgList);
	}
	
}
