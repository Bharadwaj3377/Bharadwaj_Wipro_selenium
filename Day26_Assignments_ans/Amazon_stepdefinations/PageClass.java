package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass {
    WebDriver driver;
    WebDriverWait wait;

    // =================== Login locators ===================
    By emailfield = By.id("ap_email");
    By passwordfield = By.id("ap_password");
    By loginbtn = By.id("signInSubmit");

    // =================== Search & product locators ===================
    By search = By.id("twotabsearchtextbox");
    By searchbtn = By.id("nav-search-submit-button");
    By firstproduct = By.cssSelector("#landingImage");

    // =================== Cart locators ===================
    By addtocartbtn = By.id("add-to-cart-button");
    By gotocartbtn = By.cssSelector("a[id=\"nav-cart\"]");
    By deletefromcartbtn = By.cssSelector("input[name*='submit.delete']");

    // =================== Account & profile locators ===================
    By accountandlists = By.id("nav-link-accountList-nav-line-1");
    By loginandsecurity = By.xpath("(//span[@class='a-color-secondary'])[2]");
    By editname = By.xpath("(//a[@class='a-button-text'])[1]");
    By newname = By.xpath("(//input[@class='a-input-text'])[1]");
    //By savechagebtn = By.xpath("(//span[@class='a-button a-button-primary'])[1]");
    By savechagebtn = By.id("cnep_1C_submit_button");

    // =================== Address locators ===================
    By youraddress = By.xpath("(//span[@class='a-color-secondary'])[4]");
    By editbtn = By.id("ya-myab-address-edit-btn-0");
    By pincodechange = By.id("address-ui-widgets-enterAddressPostalCode");
    By addresschange = By.id("address-ui-widgets-enterAddressLine1");
    By areachange = By.id("address-ui-widgets-enterAddressLine2");
    By citychange = By.id("address-ui-widgets-enterAddressCity");
    By statechange = By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_15");
   

    // =================== Category & product locators ===================
    By categoryDropdown = By.id("searchDropdownBox");
    By productResult = By.xpath("(//img[@class='s-image'])[1]");

    // =================== Language locators ===================
    By langdrop = By.xpath("//*[@id='icp-nav-flyout']/span/span[2]/div");
    By changectry = By.xpath("//*[@id='icp-flyout-mkt-change']/span/div");
    By prefctry = By.cssSelector(".a-dropdown-link");
    By gotowebsite = By.cssSelector(".a-button-input");
	private By closeCartPopup;

    // =================== Constructor ===================
    public PageClass(WebDriver driver) {
        this.driver = driver;
    }

    // =================== Login ===================
    public void loginToAmazon(String email, String password) {
        driver.findElement(emailfield).sendKeys(email, Keys.ENTER);
        driver.findElement(passwordfield).sendKeys(password);
        driver.findElement(loginbtn).click();
    }

    // =================== Search ===================
    public void searchItem(String item) {
        driver.findElement(search).clear();
        driver.findElement(search).sendKeys(item, Keys.ENTER);
    }

    // =================== Cart Operations ===================
    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchbtn)).click();
    }

    /** Add first product to cart */
    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstproduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn)).click();

        // Try closing cart popup if it appears
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeCartPopup)).click();
        } catch (Exception e) {
            System.out.println("Cart popup not shown, skipping...");
        }
    }

    /** Go to cart */
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(gotocartbtn)).click();
    }

    /** Delete item from cart */
    public void deleteItemFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(deletefromcartbtn)).click();
    }

    // =================== Account Operations ===================
    public void changeName(String newname2) {
        driver.findElement(accountandlists).click();
        driver.findElement(loginandsecurity).click();
        driver.findElement(editname).click();
        driver.findElement(newname).clear();
        driver.findElement(newname).sendKeys(newname2);
        driver.findElement(savechagebtn).click();
        //driver.findElement(submitbtn).click();
    }

    public void changeAddress(String pin, String addr1, String areaTxt, String cityTxt, String stateTxt) {
        driver.findElement(accountandlists).click();
        driver.findElement(youraddress).click();
        driver.findElement(editbtn).click();
        driver.findElement(pincodechange).clear();
        driver.findElement(pincodechange).sendKeys(pin);
        driver.findElement(addresschange).clear();
        driver.findElement(addresschange).sendKeys(addr1);
        driver.findElement(areachange).clear();
        driver.findElement(areachange).sendKeys(areaTxt);
        driver.findElement(citychange).clear();
        driver.findElement(citychange).sendKeys(cityTxt);
        driver.findElement(statechange).clear();
        driver.findElement(statechange).sendKeys(stateTxt);
        driver.findElement(By.cssSelector("input[aria-labelledby=\"address-ui-widgets-form-submit-button-announce\"]")).click();
    }

    // =================== Category ===================
    public void shopByCategory() {
    	driver.findElement(By.id("searchDropdownBox")).click();
  	  driver.findElement(By.cssSelector("select>option[value=\"search-alias=stripbooks\"]")).click();
  	  WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
  	  search.sendKeys("Harry Potter");
  	  search.sendKeys(Keys.ENTER);
  }


    // =================== Language ===================
    public void ChangeLanguage() {
    	  driver.findElement(By.cssSelector("a[class=\"nav-a nav-a-2 icp-link-style-2\"]")).click();
    		  
    		  driver.findElement(By.id("icp-language-translation-hint")).click();
    		  
    		  driver.findElement(By.id("icp-save-button")).click();
    	}
    
    public void ChangeCountry() {
    	  driver.findElement(By.id("nav-logo-sprites")).click();
    		  
    		  driver.findElement(By.id("icp-touch-link-country")).click();
    		  
    		  driver.findElement(By.cssSelector("span[class=\"a-button-text a-declarative\"]")).click();
    		  driver.findElement(By.id("icp-dropdown_6")).click();
    	}
    public void TodayDeals() throws InterruptedException {
   	 driver.findElement(By.id("nav-logo-sprites")).click();
   	  
   	  driver.findElement(By.cssSelector("a[data-csa-c-content-id=\"nav_cs_gb\"]")).click();
   	  
   	  Thread.sleep(3000);
   }
}
