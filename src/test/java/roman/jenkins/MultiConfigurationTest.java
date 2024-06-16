package roman.jenkins;


import org.testng.Assert;
import org.testng.annotations.Test;
import roman.jenkins.model.HomePage;
import roman.jenkins.model.jobs.configs.MultiConfigurationConfigurePage;
import roman.jenkins.model.jobs.details.MultiConfigurationDetailsPage;
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

    @Test(dependsOnMethods = "testCreate")
    public void testFindJob() {
        String searchProject = new HomePage(getDriver())
                .goSearchBox(NAME_OF_PROJECT, new MultiConfigurationConfigurePage(getDriver()))
                .getHeadLineText();

        Assert.assertEquals(searchProject, "Project " + NAME_OF_PROJECT);
    }

    @Test
    public void testCreateWithoutName() {
        String getErrorName = new HomePage(getDriver())
                .clickNewItem()
                .selectMultiConfigurationProject()
                .getRequiredNameErrorMessage();

        Assert.assertEquals(getErrorName, "» This field cannot be empty, please enter a valid name");
    }

    @Test(dependsOnMethods = "testCreate")
    public void testDisableProject() {
        String disableProject = new HomePage(getDriver())
                .clickJobByName(NAME_OF_PROJECT, new MultiConfigurationDetailsPage(getDriver()))
                .clickDisableButton()
                .getDisabledMessageText();

        Assert.assertEquals(disableProject,
                "This project is currently disabled");
    }

    @Test(dependsOnMethods = {"testCreate", "testDisableProject"})
    public void testEnableProject() {
        String enableProject = new HomePage(getDriver())
                .clickJobByName(NAME_OF_PROJECT, new MultiConfigurationDetailsPage(getDriver()))
                .clickEnableButton()
                .getDisableEnableButtonText();

        Assert.assertEquals(enableProject,
                "Disable Project");
    }

}
