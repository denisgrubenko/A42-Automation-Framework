import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {

    @Test(enabled = true)
    public void playSong(){

        loginPage.login();
        homePage.goToAllSongs();
        songsPage.clickOnFirstSong();
        homePage.pressPlay();
        homePage.moveMouseToPlayButton();

        Assert.assertTrue(homePage.getPauseButton().isDisplayed());
    }

}
