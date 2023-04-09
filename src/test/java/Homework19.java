import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test(enabled = true)
    public void testDeletePlaylist(){

        String namePlaylist = "MyPlaylist";

        loginPage.login();
        homePage.GetUserAvatar();
        playlistPage.findCreatePlaylist(namePlaylist);
        playlistPage.deletePlaylist(namePlaylist);
        Assert.assertTrue(playlistPage.GetIsSuccess().isDisplayed());

    }
}
