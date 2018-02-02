package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContModify() {
        app.goTo().contactsPage();
        if (!app.contacts().isThereAContact()) {
            app.contacts().createContact(new ContactData()
                    .withFirstName("d")
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

//        int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        app.contacts().selectAndModifyContactByIndex(before.size()-1);
        ContactData contact = new ContactData()
                .withId(before.get(before.size()-1).getId())
                .withFirstName("Test")
                .withLastName("Test");
        app.contacts().fillContactForm(contact);
        app.contacts().updateContact();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
