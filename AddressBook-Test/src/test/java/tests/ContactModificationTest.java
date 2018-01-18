package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContModify(){
        app.getNavigationHelper().goToContactsPage();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper()
                    .createContact(new ContactData("e", null, "l", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().fillContactForm(new ContactData("A", "a", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        app.getContactHelper().updateContact();
    }
}
