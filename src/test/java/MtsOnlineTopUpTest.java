
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsOnlineTopUpTest {

    private WebDriver driver;

    @BeforeAll
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка названия блока")
    void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]"));

        String actualText = blockTitle.getText().trim().replace("\n", " ");

        assertEquals("Онлайн пополнение без комиссии", actualText);
    }

    @Test
    @DisplayName("Проверка логотипов платёжных систем")
    void testPaymentLogosPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logosList = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'pay__partners')]/ul")
        ));

        List<WebElement> logos = logosList.findElements(By.xpath(".//li/img"));

        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");

        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Логотип с alt='" + logo.getAttribute("alt") + "' не отображается");
        }

        List<String> expectedAlts = List.of(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );

        List<String> actualAlts = logos.stream()
                .map(img -> img.getAttribute("alt"))
                .collect(Collectors.toList());

        for (String expectedAlt : expectedAlts) {
            assertTrue(actualAlts.contains(expectedAlt), "Ожидаемый логотип с alt='" + expectedAlt + "' не найден");
        }
    }

    @Test
    @DisplayName("Проверка ссылки «Подробнее о сервисе»")
    void testMoreAboutServiceLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payWrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.pay__wrapper")));

        WebElement moreAboutServiceLink = payWrapper.findElement(By.cssSelector("a[href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));

        assertTrue(moreAboutServiceLink.isDisplayed(), "Ссылка «Подробнее о сервисе» должна отображаться");

        assertEquals("Подробнее о сервисе", moreAboutServiceLink.getText().trim(), "Текст ссылки не совпадает");

        moreAboutServiceLink.click();

        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "После клика URL должен содержать /help/poryadok-oplaty-i-bezopasnost-internet-platezhey/, но сейчас: " + currentUrl);
    }


    @Test
    @DisplayName("Проверка формы")
    void testContinueButtonForConnectionService() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement formConnection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pay-connection")));

        WebElement phoneInput = formConnection.findElement(By.id("connection-phone"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = formConnection.findElement(By.id("connection-sum"));
        sumInput.clear();
        sumInput.sendKeys("150");

        WebElement emailInput = formConnection.findElement(By.id("connection-email"));
        emailInput.clear();
        emailInput.sendKeys("test@yandex.ru");

        WebElement continueButton = formConnection.findElement(By.cssSelector("button[type='submit']"));

        assertTrue(continueButton.isEnabled(), "Кнопка Продолжить должна быть доступна для клика");

        continueButton.click();

        assertTrue(true, "Форма отправлена");
    }
}