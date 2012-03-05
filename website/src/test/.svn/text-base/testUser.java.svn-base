/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.IOException;
import logic.EntityFactory;
import logic.IUser;

/**
 *
 * @author Administrator
 */
public class testUser {
    public static void main(String[] args) throws IOException {
        IUser user = EntityFactory.getUser(31);
        user.setPhoto("pic/face/faceS160.png");
        user.commit();
        System.out.println(user.getPhoto());
        System.out.println(EntityFactory.getUser(31).getPhoto());
    }
}
