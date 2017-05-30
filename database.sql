-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2017 a las 01:15:27
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `encuesta`
--
CREATE DATABASE IF NOT EXISTS `encuesta` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `encuesta`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contestadas`
--

CREATE TABLE `contestadas` (
  `id` int(11) NOT NULL COMMENT 'ID de la tabla',
  `id_encuesta` int(11) NOT NULL COMMENT 'Indica el id de la encuesta',
  `quien_respondio` int(11) DEFAULT NULL COMMENT 'id de quien respondió (si es nulo es anónimo)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuesta`
--

CREATE TABLE `encuesta` (
  `id` int(11) NOT NULL COMMENT 'Id tabla',
  `titulo` text NOT NULL COMMENT 'Titulo encuesta',
  `descripcion` text NOT NULL COMMENT 'Descripción encuesta',
  `id_usuario` int(11) NOT NULL COMMENT 'Quien la creo',
  `num_preguntas` int(11) NOT NULL COMMENT 'Número de preguntas de la encuesta',
  `visible` int(11) NOT NULL COMMENT 'Si es visible o no... es decir suspendida o no'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opcion`
--

CREATE TABLE `opcion` (
  `id` int(11) NOT NULL COMMENT 'Id tabla',
  `id_pregunta` int(11) NOT NULL COMMENT 'Que pregunta tiene esta opción',
  `opcion` text NOT NULL COMMENT 'Opción'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `id` int(11) NOT NULL COMMENT 'id tabla',
  `id_encuesta` int(11) NOT NULL COMMENT 'A que encuesta pertenece esta pregunta',
  `tipo` int(11) NOT NULL COMMENT 'De que tipo es la pregunta (ej. abierta, cerrada)',
  `pregunta` text NOT NULL COMMENT 'La pregunta en si'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `id` int(11) NOT NULL COMMENT 'Id tabla',
  `id_contestadas` int(11) NOT NULL COMMENT 'De que encuesta contestada es',
  `id_pregunta` int(11) NOT NULL COMMENT 'A que pregunta corresponde',
  `respuesta` text NOT NULL COMMENT 'La respuesta en sí'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pregunta`
--

CREATE TABLE `tipo_pregunta` (
  `id` int(11) NOT NULL COMMENT 'Id de la tabla',
  `nombre` text NOT NULL COMMENT 'El nombre del tipo de pregunta'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_pregunta`
--

INSERT INTO `tipo_pregunta` (`id`, `nombre`) VALUES
(1, 'Abierta'),
(2, 'Verdadero o Falso'),
(3, 'Nivel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL COMMENT 'Id de la tabla',
  `nombre` text NOT NULL COMMENT 'Nombre del tipo de usuario (ej. normal, master...)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `nombre`) VALUES
(1, 'Normal'),
(2, 'Master');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL COMMENT 'Id de la tabla',
  `email` text NOT NULL COMMENT 'correo del usuario para iniciar sesión ',
  `password` text NOT NULL COMMENT 'Contraseña para el inicio de sesión',
  `nombre` text NOT NULL COMMENT 'Nombre del usuario',
  `ape_p` text NOT NULL COMMENT 'Apellido paterno del usuario',
  `ape_m` text NOT NULL COMMENT 'Apellido materno del usuario',
  `id_tipo` int(11) NOT NULL COMMENT 'Tipo de usuario relacionado con la tabla tipo_usuario'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contestadas`
--
ALTER TABLE `contestadas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_encuesta` (`id_encuesta`),
  ADD KEY `quien_respondio` (`quien_respondio`);

--
-- Indices de la tabla `encuesta`
--
ALTER TABLE `encuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `opcion`
--
ALTER TABLE `opcion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pregunta` (`id_pregunta`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_encuesta` (`id_encuesta`),
  ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_contestadas` (`id_contestadas`),
  ADD KEY `id_pregunta` (`id_pregunta`);

--
-- Indices de la tabla `tipo_pregunta`
--
ALTER TABLE `tipo_pregunta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contestadas`
--
ALTER TABLE `contestadas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID de la tabla';
--
-- AUTO_INCREMENT de la tabla `encuesta`
--
ALTER TABLE `encuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id tabla';
--
-- AUTO_INCREMENT de la tabla `opcion`
--
ALTER TABLE `opcion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id tabla';
--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id tabla';
--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id tabla';
--
-- AUTO_INCREMENT de la tabla `tipo_pregunta`
--
ALTER TABLE `tipo_pregunta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id de la tabla', AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id de la tabla', AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id de la tabla';
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contestadas`
--
ALTER TABLE `contestadas`
  ADD CONSTRAINT `contestadas_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`);

--
-- Filtros para la tabla `encuesta`
--
ALTER TABLE `encuesta`
  ADD CONSTRAINT `encuesta_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `opcion`
--
ALTER TABLE `opcion`
  ADD CONSTRAINT `opcion_ibfk_1` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id`);

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`),
  ADD CONSTRAINT `pregunta_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `tipo_pregunta` (`id`);

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`id_contestadas`) REFERENCES `contestadas` (`id`),
  ADD CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
