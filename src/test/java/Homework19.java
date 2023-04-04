import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest{

    @Test(enabled = true)
    public void testDeletePlaylist(){

        String namePlaylist         = "MyPlaylist";
        String selectorMyPlaylist   = "//section[@id='playlists']//li//a[contains(text(),'"+namePlaylist+"')]";
        String selectorSuccess      = ".success.show";

        login();

        try{
            findElement(selectorMyPlaylist);
        }
        catch (Exception e) {
            createPlaylist(namePlaylist);

        }

        WebElement playlist = findElement(selectorMyPlaylist);
        deletePlaylist(playlist);

        WebElement success = findElement(selectorSuccess);
        Assert.assertTrue(success.isDisplayed());

    }
}
