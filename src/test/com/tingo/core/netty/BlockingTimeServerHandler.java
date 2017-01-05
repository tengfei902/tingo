package tingo.core.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by tengfei on 17/1/2.
 */
public class BlockingTimeServerHandler implements Runnable {

    private Socket socket;

    public BlockingTimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;

            while (true) {
                body = in.readLine();
                if(body == null) {
                    break;
                }
                System.out.println("The time server received order:"+body);
            }
        } catch (IOException e) {
            try {
                in.close();
            } catch (IOException e1) {

            }

            out.close();

            try {
                socket.close();
            } catch (IOException e2) {


            }
        }

    }
}
