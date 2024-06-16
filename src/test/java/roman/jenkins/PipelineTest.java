package roman.jenkins;

import org.testng.Assert;
import org.testng.annotations.Test;
import roman.jenkins.model.HomePage;
import roman.jenkins.model.jobs.configs.PipelineConfigurePage;
import roman.jenkins.runner.BaseTest;

public class PipelineTest extends BaseTest {

    public static final String PROJECT_NAME = "PipelineProject";

    public static final String PROJECT_NEW_NAME = "PipelineProjectNew";

    @Test
    public void testCreate() {
        Boolean createProject = new HomePage(getDriver())
                .clickNewItem()
                .typeItemName(PROJECT_NAME)
                .selectPipelineProject()
                .clickOk(new PipelineConfigurePage(getDriver()))
                .goHomePage()
                .isProjectExist(PROJECT_NAME);

        Assert.assertTrue(createProject, "Project not exists!!");
    }

}
