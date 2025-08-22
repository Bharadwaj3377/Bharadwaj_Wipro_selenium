package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;


public class Shopbycategory {

    WebDriver driver;
    PageClass page;

    @Given("Shopper opens Amazon site for category shopping")
    public void shopper_opens_amazon_site_for_category_shopping() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("Shopper logs in with email {string} and password {string}")
    public void shopper_logs_in_with_email_and_password(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("Shopper selects Books category and searches for Harry Potter")
    public void shopper_selects_books_category_and_searches_for_harry_potter() {
        page.shopByCategory();  // No parameters since it's hardcoded
    }

    @Then("Harry Potter books should be displayed")
    public void harry_potter_books_should_be_displayed() {
        // simple validation: page title contains "Harry Potter"
        if (driver.getTitle().toLowerCase().contains("harry potter")) {
            System.out.println("✅ Harry Potter books displayed successfully.");
        } else {
            System.out.println("❌ Failed to display Harry Potter books.");
        }
        driver.quit();
    }
}
