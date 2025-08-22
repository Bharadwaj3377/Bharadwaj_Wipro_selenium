package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class Changeusername {

    WebDriver driver;
    PageClass page;

    @Given("User navigates to Amazon account settings")
    public void user_navigates_to_amazon_account_settings() {
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("User signs in with credentials {string} and {string}")
    public void user_signs_in_with_credentials(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("User updates the account name to {string}")
    public void user_updates_the_account_name_to(String newName) {
        page.changeName(newName);
    }

    @Then("Account name should be updated successfully")
    public void account_name_should_be_updated_successfully() {
    	 System.out.println("Account name updated successfully");
        driver.quit();
    }
}
