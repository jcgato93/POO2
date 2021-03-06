USE [master]
GO
/****** Object:  Database [basereserva]    Script Date: 03/12/2017 1:54:04 p. m. ******/
CREATE DATABASE [basereserva]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'basereserva', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\basereserva.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'basereserva_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\basereserva_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [basereserva] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [basereserva].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [basereserva] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [basereserva] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [basereserva] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [basereserva] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [basereserva] SET ARITHABORT OFF 
GO
ALTER DATABASE [basereserva] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [basereserva] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [basereserva] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [basereserva] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [basereserva] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [basereserva] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [basereserva] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [basereserva] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [basereserva] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [basereserva] SET  ENABLE_BROKER 
GO
ALTER DATABASE [basereserva] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [basereserva] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [basereserva] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [basereserva] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [basereserva] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [basereserva] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [basereserva] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [basereserva] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [basereserva] SET  MULTI_USER 
GO
ALTER DATABASE [basereserva] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [basereserva] SET DB_CHAINING OFF 
GO
ALTER DATABASE [basereserva] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [basereserva] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [basereserva] SET DELAYED_DURABILITY = DISABLED 
GO
USE [basereserva]
GO
/****** Object:  User [Invitado]    Script Date: 03/12/2017 1:54:04 p. m. ******/
CREATE USER [Invitado] FOR LOGIN [Invitado] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[clientes]    Script Date: 03/12/2017 1:54:05 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[clientes](
	[clienteId] [int] IDENTITY(1,1) NOT NULL,
	[nombres] [varchar](50) NULL,
	[apellidos] [varchar](50) NULL,
	[tipo_documento] [varchar](50) NULL,
	[num_documento] [varchar](50) NULL,
	[direccion] [varchar](50) NULL,
	[telefono] [varchar](50) NULL,
	[email] [varchar](50) NULL,
 CONSTRAINT [PK_clientes] PRIMARY KEY CLUSTERED 
(
	[clienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[consumo]    Script Date: 03/12/2017 1:54:05 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[consumo](
	[consumoId] [int] IDENTITY(1,1) NOT NULL,
	[reservaId] [int] NULL,
	[productoId] [int] NULL,
	[cantidad] [int] NULL,
	[estado] [varchar](50) NULL,
 CONSTRAINT [PK_consumo] PRIMARY KEY CLUSTERED 
(
	[consumoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[habitacion]    Script Date: 03/12/2017 1:54:05 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[habitacion](
	[habitacionId] [int] IDENTITY(1,1) NOT NULL,
	[numero] [varchar](50) NULL,
	[piso] [varchar](50) NULL,
	[caracteristicas] [varchar](max) NULL,
	[precio_diario] [varchar](50) NULL,
	[estado] [varchar](50) NULL,
	[tipo_habitacion] [varchar](50) NULL,
 CONSTRAINT [PK_habitacion] PRIMARY KEY CLUSTERED 
(
	[habitacionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[pago]    Script Date: 03/12/2017 1:54:05 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pago](
	[pagoId] [int] IDENTITY(1,1) NOT NULL,
	[reservaId] [int] NULL,
	[total_pago] [varchar](50) NULL,
	[fecha_emision] [date] NULL,
	[fecha_pago] [date] NULL,
 CONSTRAINT [PK_pago] PRIMARY KEY CLUSTERED 
(
	[pagoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[producto]    Script Date: 03/12/2017 1:54:05 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[producto](
	[productoId] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[descripcion] [varchar](max) NULL,
	[unidad_medida] [varchar](50) NULL,
	[precio_venta] [varchar](50) NULL,
 CONSTRAINT [PK_producto] PRIMARY KEY CLUSTERED 
(
	[productoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[reserva]    Script Date: 03/12/2017 1:54:05 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[reserva](
	[reservaId] [int] IDENTITY(1,1) NOT NULL,
	[habitacionId] [int] NULL,
	[clienteId] [int] NULL,
	[trabajadorId] [int] NULL,
	[tipo_reserva] [varchar](50) NULL,
	[fecha_reserva] [date] NULL,
	[fecha_ingreso] [date] NULL,
	[fecha_salida] [date] NULL,
	[costo_alojamiento] [varchar](50) NULL,
	[estado] [varchar](50) NULL,
 CONSTRAINT [PK_reserva] PRIMARY KEY CLUSTERED 
(
	[reservaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[trabajadores]    Script Date: 03/12/2017 1:54:05 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[trabajadores](
	[trabajadoresId] [int] IDENTITY(1,1) NOT NULL,
	[nombres] [varchar](50) NULL,
	[apellidos] [varchar](50) NULL,
	[tipo_documento] [varchar](50) NULL,
	[num_documento] [varchar](50) NULL,
	[direccion] [varchar](50) NULL,
	[telefono] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[sueldo] [varchar](50) NULL,
	[rol] [varchar](50) NULL,
	[login] [varchar](50) NULL,
	[password] [varchar](50) NULL,
 CONSTRAINT [PK_trabajadores] PRIMARY KEY CLUSTERED 
(
	[trabajadoresId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[consumo]  WITH CHECK ADD  CONSTRAINT [FK_consumo_producto] FOREIGN KEY([productoId])
REFERENCES [dbo].[producto] ([productoId])
GO
ALTER TABLE [dbo].[consumo] CHECK CONSTRAINT [FK_consumo_producto]
GO
ALTER TABLE [dbo].[consumo]  WITH CHECK ADD  CONSTRAINT [FK_consumo_reserva] FOREIGN KEY([reservaId])
REFERENCES [dbo].[reserva] ([reservaId])
GO
ALTER TABLE [dbo].[consumo] CHECK CONSTRAINT [FK_consumo_reserva]
GO
ALTER TABLE [dbo].[pago]  WITH CHECK ADD  CONSTRAINT [FK_pago_reserva] FOREIGN KEY([reservaId])
REFERENCES [dbo].[reserva] ([reservaId])
GO
ALTER TABLE [dbo].[pago] CHECK CONSTRAINT [FK_pago_reserva]
GO
ALTER TABLE [dbo].[reserva]  WITH CHECK ADD  CONSTRAINT [FK_reserva_clientes] FOREIGN KEY([clienteId])
REFERENCES [dbo].[clientes] ([clienteId])
GO
ALTER TABLE [dbo].[reserva] CHECK CONSTRAINT [FK_reserva_clientes]
GO
ALTER TABLE [dbo].[reserva]  WITH CHECK ADD  CONSTRAINT [FK_reserva_habitacion] FOREIGN KEY([habitacionId])
REFERENCES [dbo].[habitacion] ([habitacionId])
GO
ALTER TABLE [dbo].[reserva] CHECK CONSTRAINT [FK_reserva_habitacion]
GO
ALTER TABLE [dbo].[reserva]  WITH CHECK ADD  CONSTRAINT [FK_reserva_trabajadores] FOREIGN KEY([trabajadorId])
REFERENCES [dbo].[trabajadores] ([trabajadoresId])
GO
ALTER TABLE [dbo].[reserva] CHECK CONSTRAINT [FK_reserva_trabajadores]
GO
USE [master]
GO
ALTER DATABASE [basereserva] SET  READ_WRITE 
GO
