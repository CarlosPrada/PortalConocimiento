package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Publicacion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(Seccion.class)
public class Seccion_ { 

    public static volatile SingularAttribute<Seccion, String> nombreSeccion;
    public static volatile SingularAttribute<Seccion, Integer> idSeccion;
    public static volatile SingularAttribute<Seccion, Character> eliminadoSeccion;
    public static volatile SingularAttribute<Seccion, Character> estadoSeccion;
    public static volatile CollectionAttribute<Seccion, Publicacion> publicacionCollection;

}