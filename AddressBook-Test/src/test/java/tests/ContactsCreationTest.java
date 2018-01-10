package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsCreationTest extends TestBase{

    @Test
    public void ContactsCreationTest() {
        int before = app.getContactCount();
        app.createContactTest();
        app.fillContactForm(new ContactData("r", "e", "w", "q", "q", "w", "e", "r", "e", "w", "q", "q", "w", "e", "w", "2345", "3456", "3", "w", "d"));
        app.submitContactCreation();
        int after = app.getContactCount();
        Assert.assertEquals(after, before+1);
    }

}
