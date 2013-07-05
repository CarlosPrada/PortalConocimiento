package uis.giib.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uis.giib.entidades.Proyecto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-03T21:43:04")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcionProducto;
    public static volatile SingularAttribute<Producto, String> usuarioEdicion;
    public static volatile SingularAttribute<Producto, Character> estadoProducto;
    public static volatile SingularAttribute<Producto, Date> fechaEdicion;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Character> eliminadoProducto;
    public static volatile SingularAttribute<Producto, Proyecto> idProyecto;
    public static volatile SingularAttribute<Producto, Date> fechaCreacion;
    public static volatile SingularAttribute<Producto, String> nombreProducto;
    public static volatile SingularAttribute<Producto, String> usuarioCreacion;

}