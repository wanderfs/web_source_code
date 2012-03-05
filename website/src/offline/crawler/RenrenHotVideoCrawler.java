/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package offline.crawler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.Cookie.*;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


import org.htmlparser.filters.*;
import org.htmlparser.*;
import org.htmlparser.nodes.*;
import org.htmlparser.tags.*;
import org.htmlparser.util.*;

import offline.crawler.HotVideoCrawlInfo.type;

import java.util.regex.*;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;

/**
 *
 * @author xiaoxiao
 */
public class RenrenHotVideoCrawler implements IHotVideoCrawler {

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlVideos() {
        try {
            return new RenrenHotVideoCrawlerWorker().crawlVideos();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlNewVideos() {
        try {
            return new RenrenHotVideoCrawlerWorker().crawlNewVideos();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlHotVideos() {
        try {
            return new RenrenHotVideoCrawlerWorker().crawlHotVideos();
        } catch (Exception e) {
            return null;
        }
    }
}

class RenrenHotVideoCrawlerWorker {

    private HttpClient hc;
    private PostMethod pm;
    private int status;
    private ArrayList<HotVideoCrawlInfo> al;

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

    public ArrayList<HotVideoCrawlInfo> crawlNewVideos() {
        try {
            this.init();
        } catch (Exception e) {
        } finally {
            destroy();
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> crawlHotVideos() {
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

    //6 videos
    public ArrayList<HotVideoCrawlInfo> parseTODAYHOTLinkList() {
        this.getHtml("http://guide.renren.com/guide");
        parseShareLink(this.getHtml("http://share.renren.com/share/hot?__view=async-html-reload"), 6, type.TODAYHOT);
        return al;
    }

    //200 videos
    public ArrayList<HotVideoCrawlInfo> parseHOTLinkList() {
        this.getHtml("http://guide.renren.com/guide");
        for (int i = 0; i < 10; ++i) {
            parseShareLink(this.getHtml("http://share.renren.com/share/hotlist?curpage=" + String.valueOf(i) + "&t=10&__view=async-html"), 20, type.HOT);
        }

        return al;
    }

    private boolean getSharepageLink(String url) {
        Pattern pattern = Pattern.compile("^http://share\\u002Erenren\\u002Ecom/share/GetShare\\u002Edo\\u003Fid=.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public void init() throws Exception {
        al = new ArrayList<HotVideoCrawlInfo>();
        hc = new HttpClient();
        hc.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        hc.getHostConfiguration().setHost("http://www.renren.com", 80, "http");
// post 提交
        pm = new PostMethod("http://renren.com/PLogin.do");
// 参数
        NameValuePair email = new NameValuePair("email", "voenixweijia@gmail.com");
        NameValuePair password = new NameValuePair("password", "test12");
        NameValuePair[] params = new NameValuePair[]{email, password};
        pm.setRequestHeader("User-Agent", "Firefox Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.3) Gecko/20090824 Firefox/3.5.3");
        pm.setRequestBody(params);
        status = hc.executeMethod(pm);
        pm.releaseConnection();
    }

    private String getHtml(String url) {
        String htmlstring = "";
//返回值 301 302  跳转页
        if (status == HttpStatus.SC_MOVED_PERMANENTLY
                || status == HttpStatus.SC_MOVED_TEMPORARILY) {
            Header locationHeader = pm.getResponseHeader("location");
            if (locationHeader != null) {
                GetMethod g = new GetMethod(url);
                try {
                    hc.executeMethod(g);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(g.getResponseBodyAsStream(), "UTF-8"));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        // System.out.println(line);
                        htmlstring = htmlstring + line;
                    }
                    htmlstring = htmlstring.replaceAll("ahref", "a href");

                } catch (IOException ex) {
                    Logger.getLogger(RenrenHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    g.releaseConnection();
                }
            }
        }
        return htmlstring;
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
                spl = line;
                if (getSharepageLink(spl) && (!spresharepagelink.equals(spl))) {
                    parseLink(getHtml(spl), videotype);
                    spresharepagelink = spl;
                    ++isharepagenum;
                }
            }
        } catch (ParserException ex) {
            Logger.getLogger(RenrenHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void parseLink(String result, type videotype) {
        try {
            Parser parser;
            NodeList nodelist;
            parser = Parser.createParser(result, "GB2312");
            // NodeFilter linkFilter = new NodeClassFilter(LinkTag.class);
            // nodelist = parser.parse(linkFilter);
            NodeFilter textFilter = new NodeClassFilter(LinkTag.class);
            nodelist = parser.parse(textFilter);
            Node[] nodes = nodelist.toNodeArray();
            String line = "";
            Pattern pattern = Pattern.compile(".*youku.*|.*tudou.*|.*ku6.*|.*56\\u002Ecom.*|.*joy.*|.*xunlei.*|.*sohu.*|.*6\\u002Ecn.*|.*yinyuetai.*|.*openv.*|.*letv.*|.*163\\u002Ecom.*|.*sina.*", Pattern.CASE_INSENSITIVE);
            Matcher matcher;
            NodeFilter headFilter = new NodeClassFilter(HeadingTag.class);
            Parser ht_parser = Parser.createParser(result, "GB2312");
            NodeList ht_nl = ht_parser.parse(headFilter);
            Node[] ht_nodes = ht_nl.toNodeArray();
            String s_des = "";
            for (int i = 0; i < ht_nodes.length; i++) {
                if (ht_nodes[i] instanceof HeadingTag) {
                    HeadingTag ht_node = (HeadingTag) ht_nodes[i];
                    if (ht_node.getAttribute("class") != null) {
                        if (ht_node.getAttribute("class").contains("video-title")) {
                            s_des = ht_node.getStringText();
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < nodes.length; i++) {
                Node nparsednode = nodes[i];
                /*if (nparsednode instanceof LinkTag) {
                LinkTag link = (LinkTag) nparsednode;
                line = link.getLink();
                }*/
                if (nparsednode instanceof LinkTag) {
                    LinkTag lt = (LinkTag) nparsednode;
                    line = lt.getStringText();
                }
                if (isTrimEmpty(line)) {
                    continue;
                }
                matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    //al.add(new HotVideoCrawlInfo(line, "renren.com", 0, videotype));
                    parser = Parser.createParser(result, "GB2312");
                    NodeFilter spanFilter = new NodeClassFilter(Span.class);
                    NodeList spannodelist = parser.parse(spanFilter);
                    Node[] spannodes = spannodelist.toNodeArray();
                    String sspantext = "";
                    for (int j = 0; j < spannodes.length; j++) {
                        Node nodeparsednode = spannodes[j];
                        if (nodeparsednode instanceof Span) {
                            Span nodespan = (Span) nodeparsednode;
                            sspantext = nodespan.getStringText();
                            pattern = Pattern.compile(".*分享.*<strong>.*", Pattern.CASE_INSENSITIVE);
                            matcher = pattern.matcher(sspantext);
                            if (matcher.matches()) {
                                parser = Parser.createParser(sspantext, "GB2312");
                                NodeFilter strongFilter = new NodeClassFilter(TextNode.class);
                                NodeList nlparsed = parser.parse(strongFilter);
                                Node[] naparsednodes = nlparsed.toNodeArray();
                                String ssharecnt = "";
                                for (int k = 0; k < naparsednodes.length; k++) {
                                    Node nodeparsednode2 = naparsednodes[k];
                                    if (nodeparsednode2 instanceof TextNode) {
                                        ssharecnt = nodeparsednode2.getText();
                                        double dsharecnt = 0.0;
                                        try {
                                            dsharecnt = Double.parseDouble(ssharecnt);
                                        } catch (NumberFormatException nfx) {
                                            continue;
                                        }
                                        HotVideoCrawlInfo info = new HotVideoCrawlInfo(line, "renren.com", dsharecnt, videotype, s_des);
                                        al.add(info);
                                        System.out.println("renren crawler :" + info);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        } catch (ParserException ex) {
            Logger.getLogger(RenrenHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
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
