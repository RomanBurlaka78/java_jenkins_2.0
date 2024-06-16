package roman.jenkins;


import org.testng.Assert;
import org.testng.annotations.Test;
import roman.jenkins.model.HomePage;
import roman.jenkins.model.jobs.configs.MultiConfigurationConfigurePage;
import roman.jenkins.runner.BaseTest;


public class MultiConfigurationTest extends BaseTest {

    private final static String NAME_OF_PROJECT = "Multi-configuration project";
    private final static String NEW_NAME_OF_PROJECT = "New Multi-configuration project";

    @Test
    public void testCreate() {

        Boolean createProject = new HomePage(getDriver())
                .clickNewItem()
                .typeItemName(NAME_OF_PROJECT)
                .selectMultiConfigurationProject()
                .clickOk(new MultiConfigurationConfigurePage(getDriver()))
                .goHomePage()
                .isProjectExist(NAME_OF_PROJECT);

        Assert.assertTrue(createProject, NAME_OF_PROJECT);

    }

    @Test(dependsOnMethods = "testCreate")
    public void testCreateWithSameName() {

        String createWithSameName = new HomePage(getDriver())
                .clickNewItem()
                .typeItemName(NAME_OF_PROJECT)
                .getInvalidNameErrorMessage();

        Assert.assertEquals(createWithSameName, "» A job already exists with the name ‘" + NAME_OF_PROJECT + "’");

    }

}
