package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.LineasInvestigador;
import uis.giib.entidades.Permiso;
import uis.giib.entidades.ProduccionIntelectual;
import uis.giib.entidades.ProyectoInvestigadores;
import uis.giib.entidades.TipoInvestigador;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-06T17:59:54")
@StaticMetamodel(Investigador.class)
public class Investigador_ { 

    public static volatile SingularAttribute<Investigador, String> imageInvestigadorPath;
    public static volatile SingularAttribute<Investigador, String> usuarioInvestigador;
    public static volatile SingularAttribute<Investigador, String> correoInvestigador;
    public static volatile SingularAttribute<Investigador, String> telefonoInvestigador;
    public static volatile ListAttribute<Investigador, ProduccionIntelectual> produccionIntelectualList;
    public static volatile SingularAttribute<Investigador, String> nombreInvestigador;
    public static volatile SingularAttribute<Investigador, String> celularInvestigador;
    public static volatile SingularAttribute<Investigador, String> generoInvestigador;
    public static volatile ListAttribute<Investigador, LineasInvestigador> lineasInvestigadorList;
    public static volatile SingularAttribute<Investigador, TipoInvestigador> idTipoInvestigador;
    public static volatile SingularAttribute<Investigador, Character> eliminadoInvestigador;
    public static volatile SingularAttribute<Investigador, String> cvlacInvestigador;
    public static volatile ListAttribute<Investigador, ProyectoInvestigadores> proyectoInvestigadoresList;
    public static volatile SingularAttribute<Investigador, String> contrasenaInvestigador;
    public static volatile SingularAttribute<Investigador, Permiso> idNivelPermiso;
    public static volatile SingularAttribute<Investigador, Character> estadoInvestigador;
    public static volatile SingularAttribute<Investigador, String> apellidoInvestigador;
    public static volatile SingularAttribute<Investigador, String> tituloInvestigador;
    public static volatile SingularAttribute<Investigador, String> informacionInvestigador;

}