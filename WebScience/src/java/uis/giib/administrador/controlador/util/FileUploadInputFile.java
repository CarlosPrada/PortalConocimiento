package uis.giib.administrador.controlador.util;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

/**
 *
 * @author Carlos
 */
@Named(value = "fileUploadC2")
@ViewScoped
public class FileUploadInputFile implements Serializable {

    private Part file1;

    public String upload() throws IOException {

        System.out.println("hola q ase upload");

        file1.write("lib/../" + getFilename(file1));

        System.out.println("hola q ase upload2");
        System.out.println(new File("file1").getAbsolutePath());
        return "index";
    }

    private static String getFilename(Part part) {

        System.out.println("hola q ase filename");

        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

    //Getters - Setters
    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }
}