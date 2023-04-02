import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class ProfileTests extends BaseTest {

    @Test(enabled = true)
    public void successfulLoginTest() {
        login("demo@class.com", "te$t$tudent");
        openProfile();
        enterCurrentPassword("te$t$tudent");
        enterCurrentEmail("demo@class.com");
        String newName = generateRandomName();
        System.out.println(newName);
        enterNewName(newName);
        saveProfile();
        driver.navigate().refresh();
        String name = getProfileName();
        Assert.assertEquals(newName, name);
    }

    private String getProfileName() {
        WebElement profileName = findElement("span.name");
        return profileName.getText();
    }

    private void saveProfile() {
        WebElement saveButton = findElement(".btn-submit");
        saveButton.click();
    }

    private void enterNewName(String newName) {
        WebElement userNameField = findElement("","inputProfileName");
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);
    }

    private void enterCurrentEmail(String email) {
        WebElement currentEmailField = findElement("","inputProfileEmail");
        currentEmailField.click();
        currentEmailField.clear();
        currentEmailField.sendKeys(email);
    }

    private void enterCurrentPassword(String password) {
        WebElement currentPasswordField = findElement("","inputProfileCurrentPassword");
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    private void openProfile() {
        WebElement profile = findElement(".view-profile");
        profile.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
