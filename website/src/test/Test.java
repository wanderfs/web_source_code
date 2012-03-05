package test;


import database.Access;
import database.StatementFactory;
import java.io.IOException;
import java.lang.*; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import logic.*;
import logic.datatype.CommentEvent;
import logic.datatype.PostEvent;
import logic.datatype.JoinChannelEvent;
import logic.datatype.SubscribeChannelEvent;
import logic.parse.GenericVideoParser;
import logic.parse.IVideoParser;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import utility.*;

public class Test {

    public static StringBuffer sb = new StringBuffer();
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
        SimpleHttpClient client = new SimpleHttpClient();
        HttpClient client2 = new DefaultHttpClient();
        System.out.println("orz  :" + client);
        System.out.println("orz2 :" + client);

        QueryTest.test();
	}

    public static String test() throws Exception {
        sb = new StringBuffer();
        //ModifyTest.test();
      //    QueryTest.test();
     //   DatabaseTest.test();
        //ParseTest.youkutest();
        //ParseTest.tudoutest();
        //ParseTest.cntvtest();
        //simpletest();
        //ModifyTest.channelTest();
        //ArtificialBehaviorTest.test();
        //searchUserTest();
        //AdTest.testAD();
        EventCommentTest.test();
        //TopTest.test();
        //CommentEventTest.test();
        //UserVisitTest.test();
        //ShareEventTest.test();
        //MyNewEventTest.test();
        //MyFeedEventTest.test();
        //UserBirthdayTest.test();
        return sb.toString();
    }

    public static void println(String s) {
        sb.append(s+"<br>");
        if (sb.length() > 1000000) {
            sb = new StringBuffer();
        }
        System.out.println("Test.println: " + s);
    }

    public static void simpletest() {
        IUser user = EntityFactory.getUser(3);
        user.setRenrenid("adfs123" + Math.random());
        user.commit();
        println("" + user);
    }

    public static void searchUserTest() {
        Test.println("====================== search a ============================");
        Test.println(Arrays.deepToString(EntityFactory.searchUser("a").toArray()));
        Test.println("====================== search 宫 ============================");
        Test.println(Arrays.deepToString(EntityFactory.searchUser("宫").toArray()));
        Test.println("====================== search small ============================");
        Test.println(Arrays.deepToString(EntityFactory.searchUser("small").toArray()));

     }
}

class AdTest {
    public static void testAD() {
        AD ad = EntityFactory.getAD("张旋的个人主页", "http://www.xuanzhang.net");
        Test.println("=================== create advertisment=========================");
        Test.println(ad.toString());
        IUser owner = EntityFactory.getUser(4);
        Pair<Integer, IChannel> pair_g1 = owner.setupChannel("testad");
        IChannel channel = pair_g1.getValue();
        Test.println("Channel: " + channel.toString());
        Test.println("=================== before add ad1 ===============================");
        Test.println(Arrays.deepToString(channel.getAds().toArray()));
        channel.addAd(ad);
        Test.println("=================== after add ad1 ================================");
        Test.println(Arrays.deepToString(channel.getAds().toArray()));
        channel.removeAd(ad);
        Test.println("=================== after remove ad1 =============================");
        Test.println(Arrays.deepToString(channel.getAds().toArray()));
        owner.deleteChannel(channel);
    }
}

class PairTest { 

  public void testPair() { 
    String key   = new String("key"); 
    String value = new String("asdf"); 

    Pair<String, String> pair = new Pair<String, String>( key, value ); 

    System.out.println( pair.getKey().equals( key ) );
    System.out.println( pair.getValue().equals( value ) );
    System.out.println( pair.equals( new Pair<String, String>(key, value)) );
  }

