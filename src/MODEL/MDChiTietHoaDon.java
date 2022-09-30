package MODEL;

import CLASS.chiTietHoaDon;
import CLASS.hoaDon;
import static MODEL.MDHoaDon.getHoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public static ArrayList<chiTietHoaDon> getChiTietHoaDon(String idHoaDon) {
        ArrayList<chiTietHoaDon> data = new ArrayList<>();

        hoaDon hoadon = getHoaDon(idHoaDon);
        String sql = "select chitiethoadon.*, sanpham.name as 'tensanpham',sanpham.GiaBan as 'giabanle', donvitinh.name as 'tendonvitinh',sanpham.SoLuong as 'tonkho',sanpham.giaSi as 'giaBanSi' from chitiethoadon "
                + "join sanpham on sanpham.id = chitiethoadon.idsanpham "
                + "join donvitinh on donvitinh.id = sanpham.IDDonViTinh "
                + " "
                + "where chitiethoadon.idhoadon = ? and chitiethoadon.trangthai=1";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, idHoaDon);
        try {
            while (rs.next()) {
                if (hoadon.getLoaiGia() == 0) { // giá lẽ
                    data.add(new chiTietHoaDon(
                            rs.getString("idsanpham"), //id sanpham
                            rs.getString("tensanpham"),//tensanpham
                            rs.getString("tendonvitinh"),//donvitinh
                            rs.getInt("soluong"),//soluong
                            rs.getInt("tonkho"),//tonkho
                            rs.getLong("giaban"),//giaban
                            rs.getLong("giabansi"),//giasi
                            true));
                } else {  // giá sĩ
                    data.add(new chiTietHoaDon(
                            rs.getString("idsanpham"), //id sanpham
                            rs.getString("tensanpham"),//tensanpham
                            rs.getString("tendonvitinh"),//donvitinh
                            rs.getInt("soluong"),//soluong
                            rs.getInt("tonkho"),//tonkho
                            rs.getLong("giabanle"),//giaban
                            rs.getLong("giaban"),//giasi
                            true));
                }
            }
        } catch (Exception e) {
        }
        return data;
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
