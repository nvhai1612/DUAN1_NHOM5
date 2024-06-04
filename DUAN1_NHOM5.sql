﻿﻿CREATE DATABASE DUAN1_NHOM5
DROP DATABASE DUAN1_NHOM5
USE DUAN1_NHOM5

IF OBJECT_ID ('TAIKHOAN') IS NOT NULL
DROP TABLE TAIKHOAN
CREATE TABLE TAIKHOAN(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   TAIKHOAN NVARCHAR(20),
	   MATKHAU VARCHAR(MAX)
)

IF OBJECT_ID ('NHANVIEN') IS NOT NULL
DROP TABLE NHANVIEN
CREATE TABLE NHANVIEN(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MANV VARCHAR(20),
	   TENNV NVARCHAR(MAX),
	   GIOITINH INT,
	   NGAYSINH DATE,
	   CCCD VARCHAR(13),
	   DIACHI NVARCHAR(MAX),
	   SDT VARCHAR(12),
	   EMAIL VARCHAR(MAX),
	   TRANGTHAINV INT,
	   VAITRO NVARCHAR(20),
	   IDTK UNIQUEIDENTIFIER,

	   FOREIGN KEY (IDTK) REFERENCES TAIKHOAN(ID)
)

IF OBJECT_ID ('MAUSAC') IS NOT NULL
DROP TABLE MAUSAC
CREATE TABLE MAUSAC(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAMS VARCHAR(20),
	   TENMS NVARCHAR(MAX),
	   TRANGTHAIMS INT,
)

IF OBJECT_ID ('CHATLIEU') IS NOT NULL
DROP TABLE CHATLIEU
CREATE TABLE CHATLIEU(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MACL VARCHAR(20),
	   TENCL NVARCHAR(MAX),
	   TRANGTHAICL INT
)

IF OBJECT_ID ('THUONGHIEU') IS NOT NULL
DROP TABLE THUONGHIEU
CREATE TABLE THUONGHIEU(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MATH VARCHAR(20),
	   TENTH NVARCHAR(MAX),
	   TRANGTHAITH INT
)

IF OBJECT_ID ('KICHCO') IS NOT NULL
DROP TABLE KICHCO
CREATE TABLE KICHCO(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAKC VARCHAR(20),
	   TENKC NVARCHAR(MAX),
	   TRANGTHAIKC INT
)

IF OBJECT_ID ('SANPHAM') IS NOT NULL
DROP TABLE SANPHAM
CREATE TABLE SANPHAM(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MASP VARCHAR(20),
	   TENSP NVARCHAR(MAX),
	   TRANGTHAISP INT,
)

IF OBJECT_ID ('PHUONGTHUCTHANHTOAN') IS NOT NULL
DROP TABLE PHUONGTHUCTHANHTOAN
CREATE TABLE PHUONGTHUCTHANHTOAN(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAPTTT VARCHAR(20),
	   TENPTTT NVARCHAR(MAX)
)

IF OBJECT_ID ('KHUYENMAI') IS NOT NULL
DROP TABLE KHUYENMAI
CREATE TABLE KHUYENMAI(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDSP UNIQUEIDENTIFIER,
	   MAKM VARCHAR(20),
	   TENKM NVARCHAR(MAX),
	   MUCGIAMGIA FLOAT,
	   THOIGIANBATDAU DATE,
	   THOIGIANKETTHUC DATE,
	   TRANGTHAIKM INT,
	   SOLUONG INT,

	   FOREIGN KEY (IDSP) REFERENCES SANPHAM(ID)
)

IF OBJECT_ID ('SANPHAMCHITIET') IS NOT NULL
DROP TABLE SANPHAMCHITIET
CREATE TABLE SANPHAMCHITIET(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDMS UNIQUEIDENTIFIER,
	   IDCL UNIQUEIDENTIFIER,
	   IDTH UNIQUEIDENTIFIER,
	   IDKC UNIQUEIDENTIFIER,
	   IDSP UNIQUEIDENTIFIER,
	   MASPCT VARCHAR(20),
	   NGUOITAO NVARCHAR(50),
	   SOLUONGTON INT,
	   MOTA NVARCHAR(MAX),
	   TRANGTHAISPCT INT,
	   DONGIA FLOAT,

	   FOREIGN KEY (IDMS) REFERENCES MAUSAC(ID),
	   FOREIGN KEY (IDCL) REFERENCES CHATLIEU(ID),
	   FOREIGN KEY (IDTH) REFERENCES THUONGHIEU(ID),
	   FOREIGN KEY (IDKC) REFERENCES KICHCO(ID),
	   FOREIGN KEY (IDSP) REFERENCES SANPHAM(ID),
)

