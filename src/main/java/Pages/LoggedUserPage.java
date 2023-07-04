package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SeleniumHelper;

public class LoggedUserPage {

    @FindBy(id="gb")
    private WebElement loggedUserBanner;
    @FindBy(css = "[class='gb_d gb_Fa gb_x']")
    private WebElement loggedUserIcon;
    @FindBy(xpath = "//iframe[@name='account']")
    private WebElement accountIframe;
    @FindBy(css = "[class='T6SHIc']")
    private WebElement logoutLink;

    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void logoutUser () {
        SeleniumHelper.waitForCondition(driver, ExpectedConditions.visibilityOfElementLocated(By.id("gb")));
        loggedUserIcon.click();
        driver.switchTo().frame(accountIframe);
        logoutLink.click();
    }



}
