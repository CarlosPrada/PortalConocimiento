package uis.giib.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.EstadoProyecto;
import uis.giib.entidades.LineaInvestigacion;
import uis.giib.entidades.Producto;
import uis.giib.entidades.ProyectoInvestigadores;
import uis.giib.entidades.TipoProyecto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Character> eliminadoProyecto;
    public static volatile SingularAttribute<Proyecto, String> nombreProyecto;
    public static volatile SingularAttribute<Proyecto, Date> fechaEdicion;
    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile SingularAttribute<Proyecto, String> usuarioCreacion;
    public static volatile SingularAttribute<Proyecto, EstadoProyecto> idEstadoProyecto;
    public static volatile SingularAttribute<Proyecto, String> usuarioEdicion;
    public static volatile ListAttribute<Proyecto, ProyectoInvestigadores> proyectoInvestigadoresList;
    public static volatile ListAttribute<Proyecto, Producto> productoList;
    public static volatile SingularAttribute<Proyecto, String> descripcionProyecto;
    public static volatile SingularAttribute<Proyecto, Date> fechaCreacion;
    public static volatile SingularAttribute<Proyecto, Character> estadoProyecto;
    public static volatile SingularAttribute<Proyecto, LineaInvestigacion> idLinea;
    public static volatile SingularAttribute<Proyecto, TipoProyecto> idTipoProyecto;

}