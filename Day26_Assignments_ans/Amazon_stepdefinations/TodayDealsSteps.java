package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class TodayDealsSteps {

    WebDriver driver;
    PageClass page;

    @Given("Shopper visits Amazon site to explore deals")
    public void shopper_visits_amazon_site_to_explore_deals() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("Shopper logs in with credentials {string} and {string}")
    public void shopper_logs_in_with_credentials(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("Shopper opens Today's Deals page")
    public void shopper_opens_today_s_deals_page() throws InterruptedException {
        page.TodayDeals();
    }

    @Then("Shopper should be able to see the deals section")
    public void shopper_should_be_able_to_see_the_deals_section() {
        String pageTitle = driver.getTitle().toLowerCase();
        if (pageTitle.contains("deals") || pageTitle.contains("today")) {
            System.out.println("✅ Today's Deals page opened successfully.");
        } else {
            System.out.println("❌ Failed to open Today's Deals page.");
        }
        driver.quit();
    }
}
