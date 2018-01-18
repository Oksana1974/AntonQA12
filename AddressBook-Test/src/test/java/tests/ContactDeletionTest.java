package tests;

import model.ContactData;
import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    
    @Test
    public void ContactDeletionTest() {
        app.getNavigationHelper().goToContactsPage();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper()
                    .createContact(new ContactData("e", null, "l", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContactByIndex(before-1);
        app.getContactHelper().initContactDeletion();
//        app.getContactHelper().confirmAlert();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before-1);
    }
}
