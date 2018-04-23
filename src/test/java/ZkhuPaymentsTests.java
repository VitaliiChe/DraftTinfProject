import com.sun.org.glassfish.gmbal.Description;
import global.BasePage;
import global.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ZhkuPaymentSteps;


public class ZkhuPaymentsTests extends BaseTest{

    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'payer code' field")
    public void checkMessageBelowPayerCodeField()  {
        ZhkuPaymentSteps zhkuPaymentSteps = new ZhkuPaymentSteps(driver);
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillPayerCodeInputField("11111");
        String errorMessage = zhkuPaymentSteps.getTextOfErrorMessageCodeField();
        Assert.assertEquals("Поле неправильно заполнено", errorMessage);
    }

    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'payment period' field")
    public void checkMessageBelowPaymentPeriodField() {
        ZhkuPaymentSteps zhkuPaymentSteps = new ZhkuPaymentSteps(driver);
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillPaymentPeriodInputField("88.8888");
        String errorMessage = zhkuPaymentSteps.getTextErrorMessagePayPeriodField();
        Assert.assertEquals("Поле заполнено некорректно", errorMessage);
    }


    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'sum' field")
    public void checkMessageBelowSumFieldWhenMinValue() {
        ZhkuPaymentSteps zhkuPaymentSteps = new ZhkuPaymentSteps(driver);
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillSumInputField("7");
        String errorMessage =zhkuPaymentSteps.getTextErrorMessageSumField();
        Assert.assertEquals("Минимум — 10 \u20BD", errorMessage);
    }


    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'sum' field")
    public void checkMessageBelowSumFieldWhenBigValue() {
        ZhkuPaymentSteps zhkuPaymentSteps = new ZhkuPaymentSteps(driver);
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillSumInputField("15000000");
        String errorMessage =zhkuPaymentSteps.getTextErrorMessageSumField();
        Assert.assertEquals("Максимум — 15 000 \u20BD", errorMessage);
    }


    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'sum' field")
    public void checkMessageBelowSumFieldWhenTooBigValue()  {
        ZhkuPaymentSteps zhkuPaymentSteps = new ZhkuPaymentSteps(driver);
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillSumInputField("10000000000000000000000000");
        String errorMessage =zhkuPaymentSteps.getTextErrorMessageBigSumField();
        Assert.assertEquals("Поле заполнено неверно", errorMessage);
    }

    @Test
    @Description("test covers requirement from paragraph 11")
    public void checkThatZhkuMoskvaPageTheSame() throws InterruptedException {
        ZhkuPaymentSteps zhkuPaymentSteps = new ZhkuPaymentSteps(driver);
        zhkuPaymentSteps.navigateToZhkuMoskvaFromSearch();
        String currentUrlPage = getUrl();
        zhkuPaymentSteps.navigateToZhkuMoskvaFromProviders();
        String previousUrlPage = getUrl();
        Assert.assertEquals(currentUrlPage, previousUrlPage);
    }

}
