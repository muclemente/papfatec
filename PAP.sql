-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 15, 2011 at 09:07 
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `PAP`
--

-- --------------------------------------------------------

--
-- Table structure for table `Evento`
--

CREATE TABLE IF NOT EXISTS `Evento` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(255) DEFAULT NULL,
  `Data` date NOT NULL,
  `CodigoUsuario` int(11) NOT NULL,
  `ValorTotal` float DEFAULT NULL,
  `ValorPart` float DEFAULT NULL,
  `Descricao` longtext,
  `Latitude` float DEFAULT NULL,
  `Longitude` float DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Bairro` varchar(60) DEFAULT NULL,
  `Numero` int(11) DEFAULT NULL,
  `Cidade` varchar(60) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `CEP` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=413 ;

--
-- Dumping data for table `Evento`
--

INSERT INTO `Evento` (`Codigo`, `Titulo`, `Data`, `CodigoUsuario`, `ValorTotal`, `ValorPart`, `Descricao`, `Latitude`, `Longitude`, `Endereco`, `Bairro`, `Numero`, `Cidade`, `Estado`, `CEP`) VALUES
(412, 'Teste1', '0000-00-00', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Mensagem`
--

CREATE TABLE IF NOT EXISTS `Mensagem` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoEvento` int(11) NOT NULL,
  `CodigoUsuario` int(11) NOT NULL,
  `Conteudo` longtext,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `Mensagem`
--


-- --------------------------------------------------------

--
-- Table structure for table `Participacao`
--

CREATE TABLE IF NOT EXISTS `Participacao` (
  `CodigoUsuario` int(11) NOT NULL,
  `CodigoEvento` int(11) NOT NULL,
  `Pago` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Participacao`
--


-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `PrimeiroNome` varchar(60) NOT NULL,
  `UltimoNome` varchar(120) DEFAULT NULL,
  `Email` varchar(255) NOT NULL,
  `Saldo` float DEFAULT NULL,
  `Senha` varchar(120) NOT NULL,
  `Telefone` varchar(14) DEFAULT NULL,
  `CodigoAmigos` text,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`Codigo`, `PrimeiroNome`, `UltimoNome`, `Email`, `Saldo`, `Senha`, `Telefone`, `CodigoAmigos`) VALUES
(1, 'Pedro', 'Nalin', 'pedro.nalin@hotmail.com', 0, '123456', '92188012', NULL),
(2, 'Pedro', 'Nalin', 'pedro.nalin@hotmail.com', 0, '123456', '92188012', NULL),
(3, 'efggcfd', 'fhxgcd', 'xhfdgg@vhfh.cob', 0, 'dhfgcgv', '', NULL),
(4, 'Murilo', 'Clemente', 'muclemente@gmail.com', 0, '123456', '', NULL),
(5, 'frederico', 'pacheco', 'pachecofms@gmail.com', 0, '123456', '', NULL),
(6, 'frederico', 'pacheco', 'pachecofms@gmail.com', 0, '123456', '', NULL),
(7, 'frederico', 'pacheco', 'pachecofms@gmail.com', 0, '123456', '', NULL),
(8, 'vbccx', 'zbxgx', 'thfug@gfgf.vb', 0, 'fjvbgh', '', NULL),
(9, 'fgfhccc', 'fhxhcv', 'ghgfjg@gfj.gjg', 0, 'dhcfcgg', '', NULL),
(10, 'hgufjfvd', 'gjfhghggcgch', 'hjgjgj@gfhf.gjv', 0, 'dggjgjgj', '', NULL),
(11, 'fv', 'tvvg', 'muclemente@gmail.com', 0, 'guggggghf', '', NULL),
(12, 'fv', 'tvvg', 'muclemente@gmail.com', 0, 'guggggghf', '', NULL),
(13, 'fv', 'tvvg', 'muclemente@gmail.com', 0, 'guggggghf', '', NULL),
(14, 'fv', 'tvvg', 'muclemente@gmail.com', 0, 'guggggghf', '', NULL),
(15, 'fv', 'tvvg', 'muclemente@gmail.com', 0, 'guggggghf', '', NULL);
