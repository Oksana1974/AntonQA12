package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/groups.csv")));

        String line = reader.readLine();
        while (line!= null){
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData()
                    .withName(split[0])
                    .withHeader(split[1])
                    .withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void GroupCreationTest(GroupData group) {
        app.goTo().groupsPage();
        List<GroupData> before = app.groups().getGroupList();
//        int before = app.groups().getGroupCount();
        app.groups().initGroupCreation();
        app.groups().fillGroupForm(group);
        app.groups().submitGroupCreation();
        app.groups().returnToGroupsPage();
        List<GroupData> after = app.groups().getGroupList();
        Assert.assertEquals(after.size(),before.size()+1);
//        int after = app.groups().getGroupCount();
//        Assert.assertEquals(after,before+1);
    }

}
