package com.ac.report.Comparator;

import java.util.Comparator;

import com.ac.report.Models.LocationStats;


public class LatestTotalCasesComparator implements Comparator<LocationStats>{

	@Override
	public int compare(LocationStats o1, LocationStats o2) {
		
		if(o1.getLatestTotalCases() > o2.getLatestTotalCases())
		{
			return -1;
			
		}else if(o1.getLatestTotalCases() < o2.getLatestTotalCases())
		{
			return 1;
			
		}else
		{
			return 0;
		}		
	}

}