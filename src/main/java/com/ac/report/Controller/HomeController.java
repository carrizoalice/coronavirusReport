package com.ac.report.Controller;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
	
	List<String> countryTotal = new ArrayList<>();	
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = conoraVirusDataService.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", conoraVirusDataService.getAllStats());
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);		

		LocalDate localDate = LocalDate.now();
		Locale spanishLocale = new Locale("es", "ES");
	    String dateNow = localDate.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", spanishLocale));	
	    model.addAttribute("dateNow", dateNow);
	    
	    for(LocationStats locationstats : allStats) {
	    	countryTotal.add(locationstats.getCountry());  
	    	Set<String> optionList = new HashSet<String>(countryTotal);
	    	model.addAttribute("optionList", optionList);	    	
	    }
		
		return "home";
	}	

}
