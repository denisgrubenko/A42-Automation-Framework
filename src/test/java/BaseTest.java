import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;


public class BaseTest {

    WebDriver driver;

    public final BasePage basePage = new BasePage();

    public LoginPage loginPage;
    public HomePage homePage;


    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters({"URL"})
    public void setUpBrowser(String URL) {
        basePage.initBrowser(URL);
        driver = basePage.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        basePage.closeBrowser();
    }


}