package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContModify(){
        app.goTo().contactsPage();
        if(!app.contacts().isThereAContact()){
            app.contacts()
                    .createContact(new ContactData()
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
        app.contacts().selectContact();
        app.contacts().fillContactForm(new ContactData()
                .withLastName("")
                .withNickName("")
                .withAddress("")
                .withAddress2("")
                .withaYear("")
                .withbYear("")
                .withCompany("")
                .withEmail("")
                .withEmail2("")
                .withEmail3("")
                .withFax("")
                .withHome("")
                .withHomepage("")
                .withMidleName("")
                .withMobile("")
                .withNotes("")
                .withPhone2("")
                .withTitle("")
                .withWork(""));
        app.contacts().updateContact();
    }
}
