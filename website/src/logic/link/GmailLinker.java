/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.link;

//import logic.EntityFactory;
import utility.email.EmailSender;
import com.google.gdata.util.AuthenticationException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.IUser;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.util.ServiceException;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.Name;

/**
 * Use this class inside package only
 * @author xuan
 */
public class GmailLinker implements ILinker {

    @Override
    public ArrayList<ILinkFriend> importFriends(IUser user, String identifier, ILinkKey key) {
        //Check for linker id
        if (!identifier.equals("GmailLinker")) {
            return null;
        } else {
            ArrayList<ILinkFriend> friendList = new ArrayList<ILinkFriend>();

            EmailLinkKey eKey = (EmailLinkKey) key;
            try {
                if (getGmailContact(eKey, friendList)) {
                    return friendList;
                } else {
                    friendList.clear();
                }
            } catch (Exception ex) {
                System.err.println("Exception: " + ex.getMessage());
            }
            return null;
        }//throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean inviteFriends(IUser user, String identifier, ArrayList<ILinkFriend> selectedFriends) {
        if (!identifier.equals("GmailLinker")) {
            return false;
        } else {
            //This part should be modified later
            String msg = "Welcome to iWeiShi.cn!";
            String sub = "Welcome from iWeiShi";
            String from = "iweishi2010@gmail.com";
            String smtp = "smtp.gmail.com";
            String psw = "csyale402";

            ArrayList<String> recipients = new ArrayList<String>();
            for (ILinkFriend id : selectedFriends) {
                if (id.isInvite()) {
                    for (String email : id.getEmail()) {
                        recipients.add(email);
                    }
                }
            }
            //No invitation
            if (recipients.isEmpty()) {
                return false;
            }
            //public EmailSender(ArrayList<String> recipients, String smtp, String subject, String message , String from, String key)
            EmailSender sender = new EmailSender(recipients, smtp, sub, msg, from, psw);
            try {
                sender.postMail();
            } catch (Exception ex) {
                System.err.println("Exception: " + ex.getMessage());
            }
            return true;
        }

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //private boolean getGmailContact(ContactsService myService, String userEmail, ArrayList<ILinkFriend> friendList) throws ServiceException, IOException {
    public boolean getGmailContact(EmailLinkKey key, List<ILinkFriend> friendList) {
        // Request the feed

        ContactsService myService = new ContactsService("Gmail Contact Import");
        try {
            // Email address and key needed: key structure?
            //myService.setUserCredentials("iweishi2010@gmail.com", "csyale402
            myService.setUserCredentials(key.address, key.password);
        } catch (AuthenticationException ex) {
            Logger.getLogger(GmailLinker.class.getName()).log(Level.SEVERE, null, ex);
        }

        URL feedUrl = null;
        try {
            feedUrl = new URL("http://www.google.com/m8/feeds/contacts/" + key.address + "/full");
        } catch (MalformedURLException ex) {
            Logger.getLogger(GmailLinker.class.getName()).log(Level.SEVERE, null, ex);
        }

        ContactFeed resultFeed = null;
        try {
            resultFeed = myService.getFeed(feedUrl, ContactFeed.class);
        } catch (IOException ex) {
            Logger.getLogger(GmailLinker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(GmailLinker.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Get friends' email and name
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
            ContactEntry entry = resultFeed.getEntries().get(i);
            ILinkFriend friendData = new ILinkFriend();

            //System.out.println("Photo: " + entry.getContactPhotoLink().getHref());

            //Name
            if (entry.hasName()) {
                Name name = entry.getName();
                if (name.hasFullName()) {
                    String fullName = name.getFullName().getValue();
                    if (name.getFullName().hasYomi()) {
                        fullName += " (" + name.getFullName().getYomi() + ")";
                    }
                    friendData.ILinkFriendSetName(fullName);
                }
            } else {
                friendData.ILinkFriendSetName(null);
            }

            //Email
            for (Email email : entry.getEmailAddresses()) {
                friendData.ILinkFriendAddEmail(email.getAddress());
            }
            //friendData.linkUserByGmail();
            friendList.add(friendData);
        }

        if (friendList != null) {
            return true;
        } else {
            return false;
        }
    }
}
