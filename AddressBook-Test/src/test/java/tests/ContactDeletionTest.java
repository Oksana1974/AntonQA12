package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    
    @Test
    public void ContactDeletionTest() {
        app.goTo().contactsPage();
        if(!app.contacts().isThereAContact()){
            app.contacts()
                    .createContact(new ContactData().withLastName("B")
                            .withNickName("C")
                            .withAddress("D")
                            .withAddress2("E")
                            .withaYear("123")
                            .withbYear("234")
                            .withCompany("DFG")
                            .withEmail("")
                            .withEmail2("")
                            .withEmail3("")
                            .withFax("")
                            .withHome("")
                            .withHomepage("")
                            .withMidleName("")
                            .withMobile("567")
                            .withNotes("")
                            .withPhone2("678")
                            .withTitle("")
                            .withWork(""));
        }
        int before = app.contacts().getContactCount();
        app.contacts().selectContactByIndex(before-1);
        app.contacts().initContactDeletion();
//        app.getContactHelper().confirmAlert();
        int after = app.contacts().getContactCount();
        Assert.assertEquals(after, before-1);
    }
}
