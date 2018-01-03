import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

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
