/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.IVideo;

/**
 *
 * @author Sen
 */
public class RenrenShareVideoParser implements IVideoParser {
    
    private static YoukuVideoParser youkuParser = new YoukuVideoParser();

    @Override
    public IVideo parse(String refer) {
        if (!refer.contains("renren.com") && !refer.contains("xiaonei.com")) {
            return null;
        }
        IVideo result = null;
        BufferedReader input = null;
        try {
            URL url = new URL(refer);
            input = new BufferedReader(new InputStreamReader(url.openStream()));
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                } else {
                    if (line.contains("share-source share-from")) {
                        int urlPos = line.indexOf("href=\"");
                        while (line != null && urlPos == -1) {
                            line = input.readLine();
                            urlPos = line.indexOf("href=\"");
                        }
                        if (line == null)
                            return null;
                        // assert (vidPos != -1)
                        int urlEndPos = line.indexOf("\" ", urlPos);
                        String orig_url = line.substring(urlPos + 6, urlEndPos);
                        result = GenericVideoParser.getGenericVideoParser().parseOriginalUrl(orig_url);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(YoukuVideoParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(YoukuVideoParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }
}
