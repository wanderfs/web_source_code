/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuan
 */
public class TelnetClient {

    Socket sock;
    DataOutputStream out;
    BufferedReader in;
    
    public TelnetClient(String host, int port) throws IOException {
        sock = new Socket(host, port);
        out = new DataOutputStream(sock.getOutputStream());
        in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void sendln(String str) throws IOException {
        out.writeBytes(str + "\r\n");
    }

    public String readln() throws IOException {
        return in.readLine();
    }

    public void close() {
        try {
            if (sock != null) {
                sock.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TelnetClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (sock != null) {
                out.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TelnetClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (sock != null) {
                in.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TelnetClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
