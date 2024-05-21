package roman.jenkins.model.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import roman.jenkins.model.view.ViewPage;
import roman.jenkins.model.HomePage;
import roman.jenkins.model.view.*;

public abstract class BaseViewConfigPage extends BasePage<BaseViewConfigPage>{

    @FindBy(name = "Submit")
    protected WebElement createButton;

    @FindBy(xpath = "//span[text()='Delete View']")
    private WebElement deleteView;

    public BaseViewConfigPage(WebDriver driver) {
        super(driver);
    }

    public ViewPage clickOkButton() {
        createButton.click();

        return new ViewPage(getDriver());
    }

    public HomePage clickDeleteView() {
        deleteView.click();

        return new HomePage(getDriver());
    }
}
