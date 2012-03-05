/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.link;

import java.util.ArrayList;
import logic.IUser;

/**
 * Use this class to link with any source
 * @author xuan
 */
public class GenericLinker implements ILinker {

    private static GenericLinker genericLinker = null;
    protected ArrayList<ILinker> linkers;
    public static ILinker getGenericLinker() {
        if (genericLinker == null) {
            genericLinker = new GenericLinker();
        }
        return genericLinker;
    }

    /**
     * When you implement a new linker, please add it here.
     */
    private GenericLinker() {
        linkers = new ArrayList<ILinker>();
        linkers.add(new GmailLinker());
    }

    @Override
    public ArrayList<ILinkFriend> importFriends(IUser user, String identifier, ILinkKey key) {
        for (ILinker linker : this.linkers) {
            ArrayList<ILinkFriend> friendList = linker.importFriends(user, identifier, key);
            if (friendList != null)
                return friendList;
        }
        return null;
    }

    @Override
    public boolean inviteFriends(IUser user, String identifier, ArrayList<ILinkFriend> selectedFriends) {
        boolean returnFlag = false;
        for (ILinker linker : this.linkers){
             returnFlag = returnFlag || linker.inviteFriends(user, identifier, selectedFriends);
         }
         return returnFlag;
    }

}
