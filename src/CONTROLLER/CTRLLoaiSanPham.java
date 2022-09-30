/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import CLASS.loaiSanPham;
import MODEL.MDLoaiSanPham;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CTRLLoaiSanPham {

    public static void checkAdd(loaiSanPham item) {
        boolean checkName = false;
        if (item.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập loại sản phẩm  ", " lỗi", 1);
            return;
        } else {
            checkName = true;
            MDLoaiSanPham.add(item);
            JOptionPane.showMessageDialog(null, "Thêm thành công .");

        }
    }
    
    public static void checkUpdate(loaiSanPham item) {
        boolean checkName = false;
        if (item.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập loại sản phẩm  ", " lỗi", 1);
            return;
        } else {
            checkName = true;
            MDLoaiSanPham.update(item);
            JOptionPane.showMessageDialog(null, "Cập nhật  thành công .");

        }
    }
}
