package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;

public class MtsWebPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MtsWebPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cookie show']")
    private WebElement cookiePopup;

    @FindBy(id = "cookie-agree")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//section[@class='pay']//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement onlineReplenishmentHeader;

    @FindBy(xpath = "//section[@class='pay']//form[@id='pay-connection']//button[text()='Продолжить']")
    private WebElement continueLocator;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//section[@class='pay']//ul//img")
    private List<WebElement> paymentLogos;

    @FindBy(xpath = "//section[@class='pay']//a[contains(@href, '/help/')]")
    private WebElement serviceDetailsLink;

    @FindBy(xpath = "//div[@class='bepaid-app']")
    private WebElement paymentModal;


    public boolean isCookiePopupDisplayed() {
        try {
            return cookiePopup.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cookiePopup));
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptCookiesButton.click();
            wait.until(ExpectedConditions.invisibilityOf(cookiePopup));
            System.out.println("Cookies accepted successfully");
        } catch (Exception e) {
            System.out.println("Cookie popup not found or already closed: " + e.getMessage());
        }
    }

    public void handleCookiePopup() {
        if (isCookiePopupDisplayed()) {
            acceptCookies();
        }
    }

    public boolean isHeaderDisplayed() {
        return onlineReplenishmentHeader.isDisplayed();
    }

    public String getHeaderText() {
        return onlineReplenishmentHeader.getText();
    }

    public boolean arePaymentLogosDisplayed() {
        return !paymentLogos.isEmpty() && paymentLogos.get(0).isDisplayed();
    }

    public int getPaymentLogosCount() {
        return paymentLogos.size();
    }

    public boolean isServiceDetailsLinkDisplayed() {
        return serviceDetailsLink.isDisplayed();
    }

    public void clickServiceDetailsLink() {
        serviceDetailsLink.click();
    }

    public MtsWebPage enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        return this;
    }

    public MtsWebPage enterSum(String sum) {
        sumInput.clear();
        sumInput.sendKeys(sum);
        return this;
    }

    public MtsWebPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public void clickContinueButton() {
        continueLocator.click();
        waitForPaymentModal();
    }

    public boolean isPaymentModalDisplayed() {
        return paymentModal.isDisplayed();
    }

    public void waitForPaymentModal() {
        wait.until(ExpectedConditions.visibilityOf(paymentModal));
    }
}