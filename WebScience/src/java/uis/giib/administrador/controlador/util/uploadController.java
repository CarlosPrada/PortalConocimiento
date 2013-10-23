package uis.giib.administrador.controlador.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 *  * @author Carlos David Prada Remolina  * @version 1.0  * @since 10/10/2013
 */
@Named(value = "uploadC")
@SessionScoped
public class uploadController implements Serializable {

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        InputStream is;
        try {
            File file = new File("C:\\****\\*****\\Documents\\NetBeansProjects\\EventsCalendary\\web\\resources\\images\\uploadPhoto.png");
            is = event.getFile().getInputstream();
            OutputStream os = new FileOutputStream(file);
            setUserPhoto("\\EventsCalendary\\resources\\images\\" + file.getName());
            byte buf[] = new byte[1024];
            int len;
            while ((len = is.read(buf)) > 0) {
                os.write(buf, 0, len);
            }
            os.close();
            is.close();

        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    public void setUserPhoto(String photoPath) {
        FacesContext context = FacesContext.getCurrentInstance();
        //ClientBean client = (ClientBean) context.getApplication().evaluateExpressionGet(context, "#{clientBean}", ClientBean.class);
        //client.getClient().setPhoto(photoPath);
    }
}
