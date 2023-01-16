package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AppConstants;
import utils.ElementUtil;
import utils.TimeUtil;

public class AccountPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private final By lc_men = By.xpath("//span[normalize-space()='Men']");
    private final By lc_tops = By.xpath("//a[contains(@href,'tops-men.html')]//span[contains(text(),'Tops')]");
    private final By lc_jackets = By.xpath("//a[contains(@href,'jackets-men.html')]//span[contains(text(),'Jackets')]");
    private final By lc_bottoms = By.xpath("//a[contains(@href,'bottoms-men.html')]//span[contains(text(),'Bottoms')]");
    private final By lc_pants = By.xpath("//a[contains(@href,'pants-men.html')]//span[contains(text(),'Pants')]");
    private final By lc_productAddedMsg = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By productList = By.cssSelector(".product.name.product-item-name");
    private final By productSizeList = By.xpath("//div[@class='swatch-option text'][@role='option']");
    private final By productColorList = By.xpath("//div[@class='swatch-option color']");
    private final By lc_addToCartButton = By.xpath("//span[normalize-space()='Add to Cart']");
    private final By lc_cartLink = By.xpath("//a[@class='action showcart']");
    private final By lc_checkout = By.xpath("//button[@id='top-cart-btn-checkout']");
    private final By lc_myOrder = By.xpath("//a[normalize-space()='My Orders']");
    private final By lc_productName = By.xpath("//h1[@class = 'page-title']//span[@itemprop=\"name\"]");
    private final By lc_productPrice = By.xpath("//div[contains(@class,'product-info-price')]//span[contains(@id,'product-price')]//span[@class='price']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }


    @Step("get Account Page Url")
    public String getAccPageURL() {
        return eleUtil.waitForUrlContains(AppConstants.ACC_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
    }

    public String getProductName() {
        return eleUtil.doGetElementText(lc_productName);
    }

    public String getProductPrice() {
        return eleUtil.doGetElementText(lc_productPrice);
    }

    public void selectJacket() {
        eleUtil.moveToElement(lc_men);
        eleUtil.moveToElement(lc_tops);
        eleUtil.doClick(lc_jackets);
    }

    public void selectPant() {
        eleUtil.moveToElement(lc_men);
        eleUtil.moveToElement(lc_bottoms);
        eleUtil.doClick(lc_pants);
    }

    public void selectProductName(String productName) {
        for (WebElement product : eleUtil.getElements(productList)) {
            if (product.getText().contains(productName)) {
                product.click();
                break;
            }
        }
    }

    public String getProductAddedMsg() {
        eleUtil.waitForElementPresence(lc_productAddedMsg, 5);
        return eleUtil.doGetElementText(lc_productAddedMsg);
    }

    public void selectProductSize(String productSize) {
        for (WebElement size : eleUtil.getElements(productSizeList)) {
            if (size.getText().contains(productSize)) {
                size.click();
                break;
            }
        }
    }

    public void selectProductColor(String productColor) {
        for (WebElement color : eleUtil.getElements(productColorList)) {
            if (color.getAttribute("aria-label").contains(productColor)) {
                color.click();
                break;
            }
        }
    }

    public void selectSpecificProduct(String productName, String productSize, String productColor) {
        selectProductName(productName);
        selectProductSize(productSize);
        selectProductColor(productColor);
        eleUtil.doClick(lc_addToCartButton);
    }

    public void goToCartAndCheckout() {
        eleUtil.waitForElementPresence(lc_cartLink, 5);
        eleUtil.doClick(lc_cartLink);
        eleUtil.doClick(lc_checkout);
    }

    public void goToMyOrders() {
        eleUtil.waitForElementPresence(lc_myOrder, 5);
        eleUtil.doClick(lc_myOrder);
    }

    @Step("Go to checkout page")
    public CheckoutPage navigateToCheckout() {
        driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#shipping");
        eleUtil.waitForTitleIs(AppConstants.CHECKOUT_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
        return new CheckoutPage(driver);
    }
}

