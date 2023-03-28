import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public static void ClickOnRegistrationLinkTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationlink = driver.findElement(By.id("hel"));
        registrationlink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/registration.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        driver.quit();
    }
}
