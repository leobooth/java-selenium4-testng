package abcMouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ABCMouseBaseTest {

  private WebDriver driver;

  WebDriver getDriver() {
    return driver;
  }

  @BeforeClass
  public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
