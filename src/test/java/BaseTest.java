import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.*;


public class BaseTest {

    public final BasePage basePage = new BasePage();

    public LoginPage loginPage;
    public HomePage homePage;
    public ProfilePage profilePage;
    public PlaylistPage playlistPage;
    public SongsPage songsPage;


    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters({"URL"})
    public void setUpBrowser(String URL) {
        basePage.initBrowser(URL);
        loginPage = new LoginPage(basePage.getDriver());
        homePage = new HomePage(basePage.getDriver());
        profilePage = new ProfilePage(basePage.getDriver());
        playlistPage = new PlaylistPage(basePage.getDriver());
        songsPage = new SongsPage(basePage.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        basePage.closeBrowser();
    }


}