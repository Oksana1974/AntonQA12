package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsCreationTest extends TestBase{

    @Test
    public void ContactsCreationTest() {
        int before = wd.findElements(By.xpath("//*[@title='Edit']")).size();
        createContactTest();
        fillContactForm("r", "e", "w", "q", "q", "w", "e", "r", "e", "w", "q", "q", "w", "e", "w", "2345", "3456", "3", "w", "d");
        submitContactCreation();
        int after = wd.findElements(By.xpath("//*[@title='Edit']")).size();
        Assert.assertEquals(after, before+1);
    }

}
