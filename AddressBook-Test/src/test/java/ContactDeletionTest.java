import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    
    @Test
    public void ContactDeletionTest() {
        selectContact();
        initContactDeletion();
        confirmAlert();
    }
}
