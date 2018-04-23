import com.sun.org.glassfish.gmbal.Description;
import global.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CommunProvidersSteps;


public class CommunProvidersTests extends BaseTest{

    @Test
    @Description("test covers requirement from paragraph 4")
    public void checkRegionOfServices()  {
        CommunProvidersSteps communProvidersSteps = new CommunProvidersSteps(driver);
        communProvidersSteps.navigateToProvidersList();
        String regionName = communProvidersSteps.getProvidersRegionName();
        Assert.assertEquals("Москве", regionName);
    }

    @Test
    @Description("test covers requirement from paragraph 14")
    public void checkThatZhkuIsAbsentInProvidersList() {
        CommunProvidersSteps communProvidersSteps = new CommunProvidersSteps(driver);
        communProvidersSteps.navigateToProvidersList();
        communProvidersSteps.clickOnInfoAboutRegionServices();
        communProvidersSteps.clickForChoiceSaintPetersburg();
        Assert.assertTrue(communProvidersSteps.isProviderPresentInList("ЖКУ-Москва"),
                "ЖКУ-Москва не должен быть в списке провайдеров г.Санкт-Петербурга");
    }
}
