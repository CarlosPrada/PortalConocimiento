package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Publicacion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(TipoPublicacion.class)
public class TipoPublicacion_ { 

    public static volatile SingularAttribute<TipoPublicacion, Integer> idTipoPublicacion;
    public static volatile SingularAttribute<TipoPublicacion, String> nombreTipoPublicacion;
    public static volatile ListAttribute<TipoPublicacion, Publicacion> publicacionList;

}