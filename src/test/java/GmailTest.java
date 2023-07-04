import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class GmailTest extends BaseTest{

    @Test (priority = 3)
    public void logINTest (){
        driver.get("https://www.google.com/intl/pl/gmail/about/");
        driver.findElement(By.cssSelector("[data-action='sign in']")).click();
        driver.findElement(By.id("identifierId")).sendKeys("lukasz.testowy.fake.konto");
        driver.findElement(By.id("identifierNext")).click();
        WebDriverWait waitForPass = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitForPass.until(ExpectedConditions.elementToBeClickable(By.name("Passwd")));
        driver.findElement(By.name("Passwd")).sendKeys("faketest321");
        driver.findElement(By.id("passwordNext")).click();
        WebDriverWait waitForPage = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForPage.until(ExpectedConditions.visibilityOfElementLocated(By.id("gb")));
        driver.findElement(By.cssSelector("[class='gb_d gb_Fa gb_x']")).click();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='account']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("[class='T6SHIc']")).click();


    }
    @Test (priority = 0)
    public void logInwithInvalidEmailTest () {
        driver.get("https://www.google.com/intl/pl/gmail/about/");
        driver.findElement(By.cssSelector("[data-action='sign in']")).click();
        driver.findElement(By.id("identifierId")).sendKeys("test" + " " + "test");
        driver.findElement(By.id("identifierNext")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Enter a valid email or phone number')]")));
        driver.findElement(By.xpath("//*[contains(text(), 'Enter a valid email or phone number')]")).isDisplayed();
    }
    @Test (priority = 1)
    public void logInWithNotExistGoogleAccountTest () {
        driver.get("https://www.google.com/intl/pl/gmail/about/");
        driver.findElement(By.cssSelector("[data-action='sign in']")).click();
        driver.findElement(By.id("identifierId")).sendKeys("jakikolwiekadresmailowyktorynieistnieje");
        driver.findElement(By.id("identifierNext")).click();
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Couldn’t find your Google Account')]")));
        driver.findElement(By.xpath("//*[contains(text(), 'Couldn’t find your Google Account')]")).isDisplayed();
    }

    @Test (priority = 2)
    public void logInwithInvalidPasswordTest () {
        driver.get("https://www.google.com/intl/pl/gmail/about/");
        driver.findElement(By.cssSelector("[data-action='sign in']")).click();
        driver.findElement(By.id("identifierId")).sendKeys("lukasz.testowy.fake.konto");
        driver.findElement(By.id("identifierNext")).click();
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait5.until(ExpectedConditions.elementToBeClickable(By.name("Passwd")));
        driver.findElement(By.name("Passwd")).sendKeys("faketest");
        driver.findElement(By.id("passwordNext")).click();
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]")));
        driver.findElement(By.xpath("//*[contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]")).isDisplayed();
    }

}
