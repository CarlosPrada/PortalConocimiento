package uis.giib.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Recursos;
import uis.giib.entidades.Seccion;
import uis.giib.entidades.TipoPublicacion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(Publicacion.class)
public class Publicacion_ { 

    public static volatile SingularAttribute<Publicacion, Date> fechaFineventoPublicacion;
    public static volatile SingularAttribute<Publicacion, Date> fechaEdicion;
    public static volatile SingularAttribute<Publicacion, String> contenidoPublicacion;
    public static volatile SingularAttribute<Publicacion, Date> fechaInicioeventoPublicacion;
    public static volatile SingularAttribute<Publicacion, Character> eliminadoPublicacion;
    public static volatile SingularAttribute<Publicacion, String> usuarioCreacion;
    public static volatile SingularAttribute<Publicacion, TipoPublicacion> idTipoPublicacion;
    public static volatile SingularAttribute<Publicacion, String> usuarioEdicion;
    public static volatile SingularAttribute<Publicacion, Date> fechaDespublicarPublicacion;
    public static volatile SingularAttribute<Publicacion, Seccion> idSeccion;
    public static volatile SingularAttribute<Publicacion, Integer> idMultimedia;
    public static volatile SingularAttribute<Publicacion, Character> estadoPublicacion;
    public static volatile SingularAttribute<Publicacion, Integer> idPublicacion;
    public static volatile SingularAttribute<Publicacion, Date> fechaCreacion;
    public static volatile ListAttribute<Publicacion, Recursos> recursosList;

}