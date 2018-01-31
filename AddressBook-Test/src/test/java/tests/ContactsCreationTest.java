package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsCreationTest extends TestBase{

    @Test
    public void ContactsCreationTest() {
        app.goTo().contactsPage();
        int before = app.contacts().getContactCount();
        app.contacts().createContactTest();
        app.contacts().fillContactForm(new ContactData().withFirstName("A")
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
        int after = app.contacts().getContactCount();
        Assert.assertEquals(after, before+1);
    }

}
