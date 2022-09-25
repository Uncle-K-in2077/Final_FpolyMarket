-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 25, 2022 lúc 08:45 AM
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
('Khai01', '01', 'NV09', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
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
  `soluong` int(11) DEFAULT NULL,
  `giaBan` decimal(10,0) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`id`, `idhoadon`, `idsanpham`, `soluong`, `giaBan`) VALUES
(160, 'HD2509830358', 'SP03Aiaavff', 1, '150000'),
(161, 'HD2509830358', 'SP012', 1, '90000'),
(162, 'HD2509830358', 'SP03Aiaav', 1, '60000'),
(163, 'HD2509830358', 'SP014', 1, '5000'),
(164, 'HD2509932453', 'SP03Aiaavff', 2, '150000'),
(165, 'HD2509932453', 'SP012', 1, '90000'),
(166, 'HD2509932453', 'SP01Bc', 1, '15000'),
(167, 'HD2509932453', 'SP013', 1, '50000'),
(168, 'HD2509995499', 'SP012', 2, '90000'),
(169, 'HD2509995499', 'SP03Aiaavff', 1, '150000'),
(170, 'HD2509995499', 'SP03Aiaav', 1, '60000'),
(171, 'HD2509201381', 'SP01956', 4, '5000'),
(172, 'HD2509201381', 'SP01A', 3, '10000'),
(173, 'HD2509201381', 'SP019', 1, '5000'),
(174, 'HD2509201381', 'SP01Ac', 1, '10000'),
(175, 'HD2509353818', 'SP01956', 2, '5000'),
(176, 'HD2509353818', 'SP01A', 3, '10000'),
(177, 'HD2509353818', 'SP01Ac', 1, '10000'),
(178, 'HD2509672094', 'SP01A', 3, '10000'),
(179, 'HD2509672094', 'SP01Ac', 1, '10000'),
(180, 'HD2509672094', 'SP01956', 1, '5000'),
(181, 'HD2509041561', 'SP019', 1, '5000'),
(182, 'HD2509041561', 'SP01956', 1, '5000'),
(184, 'HD2509610923', 'SP01956', 2, '4000'),
(185, 'HD2509610923', 'SP01Ac', 2, '999999123'),
(186, 'HD2509499728', 'SP019', 1, '5000'),
(187, 'HD2509130367', 'SP01956', 1, '5000'),
(188, 'HD2509130367', 'SP01Ac', 1, '10000'),
(189, 'HD2509546883', 'SP01Ac', 1, '10000'),
(190, 'HD2509546883', 'SP01956', 1, '5000'),
(191, 'HD2509546883', 'SP03Aiaavff', 1, '150000'),
(192, 'HD2509546883', 'SP03Aiaav', 1, '60000'),
(193, 'HD2509546883', 'SP03Aiaa', 1, '15000'),
(194, 'HD2509441250', 'SP012', 2, '90000'),
(195, 'HD2509441250', 'SP03Aiaavff', 1, '150000'),
(196, 'HD2509441250', 'SP03Aiaav', 1, '60000'),
(197, 'HD2509441250', 'SP014', 1, '5000'),
(198, 'HD2509840146', 'SP03Aiaavff', 2, '150000'),
(199, 'HD2509840146', 'SP012', 2, '90000'),
(200, 'HD2509840146', 'SP014', 1, '5000'),
(201, 'HD2509546909', 'SP03Ai', 5, '15000'),
(202, 'HD2509025166', 'SP03A', 1, '5000');

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
-- Cấu trúc bảng cho bảng `ctphieukhachtrahang`
--

CREATE TABLE `ctphieukhachtrahang` (
  `ID` int(11) NOT NULL,
  `IDPhieuKTH` varchar(20) DEFAULT NULL,
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
  `soTienNhanDuoc` decimal(10,0) NOT NULL,
  `loaiGia` int(11) DEFAULT 0,
  `GhiChu` varchar(250) DEFAULT NULL,
  `trangThai` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`ID`, `IDnhanvien`, `IDkhachHang`, `ThoiGian`, `HinhThucThanhToan`, `GiamGia`, `TongTienThanhToan`, `soTienNhanDuoc`, `loaiGia`, `GhiChu`, `trangThai`) VALUES
