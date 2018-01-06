package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeClass
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openAddressBook();
        login("admin", "secret");
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void goToGroupsPage() {
        click(By.linkText("groups"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void login(String userName, String userPass) {
        type(By.name("user"), userName);
        type(By.name("pass"), userPass);
        click(By.xpath("//*[@type='submit']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void openAddressBook() {
        wd.get("http://localhost/addressbook/");
    }

    public void fillContactForm(String firstName, String midleName, String lastName, String nickName, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String bYear, String aYear, String address2, String phone2, String notes) {
        click(By.name("firstname"));
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(firstName);
        click(By.name("middlename"));
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(midleName);
        click(By.name("lastname"));
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastName);
        click(By.name("nickname"));
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickName);
        click(By.name("title"));
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(title);
        click(By.name("company"));
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(company);
        click(By.name("address"));
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(address);
        click(By.name("home"));
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(home);
        click(By.name("mobile"));
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(mobile);
        click(By.name("work"));
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(work);
        click(By.name("fax"));
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(fax);
        click(By.name("email"));
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(email);
        click(By.name("email2"));
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(email2);
        click(By.name("email3"));
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(email3);
        click(By.name("homepage"));
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homepage);
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[14]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[14]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[7]"));
        }
        click(By.name("byear"));
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(bYear);
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[13]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[3]//option[13]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[5]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[4]//option[5]"));
        }
        click(By.name("ayear"));
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(aYear);
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[3]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[3]"));
        }
        click(By.name("address2"));
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(address2);
        click(By.name("phone2"));
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(phone2);
        click(By.name("notes"));
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(notes);
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void initGroupsDeletion() {
        click(By.name("delete"));
    }

    public void selectGroup() {
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/span[7]/input")).isSelected()) {
//            wd.findElement(By.xpath("//div[@id='content']/form/span[7]/input")).click();
//        }
        click(By.name("selected[]"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }



    public void createContactTest() {
        click(By.linkText("add new"));
    }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void initContactDeletion() {
//        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
        click(By.xpath("//*[@value='Delete']"));
    }

    public void selectContact() {
//        if (!wd.findElement(By.id("3")).isSelected()) {
//            wd.findElement(By.id("3")).click();
//        }
        click(By.name("selected[]"));
    }
}
