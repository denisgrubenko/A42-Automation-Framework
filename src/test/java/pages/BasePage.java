package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

//    private String isSuccessLocator =".success.show";
//    private String playButtonAreaLocator = "[class='album-thumb']";
//    private String playButtonLocator = "[data-testid='play-btn']";
//    private String pauseButtonLocator = "[data-testid='pause-btn']";
//    private String linkAllSongsLocator = "[class='songs']";



    @FindBy(css=".success.show")
    private WebElement isSuccessElement;
    @FindBy(css= "[class='album-thumb']")
    private WebElement playButtonAreaElement;
    @FindBy(css= "[data-testid='play-btn']")
    private WebElement playButtonElement;
    @FindBy(css= "[data-testid='pause-btn']")
    private WebElement pauseButtonElement;
    @FindBy(css="[class='songs']")
    private WebElement linkAllSongsElement;


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
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 1), this);
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
    public WebElement findElement(WebElement locator){
        return locator;
    }

    public WebElement getAndClick(String locator){

        WebElement webElement = findElement(locator);
        webElement.click();
        return webElement;
    }
    public WebElement getAndClick(WebElement locator){

        locator.click();
        return locator;
    }

    public WebElement inputText(String locator, String text){

        WebElement webElement = findElement(locator);
        webElement.clear();
        webElement.sendKeys(text);
        return webElement;
    }

    public WebElement inputText(WebElement locator, String text){
        locator.clear();
        locator.sendKeys(text);
        return locator;
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


    public WebElement GetIsSuccess(){

        return findElement(isSuccessElement);
        //return findElement(isSuccessLocator);
    }

    public void clickOnSuccessBanner(){
        getAndClick(isSuccessElement);
        //getAndClick(isSuccessLocator);

    }

    public void pressPlay() {

        moveMouseToPlayButton();
        getAndClick(playButtonElement);

    }

    public void moveMouseToPlayButton() {
        WebElement button  = findElement(playButtonAreaElement);
        actions.moveToElement(button).perform();
    }
    public WebElement getPauseButton() {

        return findElement(pauseButtonElement);

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

    public void goToAllSongs(){
        getAndClick(linkAllSongsElement);

    }

}
