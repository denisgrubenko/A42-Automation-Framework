import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        String namePlaylist = "MyPlaylist";

        loginPage.login();
        homePage.findCreateEmptyPlaylist(namePlaylist);

        basePage.getDriver().get("https://bbb.testpro.io/#!/songs");

        homePage.clickOnFirstSong();
        homePage.addToMyPlaylist(namePlaylist);

        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }

}
