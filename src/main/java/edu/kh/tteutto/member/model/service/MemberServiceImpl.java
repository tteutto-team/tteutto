package edu.kh.tteutto.member.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.member.model.dao.MemberDAO;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.member.model.vo.Sns;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	

	// 로그인
	@Override
	public Member login(Member member) {
		
		String encPw = encoder.encode(member.getMemberPw());
		Member loginMember = dao.login(member.getMemberEmail());
		
		if(loginMember != null && encoder.matches(member.getMemberPw(), loginMember.getMemberPw())) {
			
			loginMember.setMemberPw(null);
		}else {
			loginMember = null;
		}
		return loginMember;
	}
	
	// 이메일 중복 검사
	@Override
	public int emailDupCheck(String inputEmail) {
		return dao.emailDupCheck(inputEmail);
	}
	
	// 회원 인증테이블에 이메일 중복 확인
	@Override
	public int emailDupCheck2(String inputEmail) {
		return dao.emailDupCheck2(inputEmail);
	}
	
	// 회원가입 이메일 인증번호 저장
	@Override
	public int sendMailTest(Map<String, String> map) {
		return dao.sendMailTest(map);
	}
		
	
	// 회원가입 이메일 인증번호 수정
	@Override
	public int updateMailTest(Map<String, String> map) {
		return dao.updateMailTest(map);
	}

	// 이메일 인증 확인
	@Override
	public int checkCert(Map<String, String> map) {
		return dao.checkCert(map);
	}

	// 회원가입
	@Transactional()
	@Override
	public int signUp(Member member) {
		
		String encPw = encoder.encode(member.getMemberPw());
		
		member.setMemberPw(encPw);
		
		return dao.signUp(member);
	}

	// 비밀번호 변경전 확인
	@Override
	public int changeConfirm(Certified certified) {
		return dao.changeConfirm(certified);
	}

	// 비밀번호 변경
	@Override
	public int changePw(Member member) {
		
		String encPw = encoder.encode(member.getMemberPw());
		
		member.setMemberPw(encPw);
		return dao.changePw(member);
	}
	
	@Override
	public int updateCert(Certified certified) {
		return dao.updateCert(certified);
	}

	// 강사 정보 조회
	@Override
	public Teacher selectTeacherProfile(int memberNo) {
		return dao.selectTeacherProfile(memberNo);
	}
	
	// 강사 이력 조회
	@Override
	public List<Career> selectTeacherCareer(int memberNo) {
		return dao.selectTeacherCareer(memberNo);
	}
	
	// 강사 sns 조회
	@Override
	public List<Sns> selectTeacherSns(int memberNo) {
		return dao.selectTeacherSns(memberNo);
	}
	
	// 강사 정보 수정
@Override
	public int teacherProfileUpdate(Teacher teacher, String phone, List<Sns> snsList, List<String> profileInput,
		List<MultipartFile> images, String webPath, String serverPath) {
		
		int result = 0; 
		int result4 = 0;
		
		// 전화번호, 강사 소개에 XSS 처리 + 강사 소개에 개행문자 변경처리
		phone = (Util.XSS(phone));
		teacher.setTeacherIntro(Util.XSS(teacher.getTeacherIntro()));
		teacher.setTeacherIntro(Util.changeNewLine(teacher.getTeacherIntro()));	// 개행문자 처리
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("memberNo", teacher.getMemberNo());
		map1.put("phone", phone);
		
		
		// 전화번호 업데이트
		int result1 = dao.teacherPhoneUpdate(map1);
		
		if(result1 > 0) {
			// 강사 소개 업데이트
			int result2 = dao.teacherIntroduceUpdate(teacher);
			
			if(result2 > 0) {
				// sns 삭제
				int result3 = dao.teacherSnsDelete(teacher.getMemberNo());
				
				if(result3 > 0) {
					// sns 삽입
					for(Sns sns : snsList) {
						sns.setMemberNo(teacher.getMemberNo());
						result4 = dao.teacherSnsInsert(sns);
					}
				}
			}
		}

		if(result4 > 0) {
			// 강사 이력 삭제
			int result5 = dao.teacherProfileDelete(teacher.getMemberNo());
			// 여기까지는 진행 완료
			
			
			// images에 담겨있는 파일 정보 중 업로드된 파일 정보를 imgList에 옮겨 담기
			
			List<Career> imgList = new ArrayList<Career>();
			
			for(int i=0 ; i<images.size(); i++) {
				
				Career img = new Career();
				
				img.setMemberNo(teacher.getMemberNo()); // 강사 번호
				img.setImgPath(webPath); // 웹 접근 경로
				img.setImgName( Util.fileRename( images.get(i).getOriginalFilename() ) ); // 변경된 파일명
				img.setImgOriginal( images.get(i).getOriginalFilename() ); // 원본 파일명
				img.setCareerContent(profileInput.get(i));	// 이력 내용
				
				imgList.add(img);
				
				result = dao.teacherProfileInsert(img);
				
				if(result > 0) {
					
					try {
						images.get(i).transferTo(new File(serverPath + "/" + imgList.get(i).getImgName()));
					} catch (Exception e) {
						e.printStackTrace();
						// 파일 변환이 실패할 경우
						// 사용자 정의 예외 발생
//						throw new InsertBoardFailException("파일 변환 중 문제 발생");
					}
				}
			}
			
			
			
			
		}
		
		return result;
	}
		
		
		
		
	
}
