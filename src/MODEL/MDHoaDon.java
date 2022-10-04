package MODEL;

import CLASS.chiTietHoaDon;
import CLASS.hoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MDHoaDon {

    public static void showHoaDonCuaNhanVien(String idNhanVien, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        String sql = "select hoadon.*, nhanvien.name as 'tennhanvien' , khachhang.name as 'tenkhachhang'  from hoadon "
                + "join nhanvien  on nhanvien.id=hoadon.IDnhanvien "
                + "join khachhang on khachhang.id = hoadon.IDkhachHang "
                + "where hoadon.IDnhanvien = ? and hoadon.trangthai=1";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, idNhanVien);
        String hinhThuc = "";
        try {
            while (rs.next()) {

                if (rs.getInt("hinhthucthanhtoan") == 1) {
                    hinhThuc = "Tiền mặt";
                } else if (rs.getInt("hinhthucthanhtoan") == 2) {
                    hinhThuc = "Chuyển khoản";
                } else if (rs.getInt("hinhthucthanhtoan") == 3) {
                    hinhThuc = "Nợ";
                }
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("tenkhachhang"),
                    rs.getString("tennhanvien"),
                    HELPER.helper.LongToString(rs.getLong("tongtienthanhtoan")),
                    HELPER.helper.LongToString(rs.getLong("giamgia")),
                    hinhThuc,
                    rs.getString("thoigian"),
                    rs.getString("ghichu")
                });
            }
        } catch (Exception e) {
        }

        table.setModel(model);
    }

    public static void remove(String id) {
        String sql = "update hoadon set trangthai = 0 where id = ?";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static void updateHoaDon() {

    }

    public static String craeteID() {
        String id = "HD";
        String date = HELPER.helper.LayNgayString(new Date(), "ddMM");
        Random r = new Random();
        String alphabet = "1234567890";
        String random = "";
        for (int i = 0; i < 4; i++) {
            random += r.nextInt(alphabet.length());
        }
        return id + date + random;
    }

    public static hoaDon getHoaDon(String idhoaDon) {
        hoaDon hoadon = null;

        String sql = "select hoadon.* from hoadon where hoadon.id = ? and hoadon.trangthai=1";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, idhoaDon);
        try {
            while (rs.next()) {
                return new hoaDon(
                        rs.getString("id"),
                        rs.getString("idnhanvien"),
                        rs.getString("idkhachhang"),
                        rs.getString("thoigian"),
                        rs.getInt("hinhthucthanhtoan"),
                        rs.getLong("soTienNhanDuoc"),
                        rs.getString("ghichu"),
                        rs.getLong("giamgia"),
                        rs.getLong("tongtienthanhtoan"),
                        rs.getInt("loaigia"),
                        true);
            }
        } catch (Exception e) {
        }

        return hoadon;
    }

    public static void loadThongKeDuLieu(JLabel soHoaDonTrongNgay,
            JLabel soHoaDonTrongTuan,
            JLabel soDoanhThuTrongNgay,
            JLabel soDoanhThuTrongThang) {
        String date = HELPER.helper.LayNgayString(new Date(), "yyyy-MM-dd");

        String hoaDonTrongNgay = "select count(id) as 'count' from hoadon "
                + "where date(hoadon.ThoiGian) = ? ";

        String hoaDonTrongTuan = " select count(id) as 'count' from hoadon "
                + "where date(hoadon.ThoiGian) BETWEEN (SELECT DATE_ADD(?, INTERVAL -7 day)) and ?";

        String doanhThuTrongNgay = " select sum(hoadon.TongTienThanhToan) as 'sum' from hoadon "
                + "where date(hoadon.ThoiGian) = ? ";

        String doanhThuTrongThang = " select sum(hoadon.TongTienThanhToan) as 'sum' from hoadon "
                + "where date(hoadon.ThoiGian) BETWEEN (SELECT DATE_ADD( ? , INTERVAL -1 MONTH)) and ? ";

        ResultSet rsHoaDonTrongNgay = HELPER.SQLhelper.executeQuery(hoaDonTrongNgay, date);

        ResultSet rshoaDonTrongTuan = HELPER.SQLhelper.executeQuery(hoaDonTrongTuan, date, date);

        ResultSet rsdoanhThuTrongNgay = HELPER.SQLhelper.executeQuery(doanhThuTrongNgay, date);

        ResultSet rsdoanhThuTrongThang = HELPER.SQLhelper.executeQuery(doanhThuTrongThang, date, date);
        try {
            while (rsHoaDonTrongNgay.next()) {
                soHoaDonTrongNgay.setText(rsHoaDonTrongNgay.getString("count"));
            }
            while (rshoaDonTrongTuan.next()) {
                soHoaDonTrongTuan.setText(rshoaDonTrongTuan.getString("count"));
            }
            while (rsdoanhThuTrongNgay.next()) {
                soDoanhThuTrongNgay.setText(HELPER.helper.LongToString(rsdoanhThuTrongNgay.getLong("sum")));
            }
            while (rsdoanhThuTrongThang.next()) {
                soDoanhThuTrongThang.setText(HELPER.helper.LongToString(rsdoanhThuTrongThang.getLong("sum")));
            }
        } catch (Exception e) {
        }

    }

    public static void showDoanhThuTrongNgay(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        String date = HELPER.helper.LayNgayString(new Date(), "yyyy-MM-dd");
        String sql = "select chitiethoadon.* , sanpham.name as 'tensanpham' , hoadon.thoigian as 'thoigian',( chitiethoadon.giaBan*chitiethoadon.soluong ) as 'doanhthu',"
                + " ( ( chitiethoadon.giaBan*chitiethoadon.soluong )-(chitiethoadon.soluong*sanpham.gianhap)) as 'loinhuan' from chitiethoadon "
                + "join sanpham on sanpham.id = chitiethoadon.idsanpham "
                + "join hoadon on hoadon.id = chitiethoadon.idhoadon "
                + "where date(hoadon.ThoiGian) = ? "
                + "order by hoadon.thoigian desc";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, date);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("tensanpham"),
                    HELPER.helper.LongToString(rs.getLong("giaban")),
                    rs.getInt("soluong"),
                    rs.getString("thoigian"),
                    HELPER.helper.LongToString(rs.getLong("doanhthu")),
                    HELPER.helper.LongToString(rs.getLong("loinhuan")),});
            }
        } catch (Exception e) {
        }
        table.setModel(model);
    }

    public static void showHoaDonTrongNgay(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        String date = HELPER.helper.LayNgayString(new Date(), "yyyy-MM-dd");
        String sql = "select hoadon.*,nhanvien.name as 'tennhanvien' , khachhang.name as 'tenkhachhang' from hoadon "
                + "join nhanvien on nhanvien.id = hoadon.IDnhanvien  "
                + "join khachhang on khachhang.id = hoadon.IDkhachHang  "
                + "WHERE date(hoadon.ThoiGian) = ? "
                + "order by hoadon.thoigian desc";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, date);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("tennhanvien"),
                    rs.getString("tenkhachhang"),
                    rs.getString("thoigian"),
                    HELPER.helper.LongToString(rs.getLong("tongtienthanhtoan"))
                });
            }
        } catch (Exception e) {
        }
        table.setModel(model);
    }

    public static void taoHoaDon(hoaDon hoadon, long tienKhachDua, JTable tableGioHang, ArrayList<chiTietHoaDon> dataGioHang) {

        String sql = "insert into hoadon values(?,?,?,?,?,?,?,?,?,?,?)";
        // tạo hóa đơn trước.
        HELPER.SQLhelper.executeUpdate(
                sql,
                hoadon.getId(),
                hoadon.getIdNhanVien(),
                hoadon.getIdKhachHang(),
                hoadon.getThoiGian(),
                hoadon.getHinhThucThanhToan(),
                hoadon.getGiamGia(),
                hoadon.getTongTien(),
                hoadon.getSoTienNhanDuoc(),
                hoadon.getLoaiGia(),
                hoadon.getGhiChu(),
                hoadon.isTrangThai()
        );

        if (hoadon.getHinhThucThanhToan() == 3) { // nếu như thanh toán nợ
            long tienNo = hoadon.getTongTien() - tienKhachDua;
            String congNoKhachHang = "update khachhang set khachhang.congno = khachhang.congno + ? where khachhang.id = ?";
            HELPER.SQLhelper.executeUpdate(congNoKhachHang, tienNo, hoadon.getIdKhachHang());
        }
        // tạo chi tiết hóa đơn sau
        String sqlChiTietHoaDon = "insert into chitiethoadon(idhoadon,idsanpham,soluong,chitiethoadon.giaban,trangthai) values(?,?,?,?,1)";
        String sqlTruTonKho = "update sanpham set sanpham.soluong = sanpham.soluong - ? where sanpham.id = ?";

        int rows = tableGioHang.getRowCount();
        for (int i = 0; i < rows; i++) {
            // thêm chi tiết hóa đơn.
            HELPER.SQLhelper.executeUpdate(sqlChiTietHoaDon,
                    hoadon.getId(),
                    dataGioHang.get(i).getIdSanPham(),
                    Integer.parseInt(tableGioHang.getValueAt(i, 2) + ""),
                    HELPER.helper.StringToLong(tableGioHang.getValueAt(i, 3) + "")
            );

            // trừ số lượng tồn kho từng sản phẩm được bán
            HELPER.SQLhelper.executeUpdate(sqlTruTonKho, dataGioHang.get(i).getSoLuong(), dataGioHang.get(i).getIdSanPham());
        }

    }

    public static void getDanhSachHoaDon(JTable table) {
        String sql = " select hoadon.*,nhanvien.name as 'tennhanvien',khachhang.name as 'tenkhachhang',STR_TO_DATE(hoadon.thoigian, '%Y-%m-%d %H:%i:%s') as 'time' from hoadon"
                + " join nhanvien on nhanvien.id = hoadon.idnhanvien "
                + " join khachhang on khachhang.id = hoadon.idkhachhang"
                + " where hoadon.trangthai=1 "
                + "order by hoadon.thoigian desc";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        String hinhThuc = "";
        try {
            while (rs.next()) {
                if (rs.getInt("hinhthucthanhtoan") == 1) {
                    hinhThuc = "Tiền mặt";
                } else if (rs.getInt("hinhthucthanhtoan") == 2) {
                    hinhThuc = "Chuyển khoản";
                } else if (rs.getInt("hinhthucthanhtoan") == 3) {
                    hinhThuc = "Nợ";
                }
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("tenkhachhang"),
                    rs.getString("tennhanvien"),
                    HELPER.helper.LongToString(rs.getLong("tongtienthanhtoan")),
                    HELPER.helper.LongToString(rs.getLong("giamgia")),
                    hinhThuc,
                    rs.getString("time"),});
            }
        } catch (Exception e) {
        }
        table.setModel(model);
    }

    public static void showChiTietHoaDon(String idhoadon, JTable table) {
        String sql = " select chitiethoadon.*,  donvitinh.name as 'dvt',sanpham.name as 'tensanpham',(chitiethoadon.soluong * chitiethoadon.giaban) as 'thanhtien' from chitiethoadon"
                + " join sanpham on sanpham.id=chitiethoadon.idsanpham "
                + " join donvitinh on sanpham.iddonvitinh = donvitinh.id "
                + "where chitiethoadon.idhoadon = ?";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, idhoadon);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("tensanpham"),
                    rs.getInt("soluong"),
                    rs.getString("dvt"),
                    HELPER.helper.LongToString(rs.getLong("giaban")),
                    HELPER.helper.LongToString(rs.getLong("thanhtien"))
                });
            }
        } catch (Exception e) {
        }
        table.setModel(model);
    }
}
