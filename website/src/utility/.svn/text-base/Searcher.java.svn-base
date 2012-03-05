package utility;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import logic.EntityFactory;
import logic.IUser;
import logic.IVideo;

public class Searcher {

    //	sources
    private static final String SOUKU_ViDEO_ENGINE = "http://www.soku.com/v?keyword=";

    public ArrayList<IVideo> iweishiSearch(String keyword) {
        ArrayList<IVideo> result = new ArrayList<IVideo>();
        System.out.println(keyword);
        ArrayList<String> videos = searchByKeyword(keyword);
        int count = 0;
        for (int i = 0; i < videos.size() && count != 5; ++i) {
            int id = Constant.ARTIFICIAL_USER_ID_MIN + (int) ((Constant.ARTIFICIAL_USER_ID_MAX - Constant.ARTIFICIAL_USER_ID_MIN) * Math.random());
            IUser user = EntityFactory.getUser(id);
            Pair<Integer, IVideo> presult = EntityFactory.getVideo(videos.get(i));
            if (presult.getKey() == Constant.SUBMIT_SUCCESS) {
                presult.getValue().setSummary("");
                presult.getValue().setTime(new Date());
                if (presult.getValue().getTitle() != null && presult.getValue().getSnapshotURL() != null) {
                    if (user.submitVideo(presult.getValue()) == Constant.SUBMIT_SUCCESS) {
                        presult.getValue().setFirstSubmitUserid(id);
                        result.add(presult.getValue());
                        ++count;
                    }
                }
            } else {
                if (presult.getKey() == Constant.SUBMIT_BEFORE) {
                    result.add(presult.getValue());
                    ++count;
                }
            }
        }
        return result;
    }

    public ArrayList<String> searchByKeyword(String keyword) {
        return extractLinks(SOUKU_ViDEO_ENGINE, keyword);
    }

    private ArrayList<String> extractLinks(String url, final String keyword) {
        final ArrayList<String> links = new ArrayList<String>();
        try {
            Parser parser = new Parser(url + keyword);
            parser.setEncoding(parser.getEncoding());
            NodeVisitor visitor = new NodeVisitor() {

                public void visitTag(Tag tag) {
                    if (tag instanceof LinkTag) {
                        LinkTag linkTag = (LinkTag) tag;
                        if (linkTag.getText().contains(keyword)) {
                            //System.out.println(linkTag.getLink());
                            String s = linkTag.getLink();
                            if (!links.contains(s)) {
                                links.add(s);
                            }
                        }
                    }
                }
            };
            parser.visitAllNodesWith(visitor);
        } catch (ParserException e) {
            e.printStackTrace();
        }
        return links;
    }

    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        String keyword = "日本";
        System.out.println(keyword);
        ArrayList<String> urls = searcher.searchByKeyword(keyword);
        for (String url : urls) {
            System.out.println("result: " + url);
        }
        /*
        ArrayList<IVideo> vurls = searcher.iweishiSearch("yale");
        Iterator<IVideo> it = vurls.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getTitle());
        }
         */
    }
}
