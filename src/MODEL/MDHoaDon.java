package MODEL;

import CLASS.chiTietHoaDon;
import CLASS.hoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;

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

        return id + date + (++count);
    }

    public static void taoHoaDon(hoaDon hoadon, long tienKhachDua, JTable tableGioHang, ArrayList<chiTietHoaDon> dataGioHang) {

        String sql = "insert into hoadon values(?,?,?,?,?,?,?,?,?)";
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
        int rows = tableGioHang.getRowCount();
        for (int i = 0; i < rows; i++) {
            HELPER.SQLhelper.executeUpdate(sqlChiTietHoaDon,
                    hoadon.getId(),
                    dataGioHang.get(i).getIdSanPham(),
                    Integer.parseInt(tableGioHang.getValueAt(i, 2) + ""),
                    HELPER.helper.StringToLong(tableGioHang.getValueAt(i, 3) + "")
            );
        }
    }
}
