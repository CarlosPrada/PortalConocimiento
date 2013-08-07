package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.LineasInvestigador;
import uis.giib.entidades.Proyecto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(LineaInvestigacion.class)
public class LineaInvestigacion_ { 

    public static volatile SingularAttribute<LineaInvestigacion, Integer> idLineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacion, String> descripcionLineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacion, String> nombreLineaInvestigacion;
    public static volatile CollectionAttribute<LineaInvestigacion, LineasInvestigador> lineasInvestigadorCollection;
    public static volatile CollectionAttribute<LineaInvestigacion, Proyecto> proyectoCollection;
    public static volatile SingularAttribute<LineaInvestigacion, Character> eliminadoLineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacion, Character> estadoLineaInvestigacion;

}