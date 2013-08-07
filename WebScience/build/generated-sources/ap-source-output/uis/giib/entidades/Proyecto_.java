package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.EstadoProyecto;
import uis.giib.entidades.LineaInvestigacion;
import uis.giib.entidades.TipoProyecto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcionDetalladaProyecto;
    public static volatile SingularAttribute<Proyecto, EstadoProyecto> idEstadoProyecto;
    public static volatile SingularAttribute<Proyecto, Character> eliminadoProyecto;
    public static volatile SingularAttribute<Proyecto, String> objetivosProyecto;
    public static volatile SingularAttribute<Proyecto, String> nombreProyecto;
    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile SingularAttribute<Proyecto, String> descripcionResumidaProyecto;
    public static volatile SingularAttribute<Proyecto, Character> estadoProyecto;
    public static volatile SingularAttribute<Proyecto, TipoProyecto> idTipoProyecto;
    public static volatile SingularAttribute<Proyecto, LineaInvestigacion> idLinea;
    public static volatile SingularAttribute<Proyecto, String> resultadosProyecto;

}