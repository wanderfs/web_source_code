/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test.com.xdatasystem.contactsimporter;

/**
 *
 * @author Franklin
 */

public class ContactImpl
    implements Contact
{

    public ContactImpl(String name, String email)
    {
        this.name = name;
        this.email = email;
        im = "";
    }

    public ContactImpl(String name, String email, String im)
    {
        this.name = name;
        this.email = email;
        this.im = im;
    }

    public String getName()
    {
        return name;
    }

    public String getGeneratedName()
    {
        if(name == null || name.length() == 0)
            return email.substring(0, email.indexOf('@'));
        else
            return name;
    }

    public String getEmailAddress()
    {
        return email;
    }

    public String getIMAddress()
    {
        return im;
    }

    public String toString()
    {
        return (new StringBuilder("name: ")).append(name).append(", email: ").append(email).append(im != null ? (new StringBuilder(", im: ")).append(im).toString() : "").toString();
    }

    public boolean equals(Object o)
    {
        if(!(o instanceof Contact))
            return false;
        else
            return email.equals(((Contact)o).getEmailAddress());
    }

    private String name;
    private String email;
    private String im;
}