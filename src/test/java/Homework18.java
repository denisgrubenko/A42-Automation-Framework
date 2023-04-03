import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {
    @Test(enabled = true)
    public void playSong(){

        login("denis.grubenko@gmail.com");

        driver.get("https://bbb.testpro.io/#!/songs");

        //get first song
        getAndClick("[draggable='true'] [class='title']");

        WebElement button  = findElement("[class='album-thumb']");
        new Actions(driver)
                .moveToElement(button)
                .perform();

        getAndClick("[data-testid='play-btn']");

        //check #1: there is the sound bar
        getAndClick("[data-testid='toggle-visualizer-btn']");

        //check #2: there is the pause button
        new Actions(driver)
                .moveToElement(button)
                .perform();

        WebElement success = findElement("[data-testid='pause-btn']");
        Assert.assertTrue(success.isDisplayed());
    }

}