  public void testPairCollection() { 

    HashMap< Pair<String, String>, String> hm1 = new HashMap<Pair<String,String>, String>(); 

    Pair<String, String> p1 = new Pair<String, String>("Test1", "Value1"); 
       hm1.put(p1, "ONE");  
    Pair<String, String> p2 = new Pair<String, String>("Test1", "Value2"); 
       hm1.put(p2, "TWO");  
    Pair<String, String> p3 = new Pair<String, String>("Test2", "Value1"); 
       hm1.put(p3, "THREE");    
    Pair<String, String> p4 = new Pair<String, String>("Test2", "Value2"); 
       hm1.put(p4, "FOUR"); 
    Pair<String, String> p5 = new Pair<String, String>("Test3", "Value1"); 
       hm1.put(p5, "FIVE"); 
    Pair<String, String> p6 = new Pair<String, String>("Test3", "Value2"); 
       hm1.put(p6, "SIX");  
    Pair<String, String> p7 = new Pair<String, String>("Test3", "Value3"); 
       hm1.put(p7, "SEVEN");    

    System.out.println( hm1.size() == 7 ); 

    Pair<String, String> pSrch = new Pair<String, String>("Test3", "Value3"); 
    System.out.println( p7.equals(pSrch) );
    System.out.println( pSrch.equals(p7) );
    System.out.println( p7.hashCode() == pSrch.hashCode() ); 
    System.out.println( 0 == p7.compareTo( pSrch ) );
    System.out.println( 0 == pSrch.compareTo(p7) );

    System.out.println("starting containsKey search");
    System.out.println( hm1.containsKey( p7 ) );
    System.out.println("starting containsKey search2");
    System.out.println((p7.hashCode() == pSrch.hashCode()) + "  " + p7.equals(pSrch));
    System.out.println( hm1.containsKey( pSrch ) );
    System.out.println("finishing containsKey search");

    String result = hm1.get( pSrch );
    System.out.println( null != result );
    System.out.println( 0 == result.compareTo("SEVEN"));

  } 
}

class QueryTest {
    public static void test() {
        Test.println("=================VIDEO=====================");
        IVideo v = EntityFactory.getVideo(31); // this is senhu@iweishi.cn
        Test.println(v.toString());
        Test.println("v.getComment:");
        Test.println(Arrays.deepToString(v.getComment(10).toArray()));
        Test.println("v.getPost:");
        Test.println(Arrays.deepToString(v.getPost(1).toArray()));
        Test.println("RateUseCount: " + Integer.toString(v.getRateUserCount()));
        Test.println("v.getRate");
        Test.println(Arrays.deepToString(v.getRate(10).toArray()));
        Test.println("v.getRelatedVideo");
        Test.println(Arrays.deepToString(v.getRelatedVideo(1).toArray()));
        Test.println("v.getSubmit");
        Test.println(Arrays.deepToString(v.getSubmit(10).toArray()));
        Test.println("Submit User Count: " + Integer.toString(v.getSubmitUserCount()));
        Test.println("v.getWatch");
        Test.println(Arrays.deepToString(v.getWatch(10).toArray()));
        Test.println("");
        Test.println("=================USER=====================");
        IUser u = EntityFactory.getUser(421);
        Test.println(u.toString());
        Test.println("u.getFolloweeNewEvents");
        Test.println(Arrays.deepToString(u.GetFolloweeNewEvents(3).toArray()));
        Test.println("u.GetMyNewEvents");
        Test.println(Arrays.deepToString(u.GetMyNewEvents(3).toArray()));
        Test.println("u.getPostInfo");
        Test.println(Arrays.deepToString(u.getChannelEvents(3).toArray()));
        Test.println("u.getVideoCommented");
        Test.println(Arrays.deepToString(u.getVideoCommented(3).toArray()));
        Test.println("u.getCollect");
        Test.println(Arrays.deepToString(u.getCollectedVideo(0, 10).toArray()));
        Test.println("u.getSubmit");
        Test.println(Arrays.deepToString(u.getSubmitedVideo(0, 10).toArray()));
        Test.println("u.getWatch");
        Test.println(Arrays.deepToString(u.getWatchedVideo(0, 10).toArray()));
        u = EntityFactory.getUser(4);
        Test.println(u.getEmail());
        Test.println(u.getPassword());
        Test.println("u.GetFolloweeNewEvents");
        Test.println(Arrays.deepToString(u.GetFolloweeNewEvents(3).toArray()));
        Test.println("u.GetMyNewEvents");
        Test.println(Arrays.deepToString(u.GetMyNewEvents(3).toArray()));
        Test.println("u.getPostInfo");
        Test.println(Arrays.deepToString(u.getChannelEvents(3).toArray()));
        Test.println("u.getVideoCommented");
        Test.println(Arrays.deepToString(u.getVideoCommented(3).toArray()));
        Test.println("u.getAuthenticator");
        Test.println(u.getAuthenticator());
        Test.println("");
        Test.println("=================GROUP=====================");
        IChannel g = EntityFactory.getGroup(1);
        Test.println(g.toString());
        Test.println("u.getVideoCommented");
        Test.println(Arrays.deepToString(g.getMember(3).toArray()));
        Test.println("=================GLOBAL=====================");
        Test.println("hot videos");
        Test.println(Arrays.deepToString(Global.getHotVideo(10).toArray()));
        Test.println("new videos");
        Test.println(Arrays.deepToString(Global.getNewVideo(10).toArray()));
        Test.println("activities");
        Test.println(Arrays.deepToString(Global.getActivity(10).toArray()));
        Test.println("TopSubmitUser");
        Test.println(Arrays.deepToString(Global.getTopRecentSubmitUser(7 * 24 * 3600 * 1000, 5).toArray()));
        Test.println("TopCollectUser");
        Test.println(Arrays.deepToString(Global.getTopRecentCollectUser(7 * 24 * 3600 * 1000, 5).toArray()));
    }
}

