package com.leobooth.abcMouse;

import com.leobooth.WaitUtils;
import com.leobooth.pages.abcMouse.CaptchaPage;
import com.leobooth.pages.abcMouse.HomePage;
import com.leobooth.pages.abcMouse.ProspectRegisterPage;
import com.leobooth.pages.abcMouse.SubscriptionPage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends ABCMouseBaseTest {


    private String generateEmail(String emailAddress) {
        String username;
        String domainAndExtension;

        username = emailAddress.substring(0,emailAddress.indexOf("@"));
        domainAndExtension = emailAddress.substring(emailAddress.indexOf("@"));

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        String dateSection = dateFormatter.format(localDateTime);
        String timeSection = timeFormatter.format(localDateTime);

        // if there is a nanosecond time portion, remove it
        if(timeSection.contains(".")) {
            timeSection = timeSection.substring(0, timeSection.indexOf("."));
        }

        // remove unwanted characters from the timestamp
        dateSection = dateSection.replace("-", "");
        timeSection = timeSection.replace(":", "");
        String timestamp = dateSection + "at" + timeSection;

        return username + "+" + timestamp + domainAndExtension;
    }

    public void testGenerateEmail() {
        String emailAddress = "leoboothtx@gmail.com";
        String testEmail = generateEmail(emailAddress);
        System.out.println("test email: " + testEmail);
    }

    public void testLoginWithGeneratedEmail() {
        testLogin("https://www.abcmouse.com/", "true", "leoboothtx@gmail.com");
    }

    // TODO: parameterize test
    // url, and email address is read from config file.
    @Test
    @Parameters({"url", "generateEmail", "emailAddress"})
    public void testLogin(String url, String generateEmail, String emailAddress) {
        WebDriver driver = setupDriver();
        driver.manage().window().maximize();

        String actualPageTitle = "";
        String expectedPageTitle = "";
        String expectedText = "";
        String actualText = "";

        HomePage homePage = new HomePage(driver, url);
        homePage.navToPage();

        // TODO: bypass "prove you are a human" check
        try {
            CaptchaPage captchaPage = new CaptchaPage(driver);
            if (captchaPage.isBrowserOnPage() && captchaPage.isVerifyHumanLabelVisible()) {
                Assert.fail("test has been blocked by ABCMouse automation detection.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("automation detection did not block test; continue");
        }

        // TODO: replace with wait for element(s) to load
        WaitUtils.hardWaitForSeconds(3);
        Assert.assertTrue(homePage.isBrowserOnPage(), "The browser did not navigate to the expected page: " + homePage.getPageName());
        homePage.clickSignupButton();

        ProspectRegisterPage prospectRegisterPage = new ProspectRegisterPage(driver);
        // TODO: replace with wait for element(s) to load
        WaitUtils.hardWaitForSeconds(3);
        Assert.assertTrue(prospectRegisterPage.isBrowserOnPage(), "The browser did not navigate to the expected page:" + prospectRegisterPage.getPageName());

        actualPageTitle = prospectRegisterPage.getPageTitle();
        expectedPageTitle = "ABCmouse: Educational Games, Books, Puzzles & Songs for Kids & Toddlers";
        System.out.println("Page title: " + actualPageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Prospect Register Page title is not visible.");

        expectedText = "Become a Member!";
        actualText = prospectRegisterPage.getBecomeAMemberText();
        System.out.println("Page call-to-action: " + actualText);
        Assert.assertEquals(actualText, expectedText, "'Become A Member' call-to-action is not visible.");

        String testEmailAddress = "";
        if (generateEmail.equalsIgnoreCase("true")) {
            testEmailAddress = generateEmail(emailAddress);
        } else {
            testEmailAddress = emailAddress;
        }

        prospectRegisterPage.enterEmailAddress(testEmailAddress);
        System.out.println("test email address: " + testEmailAddress);
        // short wait to ensure email is entered before form is submitted
        WaitUtils.hardWaitForSeconds(1);
        prospectRegisterPage.clickSubmitButton();

        SubscriptionPage subscriptionPage = new SubscriptionPage(driver);
        // TODO: replace with wait for element(s) to load
        WaitUtils.hardWaitForSeconds(3);
        Assert.assertTrue(subscriptionPage.isBrowserOnPage(), "The browser did not navigate to the expected page:" + subscriptionPage.getPageName());

        expectedText = "Create Your Account";
        actualText = subscriptionPage.getCallToActionText();
        System.out.println("Page call-to-action: " + actualText);
        Assert.assertEquals(actualText, expectedText, "'Create Your Account' call-to-action is not visible.");
    }
}