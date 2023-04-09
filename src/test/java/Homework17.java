import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        String namePlaylist = "MyPlaylist";

        loginPage.login();
        playlistPage.deletePlaylist(namePlaylist);
        homePage.clickOnSuccessBanner();
        playlistPage.createPlaylist(namePlaylist);
        homePage.clickOnSuccessBanner();
        homePage.goToAllSongs();
        songsPage.clickOnFirstSong();
        playlistPage.addToMyPlaylist(namePlaylist);

        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }
}
