package global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void openSignInPage() {
        driver = new ChromeDriver();
        driver.get("https://www.tinkoff.ru");
        driver.manage().window().maximize();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
