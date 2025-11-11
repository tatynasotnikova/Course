package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;

public class MtsWebPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MtsWebPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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

    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe')]")
    private WebElement paymentIframe;

    @FindBy(xpath = "//select[@id='pay']")
    private WebElement serviceTypeSelect;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement serviceTypeDropdown;

    @FindBy(xpath = "//li[@class='select__item']//p[text()='Услуги связи']")
    private WebElement servicesConnectionOption;

    @FindBy(xpath = "//li[@class='select__item']//p[text()='Домашний интернет']")
    private WebElement homeInternetOption;

    @FindBy(xpath = "//li[@class='select__item']//p[text()='Рассрочка']")
    private WebElement instalmentOption;

    @FindBy(xpath = "//li[@class='select__item']//p[text()='Задолженность']")
    private WebElement arrearsOption;

    @FindBy(xpath = "//form[@id='pay-internet']//input[@id='internet-phone']")
    private WebElement internetPhoneInput;

    @FindBy(xpath = "//form[@id='pay-internet']//input[@id='internet-sum']")
    private WebElement internetSumInput;

    @FindBy(xpath = "//form[@id='pay-internet']//input[@id='internet-email']")
    private WebElement internetEmailInput;

    @FindBy(xpath = "//form[@id='pay-instalment']//input[@id='score-instalment']")
    private WebElement instalmentScoreInput;

    @FindBy(xpath = "//form[@id='pay-instalment']//input[@id='instalment-sum']")
    private WebElement instalmentSumInput;

    @FindBy(xpath = "//form[@id='pay-instalment']//input[@id='instalment-email']")
    private WebElement instalmentEmailInput;

    @FindBy(xpath = "//form[@id='pay-arrears']//input[@id='score-arrears']")
    private WebElement arrearsScoreInput;

    @FindBy(xpath = "//form[@id='pay-arrears']//input[@id='arrears-sum']")
    private WebElement arrearsSumInput;

    @FindBy(xpath = "//form[@id='pay-arrears']//input[@id='arrears-email']")
    private WebElement arrearsEmailInput;

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

    public void switchToPaymentIframe() {
        wait.until(ExpectedConditions.visibilityOf(paymentIframe));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='pay-description__text']")));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
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

    public void selectServiceType(String serviceType) {
        try {
            serviceTypeDropdown.click();
            Thread.sleep(500);

            switch (serviceType.toLowerCase()) {
                case "услуги связи":
                    servicesConnectionOption.click();
                    break;
                case "домашний интернет":
                    homeInternetOption.click();
                    break;
                case "рассрочка":
                    instalmentOption.click();
                    break;
                case "задолженность":
                    arrearsOption.click();
                    break;
            }
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error selecting service type: " + e.getMessage());
        }
    }

    public String getConnectionPhonePlaceholder() {
        return phoneInput.getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return sumInput.getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return emailInput.getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholder() {
        return internetPhoneInput.getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return internetSumInput.getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return internetEmailInput.getAttribute("placeholder");
    }

    public String getInstalmentScorePlaceholder() {
        return instalmentScoreInput.getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() {
        return instalmentSumInput.getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() {
        return instalmentEmailInput.getAttribute("placeholder");
    }

    public String getArrearsScorePlaceholder() {
        return arrearsScoreInput.getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return arrearsSumInput.getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return arrearsEmailInput.getAttribute("placeholder");
    }

    public String getPaymentAmount() {
        WebElement amount = driver.findElement(By.cssSelector(".pay-description__cost span"));
        return amount.getText().trim();
    }

    public String getPayButtonText() {
        WebElement payButtonSpan = driver.findElement(By.xpath("//button[contains(@class,'colored')]//span"));
        return payButtonSpan.getText().trim();
    }

    public String getCardNumberLabel() {
        WebElement label = driver.findElement(By.xpath("//input[@id='cc-number']/following-sibling::label"));
        return label.getText().trim();
    }

    public String getCardExpiryPlaceholder() {
        WebElement input = driver.findElement(By.xpath("//input[@autocomplete='cc-exp' and contains(@placeholder,'MM')]"));
        return input.getAttribute("placeholder").trim();
    }

    public String getCardCvcLabel() {
        WebElement label = driver.findElement(By.xpath("//input[@formcontrolname='cvc']/following-sibling::label"));
        return label.getText().trim();
    }

    public String getCardHolderLabel() {
        WebElement label = driver.findElement(By.xpath("//input[@formcontrolname='holder']/following-sibling::label"));
        return label.getText().trim();
    }

    public boolean isVisaIconDisplayed() {
        return driver.findElement(By.xpath("//div[contains(@class,'cards-brands__container')]//img[contains(@src,'visa-system')]")).isDisplayed();
    }

    public boolean isMastercardIconDisplayed() {
        return driver.findElement(By.xpath("//div[contains(@class,'cards-brands__container')]//img[contains(@src,'mastercard-system')]")).isDisplayed();
    }

    public boolean isBelkartIconDisplayed() {
        return driver.findElement(By.xpath("//div[contains(@class,'cards-brands__container')]//img[contains(@src,'belkart-system')]")).isDisplayed();
    }


    public void waitForPaymentFormToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__cost span")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'colored')]//span")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number")));
    }
}