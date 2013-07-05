package uis.giib.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Publicacion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(Seccion.class)
public class Seccion_ { 

    public static volatile SingularAttribute<Seccion, String> usuarioEdicion;
    public static volatile SingularAttribute<Seccion, String> nombreSeccion;
    public static volatile SingularAttribute<Seccion, Integer> idSeccion;
    public static volatile SingularAttribute<Seccion, Character> eliminadoSeccion;
    public static volatile SingularAttribute<Seccion, Date> fechaEdicion;
    public static volatile SingularAttribute<Seccion, Date> fechaCreacion;
    public static volatile SingularAttribute<Seccion, Character> estadoSeccion;
    public static volatile SingularAttribute<Seccion, String> usuarioCreacion;
    public static volatile ListAttribute<Seccion, Publicacion> publicacionList;

}