class ModifyTest {
    public static void test() {
        IUser u = EntityFactory.getUser(4);
        Test.println("before: " + u);
        u.setName("rich");
        u.setPhoto("photo" + (int)(Math.random() * 100));
        u.setPhotoMedium("photoMedium " + (int)(Math.random() * 100));
        u.setPhotoSmall("photoSmall " + (int)(Math.random() * 100));
        u.setPhotoMini("photoMini" + (int)(Math.random() * 100));
        u.setAuthenticator("authenticator" + (int)(Math.random() * 100));
        Test.println("commit random authenticator:" + u.commit());
        u.setEmail("allsy1911@gmail.com");
        Test.println("commit duplicated email:" + u.commit());
        Test.println("after: " + EntityFactory.getUser(4));

        Pair<Integer,IVideo> pair = EntityFactory.getVideo("http://vadf.yadsfukadf.com/addfv_show/adid_XMTdfI1NzAyMjYw.html");
        u.submitVideo(pair.getValue());
        Test.println("submit error status: " +pair.getKey());

        pair = EntityFactory.getVideo("http://v.youku.com/v_show/id_XMTI1NzAyMjYw.html");
        u.submitVideo(pair.getValue());
        Test.println("submit correct status: " + pair.getKey());

        IVideo v = pair.getValue();
        if (v != null) {
            int videoid = v.getVideoid();
            Test.println(v.toString());

            u.rateVideo(videoid, 1.0);
            u.watchVideo(videoid);
            PostEvent p = new PostEvent();
            p.setGroupid(1);
            p.setUserid(u.getUserid());
            p.setVideoid(1);
            u.postToChannel(p);
            
            u.addVideoComment(videoid, "I love this video, this's cool~~", Constant.VIDEO_COMMENT_COMMON_PARENT_ID);
            Test.println("test user collect");
            u.collectVideo(videoid);
            u.collectVideo(4);
            u.collectVideo(5);
            Test.println(Arrays.deepToString(u.getCollectedVideo(0, 5).toArray()));
            u.cancelCollectVideo(4);
            Test.println(Arrays.deepToString(u.getCollectedVideo(0, 5).toArray()));
        }
        Test.println("test user follow");
        u.followByID(39);
        Test.println(Arrays.deepToString(u.getFollower().toArray()));
        u.cancelFollowByID(39);
        Test.println(Arrays.deepToString(u.getFollower().toArray()));
        Pair<Integer, IChannel> pair_g = u.setupChannel("春哥.com");
        if (pair_g.getValue() != null) {
            IChannel group = pair_g.getValue();
            Test.println(group.toString());
        }
    }

