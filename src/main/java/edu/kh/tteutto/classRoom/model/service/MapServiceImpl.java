package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.MapDAO;
import edu.kh.tteutto.classRoom.model.vo.Episode;

@Service
public class MapServiceImpl implements MapService {

	@Autowired
	private MapDAO dao;

	@Override
	public List<Episode> classLocation() {
		return dao.classLocation();
	}
	
	
}
