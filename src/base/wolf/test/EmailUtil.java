package base.wolf.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wolf.util.FileUtil;

public class EmailUtil {

	private final static String default_charset = "UTF-8";

	public static enum EncryptionTypes {
		Default, TLS, SSL
	}

	static final Log logger = LogFactory.getLog(EmailUtil.class);

	private String mail_host = "smtp.126.com";
	private int mail_port = 25;
	private int encryptionType = EncryptionTypes.Default.ordinal();
	private boolean auth = true;
	private String mail_host_account = "workemailgong@126.com";
	private String mail_host_password = "workemail66";
	private boolean isHtml = true;
	
	public EmailUtil(){
		
	}

	public EmailUtil(String mail_host) {
		this.mail_host = mail_host;
	}

	public EmailUtil(String mail_host, boolean auth, String account,
			String password) {
		this(mail_host, 25, EncryptionTypes.Default.ordinal(), auth, account,
				password);
	}

	public EmailUtil(String mail_host, int mail_port, int encryptionType,
			boolean auth, String account, String password) {
		this.mail_host = mail_host;
		this.mail_port = mail_port;
		this.encryptionType = encryptionType;
		this.auth = auth;
		this.mail_host_account = account;
		this.mail_host_password = password;
	}

	public EmailUtil(String mail_host, boolean auth, String account,
			String password, boolean isHtml) {
		this(mail_host, 25, EncryptionTypes.Default.ordinal(), auth, account,
				password, isHtml);
	}

	public EmailUtil(String mail_host, int mail_port, int encryptionType,
			boolean auth, String account, String password, boolean isHtml) {
		this.mail_host = mail_host;
		this.mail_port = mail_port;
		this.encryptionType = encryptionType;
		this.auth = auth;
		this.mail_host_account = account;
		this.mail_host_password = password;
		this.isHtml = isHtml;
	}

	/**
	 * Send email to a single recipient or recipient string.
	 * 
	 * @param senderAddress
	 *            the sender email address
	 * @param senderName
	 *            the sender name
	 * @param receiverAddress
	 *            the recipient email address
	 * @param sub
	 *            the subject of the email
	 * @param msg
	 *            the message content of the email
	 */
	public void sendEmail(String senderAddress, String senderName,
			String receiverAddress, String sub, String msg) throws Exception {
		String[] address = receiverAddress.split(";");
		List<String> recipients = new ArrayList<String>();
		for (int i = 0; i < address.length; i++) {
			if (address[i].trim().length() > 0) {
				recipients.add(address[i]);
			}
		}

		this.sendEmail(senderAddress, senderName, recipients, sub, msg);
	}
	
	public void sendEmailWithBackGroundList(List<String> imgList, String receiverAddress, String msg) throws Exception {
		String[] address = receiverAddress.split(";");
		List<String> recipients = new ArrayList<String>();
		for (int i = 0; i < address.length; i++) {
			if (address[i].trim().length() > 0) {
				recipients.add(address[i]);
			}
		}
		this.finalsendEmailWithBackGround(imgList, recipients, msg, null);
		
	}

	public void sendEmail(String senderAddress, String senderName,
			List<String> recipients, String sub, String msg) throws SendFailedException {
		this.finalsendEmail(senderAddress, senderName, recipients, sub, msg, null);
	}

	public void sendEmail(String senderAddress, String senderName,
			String receiverAddress, String sub, String msg,
			Collection attachments) throws Exception {
		String[] address = receiverAddress.split(";");
		List<String> recipients = new ArrayList<String>();
		for (int i = 0; i < address.length; i++) {
			if (address[i].trim().length() > 0) {
				recipients.add(address[i]);
			}
		}

		this.finalsendEmail(senderAddress, senderName, recipients, sub, msg,
				attachments);
	}

