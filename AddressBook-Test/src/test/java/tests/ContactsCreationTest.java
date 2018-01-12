package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsCreationTest extends TestBase{

    @Test
    public void ContactsCreationTest() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContactTest();
        app.getContactHelper().fillContactForm(new ContactData("r", "e", "w", "q", "q", "w", "e", "r", "e", "w", "q", "q", "w", "e", "w", "2345", "3456", "3", "w", "d"));
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before+1);
    }

}
