package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.ProyectoInvestigadores;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile CollectionAttribute<Rol, ProyectoInvestigadores> proyectoInvestigadoresCollection;
    public static volatile SingularAttribute<Rol, String> nombreRol;
    public static volatile SingularAttribute<Rol, String> descripcionRol;
    public static volatile SingularAttribute<Rol, Character> estadoRol;
    public static volatile SingularAttribute<Rol, Integer> idRol;

}