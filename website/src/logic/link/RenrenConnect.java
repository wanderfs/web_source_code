/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.link;

import java.lang.String;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.net.URLEncoder;
import java.util.EnumSet;
import javax.swing.text.Document;
import com.xiaonei.api.ProfileField;
import com.xiaonei.api.XiaoneiException;
import com.xiaonei.api.XiaoneiRestClient;
import com.xiaonei.api.schema.ConnectRegisterUsersResponse;
import com.xiaonei.api.schema.Friend;
import com.xiaonei.api.schema.FriendsGetFriendsResponse;
import com.xiaonei.api.schema.User;
import com.xiaonei.api.schema.UsersGetInfoResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import logic.EntityFactory;
import logic.IUser;

/**
 *
 * @author Franklin
 */
public class RenrenConnect {

    RenRenLinkKey connectKey = new RenRenLinkKey(null, null, null);

    public RenrenConnect(String api_key, String secret_key, String session_key) {
        connectKey.setApiKey(api_key);
        connectKey.setSecretKey(secret_key);
        connectKey.setSessionKey(session_key);
    }

    public int GetUserId() throws XiaoneiException, IOException {
        XiaoneiRestClient client = null;
        try {
            client = new XiaoneiRestClient(this.connectKey.getApiKey(), this.connectKey.getSecretKey(), this.connectKey.getSessionKey());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(connectKey.apiKey);
        return client.users_getLoggedInUser();
    }

    public IUser GetIUser(){
        return null;
    }

    public IUser GetIUserByXNId(int XNId){
        return null;
    }

    public RenrenUser GetUserProfile() throws XiaoneiException, IOException {
        XiaoneiRestClient client = null;
        try {
            client = new XiaoneiRestClient(this.connectKey.getApiKey(), this.connectKey.getSecretKey(), this.connectKey.getSessionKey());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        EnumSet<ProfileField> enumFields = EnumSet.of(ProfileField.NAME,
                ProfileField.HOMETOWN_LOCATION, ProfileField.BIRTHDAY,
                ProfileField.HEADURL, ProfileField.MAINURL,
                ProfileField.SEX, ProfileField.STAR, ProfileField.TINYURL,
                ProfileField.ZIDOU, ProfileField.UNIVERSITY_HISTORY,
                ProfileField.WORK_HISTORY);
        int loggedInUserId = 0;
        loggedInUserId = client.users_getLoggedInUser();
        org.w3c.dom.Document doc = client.users_getInfo(loggedInUserId, enumFields);
        //json.put("xml",doc.toString());
        UsersGetInfoResponse loggedUserGetInfoRes = (UsersGetInfoResponse) client.getResponsePOJO();
        List<User> ul = loggedUserGetInfoRes.getUser();
        if (ul != null) {
            for (User u : ul) {
                if (u.getUid() == loggedInUserId) {
                    RenrenUser renrenUser = new RenrenUser(u);
                    return renrenUser;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public ArrayList<RenrenUser> GetUserFriends() {

        XiaoneiRestClient client = null;
        try {
            client = new XiaoneiRestClient(this.connectKey.getApiKey(), this.connectKey.getSecretKey(), this.connectKey.getSessionKey());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            client.friends_getFriends();
        } catch (XiaoneiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FriendsGetFriendsResponse resp = (FriendsGetFriendsResponse) client.getResponsePOJO();
        ArrayList<Friend> friends = (ArrayList<Friend>) resp.getFriend();

        if (friends != null) {
            ArrayList<RenrenUser> renrenFriends = new ArrayList<RenrenUser>();

            for (Friend friend : friends) {
                //User user = new User();
                //user.setHeadurl(friend.getHeadurl());
                //user.setName(friend.getName());
                //user.setUid(friend.getId());
                RenrenUser u = new RenrenUser(friend);
                renrenFriends.add(u);
            }
            return renrenFriends;
        } else {
            return null;
        }
    }

    public void newRenrenUser() throws XiaoneiException, IOException {
        int renrenId = this.GetUserId();
        //if(ifExist(renrenId)){
        IUser newUser = EntityFactory.getEmptyUser();
        newUser.setName(this.GetUserProfile().Name);
        String id = String.valueOf(renrenId);
        newUser.setRenrenid(id);
        int status = newUser.commit();
        //}
    }
}
