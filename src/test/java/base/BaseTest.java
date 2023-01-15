package base;

import java.util.Properties;
import factory.DriverFactory;
import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected AddressPage addressPage;
	protected CheckoutPage checkoutPage;
	protected OrderPage orderPage;
	protected SoftAssert softAssert;
	protected Properties prop;
	
	@BeforeClass
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);

		loginPage = new LoginPage(driver);
		addressPage = new AddressPage(driver);
		accountPage =  new AccountPage(driver);
		checkoutPage = new CheckoutPage(driver);
		orderPage = new OrderPage(driver);

		softAssert = new SoftAssert();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
