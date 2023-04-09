import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {

    @Test(enabled = true)
    public void playSong(){

        loginPage.login();
        songsPage.goToAllSongs();
        songsPage.clickOnFirstSong();
        songsPage.pressPlay();
        songsPage.moveMouseToPlayButton();

        Assert.assertTrue(songsPage.getPauseButton().isDisplayed());
    }

}
