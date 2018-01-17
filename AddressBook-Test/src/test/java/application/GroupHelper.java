package application;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupsDeletion() {
        click(By.name("delete"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void confirmGroupModification() {
        click(By.name("update"));
    }
}
