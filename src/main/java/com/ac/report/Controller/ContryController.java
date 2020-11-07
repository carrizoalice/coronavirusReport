package com.ac.report.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ac.report.Services.CoronavirusDataService;

@Controller
public class ContryController {
	
	@Autowired
	private CoronavirusDataService conoraVirusDataService;
	
//	@GetMapping("/contry")
//	public String listCountry(Model model, @RequestParam(defaultValue="") String txtsearch) {
//		model.addAllAttributes("country", conoraVirusDataService.findByContry());
//		return "";
//		
//	}
}
