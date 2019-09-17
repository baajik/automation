package gov.ebooks.selenium.shared.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.NumberToTextConverter;

import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;


public class DataManager {
	
	public static void ExportToExcel(String testname, String status, String comments ) {
	    if(status != null && !status.isEmpty()) {
	    	//System.out.println("\nExporting test case result to Excel.............");
	    	
	    	String reportFilePath =ConfigManager.ReportsPath() + "\\tests";
        	String reportFile = reportFilePath + "\\TestResults.xls";
	    	
	      	try {
	      		//create a new workbook based on an existing template
	        	FileInputStream inputStream = new FileInputStream(new File(reportFile));
	        	HSSFWorkbook  workBook = new HSSFWorkbook(inputStream);
	        	
	      		//populate the workbook with the result
	            HSSFSheet sheet = workBook.getSheetAt(0);
	            
	            int physicalno= sheet.getPhysicalNumberOfRows();
	        
	            for(int j = 0; j < physicalno ; j++) {
	            	
	            	 HSSFRow row = sheet.getRow(j);
	            	 String cellvalue = "";
	            	 if(row != null) {
	            		 cellvalue = row.getCell(0).getStringCellValue();  
	            	 }
	                 
	                 if(cellvalue.isEmpty()) {	            		 
	            		sheet.createRow(j);	     	            
	     	            HSSFRow rowResults = sheet.getRow(j);
	     	            HSSFCell cell = rowResults.createCell(0); 
	     	            HSSFCell cell1 = rowResults.createCell(1); 
	     	            HSSFCell cell2 = rowResults.createCell(2); 
	     	            HSSFCell cell3 = rowResults.createCell(3); 	     	            
	     	            
	     	            cell.setCellValue(testname);
	     	            cell1.setCellValue(status);
	     	            cell2.setCellValue(new Date().toString());
	     	            cell3.setCellValue(comments);
	     	            break;
	            	 }
	            }	                     
	            inputStream.close();	             
	            //export the workbook to a new excel file on the specified report path
	        		            
	        	FileOutputStream outputStream = new FileOutputStream(reportFile);
	            workBook.write(outputStream);
	            outputStream.flush();
	            outputStream.close();
	            workBook.close();
	            
		    	//System.out.println("Test result exported successfully!\n");
		    	//System.out.println("File Path: " + reportFilePath);
		    	//System.out.println("File Name: TestResults.xls \n");
		    	
		    	OpenFile(reportFile);
		    	
	        }
	        catch(FileNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("Invalid directory or file not found");
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	            System.out.println("Error occurred while exporting to Excel: " + e.getMessage());
	        }
	    }
	}
	
	public static void ExportToExcel(List<TestResult> testResult, String testSuitName, String reportFilePrefix) {
	    if(testResult != null && !testResult.isEmpty()) {
	    	System.out.println("\nExporting test result to Excel.............");
	    	
	    	String templateFilePath = ConfigManager.ReportTemplatesPath();
	    	String templateFile =  templateFilePath + "/TestResults.xls";
	      	try {
	      		//create a new workbook based on an existing template
	        	FileInputStream inputStream = new FileInputStream(new File(templateFile));
	        	HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
	        	inputStream.close();
	        	
	      		//populate the workbook with the result
	            HSSFSheet sheet = workBook.getSheetAt(0);
	            
	            HSSFRow rowPageURL = sheet.getRow(1);
	            rowPageURL.getCell((short)1).setCellValue(testSuitName);
	            
	            HSSFRow rowProcessedDate = sheet.getRow(2);
	            rowProcessedDate.getCell((short)1).setCellValue(new Date().toString());
	
	            int testsCnt = testResult.size();
	            int failedTestsCnt = testResult.stream().filter(test -> test.getResult().equalsIgnoreCase("Failed")).collect(Collectors.toList()).size();
	            int passedTestsCnt = testsCnt-failedTestsCnt;
	            
	            HSSFRow rowLinksCount = sheet.getRow(3);
	            rowLinksCount.getCell((short)1).setCellValue(testsCnt);
	
	            HSSFRow rowValidLinksCount = sheet.getRow(4);
	            rowValidLinksCount.getCell((short)1).setCellValue(passedTestsCnt);
	            
	            HSSFRow rowInvalidLinksCount = sheet.getRow(5);
	            rowInvalidLinksCount.getCell((short)1).setCellValue(failedTestsCnt);
	            
	            short rowNo = 8;
	            short recNo =1;
	           
	            for (TestResult test : testResult) {
	                HSSFRow row = sheet.createRow(rowNo);
	                row.createCell((short)0).setCellValue(recNo);
	                row.createCell((short)1).setCellValue(test.getTestName());
	                row.createCell((short)2).setCellValue(test.getTestDate());
	                row.createCell((short)3).setCellValue(test.getResult());
	                row.createCell((short)4).setCellValue(test.getComment());
	                rowNo++;
	                recNo++;
	            }
	             
	            //export the workbook to a new excel file on the specified report path
	         // String rptFilePath = ConfigManager.ReportsPath() +  "\\tests";
	        	String rptFilePath = "/Users/nayana.shivalingappa/selenium_automation/target";
	        	String rptFileName = GenerateFileName(reportFilePrefix);
	        	String fileName = rptFilePath + "\\" + rptFileName;
	            
	        	FileOutputStream outputStream = new FileOutputStream(fileName);
	            workBook.write(outputStream);
	            outputStream.flush();
	            outputStream.close();
	            workBook.close();
	            
		    	System.out.println("Test result exported successfully!\n");
		    	System.out.println("File Path: " + rptFilePath);
		    	System.out.println("File Name: " + rptFileName+"\n");
		    	
		    	System.out.println("Opening file.....");
   	
		    	OpenFile(fileName);
		    	
		    	System.out.println("File opened successfully!\n");
	        }
	        catch(FileNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("Invalid directory or file not found");
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	            System.out.println("Error occurred while exporting to Excel: " + e.getMessage());
	        }
	    }
	}
	
