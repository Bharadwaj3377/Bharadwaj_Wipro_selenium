package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Sauce_ {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        WebDriver driver = new FirefoxDriver();
      

        try {
            
            driver.manage().window().maximize();

          
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

           
            WebElement pt = driver.findElement(By.className("title"));
            if (pt.getText().equalsIgnoreCase("Products")) {
                System.out.println("title verified");
            } else {
                System.out.println("title verification failed");
            }

            
            WebElement fp = driver.findElement(By.className("inventory_item"));
            fp.findElement(By.tagName("button")).click();

            WebElement cb = driver.findElement(By.className("shopping_cart_badge"));
            if (cb.isDisplayed()) {
                System.out.println("Added to Cart");
            } else {
                System.out.println("cart adding failed");
            }

           
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.id("checkout")).click();

            driver.findElement(By.id("first-name")).sendKeys("Nasir");
            driver.findElement(By.id("last-name")).sendKeys("Hussain");
            driver.findElement(By.id("postal-code")).sendKeys("518002");
            driver.findElement(By.id("continue")).click();

            driver.findElement(By.id("finish")).click();

            WebElement check = driver.findElement(By.className("complete-header"));
            if (check.getText().contains("Thank you for your order!")) {
                System.out.println("checkout completed");
            } else {
                System.out.println("checkout failed");
            }

            
            driver.findElement(By.id("react-burger-menu-btn")).click();
            Thread.sleep(1000); 
            driver.findElement(By.id("logout_sidebar_link")).click();

            WebElement loginBtn = driver.findElement(By.id("login-button"));
            if (loginBtn.isDisplayed()) {
                System.out.println("Logged out");
            } else {
                System.out.println("Logout failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); 
        }
    }
}