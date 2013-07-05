package uis.giib.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.LineaInvestigacion;
import uis.giib.entidades.Permiso;
import uis.giib.entidades.ProyectoInvestigadores;
import uis.giib.entidades.TipoInvestigador;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(Investigador.class)
public class Investigador_ { 

    public static volatile SingularAttribute<Investigador, String> usuarioInvestigador;
    public static volatile SingularAttribute<Investigador, String> correoInvestigador;
    public static volatile SingularAttribute<Investigador, Date> fechaEdicion;
    public static volatile SingularAttribute<Investigador, String> telefonoInvestigador;
    public static volatile SingularAttribute<Investigador, String> nombreInvestigador;
    public static volatile SingularAttribute<Investigador, String> celularInvestigador;
    public static volatile SingularAttribute<Investigador, String> generoInvestigador;
    public static volatile SingularAttribute<Investigador, String> usuarioCreacion;
    public static volatile SingularAttribute<Investigador, TipoInvestigador> idTipoInvestigador;
    public static volatile SingularAttribute<Investigador, String> usuarioEdicion;
    public static volatile SingularAttribute<Investigador, Character> eliminadoInvestigador;
    public static volatile SingularAttribute<Investigador, String> cvlacInvestigador;
    public static volatile ListAttribute<Investigador, ProyectoInvestigadores> proyectoInvestigadoresList;
    public static volatile SingularAttribute<Investigador, String> contrasenaInvestigador;
    public static volatile SingularAttribute<Investigador, Permiso> idNivelPermiso;
    public static volatile SingularAttribute<Investigador, Character> estadoInvestigador;
    public static volatile SingularAttribute<Investigador, Date> fechaCreacion;
    public static volatile ListAttribute<Investigador, LineaInvestigacion> lineaInvestigacionList;
    public static volatile SingularAttribute<Investigador, String> informacionInvestigador;

}