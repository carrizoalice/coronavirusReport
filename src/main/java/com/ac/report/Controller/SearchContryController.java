package com.ac.report.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ac.report.Models.LocationStats;
import com.ac.report.Services.CoronavirusDataService;

@Controller
public class SearchContryController {
	
	@Autowired
	CoronavirusDataService conoraVirusDataService;
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam("searchString") String searchString) {
		List<LocationStats> allStats = conoraVirusDataService.getAllStats();
		List<LocationStats> searchResult = new ArrayList<>();
		
			if(searchString != null){
		       for (LocationStats l : allStats) {
				if(l.getCountry().equals(searchString)) {					
					searchResult.add(l);
					System.out.println("me agregó este: " + l.getCountry());
					}
		       }
			}
			System.out.println("String: " + searchString);	
		
		model.addAttribute("searchResult", searchResult);
		return "searchcountry";		
	}
}