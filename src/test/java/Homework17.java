import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    String namePlaylist = "MyPlaylist";

    @Test
    public void addSongToPlaylist(){


        loginPage.login();
        homePage.findCreateEmptyPlaylist(namePlaylist);

        driver.get("https://bbb.testpro.io/#!/songs");

        homePage.clickOnFirstSong();
        homePage.addToMyPlaylist(namePlaylist);

        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }

}
