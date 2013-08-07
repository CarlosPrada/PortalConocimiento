package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.Proyecto;
import uis.giib.entidades.ProyectoInvestigadoresPK;
import uis.giib.entidades.Rol;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(ProyectoInvestigadores.class)
public class ProyectoInvestigadores_ { 

    public static volatile SingularAttribute<ProyectoInvestigadores, ProyectoInvestigadoresPK> proyectoInvestigadoresPK;
    public static volatile SingularAttribute<ProyectoInvestigadores, Proyecto> proyecto;
    public static volatile SingularAttribute<ProyectoInvestigadores, Rol> idRol;
    public static volatile SingularAttribute<ProyectoInvestigadores, Investigador> investigador;

}