package TPZTBCS;

import interfacesZTBCS.IBridgeNotificaciones;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class NotificacionEmail implements IBridgeNotificaciones {
	
	private final Properties properties = new Properties();
	private Session session;
	private String email;
	
	@Override
	public void enviarNotificacion(Usuario usuario) {
		this.email = usuario.getEmail();
		sendEmail();
	}
	
	@Override
	public void enviarNotificacion(String email) {
		this.email = email;
		sendEmail();
	}

	
	@Override
	public void enviarNotificacionCambioBrusco(Usuario usuario) {
		this.email = usuario.getEmail();
		sendEmailAlerta();
	}
	
	@Override
	public void enviarNotificacionCambioBrusco(String email) {
		this.email = email;
		sendEmailAlerta();
	}
	
	
	
	private void init() {

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth", "true");
		
		session = Session.getDefaultInstance(properties);
	}

	public void sendEmail(){

		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("guardarropasztbcs@gmail.com"));//EMISOR
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.email));//RECEPTOR
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("behringertomas@gmail.com"));//RECEPTOR
			message.setSubject("Que me Pongo APP recordatorio");
			message.setText("Sugerencias listas, pase por el guardarropas");
			Transport t = session.getTransport("smtp");
			t.connect("guardarropasztbcs", "ztbcsztbcs");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
			me.printStackTrace();
			return;
		}
		
	}	
	
	public void sendEmailAlerta(){

		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("guardarropasztbcs@gmail.com"));//EMISOR
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.email));//RECEPTOR
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("behringertomas@gmail.com"));//RECEPTOR
			message.setSubject("Cambio Brusco de Temperatura");
			message.setText("Nueva sugerencia emitida.");
			Transport t = session.getTransport("smtp");
			t.connect("guardarropasztbcs", "ztbcsztbcs");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
			me.printStackTrace();
			return;
		}
		
	}

	
}
