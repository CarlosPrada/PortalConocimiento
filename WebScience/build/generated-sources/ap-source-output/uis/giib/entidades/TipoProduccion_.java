package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.ProduccionIntelectual;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(TipoProduccion.class)
public class TipoProduccion_ { 

    public static volatile SingularAttribute<TipoProduccion, Integer> idTipoProduccion;
    public static volatile SingularAttribute<TipoProduccion, String> nombreTipoProduccion;
    public static volatile CollectionAttribute<TipoProduccion, ProduccionIntelectual> produccionIntelectualCollection;
    public static volatile SingularAttribute<TipoProduccion, Character> estadoTipoProduccion;

}