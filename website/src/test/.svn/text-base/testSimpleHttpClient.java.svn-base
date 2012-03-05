/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.IOException;
import java.util.Arrays;
import utility.SimpleHttpClient;

/**
 *
 * @author xuan
 */
public class testSimpleHttpClient {
    public static void main(String[] argv) throws IOException {
        SimpleHttpClient client = new SimpleHttpClient();
        System.out.println(Arrays.deepToString(client.head("http://www.youku.com")));
        System.out.println(client.get("http://www.youku.com"));
        System.out.println(Arrays.deepToString(client.head("http://www.baidu.com")));
        System.out.println(client.get("http://www.baidu.com"));
    }
}
