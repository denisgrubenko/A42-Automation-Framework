package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    //private String avatarLocator = "a .avatar";
    @FindBy(css="a .avatar")
    private WebElement avatarLocator;



    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    public WebElement GetUserAvatar() {
       return findElement(avatarLocator);
    }





}
