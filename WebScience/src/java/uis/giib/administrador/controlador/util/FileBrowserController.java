package uis.giib.administrador.controlador.util;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import javax.inject.Named;  
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "fileBrowserController")
@SessionScoped
public class FileBrowserController implements Serializable {  
  
    private UploadedFile file;  
  
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
  
    public void upload() {  
        if(file != null) {  
            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }  
}  
