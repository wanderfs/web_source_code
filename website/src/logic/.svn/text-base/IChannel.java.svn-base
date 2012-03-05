package logic;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import logic.datatype.PostEvent;
import logic.datatype.JoinChannelEvent;
import logic.datatype.SubscribeChannelEvent;

public interface IChannel {
	/*=================================================
	 * Properties Section
	 *=================================================*/
	public int getChannelid() ;
	public void setChannelid(int groupid);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public void setDescription(String description);
	public Date getTime() ;
	public void setTime(Date time) ;
	public int getAdministratorid();
	public void setAdministratorid(int administor);

        public void commit();
	
	public List<JoinChannelEvent> getMember(int topnum);
        public List<SubscribeChannelEvent> getSubscriber(int topnum);
	public List<PostEvent> getPosts(int from, int topnum);
        public int getPostNumber();
        public void addAd(AD ad);
        public void removeAd(AD ad);
        public List<AD> getAds();
}
