import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){

        String namePl = "MyPlaylist";

        login("denis.grubenko@gmail.com");

        //try to find my playlist
        List<WebElement> ListPlaylist = driver.findElements(By.xpath("//section[@id='playlists']//li//a[contains(text(),'"+namePl+"')]"));

        if (ListPlaylist.isEmpty()) {
            CreatePlaylist(namePl);
        }
        else {
            for (WebElement curentPlayList:ListPlaylist ) {
                //bug, we can't delete song, so we delete playlist
                curentPlayList.click();
                GetAndClickByCSS("[class='del btn-delete-playlist']");
                GetAndClickByCSS("[class='ok']");
                isSuccess();

                //create playlist
                CreatePlaylist(namePl);
            }
        }
        driver.get("https://bbb.testpro.io/#!/songs");

        //get first song 
        GetAndClickByCSS("[draggable='true'] [class='title']");

        //click on button "ADD TO"
        GetAndClickByCSS("[data-test='add-to-btn']");

        //looking for our playlist
        GetAndClickByXpath("//p[.='Add 1 song to']/../ul/li[contains(text(),'"+namePl+"')]");

        isSuccess();

    }

    private void CreatePlaylist(String namePl) {
        //create playlist
        GetAndClickByCSS("[data-testid='sidebar-create-playlist-btn']");
        GetAndClickByCSS("[data-testid='playlist-context-menu-create-simple']");

        WebElement input = GetAndClickByCSS("[name='create-simple-playlist-form'] input");
        input.clear();
        input.sendKeys(namePl);
        input.sendKeys(Keys.RETURN);
        isSuccess();
    }
}
