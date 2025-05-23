package Control;

import Vista.Mensaje;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class ControlEmail {
    private Control control;

    public void transferirimail(String correo) {
        String correoEnvia = "aguilar.danna0405@gmail.com";
        String contrasena = "glgi nvuk ppms klmp";
        String mensaje = "USUARIO REGISTRADO CON ÉXITO";

        Properties objectPEC = new Properties();
        objectPEC.put("mail.smtp.host", "smtp.gamil.com");
        objectPEC.setProperty("mail.smtp.starttls.enable", "true");
        objectPEC.put("mail.smtp.port", "587");
        objectPEC.setProperty("mail.smtp.port", "587");
        objectPEC.put("mail.smtp.user", correoEnvia);
        objectPEC.setProperty("mail.smtp.auth", "true");
        objectPEC.setProperty("mail.smtp.host", "smtp.gmail.com");

        Session sesion = Session.getDefaultInstance(objectPEC);
        MimeMessage mail = new MimeMessage(sesion);

        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mail.setSubject("REGISTRO USUARIO");
            mail.setText(mensaje);

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            Mensaje.mostrarMensaje("CORREO ENVIADO");
        } catch (Exception e) {
            Mensaje.mostrarMensaje("ERROR AL MANDAR EL CORREO");
        }
    }
}
