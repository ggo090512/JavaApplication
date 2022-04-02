USE QLBaoBiGiayHungTuan
GO
CREATE TABLE VITRI
(
	MaViTri VARCHAR(2),
	TenVT NVARCHAR(30),
	CONSTRAINT PK_VITRI PRIMARY KEY (MaViTri)
)
GO
CREATE TABLE NHANVIEN
(
	MaNV VARCHAR(5) NOT NULL,
	TenNV NVARCHAR(30) NOT NULL,
	NgaySinh DATETIME,
	QueQuan NVARCHAR(30),
	CMND INT NOT NULL UNIQUE,
	GioiTinh NVARCHAR(3),
	SDT VARCHAR(10) NOT NULL,
	Email VARCHAR(30),
	MaViTri VARCHAR(2),
	LuongCB INT NOT NULL,
	CONSTRAINT PK_NHANVIEN PRIMARY KEY(MaNV),
	Constraint FK_VITRI Foreign Key(MaViTri) References VITRI(MaViTri)
)
GO
CREATE TABLE GIAY
(
	MaGiay INT IDENTITY(1,1),
	TenGiay NVARCHAR(50) NOT NULL,
	GiaGiay INT NOT NULL,
	CONSTRAINT PK_LOAIGIAY PRIMARY KEY (MaGiay)
)
GO
CREATE TABLE MUC
(
	MaMuc INT IDENTITY(1,1),
	TenMuc NVARCHAR(50) NOT NULL,
	GiaMuc INT NOT NULL,
	CONSTRAINT PK_LOAIMUC PRIMARY KEY (MaMuc)
)
GO
CREATE TABLE LOAISP
(
	MaLoai INT IDENTITY(1,1),
	TenLoaiSP NVARCHAR(50) NOT NULL,
	CONSTRAINT PK_LOAISP PRIMARY KEY (MaLoai)
)
GO
CREATE TABLE SANPHAM
(
	MaSP INT IDENTITY(1,1),
	TenSP NVARCHAR(50) NOT NULL,
	GiaSP INT ,
	MaLoai INT NOT NULL,
	CONSTRAINT PK_SANPHAM PRIMARY KEY(MaSP),
	Constraint FK_LOAISP Foreign Key(MaLoai) References LOAISP(MaLoai)
)
GO
CREATE TABLE KHACHHANG
(
	MaKH INT IDENTITY(1,1),
	TenKH NVARCHAR(50) NOT NULL,
	CongTy NVARCHAR(50) ,
	DiaChi NVARCHAR(50) ,
	SDT VARCHAR(20) ,
	Email VARCHAR(100)  UNIQUE,
	CONSTRAINT PK_KHACHHANG PRIMARY KEY(MaKH)
)
GO
CREATE TABLE CHITIETDONHANG
(
	MaHoaDon int not null,
	MaSP INT NOT NULL,
	MaGiay INT NOT NULL,
	MaMuc INT NOT NULL,
	Soluong INT CHECK(Soluong>0),
	CONSTRAINT PK_CTDatHang PRIMARY KEY(MaHoaDon,MaSP,MaGiay,MaMuc),
	Constraint FK_SANPHAM foreign key(MaSP) References SANPHAM(MaSP) ON DELETE no action on update no action,
	Constraint FK_GIAY Foreign Key(MaGiay) References GIAY(MaGiay)ON DELETE no action on update no action,
	Constraint FK_MUC Foreign Key(MaMuc) References MUC(MaMuc)ON DELETE no action on update no action,
	Constraint FK_HOADON Foreign Key(MaHoaDon) References HOADON(MaHoaDon)ON DELETE no action on update no action
)
GO

CREATE TABLE HOADON
(
	MaHoaDon INT IDENTITY(1,1),
	NgayLap DATETIME,
	MaKH INT,
	MaCTDH INT ,
	CONSTRAINT PK_HOADON PRIMARY KEY(MaHoaDon),
	Constraint FK_KHACHHANG Foreign Key(MaKH) References KHACHHANG(MaKH),
)
GO

CREATE TABLE AD
(
	UserName VARCHAR(30),
	PassWord VARCHAR(30),
	Ten NVARCHAR(50),
	PhanQuyen varchar (6),
	CONSTRAINT PK_ADMIN PRIMARY KEY(UserName)
)
GO

/*này là mấy câu truy vấn của t test thôi */


insert dbo.AD(UserName,PassWord,Ten,PhanQuyen)
values ('admin','123456','Nhóm 3','admin')
insert dbo.AD(UserName,PassWord,Ten,PhanQuyen)
values ('nhanvien01','123','Nguyễn Văn T','staff')

select * from AD where UserName='admin' and PassWord='123456'

insert GIAY (TenGiay,GiaGiay)
values ('Giay cacton tot',10000)
insert GIAY (TenGiay,GiaGiay)
values ('Giay cacton 2',20000)
insert GIAY (TenGiay,GiaGiay)
values ('Giay cacton 3',30000)
insert GIAY (TenGiay,GiaGiay)
values ('Giay cacton 4',40000)
insert GIAY (TenGiay,GiaGiay)
values ('Giay cacton 5',50000)
insert GIAY (TenGiay,GiaGiay)
values ('Giay cacton 6',60000)
insert GIAY (TenGiay,GiaGiay)
values ('Giay cacton 7',70000)
select * from MUC

insert MUC(TenMuc,GiaMuc)
values ('Đen',10000)
insert MUC(TenMuc,GiaMuc)
values ('Trắng',10000)
insert MUC(TenMuc,GiaMuc)
values ('Hồng e3',80000)
insert MUC(TenMuc,GiaMuc)
values ('Nâu 3e',14999)
insert MUC(TenMuc,GiaMuc)
values ('Đỏ 1',111111)
insert MUC
values ('Đỏ 22',111111)

insert LOAISP
values ('Thùng')
insert LOAISP
values ('Túi')
select * from LOAISP

insert SANPHAM
values ('Tui Giay',111111,1)
insert SANPHAM
values ('thung mau',200000,1)

SELECT MaSP,TenSP,Gia,TenLoaiSP
FROM SANPHAM S, LOAISP L
where L.MaLoai=S.MaLoai 


select MaCTDH, TenSP, TenGiay, TenMuc, SoLuong, DonGia
from CHITIETDONHANG c, SANPHAM s, GIAY g, MUC m
where c.MaSP=s.MaSP and c.MaGiay=g.MaGiay and c.MaMuc=m.MaMuc

select MaHoaDon, MaCTDH, TenKH, NgayLap from HOADON h, KHACHHANG k where h.MaKH = k.MaKH

select s.TenSP, g.TenGiay, m.TenMuc, c.Soluong as SLSP ,(GiaSP*Soluong)+GiaMuc+GiaGiay as Gia
from SANPHAM s, GIAY g, MUC m, CHITIETDONHANG c
where s.MaSP=c.MaSP and m.MaMuc=c.MaMuc and	g.MaGiay=c.MaGiay and c.MaHoaDon=1

select MaGiay, TenGiay from GIAY

insert HOADON values (null, null, null)

delete from HOADON where MaKH is null

select * from HOADON where MaKH is null 

select * from HOADON