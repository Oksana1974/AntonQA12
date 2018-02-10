import org.testng.annotations.Test;

public class BMetodsTest {

    @Test(groups = {"positive", "broken"})
    public void test1B() {
        System.out.println("broken testB");
    }

    @Test(groups = "positive")
    public void test2B() {
        System.out.println("positive testB");
    }


    @Test(groups = "negative")
    public void test3B() {
        System.out.println("negative testB");
    }
}
