package test;
import com.company.IResourceStorage;
import com.company.Summator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SummatorTest {

    @Test
    public void getSum() {
        Summator summator = new Summator();
        String[] resources = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};

        IResourceStorage storage = summator.getSum(resources);
        assertTrue(storage.getInfoAboutStorage());
        assertNotNull(storage);
    }

}