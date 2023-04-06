package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class ProfilePage extends BasePage{

    String profileName = "span.name";
    String saveButton = ".btn-submit";
    String userNameField = "inputProfileName";
    String currentEmailField = "inputProfileEmail";
    String currentPasswordField = "inputProfileCurrentPassword";
    String profile = ".view-profile";

    public ProfilePage(WebDriver givenDriver){
        super(givenDriver);
    }

    public String getProfileName() {
        WebElement profileName = findElement("span.name");
        return profileName.getText();
    }

    public void saveProfile() {
        WebElement saveButton = findElement(".btn-submit");
        saveButton.click();
    }

    public void enterNewName(String newName) {
        WebElement userNameField = findElement("","inputProfileName");
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);
    }

    public void enterCurrentEmail(String email) {
        WebElement currentEmailField = findElement("","inputProfileEmail");
        currentEmailField.click();
        currentEmailField.clear();
        currentEmailField.sendKeys(email);
    }

    public void enterCurrentPassword(String password) {
        WebElement currentPasswordField = findElement("","inputProfileCurrentPassword");
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void openProfile() {
        WebElement profile = findElement(".view-profile");
        profile.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}