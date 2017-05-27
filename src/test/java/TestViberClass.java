/**
 * Created by Andrey on 27/05/2017.
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestViberClass {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.google.co.il/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get("https://www.google.co.il/");
        driver.findElement(By.id("lst-ib")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("lst-ib")).sendKeys("viber");
        driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Viber | Бесплатные звонки, сообщения и обмен фото везде и со ...")).click();
        driver.findElement(By.linkText("Viber Out")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//section[@id='content']/div/div/div/div[2]/div/ul/li[2]/a")).click();
        Thread.sleep(2000);

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
