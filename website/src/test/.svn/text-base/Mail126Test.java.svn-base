package test;
///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package test;
//
///**
// *
// * @author Franklin
// */
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
//import java.util.regex.Pattern;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpException;
//import org.apache.http.HttpHost;
//import org.apache.http.HttpRequest;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.UrlEncodedFormEntity;
//import org.apache.http.cookie.CookieOrigin;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.cookie.BasicClientCookie;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.params.HttpProtocolParams;
//
//import test.com.xdatasystem.contactsimporter.AuthenticationException;
//import test.com.xdatasystem.contactsimporter.ContactImpl;
//import test.com.xdatasystem.contactsimporter.ContactListImporterException;
//import test.com.xdatasystem.contactsimporter.MemorizingRedirectHandler;
//import test.com.xdatasystem.contactsimporter.UpdateableCookieStore;
//import test.com.xdatasystem.contactsimporter.Contact;
//
//public class Mail126Test {
//
//
//	public Mail126Test(String username, String password) {
//		currentURL = null;
//		this.username = username;
//		this.password = password;
//		emailPattern = Pattern
//				.compile("^[0-9a-z]([-_.~]?[0-9a-z])*@[0-9a-z]([-.]?[0-9a-z])*\\.[a-z]{2,4}$");
//	}
//
////	protected Logger getLogger() {
////		return log;
////	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public boolean isEmailAddress(String email) {
//		return emailPattern.matcher(email).matches();
//	}
//
//	public List getContactList() throws ContactListImporterException {
//		try {
//			DefaultHttpClient client = getHttpClient();
//			//log.info("Performing login");
//			login(client);
//			//log.info("Login succeeded");
//			String host = ((HttpHost) client.getDefaultContext().getAttribute(
//					"http.target_host")).getHostName();
//			return getAndParseContacts(client, host);
//		} catch (Exception e) {
//			if (e instanceof ContactListImporterException)
//				throw (ContactListImporterException) e;
//			else
//				throw new ContactListImporterException((new StringBuilder(
//						"Exception occured: ")).append(e.getMessage())
//						.toString(), e);
//		}
//	}
//
//	public List getAndUpdateContactList(List contacts)
//			throws ContactListImporterException {
//		try {
//			DefaultHttpClient client = getHttpClient();
//			//log.info("Performing login");
//			login(client);
//			//log.info("Login succeeded");
//			String host = ((HttpHost) client.getDefaultContext().getAttribute(
//					"http.target_host")).getHostName();
//			return getAndParseUpdateContacts(client, host, contacts);
//		} catch (Exception e) {
//			if (e instanceof ContactListImporterException)
//				throw (ContactListImporterException) e;
//			else
//				throw new ContactListImporterException((new StringBuilder(
//						"Exception occured: ")).append(e.getMessage())
//						.toString(), e);
//		}
//	}
//
//	protected List getAndParseUpdateContacts(DefaultHttpClient client,
//			String host, List contacts) throws Exception {
//		return null;
//	}
//
//	protected List getAndParseContacts(DefaultHttpClient client, String host)
//			throws Exception {
//		String listUrl = getContactListURL();
//
//		if (username.contains("@hotmail.com")) {
//			listUrl = String.format(getContactListURL(), new Object[] { host });
//		}
//		//log.info("Retrieving contactlist");
//		InputStream input = null;
//		if (username.contains("@126.com")) {
//			String postData = "<?xml version='1.0'?><object><array name='items'><object><string name='func'>pab:searchContacts</string><object name='var'><array name='order'><object><string name='field'>FN</string><boolean name='ignoreCase'>true</boolean></object></array></object></object><object><string name='func'>user:getSignatures</string></object><object><string name='func'>pab:getAllGroups</string></object></array></object>";
//			StringEntity entiry = new StringEntity(postData,"UTF-8");
//			input = doPost(client,listUrl,entiry,null);
//		}
//		else
//		 input = getContactListContent(client, listUrl, null);
//
//		//log.info("Parsing contactlist");
//		List contacts = parseContacts(input);
//		input.close();
//		return contacts;
//	}
//
//	protected InputStream getContactListContent(DefaultHttpClient client,
//			String listUrl, String referer)
//			throws ContactListImporterException, URISyntaxException,
//			InterruptedException, HttpException, IOException {
//		return doGet(client, listUrl, referer);
//	}
//
//	protected DefaultHttpClient getHttpClient() {
//		if (client == null) {
//			client = new DefaultHttpClient();
//			client.setCookieStore(new UpdateableCookieStore());
//			client.setRedirectHandler(new MemorizingRedirectHandler());
//			client.getParams().setParameter("http.protocol.cookie-policy",
//					"compatibility");
//			List headers = new ArrayList();
//			headers
//					.add(new BasicHeader(
//							"User-Agent",
//							"Mozilla/5.0 (Windows; U; Windows NT 5.1; nl; rv:1.8.1.13) Gecko/20080311 Firefox/2.0.0.13"));
//			client.getParams().setParameter("http.default-headers", headers);
//			return client;
//		} else {
//			return client;
//		}
//	}
//
//	protected void setHeaders(HttpRequest req, String referer) {
//		req
//				.addHeader(
//						"Accept",
//						"text/xml,text/javascript,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
//		req.addHeader("Accept-Language", "en-us;q=0.7,en;q=0.3");
//		req.addHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
//		if (referer != null)
//			req.addHeader("Referer", referer);
//	}
//
//	private void updateCurrentUrl(HttpClient client) {
//		HttpRequest req = (HttpRequest) client.getDefaultContext()
//				.getAttribute("http.request");
//		HttpHost host = (HttpHost) client.getDefaultContext().getAttribute(
//				"http.target_host");
//		currentURL = (new StringBuilder(String.valueOf(host.toURI()))).append(
//				req.getRequestLine().getUri()).toString();
//	}
//
//	protected String getCurrentUrl() {
//		return currentURL;
//	}
//
//	protected InputStream doGet(HttpClient client, String url, String referer)
//			throws ContactListImporterException, URISyntaxException,
//			InterruptedException, HttpException, IOException {
//		client.getConnectionManager().closeIdleConnections(0L,
//				TimeUnit.MILLISECONDS);
//		HttpGet get = new HttpGet(url);
//		setHeaders(get, referer);
//		HttpResponse resp = client.execute(get, client.getDefaultContext());
//		updateCurrentUrl(client);
//		InputStream content = resp.getEntity().getContent();
//		return content;
//	}
//
//	protected InputStream doPost(HttpClient client, String url,
//			NameValuePair data[], String referer)
//			throws ContactListImporterException, HttpException, IOException,
//			InterruptedException, URISyntaxException {
//		//log.info((new StringBuilder("POST ")).append(url).toString());
//		HttpPost post = new HttpPost(url);
//		setHeaders(post, referer);
//		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
//		post.setEntity(new UrlEncodedFormEntity(data, "UTF-8"));
//		HttpProtocolParams.setUseExpectContinue(client.getParams(), false);
//		HttpProtocolParams.setUseExpectContinue(post.getParams(), false);
//		HttpResponse resp = client.execute(post, client.getDefaultContext());
//		updateCurrentUrl(client);
//		InputStream content = resp.getEntity().getContent();
//		return content;
//	}
//
//	protected InputStream doPost(HttpClient client, String url,
//			HttpEntity data, String referer)
//			throws ContactListImporterException, HttpException, IOException,
//			InterruptedException, URISyntaxException {
//		//log.info((new StringBuilder("POST ")).append(url).toString());
//		HttpPost post = new HttpPost(url);
//		setHeaders(post, referer);
//		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
//		post.setEntity(data);
//		HttpProtocolParams.setUseExpectContinue(client.getParams(), false);
//		HttpProtocolParams.setUseExpectContinue(post.getParams(), false);
//		HttpResponse resp = client.execute(post, client.getDefaultContext());
//		updateCurrentUrl(client);
//		InputStream content = resp.getEntity().getContent();
//		return content;
//	}
//
//	protected String readInputStream(InputStream is) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(is));
//		StringBuffer buffer = new StringBuffer();
//		String line;
//		while ((line = in.readLine()) != null)
//			buffer.append(line);
//		is.close();
//		return buffer.toString();
//	}
//
//	protected void consumeInputStream(InputStream is) throws IOException {
//		for (BufferedReader in = new BufferedReader(new InputStreamReader(is)); in
//				.readLine() != null;)
//			;
//		is.close();
//	}
//
//	public static boolean isConformingEmail(String email, String domains[]) {
//		if (email == null)
//			return false;
//		String as[];
//		int j = (as = domains).length;
//		for (int i = 0; i < j; i++) {
//			String d = as[i];
//			if (email.indexOf(d) == email.length() - d.length())
//				return true;
//		}
//		return false;
//	}
//
//	private String username;
//
//	private String password;
//
//	private static Logger log = Logger
//			.getLogger(test.Mail126Test.class
//					.getName());
//
//	private Pattern emailPattern;
//
//	private DefaultHttpClient client;
//
//	private String currentURL;
//
//
//	public String getContactListURL() {
//		String url = "http://"+mail_host+"/a/s?sid="+tempSessId+"&func=pab:searchContacts";
//		return url;
//	}
//
//	public String getLoginURL() {
//		// TODO Auto-generated method stub
//		return "http://reg.163.com/login.jsp?type=1&product=mail126&url=http://entry.mail.126.com/cgi/ntesdoor?hid%3D10010102%26lightweight%3D1%26language%3D0%26style%3D3";
//	}
//
//	protected void login(DefaultHttpClient client) throws Exception {
//
//		long time = System.currentTimeMillis();
//		BasicClientCookie cookie = new BasicClientCookie("126_LOGIN",
//				(new StringBuilder("T")).append(time).append("/").append(
//						time - 16L).append("/").append(time).toString());
//		client.getCookieStore().addCookie(cookie);
//
//	String content;
//	String pureName =  this.getUsername().substring(0,
//			this.getUsername().indexOf("@"));
//	String totalName = this.getUsername();
//
//		String loginUrl = getLoginURL();
//		NameValuePair data[] = {
//				new BasicNameValuePair("style", "3"),
//				new BasicNameValuePair("domain", "126.com"),
//				new BasicNameValuePair("language", "0"),
//				new BasicNameValuePair("user", pureName),
//				new BasicNameValuePair("username", totalName),
//				new BasicNameValuePair("password", this.getPassword()) };
//
//		content = readInputStream(doPost(client, loginUrl, data, ""));
////		 redirect
//		if (content.contains("window.location.replace")) {
//			//getLogger().info("redirecting");
//		}
//		else{
//			  //getLogger().info("Login failed, username or  password do not match please check your name&password");
//	            throw new AuthenticationException("Login failed");
//		}
//
//		String sessId = null;
//		String headStr = "window.location.replace(\"";
//		String reUrl = content.substring(content.indexOf(headStr)+headStr.length());
//		reUrl = reUrl.substring(0, reUrl.indexOf("\");"));
//		reUrl = reUrl.replace("|", "%40");
//
//		//getLogger().info("Requesting redirect page1  "+reUrl);
//
//		InputStream is = doGet(client, reUrl, null);
//
//		content = readInputStream(is);
//
//		//System.out.println(new String(content.getBytes(), "GBK"));
//
//		String reUrl2 = content.substring(content.indexOf(headStr)+headStr.length());
//
//		reUrl2 = reUrl2.substring(0, reUrl2.indexOf("\");"));
//		reUrl2 = reUrl2.replace("|", "%40");
//
//		//getLogger().info("Requesting redirect page1  "+reUrl2);
//
//		is = doGet(client, reUrl2, null);
//
//		content = readInputStream(is);
//		CookieOrigin cooO = (CookieOrigin) client.getDefaultContext().getAttribute("http.cookie-origin");
//		if(cooO!=null)
//		mail_host = cooO.getHost();
//
//		//System.out.println("-------------");
//
//		//System.out.println(new String(content.getBytes(), "GBK"));
//
//		if(content.contains("options.jsp?sid=")){
//			sessId = content.substring(content.indexOf("options.jsp?sid=")+16);
//			sessId = sessId.substring(0, sessId.indexOf("\""));
//			tempSessId = sessId;
//		}
//
//		BasicClientCookie logType = new BasicClientCookie("logType", "df");
//		BasicClientCookie nts_mail_user =new BasicClientCookie("nts_mail_user", pureName+":-1:1");
//		BasicClientCookie NETEASE_SSN = new BasicClientCookie("NETEASE_SSN", pureName);
//		BasicClientCookie MAIL126_SSN = new BasicClientCookie("MAIL126_SSN", pureName);
//		BasicClientCookie ntes_mail_firstpage = new BasicClientCookie("ntes_mail_firstpage", "normal");
//		BasicClientCookie mail_sid = new BasicClientCookie("mail_sid", tempSessId);
//		BasicClientCookie mail_uid = new BasicClientCookie("mail_uid", totalName);
//		BasicClientCookie mail_style = new BasicClientCookie("mail_style", "dm3");
//		BasicClientCookie mail_hostC = new BasicClientCookie("mail_host", mail_host);
//
//		client.getCookieStore().addCookie(logType);
//		client.getCookieStore().addCookie(nts_mail_user);
//		client.getCookieStore().addCookie(NETEASE_SSN);
//		client.getCookieStore().addCookie(MAIL126_SSN);
//		client.getCookieStore().addCookie(ntes_mail_firstpage);
//		client.getCookieStore().addCookie(mail_sid);
//		client.getCookieStore().addCookie(mail_uid);
//		client.getCookieStore().addCookie(mail_style);
//		client.getCookieStore().addCookie(mail_hostC);
//
//	}
//
//	protected List parseContacts(InputStream is) throws Exception {
//
//		List<Contact> contactList = new ArrayList();
//		String source = readInputStream(is);
//		source = source.replace("\"", "");
//		//getLogger().info(source);
//
//		int startI = 0;
////		String emailStr = "</string name=EMAIL;PREF>";
////		String nameStr = "</string name=FN>";
//
//		String emailStr = "'EMAIL;PREF':'";
//		String nameStr = "'FN':'";
//
//		while ((startI = source.indexOf(emailStr)) > 0) {
//			//System.out.println("One!!!");
//			String sb = source.substring(startI+emailStr.length());
//			//get name
//
//			String email = sb.substring(0, sb.indexOf("','"));
//			source = source.substring(startI
//					+ emailStr.length());
//			//get email address
//			startI = source.indexOf(nameStr);
//			String name = source.substring(startI+nameStr.length());
//			name = name.substring(0, name.indexOf("','"));
//			source = source.substring(startI
//					+ nameStr.length());
//			//Franklin
//			//System.out.println(name + ": " + email);
//			contactList.add(new ContactImpl(name, email));
//		}
//
//		return contactList;
//	}
//
//	public static boolean is126(String email) {
//		return email.indexOf("@126.") != -1;
//	}
//	static String tempSessId = "";
//	static String mail_host ="";
//
//	public static void main(String[] args) throws Exception {
//		Mail126Test importer= new Mail126Test("test2010@126.com", "csyale402");
//		List<Contact> contacts= importer.getContactList();
//		System.out.println(contacts.size());
//		for(Contact c : contacts) {
//		//System.out.println("AAA");
//		  System.out.println("name: "+new String(c.getName().getBytes(),"GBK")+", email: "+c.getEmailAddress());
//		}
//
//	}
//
//
//}
//
