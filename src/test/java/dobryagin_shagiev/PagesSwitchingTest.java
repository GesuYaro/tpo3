package dobryagin_shagiev;// Generated by Selenium IDE

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagesSwitchingTest {
  private WebDriver driver;
  private Map<String, Object> vars;

  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void switchPages() throws InterruptedException {
    driver.get("http://pikabu.ru");
    driver.findElement(By.xpath("//div[contains(@class, 'header-right-menu__search')]")).click();
    driver.findElement(By.xpath("//div[contains(@class, 'header-right-menu__search')]//form//input[@placeholder='Поиск']")).sendKeys("Java");

    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[contains(@class, 'header-right-menu__search')]//form//button[@type='submit']")).click();
    vars.put("stories_number", js.executeScript("return document.getElementsByClassName('story').length"));
    assertEquals(vars.get("stories_number").toString(), "10");
    assertEquals("1", driver.findElement(By.xpath("//span[contains(@class, 'pagination__page')]")).getText());
    driver.findElement(By.xpath("//a[contains(@class, 'pagination__page')][2]")).click();
    vars.put("uuurl", js.executeScript("return document.URL"));
    assertEquals(vars.get("uuurl").toString(), "https://pikabu.ru/search?q=Java&st=3&page=3");
  }
}
