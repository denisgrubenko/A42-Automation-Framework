import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test(enabled = true)
    public void testDeletePlaylist(){

        String namePlaylist = "MyPlaylist";

        loginPage.login();
        homePage.findCreatePlaylist(namePlaylist);
        homePage.deletePlaylist(namePlaylist);
        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }
}
