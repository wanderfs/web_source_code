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
import logic.Video;
import utility.Constant;
import utility.TelnetClient;

/**
 * Not complete yet
 * @author xiaoxiao
 */
class TudouVideoParser implements IVideoParser {

    static String programViewPrefix = "http://www.tudou.com/programs/view/";
    static String programViewPostfix = "/";
    
    static String titlePrefix = "<title>";
    static String titlePostfix = "</title>";

    static String titlePlayListExtractorPrefix = ",title:\"";
    static String titlePlayListExtractorPostfix = "\"";
    
    static String[] removePostfix = new String[] {"_土豆网", "_在线观看", "_在线视频观看", "－ 黑豆"};

    static ThreePieceExtractor programViewExtractor;
    static ThreePieceExtractor titleExtractor;

    static ThreePieceExtractor titlePlayListExtractor;
    
    TudouVideoParser() {
        programViewExtractor = new ThreePieceExtractor(
                 programViewPrefix,
                 programViewPostfix,
                 programViewPrefix.length(),
                 programViewPostfix.length());

        titleExtractor = new ThreePieceExtractor(
                 titlePrefix,
                 titlePostfix,
                 titlePrefix.length(),
                 titlePostfix.length());

        titlePlayListExtractor = new ThreePieceExtractor(
                titlePlayListExtractorPrefix,
                titlePlayListExtractorPostfix,
                titlePlayListExtractorPrefix.length(),
                titlePlayListExtractorPostfix.length());
    }
    
    @Override
    public IVideo parse(String refer) {
        if (!refer.contains("tudou.com")) {
            return null;
        }
        //http://www.tudou.com/playlist/playindex.do?lid=8070965&iid=47461057&cid=3
        //http://www.tudou.com/playlist/playindex.do?lid=8070965
        String siteSpecificid = null;
        String title = null;
        String charset = null;
        if (refer.contains("http://www.tudou.com/playlist/playindex.do")) {
            try {
                charset = "GBK";
                String iid = "iid=";
                if (refer.contains(iid)) {
                    siteSpecificid = getNextDigitString(refer, refer.indexOf(iid) + iid.length());
                    System.out.println(siteSpecificid);
                } else {
                    //http://www.tudou.com/playlist/playindex.do?lid=8070965
                    BufferedReader reader = null;
                    try {
                        URL url = new URL(refer);
                        reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
                        while (true) {
                            String line = reader.readLine();
                            if (line == null || (siteSpecificid != null && title != null)) {
                                break;
                            } else {
                                String defaultiid = "defaultIid =";
                                if (line.contains(defaultiid)) {
                                    siteSpecificid = getNextDigitString(line, line.indexOf(defaultiid) + defaultiid.length());
                                }
                                title = titleExtractor.extract(line);
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            if (reader != null) {
                                reader.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                BufferedReader reader = null;
                URL url = new URL(refer);
                reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
                int titlestatus = 0;
                try {
                    while (true) {
                        String line = reader.readLine();
                        System.out.println(line);
                        if (line == null) {
                            break;
                        } else {
                            if (line.contains("iid:" + siteSpecificid)) {
                                titlestatus = 1;
                            }
                            if (titlestatus == 1 && line.contains(",title")) {
                                title = titlePlayListExtractor.extract(line);
                                System.out.println(title);
                                break;
                            }
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        //http://www.tudou.com/programs/view/URs6TmHpbcM/
        else if (refer.contains(programViewPrefix)) {
            charset = "GBK";
            TelnetClient tc = null;
            try {
                tc = new utility.TelnetClient("www.tudou.com", 80);
                if (!refer.endsWith("/")) {
                    refer = refer.concat("/");
                }
                int startIndex = refer.indexOf(programViewPrefix);
                int endIndex = refer.indexOf(programViewPostfix, startIndex + programViewPrefix.length());
                refer = refer.substring(startIndex, endIndex + 1);
                //test.Test.println("refer: " + refer);
                String stringid = programViewExtractor.extract(refer);
                //test.Test.println("stringid: " + stringid);
                tc.sendln("HEAD /v/" + stringid + " HTTP/1.0");
                tc.sendln("HOST: www.tudou.com");
                tc.sendln("");
                while (true) {
                    String header = tc.readln();
                    if (header == null ) {
                        break;
                    }
                    String iid = "iid=";
                    if (header.startsWith("Location:") && header.contains(iid)) {
                        siteSpecificid = this.getNextDigitString(header, header.indexOf(iid) + iid.length());
                        break;
                    }
                }
            }
            catch (IOException ex) {
                Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (tc != null) {
                    tc.close();
                }
            }
        }
        //http://hd.tudou.com/program/23283/
        else if (refer.contains("http://hd.tudou.com/program/")) {
            charset = "UTF-8";
            BufferedReader reader = null;
            try {
                URL url = new URL(refer);
                reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
                while (true) {
                    String line = reader.readLine();
                    if (line == null || (siteSpecificid != null && title != null))
                        break;
                    else {
                        String iid = "iid: \"";
                        if (line.contains(iid)) {
                            siteSpecificid = getNextDigitString(line,
                                    line.indexOf(iid) + iid.length());
                        }
                        title = titleExtractor.extract(line);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // get title
        if (title == null && siteSpecificid != null) {
            BufferedReader reader = null;
            try {
                URL url = new URL(refer);
                reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
                while (true) {
                    String line = reader.readLine();
                    if (line == null || (siteSpecificid != null && title != null))
                        break;
                    else {
                        title = titleExtractor.extract(line);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(TudouVideoParser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /*preprocess title*/
        if (title != null) {
            int index = title.length();
            for (int i = 0; i != removePostfix.length; ++i ) {
                int tmp = title.indexOf(removePostfix[i]);
                if (tmp >= 0 && tmp < index) {
                    index = tmp;
                }
            }
            title = title.substring(0, index);
        }
        
        if (title != null && siteSpecificid != null) {
            if (siteSpecificid.length() < 8) {
                int difflen = 8 - siteSpecificid.length();
                String patchString = "";
                for (int i = 0; i < difflen; ++i) {
                    patchString += "0";
                }
                siteSpecificid = patchString + siteSpecificid;
            }
            IVideo v = new Video();
            v.setSiteSpecificID(siteSpecificid);
            v.setResidentSite(Constant.TUDOU_SITE);
            v.setTitle(title);
            StringBuffer sb = new StringBuffer("http://i01.img.tudou.com/data/imgs/i/");
            sb.append("0" + v.getSiteSpecificID().substring(0, 2) + "/");
            sb.append(v.getSiteSpecificID().substring(2, 5) + "/");
            sb.append(v.getSiteSpecificID().subSequence(5, 8) + "/");
            sb.append("p.jpg");
            v.setSnapshotURL(sb.toString());
            return v;
        } else {
            return null;
        }
    }

    protected String getNextDigitString(String s, int startpoint) {
        int stopIndex = startpoint;
        StringBuffer sb = new StringBuffer();
        while (stopIndex < s.length()) {
            Character c = s.charAt(stopIndex);
            if (c.equals(' ') || Character.isDigit(c)) {
                if (Character.isDigit(c))
                    sb.append(c);
                ++stopIndex;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
