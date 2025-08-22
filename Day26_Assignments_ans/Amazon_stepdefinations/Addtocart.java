package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class Addtocart {

    WebDriver driver;
    PageClass page;

    @Given("User opens Amazon website to addto")
    public void user_opens_amazon_website_to_addto() {
        // Set your ChromeDriver path
        //
    	//.System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with your path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        page = new PageClass(driver);
    }

    @When("User logs in with email {string} and password {string}")
    public void user_logs_in(String email, String password) {
        page.loginToAmazon(email, password);
    }

    @And("User searches for product {string}")
    public void user_searches_for_product(String firstproduct) {
        page.searchItem(firstproduct);
    }

    @And("User adds the first product to cart")
    public void user_adds_first_product_to_cart() throws InterruptedException {
        page.addFirstProductToCart();  // This should click the first product and add to cart
    }

    @And("User goes to the cart")
    public void user_goes_to_cart() throws InterruptedException {
        page.goToCart();  // Make sure you have a method in PageClass: goToCart()
    }

    @Then("User deletes the item from the cart")
    public void user_deletes_item_from_cart() {
        page.deleteItemFromCart();  // Make sure you have a method in PageClass: deleteItemFromCart()
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
