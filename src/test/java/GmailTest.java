import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest{

    @Test
    public void happyPath (){
        driver.get("https://www.google.com/intl/pl/gmail/about/");
        driver.findElement(By.cssSelector("[data-action='sign in']")).click();
        driver.findElement(By.id("identifierId")).click();

    }
}
