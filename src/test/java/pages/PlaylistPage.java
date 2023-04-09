package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage extends BasePage{

//    private final String locatorPlaylist  = "//section[@id='playlists']//li//a[contains(text(),'@namePlaylist@')]";
//    private final String buttonAddToLocator = "[data-test='add-to-btn']";
//    private final String myPlaylistAddLocator = "//p[.='Add 1 song to']/../ul/li[contains(text(),'@namePlaylist@')]";
//    private final String playlistIsNotEmptyLocator = "[class='song-list-wrap main-scroll-wrap playlist']";
//    private final String deletePlaylistLocator = "[class='del btn-delete-playlist']";
//    private final String buttonOKLocator = "[class='ok']";
//    private final String createPlaylistButtonLocator = "[data-testid='sidebar-create-playlist-btn']";
//    private final String createPlaylistButtonContextMenuLocator = "[data-testid='playlist-context-menu-create-simple']";
//    private final String createPlaylistFieldLocator = "[name='create-simple-playlist-form'] input";
//    private final String locatorInputRename = "[data-testid='inline-playlist-name-input']";

    @FindBy(xpath="//section[@id='playlists']//li//a[contains(text(),'MyPlaylist')]")
    public WebElement locatorPlaylist;
    @FindBy(css="[data-test='add-to-btn']")
    private WebElement buttonAddToLocator;
    @FindBy(xpath="//p[.='Add 1 song to']/../ul/li[contains(text(),'MyPlaylist')]")
    private WebElement myPlaylistAddLocator;
    @FindBy(css="[class='song-list-wrap main-scroll-wrap playlist']")
    private WebElement playlistIsNotEmptyLocator;
    @FindBy(css="[class='del btn-delete-playlist']")
    private WebElement deletePlaylistLocator;
    @FindBy(css="[class='ok']")
    private WebElement buttonOKLocator;
    @FindBy(css="[data-testid='sidebar-create-playlist-btn']")
    private WebElement createPlaylistButtonLocator;
    @FindBy(css="[data-testid='playlist-context-menu-create-simple']")
    private WebElement createPlaylistButtonContextMenuLocator;
    @FindBy(css="[name='create-simple-playlist-form'] input")
    private WebElement createPlaylistFieldLocator;
    @FindBy(css="[data-testid='inline-playlist-name-input']")
    private WebElement locatorInputRename;

    public PlaylistPage(WebDriver givenDriver){
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

        clickOnSuccessBanner();

        return input;
    }

    public void deletePlaylist(WebElement currentPlayList) {

//        boolean needPressOK = false;
//
//        currentPlayList.click();
//        try{
//            findElement(playlistIsNotEmptyLocator);
//            needPressOK = true;
//        }
//        catch (Exception e) {
//        }
//        getAndClick(deletePlaylistLocator);
//
//        if(needPressOK==true){
//            getAndClick(buttonOKLocator);
//        }

        //GetUserAvatar(); //crutch

        //currentPlayList.click();
        getAndClick(currentPlayList);
        getAndClick(deletePlaylistLocator);
        try{
            getAndClick(buttonOKLocator);}
        catch (Exception e) {
        }
    }

    public void findCreateEmptyPlaylist(String namePlaylist) {

        try{
            deletePlaylist(namePlaylist);
            clickOnSuccessBanner();
        }
        catch (Exception e) {
        }
        createPlaylist(namePlaylist);
    }

    public WebElement findCreatePlaylist(String namePlaylist) {

        WebElement webElement;

        try{
            //webElement = findElement(locatorPlaylist.replaceAll("@namePlaylist@",namePlaylist));
            webElement = findElement(locatorPlaylist);
            webElement.click();
        }
        catch (Exception e) {
            createPlaylist(namePlaylist);
            //wait for a new element to appear
            //webElement = findElement(locatorPlaylist.replaceAll("@namePlaylist@",namePlaylist));
            webElement = findElement(locatorPlaylist);
        }

        return webElement;
    }

    public void deletePlaylist(String namePlaylist){
        //WebElement element = findElement(locatorPlaylist.replaceAll("@namePlaylist@",namePlaylist));
        WebElement element = findElement(locatorPlaylist);
        deletePlaylist(element);
    }



    public void addToMyPlaylist(String namePlaylist) {
        //click on button "ADD TO"
        getAndClick(buttonAddToLocator);

        //looking for our playlist
        //getAndClick(myPlaylistAddLocator.replaceAll("@namePlaylist@",namePlaylist));
        getAndClick(myPlaylistAddLocator);

    }

    public void inputReName(WebElement webElement, String namePlaylist) {
        doubleClick(webElement);
        inputTextByActive(locatorInputRename, namePlaylist);
    }


}
