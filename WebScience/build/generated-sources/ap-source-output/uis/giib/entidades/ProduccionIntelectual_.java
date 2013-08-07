package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.TipoProduccion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(ProduccionIntelectual.class)
public class ProduccionIntelectual_ { 

    public static volatile SingularAttribute<ProduccionIntelectual, TipoProduccion> idTipoProduccion;
    public static volatile SingularAttribute<ProduccionIntelectual, Investigador> idAutorProduccion;
    public static volatile SingularAttribute<ProduccionIntelectual, Integer> idProduccion;
    public static volatile SingularAttribute<ProduccionIntelectual, String> nombreProduccion;
    public static volatile SingularAttribute<ProduccionIntelectual, String> referenciaProduccion;
    public static volatile SingularAttribute<ProduccionIntelectual, Integer> agnoProduccion;
    public static volatile SingularAttribute<ProduccionIntelectual, Character> estadoProduccion;

}