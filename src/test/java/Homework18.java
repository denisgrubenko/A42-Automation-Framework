import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {
    @Test(enabled = true)
    public void playSong()throws InterruptedException{

        login("denis.grubenko@gmail.com");

        driver.get("https://bbb.testpro.io/#!/songs");

        //get first song
        getAndClickByCSS("[draggable='true'] [class='title']");

        WebElement button  = driver.findElement(By.cssSelector("[class='album-thumb']"));
        new Actions(driver)
                .moveToElement(button)
                .perform();

        getAndClickByCSS("[data-testid='play-btn']");

        //check #1: there is the sound bar
        getAndClickByCSS("[alt='Sound bars']");

        //check #2: there is the pause button
        new Actions(driver)
                .moveToElement(button)
                .perform();
        getAndClickByCSS("[data-testid='pause-btn']");

    }

}
