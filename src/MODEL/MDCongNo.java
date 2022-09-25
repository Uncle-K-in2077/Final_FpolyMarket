package MODEL;

import java.util.Date;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MDCongNo {

    public static void dataTableThuNoKhachHang(JTable table) {

        String sql = "SELECT thutienkhachhang.*, khachhang.name as 'tenKhachHang',nhanvien.name as 'tenNhanVien' FROM thutienkhachhang"
                + " join nhanvien on nhanvien.id =thutienkhachhang.IDNhanVien "
                + " join khachhang on khachhang.id = thutienkhachhang.IDKhachHang "
                + " order by thutienkhachhang.thoigian desc";

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("thoigian"),
                    rs.getString("tennhanvien"),
                    rs.getString("tenkhachhang"),
                    HELPER.helper.LongToString(rs.getLong("sotien")),
                    rs.getString("ghichu")
                });
            }
        } catch (Exception e) {
        }

        table.setModel(model);
    }
    
    public static void dataTableTraNoNhaCungCap(JTable table){
        String sql = "Select phieutranoncc.*, nhacungcap.name as 'tenNCC', nhanvien.name as 'tenNhanVien' From phieutranoncc,"
                + " nhacungcap, nhanvien WHERE phieutranoncc.idncc = nhacungcap.id and phieutranoncc.idNhanVien = nhanvien.id ";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("thoigian"),
                    rs.getString("tennhanvien"),
                    rs.getString("tenNCC"),
                    HELPER.helper.LongToString(rs.getLong("sotientra")),
                    rs.getString("ghichu")
                });
            }
        } catch (Exception e) {
        }

        table.setModel(model);
    }

    public static void thuNoKhachHang(String idnhanvien, String idkhachhang, String ghichu, long tien) {
        String sql = "insert into thutienkhachhang(thoigian,idnhanvien,idkhachhang,ghichu,sotien) values (?,?,?,?,?) ;";
        MDKhachHang.truNo(idkhachhang, tien);
        HELPER.SQLhelper.executeUpdate(sql,
                //thời gian
                HELPER.helper.LayNgayString(new Date(), "yyyy-MM-dd hh:mm:ss"),
                idnhanvien,
                idkhachhang,
                ghichu,
                tien
        );
    }
    
    public static void traNoNhaCungCap(String idnhanvien, String idnhacungcap, String ghichu, long tien){
        String sql = "insert into phieutranoncc(ThoiGian, idnhanvien, idncc, ghichu, sotientra) values (?,?,?,?,?)";
        MDNhaCungCap.truNoNCC(idnhacungcap, tien);
        HELPER.SQLhelper.executeUpdate(sql, 
                 HELPER.helper.LayNgayString(new Date(), "yyyy-MM-dd hh:mm:ss"),
                idnhanvien,
                idnhacungcap,
                ghichu,
                tien
        );
    }
}
