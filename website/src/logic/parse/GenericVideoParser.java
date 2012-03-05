/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.parse;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.IVideo;

/**
 * Currently, we can support Youku, tudou, ku6, 6.cn, 56.com and sina.com.
 * and we have INDIRECT support for embeded youku player and Renren shared video.
 * @author xiaoxiao
 */
public class GenericVideoParser implements IVideoParser {

    ArrayList<IVideoParser> availableParsers;
    ArrayList<IVideoParser> indirectParsers;

    static GenericVideoParser parser;

    public static GenericVideoParser getGenericVideoParser() {
        if (parser == null) {
            parser = new GenericVideoParser();
            parser.availableParsers.add(new PHPVideoParser());
            parser.availableParsers.add(new YoukuVideoParser());
            parser.availableParsers.add(new TudouVideoParser());
            parser.availableParsers.add(new CNTVVideoParser());

            parser.indirectParsers.add(new EmbedVideoParser());
            parser.indirectParsers.add(new RenrenShareVideoParser());
        }
        return parser;
    }

    // test only
    public static IVideoParser getSpecificVideoParser(String residentSite) {
        if (residentSite.toLowerCase().contains("youku"))
            return new YoukuVideoParser();
        else if (residentSite.toLowerCase().contains("tudou"))
            return new TudouVideoParser();
        return null;
    }
    
    protected GenericVideoParser() {
        availableParsers = new ArrayList<IVideoParser>();
        indirectParsers = new ArrayList<IVideoParser>();
    }

    @Override
    public IVideo parse(String refer) {
        Iterator<IVideoParser> it = this.availableParsers.iterator();
        while (it.hasNext()) {
            try {
                IVideo v = it.next().parse(refer);
                if (v != null) {
                    return v;
                }
            } catch (Throwable t) {
                System.out.println("GenericParser Exception " + t);
            }
        }

        it = this.indirectParsers.iterator();
        while (it.hasNext()) {
            try {
                IVideo v = it.next().parse(refer);
                if (v != null) {
                    return v;
                }
            } catch (Throwable t) {
                System.out.println("GenericParser Exception " + t);
            }
        }
        // log error
        Logger.getLogger("ParseUrlError").log(Level.INFO, "ParseUrlError|" + refer);

        return null;
    }

    public IVideo parseOriginalUrl(String refer) {
        Iterator<IVideoParser> it = this.availableParsers.iterator();
        while (it.hasNext()) {
            IVideo v = it.next().parse(refer);
            if (v != null) {
                return v;
            }
        }

        return null;
    }
}