    public static void channelTest() {
        IUser owner = EntityFactory.getUser(4);
        IUser testUser1 = EntityFactory.getUser(500);
        IUser testUser2 = EntityFactory.getUser(501);
        Pair<Integer, IChannel> pair_g1 = owner.setupChannel("春哥testChannel.com");
        Pair<Integer, IChannel> pair_g2 = owner.setupChannel("cc.com");
        if (pair_g1.getValue() != null && pair_g2.getValue() != null) {
            IChannel channel1 = pair_g1.getValue();
            IChannel channel2 = pair_g2.getValue();
            channel1.setDescription("for test 1");
            channel2.setDescription("for test 2");
            channel1.commit();
            channel2.commit();
            Test.println(channel1.toString());
            Test.println(channel2.toString());
            PostEvent p = new PostEvent();

            // insert lots of videos into the two channel
            for (int i = 100; i < 200; ++i) {
                IChannel channel = null;
                if (i % 2 == 0) {
                    channel = channel1;
                } else {
                    channel = channel2;
                }
                p.setGroupid(channel.getChannelid());
                p.setUserid(owner.getUserid());
                p.setVideoid(i);
                owner.postToChannel(p);
            }

            // get some users to follow these channels
            for (int i = 500; i < 550; ++i) {
                IUser uu = EntityFactory.getUser(i);
                if (uu == null)
                    continue;
                int channelid = 0;
                if (i % 2 == 0) {
                   channelid = channel1.getChannelid();
                } else {
                   channelid = channel2.getChannelid();
                }
                uu.followChannel(channelid);
            }

            // get some users to follow these channels
            for (int i = 550; i < 600; ++i) {
                IUser uu = EntityFactory.getUser(i);
                if (uu == null)
                    continue;
                int channelid = 0;
                if (i % 2 == 0) {
                   channelid = channel1.getChannelid();
                } else {
                   channelid = channel2.getChannelid();
                }
                uu.joinChannel(channelid);
            }

            // test for user side funcitons
            Test.println("=============== owner channel ====================");
            Test.println(Arrays.deepToString(owner.getJoinedChannel(10).toArray()));
            Test.println("=============== followed channel ==================");
            Test.println(Arrays.deepToString(owner.getFollowedChannel(10).toArray()));
            Test.println(Arrays.deepToString(testUser1.getFollowedChannel(10).toArray()));
            Test.println(Arrays.deepToString(testUser2.getFollowedChannel(10).toArray()));
            // test for channel side functions
            Test.println("=============== get member  ========================");
            Test.println(Arrays.deepToString(channel1.getMember(10).toArray()));
            Test.println(Arrays.deepToString(channel2.getMember(10).toArray()));
            Test.println("=============== get subscriber =====================");
            Test.println(Arrays.deepToString(channel1.getSubscriber(10).toArray()));
            Test.println(Arrays.deepToString(channel2.getSubscriber(10).toArray()));
            Test.println("=============== get postNumber =====================");
            Test.println("channel1 post number: " + channel1.getPostNumber());
            Test.println("channel2 post number: " + channel2.getPostNumber());
            Test.println("=============== channel1 get post ===========================");
            Test.println(Arrays.deepToString(channel1.getPosts(0, 50).toArray()));
            //Test.println(Arrays.deepToString(channel2.getPosts(10).toArray()));
            for ( PostEvent e : channel1.getPosts(0, 50)) {
                owner.removePostFromChannel(e.getVideoid(), channel1);
            }
            Test.println("=============== channel1 after remove post by owner ==================");
            Test.println(Arrays.deepToString(channel1.getPosts(0, 50).toArray()));
            Test.println("=============== channel2 get post ===========================");
            Test.println(Arrays.deepToString(channel2.getPosts(0, 50).toArray()));
            //Test.println(Arrays.deepToString(channel2.getPosts(10).toArray()));
            for ( PostEvent e : channel2.getPosts(0, 50)) {
                testUser2.removePostFromChannel(e.getVideoid(), channel2);
            }
            Test.println("=============== channel2 after remove post by user2 ==================");
            Test.println(Arrays.deepToString(channel2.getPosts(0, 50).toArray()));
            owner.deleteChannel(channel1);
            owner.deleteChannel(channel2);
            Test.println("=============== after delete channel1, channel2 =============================");
            Test.println(Arrays.deepToString(owner.getJoinedChannel(10).toArray()));
        }
    }

    public static void deleteChannelTest() {
        int uid = 18;

        IUser host = EntityFactory.getUser(uid);
        Pair<Integer, IChannel> result = host.setupChannel("orz");
        List channellist = host.getJoinedChannel(30);
        Iterator<JoinChannelEvent> channelit = channellist.iterator();

        while (channelit.hasNext()) {
            Test.println(EntityFactory.getGroup(channelit.next().getGroupid()).getName());
        }

        host.deleteChannel(result.getValue());
        channellist = host.getJoinedChannel(30);
        channelit = channellist.iterator();

        while (channelit.hasNext()) {
            Test.println(EntityFactory.getGroup(channelit.next().getGroupid()).getName());
        }
    }

