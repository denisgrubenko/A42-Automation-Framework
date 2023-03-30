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
            createPlaylist(namePl);
        }
        else {
            for (WebElement curentPlayList:ListPlaylist ) {
                //bug, we can't delete song, so we delete playlist
                curentPlayList.click();
                getAndClickByCSS("[class='del btn-delete-playlist']");
                getAndClickByCSS("[class='ok']");
                isSuccess();

                //create playlist
                createPlaylist(namePl);
            }
        }
        driver.get("https://bbb.testpro.io/#!/songs");

        //get first song 
        getAndClickByCSS("[draggable='true'] [class='title']");

        //click on button "ADD TO"
        getAndClickByCSS("[data-test='add-to-btn']");

        //looking for our playlist
        getAndClickByXpath("//p[.='Add 1 song to']/../ul/li[contains(text(),'"+namePl+"')]");

        isSuccess();

    }

    private void createPlaylist(String namePl) {
        //create playlist
        getAndClickByCSS("[data-testid='sidebar-create-playlist-btn']");
        getAndClickByCSS("[data-testid='playlist-context-menu-create-simple']");

        WebElement input = getAndClickByCSS("[name='create-simple-playlist-form'] input");
        input.clear();
        input.sendKeys(namePl);
        input.sendKeys(Keys.RETURN);
        isSuccess();
    }
}
