package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a .avatar")
    private WebElement avatarLocator;
    @FindBy(css = ".success.show")
    private WebElement isSuccessElement;
    @FindBy(css = "[class='album-thumb']")
    private WebElement playButtonAreaElement;
    @FindBy(css = "[data-testid='play-btn']")
    private WebElement playButtonElement;
    @FindBy(css = "[data-testid='pause-btn']")
    private WebElement pauseButtonElement;
    @FindBy(css = "[class='songs']")
    private WebElement linkAllSongsElement;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement GetUserAvatar() {
        return findElement(avatarLocator);
    }

    public void goToAllSongs() {
        getAndClick(linkAllSongsElement);
    }

    public WebElement GetIsSuccess() {
        return findElement(isSuccessElement);
    }

    public void clickOnSuccessBanner() {
        getAndClick(isSuccessElement);
    }

    public void pressPlay() {
        moveMouseToPlayButton();
        getAndClick(playButtonElement);

    }

    public void moveMouseToPlayButton() {
        WebElement button = findElement(playButtonAreaElement);
        actions.moveToElement(button).perform();
    }

    public WebElement getPauseButton() {
        return findElement(pauseButtonElement);
    }
}
