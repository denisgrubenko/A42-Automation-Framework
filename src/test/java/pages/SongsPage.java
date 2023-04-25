package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends BasePage{

    @FindBy(css="[draggable='true'] [class='title']")
    private WebElement FirstSongLocator;

    public SongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public void clickOnFirstSong() {
        getAndClick(FirstSongLocator);
    }
}
