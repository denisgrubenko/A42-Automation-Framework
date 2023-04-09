import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        String namePlaylist = "MyPlaylist";

        loginPage.login();
        playlistPage.findCreateEmptyPlaylist(namePlaylist);
        playlistPage.goToAllSongs();
        songsPage.clickOnFirstSong();
        playlistPage.addToMyPlaylist(namePlaylist);

        Assert.assertTrue(songsPage.GetIsSuccess().isDisplayed());

    }

}
