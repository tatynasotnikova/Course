package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MtsWebPage;
import static org.junit.jupiter.api.Assertions.*;

public class MtsWebPageTest {

    private WebDriver driver;
    private MtsWebPage webPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
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

    @Test
    public void testConnectionServicesPaymentFlow() {
        String testPhone = "297777777";
        String testSum   = "10";
        String testEmail = "test@example.com";

        webPage.selectServiceType("Услуги связи");
        webPage.enterPhone(testPhone)
                .enterSum(testSum)
                .enterEmail(testEmail)
                .clickContinueButton();

        assertTrue(webPage.isPaymentModalDisplayed(), "Модальное окно платежа не открылось");

        webPage.switchToPaymentIframe();
        webPage.waitForPaymentFormToLoad();

        String paymentAmount = webPage.getPaymentAmount();
        assertTrue(paymentAmount.contains(testSum) && paymentAmount.toUpperCase().contains("BYN"),
                "Сумма в описании не соответствует: " + paymentAmount);

        String payButtonText = webPage.getPayButtonText();
        assertTrue(payButtonText.contains(testSum) && payButtonText.toUpperCase().contains("BYN"),
                "Сумма на кнопке оплаты не соответствует: " + payButtonText);

        assertEquals("Номер карты", webPage.getCardNumberLabel(), "Неверный label для номера карты");
        assertEquals("MM / YY", webPage.getCardExpiryPlaceholder(), "Неверный placeholder для срока действия");
        assertEquals("CVC", webPage.getCardCvcLabel(), "Неверный label для CVC");
        assertEquals("Имя и фамилия на карте", webPage.getCardHolderLabel(), "Неверный label для имени держателя");

        assertTrue(webPage.isVisaIconDisplayed(), "Иконка Visa не отображается");
        assertTrue(webPage.isMastercardIconDisplayed(), "Иконка Mastercard не отображается");
        assertTrue(webPage.isBelkartIconDisplayed(), "Иконка Белкарт не отображается");

        webPage.switchToDefaultContent();
    }

    @Test
    public void testConnectionServicesPlaceholders() {
        webPage.selectServiceType("Услуги связи");

        assertEquals("Номер телефона", webPage.getConnectionPhonePlaceholder(),
                "Неверный плейсхолдер для номера телефона");
        assertEquals("Сумма", webPage.getConnectionSumPlaceholder(),
                "Неверный плейсхолдер для суммы");
        assertEquals("E-mail для отправки чека", webPage.getConnectionEmailPlaceholder(),
                "Неверный плейсхолдер для email");
    }

    @Test
    public void testHomeInternetPlaceholders() {
        webPage.selectServiceType("Домашний интернет");

        assertEquals("Номер абонента", webPage.getInternetPhonePlaceholder(),
                "Неверный плейсхолдер для номера абонента");
        assertEquals("Сумма", webPage.getInternetSumPlaceholder(),
                "Неверный плейсхолдер для суммы");
        assertEquals("E-mail для отправки чека", webPage.getInternetEmailPlaceholder(),
                "Неверный плейсхолдер для email");
    }

    @Test
    public void testInstalmentPlaceholders() {
        webPage.selectServiceType("Рассрочка");

        assertEquals("Номер счета на 44", webPage.getInstalmentScorePlaceholder(),
                "Неверный плейсхолдер для номера счета");
        assertEquals("Сумма", webPage.getInstalmentSumPlaceholder(),
                "Неверный плейсхолдер для суммы");
        assertEquals("E-mail для отправки чека", webPage.getInstalmentEmailPlaceholder(),
                "Неверный плейсхолдер для email");
    }

    @Test
    public void testArrearsPlaceholders() {
        webPage.selectServiceType("Задолженность");

        assertEquals("Номер счета на 2073", webPage.getArrearsScorePlaceholder(),
                "Неверный плейсхолдер для номера счета");
        assertEquals("Сумма", webPage.getArrearsSumPlaceholder(),
                "Неверный плейсхолдер для суммы");
        assertEquals("E-mail для отправки чека", webPage.getArrearsEmailPlaceholder(),
                "Неверный плейсхолдер для email");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}