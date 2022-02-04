package edu.kh.tteutto.classRoom.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.admin.model.vo.AdminNoticeImage;
import edu.kh.tteutto.classRoom.model.dao.ClassRegisterDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailImage;
import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.member.model.dao.MemberDAO;

@Service
public class ClassRegisterServiceImpl implements ClassRegisterService{


	@Autowired
	private ClassRegisterDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	// 클래스 등록
	@Override
	public int classInsert(ClassDetail cdt, List<MultipartFile> images, String webPath, String serverPath) {
		int classNo = dao.classInsert(cdt);
		
		if(classNo > 0) {
			
			List<ClassDetailImage> imgList = new ArrayList<ClassDetailImage>();
			
			for(int i=0; i<images.size(); i++) {
				if(!images.get(i).getOriginalFilename().equals("")) {
					
					ClassDetailImage img = new ClassDetailImage();
					
					img.setThImgNm(Util.fileRename(images.get(i).getOriginalFilename()));
					img.setThImgLevel(i);
					img.setClassNo(classNo);
					
					imgList.add(img);
					
				} // if end
				
			} // for end
			
		
		if (!imgList.isEmpty()) {
			int result = dao.insertImgList(imgList);

			if (result == imgList.size()) {
				for (int i = 0; i < imgList.size(); i++) {

					try {
						images.get(i)
						.transferTo(new File(serverPath + "/" + imgList.get(i).getThImgNm()));
					} catch (Exception e) {
						e.printStackTrace();

					}
	
				}
			}	
		}
		
	}
		
	return classNo;
		
	}
	
}
