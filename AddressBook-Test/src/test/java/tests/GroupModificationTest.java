package tests;
import model.GroupData;
import org.testng.annotations.Test;



    public class GroupModificationTest extends TestBase {

        @Test
        public void testGroupModify(){
            app.getNavigationHelper().goToGroupsPage();
            if(!app.getGroupHelper().isThereAGroup()){
                app.getGroupHelper()
                        .createGroup(new GroupData("e", null, "l"));
            }
            app.getGroupHelper().selectGroup();
            app.getGroupHelper().initGroupModification();
            app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
            app.getGroupHelper().confirmGroupModification();
            app.getGroupHelper().returnToGroupsPage();
        }
    }

