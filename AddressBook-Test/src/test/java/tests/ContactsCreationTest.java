package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactsCreationTest extends TestBase{

    @Test
    public void ContactsCreationTest() {
        app.goTo().contactsPage();
//        int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        app.contacts().createContactTest();
        app.contacts().fillContactForm(new ContactData()
                .withFirstName("Test")
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
        app.contacts().submitContactCreation();
//        int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
    }

}
