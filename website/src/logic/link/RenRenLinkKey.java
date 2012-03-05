    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.link;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;/**
 *
 * @author xuan
 */
public class RenRenLinkKey implements ILinkKey {
	public String apiKey = null;
	public String secretKey = null;
	public String sessionKey = null;
	
	RenRenLinkKey(String api_key, String secret_key, String session_key){
		this.apiKey = api_key;
		this.secretKey = secret_key;
		this.sessionKey = session_key;
	}
	
	public void setApiKey(String key){
		this.apiKey = key;
	}
	
	public void setSecretKey(String key){
		this.secretKey = key;
	}
	
	public void setSessionKey(String key){
		this.sessionKey = key;
	}
	
	public String getApiKey() throws UnsupportedEncodingException{
		return URLEncoder.encode(this.apiKey, "UTF-8");
	}
	
	public String getSecretKey() throws UnsupportedEncodingException{
		return URLEncoder.encode(this.secretKey, "UTF-8");
	}
	
	public String getSessionKey() throws UnsupportedEncodingException{
		return URLEncoder.encode(this.sessionKey, "UTF-8");
	}
}
