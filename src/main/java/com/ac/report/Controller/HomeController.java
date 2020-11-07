package com.ac.report.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ac.report.Services.CoronavirusDataService;



@Controller
public class HomeController {
	
	@Autowired
	CoronavirusDataService conoraVirusDataService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("locationStats", conoraVirusDataService.getAllStats());
		return "home";
	}
}
