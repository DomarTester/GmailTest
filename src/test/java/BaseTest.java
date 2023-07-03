import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @AfterTest
    public void closeBrowser() {
       driver.quit();
   }


}
