/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.link;
import java.util.ArrayList;
import logic.IUser;
import logic.EntityFactory;

/**
 *
 * @author xuan
 */
public class ILinkFriend{
    private String Name;
    private ArrayList<String> Email;
    private boolean isInvite;
    public boolean isExist;
    private IUser linkUser;

    public ILinkFriend(){
        this.Name = null;
        //isExist should be checked by database
        this.isExist = false;
        this.linkUser = null;
        this.isInvite = false;
        this.Email = new ArrayList<String>();
    }

    public String getName() {
        return this.Name;
    }
    public ArrayList<String> getEmail() {
        return this.Email;
    }
    public void ILinkFriendAddEmail(String em){
        this.Email.add(em);
    }
    public void ILinkFriendSetName(String n){
        this.Name = n;
    }
    public void setInvite(){
        this.isInvite = true;
    }
    public boolean isInvite(){
        return this.isInvite;
    }

    public boolean isExist(){
        return this.isExist;
    }

    public IUser getUserByGmail(){
        return this.linkUser;
    }

    //Might have more IUsers in our db IUser->list
    public IUser linkUserByGmail(){
        for (String e : this.getEmail()) {
            System.out.println("My test: " + e);
           if(logic.EntityFactory.getUser(e)!=null){
               this.isExist = true;
               this.linkUser = logic.EntityFactory.getUser(e);
               return this.linkUser;
           }
        }
        return null;
    }

}
