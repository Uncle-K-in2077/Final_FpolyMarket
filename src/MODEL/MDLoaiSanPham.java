/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import CLASS.loaiSanPham;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class MDLoaiSanPham {

    public static String createId() {
        String id = "";
        String sql = "select count(id) as 'count' from loaisanpham";
        int count = 0;
        try {
            ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
        }
        id = "LSP0" + (++count);
        return id;
    }

    public static ArrayList<String> getNames() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "select name from loaisanpham";
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(rs.getString("name"));
            }
        } catch (Exception e) {
        }
        return data;
    }

    public static ArrayList<loaiSanPham> getAll() {
        ArrayList<loaiSanPham> data = new ArrayList<>();
        String sql = "select * from loaisanpham ";

        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                data.add(new loaiSanPham(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("ghichu"),
                        rs.getInt("trangthai") == 1 ? true : false
                ));
            }
        } catch (Exception e) {
        }
        return data;
    }

    public static void add(loaiSanPham item) {
        String sql = "insert into loaisanpham values(?,?,?,?)";
        HELPER.SQLhelper.executeUpdate(sql, item.getIdLoaiSanPham(), item.getName(), item.getGhiChu(), item.isTrangThai() == true ? 1 : 0);
    }

    public static void remove(String id) {
        String sql = "update loaisanpham set trangthai=0 where id=?";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static void reStore(String id) {
        String sql = "update loaisanpham set trangthai=1 where id=?";
        HELPER.SQLhelper.executeUpdate(sql, id);
    }

    public static void update(loaiSanPham item) {
        String sql = "update loaisanpham set name=?,ghichu=?,trangthai=? where id=?";
        HELPER.SQLhelper.executeUpdate(sql, item.getName(), item.getGhiChu(), item.isTrangThai() == true ? 1 : 0, item.getIdLoaiSanPham());
    }

    public static loaiSanPham getLoaiSanPham(String id) {
        loaiSanPham item = null;
        String sql = "select * from loaisanpham where id = ?";

        ResultSet rs = HELPER.SQLhelper.executeQuery(sql, id);
        try {
            while (rs.next()) {
                item = new loaiSanPham(
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

    public static void arrayToTable(JTable table) {
        String sql = "select * from loaisanpham";
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
