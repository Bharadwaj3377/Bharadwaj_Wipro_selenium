package Sele_package;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("This is my first script");
		//set browser (chromedriver, firefox driver)
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhara\\OneDrive\\Desktop\\Selenium_jar\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe" );
		//create object for browser
		//set webapplication url
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev");
		System.out.println("Page load successfully");
		
		String expectedtitle="Selenium dev";
		String actualtitle=driver.getTitle();
		
		System.out.println("Expected Title : "+expectedtitle);
		System.out.println("Actual Title : "+actualtitle);
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		if(expectedtitle.equals(actualtitle))
		{
			System.out.println("Title Validation successful");

		}
		else
		{
			System.out.println("Title Validation failed");
		}
		
		driver.close();
		

	}

}
