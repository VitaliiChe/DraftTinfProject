package pages;

import global.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class ZhkuPaymentPage extends BasePage{

    public ZhkuPaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " (//*[@class = 'Tab__tab_2Ylcg'])[2]")
    private WebElement payForZhkuTab;

    @FindBy(xpath = "//*[@name = 'provider-payerCode']")
    private WebElement payerCodeInputField;

    @FindBy(xpath = "//*[@name = 'provider-period']")
    private WebElement paymentPeriodInputField;

    // поле "Сумма добровольного страхования жилья из квитанции за ЖКУ в Москве, ₽ " не является обязательным

    @FindBy(xpath = "(//*[@type = 'text'])[3]/..")
//@FindBy(xpath = "(//*[@data-qa-file='FormFieldWrapper'])[22]")
    private WebElement sumInputField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[1]")
    private WebElement errorMessageCodeField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[2]")
    private WebElement errorMessagePeriodField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[3]")
    private WebElement errorMessageSumField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[4]")
    private WebElement errorMessageBigSumField;

    public WebElement getPayForZhkuTab() {
        return payForZhkuTab;
    }

    public WebElement getPayerCodeInputField() {
        return payerCodeInputField;
    }

    public WebElement getPaymentPeriodInputField() {
        return paymentPeriodInputField;
    }

    public WebElement getSumInputField() {
        return sumInputField;
    }

    public WebElement getErrorMessageCodeField() {
        return errorMessageCodeField;
    }

    public WebElement getErrorMessagePayPeriodField() {
        return errorMessagePeriodField;
    }

    public WebElement getErrorMessageSumField() {
        return errorMessageSumField;
    }

    public WebElement getErrorMessageBigSumField() {
        return errorMessageBigSumField;
    }
}
