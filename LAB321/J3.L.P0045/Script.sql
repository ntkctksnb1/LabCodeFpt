
USE [Timetable]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 17/06/2021 12:01:51 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[ClassID] [int] IDENTITY(1,1) NOT NULL,
	[ClassName] [nvarchar](16) NOT NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[ClassID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 17/06/2021 12:01:51 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RoomID] [int] IDENTITY(1,1) NOT NULL,
	[RoomName] [nvarchar](8) NOT NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Slot]    Script Date: 17/06/2021 12:01:51 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slot](
	[SlotNo] [tinyint] NOT NULL,
	[StartTime] [nvarchar](48) NOT NULL,
	[EndTime] [nvarchar](48) NOT NULL,
 CONSTRAINT [PK_Slot] PRIMARY KEY CLUSTERED 
(
	[SlotNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teacher]    Script Date: 17/06/2021 12:01:51 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teacher](
	[TeacherID] [int] IDENTITY(1,1) NOT NULL,
	[TeacherName] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Teacher] PRIMARY KEY CLUSTERED 
(
	[TeacherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TimeTable]    Script Date: 17/06/2021 12:01:51 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TimeTable](
	[Date] [date] NOT NULL,
	[Slot] [int] NOT NULL,
	[SlotTime] [nvarchar](96) NOT NULL,
	[Class] [nvarchar](16) NOT NULL,
	[Teacher] [nvarchar](100) NOT NULL,
	[Room] [nvarchar](8) NOT NULL,
	[Subject] [nvarchar](96) NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Class] ON 
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (1, N'SE1401')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (2, N'SE1402')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (3, N'SE1403')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (4, N'SE1404')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (5, N'SE1405')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (6, N'BA1401')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (7, N'BA1402')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (8, N'BA1403')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (9, N'IA1401')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (10, N'IA1402')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (11, N'GD1401')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (12, N'GD1402')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (13, N'CS1401')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (14, N'CS1402')
GO
SET IDENTITY_INSERT [dbo].[Class] OFF
GO
SET IDENTITY_INSERT [dbo].[Room] ON 
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (1, N'AL-R201')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (2, N'AL-R202')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (3, N'AL-R203')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (4, N'AL-R204')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (5, N'AL-R205')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (6, N'AL-R206')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (7, N'AL-R207')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (8, N'AL-R208')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (9, N'AL-L401')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (10, N'AL-L402')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (11, N'AL-L403')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (12, N'AL-L404')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (13, N'BE101')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (14, N'BE102')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (15, N'BE103')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (16, N'GA104')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (17, N'GA112')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (18, N'GA501')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (19, N'DE401')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (20, N'DE402')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (21, N'DE403')
GO
SET IDENTITY_INSERT [dbo].[Room] OFF
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (1, N'7h30', N'9h00')
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (2, N'9h10', N'10h40')
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (3, N'10h50', N'12h20')
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (4, N'12h50', N'14h20')
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (5, N'14h30', N'16h00')
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (6, N'16h10', N'17h40')
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (7, N'17h50', N'19h20')
GO
INSERT [dbo].[Slot] ([SlotNo], [StartTime], [EndTime]) VALUES (8, N'19h30', N'21h00')
GO
SET IDENTITY_INSERT [dbo].[Teacher] ON 
GO
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (1, N'KhaBN')
GO
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (2, N'HuanBX')
GO
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (3, N'TienBP')
GO
SET IDENTITY_INSERT [dbo].[Teacher] OFF
GO
INSERT [dbo].[TimeTable] ([Date], [Slot], [SlotTime], [Class], [Teacher], [Room], [Subject]) VALUES (CAST(N'2021-06-17' AS Date), 1, N'7h30 - 9h00', N'SE1401', N'DuongTB', N'AL-R201', N'LAB231')
GO
INSERT [dbo].[TimeTable] ([Date], [Slot], [SlotTime], [Class], [Teacher], [Room], [Subject]) VALUES (CAST(N'2021-06-17' AS Date), 2, N'9h10 - 10h40', N'SE1401', N'DuongTB', N'AL-R201', N'LAB231')
GO
INSERT [dbo].[TimeTable] ([Date], [Slot], [SlotTime], [Class], [Teacher], [Room], [Subject]) VALUES (CAST(N'2021-06-17' AS Date), 3, N'10h50 - 12h20', N'SE1401', N'TriTD', N'AL-R202', N'SWT301')
GO
INSERT [dbo].[TimeTable] ([Date], [Slot], [SlotTime], [Class], [Teacher], [Room], [Subject]) VALUES (CAST(N'2021-06-17' AS Date), 4, N'12h50 - 14h20', N'SE1401', N'TriTD', N'AL-R202', N'SWT301')
GO
INSERT [dbo].[TimeTable] ([Date], [Slot], [SlotTime], [Class], [Teacher], [Room], [Subject]) VALUES (CAST(N'2021-06-17' AS Date), 5, N'14h30 - 16h00', N'SE1402', N'KienLT', N'AL-R202', N'PRN292')
GO
INSERT [dbo].[TimeTable] ([Date], [Slot], [SlotTime], [Class], [Teacher], [Room], [Subject]) VALUES (CAST(N'2021-06-17' AS Date), 6, N'16h10 - 17h40', N'SE1402', N'KienLT', N'AL-R202', N'PRN292')
GO
INSERT [dbo].[TimeTable] ([Date], [Slot], [SlotTime], [Class], [Teacher], [Room], [Subject]) VALUES (CAST(N'2021-06-18' AS Date), 1, N'7h30 - 9h00', N'SE1402', N'KienLT', N'AL-R202', N'PRN292')
GO
USE [master]
GO
ALTER DATABASE [Timetable] SET  READ_WRITE 
GO
