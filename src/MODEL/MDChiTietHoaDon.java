package MODEL;

import CLASS.chiTietHoaDon;
import java.sql.ResultSet;

public class MDChiTietHoaDon {

    public static chiTietHoaDon getSanPhamChiTietHoaDon(String barcode) {
        String sql = "select sanpham.*, donvitinh.Name as 'dvt' from sanpham "
                + " join donvitinh on donvitinh.id = sanpham.IDDonViTinh "
                + "where sanpham.Barcode = ? ";
        chiTietHoaDon chiTiet = null;
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, barcode);
        try {
            while (rs.next()) {
                if (rs.getInt("trangthai") == 0) {
                    return null;
                }
                chiTiet = new chiTietHoaDon(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("dvt"),
                        1,
                        rs.getInt("soluong"),
                        rs.getLong("giaban"),
                        rs.getLong("giaSi"),
                        true
                );
            }
        } catch (Exception e) {
        }
        return chiTiet;
    }

    public static chiTietHoaDon getSanPhamChiTietHoaDonbyID(String idsp) {
        String sql = "select sanpham.*, donvitinh.Name as 'dvt' from sanpham "
                + " join donvitinh on donvitinh.id = sanpham.IDDonViTinh "
                + "where sanpham.id = ?";
        chiTietHoaDon chiTiet = null;
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, idsp);
        try {
            while (rs.next()) {
                if (rs.getInt("trangthai") == 0) {
                    return null;
                }
                if (rs.getInt("soluong") < 1) {
                    return null;
                }
                chiTiet = new chiTietHoaDon(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("dvt"),
                        1,
                        rs.getInt("soluong"),
                        rs.getLong("giaban"),
                        rs.getLong("giaSi"),
                        true
                );

            }
        } catch (Exception e) {
        }
        return chiTiet;
    }
}
