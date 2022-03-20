USE [master]
GO
/****** Object:  Database [KaraManager]    Script Date: 03/20/2022 21:25:36 ******/
CREATE DATABASE [KaraManager] ON  PRIMARY 
( NAME = N'KaraManager', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLSERVER\MSSQL\DATA\KaraManager.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'KaraManager_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLSERVER\MSSQL\DATA\KaraManager_log.LDF' , SIZE = 504KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [KaraManager] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [KaraManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [KaraManager] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [KaraManager] SET ANSI_NULLS OFF
GO
ALTER DATABASE [KaraManager] SET ANSI_PADDING OFF
GO
ALTER DATABASE [KaraManager] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [KaraManager] SET ARITHABORT OFF
GO
ALTER DATABASE [KaraManager] SET AUTO_CLOSE ON
GO
ALTER DATABASE [KaraManager] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [KaraManager] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [KaraManager] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [KaraManager] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [KaraManager] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [KaraManager] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [KaraManager] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [KaraManager] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [KaraManager] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [KaraManager] SET  ENABLE_BROKER
GO
ALTER DATABASE [KaraManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [KaraManager] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [KaraManager] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [KaraManager] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [KaraManager] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [KaraManager] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [KaraManager] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [KaraManager] SET  READ_WRITE
GO
ALTER DATABASE [KaraManager] SET RECOVERY SIMPLE
GO
ALTER DATABASE [KaraManager] SET  MULTI_USER
GO
ALTER DATABASE [KaraManager] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [KaraManager] SET DB_CHAINING OFF
GO
USE [KaraManager]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 03/20/2022 21:25:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room](
	[rid] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](150) NOT NULL,
	[priceperhour] [int] NOT NULL,
	[isused] [bit] NOT NULL,
	[timestarted] [datetime] NULL,
 CONSTRAINT [PK__Room__C2B7EDE820C1E124] PRIMARY KEY CLUSTERED 
(
	[rid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 03/20/2022 21:25:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[bid] [int] IDENTITY(1,1) NOT NULL,
	[rid] [int] NOT NULL,
	[datecreated] [date] NOT NULL,
	[timestarted] [datetime] NOT NULL,
	[timeended] [datetime] NOT NULL,
	[timeelapsed] [time](7) NOT NULL,
	[othercost] [int] NOT NULL,
	[totalcost] [int] NOT NULL,
 CONSTRAINT [PK__Invoice__DE90ADE71CF15040] PRIMARY KEY CLUSTERED 
(
	[bid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 03/20/2022 21:25:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
