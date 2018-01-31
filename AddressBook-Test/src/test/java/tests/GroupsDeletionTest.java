package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsDeletionTest extends TestBase{

    @Test
    public void GroupsDeletionTest() {
        app.goTo().groupsPage();
        if(!app.groups().isThereAGroup()){
            app.groups()
                    .createGroup(new GroupData()
                            .withName("e")
                            .withHeader(null)
                            .withFooter("l"));
        }
        int before = app.groups().getGroupCount();
        app.groups().selectGroupByIndex(before-1);
        app.groups().initGroupsDeletion();
        app.groups().returnToGroupsPage();
        int after = app.groups().getGroupCount();
        Assert.assertEquals(after,before-1);
    }

}
