package edu.kh.tteutto.classRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.kh.tteutto.classRoom.model.service.MapService;
import edu.kh.tteutto.classRoom.model.vo.Episode;

@Controller
public class MapController {

	@Autowired
	private MapService service;
	
	@RequestMapping("classLocation")
	@ResponseBody
	public String classLocation() {
		
		List<Episode> episode = service.classLocation();
		
		for(Episode e : episode) {
			// System.out.println(e);
		}
		return new Gson().toJson(episode);
	}
}
