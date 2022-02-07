package edu.kh.tteutto.main.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

public interface ClassListService {
	Pagination getPagination(String search, int page);
	List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map);
}
