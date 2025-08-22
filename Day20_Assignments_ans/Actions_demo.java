package Sele_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_demo {
		public static void main(String[] args) throws InterruptedException {
		    WebDriver driver = new ChromeDriver();
		    driver.get("https://demoqa.com/alerts");
		    Thread.sleep(5000);
		    driver.manage().window().maximize();
		   /*
		    WebElement doubleclick=driver.findElement(By.id("doubleClickBtn"));
		    Actions act=new Actions(driver);
		    act.contextClick(doubleclick).perform();
		    
		    Thread.sleep(3000);
		    WebElement mtors=driver.findElements(By.id("rightClickBtn"));
		    act.contextClick(rightclick).perform();
		    */
		    
	}

}
