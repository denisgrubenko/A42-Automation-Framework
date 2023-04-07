package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private String locatorPlaylist  = "//section[@id='playlists']//li//a[contains(text(),'@namePlaylist@')]";
    private String FirstSongLocator = "[draggable='true'] [class='title']";
    private String buttonAddToLocator = "[data-test='add-to-btn']";
    private String myPlaylistAddLocator = "//p[.='Add 1 song to']/../ul/li[contains(text(),'@namePlaylist@')]";
    private String isSuccessLocator =".success.show";
    private String playlistIsNotEmptyLocator = "[class='song-list-wrap main-scroll-wrap playlist']";
    private String deletePlaylistLocator = "[class='del btn-delete-playlist']";
    private String buttonOKLocator = "[class='ok']";
    private String createPlaylistButtonLocator = "[data-testid='sidebar-create-playlist-btn']";
    private String createPlaylistButtonContextMenuLocator = "[data-testid='playlist-context-menu-create-simple']";
    private String createPlaylistFieldLocator = "[name='create-simple-playlist-form'] input";
    private String avatarLocator = "a .avatar";
    private String playButtonAreaLocator = "[class='album-thumb']";
    private String playButtonLocator = "[data-testid='play-btn']";
    private String pauseButtonLocator = "[data-testid='pause-btn']";
    private String locatorInputRename = "[data-testid='inline-playlist-name-input']";



    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    public WebElement GetUserAvatar() {
        return findElement(avatarLocator);
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

    public void deletePlaylist(WebElement currentPlayList) {

        boolean needPressOK = false;

        currentPlayList.click();
        try{
            findElement(playlistIsNotEmptyLocator);
            needPressOK = true;
        }
        catch (Exception e) {
        }
        getAndClick(deletePlaylistLocator);

        if(needPressOK==true){
            getAndClick(buttonOKLocator);
        }
    }

    public void findCreateEmptyPlaylist(String namePlaylist) {

        try{
            deletePlaylist(namePlaylist);
            getAndClick(isSuccessLocator);
        }
        catch (Exception e) {
        }
        createPlaylist(namePlaylist);
        getAndClick(isSuccessLocator);
    }

    public WebElement findCreatePlaylist(String namePlaylist) {

        WebElement webElement;

        try{
            webElement = findElement(locatorPlaylist.replaceAll("@namePlaylist@",namePlaylist));
        }
        catch (Exception e) {
            createPlaylist(namePlaylist);
            getAndClick(isSuccessLocator);
            //wait for a new element to appear
            webElement = findElement(locatorPlaylist.replaceAll("@namePlaylist@",namePlaylist));
        }

        return webElement;
    }

    public void deletePlaylist(String namePlaylist){
        WebElement element = findElement(locatorPlaylist.replaceAll("@namePlaylist@",namePlaylist));
        deletePlaylist(element);
    }

    public void clickOnFirstSong() {
        getAndClick(FirstSongLocator);
    }

    public void addToMyPlaylist(String namePlaylist) {
        //click on button "ADD TO"
        getAndClick(buttonAddToLocator);

        //looking for our playlist
        getAndClick(myPlaylistAddLocator.replaceAll("@namePlaylist@",namePlaylist));
    }

    public WebElement GetIsSuccess(){

        return findElement(isSuccessLocator);
    }

    public void pressPlay() {

        moveMouseToPlayButton();

        getAndClick(playButtonLocator);

    }

    public void moveMouseToPlayButton() {
        WebElement button  = findElement(playButtonAreaLocator);
        actions.moveToElement(button).perform();
    }
    public WebElement getPauseButton() {

        WebElement success = findElement(pauseButtonLocator);
        return success;
    }

    public void inputTextByActive(String newName) {

        WebElement input = findElement(locatorInputRename);
        actions.click(input).
                keyDown(Keys.CONTROL)
                .sendKeys("A")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(input, newName)
                .sendKeys(input, Keys.ENTER)
                .perform();
    }

    public void doubleClick(WebElement elementMyPlaylist) {
        actions.doubleClick(elementMyPlaylist).perform();
    }

}
