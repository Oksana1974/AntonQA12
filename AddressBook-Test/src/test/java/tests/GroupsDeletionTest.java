package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsDeletionTest extends TestBase{

    @Test
    public void GroupsDeletionTest() {
        goToGroupsPage();
        int before = wd.findElements(By.name("selected[]")).size();
        selectGroup();
        initGroupsDeletion();
        returnToGroupsPage();
        int after = wd.findElements(By.name("selected[]")).size();
        Assert.assertEquals(after,before-1);
    }
}
