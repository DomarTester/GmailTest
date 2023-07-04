import org.testng.annotations.Test;
import Pages.LoggedUserPage;
import Pages.LoginPage;
public class GmailTest extends BaseTest{



        @Test
        public void logInUserTest() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openHomePage();
            loginPage.clickSignInButton();
            loginPage.setUsername("lukasz.testowy.fake.konto");
            loginPage.setPassword("faketest321");
            LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
            loggedUserPage.logoutUser();
        }

        @Test
        public void logInWithInvalidEmailTest() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openHomePage();
            loginPage.clickSignInButton();
            loginPage.setUsername("test" +" " + "test");
            loginPage.checkErrorMessage("Enter a valid email or phone number");
        }

        @Test
        public void logInWithInvalidPasswordTest() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openHomePage();
            loginPage.clickSignInButton();
            loginPage.setUsername("lukasz.testowy.fake.konto");
            loginPage.setPassword("faketest");
            loginPage.checkErrorMessage("Wrong password. Try again or click Forgot password to reset it");
        }

        @Test
        public void logInToNonExistingAccountTest() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openHomePage();
            loginPage.clickSignInButton();
            loginPage.setUsername("jakikolwiekadresmailowyktorynieistnieje");
            loginPage.checkErrorMessage("Couldn’t find your Google Account");
        }
    }

