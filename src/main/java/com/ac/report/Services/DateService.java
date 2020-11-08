package com.ac.report.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class DateService {
	
	String dateNow = "";
	
	public String getDateNow() {
		return dateNow;
	}

	public void setDateNow(String dateNow) {
		this.dateNow = dateNow;
	}
	
	public void dateNowSpanish() {
//		Date
		LocalDate localDate = LocalDate.now();
		Locale spanishLocale = new Locale("es", "ES");
	    dateNow = localDate.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", spanishLocale));	    
	}
}
