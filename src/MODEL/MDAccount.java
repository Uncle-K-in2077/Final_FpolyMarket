package MODEL;

import java.sql.ResultSet;
import CLASS.Account;
import java.util.ArrayList;

public class MDAccount {

    public static Account getAccount(String username) {
        String sql = "select * from account where username = ?;";

        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, username);
        Account acc = null; // ta?o ra
        try {
            while (rs.next()) {
                acc.setUsername(rs.getString("UserName"));
                acc.setPassword(rs.getString("Password"));
                acc.setIdNhanVien(rs.getString("IDNhanVien"));
                acc.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                acc.setBanHang(rs.getInt("banhang") == 1 ? true : false);
                acc.setNhapHang(rs.getInt("nhaphang") == 1 ? true : false);
                acc.setTaiKhoan(rs.getInt("taikhoan") == 1 ? true : false);
                acc.setHangHoa(rs.getInt("hanghoa") == 1 ? true : false);
                acc.setNhanVien(rs.getInt("nhanvien") == 1 ? true : false);
                acc.setKhachHang(rs.getInt("khachhang") == 1 ? true : false);
                acc.setBaoCao(rs.getInt("baocao") == 1 ? true : false);
                acc.setNhaCungCap(rs.getInt("nhacungcap") == 1 ? true : false);
                acc.setPhieuChi(rs.getInt("phieuchi") == 1 ? true : false);
            }
        } catch (Exception e) {
        }

