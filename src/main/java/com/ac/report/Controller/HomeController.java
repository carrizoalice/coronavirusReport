package com.ac.report.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ac.report.Models.LocationStats;
import com.ac.report.Services.CoronavirusDataService;



@Controller
public class HomeController {
	
	@Autowired
	CoronavirusDataService conoraVirusDataService;
	
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = conoraVirusDataService.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		model.addAttribute("locationStats", conoraVirusDataService.getAllStats());
		model.addAttribute("totalReportedCases", totalReportedCases);
		return "home";
	}
}
