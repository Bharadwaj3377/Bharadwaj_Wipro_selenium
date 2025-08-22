package Sele_package;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class DemoQA {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Fill form
        driver.findElement(By.id("firstName")).sendKeys("Bobby");
        driver.findElement(By.id("lastName")).sendKeys("A");
        driver.findElement(By.id("userEmail")).sendKeys("Boby@gmail.com");

        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9704502210");

        // Date of Birth
        driver.findElement(By.id("dateOfBirthInput")).click();
        new Select(driver.findElement(By.className("react-datepicker__year-select"))).selectByVisibleText("2002");
        new Select(driver.findElement(By.className("react-datepicker__month-select"))).selectByVisibleText("January");
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--007']")).click();

        // Subjects
        String[] subjects = {"Maths", "Physics", "Economics", "English"};
        WebElement sub = driver.findElement(By.id("subjectsInput"));
        for (String subject : subjects) {
            sub.sendKeys(subject);
            sub.sendKeys(Keys.ENTER);
        }

        // Hobbies
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        driver.findElement(By.xpath("//label[text()='Reading']")).click();

        jse.executeScript("window.scrollBy(0,400)");

        // Upload picture
        driver.findElement(By.id("uploadPicture"))
              .sendKeys("C:\\Users\\Bhara\\OneDrive\\Desktop\\Pictures\\image_2.jpg");

        driver.findElement(By.id("currentAddress")).sendKeys("7-183/A Vetapalem");

        // State & City
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        // Submit
        driver.findElement(By.id("submit")).click();

        // Screenshot
        Thread.sleep(2000);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshotDemoQA.png");
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Screenshot 'screenshotDemoQA.png' saved successfully!");

        driver.quit();
    }
}
