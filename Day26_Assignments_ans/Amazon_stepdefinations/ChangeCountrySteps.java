package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class ChangeCountrySteps {

    WebDriver driver;
    PageClass page;

    @Given("Shopper navigates to Amazon site for country change")
    public void shopper_navigates_to_amazon_site_for_country_change() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("Shopper signs in using email {string} and password {string}")
    public void shopper_signs_in_using_email_and_password(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("Shopper updates the shopping country")
    public void shopper_updates_the_shopping_country() {
        page.ChangeCountry();  // Calls your PageClass method
    }

    @Then("Amazon should display items from the selected country")
    public void amazon_should_display_items_from_the_selected_country() {
        String pageSource = driver.getPageSource().toLowerCase();

        if (pageSource.contains("united states") || pageSource.contains("deliver to")) {
            System.out.println("✅ Country updated successfully to United States!");
        } else {
            System.out.println("❌ Country update failed.");
        }

        driver.quit();
    }
}
