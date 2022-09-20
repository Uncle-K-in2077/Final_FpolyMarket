package MODEL;

import CLASS.chiTietHoaDon;
import java.sql.ResultSet;

public class MDChiTietHoaDon {

    public static chiTietHoaDon getSanPhamChiTietHoaDon(String barcode) {
        String sql = "select sanpham.*, donvitinh.Name as 'dvt' from sanpham "
                + " join donvitinh on donvitinh.id = sanpham.IDDonViTinh "
                + "where sanpham.Barcode = ?";
        chiTietHoaDon chiTiet = null;
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, barcode);
        try {
            while (rs.next()) {
                chiTiet = new chiTietHoaDon(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("dvt"),
                        1,
                        rs.getLong("giaban"),
                        true
                );

            }
        } catch (Exception e) {
        }
        return chiTiet;
    }
}
