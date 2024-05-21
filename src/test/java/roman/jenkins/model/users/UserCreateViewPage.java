package roman.jenkins.model.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import roman.jenkins.model.base.BasePage;

public class UserCreateViewPage extends BasePage<UserCreateViewPage> {

    @FindBy(css = "#name")
    private WebElement viewNameTextArea;

    @FindBy(xpath = "//label[@for='hudson.model.MyView']")
    private WebElement myViewTypeCheckBox;

    @FindBy(name = "Submit")
    private WebElement createButton;

    public UserCreateViewPage(WebDriver driver) {
        super(driver);
    }

    public UserCreateViewPage createUserViewAndSave(String viewName) {
        viewNameTextArea.sendKeys(viewName);
        myViewTypeCheckBox.click();
        createButton.click();

        return this;
    }
}
