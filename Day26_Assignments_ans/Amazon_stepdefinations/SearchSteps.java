package StepDefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchSteps {
    static WebDriver driver; // ✅ one session for all examples
    static PageClass page;

    @Given("User is logged into Amazon for search")
    public void user_is_logged_into_amazon() {
        if (driver == null) { // ✅ only initialize once
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
            page = new PageClass(driver);
            page.loginToAmazon("bharadwaj333.achimsetty@gmail.com", "Bharadwaj333@");
        }
    }

    @When("User searches for {string}")
    public void user_searches_for_item(String item) {
        page.searchItem(item);
    }

    @Then("Search results for {string} should be displayed")
    public void search_results_should_be_displayed(String item) {
        assert driver.getPageSource().toLowerCase().contains(item.toLowerCase());
    }
}
