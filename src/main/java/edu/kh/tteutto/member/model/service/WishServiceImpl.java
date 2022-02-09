package edu.kh.tteutto.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.dao.WishDAO;

@Service
public class WishServiceImpl implements WishService {
	
	@Autowired
	private WishDAO dao;

	@Override
	public Pagination getPagination(Map<String, Object> map, int page) {
		int wishListCount = dao.getWishListCount(map);
		return new Pagination(wishListCount, page);
	}

	@Override
	public List<ClassList> selectWishList(Pagination pagination, Map<String, Object> map) {
		return dao.selectWishList(pagination, map);
	}
}
