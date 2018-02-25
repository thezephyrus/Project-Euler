package org.vinil.set1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/*
 * 
 * 
==========
Problem 19 
==========
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?


 * */

public class Problem19 {

	
	public static void main (String args[]) throws ParseException {
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy");

		String startDate = "01-Jan-1901";
		String endDate = "31-Dec-2000";
		Date myDate1 =sd.parse(startDate);
		Date myDate2 =sd.parse(endDate);
		
		System.out.println("Starting Date: >>  "+myDate1);
		System.out.println("Ending Date:  >> "+ myDate2);
		
		List<Date> a = new  ArrayList<Date>();
		a= getDaysBetweenDates(myDate1, myDate2);
		System.out.println("List of Dates: >> " + a);
		System.out.println("Count of requested Days: " + a.size());
		
	}
	
	public static List<Date> getDaysBetweenDates(Date startdate, Date enddate)
	{
	    List<Date> dates = new ArrayList<Date>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(startdate);

	    while (calendar.getTime().before(enddate))
	    {
	    	Date result = calendar.getTime();
	    	if(result.getDate()==1 && result.getDay()==0){ //Sundays with date as 1
	        	dates.add(result);
	        }
	        calendar.add(Calendar.DATE, 1);
	    }
	    return dates;
	}
}
