package application;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//*[@title='Edit']")).size();
    }

    public void initContactDeletion() {
        click(By.xpath("//*[@value='Delete']"));
    }

    public void selectContact() {
        click(By.xpath("//*[@title='Edit']"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMidleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
//            click(By.xpath("//div[@id='content']/form/select[1]//option[14]"));
//        }
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
//            click(By.xpath("//div[@id='content']/form/select[2]//option[7]"));
//        }
        type(By.name("byear"), contactData.getbYear());
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[13]")).isSelected()) {
//            click(By.xpath("//div[@id='content']/form/select[3]//option[13]"));
//        }
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[5]")).isSelected()) {
//            click(By.xpath("//div[@id='content']/form/select[4]//option[5]"));
//        }
        type(By.name("ayear"), contactData.getaYear());
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[3]")).isSelected()) {
//            click(By.xpath("//div[@id='content']/form/select[5]//option[3]"));
//        }
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createContactTest() {
        click(By.linkText("add new"));
    }
}
