package dobryagin_shagiev;// Generated by Selenium IDE

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class AuthorizationFailTest {
  private WebDriver driver;
  private Map<String, Object> vars;

  private static final String message = "Ошибка. Вы ввели неверные данные авторизации";

  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void authorizationFail() throws InterruptedException {
    // Test name: authorizationFail
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://pikabu.ru/");
    // 2 | setWindowSize | 1536x864 | 
    driver.manage().window().setSize(new Dimension(1536, 864));
    // 3 | click | //*[@id="signin-form"]/div[1]/div/div/input | 
    driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[1]/div/div/input")).click();
    // 4 | type | //*[@id="signin-form"]/div[1]/div/div/input | cenec51975
    driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[1]/div/div/input")).sendKeys("cenec51975");
    // 5 | type | //*[@id="signin-form"]/div[2]/div/div/input | 1234567
    driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[2]/div/div/input")).sendKeys("1234567");
    // 6 | click | //*[@id="signin-form"]/div[7]/button | 
    driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[7]/button")).click();
    // 7 | assertText | //*[@id="signin-form"]/div[5]/span | Ошибка. Вы ввели неверные данные авторизации
    Thread.sleep(2000);
    var hhh = driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[5]/span")).getText();
    Assertions.assertEquals(hhh, message);
  }
}