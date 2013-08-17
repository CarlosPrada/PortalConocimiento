/*
SQLyog Ultimate v9.02 
MySQL - 5.6.12-log : Database - portal_data_base
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`portal_data_base` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `portal_data_base`;

/*Table structure for table `estado_proyecto` */

DROP TABLE IF EXISTS `estado_proyecto`;

CREATE TABLE `estado_proyecto` (
  `id_estado_proyecto` int(11) NOT NULL,
  `nombre_estado_proyecto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_estado_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estado_proyecto` */

/*Table structure for table `investigador` */

DROP TABLE IF EXISTS `investigador`;

CREATE TABLE `investigador` (
  `usuario_investigador` varchar(30) NOT NULL,
  `contrasena_investigador` varchar(20) NOT NULL,
  `nombre_investigador` varchar(50) NOT NULL,
  `informacion_investigador` text NOT NULL,
  `telefono_investigador` varchar(15) DEFAULT NULL,
  `celular_investigador` varchar(10) DEFAULT NULL,
  `correo_investigador` varchar(50) NOT NULL,
  `genero_investigador` varchar(50) NOT NULL,
  `cvlac_investigador` varchar(100) DEFAULT NULL,
  `id_tipo_investigador` int(11) NOT NULL,
  `id_nivel_permiso` int(11) NOT NULL,
  `estado_investigador` char(1) DEFAULT 'A',
  `eliminado_investigador` char(1) DEFAULT NULL,
  PRIMARY KEY (`usuario_investigador`),
  KEY `FK_investigador` (`id_nivel_permiso`),
  KEY `FK_investigador_tipo` (`id_tipo_investigador`),
  CONSTRAINT `FK_investigador` FOREIGN KEY (`id_nivel_permiso`) REFERENCES `permiso` (`id_permiso`),
  CONSTRAINT `FK_investigador_id_nivel_permiso` FOREIGN KEY (`id_nivel_permiso`) REFERENCES `permiso` (`id_permiso`),
  CONSTRAINT `FK_investigador_id_tipo_investigador` FOREIGN KEY (`id_tipo_investigador`) REFERENCES `tipo_investigador` (`id_tipo_investigador`),
  CONSTRAINT `FK_investigador_tipo` FOREIGN KEY (`id_tipo_investigador`) REFERENCES `tipo_investigador` (`id_tipo_investigador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `investigador` */

insert  into `investigador`(`usuario_investigador`,`contrasena_investigador`,`nombre_investigador`,`informacion_investigador`,`telefono_investigador`,`celular_investigador`,`correo_investigador`,`genero_investigador`,`cvlac_investigador`,`id_tipo_investigador`,`id_nivel_permiso`,`estado_investigador`,`eliminado_investigador`) values ('admin','admin','Carlos Humberto','','111','222','casa','M','No',1,1,'A',''),('diana','diana','Diana Milena','Ninguna','133','212','otro','M','Si',1,1,'A',''),('jose','1234','Sonia Gamboa','<p>\r\n	AA</p>\r\n','343','343','3434','F','No',2,1,'A',NULL),('sonia','1234','Sonia Gamboa','<p>\r\n	AAA</p>\r\n','343','343','3434','F','No',1,1,'A',NULL);

/*Table structure for table `linea_investigacion` */

DROP TABLE IF EXISTS `linea_investigacion`;

CREATE TABLE `linea_investigacion` (
  `id_linea_investigacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_linea_investigacion` varchar(50) NOT NULL,
  `descripcion_linea_investigacion` varchar(150) NOT NULL,
  `estado_linea_investigacion` char(1) DEFAULT 'A',
  `eliminado_linea_investigacion` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_linea_investigacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `linea_investigacion` */

insert  into `linea_investigacion`(`id_linea_investigacion`,`nombre_linea_investigacion`,`descripcion_linea_investigacion`,`estado_linea_investigacion`,`eliminado_linea_investigacion`) values (1,'Bioinformática','Bioinformática','A',NULL),(2,'IA','IA','A',NULL);

/*Table structure for table `lineas_investigador` */

DROP TABLE IF EXISTS `lineas_investigador`;

CREATE TABLE `lineas_investigador` (
  `id_linea` int(11) NOT NULL,
  `id_investigador` varchar(30) NOT NULL,
  PRIMARY KEY (`id_linea`,`id_investigador`),
  KEY `FK_lineas_investigador` (`id_investigador`),
  CONSTRAINT `FK_lineas_investigacion` FOREIGN KEY (`id_linea`) REFERENCES `linea_investigacion` (`id_linea_investigacion`),
  CONSTRAINT `FK_lineas_investigador` FOREIGN KEY (`id_investigador`) REFERENCES `investigador` (`usuario_investigador`),
  CONSTRAINT `FK_lineas_investigador_id_investigador` FOREIGN KEY (`id_investigador`) REFERENCES `investigador` (`usuario_investigador`),
  CONSTRAINT `FK_lineas_investigador_id_linea_investigacion` FOREIGN KEY (`id_linea`) REFERENCES `linea_investigacion` (`id_linea_investigacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `lineas_investigador` */

/*Table structure for table `multimedia` */

DROP TABLE IF EXISTS `multimedia`;

CREATE TABLE `multimedia` (
  `id_multimedia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_multimedia` varchar(50) NOT NULL,
  `id_tipo_multimedia` int(11) NOT NULL,
  `url_tipo_multimedia` varchar(400) NOT NULL,
  `estado_multimedia` char(1) NOT NULL DEFAULT 'A',
  `eliminado_multimedia` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_multimedia`),
  KEY `FK_multimedia` (`id_tipo_multimedia`),
  CONSTRAINT `FK_multimedia` FOREIGN KEY (`id_tipo_multimedia`) REFERENCES `tipo_multimedia` (`id_tipo_multimedia`),
  CONSTRAINT `FK_multimedia_id_tipo_multimedia` FOREIGN KEY (`id_tipo_multimedia`) REFERENCES `tipo_multimedia` (`id_tipo_multimedia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `multimedia` */

/*Table structure for table `permiso` */

DROP TABLE IF EXISTS `permiso`;

CREATE TABLE `permiso` (
  `id_permiso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_permiso` varchar(30) NOT NULL,
  `descripcion_permiso` varchar(150) NOT NULL,
  PRIMARY KEY (`id_permiso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `permiso` */

insert  into `permiso`(`id_permiso`,`nombre_permiso`,`descripcion_permiso`) values (1,'Admin','Administrador');

/*Table structure for table `produccion_intelectual` */

DROP TABLE IF EXISTS `produccion_intelectual`;

CREATE TABLE `produccion_intelectual` (
  `id_produccion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_produccion` varchar(200) NOT NULL,
  `agno_produccion` int(4) NOT NULL,
  `referencia_produccion` text,
  `id_tipo_produccion` int(4) NOT NULL,
  `id_autor_produccion` varchar(30) NOT NULL,
  `estado_produccion` char(1) DEFAULT 'A',
  PRIMARY KEY (`id_produccion`),
  KEY `FK_produccion_intelectual_autor` (`id_autor_produccion`),
  KEY `FK_produccion_intelectual_tipo` (`id_tipo_produccion`),
  CONSTRAINT `FK_produccion_intelectual_autor` FOREIGN KEY (`id_autor_produccion`) REFERENCES `investigador` (`usuario_investigador`),
  CONSTRAINT `FK_produccion_intelectual_tipo` FOREIGN KEY (`id_tipo_produccion`) REFERENCES `tipo_produccion` (`id_tipo_produccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `produccion_intelectual` */

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(40) NOT NULL,
  `descripcion_producto` varchar(200) NOT NULL,
  `id_proyecto` int(11) NOT NULL,
  `estado_producto` char(1) DEFAULT 'A',
  `eliminado_producto` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FK_producto` (`id_proyecto`),
  CONSTRAINT `FK_producto` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`),
  CONSTRAINT `FK_producto_id_proyecto` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

/*Table structure for table `proyecto` */

DROP TABLE IF EXISTS `proyecto`;

CREATE TABLE `proyecto` (
  `id_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_proyecto` varchar(50) NOT NULL,
  `descripcion_proyecto` varchar(200) NOT NULL,
  `id_tipo_proyecto` int(11) NOT NULL,
  `id_estado_proyecto` int(11) NOT NULL,
  `id_linea` int(11) NOT NULL,
  `estado_proyecto` char(1) DEFAULT 'A',
  `eliminado_proyecto` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `FK_proyecto` (`id_linea`),
  KEY `FK_tipo_proyecto` (`id_tipo_proyecto`),
  KEY `FK_proyecto_estado` (`id_estado_proyecto`),
  CONSTRAINT `FK_proyecto` FOREIGN KEY (`id_linea`) REFERENCES `linea_investigacion` (`id_linea_investigacion`),
  CONSTRAINT `FK_proyecto_estado` FOREIGN KEY (`id_estado_proyecto`) REFERENCES `estado_proyecto` (`id_estado_proyecto`),
  CONSTRAINT `FK_proyecto_id_estado_proyecto` FOREIGN KEY (`id_estado_proyecto`) REFERENCES `estado_proyecto` (`id_estado_proyecto`),
  CONSTRAINT `FK_proyecto_id_linea` FOREIGN KEY (`id_linea`) REFERENCES `linea_investigacion` (`id_linea_investigacion`),
  CONSTRAINT `FK_proyecto_id_tipo_proyecto` FOREIGN KEY (`id_tipo_proyecto`) REFERENCES `tipo_proyecto` (`id_tipo_proyecto`),
  CONSTRAINT `FK_tipo_proyecto` FOREIGN KEY (`id_tipo_proyecto`) REFERENCES `tipo_proyecto` (`id_tipo_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proyecto` */

/*Table structure for table `proyecto_investigadores` */

DROP TABLE IF EXISTS `proyecto_investigadores`;

CREATE TABLE `proyecto_investigadores` (
  `id_proyecto_investigacion` int(11) NOT NULL,
  `id_investigador` varchar(30) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_proyecto_investigacion`,`id_investigador`),
  KEY `FK_proyecto_investigadores_rol` (`id_rol`),
  KEY `FK_investigadores_proyecto` (`id_investigador`),
  CONSTRAINT `FK_investigadores_proyecto` FOREIGN KEY (`id_investigador`) REFERENCES `investigador` (`usuario_investigador`),
  CONSTRAINT `FK_proyecto_investigadores` FOREIGN KEY (`id_proyecto_investigacion`) REFERENCES `proyecto` (`id_proyecto`),
  CONSTRAINT `FK_proyecto_investigadores_id_investigador` FOREIGN KEY (`id_investigador`) REFERENCES `investigador` (`usuario_investigador`),
  CONSTRAINT `FK_proyecto_investigadores_id_proyecto` FOREIGN KEY (`id_proyecto_investigacion`) REFERENCES `proyecto` (`id_proyecto`),
  CONSTRAINT `FK_proyecto_investigadores_id_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`),
  CONSTRAINT `FK_proyecto_investigadores_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proyecto_investigadores` */

/*Table structure for table `publicacion` */

DROP TABLE IF EXISTS `publicacion`;

CREATE TABLE `publicacion` (
  `id_publicacion` int(11) NOT NULL AUTO_INCREMENT,
  `contenido_publicacion` varchar(50) NOT NULL,
  `fecha_inicioevento_publicacion` date DEFAULT NULL,
  `fecha_finevento_publicacion` date DEFAULT NULL,
  `fecha_despublicar_publicacion` date DEFAULT NULL,
  `id_tipo_publicacion` int(11) DEFAULT NULL,
  `id_seccion` int(11) DEFAULT NULL,
  `id_multimedia` int(11) DEFAULT NULL,
  `estado_publicacion` char(1) DEFAULT 'A',
  `eliminado_publicacion` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_publicacion`),
  KEY `FK_publicacion` (`id_seccion`),
  KEY `FK_publicacion_tipo` (`id_tipo_publicacion`),
  CONSTRAINT `FK_publicacion` FOREIGN KEY (`id_seccion`) REFERENCES `seccion` (`id_seccion`),
  CONSTRAINT `FK_publicacion_id_seccion` FOREIGN KEY (`id_seccion`) REFERENCES `seccion` (`id_seccion`),
  CONSTRAINT `FK_publicacion_id_tipo_publicacion` FOREIGN KEY (`id_tipo_publicacion`) REFERENCES `tipo_publicacion` (`id_tipo_publicacion`),
  CONSTRAINT `FK_publicacion_tipo` FOREIGN KEY (`id_tipo_publicacion`) REFERENCES `tipo_publicacion` (`id_tipo_publicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `publicacion` */

insert  into `publicacion`(`id_publicacion`,`contenido_publicacion`,`fecha_inicioevento_publicacion`,`fecha_finevento_publicacion`,`fecha_despublicar_publicacion`,`id_tipo_publicacion`,`id_seccion`,`id_multimedia`,`estado_publicacion`,`eliminado_publicacion`) values (1,'Algo',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL),(2,'Otro',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL);

/*Table structure for table `recursos` */

DROP TABLE IF EXISTS `recursos`;

CREATE TABLE `recursos` (
  `id_recurso` int(11) NOT NULL AUTO_INCREMENT,
  `id_publicacion` int(11) NOT NULL,
  `id_multimedia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FK_recursos_multimedia` (`id_multimedia`),
  KEY `index_publicacion` (`id_publicacion`),
  CONSTRAINT `FK_recursos_id_multimedia` FOREIGN KEY (`id_multimedia`) REFERENCES `multimedia` (`id_multimedia`),
  CONSTRAINT `FK_recursos_id_publicacion` FOREIGN KEY (`id_publicacion`) REFERENCES `publicacion` (`id_publicacion`),
  CONSTRAINT `FK_recursos_multimedia` FOREIGN KEY (`id_multimedia`) REFERENCES `multimedia` (`id_multimedia`),
  CONSTRAINT `FK_recursos_publicacion` FOREIGN KEY (`id_publicacion`) REFERENCES `publicacion` (`id_publicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `recursos` */

insert  into `recursos`(`id_recurso`,`id_publicacion`,`id_multimedia`) values (3,2,NULL);

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(40) NOT NULL,
  `descripcion_rol` varchar(150) NOT NULL,
  `estado_rol` char(1) DEFAULT 'A',
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rol` */

/*Table structure for table `seccion` */

DROP TABLE IF EXISTS `seccion`;

CREATE TABLE `seccion` (
  `id_seccion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_seccion` varchar(20) NOT NULL,
  `estado_seccion` char(1) DEFAULT NULL,
  `eliminado_seccion` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_seccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `seccion` */

/*Table structure for table `tipo_investigador` */

DROP TABLE IF EXISTS `tipo_investigador`;

CREATE TABLE `tipo_investigador` (
  `id_tipo_investigador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_investigador` varchar(20) NOT NULL,
  `descripcion_tipo_investigador` varchar(150) NOT NULL,
  PRIMARY KEY (`id_tipo_investigador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_investigador` */

insert  into `tipo_investigador`(`id_tipo_investigador`,`nombre_tipo_investigador`,`descripcion_tipo_investigador`) values (1,'Profesor','Profesor'),(2,'Estudiante','Estudiante');

/*Table structure for table `tipo_multimedia` */

DROP TABLE IF EXISTS `tipo_multimedia`;

CREATE TABLE `tipo_multimedia` (
  `id_tipo_multimedia` int(11) NOT NULL,
  `nombre_tipo_multimedia` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipo_multimedia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_multimedia` */

/*Table structure for table `tipo_produccion` */

DROP TABLE IF EXISTS `tipo_produccion`;

CREATE TABLE `tipo_produccion` (
  `id_tipo_produccion` int(4) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_produccion` varchar(50) NOT NULL,
  `estado_tipo_produccion` char(1) DEFAULT 'A',
  PRIMARY KEY (`id_tipo_produccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_produccion` */

/*Table structure for table `tipo_proyecto` */

DROP TABLE IF EXISTS `tipo_proyecto`;

CREATE TABLE `tipo_proyecto` (
  `id_tipo_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_proyecto` varchar(50) NOT NULL,
  `descripcion_tipo_proyecto` varchar(150) NOT NULL,
  PRIMARY KEY (`id_tipo_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_proyecto` */

/*Table structure for table `tipo_publicacion` */

DROP TABLE IF EXISTS `tipo_publicacion`;

CREATE TABLE `tipo_publicacion` (
  `id_tipo_publicacion` int(11) NOT NULL,
  `nombre_tipo_publicacion` int(11) NOT NULL,
  PRIMARY KEY (`id_tipo_publicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_publicacion` */

/* Trigger structure for table `publicacion` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `CrearRecurso_al_CrearPublicacion` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `CrearRecurso_al_CrearPublicacion` AFTER INSERT ON `publicacion` FOR EACH ROW BEGIN
	insert into recursos set id_publicacion = new.id_publicacion;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