('HD2509025166', 'admin', 'KH01', '2022-09-25 13:36:58', 1, '0', '5000', '5000', 0, '', 1),
('HD2509041561', 'admin', 'KH01', '2022-09-25 11:36:36', 1, '5000', '5000', '5000', 0, '', 1),
('HD2509130367', 'admin', 'KH01', '2022-09-25 12:29:52', 1, '0', '15000', '15000', 0, '', 1),
('HD2509201381', 'admin', 'KH01', '2022-09-25 00:42:30', 1, '0', '65000', '65000', 0, '', 1),
('HD2509353818', 'admin', 'KH05', '2022-09-25 00:42:50', 3, '0', '50000', '25000', 0, '', 1),
('HD2509441250', 'admin', 'KH01', '2022-09-25 13:35:55', 1, '0', '395000', '395000', 0, '', 1),
('HD2509499728', 'admin', 'KH01', '2022-09-25 12:29:44', 1, '0', '5000', '5000', 0, '', 1),
('HD2509546883', 'admin', 'KH01', '2022-09-25 13:35:49', 1, '0', '240000', '240000', 0, '', 1),
('HD2509546909', 'admin', 'KH01', '2022-09-25 13:36:31', 1, '0', '75000', '75000', 0, '', 1),
('HD2509610923', 'admin', 'KH01', '2022-09-25 11:37:23', 1, '0', '2000006246', '2000006246', 1, '', 1),
('HD2509672094', 'admin', 'KH01', '2022-09-25 00:43:00', 1, '5000', '40000', '40000', 0, '', 1),
('HD2509830358', 'admin', 'KH01', '2022-09-25 00:42:08', 1, '0', '305000', '305000', 0, '', 1),
('HD2509840146', 'admin', 'KH01', '2022-09-25 13:36:14', 1, '0', '485000', '485000', 0, '', 1),
('HD2509932453', 'admin', 'KH01', '2022-09-25 00:42:16', 1, '0', '455000', '455000', 0, '', 1),
('HD2509995499', 'admin', 'KH01', '2022-09-25 00:42:26', 1, '0', '390000', '390000', 0, '', 1);

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
('KH01', 'KHÁCH MỚI', '0987656780', 'BMT,DAKLAK', 'KO', '75000000', 1),
('KH02', 'LỘC', '098989898', 'BMT,DAKLAK', 'KO', '365000', 1),
('KH03', 'HOÀNH', '0935818820', 'BMT,DAKLAK', 'KO', '990000', 1),
('KH04', 'LAM', NULL, 'BMT,DAKLAK', 'KO', '263556', 1),
('KH05', 'KHUÊ', NULL, 'KRONG NO ,DAK NONG', NULL, '45000', 1);

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
('NCC06', 'TRÁI CAY NGON BMT', '0972909000', 'BMT,DAKLAK', 'KO', '0', 1),
('NCC09', 'CTY Thực Phẩm LACUSINA', '0909999999', '120 Khu công nghiệp Bình Dương Tỉnh Bình Dương', NULL, '6000000', 1);

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
-- Cấu trúc bảng cho bảng `phieukhachtrahang`
--

