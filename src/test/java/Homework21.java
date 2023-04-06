import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist(){

        String namePlaylist     = "MyPlaylist";
        WebElement elementMyPlaylist;

        loginPage.login();
        elementMyPlaylist = homePage.findCreatePlaylist(namePlaylist);
        String newName = elementMyPlaylist.getText()+1;
        homePage.doubleClick(elementMyPlaylist);
        homePage.inputTextByActive(newName);

        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }

}
