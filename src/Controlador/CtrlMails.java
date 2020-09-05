/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultaProducto;
import Vista.frmSupermercado;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author JorgeG
 */
public class CtrlMails {
    ConsultaProducto productoConsulta = new ConsultaProducto();
    frmSupermercado frm = new frmSupermercado();
    
    public CtrlMails(frmSupermercado frm){
        this.frm = frm;
        
    }
    
        public void enviarCorreo() {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "jgonzalezc42@miumg.edu.gt";
            String passwordRemitente = "odamaplaya3";
            String correoReceptor = frm.txtCorreo.getText();
            String asunto = "FELIZ MESANIVERSARIO MI REINA HERMOSAAAAAAAA";
            String mensaje = "Mi vida hermosa <br> <b>TE AMO CON TODO MI CORAZONCITOOOO</b><br><br>"
                    + " <b> GRACIAS POR PASAR A MI LADO OTRO MESSSSSSS MI VIDA PRECIOSAAAAA</b>"
                    + "<br> <b> CADA DÍA QUE PASO A TU LADO TE AMO MÁSSSSSSSSS</b>"
                    + "<br> <b> ESPERO ALEGRAR TODOS TUS DÍAS TANTO COMO TÚU ALEGRAS LOS MÍOSSS MI PRINCESITA HERMOSAAAAAAAA</b>";

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");

        } catch (AddressException ex) {
            Logger.getLogger(CtrlMails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CtrlMails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarCorreoAdjunto() {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "jgonzalezc42@miumg.edu.gt";
            String passwordRemitente = "odamaplaya3";
            String correoReceptor = frm.txtCorreo.getText();
            String asunto = "Correo en java - test";
            String mensaje = "Hola<br>Este es el contenido de prueba<b>java</b><br><br>"
                    + "por <b> Códigos de PRogramación </b>";

            BodyPart texto = new MimeBodyPart();
            texto.setContent(mensaje, "text/html");

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/Users/JorgeG/productosreporte.pdf")));
            adjunto.setFileName("reporte.pdf");

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");

        } catch (AddressException ex) {
            Logger.getLogger(CtrlMails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CtrlMails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void enviarCorreoMasivo() {
        String[] correos_destinos = productoConsulta.masivo();
        try {

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "jgonzalezc42@miumg.edu.gt";
            String passwordRemitente = "odamaplaya3";
            String asunto = "Correo en java - test";
            String mensaje = "Hola<br>Este es el contenido de prueba<b>java</b><br><br>"
                    + "por <b> Códigos de PRogramación </b>";

            BodyPart texto = new MimeBodyPart();
            texto.setContent(mensaje, "text/html");

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/Users/JorgeG/productosreporte.pdf")));
            adjunto.setFileName("reporte.pdf");

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            Address[] receptores = new Address[correos_destinos.length];
            int j = 0;
            while (j < correos_destinos.length) {
                receptores[j] = new InternetAddress(correos_destinos[j]);
                j++;
            }

            message.addRecipients(Message.RecipientType.TO, receptores);
            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");

        } catch (AddressException ex) {
            Logger.getLogger(CtrlMails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CtrlMails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
