package tests;
import model.GroupData;
import org.testng.annotations.Test;



    public class GroupModificationTest extends TestBase {

        @Test
        public void testGroupModify(){
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
            app.groups().initGroupModification();
            app.groups().fillGroupForm(new GroupData()
                    .withName("")
                    .withHeader("")
                    .withFooter(""));
            app.groups().confirmGroupModification();
            app.groups().returnToGroupsPage();
        }
    }