    void connect() throws IOException {
        TelnetClient tc = new TelnetClient("www.tudou.com", 80);
        tc.sendln("HEAD " + "/l/J68j7aazU0w" + " HTTP/1.1");
        tc.sendln("Host: www.tudou.com");
        tc.sendln("");

        TreeMap<String, String> map = new TreeMap<String, String>();
        while(true) {
            String line = tc.readln();
            if (line == null)
                break;
            String s[] = line.split(":");
            if (s.length == 2) {
                map.put(s[0], s[1]);
            }
            System.out.println(line);
        }
    }
}

class DatabaseTest {
    public static void test() throws SQLException, NamingException, Exception {
        ArrayList<Connection> cons = new ArrayList<Connection>();
      /*  for (int i = 0; i != 10; i ++) {
            Logger.getLogger("Xuan").log(Level.INFO, "connection " + i);
            Connection c = Access.getConnection();
            cons.add(c);
        }
        for (int i = 0; i != 10; i++) {
            Logger.getLogger("Xuan").log(Level.INFO, "close connection " + i);
            cons.get(i).close();
            cons.set(i, null);
        }
        cons.clear();
        */
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j != 1; ++j) {
            Access.JDBCWork(Access.getConnection());
        }
        Test.println("Success");
    }
}

class ParseTest {
    public static void youkutest() {
        Test.println("Youku Test");
        IVideo v = null;
        IVideoParser parser = GenericVideoParser.getSpecificVideoParser(Constant.YOUKU_SITE);

        ArrayList<String> urls = new ArrayList<String>();

        urls.add("http://v.youku.com/v_show/id_XMTU1NjI0Njc2.html");
        urls.add("http://v.youku.com/v_playlist/f4247027o1p0.html");
        urls.add("http://v.youku.com/v_show/id_XMTU1NjI0Njadfdc2.html");
        urls.add("http://v.youku.com/v_playlist/f124247027oadsf1p0.html");
        urls.add("httaddsfap:/df/v.youkadsfuadf.com/v_playadfist/f42sdfadsf7027o1padsf0.html");
        for (int i = 0; i != urls.size(); ++i) {
            v = parser.parse(urls.get(i));
            Test.println(urls.get(i));
            Test.println("" + v);
        }
    }

    public static void tudoutest() {
        Test.println("Tudou Test");
        IVideo v = null;
        IVideoParser parser = GenericVideoParser.getSpecificVideoParser(Constant.TUDOU_SITE);

        ArrayList<String> urls = new ArrayList<String>();

        
        urls.add("http://www.tudou.com/programs/view/CgBuranP0rs/");
        urls.add("http://www.tudou.com/programs/view/CgBuranP0rs/adfa");
        urls.add("http://www.tudou.com/playlist/playindex.do?lid=8104893");
        urls.add("http://www.tudou.com/playlist/playindex.do?lid=8104893&iid = 39125293  &cid=25");
        urls.add("http://hd.tudou.com/program/23803/");
        urls.add("http://www.tudou.com/programs/view/CgBurdfanP0rs/");
        urls.add("http://www.tudou.com/playlist/playindex.do?lid= 8112104893");
        urls.add("http://hd.tudou.com/program/238030/");
        urls.add("http://www.tudou.com/playlist/playindex.do?lid=8104893&iid= 3 9 1 2 52 93  &cid=25");

 
        //urls.add("http://www.tudou.com/programs/view/dGLGD4g05UI");
       
        for (int i = 0; i != urls.size(); ++i) {
            v = parser.parse(urls.get(i));
            Test.println(urls.get(i));
            Test.println("" + v);
        }
    }

