import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){

        String namePlaylist = "MyPlaylist";

        login("denis.grubenko@gmail.com");

        try{
            findElement("//section[@id='playlists']//li//a[contains(text(),'"+namePlaylist+"')]");
        }
        catch (Exception e) {
            createPlaylist(namePlaylist);
        }

        driver.get("https://bbb.testpro.io/#!/songs");

        //get first song
        getAndClick("[draggable='true'] [class='title']");

        //click on button "ADD TO"
        getAndClick("[data-test='add-to-btn']");

        //looking for our playlist
        getAndClick("//p[.='Add 1 song to']/../ul/li[contains(text(),'"+namePlaylist+"')]");

        isSuccess();

    }

}
