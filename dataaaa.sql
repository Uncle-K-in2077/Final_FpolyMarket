-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 04, 2022 lúc 06:06 AM
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
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `IDNhanVien` varchar(10) NOT NULL,
  `TrangThai` smallint(1) NOT NULL DEFAULT 1,
  `BanHang` smallint(1) NOT NULL DEFAULT 1,
  `NhapHang` smallint(1) NOT NULL DEFAULT 1,
  `TaiKhoan` smallint(1) NOT NULL DEFAULT 1,
  `HangHoa` smallint(1) NOT NULL DEFAULT 1,
  `NhanVien` smallint(1) NOT NULL DEFAULT 1,
  `KhachHang` smallint(1) NOT NULL DEFAULT 1,
  `NhaCungCap` smallint(1) NOT NULL DEFAULT 1,
  `BaoCao` smallint(1) NOT NULL DEFAULT 1,
  `PhieuChi` smallint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Username`, `Password`, `IDNhanVien`, `TrangThai`, `BanHang`, `NhapHang`, `TaiKhoan`, `HangHoa`, `NhanVien`, `KhachHang`, `NhaCungCap`, `BaoCao`, `PhieuChi`) VALUES
('admin', '123', 'admin', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('Khai01', '01', 'NV09', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('Venus19032001', 'Venus19032001@', 'NV06', 1, 1, 1, 0, 1, 0, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `id` int(11) NOT NULL,
  `idhoadon` varchar(10) DEFAULT NULL,
  `idsanpham` varchar(10) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `giaBan` decimal(10,0) NOT NULL DEFAULT 0,
  `trangThai` smallint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donvitinh`
--

CREATE TABLE `donvitinh` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` smallint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donvitinh`
--

INSERT INTO `donvitinh` (`ID`, `Name`, `GhiChu`, `TrangThai`) VALUES
('DVT03', 'bịch', 'bịch', 1),
('DVT04', 'cái', 'cái', 1),
('MN01', 'lon', '', 0),
('MN02', 'gói', 'gói', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `ID` varchar(10) NOT NULL,
  `IDnhanvien` varchar(10) DEFAULT NULL,
  `IDkhachHang` varchar(10) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `HinhThucThanhToan` int(1) DEFAULT 1,
  `GiamGia` decimal(10,0) DEFAULT NULL,
  `TongTienThanhToan` decimal(10,0) DEFAULT NULL,
  `soTienNhanDuoc` decimal(10,0) NOT NULL,
  `loaiGia` smallint(1) DEFAULT 0,
  `GhiChu` varchar(250) DEFAULT NULL,
  `trangThai` smallint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `SoDienThoai` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(250) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `congno` decimal(10,0) DEFAULT 0,
  `TrangThai` smallint(1) DEFAULT 1,
  `ThoiGian` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`ID`, `Name`, `SoDienThoai`, `DiaChi`, `GhiChu`, `congno`, `TrangThai`, `ThoiGian`) VALUES
