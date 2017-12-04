import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test()
public class testetsng {
    @DataProvider
    public Object[][] data() {
        return new String[][]{new String[]{"1"}, new String[]{"2 2 2"}, new String[]{"1 2 56"}, new String[]{"2 1 34"}};
    }

    @Test(dataProvider = "data")
    public void test(String d) {
        System.out.println(d);
    }
}

