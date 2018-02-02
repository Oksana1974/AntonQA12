package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{

    
    @Test
    public void ContactDeletionTest() {
        app.goTo().contactsPage();
        if(!app.contacts().isThereAContact()){
            app.contacts()
                    .createContact(new ContactData()
                            .withFirstName("A")
                            .withLastName("B")
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
        List<ContactData> before = app.contacts().getContactList();
//        int before = app.contacts().getContactCount();
        app.contacts().selectAndModifyContactByIndex(before.size()-1);
        app.contacts().initContactDeletion();
//        app.contacts().confirmAlert();
//        int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(after.size(),before.size()-1);
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
