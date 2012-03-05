/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;
import java.util.ArrayList;
import logic.link.GenericLinker;
import logic.link.ILinkFriend;
import logic.link.GmailLinker;
import logic.link.EmailLinkKey;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
/**
 *
 * @author Franklin
 */
public class LinkTest {
    
    public static StringBuffer sb = new StringBuffer();

    public static String myTest4Jsp() throws ServiceException, IOException{

         sb = new StringBuffer();
         GmailLinker gLinker = new GmailLinker();


        ArrayList<ILinkFriend> friendList = new ArrayList<ILinkFriend>();

        EmailLinkKey key = new EmailLinkKey("iweishi2010@gmail.com", "csyale402");

        //Get friendlist
        friendList = gLinker.importFriends(null, "GmailLinker", key);

        //gLinker.getGmailContact(key, friendList);

        for(ILinkFriend iLinker : friendList){
            if(iLinker.isExist){
               sb.append("This user has already reg on iweishi!");
            }
            else{
               sb.append("This user has not reg on iweishi yet!");
            }
            for(String s : iLinker.getEmail()){
                sb.append(s + " ");
            };
        }

        return sb.toString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws ServiceException, IOException{
        // TODO code application logic here
        GmailLinker gLinker = new GmailLinker();


        ArrayList<ILinkFriend> friendList = new ArrayList<ILinkFriend>();

        EmailLinkKey key = new EmailLinkKey("iweishi2010@gmail.com", "csyale402");

        System.out.println("Begin Fetching...");

        //Get friendlist
        friendList = gLinker.importFriends(null, "GmailLinker", key);
        
        //gLinker.getGmailContact(key, friendList);
        
        for(ILinkFriend iLinker : friendList){
            System.out.println(iLinker.getName());
            for(int i = 0; i<iLinker.getEmail().size(); i++){
              System.out.println(iLinker.getEmail().get(i));
            };
        }

        //Invite
 /*       for(ILinkFriend id : friendList){
               id.setInvite();
        }

        //Send invitation mails
        if(gLinker.inviteFriends(null, "GmailLinker", friendList)){
            System.out.println("Invitation mail sent!");
        }*/
    }

}
