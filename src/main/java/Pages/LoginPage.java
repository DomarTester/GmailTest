package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SeleniumHelper;

public class LoginPage {

    @FindBy(css = "[data-action='sign in']")
    private WebElement signInButton;

    @FindBy(id = "identifierId")
    private WebElement usernameInput;

    @FindBy(id = "identifierNext")
    private WebElement usernameNextButton;

    @FindBy(name = "Passwd")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://www.google.com/intl/pl/gmail/about/");
    }

    public void clickSignInButton() {
        signInButton.click();
    }
    public void setUsername(String username) {
        usernameInput.sendKeys(username);
        usernameNextButton.click();
    }

    public void setPassword(String password) {
        SeleniumHelper.waitForCondition(driver,ExpectedConditions.elementToBeClickable(By.name("Passwd")));
        passwordInput.sendKeys(password);
        passwordNextButton.click();
    }

    public void checkErrorMessage(String msg) {
        SeleniumHelper.waitForCondition(driver,ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '"+msg+"')]")));
    }

}

