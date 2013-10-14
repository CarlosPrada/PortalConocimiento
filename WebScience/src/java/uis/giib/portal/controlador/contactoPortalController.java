package uis.giib.portal.controlador;

import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import uis.giib.entidades.Investigador;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "contactoPC")
@RequestScoped
public class contactoPortalController implements Serializable {

    // Atributos
    private String nombre;
    private String correo;
    private String asunto;
    private String mensaje;
    private Investigador contacto;
    private boolean render = true;
    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade ejbInvestigador;

    //Constructor
    public contactoPortalController() {
    }

    //Métodos de navegación
    public String goContacto() {

        return "/portal/contacto.xhtml?faces-redirect=true";
    }

    public void sendMail() {

        contacto = ejbInvestigador.buscarPorIDUsuario("contacto");
        Email email = new SimpleEmail();

        try {
            String correoRemitente = contacto.getCorreoInvestigador();
            String password = contacto.getContrasenaInvestigador();
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
            email.addTo("carlos.prada.remolina@gmail.com", "Grupo GIIB");
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Investigador getContacto() {
        return contacto;
    }

    public void setContacto(Investigador contacto) {
        this.contacto = contacto;
    }

    public uis.giib.administrador.dao.InvestigadorFacade getEjbInvestigador() {
        return ejbInvestigador;
    }

    public void setEjbInvestigador(uis.giib.administrador.dao.InvestigadorFacade ejbInvestigador) {
        this.ejbInvestigador = ejbInvestigador;
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }
}
