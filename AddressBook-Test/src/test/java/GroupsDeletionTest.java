import org.testng.annotations.Test;

public class GroupsDeletionTest extends TestBase{

    @Test
    public void GroupsDeletionTest() {
        goToGroupsPage();
        selectGroup();
        initGroupsDeletion();
        returnToGroupsPage();
    }
}
