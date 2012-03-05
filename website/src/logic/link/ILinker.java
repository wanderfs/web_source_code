/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.link;

import java.util.ArrayList;
import logic.IUser;

/**
 *  
 *  If this linker can't parse specific key, return null;
 *
 * This linker can use identifier to decide if it can process it.
 *
 * A typical workflow of a Linker is:
 * 1. user type in user name and password of his/her account on a website "a.com"
 * 2. call importFriends(usr, "a.com", {username, password})
 * 3. linker parse out the friends, store them, return the friends list
 * 4. display the parsed friends list to the user
 * 5. user chooses some friends he/she would like to invite
 * 6. call inviteFriends(user, "a.com", friends's id)
 * 
 * @author xuan
 */
public interface ILinker {

    public ArrayList<ILinkFriend> importFriends(IUser user, String identifier, ILinkKey key);

    //public boolean inviteFriends(IUser user, String identifier, ArrayList<Integer> selectedFriendsId);

    public boolean inviteFriends(IUser user, String identifier, ArrayList<ILinkFriend> selectedFriends);
}
