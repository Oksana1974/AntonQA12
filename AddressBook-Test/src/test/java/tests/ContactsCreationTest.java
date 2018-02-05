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
                .withFirstName("Test3")
                .withLastName("TestG3")
                .withNickName("C")
                .withAddress("D")
                .withAddress2("E")
                .withaYear("1981")
                .withbYear("1996")
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
                .withWork("")
                .withGroup("Test")
                .withbDay("4")
                .withbMonth("May")
                .withaDay("20")
                .withaMonth("May"));
        app.contacts().submitContactCreation();
//        int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
    }

}
