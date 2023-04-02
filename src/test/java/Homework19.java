import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest{

    @Test(enabled = true)
    public void testDeletePlaylist()throws InterruptedException{
        //
        String namePl   = "MyPlaylist";
        String selector = "//section[@id='playlists']//li//a[contains(text(),'"+namePl+"')]";

        login();

        try{
            WebElement MyPlaylist = findElement("//section[@id='playlists']//li//a[contains(text(),'"+namePl+"')]");
        }
        catch (Exception e) {
            createPlaylist(namePl);
        }

        WebElement PL = findElement(selector);
        deletePlaylist(PL);

        WebElement success = findElement(".success.show");
        Assert.assertTrue(success.isDisplayed());

    }
}
