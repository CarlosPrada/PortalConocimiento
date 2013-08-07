package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Investigador;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(Permiso.class)
public class Permiso_ { 

    public static volatile SingularAttribute<Permiso, Integer> idPermiso;
    public static volatile SingularAttribute<Permiso, String> descripcionPermiso;
    public static volatile CollectionAttribute<Permiso, Investigador> investigadorCollection;
    public static volatile SingularAttribute<Permiso, String> nombrePermiso;

}