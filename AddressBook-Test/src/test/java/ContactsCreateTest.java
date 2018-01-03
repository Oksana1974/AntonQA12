import org.testng.annotations.Test;

public class ContactsCreateTest extends TestBase{

    @Test
    public void ContactsCreateTest() {
        createContactTest();
        fillContactForm("A", "b", "P", "T", "1", "Q", "F", "353", "052", "\\9", "\\9", "asd", "sdf", "\\9", "\\9", "1980", "\\9", "k", "\\9", "\\9");
        submitContactCreation();
    }

}
