package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class PaymentIframePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentIframePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchToIframe(WebElement iframe) {
        driver.switchTo().frame(iframe);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public boolean isAmountDisplayed(String amount) {
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='" + amount + " BYN']")));
        return amountElement.isDisplayed();
    }

    public boolean isPhoneDisplayed(String phone) {
        WebElement phoneElement = driver.findElement(By.xpath("//span[contains(text(), '" + phone + "')]"));
        return phoneElement.isDisplayed();
    }

    public String getPlaceholderByLabel(String labelText) {
        WebElement label = driver.findElement(By.xpath("//label[contains(text(), '" + labelText + "')]"));
        return label.getText();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(By.xpath("//div[contains(@class, 'cards-brands__container')]"));
    }
}
