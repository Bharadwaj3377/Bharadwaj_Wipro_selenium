package Sele_package;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CssDenoQA {
		public static void main(String[] args) throws InterruptedException {
		    WebDriver driver = new ChromeDriver();
		    driver.get("https://demoqa.com/automation-practice-form");
		    Thread.sleep(5000);
		    driver.manage().window().maximize();
		//  WebElement fname=driver.findElement(By.cssSelector("div>input[placeholder=\"First Name\"]"));
		//  fname.sendKeys("Neeva");

	//   WebElement lname=driver.findElement(By.cssSelector("div>input[placeholder=\"Last Name\"]"));
	//   lname.sendKeys("Sharma");

		    driver.findElement(By.id("dateOfBirthInput")).click();
		    driver.findElement(By.cssSelector("select>option[value=\"2025\"]")).click();
		    driver.findElement(By.cssSelector("select>option[value=\"3\"]")).click();
		    driver.findElement(By.cssSelector("div[aria-label=\"Choose Tuesday, April 1st, 2025\"]")).click();
		}
}
