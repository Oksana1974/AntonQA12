import org.testng.annotations.Test;

public class ContactsCreationTest extends TestBase{

    @Test
    public void ContactsCreationTest() {
        createContactTest();
        fillContactForm();
        submitContactCreation();
    }

}