        return acc;
    }

    public static ArrayList<Account> getDataToTable() {

        String sql = "select username,account.password,nhanvien.name as 'tennhanvien',account.TrangThai,banhang,nhaphang,taikhoan,hanghoa,nhanvien,khachhang,account.nhacungcap,baocao,phieuchi from account\n"
                + "join nhanvien on nhanvien.id=account.IDNhanVien";
        ArrayList<Account> data = new ArrayList<>();
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new Account(
                        rs.getString("tennhanvien"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("trangthai") == 1 ? true : false,
                        rs.getInt("banhang") == 1 ? true : false,
                        rs.getInt("nhaphang") == 1 ? true : false,
                        rs.getInt("taikhoan") == 1 ? true : false,
                        rs.getInt("hanghoa") == 1 ? true : false,
                        rs.getInt("nhanvien") == 1 ? true : false,
                        rs.getInt("khachhang") == 1 ? true : false,
                        rs.getInt("nhacungcap") == 1 ? true : false,
                        rs.getInt("baocao") == 1 ? true : false,
                        rs.getInt("phieuchi") == 1 ? true : false
                ));
            }
        } catch (Exception ex) {
            System.out.println("Loi lay du lieu " + ex.getMessage());
        }
        return data;
    }

    public static ArrayList<Account> getAll() {
        ArrayList<Account> arr = new ArrayList<>();
        String sql = "Select account.*,nhanvien.name as 'tennhanvien' From Account join nhanvien on nhanvien.id=account.idnhanvien";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                Account acc = new Account();

                acc.setUsername(rs.getString("UserName"));
                acc.setPassword(rs.getString("Password"));
                acc.setIdNhanVien(rs.getString("tennhanvien"));
                acc.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                acc.setBanHang(rs.getInt("banhang") == 1 ? true : false);
                acc.setBaoCao(rs.getInt("baocao") == 1 ? true : false);
                acc.setKhachHang(rs.getInt("khachhang") == 1 ? true : false);
                acc.setNhaCungCap(rs.getInt("nhacungcap") == 1 ? true : false);
                acc.setNhanVien(rs.getInt("nhanvien") == 1 ? true : false);
                acc.setNhapHang(rs.getInt("nhaphang") == 1 ? true : false);
                acc.setTaiKhoan(rs.getInt("taikhoan") == 1 ? true : false);
                acc.setPhieuChi(rs.getInt("phieuchi") == 1 ? true : false);
                acc.setHangHoa(rs.getInt("hanghoa") == 1 ? true : false);
                arr.add(acc);
            }
        } catch (Exception ex) {
            System.out.println("Loi lay du lieu " + ex.getMessage());
        }
        return arr;
    }

    public static void add(Account acc) {

        String sql = "INSERT INTO Account (Username, Password, IDNhanVien, TrangThai, BanHang, NhapHang, TaiKhoan, HangHoa, NhanVien, "
                + " KhachHang, NhaCungCap, BaoCao, PhieuChi) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        HELPER.SQLhelper.executeUpdate(sql,
                acc.getUsername(),
                acc.getPassword(),
                acc.getIdNhanVien(),
                acc.isTrangThai() == true ? 1 : 0,
                acc.isBanHang() == true ? 1 : 0,
                acc.isNhapHang() == true ? 1 : 0,
                acc.isTaiKhoan() == true ? 1 : 0,
                acc.isHangHoa() == true ? 1 : 0,
                acc.isNhanVien() == true ? 1 : 0,
                acc.isKhachHang() == true ? 1 : 0,
                acc.isNhaCungCap() == true ? 1 : 0,
                acc.isBaoCao() == true ? 1 : 0,
                acc.isPhieuChi() == true ? 1 : 0);
    }

    // return 1 dô´i tuo?ng
    public static Account getAccount(String username, String password) {
        String sql = "select * from account where account.username = ? and account.password = ?";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, username, password);
        Account acc = new Account();
        try {
            while (rs.next()) {
                acc.setUsername(rs.getString("UserName"));
                acc.setPassword(rs.getString("Password"));
                acc.setIdNhanVien(rs.getString("IDNhanVien"));
                acc.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                acc.setBanHang(rs.getInt("banhang") == 1 ? true : false);
                acc.setNhapHang(rs.getInt("nhaphang") == 1 ? true : false);
                acc.setTaiKhoan(rs.getInt("taikhoan") == 1 ? true : false);
                acc.setHangHoa(rs.getInt("hanghoa") == 1 ? true : false);
                acc.setNhanVien(rs.getInt("nhanvien") == 1 ? true : false);
                acc.setKhachHang(rs.getInt("khachhang") == 1 ? true : false);
                acc.setBaoCao(rs.getInt("baocao") == 1 ? true : false);
                acc.setNhaCungCap(rs.getInt("nhacungcap") == 1 ? true : false);
                acc.setPhieuChi(rs.getInt("phieuchi") == 1 ? true : false);
            }
        } catch (Exception e) {
        }

        return acc;// tra? vê`
    }

    //Hàm xóa
    public static void remove(String Username) {
        // không xóa hoàn toản, đưa trạng thái về 0
        String sql = " Update Account set TrangThai = 0 Where Username = ?";
        HELPER.SQLhelper.executeUpdate(sql, Username);
    }

    //Hàm Update
    public static void updateAccount(Account acc) {
        String sql = "UPDATE Account set Username = ?, Password = ?, TrangThai = ?, BanHang = ?, NhapHang = ?, TaiKhoan = ?, HangHoa = ?,"
                + " NhanVien = ?, KhachHang = ?, NhaCungCap = ?, BaoCao = ?, PhieuChi = ? Where IDNhanVien = ?";
        HELPER.SQLhelper.executeUpdate(sql,
                acc.getUsername(),
                acc.getPassword(),
                acc.isTrangThai(),
                acc.isBanHang(),
                acc.isNhapHang(),
                acc.isTaiKhoan(),
                acc.isHangHoa(),
                acc.isNhanVien(),
                acc.isKhachHang(),
                acc.isNhaCungCap(),
                acc.isBaoCao(),
                acc.isPhieuChi(),
                acc.getIdNhanVien());
    }

    public static void reStore(String username) {
        String sql = "update account set trangthai=1 where username = ?";
        HELPER.SQLhelper.executeUpdate(sql, username);
    }

    public static String createId() {
        String id = "";
        String sql = "select count(id) as 'count' from Account";
        int count = 0;
        try {
            ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
        }
        id = "ACC0" + (++count);
        return id;
    }
    //Không đùa được đâu :)))
}
