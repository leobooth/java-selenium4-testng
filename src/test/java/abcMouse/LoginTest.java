package abcMouse;

import com.leobooth.WaitUtils;
import com.leobooth.pages.abcMouse.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LoginTest extends ABCMouseBaseTest {

    @Test
    public void testLogin() {
        getDriver().manage().window().maximize();

        HomePage homePage = new HomePage(getDriver());
        // TODO: handle "prove you are a human" check
        homePage.navToPage();
        WaitUtils.hardWaitForSeconds(2);
        homePage.clickSignupButton();
    }
}
