package tests;
import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;


public class GroupModificationTest extends TestBase {

        @Test
        public void groupModificationTest(){
            app.goTo().groupsPage();
            if(!app.groups().isThereAGroup()){
                app.groups()

                        .createGroup(new GroupData()
                                .withName("e")
                                .withHeader(null)
                                .withFooter("l"));
            }
//            int before = app.groups().getGroupCount();
            List<GroupData> before = app.groups().getGroupList();
            app.groups().selectGroupByIndex(before.size()-1);
            app.groups().initGroupModification();
            GroupData group = new GroupData()
                    .withId(before.get(before.size()-1).getId())
                    .withName("test 1");
            app.groups().fillGroupForm(group);
            app.groups().confirmGroupModification();
            app.groups().returnToGroupsPage();

            List<GroupData> after = app.groups().getGroupList();
            Assert.assertEquals(before.size(), after.size());
            before.remove(before.size()-1);
            before.add(group);
            Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

//            Assert.assertEquals(before, after);
        }

    }

