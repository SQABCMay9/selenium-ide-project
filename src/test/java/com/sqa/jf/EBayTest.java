package com.sqa.jf;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EBayTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.ebay.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEBay() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input")).clear();
    driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input")).sendKeys("sqasolution@hotmail.com");
    driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).clear();
    driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).sendKeys("sqaadmin2016");
    driver.findElement(By.id("sgnBt")).click();
    driver.findElement(By.id("gh-ac")).click();
    driver.findElement(By.id("gh-ac")).clear();
    driver.findElement(By.id("gh-ac")).sendKeys("shoe");
    driver.findElement(By.id("gh-btn")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.linkText("2016 NEW Fashion England Men's Breathable Recreational Shoes Casual Shoes")).click();
    driver.findElement(By.xpath("//div[@id='vi_main_img_fs']/ul/li[3]")).click();
    new Select(driver.findElement(By.id("msku-sel-1"))).selectByVisibleText("Black");
    driver.findElement(By.xpath("//div[@id='vi_main_img_fs']/ul/li[3]")).click();
    new Select(driver.findElement(By.id("msku-sel-2"))).selectByVisibleText("8");
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.id("qtyTextBox")).clear();
    driver.findElement(By.id("qtyTextBox")).sendKeys("3");
    driver.findElement(By.id("isCartBtn_btn")).click();
    driver.findElement(By.id("gh-cart-i")).click();
    driver.findElement(By.linkText("Remove")).click();
    driver.findElement(By.cssSelector("b.gh-eb-arw.gh-sprRetina")).click();
    driver.findElement(By.linkText("Sign out")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
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