    public static void cntvtest() {
        Test.println("CNTV test");
        IVideo v = null;
        IVideoParser parser = GenericVideoParser.getGenericVideoParser();

        ArrayList<String> urls = new ArrayList<String>();
urls.add("http://worldcup.cntv.cn/20100612/103407.shtml");
       /* urls.add("http://bugu.cntv.cn/ent/yue/xingguangdadao/classpage/video/20100314/100009.shtml");
        urls.add("http://jingji.cntv.cn/20100314/103357.shtml");
        urls.add("http://news.cntv.cn/china/20100314/102648.shtml");
        urls.add("http://sports.cntv.cn/20100311/100743.shtml");
        urls.add("http://ent.cntv.cn/enttv/kaixincidian/classpage/video/20100310/100589.shtml");
        urls.add("http://dianying.cntv.cn/other/dianyingshouying/classpage/video/20100309/100606.shtml");
        urls.add("http://dianshiju.cntv.cn/revolution/lijian/classpage/video/20100225/100001.shtml");
        urls.add("http://tansuo.cntv.cn/history/baijiajiangtan/classpage/video/20100218/100101.shtml");
        urls.add("http://tansuo.cntv.cn/history/baijiajiangtan/classpage/video/20100218/100101.shtml");
        urls.add("http://jilu.cntv.cn/people/menghuaiqingping/classpage/video/20100310/100608.shtml");
        urls.add("http://xiyou.cntv.cn/video/a535b6f2-0f13-11df-bb43-001e0bbafb46");
        urls.add("http://worldcup.cntv.cn/20100612/103407.shtml");

        urls.add("http://bugu.cntv.cn/ent/yue/xinggfdfuangdadao/claadssadfpage/viadfdeo/20100314/100009.shtml");
        urls.add("http://jingji.cntv.cn/201d0f0314/10f33f57.shtml");
        urls.add("http://news.cntv.cn/china/201011230314/102648.shtml");
        urls.add("http://sports.cntv.cn/2010df0311/100df743.shtml");
        urls.add("http://ent.cntv.cn/enttv/kaixincidian/classpage/video/201003adf10/100589.shtml");
        urls.add("http://dianying.cntv.cn/other/dianyingshouying/classpage/video/20100309/100606.shtml");
        urls.add("http://dianshiju.cntv.cn/revolution/lijian/classpage/video/20100225/100001.shtml");
        urls.add("http://tansuo.cntv.cn/history/baijiajiangtan/classpage/video/20100218/10010f1.shtml");
        urls.add("http://tansuo.cntv.cn/history/baijiajiangtan/classpage/video/20100218/10010f1.shtml");
        urls.add("http://jilu.cntv.cn/people/menghuaiqingping/classpage/video/20100310/10060df8.shtml");
        urls.add("http://xiyou.cntv.cn/video123/a535b6f2-0f13-11df-bb43-001e0bbdfafb46");
*/
        for (int i = 0; i != urls.size(); ++i) {
            v = parser.parse(urls.get(i));
            Test.println(urls.get(i));
            Test.println("" + v);
        }
    }
}

class ArtificialBehaviorTest {
    public static void test() {
        IUser u = EntityFactory.getUser(4);

        Test.println("===================== initial ====================");
        Test.println(Arrays.deepToString(u.getFollower().toArray()));
        for (int i = 0; i < 4; ++i) {
            ArtificialBehavior.smartFollowUser(u);
        }
        Test.println("===================== after smartFollow for 4 times====================");
        List<Integer> follow = u.getFollower();
        Test.println(Arrays.deepToString(follow.toArray()));
        for (Integer id : follow) {
            EntityFactory.getUser(id).cancelFollowByID(u.getUserid());
        }
        Test.println("===================== after clear ====================");
        Test.println(Arrays.deepToString(u.getFollower().toArray()));

        u = EntityFactory.getUser(29);

        Test.println("===================== initial ====================");
        Test.println(Arrays.deepToString(u.getFollower().toArray()));
        for (int i = 0; i < 4; ++i) {
            ArtificialBehavior.smartFollowUser(u);
        }
        Test.println("===================== after smartFollow for 4 times====================");
        follow = u.getFollower();
        Test.println(Arrays.deepToString(follow.toArray()));
        for (Integer id : follow) {
            EntityFactory.getUser(id).cancelFollowByID(u.getUserid());
        }
        Test.println("===================== after clear ====================");
        Test.println(Arrays.deepToString(u.getFollower().toArray()));
    }
}

class EventCommentTest {
    public static void test() {
        IUser u = EntityFactory.getUser(4);
        IUser u2 = EntityFactory.getUser("xuan.zhang1911@gmail.com");
/*
        List<IEvent> events = u.GetMyNewEvents(10);
        for (IEvent e : events) {
            Test.println("Event: " + e.toString());
            CommentEvent ec = u.leaveEventComment(e.getEventID(), "test event comment", Constant.EVENT_COMMENT_COMMON_PARENT_ID);
            u.leaveEventComment(e.getEventID(), "test event comment 2", ec.getCommentid());

            Test.println("event num: " + e.getEventCommentNum());
            Test.println("events: " + Arrays.deepToString(e.getEventComments(0, 10).toArray()));
        }*/
        Test.println("" + u.leaveUserComment(u2.getUserid(), "lalala", Constant.EVENT_COMMENT_COMMON_PARENT_ID));
        Test.println("UserComment:" + Arrays.deepToString(u2.getUserComments(10).toArray()));
    }
}

