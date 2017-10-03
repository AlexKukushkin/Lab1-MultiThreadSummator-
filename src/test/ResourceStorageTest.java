package test;

import com.company.ResourceStorage;
import com.company.Summator;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class ResourceStorageTest {

    @Test
    public void addValue() {
        String[] resources = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};
        ResourceStorage storage = new ResourceStorage();
        Summator summator = new Summator();

        assertNotNull(storage.getValue());
        assertFalse(storage.getValue() < 0);
        assertTrue(storage.getValue() % 2 == 0);

        storage.addValue(4);
        storage.getValue();
        assertEquals( 4, storage.getValue());

        storage.addValue(-2);
        storage.getValue();
        Assert.assertNotSame(2, storage.getValue());
    }
}