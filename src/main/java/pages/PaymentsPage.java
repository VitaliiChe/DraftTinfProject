package pages;

import global.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage  extends BasePage{

    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    @CacheLookup
    @FindBy(xpath = "//*[@data-qa-file='SecondMenu'][text() = 'Платежи']")
    private WebElement paymentsMenuTab;

    @CacheLookup
    @FindBy(xpath = "//*[@class= 'ui-link__text'][text() = 'ЖКХ']")
    private WebElement ZHKHLink;

    @FindBy(xpath = "//*[contains(@class,'Input__valueContent')]")
    private WebElement receiverSearchField;

    @FindBy(xpath = "(//*[contains(@class, 'SearchSuggest__entryText')]/div)[1]")
    private WebElement firstProviderFromMenu;

    public WebElement getPaymentsMenuTab() {
        return paymentsMenuTab;
    }

    public WebElement getZHKHLink() {
        return ZHKHLink;
    }

    public WebElement getReceiverSearchField() {
        return receiverSearchField;
    }

    public WebElement getFirstProviderFromMenu() {
        return firstProviderFromMenu;
    }
}
