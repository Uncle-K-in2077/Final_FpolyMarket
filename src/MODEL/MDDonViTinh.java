/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import CLASS.donViTinh;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class MDDonViTinh {

    public static String createId() {
        String id = "";
        String sql = "select count(id) as 'count' from donvitinh";
        int count = 0;
        try {
            ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
        }
        id = "DVT0" + (++count);
        return id;
    }

    public static void add(donViTinh item) {
        String sql = "insert into donvitinh values(?,?,?,?)";
        HELPER.SQLhelper.executeUpdate(sql, item.getIdDonViTinh(), item.getName(), item.getGhiChu(), item.isTrangThai() == true ? 1 : 0);
    }

    public static void remove(String id) {
        String sql = "update donvitinh set trangthai=0 where id=?";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static void reStore(String id) {
        String sql = "update donvitinh set trangthai=1 where id=?";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static void update(donViTinh item) {
        String sql = "update donvitinh set name=?,ghichu=?,trangthai=? where id=?";
        HELPER.SQLhelper.executeUpdate(sql, item.getName(), item.getGhiChu(), item.isTrangThai() == true ? 1 : 0, item.getIdDonViTinh());
    }

    public static donViTinh getDonViTinh(String id) {
        donViTinh item = null;
        String sql = "select * from donvitinh where id = ?";

        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, id);
        try {
            while (rs.next()) {
                item = new donViTinh(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("ghichu"),
                        rs.getInt("trangthai") == 1 ? true : false
                );
            }
        } catch (Exception e) {
        }
        return item;
    }

    public static ArrayList<donViTinh> getAll() {
        ArrayList<donViTinh> data = new ArrayList<>();
        String sql = "select * from donvitinh";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new donViTinh(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("ghichu"),
                        rs.getInt("trangthai") == 1 ? true : false));
            }
        } catch (Exception ex) {
            System.out.println("Loi lay du lieu " + ex.getMessage());
        }
        return data;
    }

    public static void arrayToTable(JTable table) {
        String sql = "select * from donvitinh";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("ghichu"),
                    rs.getInt("trangthai") == 1 ? true : false,});
            }
        } catch (Exception ex) {
            System.out.println("Loi lay du lieu " + ex.getMessage());
        }
        table.setModel(model);
    }
}
