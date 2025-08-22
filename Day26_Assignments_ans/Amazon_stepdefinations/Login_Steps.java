package StepDefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Steps {
    WebDriver driver;
    PageClass page;

    @Given("User is on Amazon login page")
    public void user_is_on_amazon_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("User enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        // Already handled inside loginToAmazon method
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

        driver.quit();
    }
}
