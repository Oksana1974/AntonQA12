import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{

    @Test
    public void GroupCreationTest() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("name", "header", "footer");
        submitGroupCreation();
        returnToGroupsPage();
    }

}