class TopTest {
    public static void test() {
        List<Pair<IUser, Integer>> topCollect = Global.getTopRecentCollectUser(10 * 365 * 24 * 3600 * 1000, 10);
        List<Pair<IUser, Integer>> topFollow = Global.getTopRecentFolloweeUser(10l * 365 * 24 * 3600 * 1000, 10);
        List<Pair<IUser, Integer>> topSubmit = Global.getTopRecentSubmitUser(10 * 365 * 24 * 3600 * 1000, 10);
        List<Pair<IChannel, Integer>> topChannel = Global.getTopRecentSubscribeChannel(-1, 10);
        for (Pair<IUser, Integer> p : topCollect) {
            //Test.println(p.getKey() + " : " + p.getValue());
        }
        Test.println("topFollow");
        for (Pair<IUser, Integer> p : topFollow) {
            Test.println(p.getKey() + " : " + p.getValue());
        }
        Test.println("topSubmit");
        for (Pair<IUser, Integer> p : topSubmit) {
            //Test.println(p.getKey() + " : " + p.getValue());
        }
        Test.println("top subscribedChannel");
        for (Pair<IChannel, Integer> p : topChannel) {
            Test.println(p.getKey() + " : " + p.getValue());
        }
    }
}

class CommentEventTest {
    public static void test() {
        IUser u = EntityFactory.getUser(4);

        u.collectVideo(1000, "lalala");
        u.rateVideo(1000, 1, "lalala");
        PostEvent event = new PostEvent();
        event.setComment("lalala");
        event.setUserid(4);
        event.setVideoid(1000);
        event.setGroupid(183);
        u.postToChannel(event);


        Test.println(Arrays.deepToString(u.GetMyNewEvents(10).toArray()));
    }
}

class UserVisitTest {
    public static void test() {
        IUser visitor = EntityFactory.getUser(1600);
        IUser host = EntityFactory.getUser(4);

        Test.println("visit count: " + host.getUserVisitNum());
        Test.println("recent visit:");
        Test.println(Arrays.deepToString(host.getRecentVisitors(10).toArray()));
        visitor.visit(host.getUserid());
        Test.println("=========================================================");
        Test.println("visit count: " + host.getUserVisitNum());
        Test.println("recent visit:");
        Test.println(Arrays.deepToString(host.getRecentVisitors(10).toArray()));
    }
}

class ShareEventTest {
    public static void test() {
        IUser u = EntityFactory.getUser(4);
        IVideo v = EntityFactory.getVideo(25319);

        Test.println("user share count: " + u.getShareNum());
        Test.println("recent share:");
        Test.println(Arrays.deepToString(u.getRecentShareEvent(10).toArray()));
        Test.println("video share count: " + v.getShareCount());
        Test.println("recent video share: ");
        Test.println("" + v.getRecentShare(10));
        //Test.println(Arrays.deepToString(v.getRecentShare(10).toArray()));
        u.shareVideo(v.getVideoid(), "haha", "faked");
        Test.println("=========================================================");
        Test.println("share count: " + u.getShareNum());
        Test.println("recent share:");
        Test.println(Arrays.deepToString(u.getRecentShareEvent(10).toArray()));
        Test.println("video share count: " + v.getShareCount());
    }
}

class MyNewEventTest {
    public static void test() {
        IUser u = EntityFactory.getUser("xuan.zhang1911@gmail.com");
        Test.println(Arrays.deepToString(u.GetMyNewEvents(20).toArray()));
    }
}

class MyFeedEventTest {
    public static void test() {
        IUser u = EntityFactory.getUser("xuan.zhang1911@gmail.com");
        Test.println(Arrays.deepToString(u.GetFolloweeNewEvents(20).toArray()));
    }
}

class UserBirthdayTest {
    public static void test() throws ParseException {
        IUser u = EntityFactory.getUser(4);

        Test.println(u.toString());
        Test.println(u.getConstellation().getChineseName());
        u.setLocation("北京");
        u.setBirthday(java.sql.Date.valueOf("1987-05-23"));
        u.setGender("M");
        Test.println(u.toString());
        Test.println(u.getConstellation().getChineseName());
    }
}