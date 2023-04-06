import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {
    @Test(enabled = true)
    public void playSong(){

        loginPage.login();

        driver.get("https://bbb.testpro.io/#!/songs");

        //get first song
        homePage.clickOnFirstSong();

        homePage.pressPlay();
        homePage.moveMouseToPlayButton();

        WebElement success = homePage.getPauseButton();
        Assert.assertTrue(success.isDisplayed());
    }




}
