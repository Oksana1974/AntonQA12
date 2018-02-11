package tests;

import model.ContactData;
import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactsCreationTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/contacts.csv")));

        String line = reader.readLine();
        while (line!= null){
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData()
                    .withFirstName(split[0])
                    .withLastName(split[1])
                    .withAddress(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void ContactsCreationTest(ContactData contact) {
        app.goTo().contactsPage();
//        int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        app.contacts().createContactTest();
        app.contacts().fillContactForm(contact);
//                .withFirstName("Test3")
//                .withLastName("TestG3")
//                .withNickName("C")
//                .withAddress("D")
//                .withAddress2("E")
//                .withaYear("1981")
//                .withbYear("1996")
//                .withCompany("DFG")
//                .withEmail("")
//                .withEmail2("")
//                .withEmail3("")
//                .withFax("")
//                .withHome("")
//                .withHomepage("")
//                .withMidleName("")
//                .withMobile("567")
//                .withNotes("")
//                .withPhone2("678")
//                .withTitle("")
//                .withWork("")
//                .withGroup("Test")
//                .withbDay("4")
//                .withbMonth("May")
//                .withaDay("20")
//                .withaMonth("May"));
        app.contacts().submitContactCreation();
//        int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
    }

    @Test
    public void ContactsCreationTestWithPhoto() {
        app.goTo().contactsPage();
//        int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        app.contacts().createContactTest();
        File photo = new File("src/test/resources/photo.jpg");
        app.contacts().fillContactForm(new ContactData()
                .withFirstName("Test3")
                .withLastName("TestG3")
                .withPhoto(photo)
        );
//                .withNickName("C")
//                .withAddress("D")
//                .withAddress2("E")
//                .withaYear("1981")
//                .withbYear("1996")
//                .withCompany("DFG")
//                .withEmail("")
//                .withEmail2("")
//                .withEmail3("")
//                .withFax("")
//                .withHome("")
//                .withHomepage("")
//                .withMidleName("")
//                .withMobile("567")
//                .withNotes("")
//                .withPhone2("678")
//                .withTitle("")
//                .withWork("")
//                .withGroup("Test")
//                .withbDay("4")
//                .withbMonth("May")
//                .withaDay("20")
//                .withaMonth("May"));
        app.contacts().submitContactCreation();
//        int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
    }

    @Test
    public void getCurrentURL(){
        File curr = new File(".");
        System.out.println(curr.getAbsolutePath());
    }

}