IF OBJECT_ID ('KHUYENMAICHITIET') IS NOT NULL
DROP TABLE KHUYENMAICHITIET
CREATE TABLE KHUYENMAICHITIET(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDKM UNIQUEIDENTIFIER,
	   IDSPCT UNIQUEIDENTIFIER,
	   MAKMCT VARCHAR(20),
	   TRANGTHAIKMCT INT,

	   FOREIGN KEY (IDKM) REFERENCES KHUYENMAI(ID),
	   FOREIGN KEY (IDSPCT) REFERENCES SANPHAMCHITIET(ID),
)

IF OBJECT_ID ('KHACHHANG') IS NOT NULL
DROP TABLE KHACHHANG
CREATE TABLE KHACHHANG(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAKH VARCHAR(20),
	   TENKH NVARCHAR(MAX),
	   NGAYSINH DATE,
	   GIOITINH BIT,
	   SDT VARCHAR(12),
	   DIACHI NVARCHAR(MAX),
)

IF OBJECT_ID ('HOADON') IS NOT NULL
DROP TABLE HOADON
CREATE TABLE HOADON(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDKH UNIQUEIDENTIFIER,
	   IDTK UNIQUEIDENTIFIER,
	   IDPTTT UNIQUEIDENTIFIER,
	   MAHD VARCHAR(20),
	   NGAYTAO DATETIME,
	   NGAYTHANHTOAN DATE,
	   TONGTIEN FLOAT,
	   TRANGTHAIHD INT,

	   FOREIGN KEY (IDKH) REFERENCES KHACHHANG(ID),
	   FOREIGN KEY (IDTK) REFERENCES TAIKHOAN(ID),
	   FOREIGN KEY (IDPTTT) REFERENCES PHUONGTHUCTHANHTOAN(ID)
)

IF OBJECT_ID ('HOADONCT') IS NOT NULL
DROP TABLE HOADONCT
CREATE TABLE HOADONCT(
	   ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDHD UNIQUEIDENTIFIER,
	   IDSPCT UNIQUEIDENTIFIER,
	   MAHDCT VARCHAR(20),
	   NGAYTAO DATETIME,
	   DONGIA FLOAT,
	   DONGIASAUKHIGIAM FLOAT,
	   SOLUONG INT,

	   FOREIGN KEY (IDHD) REFERENCES HOADON(ID),
	   FOREIGN KEY (IDSPCT) REFERENCES SANPHAMCHITIET(ID),
)

--INSERT TAIKHOAN
INSERT INTO TAIKHOAN (TAIKHOAN,MATKHAU) VALUES
('hainvph24897',N'nvhai1612'),
('nhungnt',N'nhungxinhdep'),
('ngocnt',N'123456'),
('tungnv',N'123456'),
('hoangbv',N'123456'),
('hiepnb',N'123456')


-- INSERT NHANVIEN
INSERT INTO NHANVIEN (MANV,TENNV,GIOITINH,NGAYSINH,CCCD,DIACHI,SDT,EMAIL,TRANGTHAINV,VAITRO,IDTK) VALUES
('NV01',N'Nguyễn Văn Hải',1,'12/16/2003','001203030101',N'Hà Nội','0327213548','nvhai1612@gmail.com',1,N'Quản lý','004A406A-1232-4487-84FD-7F5C8727FCE1'),
('NV02',N'Nguyễn Thị Nhung',0,'01/20/2000','001203987617',N'Thạch Thất','0962474048','nhungnt0801@gmail.com',1,N'Quản lý','39E194D6-C797-4780-8458-A9D6269B8FA9'),
('NV03',N'Nguyễn Bích Ngọc',0,'03/09/2004','001298768787',N'Thái Bình','0346567677','ngocnt@gmail.com',0,N'Nhân viên','687952C9-5A86-44B6-A6FB-D409A7CAB0E2'),
('NV04',N'Nguyễn Văn Tùng',1,'05/11/2003','001202098789',N'Đông Anh','0976541482','tungnv0976541482@gmail.com',1,N'Nhân viên','DC5B1B79-E198-46B1-B323-96FD2BDDB65E'),
('NV05',N'Bùi Vũ Hoàng',1,'06/22/2002','001202098789',N'Nghệ An','0976541482','hoangbv@gmail.com',0,N'Nhân viên','4A0DC28D-2AE7-4F1A-84FE-B9DBA08FF849'),
('NV06',N'Nguyễn Bá Hiệp',1,'07/13/1999','001202098789',N'Quảng Ninh','0976541482','hiepnb@gmail.com',1,N'Nhân viên','CBEF100D-A24F-4E89-A0A7-B6D76879147F')


