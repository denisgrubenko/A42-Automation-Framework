//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class SongsTests extends BaseTest {
//
//    @Test
//    public void addSongToPlaylist()  {
//
//        String song = "Waiting on a train";
//        // login
//        basePage.login("demo@class.com", "te$t$tudent");
//        // search song
//        WebElement searchField = basePage.driver.findElement(By.cssSelector("[type='search']"));
//        searchField.click();
//        searchField.clear();
//        searchField.sendKeys(song);
//        // click view all
//        WebElement viewAllBtn = basePage.driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
//        viewAllBtn.click();
//        // click on the first song
//        List<WebElement> songResults = basePage.driver.findElements(By.cssSelector("#songResultsWrapper .song-item"));
//        songResults.get(0).click();
//        // add to playlist
//        WebElement addToBtn = basePage.driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
//        addToBtn.click();
//        // create a new playlist
//        List<WebElement> listNameField = basePage.driver.findElements(By.cssSelector(".form-save [data-test='new-playlist-name']"));
//        listNameField.get(2).click();
//        listNameField.get(2).clear();
//        listNameField.get(2).sendKeys("123");
//        new Actions(basePage.driver)
//                .keyDown(Keys.ENTER)
//                .perform();
//        // assert
//        WebElement successBanner = basePage.driver.findElement(By.cssSelector(".success.show"));
//        Assert.assertTrue(successBanner.isDisplayed());
//    }
//
//
//
//
//
//}
