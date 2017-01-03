package tingo.core.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by user on 17/1/2.
 */
public class BlockingTimeClient {
    public static void main(String[] args) {
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER");
            String resp = in.readLine();
            System.out.println("Now is :"+resp);
        } catch (IOException e) {

        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {

            }
            try {
                socket.close();
            } catch (IOException e) {

            }
        }

    }
}
