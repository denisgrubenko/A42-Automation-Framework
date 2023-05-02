import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;
import java.net.MalformedURLException;

public class BaseTest {

    public final BasePage basePage = new BasePage();

    @BeforeMethod
    @Parameters({"URL"})
    public void setUpBrowser(String URL) throws MalformedURLException {
        basePage.initBrowser(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        basePage.closeBrowser();
    }

}

