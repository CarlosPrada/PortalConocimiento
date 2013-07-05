package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Proyecto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(EstadoProyecto.class)
public class EstadoProyecto_ { 

    public static volatile SingularAttribute<EstadoProyecto, Integer> idEstadoProyecto;
    public static volatile SingularAttribute<EstadoProyecto, String> nombreEstadoProyecto;
    public static volatile ListAttribute<EstadoProyecto, Proyecto> proyectoList;

}