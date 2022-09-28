/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import CLASS.khachHang;
import MODEL.MDKhachHang;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CTRLKhachHang {

    public static void checkAdd(khachHang kh) {
        boolean checkIdKhachHang = false;
        boolean checkName = false;
        boolean checkSoDienThoai = false;
        boolean checkDiaChi = false;

        if (kh.getIdKhachHang() == " ") {
            JOptionPane.showMessageDialog(null, " Mã Khách hàng không để trống", " lỗi", 1);
            return;
        } else {
            checkIdKhachHang = true;
        }

        if (HELPER.helper.isFullname(kh.getName()) == true && kh.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập đầy đủ họ tên !", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (HELPER.helper.isNumberPhone(kh.getSoDienThoai()) == true && kh.getSoDienThoai() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập số điện thoại", " lỗi", 1);
            return;
        } else {
            checkSoDienThoai = true;
        }
        if (kh.getDiaChi() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập thông tin địa chỉ !", " lỗi", 1);
            return;
        } else {
            checkDiaChi = true;
        }

        if (checkIdKhachHang == false || checkName == false
                || checkDiaChi == false || checkSoDienThoai == false) {
            return;
        } else {
            MDKhachHang.add(kh);
            JOptionPane.showMessageDialog(null, "Thêm thành  thành công");

        }
    }

    public static void checkUpdate(khachHang kh) {
        boolean checkIdKhachHang = false;
        boolean checkName = false;
        boolean checkSoDienThoai = false;
        boolean checkDiaChi = false;

        if (kh.getIdKhachHang() == " ") {
            JOptionPane.showMessageDialog(null, " Mã Khách hàng không để trống", " lỗi", 1);
            return;
        } else {
            checkIdKhachHang = true;
        }

        if (HELPER.helper.isFullname(kh.getName()) == true && kh.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập đầy đủ họ tên !", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (HELPER.helper.isNumberPhone(kh.getSoDienThoai()) == true && kh.getSoDienThoai() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập số điện thoại", " lỗi", 1);
            return;
        } else {
            checkSoDienThoai = true;
        }
        if (kh.getDiaChi() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập thông tin địa chỉ !", " lỗi", 1);
            return;
        } else {
            checkDiaChi = true;
        }

        if (checkIdKhachHang == false || checkName == false
                || checkDiaChi == false || checkSoDienThoai == false) {
            return;
        } else {
            MDKhachHang.update(kh);
            JOptionPane.showMessageDialog(null, "Cập nhật  thành công");

        }
    }
}
