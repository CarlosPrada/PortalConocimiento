package uis.giib.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.Proyecto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(LineaInvestigacion.class)
public class LineaInvestigacion_ { 

    public static volatile SingularAttribute<LineaInvestigacion, Integer> idLineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacion, String> usuarioEdicion;
    public static volatile SingularAttribute<LineaInvestigacion, String> descripcionLineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacion, Date> fechaEdicion;
    public static volatile ListAttribute<LineaInvestigacion, Proyecto> proyectoList;
    public static volatile SingularAttribute<LineaInvestigacion, String> nombreLineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacion, Date> fechaCreacion;
    public static volatile SingularAttribute<LineaInvestigacion, Character> eliminadoLineaInvestigacion;
    public static volatile ListAttribute<LineaInvestigacion, Investigador> investigadorList;
    public static volatile SingularAttribute<LineaInvestigacion, Character> estadoLineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacion, String> usuarioCreacion;

}