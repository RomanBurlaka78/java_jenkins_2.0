package roman.jenkins.model.builds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import roman.jenkins.model.jobs.details.PipelineDetailsPage;
import roman.jenkins.model.base.BasePage;

public class ReplayBuildPipelinePage extends BasePage<ReplayBuildPipelinePage> {

    @FindBy(xpath = "//button[@name = 'Submit']")
    private WebElement runButton;

    public ReplayBuildPipelinePage(WebDriver driver) {
        super(driver);
    }

    public PipelineDetailsPage clickRunButton() {
        runButton.click();

        return new PipelineDetailsPage(getDriver());
    }

}
