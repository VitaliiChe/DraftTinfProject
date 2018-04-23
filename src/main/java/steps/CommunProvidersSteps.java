package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommunProvidersPage;

import java.util.Iterator;
import java.util.List;


public class CommunProvidersSteps {

    CommunProvidersPage communProvidersPage;
    private WebDriver driver;
    PaymentsSteps paymentsSteps ;


    public CommunProvidersSteps (WebDriver driver) {
        communProvidersPage = new CommunProvidersPage(driver);
        paymentsSteps = new PaymentsSteps(driver);
    }


    public void clickOnTheFirstProvider() {
        WebElement element = communProvidersPage.getFirstProviderCommunServices();
        communProvidersPage.waitUntilElementClickable(7, element);
        element.click();
    }

    public void clickOnInfoAboutRegionServices() {
        WebElement element = communProvidersPage.getInfoAboutRegionServices();
        communProvidersPage.waitUntilElementVisible(7,element);
        element.click();
    }

    public void clickForChoiceSaintPetersburg() {
        WebElement element = communProvidersPage.getChoiceSaintPetersburg();
        communProvidersPage.waitUntilElementClickable(7,element);
        element.click();
    }

    public String getProvidersRegionName() {
        return communProvidersPage.getInfoAboutRegionServices().getText();
    }

    public String getFirstProviderName() {
        WebElement element = communProvidersPage.getFirstProviderCommunServices();
        communProvidersPage.waitUntilElementVisible(7,element);
        return element.getText();
    }

    public void navigateToProvidersList()  {
        paymentsSteps.clickOnPaymentsMenuTab();
        paymentsSteps.clickOnZHKHLink();
    }

    public boolean isProviderPresentInList(String providerName) {
        List<WebElement> providers = communProvidersPage.getProvidersNames();
        Iterator<WebElement> provider = providers.iterator();
        while(provider.hasNext()) {
            String name = provider.next().getText();
            if (name.equals(providerName)) {
                return false;
            }
        }
        return true;
    }
}
