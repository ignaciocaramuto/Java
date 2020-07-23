create database hotel;
CREATE TABLE `hotel`.`clientes` (

  `id_Cliente` INT NOT NULL AUTO_INCREMENT,
  `tipo_Doc` VARCHAR(10) NOT NULL,
  `nro_Doc` VARCHAR(25) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `fecha_Nacimiento` DATE NOT NULL,
  `tipo_Tarjeta_Credito` VARCHAR(45) NOT NULL,
  `nro_Tarjeta_Credito` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Cliente`));

CREATE TABLE `hotel`.`estadia` (
  `id_Estadia` INT NOT NULL AUTO_INCREMENT,
  `fecha_Ingreso` DATE NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `id_Cliente` INT NULL,
  PRIMARY KEY (`id_Estadia`),
 
  CONSTRAINT `id_Cliente`
    FOREIGN KEY (`id_Cliente`)
    REFERENCES `hotel`.`cliente` (`id_Cliente`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION);

CREATE TABLE `hotel`.`tipo_habitacion` (
  `id_Tipo_Habitacion` INT NOT NULL AUTO_INCREMENT,
  `denominacion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `capacidad_Personas` INT NOT NULL,
  `precio_Por_Dia` FLOAT NOT NULL,
  PRIMARY KEY (`id_Tipo_Habitacion`));

CREATE TABLE `hotel`.`habitacion` (
  `nro_Habitacion` INT NOT NULL,
  `id_Tipo_Habitacion` INT NOT NULL,
  PRIMARY KEY (`nro_Habitacion`),
  CONSTRAINT `tipo_Habitacion`
    FOREIGN KEY (`id_Tipo_Habitacion`)
    REFERENCES `hotel`.`tipo_habitacion` (`id_Tipo_Habitacion`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
CREATE TABLE `hotel`.`servicio` (
  `id_Servicio` INT NOT NULL AUTO_INCREMENT,
  `denominacion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `costo` FLOAT NOT NULL,
  PRIMARY KEY (`id_Servicio`));

CREATE TABLE `hotel`.`estadia_servicio` (
  `id_estadia` INT NOT NULL,
  `id_servicio` INT NOT NULL,
  PRIMARY KEY (`id_estadia`, `id_servicio`),
  
  CONSTRAINT `estadia`
    FOREIGN KEY (`id_estadia`)
    REFERENCES `hotel`.`estadia` (`id_Estadia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `servicio`
    FOREIGN KEY (`id_servicio`)
    REFERENCES `hotel`.`servicio` (`id_Servicio`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
