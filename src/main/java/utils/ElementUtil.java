package utils;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ElementUtil {

    private WebDriver driver;
    private JavaScriptUtil jsUtil;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        jsUtil = new JavaScriptUtil(driver);
    }

    public WebElement getElement(By locator) {
        WebElement ele = driver.findElement(locator);
        if (Boolean.parseBoolean(DriverFactory.highlight)) {
            jsUtil.flash(ele);
        }
        return ele;
    }

    public void doSendKeys(By locator, String value) {
        WebElement ele = getElement(locator);
        ele.clear();
        ele.sendKeys(value);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public String doGetElementText(By locator) {
        return getElement(locator).getText();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public boolean doIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public void doSelectDropDownByVisibleText(By locator, String text) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    public void moveToElement(By locator) {
        WebElement element = getElement(locator);
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public String waitForTitleIs(String titleVal, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.titleIs(titleVal))) {
            return driver.getTitle();
        } else {
            System.out.println("expected title is not visible...");
            return null;
        }
    }


    public String waitForUrlContains(String urlFractionValue, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.urlContains(urlFractionValue))) {
            return driver.getCurrentUrl();
        } else {
            System.out.println("expected url is not visible...");
            return null;
        }
    }

    public void staleElementRefExceptionSolution(WebElement element) {

        for (int i = 0; i <= 3; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementPresence(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
