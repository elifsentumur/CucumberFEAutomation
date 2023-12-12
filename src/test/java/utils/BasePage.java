package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;


public class BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000).toMillis());
        LOGGER.info("Before - Initialize WebDriver");
    }

    // Sayfa yüklenmesini kontrol etmek için
    public void waitForPageLoad(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    // Elementin görünürlüğünü kontrol etmek için
    public void waitForVisibility(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        LOGGER.info("Visibilty element with locator: {}", element);
    }

    //Elementin text'ini almak için
    public String waitGetText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        LOGGER.info("Wait element getText: {}", element.getText().toString());
        return element.getText().toString();
    }

    // Elementin tıklanabilir olmasını kontrol etmek için
    public void waitForClickability(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        LOGGER.info("Clicked element with locator: {}", locator);
    }

    // Elementin değerini kontrol etmek için
    public void waitForValueToBe(By locator, String expectedValue) {
        wait.until(ExpectedConditions.textToBe(locator, expectedValue));
        LOGGER.info("Wait element with locator: {}", locator, "Wait text : ", expectedValue);
    }

    // Bir elementin varlığını kontrol etmek için
    public void waitForPresenceOfElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Sayfa URL'sinin belirli bir değeri beklemek için
    public void waitForUrlToBe(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    // Elemente veri gönderme işlemini kontrol etmek için
    public void waitForSendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        LOGGER.info("Typed '{}' into element with locator: {}", text, locator);
    }

    //Elemente veri göndermek için
    public void waitForSendKeysEnter(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.sendKeys(Keys.ENTER);
        LOGGER.info("Typed '{}' into element with locator: {}", locator);
    }

    public void waitForAllertMesageAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            // Alert bulunamadı, istediğiniz işlemleri gerçekleştirin veya hatayı loglayın.
        }
    }

    public void waitAssertMultipleText(By locator, String t1, String t2, String t3, String t4, String t5, String t6, String t7) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String sizeText = element.getText();
        Assert.assertEquals(sizeText, "" + t1 + "" + t2 + "" + t3 + "" + t4 + "" + t5 + "" + t6 + "" + t7); // Boyutlar beklenen değerlere mi sahip?
    }

    //İlgili web sitesinin url'sini al
    public String waitGetCurrentUrl() {
        driver.getCurrentUrl();
        return driver.getCurrentUrl();
    }

    //Element kontrolün varlığı
    public boolean isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            LOGGER.info("Element with locator {} is present.", locator);
            return true;
        } catch (TimeoutException e) {
            LOGGER.info("Element with locator {} is NOT present.", locator);
            return false;
        }
    }

    public boolean isElementNotPresent(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            LOGGER.info("Element with locator {} is NOT present.", locator);
            return true;
        } catch (TimeoutException e) {
            LOGGER.info("Element with locator {} is present.", locator);
            return false;
        }
    }
}
