/*
 * parse embeded code in a webpage.
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
public class EmbedVideoParser implements IVideoParser {

    @Override
    public IVideo parse(String refer) {
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
                    if (line.toLowerCase().contains("<embed")) {
                        int vidPos = line.indexOf("VideoIDS=");
                        while (line != null && vidPos == -1) {
                            line = input.readLine();
                            vidPos = line.indexOf("VideoIDS=");
                        }
                        if (line == null) {
                            return null;
                        }
                        // assert (vidPos != -1)
                        int vidEndPos = line.indexOf("&", vidPos);
                        String videoID = line.substring(vidPos + 9, vidEndPos);
                        result = GenericVideoParser.getGenericVideoParser().parseOriginalUrl("http://v.youku.com/v_show/id_" + videoID + ".html");
                    }
                }
            }
        } catch (Exception ex) {
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
