import org.testng.annotations.Test;

public class TaggedMethodsTests {
    @Test(groups = {"positive", "broken"})
    public void test1T() {
        System.out.println("broken testT");
    }

    @Test(groups = "positive")
    public void test2T() {
        System.out.println("positive testT");
    }


    @Test(groups = "negative")
    public void test3T() {
        System.out.println("negative testT");
    }
}
