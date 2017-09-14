package tingo.core.net;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by user on 17/8/2.
 */
public class URLTest {

    @Test
    public void testUrl() throws MalformedURLException,IOException {
        URL url = new URL("http://192.168.1.52:8080/monitor/screen.html");
        System.out.println(url.getHost());
        System.out.println(url.getAuthority());
        System.out.println(url.getFile());
        System.out.println(url.getDefaultPort());

        URLConnection urlConnection = url.openConnection();

    }
}
