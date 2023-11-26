package abcMouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ABCMouseBaseTest {

  private WebDriver driver;

  public WebDriver setupDriver() {
    WebDriverManager.chromedriver().setup();
    return driver = new ChromeDriver();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
