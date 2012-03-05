/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.link;

import com.xiaonei.api.schema.Friend;
import com.xiaonei.api.schema.User;
import logic.IUser;
import logic.EntityFactory;
/**
 *
 * @author Franklin
 */

public class RenrenUser {

	public String Name = null;
	public String Birth = null;
	public Integer Sex = -1;
	public Integer Star = -1;
	public String HeadUrl = null;
	public String MainUrl = null;
	public String TinyUrl = null;
	public Integer RenrenId = -1;
        public boolean isExist;
        private IUser linkUser;

//	public RenrenUser(Friend friend){
//		this.Name = friend.getName();
//		this.HeadUrl = friend.getHeadurl();
//		this.RenrenId = friend.getId();
//	}

	public RenrenUser(User user){
		this.Name = user.getName();
		this.Birth = user.getBirthday();
		this.Sex = user.getSex();
		this.Star = user.getStar();
		this.HeadUrl = user.getHeadurl();
		this.MainUrl = user.getMainurl();
		this.TinyUrl = user.getTinyurl();
		this.RenrenId = user.getUid();
                this.isExist = false;
                this.linkUser = null;
	}

        public RenrenUser(Friend f){
		this.Name = f.getName();
		this.HeadUrl = f.getHeadurl();
		this.RenrenId = f.getId();
	}


	String GetName(){
		return this.Name;
	}

	String GetBirth(){
		return this.Birth;
	}

	Integer GetSex(){
		return this.Sex;
	}

	Integer GetStar(){
		return this.Star;
	}

	String GetHeadUrl(){
		return this.HeadUrl;
	}

	String GetMainUrl(){
		return this.MainUrl;
	}

	String GetTinyUrl(){
		return this.TinyUrl;
	}

	Integer GetRenrenId(){
		return this.RenrenId;
	}

}
