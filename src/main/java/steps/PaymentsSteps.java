package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PaymentsPage;

public class PaymentsSteps {

    PaymentsPage paymentsPage;

    public PaymentsSteps (WebDriver driver) {
        paymentsPage = new PaymentsPage(driver);
    }

    public void clickOnPaymentsMenuTab(){
        WebElement element = paymentsPage.getPaymentsMenuTab();
        paymentsPage.waitUntilElementVisible(7,element);
        element.click();
    }

    public void clickOnZHKHLink() {
        WebElement element = paymentsPage.getZHKHLink();
        paymentsPage.waitUntilElementVisible(7,element);
        element.click();
    }

    public void clickOnReceiverSearchField(){
        WebElement element = paymentsPage.getReceiverSearchField();
        paymentsPage.waitUntilElementVisible(7,element);
        element.click();
    }

    public void clickOnFirstProviderFromMenu(){
        WebElement element = paymentsPage.getFirstProviderFromMenu();
        paymentsPage.waitUntilElementVisible(7,element);
        element.click();
    }

    public void clearAndFillSearchField(String value) {
        clickOnReceiverSearchField();
        paymentsPage.getReceiverSearchField().clear();
        paymentsPage.getReceiverSearchField().sendKeys(value, Keys.ENTER);
    }

    public String getTextFirstProviderFromMenu(){
        WebElement element = paymentsPage.getFirstProviderFromMenu();
        paymentsPage.waitUntilElementVisible(7,element);
        return element.getText();
    }
}
