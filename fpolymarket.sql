-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 16, 2022 lúc 02:16 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `fpolymarket`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `IDNhanVien` varchar(20) NOT NULL,
  `TrangThai` int(1) NOT NULL DEFAULT 1,
  `BanHang` int(1) NOT NULL DEFAULT 1,
  `NhapHang` int(1) NOT NULL DEFAULT 1,
  `TaiKhoan` int(1) NOT NULL DEFAULT 1,
  `HangHoa` int(1) NOT NULL DEFAULT 1,
  `NhanVien` int(1) NOT NULL DEFAULT 1,
  `KhachHang` int(1) NOT NULL DEFAULT 1,
  `NhaCungCap` int(1) NOT NULL DEFAULT 1,
  `BaoCao` int(1) NOT NULL DEFAULT 1,
  `PhieuChi` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Username`, `Password`, `IDNhanVien`, `TrangThai`, `BanHang`, `NhapHang`, `TaiKhoan`, `HangHoa`, `NhanVien`, `KhachHang`, `NhaCungCap`, `BaoCao`, `PhieuChi`) VALUES
('admin', '123', 'admin', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('NV1', '123456', 'NV1', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('NV2', '123456', 'NV2', 1, 1, 1, 0, 1, 0, 1, 1, 1, 1),
('NV3', '123456', 'NV3', 1, 0, 1, 0, 1, 1, 0, 1, 1, 1),
('NV4', '123456', 'NV4', 1, 1, 1, 0, 1, 0, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `id` int(11) NOT NULL,
  `idhoadon` varchar(20) DEFAULT NULL,
  `idsanpham` varchar(20) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietkhachtrahang`
--

