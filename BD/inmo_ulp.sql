-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-10-2019 a las 01:25:22
-- Versión del servidor: 5.7.23
-- Versión de PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inmo_ulp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contrato`
--

DROP TABLE IF EXISTS `contrato`;
CREATE TABLE IF NOT EXISTS `contrato` (
  `id_contrato` int(11) NOT NULL AUTO_INCREMENT,
  `id_inmueble` int(11) NOT NULL,
  `id_inquilino` int(11) NOT NULL,
  `id_estado_contrato` int(11) NOT NULL,
  `vigente` smallint(6) NOT NULL,
  `monto` double NOT NULL,
  `fecha_ini` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  PRIMARY KEY (`id_contrato`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_contrato`
--

DROP TABLE IF EXISTS `estado_contrato`;
CREATE TABLE IF NOT EXISTS `estado_contrato` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `detalle_estado` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
CREATE TABLE IF NOT EXISTS `inmueble` (
  `id_inmueble` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_inmueble` int(11) NOT NULL,
  `dni_propietario` int(8) NOT NULL,
  `direccion_inmueble` varchar(100) COLLATE utf8_bin NOT NULL,
  `altura_inmueble` int(11) NOT NULL,
  `superficie_propietario` double NOT NULL,
  `zona_propietario` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `precio_base_propietario` double NOT NULL,
  PRIMARY KEY (`id_inmueble`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inquilino`
--

DROP TABLE IF EXISTS `inquilino`;
CREATE TABLE IF NOT EXISTS `inquilino` (
  `id_inquilio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_inquilio` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellido_inquilio` varchar(50) COLLATE utf8_bin NOT NULL,
  `cuit_inquilio` int(11) NOT NULL,
  `lugar_trabajo_inquilio` varchar(150) COLLATE utf8_bin NOT NULL,
  `nom_garante_inquilio` varchar(150) COLLATE utf8_bin NOT NULL,
  `dni_garante_inquilio` int(8) NOT NULL,
  PRIMARY KEY (`id_inquilio`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietario`
--

DROP TABLE IF EXISTS `propietario`;
CREATE TABLE IF NOT EXISTS `propietario` (
  `dni_propietario` int(8) NOT NULL,
  `nombre_propietario` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellido_propietario` varchar(50) COLLATE utf8_bin NOT NULL,
  `domicilio_propietario` varchar(100) COLLATE utf8_bin NOT NULL,
  `telefono_propietario` int(20) NOT NULL,
  PRIMARY KEY (`dni_propietario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_inmueble`
--

DROP TABLE IF EXISTS `tipo_inmueble`;
CREATE TABLE IF NOT EXISTS `tipo_inmueble` (
  `id_tipo_inmueble` int(11) NOT NULL AUTO_INCREMENT,
  `detalle_tipo_inmueble` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_tipo_inmueble`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
