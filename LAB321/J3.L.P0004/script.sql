USE [J3.L.P0004]
GO
/****** Object:  Table [dbo].[News]    Script Date: 6/3/2021 9:57:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[id] [int] NOT NULL,
	[title] [nvarchar](max) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[image] [nvarchar](max) NOT NULL,
	[author] [nvarchar](max) NOT NULL,
	[postTime] [datetime] NULL,
	[shortDescription] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Digital] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (1, N'Video Chelsea - Arsenal: Sai lầm "chết người", ám ảnh xà ngang', N'Thực tế cũng chứng minh điều đó khi Chelsea nắm quyền kiểm soát thế trận ngay sau tiếng còi khai cuộc. Phút 11, Havertz cướp bóng từ chân Mari ở giữa sân và băng một mạch xuống để đối mặt với thủ thành Leno nhưng lại dứt điểm lên trời trong tư thế thuận lợi.

Chỉ 5 phút sau, bước ngoặt của trận đấu đã tới. Jorginho có pha chuyền bóng về bất cẩn khiến Kepa phải bay người hết cỡ để cản phá. Aubameyang đón được bóng nảy ra và bình tĩnh chuyền ngược ra cho Smith Rowe dứt điểm đem về bàn mở tỉ số trận đấu.

Nhận bàn thua đau, Chelsea tổ chức tấn công liên tục để tìm bàn gỡ. Arsenal hầu như không có sự đáp trả nào nhưng vẫn đứng vững qua hiệp một. Sang đến hiệp hai, Tuchel thay đổi nhân sự để tìm sự tươi mới trên hàng công. Phút 61, Pulisic đưa được bóng vào lưới đối phương nhưng trọng tài không công nhận do lỗi việt vị. 

Tuy nhiên, tình huống đáng tiếc nhất của Chelsea tới ở phút 90. Zouma đánh đầu ngược đưa bóng trúng xà ngang, Giroud băng vào đá bồi nhưng cũng trúng xà ngang lần nữa dù thủ thành Leno đã chôn chân đứng nhìn. Kết thúc trận đấu, Arsenal bất ngờ giành chiến thắng tối thiểu.', N'i1.jpg', N'Ngọc Lâm - Tiến Tài', CAST(N'2021-05-13T15:02:11.000' AS DateTime), N'Bàn thắng duy nhất của trận đấu tới từ một sai lầm "chết người" trong khi xà ngang sắm vai người hùng.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (2, N'Choáng HLV Conte chửi thẳng mặt SAO Inter Milan vì phản ứng gây sốc', N'Sau khi chính thức đăng quang ở Serie A 2020/21, Inter Milan tiếp tục có chiến thắng dễ dàng 3-1 trước AS Roma trên sân nhà ở vòng 36. Tuy nhiên, trận đấu này có một sự vụ đáng chú ý liên quan đến HLV Conte và tiền đạo Lautaro Martinez. Số là Lautaro không đá chính ở trận này và chỉ được tung vào sân ở phút 36 thay Alexis Sanchez gặp chấn thương. Tuy nhiên anh chỉ được thi đấu hơn 40 phút và bị rút ra sân ở phút 77 nhường chỗ cho Andrea Pinamonti mà không có đóng góp nào cụ thể.

Trên đường rời sân, Lautaro buông một ánh nhìn đầy giận dữ hướng thẳng đến Conte, người dường như phớt lờ sự hiện diện của anh. Nhận thấy thái độ này của ông thầy, tiền đạo người Argentina phản ứng dữ dội khi đá bay một chai nước trên đường pitch.

Nhìn phản ứng này, chiến lược gia người Italia không kiềm chế nổi và lập tiếng lên tiếng “dằn mặt” cậu học trò: “Biết điều đi! Cậu tức với ai? Đừng bao giờ có cái thái độ đấy lần nữa!”. Đáp lại, Lautaro cởi phăng chiếc áo đấu, vo viên trên tay rồi đưa ra một loạt động thái bất bình.

Sau trận, Conte không xuất hiện trong buổi họp báo để tránh né những câu hỏi về tình hình tài chính của câu lạc bộ và người thay ông là trợ lý Cristian Stellini. Ông này đã có những giải thích về sự vụ trên sân giữa Conte và Lautaro.

“Đây là điều từng xảy ra với chính tôi cách đây 14 năm hồi tôi còn là cầu thủ và Conte là thầy tôi. Ông ấy thay tôi ra sau 20 phút”, Stellini nói với Sky Sport Italia. “Đấy là một ví dụ về tinh thần thi đấu mà chúng tôi muốn thấy. Ngay cả khi mọi thứ đã an bài, chúng tôi vẫn mong các cầu thủ cống hiến tận cùng.', N'i2.jpg', N'Minh Đức', CAST(N'2021-05-13T17:20:12.000' AS DateTime), N'LV Antonio Conte và tiền đạo Lautaro Martinez của Inter Milan đã có những giây phút căng thẳng ngay trên sân ở trận đấu với AS Roma đêm qua.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (3, N'MU dám tung 80 triệu bảng mua Sancho: Dortmund gật đầu, "bom tấn" dễ nổ', N'Sancho từng là mục tiêu số 1 của MU ở kỳ chuyển nhượng mùa hè năm ngoái. “Quỷ đỏ” được cho là đã đưa ra lời đề nghị trị giá 91 triệu bảng dành cho tài năng người Anh nhưng đã bị Dortmund từ chối khi đội bóng nước Đức đòi 108 triệu bảng. Tuy nhiên, mọi thứ có vẻ như đã thay đổi sau gần 1 năm. Cách đây ít ngày, tờ Sky Sports đưa tin Dortmund sẵn sàng cho phép Sancho ra đi ngay trong mùa hè này nếu nhận được lời đề nghị 80 triệu bảng.

Trong khi đó, MU vẫn đang theo sát mọi tình hình của Sancho. Theo nguồn tin của tờ Daily Star, “Quỷ đỏ” cũng đang chuẩn bị đưa ra lời đề nghị ban đầu trị giá 80 triệu bảng. Nếu thông tin này là sự thật, nhiều khả năng tuyển thủ Anh sẽ cập bến Old Trafford ngay trong mùa hè này.

Sancho vẫn đang có phong độ khá tốt ở mùa giải này. Cựu cầu thủ của Man City đã ghi được 14 bàn thắng và cung cấp 18 pha kiến ​​tạo trong 35 trận cho Dortmund trên mọi đấu trường. Sự xuất hiện của tài năng trẻ 21 tuổi chắc chắn sẽ giúp hàng công của MU trở nên đáng sợ hơn rất nhiều ở mùa giải tới.', N'i1.jpg', N'Sỹ Anh', CAST(N'2021-05-12T02:12:00.000' AS DateTime), N'MU được cho là sẵn sàng chi ra số tiền rất lớn dành cho Jadon Sancho của Dortmund vào mùa hè này.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (4, N'Fan Liverpool phẫn nộ vì MU "đội hình 3" thua Leicester, "dọa báo thù" mùa tới', N'Vì lịch thi đấu dày đặc, HLV Ole Gunnar Solskjaer đã thay tới 10 vị trí trong đội hình xuất phát của MU so với trận gặp Aston Villa, khi chỉ Mason Greenwood được giữ lại. Những cái tên đá chính còn lại đều không phải là sự lựa chọn thường xuyên của Solskjaer ở Premier League. Đây có thể coi là "đội hình 3" của MU bởi có nhiều cầu thủ chỉ là sự lựa chọn thứ 3 ở vị trí của họ như Axel Tuanzebe hay Brandon Williams, trong khi những Van de Beek, Mata hay Alex Telles đều hiếm khi được ra sân, bên cạnh đó còn là 2 sao trẻ tuổi teen Amad Diallo và Anthony Elanga.

Phát biểu trên beIN Sports, chuyên gia Andy Gray không hài lòng với quyết định của Solskjaer. Ông cho rằng MU gây ảnh hưởng đến sự công bằng trong cuộc đua đến top 4 mùa này. "Tôi biết Solskjaer sẽ có những sự điều chỉnh, nhưng không thể ngờ ông ta lại thực hiện đến 10 sự thay đổi. CĐV Liverpool chắc chắn cảm thấy thất vọng với MU ở trận đấu này", chuyên gia Gray cho biết.', N'i1.jpg', N'Minh Đức', CAST(N'2021-05-12T03:04:00.000' AS DateTime), N'Các CĐV Liverpool bày tỏ sự phẫn nộ ngay khi MU công bố đội hình ra sân trước Leicester, và càng buồn chán hơn sau khi trận đấu này kết thúc.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (5, N'ĐT Việt Nam rèn quân dưới mưa to, luyện bài tủ đấu Malaysia, UAE', N'Chiều 11/5, ĐT Việt Nam tiếp tục có buổi tập trên sân của Trung tâm đào tạo bóng đá trẻ Việt Nam (Hà Nội), chuẩn bị cho chiến dịch vòng loại World Cup 2022 khu vực châu Á.

Ở buổi tập này, thời tiết đã không ủng hộ thầy trò HLV Park Hang Seo. Sau phần khởi động, trời đổ mưa rất to, kèm theo gió và sấm chớp. Với điều kiện thời tiết không thuận lợi, nhiều người nghĩ rằng HLV Park Hang Seo sẽ cho toàn đội được nghỉ. Tuy nhiên, chiến lược gia người Hàn Quốc vẫn chỉ đạo các cầu thủ tập luyện bình thường. Ông Park còn trực tiếp ra sân hướng dẫn Quang Hải, Công Phượng và các đồng đội làm quen với bài tập mới.

HLV Park Hang Seo chia hơn 30 cầu thủ thành 2 đội đá đối kháng trên 1/2 sân. Các cầu thủ đội tuyển Việt Nam đã có một trận thuỷ chiến thực sự. Mưa trắng trời nhưng tất cả vẫn thi đấu rất quyết tâm, bởi ai cũng muốn ghi điểm với thầy Park.

Việc HLV Park Hang Seo cho toàn đội tập dưới mưa vừa là để đánh giá sự bền bỉ, khả năng thích nghi của các cầu thủ, nhưng quan trọng hơn thời gian từ nay tới vòng loại World Cup 2022 không còn nhiều, nên chiến lược gia người Hàn Quốc hạn chế tối đa việc dừng tập.', N'i1.jpg', N'T.A', CAST(N'2021-05-11T05:06:00.000' AS DateTime), N'Cơn mưa như trút nước kéo dài gần 1 tiếng đồng hồ không ngăn cản được sự quyết tâm tập luyện của đội tuyển (ĐT) Việt Nam.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (6, N'Sốc bóng đá TBN: Thua đau, 2 SAO rút dao đâm đối thủ, lĩnh án 20 năm tù', N'Theo tờ Mundo Deportivo, tòa án Tây Ban Nha vừa kết án hai cầu thủ của CLB El Paco B (một đội bóng ở Malaga) với mức án tổng cộng lên đến 20 năm tù vì tội cố ý giết người khi rút dao đâm một đồng nghiệp 24 tuổi ở đội Alhaurín de la Torre B sau trận đấu của 2 đội bóng này tại Malaga ngày 20/3/2016. Hãng thông tấn Efe còn cho biết, cùng với việc phải ngồi “bóc lịch” dài hạn sau song sắt, hai cầu thủ hóa kẻ hung đồ này còn phải nộp phạt cho nạn nhân số tiền lên tới 68.894 euro (gần 2 tỷ đồng).

Các bị cáo cũng không được đến gần cầu thủ bị hành hung hay hoặc đến địa điểm người này hay lui tới ở khoảng cách tối thiểu 1.000m trong 11 năm tới.

Trận đấu tai tiếng kể trên diễn ra khi El Paco B tiếp đón các vị khách Alhaurín de la Torre B trên sân bóng ở khu phố Palo của tháp Malaga tại giải đấu hạng 3 của Tây Ban Nha ngày 20/3/2016. Ở trận này, El Paco B đã thua đau đối thủ.

Trong màn so tài này, 2 đội trưởng của CLB El Paco B và Alhaurín de la Torre B đã nảy sinh mâu thuẫn. Đội trưởng của đội chủ nhà El Paco B (một trong hai bị cáo của phiên tòa kể trên) đã tỏ thái độ hung hăng thái quá và nhiều lần dọa giết cầu thủ đội trưởng của đội khách Alhaurín de la Torre B.

“Tao sẽ giết mày”, “Cứ mỗi phút trôi qua, tao sẽ đợi để giết mày. Chúng ta sẽ gặp nhau bên ngoài sân đấu. Tao sẽ đợi mày”, gã đàn ông hung tợn này hăm dọa đối phương.', N'i1.jpg', N'Đăng Đức', CAST(N'2021-05-11T07:08:00.000' AS DateTime), N'“Giận quá mất khôn”, 2 cầu thủ của đội bóng Tây Ban Nha El Pado B đã hóa thành những kẻ côn đồ đáng sợ khi rút hung khí sát hại một đồng nghiệp bên kia chiến tuyến trong một trận đấu căng thẳng đến nghẹt thở.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (7, N'Fernandes ve vãn đồng đội cũ sang MU: SAO Brazil có giá 45 triệu bảng', N'Tiền vệ Bruno Fernandes vừa tiếp tục cho thấy quyết tâm lôi kéo đồng đội cũ Raphinha tới Man United. Raphinha hiện đang thuộc biên chế của Leeds United nhưng anh từng cùng Bruno Fernandes khoác áo Sporting trước đây. Raphinha đã trở lại sau chấn thương và góp mặt trong chiến thắng 3-1 của Leeds United trước Tottenham. Ngay sau khi trận đấu khép lại, Bruno Fernandes đã đưa ra một thông điệp tới cầu thủ chạy cánh được coi là hiện tượng của Ngoại hạng Anh mùa này.

Ngôi sao MU đã trả lời trên trang Instagram cá nhân của Raphinha bằng một bình luận ngắn gọn: "Tôi là người hâm mộ của bạn". Rõ ràng, Bruno Fernandes đánh giá rất cao tài năng và tầm ảnh hưởng của Raphinha kể từ khi cầu thủ này chuyển tới Leeds United hồi đầu mùa. 

Phong độ cao của tiền vệ người Brazil đã thu hút sự quan tâm của rất nhiều đội bóng tại Ngoại hạng Anh, trong đó có cả MU. "Quỷ đỏ" đang chơi một thứ bóng đá đầy tốc độ, hoàn toàn phù hợp với tố chất của Raphinha. Bởi vậy, tiền vệ 24 tuổi được coi là mục tiêu hàng đầu mà MU hướng tới khi thị trường chuyển nhượng mùa hè mở cửa.', N'i1.jpg', N'Việt Thành', CAST(N'2021-05-10T08:09:00.000' AS DateTime), N'Tiền vệ Bruno Fernandes vừa có động thái lôi kéo người đồng đội cũ Raphinha gia nhập Man United vào mùa hè tới.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (8, N'Điểm nhấn vòng 35 Ngoại hạng Anh: "Vua ngược dòng" MU khiến Man City "hậm hực"', N'Người hâm mộ đã quá quen với những màn ngược dòng của MU ở mùa giải 2020/21. Đến vòng 35 Ngoại hạng Anh cuối tuần qua, thầy trò Ole Gunnar Solskjaer lại biến Aston Villa thành "nạn nhân" tiếp theo khi giành chiến thắng 3-1 trong thế bị dẫn bàn. Theo thống kê, MU kiếm tổng cộng 31 điểm, giành 10 chiến thắng sau khi bị thủng lưới trước tại Ngoại hạng Anh 2020/21. Chiến thắng này cũng giúp họ nối dài chuỗi trận bất bại trên sân khách tại giải đấu hàng đầu "xứ sở sương mù" lên con số 25.

Do đội hạng 5 West Ham thua Everton 0-1, MU chính thức tiếp bước Man City trở thành đại diện thứ 2 của Ngoại hạng Anh giành vé dự Champions League 2021/22. Hiện "Quỷ đỏ" hơn West Ham 12 điểm và đá ít hơn 1 trận, trong khi mùa giải chỉ còn 3 vòng nữa.

Việc chắc chắn dự Champions League giúp MU có tâm lý thoải mái trước chặng "mini-tourmalet" sắp tới. Từ ngày 12/5 đến 14/5, họ lần lượt bước vào những cuộc đại chiến với Leicester City (vòng 36) và Liverpool (đá bù vòng 34). ', N'i1.jpg', N'Đỗ Anh', CAST(N'2021-05-10T09:10:00.000' AS DateTime), N'MU khẳng định đẳng cấp của "vua ngược dòng", Chelsea khiến Man City chưa thể vô địch sớm, đồng thời chiếm ưu thế lớn trong cuộc đua vào top 4.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (9, N'Greenwood sút hai chân như một, chính thức phá kỷ lục của Rooney', N'Mason Greenwood vừa có thêm một bàn thắng nữa cho MU trong mùa giải này. Tài năng trẻ người Anh là người nâng tỉ số lên thành 2-1 trong chuyến làm khách tại Villa Park của “Quỷ đỏ”. Đó là pha bóng đẳng cấp khi Greenwood đánh lừa được Tyron Mings, cầu thủ cao hơn mình rất nhiều để dứt điểm vào góc gần bằng chân trái. Bàn thắng này cũng là pha lập công thứ 16 của Mason Greenwood tại Ngoại hạng Anh. Như vậy, tài năng trẻ người Anh chính thức vượt mặt người đàn anh Wayne Rooney để trở thành cầu thủ dưới 20 tuổi ghi nhiều bàn nhất cho MU tại Ngoại hạng Anh.

Trước đó, Wayne Rooney vượt qua người đàn anh Ryan Giggs (12 bàn) để nắm giữ kỷ lục này với 15 bàn thắng. Marcus Rashford nằm trong Top 3 với 13 bàn thắng trong khi đó Ronaldo góp mặt trong Top 5 với 8 bàn thắng.

Đây là thành tích có thể dự báo trước của Mason Greenwood nếu như thường xuyên theo dõi cầu thủ này thi đấu. Chưa đầy 20 tuổi nhưng tài năng trẻ người Anh đã chiếm một vị trí chính thức trong đội hình xuất phát của MU.', N'i1.jpg', N'Ngọc Lâm', CAST(N'2021-05-10T10:11:00.000' AS DateTime), N'Mason Greenwood chính thức vượt qua Wayne Rooney để trở thành cầu thủ dưới 20 tuổi ghi bàn nhiều nhất cho MU tại Ngoại hạng Anh.')
INSERT [dbo].[News] ([id], [title], [description], [image], [author], [postTime], [shortDescription]) VALUES (10, N'Fernandes sút penalty khiến Aguero hổ thẹn, sắp được MU thưởng to', N'MU lại vừa có một màn lội ngược dòng xuất sắc tại giải Ngoại hạng Anh mùa này. Tối 9/5, “Quỷ đỏ” bị Aston Villa dẫn trước nhưng đã xuất sắc đảo ngược tình thế trên đất khách bằng 3 pha lập công của Bruno Fernandes, Mason Greenwood và Edinson Cavani để thắng ngược 3-1 và cản bước Man City đăng quang sớm chức vô địch trước 3 vòng đấu. Người gỡ hòa cho MU trên sân Villa Park vừa qua chính là Bruno Fernandes với một cú sút penalty kiểu nhảy chân sáo đưa bóng đi chìm hiểm hóc để hạ gục thủ thành Emiliano Martinez phút 52.

Đó chính là bàn thắng thứ 27 của cầu thủ mang áo số 18 ghi cho “nửa đỏ thành Manchester” trên mọi đấu trường mùa này. Bruno Fernandes đã chính thức san bằng kỷ lục của huyền thoại Frank Lampard (Chelsea, mùa giải 2009/10) để cùng sở hữu chiến tích là tiền vệ ghi nhiều bàn thắng nhất cho 1 CLB Ngoại hạng Anh trên tất cả các mặt trận trong 1 mùa giải.

Tình huống sút 11m của Bruno Fernandes cũng là lần thứ 113, các trọng tài thổi phạt đền ở giải Ngoại hạng Anh mùa 2020/21, phá kỷ lục đã tồn tại trước đó  (112 quả penalty tại giải đấu này vào mùa 2013/14).

Đáng chú ý, trước khi Bruno Fernandes sút phạt đền chỉ 1 ngày, tiền đạo siêu sao Sergio Aguero đã đá hỏng quả penalty và bỏ lỡ cơ hội giúp Man City nâng tỷ số lên 2-0 khi đón tiếp Chelsea trên sân nhà Etihad cũng ở vòng 35 giải Ngoại hạng Anh.', N'i1.jpg', N'Đăng Đức', CAST(N'2021-05-09T11:12:00.000' AS DateTime), N'Cùng được giao trọng trách thực hiện những quả phạt đền rất quan trọng cuối tuần qua cho 2 đội bóng thành Manchester ở vòng 35 giải Ngoại hạng Anh, nhưng Sergio Aguero và Bruno Fernandes đã cho thấy sự khác biệt lớn giữa họ. Một đặc ân lớn cũng đang chuẩn bị được MU ban cho ngôi sao mang áo số 18 của mình.')
