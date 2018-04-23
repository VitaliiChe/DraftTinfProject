package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.PaymentsPage;
import pages.ZhkuPaymentPage;

public class ZhkuPaymentSteps {

    private WebDriver driver;
    ZhkuPaymentPage zhkuPaymentPage;
    CommunProvidersSteps communProvidersSteps;
    PaymentsSteps paymentsSteps;

    public ZhkuPaymentSteps (WebDriver driver) {
        zhkuPaymentPage = new ZhkuPaymentPage(driver);
        communProvidersSteps = new CommunProvidersSteps(driver);
        paymentsSteps = new PaymentsSteps(driver);
    }


    public void clickOnPayZhkuTab(){
        WebElement element = zhkuPaymentPage.getPayForZhkuTab();
        zhkuPaymentPage.waitUntilElementVisible(7,element);
        element.click();
    }

    public void navigateToZhkuMoskvaPayTab()  {
        communProvidersSteps.navigateToProvidersList();
        communProvidersSteps.clickOnTheFirstProvider();
        clickOnPayZhkuTab();
    }

    public void navigateToZhkuMoskvaFromProviders() throws InterruptedException {
        communProvidersSteps.navigateToProvidersList();
        communProvidersSteps.clickOnTheFirstProvider();
        Thread.sleep(2000);
    }

    public void navigateToZhkuMoskvaFromSearch() throws InterruptedException {
        paymentsSteps.clickOnPaymentsMenuTab();
        paymentsSteps.clearAndFillSearchField("ЖКУ");
        paymentsSteps.clickOnFirstProviderFromMenu();
        Thread.sleep(2000);
    }

    public void clearAndFillPayerCodeInputField(String value) {
        WebElement element = zhkuPaymentPage.getPayerCodeInputField();
        zhkuPaymentPage.waitUntilElementVisible(7,element);
        element.clear();
        element.sendKeys(value, Keys.ENTER);
    }

    public void clearAndFillPaymentPeriodInputField(String value) {
        WebElement element = zhkuPaymentPage.getPaymentPeriodInputField();
        zhkuPaymentPage.waitUntilElementVisible(7,element);
        element.clear();
        element.sendKeys(value, Keys.ENTER);
    }

    public void clearAndFillSumInputField(String value) {
        WebElement element = zhkuPaymentPage.getSumInputField();
        zhkuPaymentPage.waitUntilElementVisible(10, element);
        element.sendKeys(Keys.PAGE_DOWN);
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value, Keys.ENTER);
    }

    public String getTextOfErrorMessageCodeField(){
        return zhkuPaymentPage.getErrorMessageCodeField().getText();
    }

    public String getTextErrorMessagePayPeriodField(){
        return zhkuPaymentPage.getErrorMessagePayPeriodField().getText();
    }

    public String getTextErrorMessageSumField(){
        return zhkuPaymentPage.getErrorMessageSumField().getText();
    }

    public String getTextErrorMessageBigSumField(){
        return zhkuPaymentPage.getErrorMessageBigSumField().getText();
    }
}
