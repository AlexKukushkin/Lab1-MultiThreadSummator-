package test;

import com.company.FileReader;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;


public class FileReaderTest {

    @Test
    public void readFromFile() {
        String[] resources = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};
        boolean flag = true;

        for (int i = 0; i < resources.length; i++) {
            try {
                assertNotNull(FileReader.readFromFile(resources[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (FileReader.readFromFile(resources[i]).hasNext() && flag) {
                    if(FileReader.readFromFile(resources[i]).hasNextInt()){
                        flag = true;

                    }else{
                        assertTrue(FileReader.readFromFile(resources[i]).hasNextInt());
                        flag = false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getFilePath() {
        String[] resources = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};
        for (int i = 0; i < resources.length; i++) {
            try {
                FileReader fileReader = new FileReader(resources[i]);
                assertNotNull(fileReader.getFilePath());
                assertNotNull(resources[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void checkFilePath() {
        String[] resources = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};
        assertEquals("1.txt", resources[0]);
        assertEquals("2.txt", resources[1]);
        assertEquals("3.txt", resources[2]);
        assertEquals("4.txt", resources[3]);
        assertEquals("5.txt", resources[4]);
        assertEquals("6.txt", resources[5]);
    }
}