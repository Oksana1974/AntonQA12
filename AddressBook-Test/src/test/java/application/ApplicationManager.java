package application;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {
    FirefoxDriver wd;

    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;
    public ContactHelper contactHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void start() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openAddressBook();
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        contactHelper = new ContactHelper(wd);
        login("admin", "secret");
    }

    public void login(String userName, String userPass) {
        groupHelper.type(By.name("user"), userName);
        groupHelper.type(By.name("pass"), userPass);
        groupHelper.click(By.xpath("//*[@type='submit']"));
    }

    public void openAddressBook() {
        wd.get("http://localhost/addressbook/");
    }



    public void stop() {
        wd.quit();
    }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
