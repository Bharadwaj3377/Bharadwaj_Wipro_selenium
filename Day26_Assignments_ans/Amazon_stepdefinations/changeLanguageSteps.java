package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class changeLanguageSteps {

    WebDriver driver;
    PageClass page;

    @Given("Shopper visits Amazon site for language update")
    public void shopper_visits_amazon_site_for_language_update() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("Shopper provides login with email {string} and password {string}")
    public void shopper_provides_login_with_email_and_password(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("Shopper updates the display language")
    public void shopper_updates_the_display_language() {
        page.ChangeLanguage(); // calls your PageClass method
    }

    @Then("Amazon should show the site in the updated language")
    public void amazon_should_show_the_site_in_the_updated_language() {
        // Validation (check Hindi/Tamil/etc. text in page source)
        String pageSource = driver.getPageSource().toLowerCase();

        if (pageSource.contains("हिंदी") || pageSource.contains("भाषा")) {
            System.out.println("✅ Language updated successfully to Hindi!");
        } else {
            System.out.println("❌ Language update failed.");
        }

        driver.quit();
    }
}
