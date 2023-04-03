import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest{

    @Test(enabled = true)
    public void testDeletePlaylist(){

        String namePlaylist   = "MyPlaylist";
        String selector = "//section[@id='playlists']//li//a[contains(text(),'"+namePlaylist+"')]";

        login();

        try{
            findElement(selector);
        }
        catch (Exception e) {
            createPlaylist(namePlaylist);

        }

        WebElement playlist = findElement(selector);
        deletePlaylist(playlist);

        WebElement success = findElement(".success.show");
        Assert.assertTrue(success.isDisplayed());

    }
}
