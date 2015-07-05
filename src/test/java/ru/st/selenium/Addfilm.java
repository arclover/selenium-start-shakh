package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Addfilm extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testAddfilm() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("My First Film");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Syberia");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2014");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("120");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("10");
    driver.findElement(By.id("loaned_yes")).click();
    driver.findElement(By.id("submit")).click();
 }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}