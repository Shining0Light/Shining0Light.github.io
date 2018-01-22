import org.junit.Assert;
import org.junit.Test;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 17:25 01/22/18
 */
public class AMethodTest {

    @Test
    public void printSth() {
        Assert.assertEquals("hello world", new AMethod().printSth());
    }
}
