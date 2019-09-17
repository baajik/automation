package gov.ebooks.selenium.shared.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Helper 
{
	public static void ShowTestHeader()
	{
		System.out.format("%-60s%-35s%-25s","Test Name", "Test Date", "Result");
		System.out.println("");
		System.out.println("======================================================================================================");

	}
	
	
	public static void ShowTestResult(String TestName, boolean passed)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String TestDateTime = dateFormat.format(cal.getTime());
		
		System.out.format("%-60s%-35s%-25s",TestName.trim(), TestDateTime.trim(), (passed? "Passed": "Failed"));
		System.out.println("");
	}
}
