package uis.giib.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Investigador;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(TipoInvestigador.class)
public class TipoInvestigador_ { 

    public static volatile SingularAttribute<TipoInvestigador, Integer> idTipoInvestigador;
    public static volatile SingularAttribute<TipoInvestigador, String> nombreTipoInvestigador;
    public static volatile ListAttribute<TipoInvestigador, Investigador> investigadorList;
    public static volatile SingularAttribute<TipoInvestigador, String> descripcionTipoInvestigador;

}