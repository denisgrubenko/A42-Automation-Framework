package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public String url = "https://bbb.testpro.io/";

    public WebDriver getDriver(){
        return driver;
    }


    public void closeBrowser() {
        driver.quit();
    }

    public BasePage( ){}

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
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

        WebElement webElement = findElement(locator);
        webElement.click();
        return webElement;
    }

    public WebElement inputText(String locator, String text){

        WebElement webElement = findElement(locator);
        webElement.clear();
        webElement.sendKeys(text);
        return webElement;
    }

    public void initBrowser(String URL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(URL);
        //driver.get(url);
    }

}
