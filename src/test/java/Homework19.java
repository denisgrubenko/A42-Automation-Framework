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

        //try to find my playlist
        List<WebElement> ListPlaylist = driver.findElements(By.xpath(selector));

        if (ListPlaylist.isEmpty()) {
            createPlaylist(namePl);
        }

        WebElement PL = driver.findElement(By.xpath(selector));
        deletePlaylist(PL);

        WebElement success = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(success.isDisplayed());

    }
}
