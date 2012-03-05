/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.link;

/**
 * For demostration purpose
 * @author xuan
 */
public class EmailLinkKey implements ILinkKey {
    public String address;
    public String password;
    public EmailLinkKey(String address, String password) {
        this.address = address;
        this.password = password;
    }
}
