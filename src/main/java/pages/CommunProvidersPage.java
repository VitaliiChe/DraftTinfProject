package pages;

import global.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class CommunProvidersPage  extends BasePage{

    public CommunProvidersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//*[contains(@href,'zhku')][@title]/span)[2]")
    private WebElement firstProviderCommunServices;

    @FindBy(xpath = "//*[contains(@class, 'regionSelect')]//*[@data-qa-file='Link']")
    private WebElement infoAboutRegionServices;

    @FindBy(xpath = "//*[@class='ui-link__text'][text()='г. Санкт-Петербург']")
    private WebElement choiceSaintPetersburg;

    public  WebElement getFirstProviderCommunServices() {
        return firstProviderCommunServices;
    }

    public WebElement getInfoAboutRegionServices() {
        return infoAboutRegionServices;
    }

    public WebElement getChoiceSaintPetersburg() {
        return choiceSaintPetersburg;
    }

    public List<WebElement> getProvidersNames() {
        return driver.findElements(By.xpath("//span[2]//*[@class='ui-link__text'][@data-qa-file]"));
    }
}


