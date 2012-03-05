/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package offline.crawler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.*;

import org.htmlparser.filters.*;
import org.htmlparser.*;
import org.htmlparser.nodes.*;
import org.htmlparser.tags.*;
import org.htmlparser.util.*;

import java.util.regex.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import offline.crawler.HotVideoCrawlInfo.type;

/**
 *
 * @author Administrator
 */
public class QzoneHotVideoCrawler implements IHotVideoCrawler {

    public ArrayList<HotVideoCrawlInfo> crawlVideos() {
        try {
            return new QzoneHotVideoCrawlerWorker().crawlVideos();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlNewVideos() {
        try {
            return new QzoneHotVideoCrawlerWorker().crawlNewVideos();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlHotVideos() {
        try {
            return new QzoneHotVideoCrawlerWorker().crawlHotVideos();

        } catch (Exception e) {
            return null;
        }

    }
}

class QzoneHotVideoCrawlerWorker {

    public static final String QQNUM = "1494414569";      //QQ行号码
    public static final String PASSWORD = "test12";   //密码
    private DefaultHttpClient httpclient = new DefaultHttpClient();
    private boolean loginFlag = false;
    private List<Cookie> cookies;
    private HttpResponse response;
    private HttpEntity entity;
    private HttpGet request;
    private String verifyString;
    private String verifySession;
    private ArrayList<HotVideoCrawlInfo> al = new ArrayList<HotVideoCrawlInfo>();

    public ArrayList<HotVideoCrawlInfo> crawlVideos() {
        try {
            init();
            parseNEWLinkList();
            parseTODAYHOTLinkList();
            parseWEEKHOTLinkList();
            parseMONTHHOTLinkList();
        } catch (Exception e) {
        } finally {
            destroy();
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> crawlNewVideos() {
        try {
            init();
            parseNEWLinkList();
        } catch (Exception e) {
        } finally {
            destroy();
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> crawlHotVideos() {
        try {
            init();
            parseTODAYHOTLinkList();
            //parseWEEKHOTLinkList();
            //parseMONTHHOTLinkList();
        } catch (Exception e) {
        } finally {
            destroy();
        }
        return al;
    }

    public ArrayList<HotVideoCrawlInfo> parseMONTHHOTLinkList() {
        for (int i = 1; i < 21; ++i) {
            parseLink(this.getHtml("http://live.qq.com/json/qzvideo/hotshare_timeorder/hotshare_2_" + String.valueOf(i) + ".json"), type.MONTHHOT);
        }
        // parseLink(this.getHtml("http://live.qq.com/json/qzvideo/hotshare/hotshare_0_20.json?_=355190"), type.TODAYHOT);

        return al;
    }

    public ArrayList<HotVideoCrawlInfo> parseWEEKHOTLinkList() {


        for (int i = 1; i < 21; ++i) {
            parseLink(this.getHtml("http://live.qq.com/json/qzvideo/hotshare_timeorder/hotshare_1_" + String.valueOf(i) + ".json"), type.WEEKHOT);
        }
        // parseLink(this.getHtml("http://live.qq.com/json/qzvideo/hotshare/hotshare_0_20.json?_=355190"), type.TODAYHOT);

        return al;
    }

    //200 videos
    public ArrayList<HotVideoCrawlInfo> parseTODAYHOTLinkList() {
        for (int i = 1; i < 21; ++i) {
            parseLink(this.getHtml("http://live.qq.com/json/qzvideo/hotshare_timeorder/hotshare_0_" + String.valueOf(i) + ".json"), type.TODAYHOT);
        }
        // parseLink(this.getHtml("http://live.qq.com/json/qzvideo/hotshare/hotshare_0_20.json?_=355190"), type.TODAYHOT);

        return al;
    }

    //100 videos
    public ArrayList<HotVideoCrawlInfo> parseNEWLinkList() {


        for (int i = 1; i < 11; ++i) {
            parseLink(this.getHtml("http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshareget_recentlist?spaceuin=1494414569&page=" + String.valueOf(i)), type.NEW);
        }
        return al;
    }

    public void init() throws Exception {
        if (!loginFlag) {
            String vchtml = getHtml("http://ptlogin2.qq.com/check?uin=1494414569&appid=15000101&r=0.17154387252919046");
                                
            verifyString = parseVC(vchtml);

            HttpPost httpost = new HttpPost("http://ptlogin2.qq.com/login");

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("u", QQNUM));
            nvps.add(new BasicNameValuePair("p", md5(md5_3(PASSWORD) + verifyString.toUpperCase())));

            nvps.add(new BasicNameValuePair("verifycode", verifyString));
            nvps.add(new BasicNameValuePair("aid", "8000108"));
            nvps.add(new BasicNameValuePair("u1", "http://imgcache.qq.com/qzone/v5/loginsucc.html"));
            nvps.add(new BasicNameValuePair("fp", "loginerroralert"));
            nvps.add(new BasicNameValuePair("h", "1"));
            nvps.add(new BasicNameValuePair("ptredirect", "0"));
            nvps.add(new BasicNameValuePair("ptlang", "0"));
            nvps.add(new BasicNameValuePair("from_ui", "1"));
            nvps.add(new BasicNameValuePair("dumy", "1"));


            httpost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727)");
            // httpost.setHeader("Cookie", "verifysession=" + verifySession + ";");
            httpost.setHeader("Referer", "http://ui.ptlogin2.qq.com/cgi-bin/login?link_target=blank&target=self&appid=8000108&qlogin_jumpname=vipmyqq&f_url=loginerroralert&qlogin_auto_login=1&s_url=http%3A//imgcache.qq.com/qzone/v5/loginsucc.html&qlogin_param=jump_url%3D");
            httpost.setHeader("Accept", "text/html, */*");
            httpost.removeHeaders("Cookie2");
            httpost.removeHeaders("Expect");
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            response = httpclient.execute(httpost);

            cookies = httpclient.getCookieStore().getCookies();
            if (cookies.size() < 3) {
                System.err.println("登录失败...");
                loginFlag = false;
            } else {
                System.out.println("登录成功...");
                /*for (Cookie c : cookies) {
                System.out.println(c);
                }*/
                entity = response.getEntity();
                if (entity != null) {
                    entity.consumeContent();
                }
            }
        }
    }

    public String getHtml(String url) {
        BufferedReader reader = null;
        try {
            String htmlstring = "";
            request = new HttpGet(url);
            response = httpclient.execute(request);
            entity = response.getEntity();
            //System.out.println("----------------------------------------");
            //System.out.println(response.getStatusLine());
            /*if (entity != null) {
            System.out.println("Response content length: " + entity.getContentLength());
            }*/
            reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                htmlstring = htmlstring + line;
            }
            return htmlstring;
        } catch (IOException ex) {
            Logger.getLogger(QzoneHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(QzoneHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (IOException ex) {
                    Logger.getLogger(QzoneHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(QzoneHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    public void parseLink(String result, type videoType) {

        Pattern pattern;
        Matcher matcher;
        double[] dascore = new double[11];
        String[] salink = new String[11];
        int arraynum = 0;

        if (videoType == type.NEW) {
            try {
                Parser pparser = Parser.createParser(result, "GB2312");
                NodeList pnodelist;
                String ssharecnt = "";
                NodeFilter pFilter = new NodeClassFilter(ParagraphTag.class);
                pnodelist = pparser.parse(pFilter);
                Node[] pnodes = pnodelist.toNodeArray();
                String strlink = "";
                for (int i = 0; i < pnodes.length; i++) {
                    Node node = pnodes[i];
                    if (node instanceof ParagraphTag) {
                        ParagraphTag pNode = (ParagraphTag) node;
                        ssharecnt = pNode.getStringText();
                        pattern = Pattern.compile(".*已被分享.*", Pattern.CASE_INSENSITIVE);
                        matcher = pattern.matcher(ssharecnt);
                        if (matcher.matches()) {
                            Parser linkparser = Parser.createParser(ssharecnt, "GB2312");
                            NodeFilter linkFilter = new NodeClassFilter(LinkTag.class);
                            NodeList linknodelist = linkparser.parse(linkFilter);
                            Node[] linknodes = linknodelist.toNodeArray();
                            for (int j = 0; j < linknodes.length; j++) {
                                Node linknode = linknodes[j];
                                if (linknode instanceof LinkTag) {
                                    LinkTag link = (LinkTag) linknode;
                                    strlink = link.getLinkText();
                                }
                                if (isTrimEmpty(strlink)) {
                                    continue;
                                }
                                pattern = Pattern.compile(".*youku.*|.*tudou.*|.*ku6.*|.*56\\u002Ecom.*|.*joy.*|.*xunlei.*|.*sohu.*|.*6\\u002Ecn.*|.*yinyuetai.*|.*openv.*|.*letv.*|.*163\\u002Ecom.*|.*sina.*", Pattern.CASE_INSENSITIVE);
                                matcher = pattern.matcher(strlink);
                                if (matcher.matches()) {
                                    ssharecnt = ssharecnt.split("享")[1];
                                    ssharecnt = ssharecnt.split("次")[0];
                                    salink[arraynum] = strlink;
                                    dascore[arraynum] = Double.parseDouble(ssharecnt);
                                    ++arraynum;
                                }
                            }
                        }
                    }
                    if (isTrimEmpty(ssharecnt)) {
                        continue;
                    }
                }
            } catch (ParserException ex) {
                Logger.getLogger(QzoneHotVideoCrawlerWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < arraynum; ++i) {
                HotVideoCrawlInfo info = new HotVideoCrawlInfo(salink[i], "qzone.qq.com", dascore[i], videoType, "");
                System.out.println("qqzone  crawler: " + info);
                al.add(info);
            }
        } else {

            JSONArray array = null;
            try {
                String js = result.substring(result.indexOf("(") + 1, result.lastIndexOf(")"));
                JSONObject jo = JSONObject.fromObject(js);
                array = jo.getJSONArray("items");
            } catch (JSONException je) {
                je.printStackTrace();
            }


            String ssplit = result;
            String ssharecnt = "";

            for (arraynum = 0; arraynum < 10; ++arraynum) {
                pattern = Pattern.compile(".*sharecnt.*", Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(ssplit);
                if (!matcher.matches()) {
                    break;
                }
                ssharecnt = "";
                ssplit = ssplit.split("sharecnt", 2)[1];
                pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
                int inumindex = 0;
                String snum = ssplit.substring(inumindex, inumindex + 1);
                matcher = pattern.matcher(snum);
                while (!matcher.matches()) {

                    snum = ssplit.substring(inumindex, inumindex + 1);
                    matcher = pattern.matcher(snum);
                    ++inumindex;

                }
                while (matcher.matches()) {
                    ssharecnt += snum;
                    snum = ssplit.substring(inumindex, inumindex + 1);
                    matcher = pattern.matcher(snum);
                    ++inumindex;
                }
                dascore[arraynum] = Double.parseDouble(ssharecnt);

                ssplit = ssplit.split("videourl", 2)[1];
                salink[arraynum] = ssplit.split("\"", 4)[2];
            }
            for (int i = 0; i < arraynum; ++i) {
                HotVideoCrawlInfo info = new HotVideoCrawlInfo(salink[i], "qzone.qq.com", dascore[i], videoType, array.getJSONObject(i).getString("memo"));
                System.out.println("qqzone  crawler: " + info);
                al.add(info);
            }
        }
    }

    /**
     * 去掉左右空格后字符串是否为空
     */
    public static boolean isTrimEmpty(String astr) {
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
    public static boolean isBlank(String astr) {
        if ((null == astr) || (astr.length() == 0)) {
            return true;
        } else {
            return false;
        }
    }
    private final static char[] hexDigits = {'0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        int t;
        for (int i = 0; i < 16; i++) {
            t = bytes[i];
            if (t < 0) {
                t += 256;
            }
            sb.append(hexDigits[(t >>> 4)]);
            sb.append(hexDigits[(t % 16)]);
        }
        return sb.toString();
    }

    public static String md5(String input) throws Exception {
        return code(input, 32);
    }

    public static String code(String input, int bit) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance(System.getProperty(
                    "MD5.algorithm", "MD5"));
            if (bit == 16) {
                return bytesToHex(md.digest(input.getBytes("utf-8"))).substring(8, 24);
            }
            return bytesToHex(md.digest(input.getBytes("utf-8")));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new Exception("Could not found MD5 algorithm.", e);
        }
    }

    public static String md5_3(String b) throws Exception {
        MessageDigest md = MessageDigest.getInstance(System.getProperty(
                "MD5.algorithm", "MD5"));
        byte[] a = md.digest(b.getBytes());
        a = md.digest(a);
        a = md.digest(a);

        return bytesToHex(a);
    }

    public String parseVC(String result) throws Exception {
        int starpos = result.indexOf("!");
        String strvc = result.substring(starpos, starpos + 4);
        // ptui_checkVC('1','c4cde1a7c6b65b45102380dafc8351bbf51f42aedecb4848');
        //int starpos = result.indexOf(",");
        //String strvc = result.substring(starpos+2, result.length()-3);
        //System.out.println(strvc);
        return strvc;

    }

    public void destroy() {
        try {
            if (this.httpclient != null) {
                this.httpclient.getConnectionManager().shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
