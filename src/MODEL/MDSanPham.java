package MODEL;

import CLASS.sanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MDSanPham {

    public static void quickAdd(String ten, long giaBan, String barcode) {
        String sql = "insert into sanpham(id,name,barcode,giaBan,giasi,hinhAnh,idnhacungcap,idloaisanpham,iddonvitinh,soluong,soluongtoithieu,trangthai,ghichu) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        HELPER.SQLhelper.executeUpdate(sql,
                createId(),
                ten,
                barcode,
                giaBan,
                0,
                "empty.png",
                "01",
                "01",
                "01",
                0,
                0,
                true,
                "Chưa đầy đủ thông tin !!!"
        );
    }

    public static ArrayList<sanPham> getDataToTable() {
        ArrayList<sanPham> data = new ArrayList<>();
        String sql = "SELECT sanpham.* ,donvitinh.name as 'dvt', loaisanpham.name as 'lsp' from sanpham "
                + "join donvitinh on donvitinh.id = sanpham.IDDonViTinh "
                + "join loaisanpham on loaisanpham.id=sanpham.idLoaiSanPham"
                + " order by trangthai desc";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new sanPham(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("barcode"),
                        rs.getString("hinhanh"),
                        rs.getLong("GiaNhap"),
                        rs.getLong("GiaBan"),
                        rs.getLong("giaSi"),
                        rs.getInt("Soluong"),
                        rs.getInt("soLuongToiThieu"),
                        rs.getString("idNhaCungCap"),
                        rs.getString("dvt"),
                        rs.getString("lsp"),
                        rs.getString("GhiChu"),
                        rs.getInt("trangthai") == 1 ? true : false
                ));
            }
        } catch (Exception e) {
        }
        return data;
    }

    public static ArrayList<sanPham> getDataToTableBanHang() {
        ArrayList<sanPham> data = new ArrayList<>();
        String sql = "SELECT sanpham.* ,donvitinh.name as 'dvt', loaisanpham.name as 'lsp' from sanpham "
                + "join donvitinh on donvitinh.id = sanpham.IDDonViTinh "
                + "join loaisanpham on loaisanpham.id=sanpham.idLoaiSanPham"
                + " where sanpham.trangthai = 1 and sanpham.soluong>0"
                + " order by trangthai desc";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new sanPham(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("barcode"),
                        rs.getString("hinhanh"),
                        rs.getLong("GiaNhap"),
                        rs.getLong("GiaBan"),
                        rs.getLong("giaSi"),
                        rs.getInt("Soluong"),
                        rs.getInt("soLuongToiThieu"),
                        rs.getString("idNhaCungCap"),
                        rs.getString("dvt"),
                        rs.getString("lsp"),
                        rs.getString("GhiChu"),
                        rs.getInt("trangthai") == 1 ? true : false
                ));
            }
        } catch (Exception e) {
        }
        return data;
    }

    public static ArrayList<sanPham> getAll() {
        ArrayList<sanPham> data = new ArrayList<>();
        String sql = "select * from SanPham where trangthai = 1";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new sanPham(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("barcode"),
                        rs.getString("hinhanh"),
                        rs.getLong("GiaNhap"),
                        rs.getLong("GiaBan"),
                        rs.getLong("giaSi"),
                        rs.getInt("Soluong"),
                        rs.getInt("soLuongToiThieu"),
                        rs.getString("idNhaCungCap"),
                        rs.getString("idDonViTinh"),
                        rs.getString("idLoaiSanPham"),
                        rs.getString("GhiChu"),
                        rs.getInt("trangthai") == 1 ? true : false
                ));
            }
        } catch (Exception e) {
        }
        return data;
    }

    public static sanPham getSanPham(String id) {
        sanPham item = new sanPham();
        String sql = "select * from SanPham where id = ?";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, id);
        try {
            while (rs.next()) {
                item = new sanPham(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("barcode"),
                        rs.getString("hinhanh"),
                        rs.getLong("GiaNhap"),
                        rs.getLong("GiaBan"),
                        rs.getLong("giaSi"),
                        rs.getInt("Soluong"),
                        rs.getInt("soLuongToiThieu"),
                        rs.getString("idNhaCungCap"),
                        rs.getString("idDonViTinh"),
                        rs.getString("IDLoaiSanPham"),
                        rs.getString("GhiChu"),
                        rs.getInt("trangthai") == 1 ? true : false
                );
            }
        } catch (Exception e) {
        }
        return item;
    }

    public static void add(sanPham item) {
        String sql = "insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        HELPER.SQLhelper.executeUpdate(sql,
                item.getIdSanPham(),
                item.getName(),
                item.getBarcode(),
                item.getHinhAnh() == null ? "empty.png" : item.getHinhAnh(),
                item.getGiaNhap(),
                item.getGiaBan(),
                item.getGiaSi(),
                item.getSoLuong(),
                item.getSoLuongToiThieu(),
                item.getIdNhaCungCap(),
                item.getIdDonViTinh(),
                item.getIdLoaiSanPham(),
                item.getGhiChu(),
                item.isTrangThai() == true ? 1 : 0,
                HELPER.helper.getDateTime()
        );
    }

    public static void remove(String id) {
        String sql = "update SanPham set trangthai=0 where id=?";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static void update(sanPham sp) {
        String sql = "update SanPham set name=?,giasi=?, barcode=?, hinhanh = ?, Gianhap=?, GiaBan=?, SoLuong=?, SoLuongToiThieu=?, "
                + " IDNhaCungCap=?, IDDonViTinh=?, IDLoaiSanPham=?, GhiChu=?, Trangthai=? where id=?";
        HELPER.SQLhelper.executeUpdate(sql,
                sp.getName(),
                sp.getGiaSi(),
                sp.getBarcode(),
                sp.getHinhAnh() == null ? "empty.png" : sp.getHinhAnh(),
                sp.getGiaNhap(),
                sp.getGiaBan(),
                sp.getSoLuong(),
                sp.getSoLuongToiThieu(),
                sp.getIdNhaCungCap(),
                sp.getIdDonViTinh(),
                sp.getIdLoaiSanPham(),
                sp.getGhiChu(),
                sp.isTrangThai() == true ? 1 : 0,
                sp.getIdSanPham());
    }

    public static void reStore(String id) {
        String sql = "update sanPham set trangthai=1 where id = ? ";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    //hàm auto create ID cho Sanr Phaamr
    public static String createId() {
        String id = "";
        String sql = "select count(id) as 'count' from SanPham";
        int count = 0;
        try {
            ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
        }
        id = "SP0" + (++count);
        return id;
    }

    public static ArrayList<sanPham> getSPsapHetHang() {
        ArrayList<sanPham> data = new ArrayList<>();
        String sql = "select * from SanPham where Soluong <= SoLuongToiThieu";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new sanPham(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("barcode"),
                        rs.getString("hinhanh"),
                        rs.getLong("GiaNhap"),
                        rs.getLong("GiaBan"),
                        rs.getLong("giaSi"),
                        rs.getInt("Soluong"),
                        rs.getInt("soLuongToiThieu"),
                        rs.getString("idNhaCungCap"),
                        rs.getString("idDonViTinh"),
                        rs.getString("idLoaiSanPham"),
                        rs.getString("GhiChu"),
                        rs.getInt("trangthai") == 1 ? true : false
                ));
            }
        } catch (Exception e) {
        }
        return data;
    }
//    public static void quickAdd(String id, String name, String sdt, String diachi) {
//        String sql = "insert into SanPham(id,name,SoDienThoai,DiaChi) values(?,?,?,?);";
//        HELPER.SQLhelper.executeUpdate(sql, id, name, sdt, diachi);
//    }
}
