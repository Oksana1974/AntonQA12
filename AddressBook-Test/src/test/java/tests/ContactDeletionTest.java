package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    
    @Test
    public void ContactDeletionTest() {
        int before = app.getContactCount();
        app.selectContact();
        app.initContactDeletion();
        app.confirmAlert();
        int after = app.getContactCount();
        Assert.assertEquals(after, before-1);
    }
}
