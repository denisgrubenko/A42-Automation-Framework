import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist(){

        String namePlaylist     = "MyPlaylist";
        WebElement elementMyPlaylist;

        loginPage.login();
        homePage.GetUserAvatar();
        elementMyPlaylist = playlistPage.findCreatePlaylist(namePlaylist);
        String newName = elementMyPlaylist.getText()+1;
        playlistPage.inputReName(elementMyPlaylist, newName);

        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }
}
