package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Recursos;
import uis.giib.entidades.TipoMultimedia;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(Multimedia.class)
public class Multimedia_ { 

    public static volatile SingularAttribute<Multimedia, Character> eliminadoMultimedia;
    public static volatile SingularAttribute<Multimedia, Integer> idMultimedia;
    public static volatile SingularAttribute<Multimedia, String> urlTipoMultimedia;
    public static volatile SingularAttribute<Multimedia, TipoMultimedia> idTipoMultimedia;
    public static volatile SingularAttribute<Multimedia, String> nombreMultimedia;
    public static volatile SingularAttribute<Multimedia, Character> estadoMultimedia;
    public static volatile CollectionAttribute<Multimedia, Recursos> recursosCollection;

}