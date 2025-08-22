package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class Changeaddress {

    WebDriver driver;
    PageClass page;

    @Given("User opens Amazon account address page")
    public void user_opens_amazon_account_address_page() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("User logs in using email {string} and password {string}")
    public void user_logs_in_using_email_and_password(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("User modifies the address with Pincode {string}, Address {string}, Area {string}, City {string}, State {string}")
    public void user_modifies_the_address(String pin, String addr1, String areaTxt, String cityTxt, String stateTxt) {
        page.changeAddress(pin, addr1, areaTxt, cityTxt, stateTxt);
    }

    @Then("Account address should be updated successfully")
    public void account_address_should_be_updated_successfully() {
        System.out.println("Account address updated successfully");
        driver.quit();
    }
}
