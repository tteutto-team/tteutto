package edu.kh.tteutto.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.dao.WishDAO;

@Service
public class WishServiceImpl implements WishService {
	
	@Autowired
	private WishDAO dao;
	
	// 클래스 개수 조회 + 페이지네이션
	@Override
	public Pagination getPagination(int memberNo, int page) {
		int wishListCount = dao.getWishListCount(memberNo);
		return new Pagination(wishListCount, page);
	}
	
	// 클래스 카드 목록 조회
	@Override
	public List<ClassList> selectWishList(Pagination pagination, int memberNo) {
		return dao.selectWishList(pagination, memberNo);
	}
}
