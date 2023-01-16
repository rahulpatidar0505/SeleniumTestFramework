package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtil;

public class AddressPage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    private final By lc_editAddress = By.xpath("//div[@class='box box-billing-address']//span[contains(text(),'Edit Address')]");
    private final By lc_firstName = By.xpath("//input[@name='firstname']");
    private final By lc_lastName = By.xpath("//input[@name='lastname']");
    private final By lc_streetAddress = By.xpath("//input[@title='Street Address']");
    private final By lc_city = By.xpath("//input[@name='city']");
    private final By lc_state = By.xpath("//select[@name='region_id']");
    private final By lc_postcode = By.xpath("//input[@name='postcode']");
    private final By lc_country = By.xpath("//select[@id='country']");
    private final By lc_phoneNumber = By.xpath("//input[@name='telephone']");
    private final By lc_saveAddress = By.xpath("//span[normalize-space()='Save Address']");
    private final By lc_successMsg = By.xpath("//div[.='You saved the address.']");

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public void editAddressDetails(String fName, String lName, String pNumber, String street0,
                                   String country, String state, String city, String postcode) {
        eleUtil.doClick(lc_editAddress);
        eleUtil.doSendKeys(lc_firstName, fName);
        eleUtil.doSendKeys(lc_lastName, lName);
        eleUtil.doSendKeys(lc_phoneNumber, pNumber);
        eleUtil.doSendKeys(lc_streetAddress, street0);
        eleUtil.doSelectDropDownByVisibleText(lc_country, country);
        eleUtil.doSelectDropDownByVisibleText(lc_state, state);
        eleUtil.doSendKeys(lc_city, city);
        eleUtil.doSendKeys(lc_postcode, postcode);
        eleUtil.doClick(lc_saveAddress);
    }

    public String verifyAddressSavedMessage() {
        eleUtil.waitForElementPresence(lc_successMsg, 5);
        return eleUtil.doGetElementText(lc_successMsg);
    }
}
