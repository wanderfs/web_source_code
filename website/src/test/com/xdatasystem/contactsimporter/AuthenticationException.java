/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test.com.xdatasystem.contactsimporter;

/**
 *
 * @author Franklin
 */
public class AuthenticationException extends ContactListImporterException
{

    public AuthenticationException(String message)
    {
        super(message);
    }

    public AuthenticationException(String message, Throwable t)
    {
        super(message, t);
    }

    static final long serialVersionUID = 1L;
}