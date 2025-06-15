import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


import pageObject.MtsMainPage;
import pageObject.PaymentIframePage;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsTest {

    private WebDriver driver;
    private MtsMainPage mainPage;
    private PaymentIframePage iframePage;

    @BeforeAll
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        mainPage = new MtsMainPage(driver);
        iframePage = new PaymentIframePage(driver);
        mainPage.open();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockTitleText());
    }

    @Test
    void testPaymentLogosPresence() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        assertFalse(logos.isEmpty());

        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }

        List<String> expectedAlts = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        List<String> actualAlts = logos.stream()
                .map(e -> e.getAttribute("alt"))
                .collect(Collectors.toList());

        for (String expected : expectedAlts) {
            assertTrue(actualAlts.contains(expected));
        }
    }

    @Test
    void testMoreAboutServiceLink() {
        WebElement link = mainPage.getMoreAboutServiceLink();
        assertTrue(link.isDisplayed());
        assertEquals("Подробнее о сервисе", link.getText().trim());
        link.click();
        assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    void testContinueButtonForConnectionService() {
        WebElement form = mainPage.getFormById("pay-connection");
        mainPage.fillForm(form, "connection-phone", "297777777", "connection-sum", "150", "connection-email", "test@yandex.ru");
        WebElement button = mainPage.getSubmitButton(form);
        assertTrue(button.isEnabled());
        button.click();
    }

    @Test
    void testPlaceholdersInAllPaymentForms() {
        String[][] forms = {
                {"pay-connection", "connection-phone", "Номер телефона", "connection-sum", "Сумма", "connection-email", "E-mail для отправки чека"},
                {"pay-internet", "internet-phone", "Номер абонента", "internet-sum", "Сумма", "internet-email", "E-mail для отправки чека"},
                {"pay-instalment", "score-instalment", "Номер счета на 44", "instalment-sum", "Сумма", "instalment-email", "E-mail для отправки чека"},
                {"pay-arrears", "score-arrears", "Номер счета на 2073", "arrears-sum", "Сумма", "arrears-email", "E-mail для отправки чека"}
        };

        for (String[] form : forms) {
            WebElement formElement = mainPage.getFormById(form[0]);
            for (int i = 1; i < form.length; i += 2) {
                WebElement input = mainPage.getInputById(formElement, form[i]);
                assertEquals(form[i + 1], input.getAttribute("placeholder"));
            }
        }
    }

    @Test
    void testConnectionServiceFormSubmissionAndIframeData() {
        WebElement form = mainPage.getFormById("pay-connection");
        mainPage.fillForm(form, "connection-phone", "297777777", "connection-sum", "100", "connection-email", "test@yandex.ru");
        mainPage.submitForm(form);

        WebElement iframe = mainPage.getIframe();
        iframePage.switchToIframe(iframe);

        assertTrue(iframePage.isAmountDisplayed("100.00"));
        assertTrue(iframePage.isPhoneDisplayed("297777777"));

        assertEquals("Номер карты", iframePage.getPlaceholderByLabel("Номер карты"));
        assertEquals("Срок действия", iframePage.getPlaceholderByLabel("Срок действия"));
        assertEquals("CVC", iframePage.getPlaceholderByLabel("CVC"));
        assertEquals("Имя и фамилия на карте", iframePage.getPlaceholderByLabel("Имя и фамилия"));

        assertFalse(iframePage.getPaymentLogos().isEmpty());

        iframePage.switchToDefault();
    }
}