('KH01', 'KHÁCH MỚI', '0987656780', 'BMT,DAKLAK', 'KO', '75000000', 1, '2022-09-25 13:36:58'),
('KH02', 'LỘC', '098989898', 'BMT,DAKLAK', 'KO', '0', 1, '2022-09-25 13:36:58'),
('KH03', 'HOÀNH', '0935818820', 'BMT,DAKLAK', 'KO', '990000', 1, '2022-09-25 13:36:58'),
('KH04', 'LAM', NULL, 'BMT,DAKLAK', 'KO', '263556', 1, '2022-09-25 13:36:58'),
('KH05', 'KHUÊ', NULL, 'KRONG NO ,DAK NONG', NULL, '45000', 1, '2022-09-25 13:36:58');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` smallint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`ID`, `Name`, `GhiChu`, `TrangThai`) VALUES
('LSP01', 'Đồ Uống', 'KO', 1),
('LSP02', 'Đồ Ăn ', 'ko', 1),
('LSP03', 'Đồ Ăn Nhanh', 'KO', 1),
('LSP04', 'Đồ Gia Dụng', 'KO', 1),
('LSP05', 'bim sữa', '', 0),
('LSP06', 'Đồ ăn vặt', '', 1),
('LSP07', 'dụng cụ', 'hello', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `SoDienThoai` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(150) DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL,
  `congno` decimal(10,0) DEFAULT 0,
  `TrangThai` smallint(1) DEFAULT 1,
  `ThoiGian` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`ID`, `Name`, `SoDienThoai`, `DiaChi`, `GhiChu`, `congno`, `TrangThai`, `ThoiGian`) VALUES
('NCC01', 'Nước Ngọt Sông Lam', '0909090909', 'Sông Lam , Nghệ An', 'ko', '0', 1, '2022-09-25 13:36:58'),
('NCC02', 'COCACOLA VN', '0808080808', 'Q9,HCM', 'KO', '0', 1, '2022-09-25 13:36:58'),
('NCC03', 'Đồ ăn vặt bé Bự', '0707070707', 'BMT,DAK LAK', 'KO', '0', 1, '2022-09-25 13:36:58'),
('NCC04', 'Nội Thất Đồ Gia Dụng Hưng Quang', '0606060606', 'CUMGAR ,DAKLAK', 'KO', '0', 1, '2022-09-25 13:36:58'),
('NCC05', 'BỈM SỮA BABY BU', '0505050505', 'BMT,DAK LAK', 'KO', '0', 1, '2022-09-25 13:36:58'),
('NCC06', 'TRÁI CAY NGON BMT', '0972909000', 'BMT,DAKLAK', 'KO', '0', 1, '2022-09-25 13:36:58'),
('NCC09', 'CTY Thực Phẩm LACUSINA', '0909999999', '120 Khu công nghiệp Bình Dương Tỉnh Bình Dương', NULL, '6000000', 1, '2022-09-25 13:36:58');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` varchar(10) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `SoDienThoai` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(150) DEFAULT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `Luong` decimal(10,0) DEFAULT NULL,
  `GioiTinh` smallint(1) DEFAULT 1,
  `NgayVaoLam` datetime DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL,
  `TrangThai` smallint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `Name`, `SoDienThoai`, `DiaChi`, `NgaySinh`, `Luong`, `GioiTinh`, `NgayVaoLam`, `GhiChu`, `TrangThai`) VALUES
('admin', 'admin', '0935818820', 'BMT,DAK LAK', '2001-12-30 00:00:00', '100000000', 1, '2001-12-30 00:00:00', 'KO', 1),
('NV010', '', '', '', '2022-10-04 00:00:00', '0', 1, '2022-10-04 00:00:00', '', 1),
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
  `ID` varchar(10) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDnhanvien` varchar(10) DEFAULT NULL,
  `IDNhaCungCap` varchar(10) DEFAULT NULL,
  `TongTien` decimal(10,0) DEFAULT NULL,
  `ThanhToan` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL,
  `TrangThai` smallint(1) DEFAULT 1
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
  `ID` varchar(10) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDnhanvien` varchar(10) DEFAULT NULL,
  `IDncc` varchar(10) DEFAULT NULL,
  `TongTien` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL,
  `TrangThai` smallint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuchi`
--

CREATE TABLE `phieuchi` (
  `ID` varchar(10) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDnhanvien` varchar(10) DEFAULT NULL,
  `TienChi` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieuchi`
--

INSERT INTO `phieuchi` (`ID`, `ThoiGian`, `IDnhanvien`, `TienChi`, `GhiChu`) VALUES
('PC01', '2022-09-04 20:00:39', 'NV1', '886000', 'KO');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieutranoncc`
--

