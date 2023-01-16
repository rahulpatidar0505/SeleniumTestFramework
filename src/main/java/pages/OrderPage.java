package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class OrderPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By orderRowList = By.xpath("//table[@id=\"my-orders-table\"]//tr");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String verifySubmittedOrder() {
        String beforeXpath = "//table[@id=\"my-orders-table\"]//tr[";
        String afterXpath = "]/td[1]";
        String text = null;
        for (int i = 1; i <= eleUtil.getElements(orderRowList).size(); i++) {
            String finalXpath = beforeXpath + i + afterXpath;
            text = driver.findElement(By.xpath(finalXpath)).getText();
            break;
        }
        return text;
    }

}