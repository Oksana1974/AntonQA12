package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{

    @Test
    public void GroupCreationTest() {
        goToGroupsPage();
        int before = wd.findElements(By.name("selected[]")).size();
        initGroupCreation();
        fillGroupForm(new GroupData("A", "H", "F"));
        submitGroupCreation();
        returnToGroupsPage();
        int after = wd.findElements(By.name("selected[]")).size();
        Assert.assertEquals(after,before+1);
    }

}
