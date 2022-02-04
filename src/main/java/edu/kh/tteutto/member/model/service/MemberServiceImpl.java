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
	@Transactional("rollbackFor = Exception.class")
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
	
	// 강사 정보 수정 - 이력 수정 x
	@Override
	public int teacherProfileUpdate2(Teacher teacher, String phone, List<Sns> snsList) {
		
		int result = 0;
		
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
						result = dao.teacherSnsInsert(sns);
					}
				}
			}
		}
		return result;
	}

	// 강사 정보 수정 - 이력 삭제
	@Override
	public int teacherProfiledelete(String id, String webPath, String serverPath) {
		
		String selectImgName = dao.selectImgName(id);

		if(selectImgName.length() != 0) {
			String fileName = serverPath + selectImgName;

			//현재 게시판에 존재하는 파일객체를 만듬
			File file = new File(fileName);
			if(file.exists()) { // 파일이 존재하면
				file.delete(); // 파일 삭제	
			}
		}
		
		return dao.teacherProfiledelete(id);
	}

	// 학생 정보 수정
	@Override
	public int studentProfileUpdate(Member member) {
		return dao.studentProfileUpdate(member);
	}


	// 강사 신청
	@Transactional
	@Override
	public int teacherRegisterInsert(Teacher teacher, List<MultipartFile> images, List<Career> career, List<Sns> snsList) {
		
		// SNS 삽입
		if(!snsList.isEmpty()) {
			for(Sns sns : snsList) {
				sns.setMemberNo(teacher.getMemberNo());
				dao.teacherSnsInsert(sns);
			}
		}
		
		// 이력 삽입
		if(!career.isEmpty()) {
			for(Career car : career) {
				car.setMemberNo(teacher.getMemberNo());
				dao.insertTeacherCareer(car);
			}
		}

		// 크로스사이트 ,개행문자
		teacher.setTeacherIntro(Util.XSS(teacher.getTeacherIntro()));
		teacher.setTeacherIntro(Util.changeNewLine(teacher.getTeacherIntro()));
		teacher.setTeacherImg("/resources/images/teacher/" + Util.fileRename(images.get(0).getOriginalFilename()));
		
		int result = dao.teacherRegisterInsert(teacher);
		
		/*
		 * //이미지 삽입 if(result > 0) { // 게시글 삽입 성공 시
		 * 
		 * // 실제 업로드된 이미지를 분별하여 List<BoardImage> imgList에 담기 List<BoardImage> imgList =
		 * new ArrayList<BoardImage>();
		 * 
		 * for(int i=0; i<images.size(); i++) { // i == images의 인덱스 == 업로드된 파일의 level
		 * 
		 * // 각 인덱스 요소에 파일이 업로드 되었는지 검사 if(
		 * !images.get(i).getOriginalFilename().equals("") ) { // MultipartFile에서 DB저장에
		 * 필요한 데이터만을 추출하여 // BoardImage 객체에 담은 후 imgList에 추가
		 * 
		 * BoardImage img = new BoardImage(); img.setImgPath(webPath); // 웹 접근 경로
		 * img.setImgOriginal( images.get(i).getOriginalFilename() ); // 원본 파일명
		 * img.setImgName( Util.fileRename(images.get(i).getOriginalFilename()) ); //
		 * 변경된 파일명 img.setImgLevel(i); // 이미지 레벨 img.setBoardNo(boardNo); // DAO 수행 결과로
		 * 반환 받은 boardNo
		 * 
		 * imgList.add(img); }
		 * 
		 * }
		 * 
		 * // 4) imgList에 업로드된 이미지 정보가 있다면 DAO 호출 if(!imgList.isEmpty()) { int result =
		 * dao.insertImgList(imgList);
		 * 
		 * // System.out.println("삽입 성공한 이미지 정보 개수 : " + result);
		 * 
		 * // 5) 삽입 성공한 행의 개수와 imgList 개수가 같을 경우 // 파일을 서버에 저장 // 1 순위로 확인 할 것! :
		 * servers -> fin server -> OverView // -> serve modules without.. 체크 // -> 저장되는
		 * 파일 경로를 현재 프로젝트로 지정할 수 있음.
		 * 
		 * if(result == imgList.size()) { // 성공 ==> 파일 저장
		 * 
		 * // images : MultipartFile List, 실제 파일 자체 + 정보 // imgList : BoardImage List,
		 * DB에 저장할 파일 정보 for(int i=0; i<imgList.size(); i++) {
		 * 
		 * // 업로드된 파일이 있는 images의 인덱스 요소를 얻어와 //지정된 경로와 이름으로 파일로 변환하여 저장 try {
		 * images.get( imgList.get(i).getImgLevel() ) .transferTo(new File(serverPath +
		 * "/" + imgList.get(i).getImgName() )); }catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace();
		 * 
		 * // 파일 변환이 실패할 경우 // 사용자 정의 예외 발생 throw new
		 * InsertBoardFailException("파일 변환 중 문제 발생"); }
		 * 
		 * }
		 * 
		 * }else { // 업로드된 이미지 수와 삽입된 행의 수가 다를 경우 // 사용자 정의 예외 발생 throw new
		 * InsertBoardFailException(); }
		 * 
		 * }
		 * 
		 * }
		 */
		
		return result;
	}
	
}