	/**
	 * Send email to a list of recipients.
	 * 
	 * @param senderAddress
	 *            the sender email address
	 * @param senderName
	 *            the sender name
	 * @param recipients
	 *            a list of receipients email addresses
	 * @param sub
	 *            the subject of the email
	 * @param msg
	 *            the message content of the email
	 * @param attachments
	 *            attachments list of the email
	 */
	public void finalsendEmail(String senderAddress, String senderName,
			List<String> recipients, String sub, String msg, Collection attachments)
			throws SendFailedException {

		logger.debug("mail subject: " + sub + " mail_port: " + this.mail_port
				+ " encryptionType: " + this.encryptionType + " auth: "
				+ this.auth + " mail_host_account: " + this.mail_host_account
				+ " mail_host_password: " + this.mail_host_password);

		Transport transport = null;

		try {

			Properties props = this.getProperties();

			Session session = this.getSession(props);

			MimeMessage message = new MimeMessage(session);

			if (this.getDefaultIsHtml()) {
				message.addHeader("Content-type", "text/html");
			} else {
				message.addHeader("Content-type", "text/plain");
			}

			message.setSubject(sub, default_charset);
			message.setFrom(new InternetAddress(senderAddress, senderName));

			for (Iterator<String> it = recipients.iterator(); it.hasNext();) {
				String email = (String) it.next();
				message.addRecipients(Message.RecipientType.TO, email);
			}

			

			// content
			MimeBodyPart contentPart = new MimeBodyPart();

			if (this.getDefaultIsHtml()) {
				contentPart.setContent(
						"<meta http-equiv=Content-Type content=text/html; charset="
								+ default_charset + ">" + msg,
						"text/html;charset=" + default_charset);
			} else {
				contentPart.setText(msg, default_charset);
			}
//			Multipart mp = new MimeMultipart();
			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(contentPart);

			
			//附件形式
			// attachment
			if (attachments != null) {
				MimeBodyPart attachPart;
				for (Iterator it = attachments.iterator(); it.hasNext();) {
					attachPart = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(it.next()
							.toString().trim());
					attachPart.setDataHandler(new DataHandler(fds));
					if (fds.getName().indexOf("$") != -1) {
						attachPart.setFileName(fds.getName().substring(
								fds.getName().indexOf("$") + 1,
								fds.getName().length()));
					} else {
						attachPart.setFileName(fds.getName());
					}
					mp.addBodyPart(attachPart);
				}

			}
			

			message.setContent(mp);

			message.setSentDate(new Date());

			if (this.getDefaultEncryptionType() == EncryptionTypes.SSL
					.ordinal()) {
				Transport.send(message);
			} else {
				transport = session.getTransport("smtp");

				transport.connect(this.mail_host, this.mail_port,
						this.mail_host_account, this.mail_host_password);
				
				transport.sendMessage(message, message.getAllRecipients());
				
//				transport.sendMessage(EmailUtil.createImageMail(session), EmailUtil.createImageMail(session).getAllRecipients());
				
				
			}

		} catch (Exception e) {
			logger.error("send mail error", e);
			throw new SendFailedException(e.toString());
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (Exception ex) {
				}
			}
		}
	}
	
	
	public void finalsendEmailWithBackGround(List<String> imgList, List<String> recipients, String msg, 
			Collection attachments) throws SendFailedException {
		

		Transport transport = null;

		try {

			Properties props = this.getProperties();

			Session session = this.getSession(props);

			MimeMessage message = new MimeMessage(session);

			if (this.getDefaultIsHtml()) {
				message.addHeader("Content-type", "text/html");
			} else {
				message.addHeader("Content-type", "text/plain");
			}

			message.setSubject("新越网注册", default_charset);
			message.setFrom(new InternetAddress(this.mail_host_account));

			for (Iterator<String> it = recipients.iterator(); it.hasNext();) {
				String email = (String) it.next();
				message.addRecipients(Message.RecipientType.TO, email);
			}

			
			System.out.println(msg);
			// content
			MimeBodyPart contentPart = new MimeBodyPart();

			if (this.getDefaultIsHtml()) {
				contentPart.setContent(
						"<meta http-equiv=Content-Type content=text/html; charset="
								+ default_charset + ">" + msg,
						"text/html;charset=" + default_charset);
			} else {
				contentPart.setText(msg, default_charset);
			}
//			Multipart mp = new MimeMultipart();
			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(contentPart);

			//添加图片
			for (String imgName : imgList) {
				 // 准备图片数据
		        MimeBodyPart image = new MimeBodyPart();
		        DataHandler dh = new DataHandler(new FileDataSource("D:/image/" + imgName));
		        image.setDataHandler(dh);
		        image.setContentID(imgName);
		        System.out.println(imgName);
		        mp.addBodyPart(image);
			}
			
			
			//附件形式
			// attachment
			if (attachments != null) {
				MimeBodyPart attachPart;
				for (Iterator it = attachments.iterator(); it.hasNext();) {
					attachPart = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(it.next()
							.toString().trim());
					attachPart.setDataHandler(new DataHandler(fds));
					if (fds.getName().indexOf("$") != -1) {
						attachPart.setFileName(fds.getName().substring(
								fds.getName().indexOf("$") + 1,
								fds.getName().length()));
					} else {
						attachPart.setFileName(fds.getName());
					}
					mp.addBodyPart(attachPart);
				}

			}
			

			message.setContent(mp);

			message.setSentDate(new Date());

			if (this.getDefaultEncryptionType() == EncryptionTypes.SSL
					.ordinal()) {
				Transport.send(message);
			} else {
				transport = session.getTransport("smtp");

				transport.connect(this.mail_host, this.mail_port,
						this.mail_host_account, this.mail_host_password);
				
				transport.sendMessage(message, message.getAllRecipients());
				
				
				
			}

		} catch (Exception e) {
			logger.error("send mail error", e);
			throw new SendFailedException(e.toString());
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (Exception ex) {
				}
			}
		}
	
			
			
	}

	
	public static MimeMessage createImageMail(Session session) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //发件人
        message.setFrom(new InternetAddress("workemailgong@126.com"));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("378476772@qq.com"));
        //邮件标题
        message.setSubject("带图片的邮件");

        // 准备邮件数据
        // 准备邮件正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:test.jpg'>的邮件", "text/html;charset=UTF-8");
        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("D:/image/bj.png"));
        image.setDataHandler(dh);
        image.setContentID("test.jpg");
        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        message.setContent(mm);
        message.saveChanges();
        //将创建好的邮件写入到E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
        //返回创建好的邮件
        return message;
}
	
	private Properties getProperties() {

		Properties props = System.getProperties();

		int defaultEncryptionType = this.getDefaultEncryptionType();

		if (defaultEncryptionType == EncryptionTypes.TLS.ordinal()) {
			props.put("mail.smtp.auth", String.valueOf(this.auth));
			props.put("mail.smtp.starttls.enable", "true");
		} else if (defaultEncryptionType == EncryptionTypes.SSL.ordinal()) {
			props.put("mail.smtp.host", this.mail_host);
			props.put("mail.smtp.socketFactory.port", this.mail_port);
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.auth", String.valueOf(this.auth));
			props.put("mail.smtp.port", this.mail_port);
		} else {
			props.put("mail.smtp.host", this.mail_host);
			props.put("mail.smtp.auth", String.valueOf(this.auth));
		}

		return props;
	}

	private Session getSession(Properties props) {
		Session session = null;

		if (this.getDefaultEncryptionType() == EncryptionTypes.TLS.ordinal()) {
			session = Session.getInstance(props);
		} else if (this.getDefaultEncryptionType() == EncryptionTypes.SSL
				.ordinal()) {
			session = Session.getInstance(props, new MyAuthenticator(
					this.mail_host_account, this.mail_host_password));
		} else {
			session = Session.getDefaultInstance(props, null);
		}

		return session;
	}

	private boolean getDefaultIsHtml() {
		return this.isHtml;
	}

	private class MyAuthenticator extends Authenticator {
		String user;
		String password;

		public MyAuthenticator() {

		}

		public MyAuthenticator(String user, String password) {
			this.user = user;
			this.password = password;
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.user, this.password);
		}
	}

	/**
	 * get default encryption type, for 465, SSL for 587, TLS
	 * 
	 * @return
	 */
	private int getDefaultEncryptionType() {
		int rst = this.encryptionType;
		if (this.encryptionType == EncryptionTypes.Default.ordinal()) {
			if (this.mail_port == 465) {
				rst = EncryptionTypes.SSL.ordinal();
			} else if (this.mail_port == 587) {
				rst = EncryptionTypes.TLS.ordinal();
			}
		}

		return rst;
	}
	
	

	public static void main(String[] args) {

		System.out.println("EncryptionTypes.SSL.ordinal(): "
				+ EncryptionTypes.Default.ordinal());

		EmailUtil email = new EmailUtil();
//		Collection col = new ArrayList();
		// add attachment
//		col.add("D:/image/bj.png");
//		col.add("D:/image/zc_btn.png");
//		File file = new File("d:/index,html");
		try {
		
		
		String string = FileUtil.read("D:/index.html");
		
//		string = string.replaceAll("${content}", "aaa");
		List<String> imgList = new LinkedList<String>();
		
		String bj = "bj.png";
		String zc_btn  = "zc_btn.png";
//		String zc_btn_hover = "zc_btn_hover.png";
		//第一张图片
//		string = string.replace("${bj.png}", bj);
		imgList.add(bj);
		
		//第二张图片
//		string = string.replaceAll("${zc_btn.png}", zc_btn);
		imgList.add(zc_btn);
		
		
		//第三张图片
//		string = string.replaceAll("${zc_btn_hover.png}", zc_btn_hover);
//		imgList.add(zc_btn_hover);
		
//		email.sendEmail(
//				"workemailgong@126.com",//发件人邮箱
//				"新越网",//发件人名称
//				"378476772@qq.com",
//				"新越网注册",//标题
//				string
//				);
		email.sendEmailWithBackGroundList(imgList, "378476772@qq.com;18768104912@163.com;", string);
			System.out.println("send out successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("send fail");
		}

	}

}
