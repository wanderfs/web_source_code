/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package offline.crawler;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import java.io.*;

import org.htmlparser.filters.*;
import org.htmlparser.*;
import org.htmlparser.nodes.*;
import org.htmlparser.tags.*;
import org.htmlparser.util.*;

import java.util.regex.*;
import java.util.ArrayList;
import offline.crawler.HotVideoCrawlInfo.type;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;

/**
 *
 * @author Administrator
 */
public class Kaixin001HotVideoCrawler implements IHotVideoCrawler {

    public ArrayList<HotVideoCrawlInfo> crawlVideos() {
        try {
            return new Kaixin001HotVideoCrawlerWorker().crawlVideos();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlNewVideos() {
        try {
            return new Kaixin001HotVideoCrawlerWorker().crawlNewVideos();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlHotVideos() {
        return new Kaixin001HotVideoCrawlerWorker().crawlHotVideos();
    }
}

class Kaixin001HotVideoCrawlerWorker {

    private HttpClient hc;
    private Cookie[] cookies;
    private ArrayList<HotVideoCrawlInfo> al;

    public ArrayList<HotVideoCrawlInfo> crawlNewVideos() {
        try {
            this.init();
            parseTODAYHOTLinkList();
        } catch (Exception e) {
        } finally {
            destroy();
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> crawlVideos() {
        try {
            this.init();
            parseTODAYHOTLinkList();
            parseHOTLinkList();
        } catch (Exception e) {
        } finally {
            destroy();
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> crawlHotVideos() {
        try {
            this.init();
            parseHOTLinkList();
        } catch (Exception e) {
        } finally {
            destroy();
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> parseTODAYHOTLinkList() {

        for (int i = 0; i < 1; ++i) {
            parseShareLink(this.getHtml("http://www.kaixin001.com/!repaste/random.php?viewtype=hotrp&start=" + String.valueOf(i * 20)), 20, type.TODAYHOT);
            try {
                //System.out.println(al.size());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kaixin001HotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> parseHOTLinkList() {

        for (int i = 0; i < 1; ++i) {
            parseShareLink(this.getHtml("http://www.kaixin001.com/!repaste/random.php?viewtype=video&start=" + String.valueOf(i * 20)), 20, type.HOT);
            try {
                //System.out.println(al.size());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kaixin001HotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return al;
    }

    public void init() throws Exception {
        al = new ArrayList<HotVideoCrawlInfo>();
        hc = new HttpClient();
        hc.getHostConfiguration().setHost("http://www.kaixin001.com", 80);
        PostMethod post = new PostMethod("http://www.kaixin001.com/login/login.php");
        NameValuePair ie = new NameValuePair("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
        NameValuePair url = new NameValuePair("url", "/home/");
        NameValuePair username = new NameValuePair("email", "voenixweijia@gmail.com");
        NameValuePair password = new NameValuePair("password", "test12");
        post.setRequestBody(new NameValuePair[]{ie, url, username, password});
        hc.executeMethod(post);
        cookies = hc.getState().getCookies();
        hc.getState().addCookies(cookies);
        post.releaseConnection();
        hc.getState().addCookies(cookies);
        post.releaseConnection();
    }

    private String getHtml(String url) {
        BufferedReader reader = null;
        GetMethod get = new GetMethod(url);
        try {

            get.setRequestHeader("Cookie", cookies.toString());
            hc.executeMethod(get);
            String responseString = "";
            reader = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream(), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                responseString = responseString + line;
            }
            //System.out.println(responseString);

            return responseString;
        } catch (IOException ex) {
            Logger.getLogger(Kaixin001HotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            get.releaseConnection();
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Kaixin001HotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    private void parseShareLink(String result, int isharepagemaxnum, type videotype) {
        try {
            Parser parser;
            NodeList nodelist;
            parser = Parser.createParser(result, "GB2312");
            NodeFilter linkFilter = new NodeClassFilter(LinkTag.class);
            nodelist = parser.parse(linkFilter);
            Node[] nodes = nodelist.toNodeArray();
            String line = "";
            String spl = "";
            String spresharepagelink = "";
            int isharepagenum = 0;
            for (int i = 0; (i < nodes.length) && (isharepagenum < isharepagemaxnum); i++) {
                Node node = nodes[i];
                if (node instanceof LinkTag) {
                    LinkTag link = (LinkTag) node;
                    if (line.equals(link.getLink())) {
                        continue;
                    }
                    line = link.getLink();
                }
                if (isTrimEmpty(line)) {
                    continue;
                }
                spl = getSharepageLink(line);
                if (!line.equals(spl) && (!spresharepagelink.equals(spl))) {
                    parseLink(getHtml(spl), videotype);
                    spresharepagelink = spl;
                    ++isharepagenum;
                }
            }
        } catch (ParserException ex) {
            Logger.getLogger(Kaixin001HotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getSharepageLink(String url) {
        Pattern pattern = Pattern.compile("^/!repaste/detail\\u002Ephp.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        String absurl = url;
        if (matcher.matches()) {
            absurl = "http://www.kaixin001.com" + url;
        }
        return absurl;
    }

    private void parseLink(String result, type videotype) {
        try {
            Parser parser;
            NodeList nodelist;
            parser = Parser.createParser(result, "GB2312");
            NodeFilter linkFilter = new NodeClassFilter(LinkTag.class);
            nodelist = parser.parse(linkFilter);
            Node[] nodes = nodelist.toNodeArray();
            String line = "";
            Pattern pattern = Pattern.compile(".*youku.*|.*tudou.*|.*p\\u002Epomoho\\u002Ecom.*|.*ku6.*|.*56\\u002Ecom.*|.*joy.*|.*xunlei.*|.*sohu.*|.*6\\u002Ecn.*|.*yinyuetai.*|.*openv.*|.*letv.*|.*163\\u002Ecom.*|.*sina.*", Pattern.CASE_INSENSITIVE);
            Matcher matcher;
            Pattern pattern2;
            Matcher matcher2;
            boolean des_flag = false;
            for (int i = 0; i < nodes.length; i++) {
                Node nparsednode = nodes[i];
                if (nparsednode instanceof LinkTag) {
                    LinkTag link = (LinkTag) nparsednode;
                    line = link.getLinkText();
                }
                if (isTrimEmpty(line)) {
                    continue;
                }
                matcher = pattern.matcher(line);
                /* if (matcher.matches()) {
                String sparsingsharecnt = result;
                sparsingsharecnt = sparsingsharecnt.split("累计转帖：</div>")[1];
                String ssharecnt = sparsingsharecnt.substring(sparsingsharecnt.indexOf(">") + 1, sparsingsharecnt.indexOf("次"));
                double dsharecnt = 0.0;
                dsharecnt = Double.parseDouble(ssharecnt);
                al.add(new HotVideoCrawlInfo(line, "kaixin001.com", dsharecnt, videotype));
                break;
                }*/
                if (matcher.matches()) {
                    parser = Parser.createParser(result, "GB2312");
                    NodeFilter DivFilter = new NodeClassFilter(Div.class);
                    NodeList Divnodelist = parser.parse(DivFilter);
                    Node[] Divnodes = Divnodelist.toNodeArray();
                    String sDivtext = "";
                    String sDivclasstext = "";
                    String s_div_style_text = "";
                    String s_description = "";
                    for (int j = 0; j < Divnodes.length; j++) {
                        s_div_style_text = "";
                        Node nodeparsednode = Divnodes[j];
                        if (nodeparsednode instanceof Div) {
                            Div nodeDiv = (Div) nodeparsednode;
                            if (nodeDiv.getAttribute("style") != null) {
                                s_div_style_text = nodeDiv.getAttribute("style");
                            }

                            if (s_div_style_text.contains("margin-top:15px;display:block") && !des_flag) {
                                des_flag = true;
                                Node[] p_description = nodeDiv.getChildrenAsNodeArray();
                                if (p_description.length <= 1) {
                                    if (nodeDiv.getStringText() != null) {
                                        s_description = nodeDiv.getStringText();
                                    }
                                }
                                for (int node_count = 1; node_count < p_description.length; ++node_count) {
                                    if (p_description[node_count] instanceof ParagraphTag) {
                                        ParagraphTag pt = (ParagraphTag) p_description[node_count];
                                        s_description += pt.getStringText();
                                    }
                                }
                            }
                            sDivtext = nodeDiv.getStringText();
                            if (nodeDiv.getAttribute("class") == null) {
                                continue;
                            }
                            sDivclasstext = nodeDiv.getAttribute("class");
                            pattern2 = Pattern.compile(".*l.*w75.*tar.*", Pattern.CASE_INSENSITIVE);
                            matcher2 = pattern2.matcher(sDivclasstext);
                            pattern = Pattern.compile(".*累计转帖.*", Pattern.CASE_INSENSITIVE);
                            matcher = pattern.matcher(sDivtext);
                            if (matcher.matches() && matcher2.matches()) {
                                nodeparsednode = Divnodes[j + 1];
                                nodeDiv = (Div) nodeparsednode;
                                sDivtext = nodeDiv.getStringText();
                                String ssharecnt = sDivtext.split("次", 2)[0];
                                double dsharecnt = 0.0;
                                dsharecnt = Double.parseDouble(ssharecnt);

                                HotVideoCrawlInfo info = new HotVideoCrawlInfo(line, "kaixin001.com", dsharecnt, videotype, s_description);
                                al.add(info);
                                System.out.println("kaixin crawler: " + info);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        } catch (ParserException ex) {
            Logger.getLogger(Kaixin001HotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 去掉左右空格后字符串是否为空
     */
    private static boolean isTrimEmpty(String astr) {
        if ((null == astr) || (astr.length() == 0)) {
            return true;
        }
        if (isBlank(astr.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 字符串是否为空:null或者长度为0.
     */
    private static boolean isBlank(String astr) {
        if ((null == astr) || (astr.length() == 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void destroy() {
        try {
            if (this.hc != null) {
                ((SimpleHttpConnectionManager) this.hc.getHttpConnectionManager()).shutdown();
            }
        } catch (Exception t) {
            t.printStackTrace();
        }
    }
}
