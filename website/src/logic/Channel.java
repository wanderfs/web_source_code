package logic;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import database.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.datatype.*;
import test.Test;

public class Channel implements IChannel {

    public static String CHANNEL_ID = "groupid"; // the underline database is using groupid
    int channelid;
    String name;
    String description = "";
    Date time;
    int administratorid = -1;

    @Override
    public int getChannelid() {
        return channelid;
    }

    @Override
    public void setChannelid(int groupid) {
        this.channelid = groupid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int getAdministratorid() {
        return administratorid;
    }

    @Override
    public void setAdministratorid(int administratorid) {
        this.administratorid = administratorid;
    }

    @Override
    public List<JoinChannelEvent> getMember(int topnum) {
        return StatementFactory.getQuery().getUserChannelMemberRelation(CHANNEL_ID, this.channelid, topnum);
    }

    @Override
    public List<SubscribeChannelEvent> getSubscriber(int topnum) {
        return StatementFactory.getQuery().getUserChannelSubscriberRelation(CHANNEL_ID, this.channelid, topnum);
    }

    @Override
    public List<PostEvent> getPosts(int from, int topnum) {
        List<PostEvent> results = StatementFactory.getQuery().getPost(CHANNEL_ID, this.channelid, from + topnum);
        if (results.size() > topnum) {
            results = results.subList(results.size() - topnum, results.size());
        }
        return results;
    }

    @Override
    public int getPostNumber() {
        // todo
        return database.StatementFactory.getQuery().getPostCount("groupid", channelid);
    }

    @Override
    public void commit() {
        StatementFactory.getModify().updateGroup(Channel.CHANNEL_ID, this.channelid, this);
    }

    @Override
    public String toString() {
        return "Channel: " + "Channelid = " + channelid
                + "; name = " + name + "; time = " + time
                + "; description = " + description
                + "; administratorid = " + administratorid;
    }

    @Override
    public void addAd(AD ad) {
        database.StatementFactory.getModify().insertChannelADRelation(this.channelid, ad.getAdid());
    }

    @Override
    public void removeAd(AD ad) {
        database.StatementFactory.getModify().removeChannelADRelation(this.channelid, ad.getAdid());
    }
    
    @Override
    public List<AD> getAds() {
        List<ChannelADRelation> relations = database.StatementFactory.getQuery().getChannelADRelation("groupid", this.channelid, 1000);
        List<AD> result = new ArrayList<AD>();
        for (ChannelADRelation re : relations) {
            List<AD> ad = database.StatementFactory.getQuery().getAD("adid", re.getAdid(), 1);
            result.addAll(ad);
        }
        return result;
    }
}
