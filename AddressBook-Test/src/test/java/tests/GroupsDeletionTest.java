package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
        List<GroupData> before = app.groups().getGroupList();
//        int before = app.groups().getGroupCount();
        app.groups().selectGroupByIndex(before.size()-1);
        app.groups().initGroupsDeletion();
        app.groups().returnToGroupsPage();
//        int after = app.groups().getGroupCount();
        List<GroupData> after = app.groups().getGroupList();
        Assert.assertEquals(after.size(),before.size()-1);
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
//        for(int i=0; i<after.size(); i++){
//            Assert.assertEquals(before.get(i), after.get(i));
//        }
    }

}
