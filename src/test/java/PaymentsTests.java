import com.sun.org.glassfish.gmbal.Description;
import global.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CommunProvidersSteps;
import steps.PaymentsSteps;
import steps.ZhkuPaymentSteps;


public class PaymentsTests extends BaseTest {

    @Test
    @Description("test covers requirement from paragraph 10")
    public void checkThatZhkuIsTheFirstProvider() {
        CommunProvidersSteps communProvidersSteps = new CommunProvidersSteps(driver);
        PaymentsSteps paymentsSteps = new PaymentsSteps(driver);
        communProvidersSteps.navigateToProvidersList();
        String firstProviderFromList =  communProvidersSteps.getFirstProviderName();
        paymentsSteps.clickOnPaymentsMenuTab();
        paymentsSteps.clearAndFillSearchField(firstProviderFromList);
        String firstProviderNameFromMenu = paymentsSteps.getTextFirstProviderFromMenu();
        Assert.assertEquals(firstProviderFromList, firstProviderNameFromMenu);
    }

}
