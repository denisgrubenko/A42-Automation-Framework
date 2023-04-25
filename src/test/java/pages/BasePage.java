package pages;

import com.beust.jcommander.IDefaultProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public String url = "https://bbb.testpro.io/";

    public WebDriver getDriver() {
        return driver;
    }

    public void closeBrowser() {
        driver.quit();
    }

    public BasePage() {
    }

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.65:4444";

        if (browser == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            return driver = new ChromeDriver(options);
        }

        switch (browser) {
            case "firefox":
                return driver = new FirefoxDriver();

            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }


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

    public void initBrowser(String URL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public void doubleClick(WebElement webElement) {
        actions.doubleClick(webElement).perform();
    }

    public void doubleClick(String Locator) {
        actions.doubleClick(findElement(Locator)).perform();
    }

    public void inputTextByActive(String Locator, String newName) {

        WebElement input = findElement(Locator);
        actions.click(input).
                keyDown(Keys.CONTROL)
                .sendKeys("A")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(input, newName)
                .sendKeys(input, Keys.ENTER)
                .perform();
    }

    public void inputTextByActive(WebElement Locator, String newName) {

        WebElement input = findElement(Locator);
        actions.click(input).
                keyDown(Keys.CONTROL)
                .sendKeys("A")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(input, newName)
                .sendKeys(input, Keys.ENTER)
                .perform();
    }
}
