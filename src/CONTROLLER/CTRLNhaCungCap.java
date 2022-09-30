/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import CLASS.nhaCungCap;
import MODEL.MDNhaCungCap;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CTRLNhaCungCap {
   public static void checkAdd(nhaCungCap ncc) {
        boolean checkIdNhaCungCap = false;
        boolean checkName = false;
        boolean checkSoDienThoai = false;
        boolean checkDiaChi = false;

        if (ncc.getIdNhaCungCap()== " ") {
            JOptionPane.showMessageDialog(null, " Mã nhà cung cấp không để trống", " lỗi", 1);
            return;
        } else {
            checkIdNhaCungCap = true;
        }

        if ( ncc.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập tên nhà cung cấp !", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (HELPER.helper.isNumberPhone(ncc.getSoDienThoai()) == true && ncc.getSoDienThoai() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập số điện thoại", " lỗi", 1);
            return;
        } else {
            checkSoDienThoai = true;
        }
        if (ncc.getDiaChi() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập thông tin địa chỉ !", " lỗi", 1);
            return;
        } else {
            checkDiaChi = true;
        }

        if (checkIdNhaCungCap == false || checkName == false
                || checkDiaChi == false || checkSoDienThoai == false) {
            return;
        } else {
            MDNhaCungCap.add(ncc);
            JOptionPane.showMessageDialog(null, "Thêm thành  thành công");

        }
    }

   public static void checkUpdate(nhaCungCap ncc) {
        boolean checkIdNhaCungCap = false;
        boolean checkName = false;
        boolean checkSoDienThoai = false;
        boolean checkDiaChi = false;

        if (ncc.getIdNhaCungCap()== " ") {
            JOptionPane.showMessageDialog(null, " Mã nhà cung cấp không để trống", " lỗi", 1);
            return;
        } else {
            checkIdNhaCungCap = true;
        }

        if ( ncc.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập tên nhà cung cấp !", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (HELPER.helper.isNumberPhone(ncc.getSoDienThoai()) == true && ncc.getSoDienThoai() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập số điện thoại", " lỗi", 1);
            return;
        } else {
            checkSoDienThoai = true;
        }
        if (ncc.getDiaChi() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập thông tin địa chỉ !", " lỗi", 1);
            return;
        } else {
            checkDiaChi = true;
        }

        if (checkIdNhaCungCap == false || checkName == false
                || checkDiaChi == false || checkSoDienThoai == false) {
            return;
        } else {
            MDNhaCungCap.update(ncc);
            JOptionPane.showMessageDialog(null, "Cập nhật thành  thành công");

        }
    }
}