CREATE TABLE `chitietkhachtrahang` (
  `ID` varchar(20) NOT NULL,
  `IDHoaDon` varchar(20) DEFAULT NULL,
  `IDSanPham` varchar(20) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietnhaphang`
--

CREATE TABLE `chitietnhaphang` (
  `ID` varchar(20) NOT NULL,
  `IDNhatKyNH` varchar(20) DEFAULT NULL,
  `IDSanPham` varchar(20) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiettrahangnhacungcap`
--

CREATE TABLE `chitiettrahangnhacungcap` (
  `ID` varchar(20) NOT NULL,
  `IDNhatKyTHNCC` varchar(20) DEFAULT NULL,
  `IDSanPham` varchar(20) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `Gia` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiettrichkho`
--

CREATE TABLE `chitiettrichkho` (
  `ID` varchar(20) NOT NULL,
  `IDTricKho` varchar(20) DEFAULT NULL,
  `IDSanPham` varchar(20) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donvitinh`
--

CREATE TABLE `donvitinh` (
  `ID` varchar(20) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donvitinh`
--

INSERT INTO `donvitinh` (`ID`, `Name`, `GhiChu`, `TrangThai`) VALUES
('MN01', 'VNĐ', 'Việt Nam Đồng', 1),
('MN02', '$', 'Đô la', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `ID` varchar(20) NOT NULL,
  `IDnhanvien` varchar(20) DEFAULT NULL,
  `IDkhachHang` varchar(20) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `HinhThucThanhToan` int(1) DEFAULT 1,
  `GiamGia` decimal(10,0) DEFAULT NULL,
  `TongTienThanhToan` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `trangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`ID`, `IDnhanvien`, `IDkhachHang`, `ThoiGian`, `HinhThucThanhToan`, `GiamGia`, `TongTienThanhToan`, `GhiChu`, `trangThai`) VALUES
('HD01', 'NV1', 'KH01', '2022-09-04 19:10:22', 1, '0', '10000', 'KO', 1),
('HD02', 'NV1', 'KH02', '2022-09-05 19:18:31', 1, '0', '35000', 'KO', 1),
('HD03', 'NV1', 'KH03', '2022-09-05 19:19:51', 1, '0', '100000', 'heniken1,taomy5,bimbim10', 1),
('HD04', 'NV1', 'KH04', '2022-09-05 19:25:18', 1, '0', '30000', 'heniken2', 1),
('HD05', 'NV1', 'KH05', '2022-09-05 19:26:33', 1, '0', '20000', 'coca2', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `ID` varchar(20) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `SoDienThoai` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(250) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `congno` decimal(10,0) DEFAULT 0,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`ID`, `Name`, `SoDienThoai`, `DiaChi`, `GhiChu`, `congno`, `TrangThai`) VALUES
('KH01', 'HOÀNG', '0987656780', 'BMT,DAKLAK', 'KO', '0', 1),
('KH02', 'LỘC', '098989898', 'BMT,DAKLAK', 'KO', '0', 1),
('KH03', 'HOÀNH', '0935818820', 'BMT,DAKLAK', 'KO', '0', 1),
('KH04', 'LAM', NULL, 'BMT,DAKLAK', 'KO', '0', 1),
('KH05', 'KHUÊ', NULL, 'KRONG NO ,DAK NONG', NULL, '0', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachtrahang`
--

CREATE TABLE `khachtrahang` (
  `ID` varchar(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDKhachHang` varchar(20) DEFAULT NULL,
  `IDNhanVien` varchar(20) DEFAULT NULL,
  `HoanTien` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `trangthai` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `ID` varchar(20) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`ID`, `Name`, `GhiChu`, `TrangThai`) VALUES
('LSP01', 'Đồ Uống', 'KO', 1),
('LSP02', 'Đồ Ăn ', 'ko', 1),
('LSP03', 'Đồ Ăn Nhanh', 'KO', 1),
('LSP04', 'Đồ Gia Dụng', 'KO', 1),
('LSP05', 'Bỉm Sữa', 'Ko', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `ID` varchar(20) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `SoDienThoai` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(250) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `congno` decimal(10,0) DEFAULT 0,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`ID`, `Name`, `SoDienThoai`, `DiaChi`, `GhiChu`, `congno`, `TrangThai`) VALUES
('NCC01', 'Nước Ngọt Sông Lam', '0909090909', 'Sông Lam , Nghệ An', 'ko', '0', 1),
('NCC02', 'COCACOLA VN', '0808080808', 'Q9,HCM', 'KO', '0', 1),
('NCC03', 'Đồ ăn vặt bé Bự', '0707070707', 'BMT,DAK LAK', 'KO', '0', 1),
('NCC04', 'Nội Thất Đồ Gia Dụng Hưng Quang', '0606060606', 'CUMGAR ,DAKLAK', 'KO', '0', 1),
('NCC05', 'BỈM SỮA BABY BU', '0505050505', 'BMT,DAK LAK', 'KO', '0', 1),
('NCC06', 'TRÁI CAY NGON BMT', '0972909000', 'BMT,DAKLAK', 'KO', '0', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` varchar(20) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `SoDienThoai` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(250) DEFAULT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `Luong` decimal(10,0) DEFAULT NULL,
  `GioiTinh` int(1) DEFAULT 1,
  `NgayVaoLam` datetime DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `Name`, `SoDienThoai`, `DiaChi`, `NgaySinh`, `Luong`, `GioiTinh`, `NgayVaoLam`, `GhiChu`, `TrangThai`) VALUES
('admin', 'admin', '0935818820', 'BMT,DAK LAK', '2001-12-30 00:00:00', '100000000', 1, '2001-12-30 00:00:00', 'KO', 1),
('NV06', 'Châu Văn Hiệu', '0352461759', '209/12 Nguyễn Văn Cừ', '2000-12-31 00:00:00', '7500000', 1, '2021-12-26 00:00:00', 'hiệu', 1),
('NV07', 'chau van hieuiz', '56456465', 'ưqeqwe', '2022-09-15 00:00:00', '7000000', 1, '2022-09-15 00:00:00', '', 1),
('NV08', 'cvh', '123456789', '213 aSDAS D', '2001-03-19 00:00:00', '10000000', 1, '2022-09-15 00:00:00', '', 0),
('NV09', 'lê hoàng khải', '123456789', '123asdasd', '2022-09-15 00:00:00', '5000000', 1, '2022-09-15 00:00:00', '', 1),
('NV1', 'Nguyễn Văn A', '0987654321', 'BMT ,DAK LAK', '2003-09-02 13:50:31', '5000000', 1, '2022-09-02 13:50:31', 'KO', 1),
('NV2', 'Nguyễn Thị Thanh Dung', '098765431', 'CUMGAR,DAK LAK', '2002-09-11 00:00:00', '5000000', 0, '2002-09-11 00:00:00', 'KO', 1),
('NV3', 'Nguyễn Văn Thế Bảo', '0912345678', 'KRONG NO ,DAK NONG', '2002-09-01 00:00:00', '5000000', 1, '2002-09-01 00:00:00', 'KO', 1),
('NV4', 'Hoàng Văn Lộc', '097999898', 'buôn Trấp,DAKLAK', '2004-09-04 00:00:00', '5000000', 1, '2004-09-04 00:00:00', 'ko', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhatkynhaphang`
--

CREATE TABLE `nhatkynhaphang` (
  `ID` varchar(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDnhanvien` varchar(20) DEFAULT NULL,
  `IDNhaCungCap` varchar(20) DEFAULT NULL,
  `TongTien` decimal(10,0) DEFAULT NULL,
  `ThanhToan` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhatkynhaphang`
--

INSERT INTO `nhatkynhaphang` (`ID`, `ThoiGian`, `IDnhanvien`, `IDNhaCungCap`, `TongTien`, `ThanhToan`, `GhiChu`, `TrangThai`) VALUES
('NKNH01', '2022-09-04 19:39:32', 'NV1', 'NCC02', '192000', '192000', 'KO', 1),
('NKNH02', '2022-09-04 19:42:23', 'NV1', 'NCC02', '284000', '284000', 'KO', 1),
('NKNH03', '2022-09-04 19:44:34', 'NV1', 'NCC06', '200000', '200000', 'KO', 1),
('NKNH04', '2022-09-04 19:46:25', 'NV1', 'NCC03', '60000', '60000', 'KO', 1),
('NKNH05', '2022-09-04 19:47:26', 'NV1', 'NCC04', '350000', '350000', 'KO', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhatkytrahangncc`
--

CREATE TABLE `nhatkytrahangncc` (
  `ID` varchar(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDnhanvien` varchar(20) DEFAULT NULL,
  `IDncc` varchar(20) DEFAULT NULL,
  `TongTien` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuchi`
--

CREATE TABLE `phieuchi` (
  `ID` varchar(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDnhanvien` varchar(20) DEFAULT NULL,
  `TienChi` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieuchi`
--

INSERT INTO `phieuchi` (`ID`, `ThoiGian`, `IDnhanvien`, `TienChi`, `GhiChu`) VALUES
('PC01', '2022-09-04 20:00:39', 'NV1', '886000', 'KO');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `ID` varchar(20) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Barcode` varchar(30) DEFAULT NULL,
  `hinhAnh` varchar(200) DEFAULT 'empty.png',
  `GiaNhap` decimal(10,0) DEFAULT 0,
  `GiaBan` decimal(10,0) DEFAULT 0,
  `SoLuong` int(11) DEFAULT 0,
  `SoLuongToiThieu` int(11) DEFAULT 0,
  `IDNhaCungCap` varchar(20) DEFAULT NULL,
  `IDDonViTinh` varchar(20) DEFAULT NULL,
  `idLoaiSanPham` varchar(20) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ID`, `Name`, `Barcode`, `hinhAnh`, `GiaNhap`, `GiaBan`, `SoLuong`, `SoLuongToiThieu`, `IDNhaCungCap`, `IDDonViTinh`, `idLoaiSanPham`, `GhiChu`, `TrangThai`) VALUES
('SP01A', 'COCACOLA', '8935049510123', 'cocacola.png', '8000', '10000', 24, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP01Ac', 'Revice chanh muối', '8934588183133', 'revicechanhmuoi.png', '8000', '10000', 24, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP01B', 'HENIKEN', '8934822201333', 'lon-heineken.png', '12000', '15000', 24, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP01Bc', 'Trà ô lông', '8934588873058', 'traolong.png', '12000', '15000', 24, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP02A', 'String', '8934588232220', 'chaisting.png', '4000', '7000', 50, 70, 'NCC06', 'MN01', 'LSP02', 'KO', 1),
('SP02Av', 'Nước lọc aquafina', '8934588063060', 'nuocloc.png', '4000', '7000', 50, 70, 'NCC06', 'MN01', 'LSP02', 'KO', 1),
('SP03A', '7up 1,5L', '8934588023064', '7up1-5L.png', '3000', '5000', 20, 50, 'NCC03', 'MN01', 'LSP03', 'KO', 1),
('SP03Ai', 'Thuốc lá Demi(mèo bạc)', '8934674015416', 'thuocdemi.png', '3000', '15000', 20, 50, 'NCC03', 'MN01', 'LSP03', '', 1),
('SP03Aiaa', 'Cục sạc', 'KP1350H00211900044PH02', 'thuocdemi.png', '3000', '15000', 20, 50, 'NCC03', 'MN01', 'LSP03', '', 1),
('SP03Aiaav', 'Enter Bacicus', '8938530836214', 'empty.png', '50000', '60000', 120, 50, 'NCC03', 'MN01', 'LSP03', '', 1),
('SP03Aiaavff', 'KidOne 2++', '8936139990030', 'empty.png', '95000', '150000', 120, 50, 'NCC03', 'MN01', 'LSP03', '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thutienkhachhang`
--

CREATE TABLE `thutienkhachhang` (
  `ID` varchar(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDNhanVien` varchar(20) DEFAULT NULL,
  `IDKhachHang` varchar(20) DEFAULT NULL,
  `SoTien` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thutienncc`
--

CREATE TABLE `thutienncc` (
  `ID` varchar(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDNhanVien` varchar(20) DEFAULT NULL,
  `IDncc` varchar(20) DEFAULT NULL,
  `SoTien` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trichkho`
--

CREATE TABLE `trichkho` (
  `ID` varchar(20) NOT NULL,
  `IDNhanVien` varchar(20) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `trichkho`
--

INSERT INTO `trichkho` (`ID`, `IDNhanVien`, `ThoiGian`, `GhiChu`) VALUES
('KHO01', 'NV1', '2022-09-05 19:08:30', 'KO'),
('KHO02', 'NV2', '2022-09-05 19:09:17', 'KO');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Username`),
  ADD KEY `IDNhanVien` (`IDNhanVien`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idhoadon` (`idhoadon`),
  ADD KEY `idsanpham` (`idsanpham`);

--
-- Chỉ mục cho bảng `chitietkhachtrahang`
--
ALTER TABLE `chitietkhachtrahang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDHoaDon` (`IDHoaDon`),
  ADD KEY `IDSanPham` (`IDSanPham`);

--
-- Chỉ mục cho bảng `chitietnhaphang`
--
ALTER TABLE `chitietnhaphang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDNhatKyNH` (`IDNhatKyNH`),
  ADD KEY `IDSanPham` (`IDSanPham`);

--
-- Chỉ mục cho bảng `chitiettrahangnhacungcap`
--
ALTER TABLE `chitiettrahangnhacungcap`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDNhatKyTHNCC` (`IDNhatKyTHNCC`),
  ADD KEY `IDSanPham` (`IDSanPham`);

--
-- Chỉ mục cho bảng `chitiettrichkho`
--
ALTER TABLE `chitiettrichkho`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDSanPham` (`IDSanPham`),
  ADD KEY `IDTricKho` (`IDTricKho`);

--
-- Chỉ mục cho bảng `donvitinh`
--
ALTER TABLE `donvitinh`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDnhanvien` (`IDnhanvien`),
  ADD KEY `IDkhachHang` (`IDkhachHang`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `khachtrahang`
--
ALTER TABLE `khachtrahang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDKhachHang` (`IDKhachHang`),
  ADD KEY `IDNhanVien` (`IDNhanVien`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nhatkynhaphang`
--
ALTER TABLE `nhatkynhaphang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDnhanvien` (`IDnhanvien`),
  ADD KEY `IDncc` (`IDNhaCungCap`);

--
-- Chỉ mục cho bảng `nhatkytrahangncc`
--
ALTER TABLE `nhatkytrahangncc`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDnhanvien` (`IDnhanvien`),
  ADD KEY `IDncc` (`IDncc`);

--
-- Chỉ mục cho bảng `phieuchi`
--
ALTER TABLE `phieuchi`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDnhanvien` (`IDnhanvien`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDDonViTinh` (`IDDonViTinh`),
  ADD KEY `idLoaiSanPham` (`idLoaiSanPham`),
  ADD KEY `IDNhaCungCap` (`IDNhaCungCap`);

--
-- Chỉ mục cho bảng `thutienkhachhang`
--
ALTER TABLE `thutienkhachhang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDNhanVien` (`IDNhanVien`),
  ADD KEY `IDKhachHang` (`IDKhachHang`);

--
-- Chỉ mục cho bảng `thutienncc`
--
ALTER TABLE `thutienncc`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDNhanVien` (`IDNhanVien`),
  ADD KEY `IDncc` (`IDncc`);

--
-- Chỉ mục cho bảng `trichkho`
--
ALTER TABLE `trichkho`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDNhanVien` (`IDNhanVien`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`);

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`idhoadon`) REFERENCES `hoadon` (`ID`),
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`idsanpham`) REFERENCES `sanpham` (`ID`);

--
-- Các ràng buộc cho bảng `chitietkhachtrahang`
--
ALTER TABLE `chitietkhachtrahang`
  ADD CONSTRAINT `chitietkhachtrahang_ibfk_1` FOREIGN KEY (`IDHoaDon`) REFERENCES `khachtrahang` (`ID`),
  ADD CONSTRAINT `chitietkhachtrahang_ibfk_2` FOREIGN KEY (`IDSanPham`) REFERENCES `sanpham` (`ID`);

--
-- Các ràng buộc cho bảng `chitietnhaphang`
--
ALTER TABLE `chitietnhaphang`
  ADD CONSTRAINT `chitietnhaphang_ibfk_1` FOREIGN KEY (`IDNhatKyNH`) REFERENCES `nhatkynhaphang` (`ID`),
  ADD CONSTRAINT `chitietnhaphang_ibfk_2` FOREIGN KEY (`IDNhatKyNH`) REFERENCES `nhatkynhaphang` (`ID`),
  ADD CONSTRAINT `chitietnhaphang_ibfk_3` FOREIGN KEY (`IDSanPham`) REFERENCES `sanpham` (`ID`);

--
-- Các ràng buộc cho bảng `chitiettrahangnhacungcap`
--
ALTER TABLE `chitiettrahangnhacungcap`
  ADD CONSTRAINT `chitiettrahangnhacungcap_ibfk_1` FOREIGN KEY (`IDNhatKyTHNCC`) REFERENCES `nhatkytrahangncc` (`ID`),
  ADD CONSTRAINT `chitiettrahangnhacungcap_ibfk_2` FOREIGN KEY (`IDSanPham`) REFERENCES `sanpham` (`ID`);

--
-- Các ràng buộc cho bảng `chitiettrichkho`
--
ALTER TABLE `chitiettrichkho`
  ADD CONSTRAINT `chitiettrichkho_ibfk_1` FOREIGN KEY (`IDSanPham`) REFERENCES `sanpham` (`ID`),
  ADD CONSTRAINT `chitiettrichkho_ibfk_2` FOREIGN KEY (`IDTricKho`) REFERENCES `trichkho` (`ID`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`IDnhanvien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`IDkhachHang`) REFERENCES `khachhang` (`ID`);

--
-- Các ràng buộc cho bảng `khachtrahang`
--
ALTER TABLE `khachtrahang`
  ADD CONSTRAINT `khachtrahang_ibfk_1` FOREIGN KEY (`IDKhachHang`) REFERENCES `khachhang` (`ID`),
  ADD CONSTRAINT `khachtrahang_ibfk_2` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`);

--
-- Các ràng buộc cho bảng `nhatkynhaphang`
--
ALTER TABLE `nhatkynhaphang`
  ADD CONSTRAINT `nhatkynhaphang_ibfk_1` FOREIGN KEY (`IDnhanvien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `nhatkynhaphang_ibfk_2` FOREIGN KEY (`IDNhaCungCap`) REFERENCES `nhacungcap` (`ID`);

--
-- Các ràng buộc cho bảng `nhatkytrahangncc`
--
ALTER TABLE `nhatkytrahangncc`
  ADD CONSTRAINT `nhatkytrahangncc_ibfk_1` FOREIGN KEY (`IDnhanvien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `nhatkytrahangncc_ibfk_2` FOREIGN KEY (`IDncc`) REFERENCES `nhacungcap` (`ID`);

--
-- Các ràng buộc cho bảng `phieuchi`
--
ALTER TABLE `phieuchi`
  ADD CONSTRAINT `phieuchi_ibfk_1` FOREIGN KEY (`IDnhanvien`) REFERENCES `nhanvien` (`id`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`IDDonViTinh`) REFERENCES `donvitinh` (`ID`),
  ADD CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`idLoaiSanPham`) REFERENCES `loaisanpham` (`ID`),
  ADD CONSTRAINT `sanpham_ibfk_3` FOREIGN KEY (`IDNhaCungCap`) REFERENCES `nhacungcap` (`ID`);

--
-- Các ràng buộc cho bảng `thutienkhachhang`
--
ALTER TABLE `thutienkhachhang`
  ADD CONSTRAINT `thutienkhachhang_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `thutienkhachhang_ibfk_2` FOREIGN KEY (`IDKhachHang`) REFERENCES `khachhang` (`ID`);

--
-- Các ràng buộc cho bảng `thutienncc`
--
ALTER TABLE `thutienncc`
  ADD CONSTRAINT `thutienncc_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `thutienncc_ibfk_2` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `thutienncc_ibfk_3` FOREIGN KEY (`IDncc`) REFERENCES `nhacungcap` (`ID`);

--
-- Các ràng buộc cho bảng `trichkho`
--
ALTER TABLE `trichkho`
  ADD CONSTRAINT `trichkho_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
