-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2019 a las 17:05:13
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

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

CREATE TABLE `contrato` (
  `id_contrato` int(11) NOT NULL,
  `id_inmueble` int(11) NOT NULL,
  `id_inquilino` int(11) NOT NULL,
  `estado_contrato` varchar(50) COLLATE utf8_bin NOT NULL,
  `monto` double NOT NULL,
  `fecha_ini` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmueble`
--

CREATE TABLE `inmueble` (
  `id_inmueble` int(11) NOT NULL,
  `id_tipo_inmueble` int(11) NOT NULL,
  `dni_propietario` int(8) NOT NULL,
  `direccion_inmueble` varchar(100) COLLATE utf8_bin NOT NULL,
  `superficie` double NOT NULL,
  `precio_base` double NOT NULL,
  `estado_inmueble` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `inmueble`
--

INSERT INTO `inmueble` (`id_inmueble`, `id_tipo_inmueble`, `dni_propietario`, `direccion_inmueble`, `superficie`, `precio_base`, `estado_inmueble`) VALUES
(4, 0, 0, 'HOLA', 0, 123, 'adsa'),
(5, 1, 3333, 'La calle', 5000, 2000, 'Disponible'),
(8, 1, 3333, 'aaa', 5, 3, 'disponible'),
(9, 1, 1111, 'a', 111, 11, 'a'),
(10, 1, 12, 'a', 12, 12, 'a'),
(11, 1, 231321, 'aaaa', 12312, 12321, 'a'),
(15, 1, 38752605, 'Virorco', 12345, 1234, 'Disponible'),
(16, 1, 3333, 'adasda', 300, 3000, 'asdasda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inquilino`
--

CREATE TABLE `inquilino` (
  `dni_inquilio` int(11) NOT NULL,
  `nombre_inquilio` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellido_inquilio` varchar(50) COLLATE utf8_bin NOT NULL,
  `cuit_inquilio` int(11) NOT NULL,
  `lugar_trabajo_inquilio` varchar(150) COLLATE utf8_bin NOT NULL,
  `nom_garante_inquilio` varchar(150) COLLATE utf8_bin NOT NULL,
  `dni_garante_inquilio` int(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietario`
--

CREATE TABLE `propietario` (
  `dni_propietario` int(8) NOT NULL,
  `nombre_propietario` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellido_propietario` varchar(50) COLLATE utf8_bin NOT NULL,
  `domicilio_propietario` varchar(100) COLLATE utf8_bin NOT NULL,
  `telefono_propietario` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `propietario`
--

INSERT INTO `propietario` (`dni_propietario`, `nombre_propietario`, `apellido_propietario`, `domicilio_propietario`, `telefono_propietario`) VALUES
(3333, 'Juani', 'Balaguer', 'Virorco', 26644),
(38752605, 'J', 'J', 'dasdsa', 26644038),
(111111111, 'a', 'a', 'a', 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_inmueble`
--

CREATE TABLE `tipo_inmueble` (
  `id_tipo_inmueble` int(11) NOT NULL,
  `tipo_inmueble` varchar(50) NOT NULL,
  `zona_inmueble` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_inmueble`
--

INSERT INTO `tipo_inmueble` (`id_tipo_inmueble`, `tipo_inmueble`, `zona_inmueble`) VALUES
(1, 'Departamento', 'Centro'),
(2, 'Departamento', 'Rural');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`id_contrato`);

--
-- Indices de la tabla `inmueble`
--
ALTER TABLE `inmueble`
  ADD PRIMARY KEY (`id_inmueble`);

--
-- Indices de la tabla `inquilino`
--
ALTER TABLE `inquilino`
  ADD PRIMARY KEY (`dni_inquilio`);

--
-- Indices de la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD PRIMARY KEY (`dni_propietario`);

--
-- Indices de la tabla `tipo_inmueble`
--
ALTER TABLE `tipo_inmueble`
  ADD PRIMARY KEY (`id_tipo_inmueble`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contrato`
--
ALTER TABLE `contrato`
  MODIFY `id_contrato` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inmueble`
--
ALTER TABLE `inmueble`
  MODIFY `id_inmueble` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `inquilino`
--
ALTER TABLE `inquilino`
  MODIFY `dni_inquilio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_inmueble`
--
ALTER TABLE `tipo_inmueble`
  MODIFY `id_tipo_inmueble` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
