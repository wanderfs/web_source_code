/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author xuan
 */
public class SimpleHttpClient {
    public String get(String url) {


        SimpleHttpConnectionManager mgr = new SimpleHttpConnectionManager(true);
        HttpClient client = new HttpClient(mgr);

        // Create a method instance.
        GetMethod method = new GetMethod(url);

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            String responseBodyString;
            if (method.getResponseCharSet() != "ISO-8859-1") {
                responseBodyString = new String(responseBody, method.getResponseCharSet());
            } else {
                String testString = new String(responseBody, method.getResponseCharSet());
                String charsetPre = "<meta http-equiv=\"Content-Type\" content=\"text/html;";
                int index = testString.indexOf(charsetPre);
                if (index > 0) {
                    index += charsetPre.length();
                    String charsetsign = "charset=";
                    int indexbegin = testString.indexOf(charsetsign);
                    indexbegin += charsetsign.length();
                    int indexend = testString.indexOf("\"", indexbegin);
                    String charset = testString.substring(indexbegin, indexend);
                    System.out.println(charset);
                    responseBodyString = new String(responseBody, charset);
                } else {
                    responseBodyString = new String(responseBody, "utf-8");
                }
            }
            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            return responseBodyString;
            //return EntityUtils.toString(response.getEntity(), "ascii");
        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
            mgr.shutdown();
        }
        return null;
    }

    public Header[] head(String url) {
        SimpleHttpConnectionManager mgr = new SimpleHttpConnectionManager(true);
        HttpClient client = new HttpClient(mgr);

        // Create a method instance.
        GetMethod method = new GetMethod(url);

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }
            return method.getResponseHeaders();
            //return EntityUtils.toString(response.getEntity(), "ascii");
        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
            mgr.shutdown();
        }
        return null;
    }
}
