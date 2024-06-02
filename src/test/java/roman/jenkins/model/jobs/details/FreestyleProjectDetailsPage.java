package roman.jenkins.model.jobs.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import roman.jenkins.model.builds.BuildPage;
import roman.jenkins.model.jobs.configs.FreestyleProjectConfigurePage;
import roman.jenkins.model.HomePage;
import roman.jenkins.model.WorkspacePage;
import roman.jenkins.model.base.BaseDetailsPage;

import java.util.ArrayList;
import java.util.List;

public class FreestyleProjectDetailsPage extends BaseDetailsPage<FreestyleProjectConfigurePage, FreestyleProjectDetailsPage> {

    @FindBy(xpath = "//a[@href='lastBuild/']")
    private WebElement lastBuild;

    @FindBy(css = "ul[class='permalinks-list']")
    private WebElement listPermalinks;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement projectDescriptionInputField;

    @FindBy(xpath = "//*[@id='tasks']/div[6]/span/a/span[2]")
    private WebElement getDeleteProject;

    @FindBy(xpath = "//a[contains(@href,'ws')]")
    private WebElement workspaceButton;

    @FindBy(xpath = "//a//span[2]")
    private List<WebElement> itemsSidePanel;

    @FindBy(xpath = "//ul[@style='list-style-type: none;']/li/a")
    private List<WebElement> upstreamProjectsList;

    @FindBy(xpath = "//button[@data-id=\"ok\"]")
    WebElement getDeleteOkButton;


    public FreestyleProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected FreestyleProjectConfigurePage createConfigurationPage() {
        return new FreestyleProjectConfigurePage(getDriver());
    }

    public WorkspacePage goToWorkspaceFromSideMenu() {
        workspaceButton.click();

        return new WorkspacePage(getDriver());
    }

    public boolean isJobExist() {
        return getDriver().findElement(By.xpath("//div[@id='main-panel']//h1")).isDisplayed();
    }

    public BuildPage clickPermalinkLastBuild() {
        lastBuild.click();

        return new BuildPage(getDriver());
    }

    public String getPermalinksText() {
        return listPermalinks.getText();
    }

    public FreestyleProjectDetailsPage insertDescriptionText(String description) {
        projectDescriptionInputField.sendKeys(description);

        return this;
    }

    public FreestyleProjectDetailsPage deleteDescriptionText() {
        projectDescriptionInputField.clear();

        return this;
    }

    public HomePage deleteProject() {
        getDeleteProject.click();
        getWait5().until(ExpectedConditions.elementToBeClickable(getDeleteOkButton));
        getDeleteOkButton.click();

        return new HomePage(getDriver());
    }

    public List<String> getTextItemsSidePanel() {
        List<String> textValue = new ArrayList<>();
        for (WebElement item : itemsSidePanel) {
            textValue.add(item.getText());
        }

        return textValue;
    }

    public List<String> getUpstreamProjectsList() {
        return upstreamProjectsList.stream().map(WebElement::getText).toList();
    }
}
