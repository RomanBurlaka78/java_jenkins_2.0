package roman.jenkins;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import roman.jenkins.model.HomePage;
import roman.jenkins.model.jobs.configs.FolderConfigurationPage;
import roman.jenkins.model.jobs.details.FolderDetailsPage;
import roman.jenkins.model.*;
import roman.jenkins.runner.BaseTest;

public class FolderTest extends BaseTest {
    private static final String FOLDER_NAME = "FolderProjectName";
    private static final String NAME_FOR_BOUNDARY_VALUES = "A";
    private static final String RENAMED_FOLDER = "RenamedFolder";
    private static final String NESTED_FOLDER = "NestedFolder";
    private static final String JOB_NAME = "New Job";
    private static final String PIPELINE_PROJECT_NAME = "New pipeline project";
    private static final String DESCRIPTION_NAME = "Description Name";

    @DataProvider
    public Object[][] provideUnsafeCharacters() {

        return new Object[][]{
                {"#"}, {"&"}, {"?"}, {"!"}, {"@"}, {"$"}, {"%"}, {"^"}, {"*"}, {"|"}, {"/"}, {"\\"}, {"<"}, {">"},
                {"["}, {"]"}, {":"}, {";"}
        };
    }

    @Ignore
    @Test
    public void testCreate() {
        HomePage homePage = new HomePage(getDriver())
                .clickNewItem()
                .typeItemName(FOLDER_NAME)
                .selectItemFolder()
                .clickOk(new FolderConfigurationPage(getDriver()))
                .goHomePage();

        Assert.assertTrue(homePage.getJobList().contains(FOLDER_NAME));
    }

    @Ignore
    @Test(dependsOnMethods = "testCreate")
    public void testRename() {
        HomePage homePage = new HomePage(getDriver())
                .clickJobByName(FOLDER_NAME, new FolderDetailsPage(getDriver()))
                .clickRename()
                .enterName(RENAMED_FOLDER)
                .clickRenameButton()
                .goHomePage();

        Assert.assertTrue(homePage.getJobList().contains(RENAMED_FOLDER));
    }


}

