-- INSERT MAUSAC
INSERT INTO MAUSAC (MAMS,TENMS,TRANGTHAIMS) VALUES
('MS01',N'Xám',1),
('MS02',N'Đen',1),
('MS03',N'Trắng',1),
('MS04',N'Xanh',0),
('MS05',N'Hồng',1)


-- INSERT CHATLIEU
INSERT INTO CHATLIEU (MACL,TENCL,TRANGTHAICL) VALUES
('CL01',N'Kaki',1),
('CL02',N'Cotton',1),
('CL03',N'Polyester',1),
('CL04',N'Denim',1),
('CL05',N'Nano',0)


-- INSERT THUONGHIEU
INSERT INTO THUONGHIEU(MATH,TENTH,TRANGTHAITH) VALUES
('TH01',N'Denimst',1),
('TH02',N'Coolmate',1),
('TH03',N'Hussio',1),
('TH04',N'Pattern',1),
('TH05',N'SSStutter',1)


-- INSERT KICHCO
INSERT INTO KICHCO (MAKC,TENKC,TRANGTHAIKC) VALUES
('KC01',N'M',1),
('KC02',N'L',1),
('KC03',N'XL',1),
('KC04',N'XXL',1),
('KC05',N'XXXL',0)


-- INSERT SANPHAM
INSERT INTO SANPHAM (MASP,TENSP,TRANGTHAISP) VALUES
('SP01',N'Sơ mi cộc tay cổ bẻ',1),
('SP02',N'Sơ mi cộc tay cổ tàu',1),
('SP03',N'Sơ mi dài tay cổ bẻ',1),
('SP04',N'Sơ mi dài tay cổ tàu',1)


-- INSERT PHUONGTHUCTHANHTOAN
INSERT INTO PHUONGTHUCTHANHTOAN (MAPTTT,TENPTTT) VALUES
('PTTT01',N'Quét mã'),
('PTTT02',N'Tiền mặt')


-- INSERT SPCT
INSERT INTO SANPHAMCHITIET (MASPCT,IDMS,IDCL,IDTH,IDKC,IDSP,NGUOITAO,SOLUONGTON,MOTA,TRANGTHAISPCT,DONGIA) VALUES
('SPCT01','2917F74A-064D-4760-BAAD-2E3EC3AD8B09','49DDE4CD-7615-4DED-9625-33A9B9D779EE',
'A79E1A86-652E-4AA5-804B-101E3298317E','D9CC5357-BD00-4397-A3D2-2D2FB14BF710',
'0D102B90-9DFE-40A6-921A-07148BF262A8',N'Nguyễn Văn Hải',100,N'chất liệu thoáng mát',1,800000),
('SPCT02','10152348-1FF1-495D-808E-3CC9874A84E8','15E43965-4EB5-4D65-9728-549EBBE5698A',
'6BD33C97-F323-4E24-8C84-49F638502DBA','0CE72144-FE06-403E-B8F1-4B3BE7497706',
'3751C971-5D56-41D9-9FEA-8EECB6E1A6ED',N'Nguyễn Văn Hải',200,N'sang trọng, lịch lãm',1,700000),
('SPCT03','32586674-66D3-4557-998F-6EA470E2026B','18695E27-809C-4439-B58D-79FEDAE38904',
'D05BA78F-3ABB-44B4-B593-571796960A44','35DB83DE-954F-4E7C-BFFD-65815D26F3FB',
'1D9ED1EC-3E8E-40F7-A4D2-DE28EBD08C98',N'Nguyễn Thị Nhung',300,N'trẻ trung, năng động',1,700000)


-- INSERT KHACHHANG
INSERT INTO KHACHHANG (MAKH,TENKH,NGAYSINH,GIOITINH,SDT,DIACHI) VALUES
('KH01',N'Nguyễn Cầu Giấy','12/09/2000',1,'0987878787',N'Sài Gòn'),
('KH02',N'Trần Thanh Xuân','08/09/1997',1,'0987678787',N'Hà Nội'),
('KH03',N'Lê Ba Đình','11/03/2003',0,'0347878787',N'Hà Nội')


