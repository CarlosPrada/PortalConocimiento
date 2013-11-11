package uis.giib.administrador.controlador.util;

import javax.inject.Named;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Carlos David Prada remolina
 * @version 1.0
 * @since 01/10/2013
 */
@Named(value = "fileUploadC")
@SessionScoped
public class FileUploadController implements Serializable {

    //Atributos
    private String destination = "C:\\ImagenPortal\\";
    private String fileName;
    private String fileNameHistoria;
    private String fileNameRazon;
    private String fileNameRelaciones;

    /**
     * Constructor
     */
    public FileUploadController() {
    }

    /**
     * Método que captura el evento de subir una imagen al servidor. De la
     * imagen extrae su nombre.
     *
     * @param event evento disparado cuando el usuario intenta subir una imagen
     * al servidor
     */
    public void upload(FileUploadEvent event) {
//        FacesContext.getCurrentInstance().addMessage(
//                null,
//                new FacesMessage(FacesMessage.SEVERITY_WARN,
//                "Bienvenido",
//                "¡Ha vuelto! Le estamos esperando"));


        fileName = event.getFile().getFileName();
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("imagenCargada"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que captura el evento de subir una imagen al servidor. De la
     * imagen extrae su nombre.
     *
     * @param event evento disparado cuando el usuario intenta subir una imagen
     * al servidor
     */
    public void uploadContentHistoria(FileUploadEvent event) {

//        FacesMessage facesMessage = new FacesMessage("Imagen Cargada!", "Imagen cargada exitosamente!");
//        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        fileNameHistoria = event.getFile().getFileName();
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que captura el evento de subir una imagen al servidor. De la
     * imagen extrae su nombre.
     *
     * @param event evento disparado cuando el usuario intenta subir una imagen
     * al servidor
     */
    public void uploadContentRazon(FileUploadEvent event) {

//        FacesMessage facesMessage = new FacesMessage("Imagen Cargada!", "Imagen cargada exitosamente!");
//        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        fileNameRazon = event.getFile().getFileName();
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que captura el evento de subir una imagen al servidor. De la
     * imagen extrae su nombre.
     *
     * @param event evento disparado cuando el usuario intenta subir una imagen
     * al servidor
     */
    public void uploadContentRelaciones(FileUploadEvent event) {

//        FacesMessage facesMessage = new FacesMessage("Imagen Cargada!", "Imagen cargada exitosamente!");
//        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        fileNameRelaciones = event.getFile().getFileName();
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que copia la imagen a ser subida la servido en la carpeta
     * especificada por el String 'destination'
     *
     * @param fileName Nombre de la imagen a ser copiada
     * @param in InputStream
     */
    public void copyFile(String fileName, InputStream in) {

        try {
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @PostConstruct
    public void inicializacion() {
        this.fileName = null;
    }

    //Getters - Setters
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameHistoria() {
        return fileNameHistoria;
    }

    public void setFileNameHistoria(String fileNameHistoria) {
        this.fileNameHistoria = fileNameHistoria;
    }

    public String getFileNameRazon() {
        return fileNameRazon;
    }

    public void setFileNameRazon(String fileNameRazon) {
        this.fileNameRazon = fileNameRazon;
    }

    public String getFileNameRelaciones() {
        return fileNameRelaciones;
    }

    public void setFileNameRelaciones(String fileNameRelaciones) {
        this.fileNameRelaciones = fileNameRelaciones;
    }
}
