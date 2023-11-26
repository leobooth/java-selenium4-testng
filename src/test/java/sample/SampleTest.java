package sample;

import com.leobooth.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

  @Test
  public void testPageTitle() {
    WebDriver driver = initiateTestDriver();
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/");
    String expectedTitle = "The Internet";
    String actualTitle = driver.getTitle();
    WaitUtils.hardWaitForSeconds(2);

    Assert.assertEquals(actualTitle, expectedTitle);
    driver.quit();
  }
}