-- INSERT KHUYENMAI
insert into KHUYENMAI (IDSP,MAKM,TENKM,MUCGIAMGIA,THOIGIANBATDAU,THOIGIANKETTHUC,TRANGTHAIKM,SOLUONG) values 
('1D9ED1EC-3E8E-40F7-A4D2-DE28EBD08C98','KM01',N'Sale 11/11/2021',30,'11/11/2021','11/12/2021',0,500),
('5461B89B-6C2C-4E72-B750-CF10728B5CA0','KM02',N'Sale 12/12/2021',10,'12/12/2021','12/13/2021',0,200),
('0D102B90-9DFE-40A6-921A-07148BF262A8','KM03',N'Sale 04/04/2024',20,'04/04/2025','04/04/2023',1,100)


-- INSERT KHUYENMAICHITIET
INSERT INTO KHUYENMAICHITIET (MAKMCT,IDKM,IDSPCT,TRANGTHAIKMCT) VALUES
('KMCT01','5FE2AF4D-79DD-4A61-9219-0EEF7E9C627F','698B6CFC-5D35-426F-B78D-41B0E2FC85D1',1),
('KMCT02','83A3D467-EA9B-4678-ACEF-FADFFEA504C0','25DA667E-80B2-4959-9256-27FC3AE17999',0)


select * from TAIKHOAN
select MANV,TENNV,GIOITINH,NGAYSINH,CCCD,DIACHI,SDT,EMAIL,TRANGTHAINV from NHANVIEN
select * from MAUSAC
select * from CHATLIEU
select * from THUONGHIEU
select * from KICHCO
select * from SANPHAM
select * from PHUONGTHUCTHANHTOAN
select * from KHUYENMAI
select * from SANPHAMCHITIET
select * from KHUYENMAICHITIET
select * from KHACHHANG
select * from HOADON
select * from HOADONCT
delete from hoadonct where id = '7E25494F-8830-4DC2-AB31-D6991E19CB3B'

select mahdct from HOADONCT hd join SANPHAMCHITIET sp on hd.IDSPCT = sp.ID where sp.MASPCT = ?
SELECT MASPCT,TENSP,SOLUONGTON,NGUOITAO,TRANGTHAISPCT,TENCL,TENKC,TENMS,TENTH,DONGIA FROM SANPHAMCHITIET JOIN SANPHAM ON SANPHAMCHITIET.IDSP = SANPHAM.ID JOIN CHATLIEU ON SANPHAMCHITIET.IDCL = CHATLIEU.ID JOIN KICHCO ON SANPHAMCHITIET.IDKC = KICHCO.ID JOIN THUONGHIEU ON SANPHAMCHITIET.IDTH = THUONGHIEU.ID JOIN MAUSAC ON SANPHAMCHITIET.IDMS = MAUSAC.ID

SELECT * from HoaDon LEFT join TAIKHOAN n on hoadon.idtk = n.id

delete from PHUONGTHUCTHANHTOAN

delete from SANPHAM

SELECT MASPCT,TENSP,SOLUONGTON,IDCL,IDKC,IDMS,IDTH,DONGIA,SANPHAMCHITIET.id FROM SANPHAMCHITIET JOIN SANPHAM ON SANPHAMCHITIET.IDSP = SANPHAM.ID JOIN CHATLIEU ON SANPHAMCHITIET.IDCL = CHATLIEU.ID JOIN KICHCO ON SANPHAMCHITIET.IDKC = KICHCO.ID JOIN THUONGHIEU ON SANPHAMCHITIET.IDTH = THUONGHIEU.ID JOIN MAUSAC ON SANPHAMCHITIET.IDMS = MAUSAC.ID WHERE MASPCT = 'SPCT03'

SELECT MASPCT,TENSP,SOLUONG,SANPHAMCHITIET.DONGIA FROM HOADON INNER JOIN
                  HOADONCT ON HOADON.ID = HOADONCT.IDHD INNER JOIN
                  SANPHAMCHITIET ON HOADONCT.IDSPCT = SANPHAMCHITIET.ID Join
				  SANPHAM ON SANPHAMCHITIET.IDSP = SANPHAM.ID WHERE MAHD = 'SP7995' 

select MaHD,IDKH,IDTK,h.TRANGTHAIHD,MASP,TENSP,SOLUONG,hc.DONGIA from hoadonct hc join hoadon h on h.id = hc.IDHD join SANPHAMCHITIET sc on sc.id = hc.IDSPCT join sanpham s on s.id = sc.IDSP