/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.IOException;
import net.sf.json.JSONObject;
import utility.SimpleHttpClient;

/**
 *
 * @author xuan
 */
public class testJson {
    public static void main(String[] args) throws IOException {
        SimpleHttpClient client = new SimpleHttpClient();
        String jsonstring = client.get("http://summer.cs.yale.edu/cnvideoapi/parse.php?url=http://v.youku.com/v_show/id_XMjMwODA2MDAw.html");
        System.out.println("|" + jsonstring);
        System.out.println("|" + jsonstring.trim());
        System.out.println("|" + (int)jsonstring.charAt(0));
        System.out.println("|" + (int)jsonstring.charAt(1));
        System.out.println("|a");

        JSONObject json = JSONObject.fromObject(jsonstring); 
    }
}
