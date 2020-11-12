package com.ac.report.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
	
	List<String> countryTotal = new ArrayList<>();
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam("searchString") String searchString) {
		List<LocationStats> allStats = conoraVirusDataService.getAllStats();
		List<LocationStats> searchResult = new ArrayList<>();
			if(searchString != null){
		       for (LocationStats locationstats : allStats) {	  		    	
				if(locationstats.getCountry().equals(searchString)) {						
					searchResult.add(locationstats);
					System.out.println("País agregado: " + locationstats.getCountry());
					}
		       }
			}
			
			if(searchResult == null || searchResult.isEmpty())
			{
				String searchResultError = "No se ha encontrado el país, por favor intente nuevamente.";
				model.addAttribute("searchResultError", searchResultError);
			}
			
			System.out.println("String: " + searchString);
			
		    for(LocationStats locationstats : allStats) {
		    	countryTotal.add(locationstats.getCountry());  
		    	Set<String> optionList = new HashSet<String>(countryTotal);
		    	model.addAttribute("optionList", optionList);	    	
		    }	
		    
		model.addAttribute("searchResult", searchResult);
		return "searchcountry";		
	}
}