package uis.giib.portal.controlador;

import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import uis.giib.entidades.Contacto;
/**
 *
 *  * @author Carlos David Prada Remolina  * @version 1.0  * @since 10/10/2013
 */
@Named(value = "contactoPC")
@RequestScoped
public class contactoPortalController implements Serializable {

    // Atributos
    private String nombre;
    private String correo;
    private String asunto;
    private String mensaje;
    private Contacto emisor;
    private Contacto recibeCorreo1;
    private Contacto recibeCorreo2;
    private Contacto recibeCorreo3;
    private Contacto recibeCorreo4;
    private Contacto recibeCorreo5;
    private boolean render = true;
    @EJB
    private uis.giib.administrador.dao.ContactoFacade ejbContacto;

    //Constructor
    public contactoPortalController() {
    }

    //Métodos de navegación
    public String goContacto() {
        return "/portal/contacto.xhtml?faces-redirect=true";
    }

    public void sendMail() {

        emisor = ejbContacto.buscarPorIDContacto("Emisor");
        recibeCorreo1 = ejbContacto.buscarPorIDContacto("RecibeCorreo1");
        recibeCorreo2 = ejbContacto.buscarPorIDContacto("RecibeCorreo2");
        recibeCorreo3 = ejbContacto.buscarPorIDContacto("RecibeCorreo3");
        recibeCorreo4 = ejbContacto.buscarPorIDContacto("RecibeCorreo4");
        recibeCorreo5 = ejbContacto.buscarPorIDContacto("RecibeCorreo5");
        Email email = new SimpleEmail();

        try {
            String correoRemitente = emisor.getCorreoElectronico();
            String password = emisor.getContrasena();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(correoRemitente, password));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.getMailSession().getProperties().put("mail.smtps.auth", "true");
            email.getMailSession().getProperties().put("mail.debug", "true");
            email.getMailSession().getProperties().put("mail.smtps.port", "587");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
            email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
            email.setFrom(correo, nombre);
            email.setSubject(asunto);
            email.setMsg("Dirección de Correo: " + correo
                    + "\n\nNombre de Remitente: " + nombre
                    + "\n\nAsunto : " + asunto + "\n\n"
                    + mensaje);
            email.addTo(recibeCorreo1.getCorreoElectronico(), "Grupo GIIB");
            email.addTo(recibeCorreo2.getCorreoElectronico(), "Grupo GIIB");
            email.addTo(recibeCorreo3.getCorreoElectronico(), "Grupo GIIB");
            email.addTo(recibeCorreo4.getCorreoElectronico(), "Grupo GIIB");
            email.addTo(recibeCorreo5.getCorreoElectronico(), "Grupo GIIB");
            email.send();
            render = false;
        } catch (EmailException e) {
            System.out.println("Eror de mail" + e.getMessage() + "." + e.getLocalizedMessage());
        }
    }

    //Getters - Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Contacto getEmisor() {
        return emisor;
    }

    public void setEmisor(Contacto emisor) {
        this.emisor = emisor;
    }

    public Contacto getRecibeCorreo1() {
        return recibeCorreo1;
    }

    public void setRecibeCorreo1(Contacto recibeCorreo1) {
        this.recibeCorreo1 = recibeCorreo1;
    }

    public Contacto getRecibeCorreo2() {
        return recibeCorreo2;
    }

    public void setRecibeCorreo2(Contacto recibeCorreo2) {
        this.recibeCorreo2 = recibeCorreo2;
    }

    public Contacto getRecibeCorreo3() {
        return recibeCorreo3;
    }

    public void setRecibeCorreo3(Contacto recibeCorreo3) {
        this.recibeCorreo3 = recibeCorreo3;
    }

    public Contacto getRecibeCorreo4() {
        return recibeCorreo4;
    }

    public void setRecibeCorreo4(Contacto recibeCorreo4) {
        this.recibeCorreo4 = recibeCorreo4;
    }

    public Contacto getRecibeCorreo5() {
        return recibeCorreo5;
    }

    public void setRecibeCorreo5(Contacto recibeCorreo5) {
        this.recibeCorreo5 = recibeCorreo5;
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public uis.giib.administrador.dao.ContactoFacade getEjbContacto() {
        return ejbContacto;
    }

    public void setEjbContacto(uis.giib.administrador.dao.ContactoFacade ejbContacto) {
        this.ejbContacto = ejbContacto;
    }
}