CREATE TABLE `phieutranoncc` (
  `ID` int(11) NOT NULL,
  `IDNcc` varchar(10) DEFAULT NULL,
  `IDNhanVien` varchar(10) DEFAULT NULL,
  `SoTienTra` decimal(10,0) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL,
  `TrangThai` smallint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieutranoncc`
--

INSERT INTO `phieutranoncc` (`ID`, `IDNcc`, `IDNhanVien`, `SoTienTra`, `ThoiGian`, `GhiChu`, `TrangThai`) VALUES
(1, 'NCC09', 'NV09', NULL, '2022-09-20 11:07:19', 'Khải 20-09-2022', 1),
(2, 'NCC09', 'NV09', NULL, '2022-09-20 11:09:40', '20-09-2022', 1),
(3, 'NCC09', 'NV09', '2000000', '2022-09-20 11:13:00', 'lần 2', 1),
(4, 'NCC09', 'NV09', '1000000', '2022-09-20 11:40:19', 'test laanf 4', 1),
(5, 'NCC09', 'admin', '8000000', '2022-09-20 11:47:44', 'hịu', 1),
(6, 'NCC09', 'admin', '5000000', '2022-09-20 11:49:53', '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Barcode` varchar(30) DEFAULT NULL,
  `hinhAnh` varchar(200) NOT NULL DEFAULT 'empty.png',
  `GiaNhap` decimal(10,0) DEFAULT 0,
  `GiaBan` decimal(10,0) DEFAULT 0,
  `giaSi` decimal(10,0) NOT NULL DEFAULT 999999,
  `SoLuong` int(11) DEFAULT 0,
  `SoLuongToiThieu` int(11) DEFAULT 0,
  `IDNhaCungCap` varchar(10) NOT NULL,
  `IDDonViTinh` varchar(10) NOT NULL,
  `idLoaiSanPham` varchar(10) NOT NULL,
  `GhiChu` varchar(150) DEFAULT NULL,
  `TrangThai` smallint(1) NOT NULL DEFAULT 1,
  `ThoiGian` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ID`, `Name`, `Barcode`, `hinhAnh`, `GiaNhap`, `GiaBan`, `giaSi`, `SoLuong`, `SoLuongToiThieu`, `IDNhaCungCap`, `IDDonViTinh`, `idLoaiSanPham`, `GhiChu`, `TrangThai`, `ThoiGian`) VALUES
('SP012', 'Nước giặt Ariel 1.6 lít', '4902430650212', '1568083204882549375.jpg', '50000', '90000', '999999', 72, 20, 'NCC02', 'MN01', 'LSP04', '', 1, '2022-09-25 13:36:58'),
('SP013', 'Bánh Oreo 68.5g', '6901668053121', 'Bánh-quy-kem-vani-Oreo-gói-68.5g.jpg', '23000', '50000', '999999', 91, 50, 'NCC03', 'MN01', 'LSP02', 'đồ ăn vặt', 1, '2022-09-25 13:36:58'),
('SP014', 'Lưỡi lam Platinum', '8888826024583', '70af2aec3c3268a9a8359dcd06a3b72a.png', '3000', '5000', '999999', 91, 20, 'NCC02', 'MN02', 'LSP02', '', 1, '2022-09-25 13:36:58'),
('SP015', 'Bột canh 180G', '8934561281696', '287652673_558881695830581_2757102238107310630_n.jpg', '32000', '46000', '999999', 87, 10, 'NCC02', 'MN01', 'LSP02', '', 1, '2022-09-25 13:36:58'),
('SP016', 'STTT vinamilk 110ml dâu', '8934673574327', 'empty.png', '8000', '12000', '100000', 100, 100, 'NCC02', 'MN01', 'LSP05', '', 0, '2022-09-25 13:36:58'),
('SP018', 'ád', 'ád', 'id shoppee.png', '222', '2222', '999999', 99, 20, 'NCC02', 'MN01', 'LSP02', '', 1, '2022-09-25 13:36:58'),
('SP019', 'Đường ăn', '', 'empty.png', '2000', '5000', '4000', 76, 10, 'NCC02', 'MN01', 'LSP01', '', 1, '2022-09-25 13:36:58'),
('SP01956', 'Đường ăn65456', '', 'empty.png', '2000', '5000', '4000', 58, 10, 'NCC02', 'MN01', 'LSP01', '', 1, '2022-09-25 13:36:58'),
('SP01A', 'COCACOLA', '8934588012228', 'cocacola.png', '8000', '10000', '999999', 0, 20, 'NCC02', 'MN01', 'LSP01', 'KO', 1, '2022-09-25 13:36:58'),
('SP01Ac', 'Revice chanh muối', '8934588843051', 'revicechanhmuoi.png', '8000', '10000', '999999', 82, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1, '2022-09-25 13:36:58'),
('SP01B', 'HENIKEN', '8934822201333', 'lon-heineken.png', '12000', '15000', '999999', 99, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1, '2022-09-25 13:36:58'),
('SP01Bc', 'Trà ô lông', '8934588873058', 'traolong.png', '12000', '15000', '999999', 99, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1, '2022-09-25 13:36:58'),
('SP020', 'test item', '71289571289478', 'zalo_last_screenshot.png', '6000', '12000', '9000', 95, 20, 'NCC02', 'DVT04', 'LSP02', 'test item', 1, '2022-09-25 13:36:58'),
('SP021', 'helloworldv hello', '12412312312', '293128237_604584784402934_8419741851485846479_n.jpg', '10000', '15000', '12000', 100, 20, 'NCC01', 'DVT04', 'LSP02', 'hello', 1, '2022-10-04 11:02:17'),
('SP02A', 'String', '8934588232220', 'chaisting.png', '4000', '7000', '999999', 93, 70, 'NCC06', 'MN01', 'LSP02', 'KO', 1, '2022-09-25 13:36:58'),
('SP02Av', 'Nước lọc aquafina', '8934588063053', 'nuocloc.png', '4000', '7000', '999999', 99, 70, 'NCC06', 'MN01', 'LSP02', 'KO', 1, '2022-09-25 13:36:58'),
('SP03A', '7up 1,5L', '8934588023064', '7up1-5L.png', '3000', '5000', '999999', 77, 50, 'NCC03', 'MN01', 'LSP03', 'KO', 1, '2022-09-25 13:36:58'),
('SP03Ai', 'Thuốc lá Demi(mèo bạc)', '8934674015416', 'thuocdemi.png', '3000', '15000', '999999', 90, 20, 'NCC03', 'MN01', 'LSP03', '', 1, '2022-09-25 13:36:58'),
('SP03Aiaa', 'Bia tiger lon', '8934822101336', '9471798d16594cb09d617aee28d8297d.jpg', '3000', '15000', '999999', 97, 50, 'NCC03', 'MN01', 'LSP03', '', 1, '2022-09-25 13:36:58'),
('SP03Aiaav', 'Pepsi lon', '8934588013065', 'banner.jpg', '50000', '60000', '999999', 75, 50, 'NCC03', 'MN01', 'LSP03', '', 1, '2022-09-25 13:36:58'),
('SP03Aiaavf', 'Mirinda lon', '8934588132223', 'mirinda.png', '95000', '150000', '999999', 75, 50, 'NCC03', 'MN01', 'LSP03', '', 1, '2022-09-25 13:36:58');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thutienkhachhang`
--

CREATE TABLE `thutienkhachhang` (
  `ID` int(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDNhanVien` varchar(10) DEFAULT NULL,
  `IDKhachHang` varchar(10) DEFAULT NULL,
  `SoTien` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `thutienkhachhang`
--

INSERT INTO `thutienkhachhang` (`ID`, `ThoiGian`, `IDNhanVien`, `IDKhachHang`, `SoTien`, `GhiChu`) VALUES
(1, '2022-09-19 12:40:03', 'admin', 'KH01', NULL, ''),
(2, '2022-09-19 12:41:09', 'admin', 'KH01', NULL, ''),
(3, '2022-09-19 12:54:47', 'admin', 'KH01', '30000000', ''),
(4, '2022-09-19 01:20:23', 'NV09', 'KH01', '10000000', 'Khải đã thu 10 triệu'),
(5, '2022-09-19 01:21:29', 'NV09', 'KH01', '10000000', 'Khải đã thu tiền'),
(6, '2022-09-20 09:39:19', 'NV09', 'KH01', '5000000', 'Khải thu ngày 20-09'),
(7, '2022-09-25 03:03:17', 'admin', 'KH02', '365000', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trichkho`
--

CREATE TABLE `trichkho` (
  `ID` varchar(10) NOT NULL,
  `IDNhanVien` varchar(10) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `GhiChu` varchar(150) DEFAULT NULL
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
-- Chỉ mục cho bảng `phieutranoncc`
--
ALTER TABLE `phieutranoncc`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDNhanVien` (`IDNhanVien`),
  ADD KEY `IDNcc` (`IDNcc`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=259;

--
-- AUTO_INCREMENT cho bảng `phieutranoncc`
--
ALTER TABLE `phieutranoncc`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `thutienkhachhang`
--
ALTER TABLE `thutienkhachhang`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`IDnhanvien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`IDkhachHang`) REFERENCES `khachhang` (`ID`);

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
-- Các ràng buộc cho bảng `phieutranoncc`
--
ALTER TABLE `phieutranoncc`
  ADD CONSTRAINT `phieutranoncc_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `phieutranoncc_ibfk_2` FOREIGN KEY (`IDNcc`) REFERENCES `nhacungcap` (`ID`);

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
-- Các ràng buộc cho bảng `trichkho`
--
ALTER TABLE `trichkho`
  ADD CONSTRAINT `trichkho_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
