package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MtsWebPage;
import static org.junit.jupiter.api.Assertions.*;

public class MtsWebPageTest {

    private WebDriver driver;
    private MtsWebPage webPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        webPage = new MtsWebPage(driver);
        webPage.handleCookiePopup();
    }

    @Test
    public void testBlockTitle() {
        assertTrue(webPage.isHeaderDisplayed(), "Заголовок блока не отображается");
        String headerText = webPage.getHeaderText();
        assertTrue(headerText.contains("Онлайн пополнение"),
                "Заголовок не содержит ожидаемый текст. Фактический текст: " + headerText);
        assertTrue(headerText.contains("без комиссии"),
                "Заголовок не содержит текст 'без комиссии'. Фактический текст: " + headerText);
    }

    @Test
    public void testPaymentSystemsLogos() {
        assertTrue(webPage.arePaymentLogosDisplayed(), "Логотипы платёжных систем не отображаются");
        assertTrue(webPage.getPaymentLogosCount() >= 5, "Неверное количество логотипов платёжных систем");
    }

    @Test
    public void testServiceDetailsLink() {
        assertTrue(webPage.isServiceDetailsLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");

        String initialUrl = driver.getCurrentUrl();
        webPage.clickServiceDetailsLink();

        String newUrl = driver.getCurrentUrl();
        assertNotEquals(initialUrl, newUrl, "Переход по ссылке не произошёл");
        assertNotNull(newUrl);
        assertTrue(newUrl.contains("/help/"), "URL не содержит путь к справке");
    }

    @Test
    public void testCompletePaymentFlow() {
        String testPhone = "297777777";
        webPage.enterPhone(testPhone)
                .enterSum("10")
                .enterEmail("test@example.com")
                .clickContinueButton();

        assertTrue(webPage.isPaymentModalDisplayed(), "Модальное окно платежа не открылось");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}