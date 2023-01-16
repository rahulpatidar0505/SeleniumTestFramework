package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AppConstants;
import utils.ElementUtil;
import utils.TimeUtil;

public class LoginPage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    private final By lc_signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    private final By lc_email = By.id("email");
    private final By lc_password = By.id("pass");
    private final By lc_signInButton = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
    private final By forgotPwdLink = By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]");
    private final By lc_accountPanelArrow = By.xpath("//div[@class='panel header']//button[@type='button']");
    private final By lc_myAccount = By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']");
    private final By lc_invalidLoginErrorMsg = By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By lc_emailErrorMsg = By.xpath("//div[@id='email-error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    @Step("getting login page title...")
    public String getLoginPageTitle() {
        return eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
    }

    @Step("get Login Page Url")
    public String getLoginPageUrl() {
        return eleUtil.waitForUrlContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
    }

    @Step("checking forgot pwd link exist")
    public boolean isforgotPWdLinkExist() {
        return eleUtil.doIsDisplayed(forgotPwdLink);
    }

    public void clickOnSignInLink() {
        eleUtil.doClick(lc_signInLink);
    }

    public String verifyInvalidLoginErrorMsg() throws InterruptedException {
        eleUtil.waitForElementPresence(lc_invalidLoginErrorMsg, 10);
        eleUtil.staleElementRefExceptionSolution(eleUtil.getElement(lc_invalidLoginErrorMsg));
        return eleUtil.doGetElementText(lc_invalidLoginErrorMsg);
    }

    public void customerLogin(String emailId, String passowrd) {
        eleUtil.waitForElementVisible(lc_email, TimeUtil.DEFAULT_TIME_OUT).sendKeys(emailId);
        eleUtil.doSendKeys(lc_password, passowrd);
        eleUtil.doClick(lc_signInButton);
    }

    public String verifyInvalidEmailErrorMsg() {
        eleUtil.waitForElementPresence(lc_emailErrorMsg, 10);
        return eleUtil.doGetElementText(lc_emailErrorMsg);
    }

    public void goToMyAccount() {
        eleUtil.waitForElementPresence(lc_accountPanelArrow, 5);
        eleUtil.doClick(lc_accountPanelArrow);
        eleUtil.doClick(lc_myAccount);
    }

    @Step("login with username : {0} and password: {1}")
    public AccountPage doLogin(String un, String pwd) {
        clickOnSignInLink();
        customerLogin(un, pwd);
        return new AccountPage(driver);
    }
}
