/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test.com.xdatasystem.contactsimporter;

/**
 *
 * @author Franklin
 */
public class ContactListImporterException extends Exception
{

    public ContactListImporterException(String message)
    {
        super(message);
    }

    public ContactListImporterException(String message, Throwable t)
    {
        super(message, t);
    }

    static final long serialVersionUID = 1L;
}
