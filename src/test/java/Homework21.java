import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist(){

        String namePlaylist     = "MyPlaylist";
        String locatorPlaylist  = "//section[@id='playlists']//li//a[contains(text(),'"+namePlaylist+"')]";
        String locatorInput     = "[data-testid='inline-playlist-name-input']";
        String locatorSuccess   = ".success.show";
        WebElement elementMyPlaylist;

        login();
        try{
            elementMyPlaylist = findElement(locatorPlaylist);
        }
        catch (Exception e) {
            elementMyPlaylist = createPlaylist(namePlaylist);
        }

        String newName = elementMyPlaylist.getText()+1;
        actions.doubleClick(elementMyPlaylist).perform();
        WebElement input = findElement(locatorInput);
        actions.click(input).
                keyDown(Keys.CONTROL)
                .sendKeys("A")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(input,newName)
                .sendKeys(input, Keys.ENTER)
                .perform();

        WebElement success = findElement(locatorSuccess);
        Assert.assertTrue(success.isDisplayed());

    }
}
