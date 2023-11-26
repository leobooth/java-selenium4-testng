package abcMouse;

import com.leobooth.WaitUtils;
import com.leobooth.pages.abcMouse.CaptchaPage;
import com.leobooth.pages.abcMouse.HomePage;
import com.leobooth.pages.abcMouse.ProspectRegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends ABCMouseBaseTest {

    @Test
    public void testLogin() {
        WebDriver driver = setupDriver();
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);

        // TODO: bypass "prove you are a human" check
        homePage.navToPage();
        CaptchaPage captchaPage = new CaptchaPage(driver);
        if (captchaPage.isBrowserOnPage() && captchaPage.isVerifyHumanLabelVisible()) {
            Assert.fail("test has been blocked by ABCMouse automation detection.");
        }

        // TODO: replace with wait for element(s) to load
        WaitUtils.hardWaitForSeconds(2);
        homePage.clickSignupButton();

        ProspectRegisterPage prospectRegisterPage = new ProspectRegisterPage(driver);
        // TODO: replace with wait for element(s) to load
        WaitUtils.hardWaitForSeconds(3);
        Assert.assertTrue(prospectRegisterPage.isBrowserOnPage());

        String actualPageTitle = prospectRegisterPage.getPageTitle();
        String expectedPageTitle = "ABCmouse: Educational Games, Books, Puzzles & Songs for Kids & Toddlers";
        System.out.println("Page title: " + actualPageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        String expectedText = "Become a Member!";
        String actualText = prospectRegisterPage.getBecomeAMemberText();
        System.out.println("'Become A Member' text: " + actualText);
        Assert.assertEquals(actualText, expectedText);

        // Enter Email address (any email address)
        // Click “Submit” button
        // Verify that ABCmouse.com page is returned.

        // Verify that on subscription page, “Become a Member!” text is rendered.
    }
}
