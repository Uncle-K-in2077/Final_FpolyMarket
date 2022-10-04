/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import CLASS.nhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class MDNhaCungCap {

    public static void truNoNCC(String idNCC, long tien) {
        String sql = "update NhaCungCap set congno = congno-? where id= ?";

        HELPER.SQLhelper.executeUpdate(sql, tien, idNCC);
    }

    public static void arrayToTable(JTable table) {
        String sql = "select * from nhacungcap";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("diachi"),
                    rs.getString("sodienthoai"),
                    rs.getString("ghichu"),
                    HELPER.helper.LongToString(rs.getLong("congno")),
                    rs.getInt("trangthai") == 1 ? true : false,});
            }
        } catch (Exception ex) {
            System.out.println("Loi lay du lieu " + ex.getMessage());
        }
        table.setModel(model);
    }

    public static ArrayList<nhaCungCap> getAll() {
        ArrayList<nhaCungCap> data = new ArrayList<>();
        String sql = "select * from NhaCungCap where trangthai = 1";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new nhaCungCap(
                        rs.getString("ID"),
                        rs.getString("name"),
                        rs.getString("SoDienThoai"),
                        rs.getString("DiaChi"),
                        rs.getString("GhiChu"),
                        rs.getLong("congNo"),
                        rs.getInt("trangthai") == 1 ? true : false
                ));
            }
        } catch (Exception e) {
        }
        return data;
    }

    public static nhaCungCap getNhaCungCap(String id) {
        String sql = "select * from NhaCungCap where id = ?";
        nhaCungCap ncc = new nhaCungCap();
        HELPER.SQLhelper.executeQuery(sql);
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                ncc = new nhaCungCap(
                        rs.getString("ID"),
                        rs.getString("name"),
                        rs.getString("SoDienThoai"),
                        rs.getString("DiaChi"),
                        rs.getString("GhiChu"),
                        rs.getLong("congNo"),
                        rs.getInt("trangthai") == 1 ? true : false
                );
            }
        } catch (Exception e) {
        }

        return ncc;
    }

    public static void add(nhaCungCap ncc) {
        String sql = "insert into NhaCungCap values(?,?,?,?,?,?,?,?)";
        HELPER.SQLhelper.executeUpdate(sql,
                ncc.getIdNhaCungCap(),
                ncc.getName(),
                ncc.getSoDienThoai(),
                ncc.getDiaChi(),
                ncc.getGhiChu(),
                ncc.getCongNo(),
                ncc.isTrangThai() == true ? 1 : 0,
                HELPER.helper.getDateTime()
        );
    }

    public static void remove(String id) {
        String sql = "update NhaCungCap set trangthai=0 where id=?";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static void update(nhaCungCap ncc) {
        String sql = "update NhaCungCap set name=?,sodienthoai=?,diachi=?,ghichu=?,congno=?,trangthai=? where id=?";
        HELPER.SQLhelper.executeUpdate(sql,
                ncc.getName(),
                ncc.getSoDienThoai(),
                ncc.getDiaChi(),
                ncc.getGhiChu(),
                ncc.getCongNo(),
                ncc.isTrangThai() == true ? 1 : 0,
                ncc.getIdNhaCungCap()
        );
    }

    public static void reStore(String id) {
        String sql = "update NhaCungCap set trangthai=1 where id = ? ";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static String createId() {
        String id = "";
        String sql = "select count(id) as 'count' from NhaCungCap";
        int count = 0;
        try {
            ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
        }
        id = "NCC0" + (++count);
        return id;
    }

    //Quick add chưa chắc lắm đoạn này
    public static void quickAdd(String id, String name, String sdt, String diachi) {
        String sql = "insert into NhaCungCap(id,name,SoDienThoai,DiaChi,thoigian) values(?,?,?,?,?);";
        HELPER.SQLhelper.executeUpdate(sql, id, name, sdt, diachi, HELPER.helper.getDateTime());
    }
}
