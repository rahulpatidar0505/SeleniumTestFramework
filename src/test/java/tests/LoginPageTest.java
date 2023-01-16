package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import utils.AppConstants;
import utils.AppErrors;

public class LoginPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        loginPage.clickOnSignInLink();
    }

    @Description("login page title test")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(priority = 1)
    public void loginPageTitleTest() {
        String loginTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(loginTitle, AppConstants.LOGIN_PAGE_TITLE, AppErrors.NO_TITLE_MATCHED);
    }

    @Description("login page url test")
    @Test(priority = 2)
    public void loginPageURLTest() {
        String actURL = loginPage.getLoginPageUrl();
        Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), AppErrors.NO_URL_MATCHED);
    }

    @Description("forgot password link test")
    @Test(priority = 3)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isforgotPWdLinkExist());
    }

    @Description("invalid email address test")
    @Test(priority = 4)
    public void invalidEmailAddressTest() {
        loginPage.customerLogin(RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(5));
        String errMsg = loginPage.verifyInvalidEmailErrorMsg();
        Assert.assertTrue(errMsg.contains("Please enter a valid email address"));
    }

    @Description("invalid login test")
    @Test(priority = 5)
    public void inValidLoginTest() throws InterruptedException {
        loginPage.customerLogin(RandomStringUtils.randomAlphanumeric(5)+"@gmail.com", RandomStringUtils.randomAlphanumeric(5));
        String errMsg = loginPage.verifyInvalidLoginErrorMsg();
        Assert.assertTrue(errMsg.contains("The account sign-in was incorrect or your account is disabled temporarily"));
    }

    @Description("valid login test")
    @Test(priority = 6)
    public void validLoginTest() {
        loginPage.customerLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

}
