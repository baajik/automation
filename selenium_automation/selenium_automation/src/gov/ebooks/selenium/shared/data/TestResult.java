package gov.ebooks.selenium.shared.data;

public class TestResult 
{
	private String TestName;
	public final String getTestName()
	{
		return TestName;
	}
	
	public final void setTestName(String value)
	{
		TestName = value;
	}
	
	private String TestDate;
	public final String getTestDate()
	{
		return TestDate;
	}
	
	public final void setTestDate(String value)
	{
		TestDate = value;
	}
		
	private String Result;
	public final String getResult()
	{
		return Result;
	}
	
	public final void setResult(String value)
	{
		Result = value;
	}
	
	private String Comment;
	public final String getComment()
	{
		return Comment;
	}
	
	public final void setComment(String value)
	{
		Comment = value;
	}
}
