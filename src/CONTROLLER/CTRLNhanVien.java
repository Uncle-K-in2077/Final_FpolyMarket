/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import CLASS.nhanVien;
import MODEL.MDNhanVien;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CTRLNhanVien {

    public static void checkAdd(nhanVien nhanvien) {
        boolean checkIdNhanVien = false;
        boolean checkName = false;
        boolean checkSoDienThoai = false;
        boolean checkDiaChi = false;
        boolean checkLuong = false;

        if (nhanvien.getIdNhanVien() == " ") {
            JOptionPane.showMessageDialog(null, " Mã nhân viên không để trống", " lỗi", 1);
            return;
        } else {
            checkIdNhanVien = true;
        }

        if (nhanvien.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập tên nhà cung cấp !", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (HELPER.helper.isNumberPhone(nhanvien.getSoDienthoai()) == true && nhanvien.getSoDienthoai() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập số điện thoại", " lỗi", 1);
            return;
        } else {
            checkSoDienThoai = true;
        }
        if (nhanvien.getDiaChi() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập thông tin địa chỉ !", " lỗi", 1);
            return;
        } else {
            checkDiaChi = true;
        }
        if (nhanvien.getLuong() <= 0) {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập lương nhân viên !", " lỗi", 1);
            return;
        } else {
            checkLuong = true;
        }
        if (checkIdNhanVien == false || checkName == false
                || checkDiaChi == false || checkSoDienThoai == false || checkLuong == false) {
            return;
        } else {
            MDNhanVien.add(nhanvien);
            JOptionPane.showMessageDialog(null, "Thêm thành  thành công");

        }
    }

    public static void checkUpdate(nhanVien nhanvien) {
        boolean checkIdNhanVien = false;
        boolean checkName = false;
        boolean checkSoDienThoai = false;
        boolean checkDiaChi = false;
        boolean checkLuong = false;

        if (nhanvien.getIdNhanVien() == " ") {
            JOptionPane.showMessageDialog(null, " Mã nhân viên không để trống", " lỗi", 1);
            return;
        } else {
            checkIdNhanVien = true;
        }

        if (nhanvien.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập tên nhà cung cấp !", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (HELPER.helper.isNumberPhone(nhanvien.getSoDienthoai()) == true && nhanvien.getSoDienthoai() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập số điện thoại", " lỗi", 1);
            return;
        } else {
            checkSoDienThoai = true;
        }
        if (nhanvien.getDiaChi() == " ") {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập thông tin địa chỉ !", " lỗi", 1);
            return;
        } else {
            checkDiaChi = true;
        }
        if (nhanvien.getLuong() <= 0) {
            JOptionPane.showMessageDialog(null, " Vui lòng nhập lương nhân viên !", " lỗi", 1);
            return;
        } else {
            checkLuong = true;
        }
        if (checkIdNhanVien == false || checkName == false
                || checkDiaChi == false || checkSoDienThoai == false || checkLuong == false) {
            return;
        } else {
            MDNhanVien.update(nhanvien);
            JOptionPane.showMessageDialog(null, "Cập nhật thành  thành công");

        }
    }
}
