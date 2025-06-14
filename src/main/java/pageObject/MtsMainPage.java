package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class MtsMainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public String getBlockTitleText() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]"));
        return blockTitle.getText().trim().replace("\n", " ");
    }

    public List<WebElement> getPaymentLogos() {
        WebElement logosList = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'pay__partners')]/ul")));
        return logosList.findElements(By.xpath(".//li/img"));
    }

    public WebElement getMoreAboutServiceLink() {
        WebElement wrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.pay__wrapper")));
        return wrapper.findElement(By.cssSelector("a[href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
    }

    public WebElement getFormById(String formId) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(formId)));
    }

    public WebElement getInputById(WebElement form, String inputId) {
        return form.findElement(By.id(inputId));
    }

    public WebElement getSubmitButton(WebElement form) {
        return form.findElement(By.cssSelector("button[type='submit']"));
    }

    public void fillForm(WebElement form, String phoneId, String phone, String sumId, String sum, String emailId, String email) {
        getInputById(form, phoneId).clear();
        getInputById(form, phoneId).sendKeys(phone);

        getInputById(form, sumId).clear();
        getInputById(form, sumId).sendKeys(sum);

        getInputById(form, emailId).clear();
        getInputById(form, emailId).sendKeys(email);
    }

    public void submitForm(WebElement form) {
        getSubmitButton(form).click();
    }

    public WebElement getIframe() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.bepaid-app__container iframe.bepaid-iframe")));
    }
}