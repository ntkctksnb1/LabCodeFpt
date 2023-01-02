
USE [Quiz]
GO
/****** Object:  Table [dbo].[QuizQuestion]    Script Date: 15/07/2021 11:51:53 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuizQuestion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[problem] [nvarchar](2048) NOT NULL,
	[option1] [nvarchar](1024) NULL,
	[option2] [nvarchar](1024) NULL,
	[option3] [nvarchar](1024) NULL,
	[option4] [nvarchar](1024) NULL,
	[answer] [nvarchar](64) NOT NULL,
	[creator] [int] NULL,
	[createdDate] [date] NULL,
 CONSTRAINT [PK_QuizQuestion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 15/07/2021 11:51:53 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NOT NULL,
	[email] [nvarchar](128) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[QuizQuestion] ON 
GO
INSERT [dbo].[QuizQuestion] ([id], [problem], [option1], [option2], [option3], [option4], [answer], [creator], [createdDate]) VALUES (1, N'1+2', N'2', N'3', N'4', N'5', N'1', 2, CAST(N'2021-05-11' AS Date))
GO
INSERT [dbo].[QuizQuestion] ([id], [problem], [option1], [option2], [option3], [option4], [answer], [creator], [createdDate]) VALUES (2, N'2+3', N'5', N'6', N'7', N'8', N'1', 2, CAST(N'2021-05-12' AS Date))
GO
INSERT [dbo].[QuizQuestion] ([id], [problem], [option1], [option2], [option3], [option4], [answer], [creator], [createdDate]) VALUES (3, N'5+6', N'14', N'1', N'13', N'11', N'4', 2, CAST(N'2021-05-22' AS Date))
GO
INSERT [dbo].[QuizQuestion] ([id], [problem], [option1], [option2], [option3], [option4], [answer], [creator], [createdDate]) VALUES (4, N'7+8', N'15', N'25', N'35', N'45', N'1', 2, CAST(N'2021-05-13' AS Date))
GO
INSERT [dbo].[QuizQuestion] ([id], [problem], [option1], [option2], [option3], [option4], [answer], [creator], [createdDate]) VALUES (14, N'16x2', N'32', N'64', N'33', N'34', N'1', 2, CAST(N'2021-07-15' AS Date))
GO
SET IDENTITY_INSERT [dbo].[QuizQuestion] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 
GO
INSERT [dbo].[User] ([id], [username], [password], [type], [email]) VALUES (1, N'kienloz', N'123456', N'student', N'kien@gm.com')
GO
INSERT [dbo].[User] ([id], [username], [password], [type], [email]) VALUES (2, N'ntkctksnb1', N'123456', N'Teacher', N'kienlaoz@gmai.com')
GO
INSERT [dbo].[User] ([id], [username], [password], [type], [email]) VALUES (3, N'kiennthe141019', N'123456', N'Student', N'kiennnt@gmail.com')
GO
SET IDENTITY_INSERT [dbo].[User] OFF
GO
USE [master]
GO
ALTER DATABASE [Quiz] SET  READ_WRITE 
GO
