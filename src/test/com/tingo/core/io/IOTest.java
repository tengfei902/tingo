package tingo.core.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by user on 17/8/1.
 */
public class IOTest {

    @Test
    public void charArrayReader() {
        CharArrayReader reader = new CharArrayReader("123456787".toCharArray());
        try {
            int result= reader.read();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Test
    public void testBufferReader() {
        BufferedReader br = new BufferedReader(new StringReader("tesdgdgdffsgfdgdf"));
        try {
            String result = br.readLine();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
