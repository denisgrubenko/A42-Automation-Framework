package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class BasePage {

    WebDriverWait wait;
    Actions actions;

    protected static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public String url = "https://bbb.testpro.io/";

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    public void closeBrowser() {
        threadDriver.get().quit();
        threadDriver.remove();
    }

    public BasePage() {
    }

    public BasePage(WebDriver givenDriver) {
        wait = new WebDriverWait(givenDriver, Duration.ofSeconds(5));
        actions = new Actions(givenDriver);
        PageFactory.initElements(new AjaxElementLocatorFactory(givenDriver, 3), this);
    }

    public void initBrowser(String URL) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = lambdaTest();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        threadDriver.set(driver);

        getDriver().get(url);
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "denis.grubenko";
        String authkey = "bCdCZOgQHKxT7AyEHcRvTxLUpT4K9uplxErB7EsFXJDUdmngdR";
        String hub = "@hub.lambdatest.com/wd/hub";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "113.0");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("build", "java-testNG");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    public WebElement findElement(String locator) {

        boolean isCSS = true;
        if (locator.contains("//") || locator.contains("xpath")) isCSS = false;

        if (isCSS)
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        else
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }

    public WebElement findElement(String locator, String ID) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));

    }

    public WebElement findElement(WebElement locator) {
        return locator;
    }

    public WebElement getAndClick(String locator) {

        WebElement webElement = findElement(locator);
        webElement.click();
        return webElement;
    }

    public WebElement getAndClick(WebElement locator) {

        locator.click();
        return locator;
    }

    public WebElement inputText(String locator, String text) {

        WebElement webElement = findElement(locator);
        webElement.clear();
        webElement.sendKeys(text);
        return webElement;
    }

    public WebElement inputText(WebElement locator, String text) {
        locator.clear();
        locator.sendKeys(text);
        return locator;
    }

    public void doubleClick(WebElement webElement) {
        actions.doubleClick(webElement).perform();
    }

    public void doubleClick(String Locator) {
        actions.doubleClick(findElement(Locator)).perform();
    }
}
