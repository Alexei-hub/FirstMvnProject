
import org.testng.Assert;
import org.testng.annotations.Test;


public class SoftAssert {

    @Test
    public void testCaseOne() {
        System.out.println("*** test case one started ***");
        Assert.assertEquals(5, 5, "First hard assert failed");
        System.out.println("hard assert success....");
        Assert.assertTrue("Hello".equals("hello"), "Second hard assert failed");
        System.out.println("*** test case one executed successfully ***");
    }

    @Test
    public void testCasetwo() {
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
        System.out.println("*** test case two started ***");
        softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
        System.out.println("hard assert success....");
        softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
        softAssert.assertTrue("Welcome".equals("welcomeeee"), "Third soft assert failed");
        System.out.println("*** test case two executed successfully ***");
        softAssert.assertAll();
    }

}