CREATE TABLE `phieukhachtrahang` (
  `ID` varchar(20) NOT NULL,
  `IDKhachHang` varchar(20) DEFAULT NULL,
  `IDNhanVien` varchar(20) DEFAULT NULL,
  `SoTienHoaTra` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `TrangThai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieutranoncc`
--

CREATE TABLE `phieutranoncc` (
  `ID` int(11) NOT NULL,
  `IDNcc` varchar(20) DEFAULT NULL,
  `IDNhanVien` varchar(20) DEFAULT NULL,
  `SoTienTra` decimal(10,0) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(11) DEFAULT 1
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
  `ID` varchar(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Barcode` varchar(30) DEFAULT NULL,
  `hinhAnh` varchar(200) NOT NULL DEFAULT 'empty.png',
  `GiaNhap` decimal(10,0) DEFAULT 0,
  `GiaBan` decimal(10,0) DEFAULT 0,
  `giaSi` decimal(10,0) NOT NULL DEFAULT 999999,
  `SoLuong` int(11) DEFAULT 0,
  `SoLuongToiThieu` int(11) DEFAULT 0,
  `IDNhaCungCap` varchar(20) NOT NULL,
  `IDDonViTinh` varchar(20) NOT NULL,
  `idLoaiSanPham` varchar(20) NOT NULL,
  `GhiChu` varchar(250) DEFAULT NULL,
  `TrangThai` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ID`, `Name`, `Barcode`, `hinhAnh`, `GiaNhap`, `GiaBan`, `giaSi`, `SoLuong`, `SoLuongToiThieu`, `IDNhaCungCap`, `IDDonViTinh`, `idLoaiSanPham`, `GhiChu`, `TrangThai`) VALUES
('SP012', 'Nước giặt Ariel 1.6 lít', '4902430650212', '1568083204882549375.jpg', '50000', '90000', '999999', 86, 20, 'NCC02', 'MN01', 'LSP04', '', 1),
('SP013', 'Bánh Oreo 68.5g', '6901668053121', 'Bánh-quy-kem-vani-Oreo-gói-68.5g.jpg', '23000', '50000', '999999', 99, 50, 'NCC03', 'MN01', 'LSP02', 'đồ ăn vặt', 1),
('SP014', 'Lưỡi lam Platinum', '8888826024583', '70af2aec3c3268a9a8359dcd06a3b72a.png', '3000', '5000', '999999', 94, 20, 'NCC02', 'MN02', 'LSP02', '', 1),
('SP015', 'Bột canh 180G', '8934561281696', '287652673_558881695830581_2757102238107310630_n.jpg', '32000', '46000', '999999', 90, 10, 'NCC02', 'MN01', 'LSP02', '', 1),
('SP016', 'STTT vinamilk 110ml dâu', '8934673574327', 'empty.png', '8000', '12000', '100000', 100, 100, 'NCC02', 'MN01', 'LSP05', '', 0),
('SP018', 'ád', 'ád', 'id shoppee.png', '222', '2222', '999999', 100, 20, 'NCC02', 'MN01', 'LSP02', '', 1),
('SP019', 'Đường ăn', '', 'empty.png', '2000', '5000', '4000', 80, 10, 'NCC02', 'MN01', 'LSP01', '', 1),
('SP01956', 'Đường ăn65456', '', 'empty.png', '2000', '5000', '4000', 64, 10, 'NCC02', 'MN01', 'LSP01', '', 1),
('SP01A', 'COCACOLA', '8934588012228', 'cocacola.png', '8000', '10000', '999999', 0, 20, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP01Ac', 'Revice chanh muối', '8934588843051', 'revicechanhmuoi.png', '8000', '10000', '999999', 86, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP01B', 'HENIKEN', '8934822201333', 'lon-heineken.png', '12000', '15000', '999999', 100, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP01Bc', 'Trà ô lông', '8934588873058', 'traolong.png', '12000', '15000', '999999', 99, 120, 'NCC02', 'MN01', 'LSP01', 'KO', 1),
('SP02A', 'String', '8934588232220', 'chaisting.png', '4000', '7000', '999999', 94, 70, 'NCC06', 'MN01', 'LSP02', 'KO', 1),
('SP02Av', 'Nước lọc aquafina', '8934588063053', 'nuocloc.png', '4000', '7000', '999999', 99, 70, 'NCC06', 'MN01', 'LSP02', 'KO', 1),
('SP03A', '7up 1,5L', '8934588023064', '7up1-5L.png', '3000', '5000', '999999', 82, 50, 'NCC03', 'MN01', 'LSP03', 'KO', 1),
('SP03Ai', 'Thuốc lá Demi(mèo bạc)', '8934674015416', 'thuocdemi.png', '3000', '15000', '999999', 95, 20, 'NCC03', 'MN01', 'LSP03', '', 1),
('SP03Aiaa', 'Bia tiger lon', '8934822101336', '9471798d16594cb09d617aee28d8297d.jpg', '3000', '15000', '999999', 99, 50, 'NCC03', 'MN01', 'LSP03', '', 1),
('SP03Aiaav', 'Pepsi lon', '8934588013065', 'banner.jpg', '50000', '60000', '999999', 78, 50, 'NCC03', 'MN01', 'LSP03', '', 1),
('SP03Aiaavff', 'Mirinda lon', '8934588132223', 'mirinda.png', '95000', '150000', '999999', 79, 50, 'NCC03', 'MN01', 'LSP03', '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thutienkhachhang`
--

CREATE TABLE `thutienkhachhang` (
  `ID` int(20) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `IDNhanVien` varchar(20) DEFAULT NULL,
  `IDKhachHang` varchar(20) DEFAULT NULL,
  `SoTien` decimal(10,0) DEFAULT NULL,
  `GhiChu` varchar(250) DEFAULT NULL
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
(6, '2022-09-20 09:39:19', 'NV09', 'KH01', '5000000', 'Khải thu ngày 20-09');

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
-- Chỉ mục cho bảng `ctphieukhachtrahang`
--
ALTER TABLE `ctphieukhachtrahang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDPhieuKTH` (`IDPhieuKTH`),
  ADD KEY `IDSanPham` (`IDSanPham`);

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
-- Chỉ mục cho bảng `phieukhachtrahang`
--
ALTER TABLE `phieukhachtrahang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDKhachHang` (`IDKhachHang`),
  ADD KEY `IDNhanVien` (`IDNhanVien`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;

--
-- AUTO_INCREMENT cho bảng `ctphieukhachtrahang`
--
ALTER TABLE `ctphieukhachtrahang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `phieutranoncc`
--
ALTER TABLE `phieutranoncc`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `thutienkhachhang`
--
ALTER TABLE `thutienkhachhang`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
-- Các ràng buộc cho bảng `ctphieukhachtrahang`
--
ALTER TABLE `ctphieukhachtrahang`
  ADD CONSTRAINT `ctphieukhachtrahang_ibfk_1` FOREIGN KEY (`IDPhieuKTH`) REFERENCES `phieukhachtrahang` (`ID`),
  ADD CONSTRAINT `ctphieukhachtrahang_ibfk_2` FOREIGN KEY (`IDSanPham`) REFERENCES `sanpham` (`ID`);

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
-- Các ràng buộc cho bảng `phieukhachtrahang`
--
ALTER TABLE `phieukhachtrahang`
  ADD CONSTRAINT `phieukhachtrahang_ibfk_1` FOREIGN KEY (`IDKhachHang`) REFERENCES `khachhang` (`ID`),
  ADD CONSTRAINT `phieukhachtrahang_ibfk_2` FOREIGN KEY (`IDNhanVien`) REFERENCES `khachhang` (`ID`),
  ADD CONSTRAINT `phieukhachtrahang_ibfk_3` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`id`);

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
