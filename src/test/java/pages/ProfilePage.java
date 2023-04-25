package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.UUID;

public class ProfilePage extends BasePage{

    @FindBy(css="span.name")
    private WebElement profileName;
    @FindBy(css=".btn-submit")
    private WebElement saveButton;
    @FindBy(id="inputProfileName")
    private WebElement userNameField;
    @FindBy(id="inputProfileEmail")
    private WebElement currentEmailField;
    @FindBy(id="inputProfileCurrentPassword")
    private WebElement currentPasswordField;
    @FindBy(css=".view-profile")
    private WebElement profile;


    public ProfilePage(WebDriver givenDriver){
        super(givenDriver);
    }

    public String getProfileName() {
        return profileName.getText();
    }

    public void saveProfile() {
        saveButton.click();
    }

    public void enterNewName(String newName) {
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);
    }

    public void enterCurrentEmail(String email) {
        currentEmailField.click();
        currentEmailField.clear();
        currentEmailField.sendKeys(email);
    }

    public void enterCurrentPassword(String password) {
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void openProfile() {
        profile.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
