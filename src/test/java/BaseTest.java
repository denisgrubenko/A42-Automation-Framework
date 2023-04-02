import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    static WebDriver driver;
    WebDriverWait wait;
    public String url = "https://bbb.testpro.io1/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"URL"})
    public void setUpBrowser(String URL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    static void tearDown() {
        driver.quit();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void login(String email) {
        enterEmail(email);
        enterPassword("te$t$tudent");
        clickLoginButton();
    }

    public void login() {
        enterEmail("denis.grubenko@gmail.com");
        enterPassword("te$t$tudent");
        clickLoginButton();
    }


    public WebElement findElement(String locator){

        boolean isCSS = true;
        if (locator.contains("//") || locator.contains("xpath")) isCSS = false;

        if (isCSS)
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        else
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }

    public WebElement findElement(String locator, String ID){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));

    }


    public WebElement getAndClick(String locator){

        WebElement webElement = findElement( locator);
        webElement.click();
        return webElement;
    }


    public void isSuccess(){

          getAndClick(".success.show");
    }


    protected void enterPassword(String password) {
        WebElement passwordInput = getAndClick("[type='password']");
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected void enterEmail(String email) {
        WebElement emailInput = getAndClick("//input[@type='email']");
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected void clickLoginButton() {
        getAndClick("button[type='submit']");
    }

    public void createPlaylist(String namePl) {
        //create playlist
        getAndClick("[data-testid='sidebar-create-playlist-btn']");
        getAndClick("[data-testid='playlist-context-menu-create-simple']");

        WebElement input = getAndClick("[name='create-simple-playlist-form'] input");
        input.clear();
        input.sendKeys(namePl);
        input.sendKeys(Keys.RETURN);
        isSuccess();
    }

    public void deletePlaylist(WebElement currentPlayList) {

        boolean needPressOK = false;

        currentPlayList.click();
        try{
            findElement("[class='song-list-wrap main-scroll-wrap playlist']");
            needPressOK = true;
        }
        catch (Exception e) {
        }
        getAndClick("[class='del btn-delete-playlist']");

        if(needPressOK==true){
            getAndClick("[class='ok']");
        }

        //isSuccess();
    }


}