	public static void SaveTestResult(String testName, String testResult, String comment) {
	    if(testName != null && !testName.isEmpty()) {
	      	try {
	    		TestResult result = new TestResult();
	    		result.setTestName(testName);
	    		result.setTestDate(new Date().toString());
	    		result.setResult(testResult);
	    		result.setComment(comment);
	    		
	    		TestResultList.ExternalTestSuit.add(result);
	        }
	        catch(Exception e) {
	            System.out.println("Error occurred while trying to save test result: " + e.getMessage());
	        }
	    }
	}
	
	public static String[][] ImportFromExcel(String sheetName) {
	    if(sheetName != null && !sheetName.isEmpty()) {
	    	
	    	String testDataFilePath = ConfigManager.DataPath();
	    	String testDataFileFile = testDataFilePath + "/TestData.xls";
	    	
	      	try
	        {
	        	FileInputStream inputStream = new FileInputStream(new File(testDataFileFile));
	        	HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
	        	inputStream.close();
	        	
	        	HSSFSheet sheet = workBook.getSheet(sheetName);
	            
				int rowNum = sheet.getLastRowNum() +1;
			    int colNum = sheet.getRow(0).getLastCellNum();
			    String[][] data = new String[rowNum][colNum];
				
			    for (int i = 0 ; i < rowNum ; i++) 
			    {
			        HSSFRow row = sheet.getRow(i);
		            for (int j = 0 ; j < colNum ; j++) 
		            {
		                HSSFCell cell = row.getCell(j);
		                String value = ConvertCellToString(cell);
		                data[i][j] = value ;
		            }
			    }
				workBook.close();
				return data;
	        }
	        catch(FileNotFoundException e)
	        {
	            e.printStackTrace();
	            System.out.println("Invalid directory or file not found");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("Error occurred while exporting to Excel: " + e.getMessage());
	        }
	    }
	    return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String ConvertCellToString(HSSFCell cell) 
	{  
	    String result = "";
	    if(cell!=null)
	    {
		    int type =cell.getCellType();
		
		    switch (type) 
		    {
	
		        case Cell.CELL_TYPE_NUMERIC:
		        case Cell.CELL_TYPE_FORMULA:
		        	if(HSSFDateUtil.isCellDateFormatted(cell))
		    		{
		    			DateFormat dfEventDate = new SimpleDateFormat("MM/dd/yyyy");
		        		result = dfEventDate.format(cell.getDateCellValue());
		    		}
		        	else
		        	{
		        		result = NumberToTextConverter.toText(cell.getNumericCellValue());
		        	}
		            break;
		        case Cell.CELL_TYPE_STRING: 
		            result = cell.getStringCellValue();
		            break;
		        case Cell.CELL_TYPE_BLANK:
		            result = "";
		            break;
		        case Cell.CELL_TYPE_BOOLEAN: 
		            result = BooleanUtils.toStringYesNo(cell.getBooleanCellValue());
		            break;
		        case Cell.CELL_TYPE_ERROR:
		        default:  
		            throw new RuntimeException("There is no support for this type of cell");                        
		    }
	    }
	    return result;
	}
	
	private static void OpenFile(String FileToOpen) throws IOException
	{
		     Desktop.getDesktop().open(new File(FileToOpen));
	}

	private static String GenerateFileName(String reportFilePrefix) 
	{
	    String filename = "";
	    String ext="xls";
	    long ms = System.currentTimeMillis();
	    String date = new Date().toString();
	    date = date.replace(" ", "");
	    date = date.replace(":", "");
	    filename = reportFilePrefix + "_" + date + "_" + ms;
	    
	    return filename + "." + ext;
	}
	
	
/*
	public static SiteSearch GetSiteSearchData() 
	{

	    	String testDataFilePath = ConfigManager.DataPath();
	    	String testDataFileFile = testDataFilePath + "/TestData.xls";
	    	
	    	SiteSearch objSiteSearch = new SiteSearch();
	    	
	      	try
	        {
	      		//create a new workbook based on an existing template
	        	FileInputStream inputStream = new FileInputStream(new File(testDataFileFile));
	        	HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
	        	inputStream.close();
	        	
	      		//read data from excel sheet
	            HSSFSheet sheet = workBook.getSheet("SiteSearch");
	            
	            Field[] fields = SiteSearch.class.getDeclaredFields();

	            HSSFRow row = sheet.getRow(1);
	            
	            for (Field field: fields)
	            {
	            	switch(field.getName())
	            	{
		            	case "SearchKeyPositive":
		            		objSiteSearch.setSearchKeyPositive(CellUtil.getCell(row, 0).getRichStringCellValue().getString());
		            		break;
		            	case "SearchKeyNegative":
		            		objSiteSearch.setSearchKeyNegative(CellUtil.getCell(row, 1).getRichStringCellValue().getString());
			            	break;
	            	}
	            }
	            workBook.close();
	            
	        }
	        catch(FileNotFoundException e)
	        {
	            e.printStackTrace();
	            System.out.println("Invalid directory or file not found");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("Error occurred while importing from Excel: " + e.getMessage());
	        }
	      	
            return objSiteSearch;
	}*/
	
	public static UserAccount GetUserAccount(String Role) 
	{

	    	String testDataFilePath = ConfigManager.DataPath();
	    	String testDataFileFile = "/Users/nayana.shivalingappa/selenium_automation/esto_review/gov/ebooks/selenium/esto_review/resources/TestData.xls"; //testDataFilePath + "/TestData.xls";
	    	
	    	UserAccount objUserAccount = new UserAccount();
	    	
	      	try
	        {
	      		//create a new workbook based on an existing template
	        	FileInputStream inputStream = new FileInputStream(new File(testDataFileFile));
	        	HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
	        	inputStream.close();
	        	
	      		//read data from excel sheet
	            HSSFSheet sheet = workBook.getSheet("UserAccounts");
	            
	            Field[] fields = UserAccount.class.getDeclaredFields();

	            int rowNum =1;
	            switch(Role.toUpperCase())
	            {
            	case "APPSCIPI": //AppsciPM
            		rowNum = 1;
            		break;
            	case "APPSCIPM": //AppsciPM
            		rowNum = 2;
            		break;
            	case "ESTOREVIEWER": //ESTOReviewer
            		rowNum = 3;
            		break;
            	case "ESTOPM": // ESTOPM
            		rowNum = 4;
            		break;
            	case "ALLCAPITAL2":  //
            		rowNum = 5;
            		break;

            	default:
            		rowNum =1;
            		break;
	            }
	            HSSFRow row = sheet.getRow(rowNum);
	            
	            for (Field field: fields)
	            {
	            	switch(field.getName())
	            	{
		            	case "Role":
		            		objUserAccount.setRole(CellUtil.getCell(row, 0).getRichStringCellValue().getString());
		            		break;
		            	case "UserName":
		            		objUserAccount.setUserName(CellUtil.getCell(row, 1).getRichStringCellValue().getString());
			            	break;
		            	case "Password":
		            		objUserAccount.setPassword(CellUtil.getCell(row, 2).getRichStringCellValue().getString());
			            	break;
	            	}
	            }
	            workBook.close();
	            
	        }
	        catch(FileNotFoundException e)
	        {
	            e.printStackTrace();
	            System.out.println("Invalid directory or file not found");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("Error occurred while importing from Excel: " + e.getMessage());
	        }
	      	
            return objUserAccount;
	}
            
            public static void main(String[] args) 
	{
		ImportFromExcel("CompanyRegistrationExisting");
		try 
		{
			File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
			System.out.println(root.getAbsolutePath());
			System.out.println(ConfigManager.DriverPath());
			System.out.println(DataManager.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
