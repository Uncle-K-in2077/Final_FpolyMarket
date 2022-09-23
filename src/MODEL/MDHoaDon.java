package MODEL;

import CLASS.chiTietHoaDon;
import CLASS.hoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MDHoaDon {

    public static String craeteID() {
        String id = "HD";
        String date = HELPER.helper.LayNgayString(new Date(), "yyyyMMdd");
        String sql = "select count(id) as 'count' from hoadon";
        int count = 0;
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
        }

        return id + date + (count + 1);
    }

    public static void taoHoaDon(hoaDon hoadon, long tienKhachDua, JTable tableGioHang, ArrayList<chiTietHoaDon> dataGioHang) {

        String sql = "insert into hoadon values(?,?,?,?,?,?,?,?,?,?)";
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
        String sqlChiTietHoaDon = "insert into chitiethoadon(idhoadon,idsanpham,soluong,chitiethoadon.giaban) values(?,?,?,?)";
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
        String sql = " select hoadon.*,nhanvien.name as 'tennhanvien',khachhang.name as 'tenkhachhang' from hoadon"
                + " join nhanvien on nhanvien.id = hoadon.idnhanvien "
                + " join khachhang on khachhang.id = hoadon.idkhachhang"
                + " where hoadon.trangthai=1 "
                + "order by hoadon.thoigian desc";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("tenkhachhang"),
                    rs.getString("tennhanvien"),
                    HELPER.helper.LongToString(rs.getLong("giamgia")),
                    HELPER.helper.LongToString(rs.getLong("tongtienthanhtoan")),
                    rs.getString("thoigian"),});
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
