package com.charan.map.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.charan.map.model.Location;
import com.charan.map.service.MapService;

@Controller
public class MapController {

	private final MapService mapService;

	public MapController(MapService mapService) {
		this.mapService = mapService;
	}

	@GetMapping("/home")
	public ModelAndView getDefaultMap(Map<String, Object> model) {
		Location location = new Location();
		location.setCity("Hyderabad");
		location.setState("Telangana");
		mapService.addCoordinates(location);
		model.put("location", location);
		return new ModelAndView("index.html");
	}

	@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {
		mapService.addCoordinates(location);
		model.addAttribute(location);
		return "index.html";
	}

}
