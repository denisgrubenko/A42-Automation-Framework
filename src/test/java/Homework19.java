import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest{

    @Test(enabled = true)
    public void testDeletePlaylist(){

        String namePl   = "MyPlaylist";
        String selector = "//section[@id='playlists']//li//a[contains(text(),'"+namePl+"')]";
        login();

        //try to find my playlist
        List<WebElement> ListPlaylist = driver.findElements(By.xpath(selector));

        if (ListPlaylist.isEmpty()) {
            createPlaylist(namePl);
            WebElement PL = driver.findElement(By.xpath(selector));
            deletePlaylist(PL);
        }
        else {
            for (WebElement currentPlayList:ListPlaylist ) {
                deletePlaylist(currentPlayList);
            }
        }

    }
}
