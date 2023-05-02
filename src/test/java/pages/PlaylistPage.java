package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage extends BasePage {

    @FindBy(xpath = "//section[@id='playlists']//li//a[contains(text(),'MyPlaylist')]")
    private WebElement locatorPlaylist;
    @FindBy(css = "[data-test='add-to-btn']")
    private WebElement buttonAddToLocator;
    @FindBy(xpath = "//p[.='Add 1 song to']/../ul/li[contains(text(),'MyPlaylist')]")
    private WebElement myPlaylistAddLocator;
    @FindBy(css = "[class='song-list-wrap main-scroll-wrap playlist']")
    private WebElement playlistIsNotEmptyLocator;
    @FindBy(css = "[class='del btn-delete-playlist']")
    private WebElement deletePlaylistLocator;
    @FindBy(css = "[class='ok']")
    private WebElement buttonOKLocator;
    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    private WebElement createPlaylistButtonLocator;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement createPlaylistButtonContextMenuLocator;
    @FindBy(css = "[name='create-simple-playlist-form'] input")
    private WebElement createPlaylistFieldLocator;
    @FindBy(css = "input[name='name']")
    private WebElement locatorInputRename;
    @FindBy(css = ".success.show")
    private WebElement isSuccessElement;

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement createPlaylist(String namePl) {

        //create playlist
        getAndClick(createPlaylistButtonLocator);
        getAndClick(createPlaylistButtonContextMenuLocator);

        WebElement input = getAndClick(createPlaylistFieldLocator);
        input.clear();
        input.sendKeys(namePl);
        input.sendKeys(Keys.RETURN);

        return input;
    }

    public WebElement findCreatePlaylist(String namePlaylist) {

        WebElement webElement;

        try {
            webElement = findElement(locatorPlaylist);
            webElement.click();
        } catch (Exception e) {
            createPlaylist(namePlaylist);
            webElement = findElement(locatorPlaylist);
            isSuccessElement.click();
        }
        return webElement;
    }

    public void deletePlaylist(String namePlaylist) {
        locatorPlaylist.click();
        deletePlaylistLocator.click();
        try {
            buttonOKLocator.click();
        } catch (Exception e) {
        }
    }

    public void addToMyPlaylist(String namePlaylist) {
        //click on button "ADD TO"
        getAndClick(buttonAddToLocator);

        //looking for our playlist
        getAndClick(myPlaylistAddLocator);
    }

    public void inputReName(WebElement webElement, String namePlaylist) {
        doubleClick(webElement);
        locatorInputRename.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        locatorInputRename.sendKeys(namePlaylist);
        locatorInputRename.sendKeys(Keys.ENTER);
    }
}
