/*
SQLyog Ultimate v9.02 
MySQL - 5.5.24-log : Database - portal_data_base
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

insert  into `estado_proyecto`(`id_estado_proyecto`,`nombre_estado_proyecto`) values (1,'Activo'),(2,'Inconcluso'),(3,'Finalizado');

/*Table structure for table `investigador` */

DROP TABLE IF EXISTS `investigador`;

CREATE TABLE `investigador` (
  `usuario_investigador` varchar(30) NOT NULL,
  `contrasena_investigador` varchar(20) NOT NULL,
  `nombre_investigador` varchar(30) NOT NULL,
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
  `apellido_investigador` varchar(30) NOT NULL,
  `titulo_Investigador` varchar(100) DEFAULT NULL,
  `image_investigador_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuario_investigador`),
  KEY `FK_investigador` (`id_nivel_permiso`),
  KEY `FK_investigador_tipo` (`id_tipo_investigador`),
  CONSTRAINT `FK_investigador` FOREIGN KEY (`id_nivel_permiso`) REFERENCES `permiso` (`id_permiso`),
  CONSTRAINT `FK_investigador_id_nivel_permiso` FOREIGN KEY (`id_nivel_permiso`) REFERENCES `permiso` (`id_permiso`),
  CONSTRAINT `FK_investigador_id_tipo_investigador` FOREIGN KEY (`id_tipo_investigador`) REFERENCES `tipo_investigador` (`id_tipo_investigador`),
  CONSTRAINT `FK_investigador_tipo` FOREIGN KEY (`id_tipo_investigador`) REFERENCES `tipo_investigador` (`id_tipo_investigador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `investigador` */

insert  into `investigador`(`usuario_investigador`,`contrasena_investigador`,`nombre_investigador`,`informacion_investigador`,`telefono_investigador`,`celular_investigador`,`correo_investigador`,`genero_investigador`,`cvlac_investigador`,`id_tipo_investigador`,`id_nivel_permiso`,`estado_investigador`,`eliminado_investigador`,`apellido_investigador`,`titulo_Investigador`,`image_investigador_path`) values ('admin','admin','Carlos','<p>\r\n	<span style=\"background-color:#ff0000;\">Soy carlos</span></p>\r\n<p>\r\n	&nbsp;</p>\r\n<ul>\r\n	<li>\r\n		wejwej</li>\r\n	<li>\r\n		wjewqje</li>\r\n	<li>\r\n		owqeqwle</li>\r\n</ul>\r\n','2222222','2222222222','@Carlos','M','No',1,1,'A',NULL,' Humberto','Magister Ing. Sistemas','CarlosH.jpg'),('diana','diana','Milena','Soy Milena','3333333','3333333333','@Milena','f','Si',3,1,'A','',' Amado',NULL,NULL),('jose','1234','Jose','Hola q ase?','1111111','1111111111','@Jose','M','No',2,1,'A',NULL,' Perazo',NULL,NULL),('sonia','1234','Sonia ','Soy Sonia','4444444','4444444444','@Sonia','F','No',1,1,'A',NULL,' Gamboa','Dcotora en Filosofía',NULL);

/*Table structure for table `linea_investigacion` */

DROP TABLE IF EXISTS `linea_investigacion`;

CREATE TABLE `linea_investigacion` (
  `id_linea_investigacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_linea_investigacion` varchar(50) NOT NULL,
  `descripcion_linea_investigacion` text NOT NULL,
  `estado_linea_investigacion` char(1) DEFAULT 'A',
  `eliminado_linea_investigacion` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_linea_investigacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `linea_investigacion` */

insert  into `linea_investigacion`(`id_linea_investigacion`,`nombre_linea_investigacion`,`descripcion_linea_investigacion`,`estado_linea_investigacion`,`eliminado_linea_investigacion`) values (1,'Biología Computacional','La biología (del griego «????» bíos, vida, y «-?????» -logía, tratado, estudio, ciencia) es la ciencia que tiene como objeto de estudio a los seres vivos y, más específicamente, su origen, su evolución y sus propiedades: nutrición, morfogénesis, reproducción, patogenia, etc. Se ocupa tanto de la descripción de las características y los comportamientos de los organismos individuales como de las especies en su conjunto, así como de la reproducción de los seres vivos y de las interacciones entre ellos y el entorno. De este modo, trata de estudiar la estructura y la dinámica funcional comunes a todos los seres vivos, con el fin de establecer las leyes generales que rigen la vida orgánica y los principios explicativos fundamentales de esta.','A',NULL),(2,'Computación de Alto Rendimiento','Las ciencias de la computación o ciencias computacionales son aquellas que abarcan las bases teóricas de la información y la computación, así como su aplicación en sistemas computacionales.1 2 3 Existen diversos campos o disciplinas dentro de las ciencias de la computación o ciencias computacionales; algunos resaltan los resultados específicos del cómputo (como los gráficos por computadora), mientras que otros (como la teoría de la complejidad computacional) se relacionan con propiedades de los algoritmos usados al realizar cómputos y otros se enfocan en los problemas que requieren la implementación de cómputos. Por ejemplo, los estudios de la teoría de lenguajes de programación describen un cómputo, mientras que la programación de computadoras aplica lenguajes de programación específicos para desarrollar una solución a un problema computacional específico.','A',NULL),(3,'Dispositivos móviles y Redes P2P','La historia de la ciencia de la computación antecede a la invención del computador digital moderno. Antes de la década de 1920, el término computador se refería a un ser humano que realizaba cálculos.5 Los primeros investigadores en lo que después se convertiría las ciencias de la computación estaban interesados en la cuestión de la computabilidad: qué cosas pueden ser computadas por un ser humano que simplemente siga una lista de instrucciones con lápiz y papel, durante el tiempo que sea necesario, con ingenuidad y sin conocimiento previo del problema. Parte de la motivación para este trabajo era el desarrollar máquinas que computaran y que pudieran automatizar el tedioso y falible trabajo de la computación humana.','A',NULL),(4,'Ingeniería de Software','Durante la década de 1940, conforme se desarrollaban nuevas y más poderosas máquinas para computar, el término computador se comenzó a utilizar para referirse a las máquinas y ya no a sus antecesores humanos. Conforme iba quedando claro que las computadoras podían usarse para más cosas que solamente cálculos matemáticos, el campo de la ciencia de la computación se fue ampliando para estudiar a la computación (informática) en general. La ciencia de la computación comenzó entonces a establecerse como una disciplina académica en la década de 1960, con la creación de los primeros departamentos de ciencia de la computación y los primeros programas de licenciatura (Denning 2000).','A',NULL),(5,'Procesamiento de Imágenes y Señales Digitales','Las ciencias de la computación frecuentemente se cruzan con otras áreas de investigación, tales como la física y la lingüística. Pero es con las matemáticas con las que se considera que tiene un grado mayor de relación. Eso es evidenciado por el hecho de que los primeros trabajos en el área fueran fuertemente influenciados por matemáticos como Kurt Gödel y Alan Turing. En la actualidad sigue habiendo un intercambio de ideas útil entre ambos campos en áreas como la lógica matemática, la teoría de categorías, la teoría de dominios, el álgebra y la geometría.','A',NULL);

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

insert  into `lineas_investigador`(`id_linea`,`id_investigador`) values (1,'admin'),(3,'admin'),(4,'admin'),(1,'diana'),(2,'diana'),(1,'jose'),(5,'jose'),(3,'sonia'),(4,'sonia');

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
  `descripcion_resumida_proyecto` varchar(200) NOT NULL,
  `id_tipo_proyecto` int(11) NOT NULL,
  `id_estado_proyecto` int(11) NOT NULL,
  `id_linea` int(11) NOT NULL,
  `estado_proyecto` char(1) DEFAULT 'A',
  `eliminado_proyecto` char(1) DEFAULT NULL,
  `descripcion_detallada_proyecto` text NOT NULL,
  `objetivos_proyecto` text NOT NULL,
  `resultados_proyecto` text NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `proyecto` */

insert  into `proyecto`(`id_proyecto`,`nombre_proyecto`,`descripcion_resumida_proyecto`,`id_tipo_proyecto`,`id_estado_proyecto`,`id_linea`,`estado_proyecto`,`eliminado_proyecto`,`descripcion_detallada_proyecto`,`objetivos_proyecto`,`resultados_proyecto`) values (1,'Celulas','Celulas',1,1,2,'A',NULL,'La teoría celular, propuesta en 1838 para los vegetales y en 1839 para los animales,3 \r\npor Matthias Jakob Schleiden y Theodor Schwann, postula que todos los organismos \r\nestán compuestos por células, y que todas las células derivan de otras precedentes. \r\n\r\nDe este modo, todas las funciones vitales emanan de la maquinaria celular y de la \r\ninteracción entre células adyacentes; además, la tenencia de la información genética, \r\nbase de la herencia, en su ADN permite la transmisión de aquella de generación en \r\ngeneración.4','Que la célula es una unidad morfológica de todo ser vivo: es decir, que en los seres vivos todo está formado por células o por sus productos de secreción.','Nutrición. Las células toman sustancias del medio, las transforman de una forma a otra, liberan energía y eliminan productos de desecho, mediante el metabolismo.'),(2,'Comunicaciones','Comunicaciones',2,1,3,'A',NULL,'Década de 1670: Anton van Leeuwenhoek, observó diversas células eucariotas (como protozoos y espermatozoides) y procariotas (bacterias).','Este primer postulado sería completado por Rudolf Virchow con la afirmación Omnis cellula ex cellula, la cual indica que toda célula deriva de una célula precedente (biogénesis). En otras palabras, este postulado constituye la refutación de la teoría de generación espontánea o ex novo, que hipotetizaba la posibilidad de que se generara vida a partir de elementos inanimados.13','Crecimiento y multiplicación. Las células son capaces de dirigir su propia síntesis. A consecuencia de los procesos nutricionales, una célula crece y se divide, formando dos células, en una célula idéntica a la célula original, mediante la división celular.'),(3,'Computadora','Computadora',2,3,2,'A',NULL,'Década de 1830: Theodor Schwann estudió la célula animal; junto con Matthias Schleiden postularon que las células son las unidades elementales en la formación de las plantas y animales, y que son la base fundamental del proceso vital.','Finalmente, el cuarto postulado de la teoría celular expresa que cada célula contiene toda la información hereditaria necesaria para el control de su propio ciclo y del desarrollo y el funcionamiento de un organismo de su especie, así como para la transmisión de esa información a la siguiente generación celular.14','Células contráctiles que suelen ser alargadas, como las fibras musculares.');

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

insert  into `proyecto_investigadores`(`id_proyecto_investigacion`,`id_investigador`,`id_rol`) values (1,'diana',1),(1,'sonia',2),(2,'jose',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `publicacion` */

insert  into `publicacion`(`id_publicacion`,`contenido_publicacion`,`fecha_inicioevento_publicacion`,`fecha_finevento_publicacion`,`fecha_despublicar_publicacion`,`id_tipo_publicacion`,`id_seccion`,`id_multimedia`,`estado_publicacion`,`eliminado_publicacion`) values (1,'Algo','2013-08-10','2013-08-12',NULL,1,NULL,NULL,'A',NULL),(2,'Otro','2013-07-10','2013-07-11',NULL,1,NULL,NULL,'A',NULL),(3,'Hola',NULL,NULL,NULL,NULL,NULL,NULL,'A',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `recursos` */

insert  into `recursos`(`id_recurso`,`id_publicacion`,`id_multimedia`) values (3,2,NULL),(4,3,NULL);

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(40) NOT NULL,
  `descripcion_rol` varchar(150) NOT NULL,
  `estado_rol` char(1) DEFAULT 'A',
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `rol` */

insert  into `rol`(`id_rol`,`nombre_rol`,`descripcion_rol`,`estado_rol`) values (1,'Investigador','Investigador','A'),(2,'Director','Director','A'),(3,'Co-Director','Co-Director','A');

/*Table structure for table `seccion` */

DROP TABLE IF EXISTS `seccion`;

CREATE TABLE `seccion` (
  `id_seccion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_seccion` varchar(20) NOT NULL,
  `estado_seccion` char(1) DEFAULT NULL,
  `eliminado_seccion` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_seccion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `seccion` */

insert  into `seccion`(`id_seccion`,`nombre_seccion`,`estado_seccion`,`eliminado_seccion`) values (1,'Eventos','A',NULL),(2,'Grupo','A',NULL);

/*Table structure for table `tipo_investigador` */

DROP TABLE IF EXISTS `tipo_investigador`;

CREATE TABLE `tipo_investigador` (
  `id_tipo_investigador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_investigador` varchar(20) NOT NULL,
  `descripcion_tipo_investigador` varchar(150) NOT NULL,
  PRIMARY KEY (`id_tipo_investigador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_investigador` */

insert  into `tipo_investigador`(`id_tipo_investigador`,`nombre_tipo_investigador`,`descripcion_tipo_investigador`) values (1,'Profesor','Profesor'),(2,'Estudiante Maestria','Estudiante Maestria'),(3,'Estudiante Pregrado','Estudiante Pregrado');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_proyecto` */

insert  into `tipo_proyecto`(`id_tipo_proyecto`,`nombre_tipo_proyecto`,`descripcion_tipo_proyecto`) values (1,'Investigacion Maestria','Proyecto Investigacion Maestria'),(2,'Investigacion Pregrado','Proyecto Investigacion Pregrado');

/*Table structure for table `tipo_publicacion` */

DROP TABLE IF EXISTS `tipo_publicacion`;

CREATE TABLE `tipo_publicacion` (
  `id_tipo_publicacion` int(11) NOT NULL,
  `nombre_tipo_publicacion` varchar(20) NOT NULL,
  PRIMARY KEY (`id_tipo_publicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_publicacion` */

insert  into `tipo_publicacion`(`id_tipo_publicacion`,`nombre_tipo_publicacion`) values (1,'Evento'),(2,'Historia'),(3,'Objetivos'),(4,'Mision'),(5,'Vision');

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
