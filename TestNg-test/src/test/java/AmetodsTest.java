import org.testng.annotations.Test;

public class AmetodsTest {

    @Test(groups = {"positive", "broken"})
    public void test1A() {
        System.out.println("broken testA");
    }

    @Test(groups = "positive")
    public void test2A() {
        System.out.println("positive testA");
    }


    @Test(groups = "negative")
    public void test3A() {
        System.out.println("negative testA");
    }
}
