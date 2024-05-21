package roman.jenkins.model.logrecorders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import roman.jenkins.model.base.BasePage;

public class NewLogRecorderPage extends BasePage<NewLogRecorderPage> {

    @FindBy(name = "name")
    private WebElement inputName;

    @FindBy(name = "Submit")
    private WebElement buttonCreate;

    public NewLogRecorderPage(WebDriver driver) {
        super(driver);
    }

    public NewLogRecorderPage typeName(String name) {
        inputName.clear();
        inputName.sendKeys(name);

        return this;
    }

    public ConfigureLogRecorderPage clickCreate() {
        buttonCreate.click();

        return new ConfigureLogRecorderPage(getDriver());
    }
}
