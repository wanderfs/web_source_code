/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;
import logic.IUser;
import logic.EntityFactory;
import java.util.List;
import java.util.Iterator;
import logic.datatype.JoinChannelEvent;
/**
 *
 * @author Administrator
 */
public class ChannelListTest {

    public static void main(String[] args) throws Exception {

            int uid = 18;
            IUser host = EntityFactory.getUser(uid);
             List channellist = host.getJoinedChannel(30);
                    Iterator<JoinChannelEvent> channelit = channellist.iterator();

                    while(channelit.hasNext()){
                        System.out.println(EntityFactory.getGroup(channelit.next().getGroupid()).getName());
                    }
    }
}
