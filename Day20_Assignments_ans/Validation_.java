package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validation_ {
	public static void main(String[] args ) throws InterruptedException
	{
		System.out.println("This is Page's Title Validation Script");
		//setup browser(Chrome driver, firefox driver)
		//System.setProperty("webdriver.chrome.driver","/Users/sai/Desktop/Nasir/Wipro/Selenium_jar/chromedriver-mac-arm64/chromedriver")
		
		//create object for Browser
		WebDriver driver=new ChromeDriver();
//		try{
			
			//Set WebApplication URL
		
		driver.get("https://www.selenium.dev");
		String Expected_Title ="Selenium";
		
		String Actual_Title = driver.getTitle();
//		driver.manage().window().maximize();
//		Thread.sleep(4000);
		System.out.println("Expected Title : "+ Expected_Title);
		System.out.println("Actual Title : "+ Actual_Title);
		if(Expected_Title.equals(Actual_Title))
		{
			System.out.println("Title Validation of Page Successfull");
			
		}
		else 
		{
			System.out.println("Title Validation of Page Failed");
		}
		driver.close();
		System.out.println("Page Successfully opened");
		}
//		catch(Exception e) {
//			System.out.println("Unable to open URL");
//		}
//	}

}