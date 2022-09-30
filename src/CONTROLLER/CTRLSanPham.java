package CONTROLLER;

import CLASS.sanPham;
import MODEL.MDSanPham;
import javax.swing.JOptionPane;
import java.awt.Color;

public class CTRLSanPham {

//    public static void add(sanPham sp) {
//        if (sp.getName() == "") {
//            JOptionPane.showMessageDialog(null, "thông báo lỗi");
//            return;
//        }
//
//        // đủ điều kiện
//        MDSanPham.add(sp);
//        JOptionPane.showMessageDialog(null, "đã thêm thành công");
//    }
//
    public static boolean themNhanhSanPham(String ten, long giaBan, String barcode) {
        boolean check = true;
        if (ten.equals("") || giaBan < 1) {
            JOptionPane.showMessageDialog(null, "Sai thông tin sản phẩm !!!");
            check = false;
        }

        if (check == true) {
            MDSanPham.quickAdd(ten, giaBan, barcode);
        }
        return check;
    }

    public static void checkAddSP(sanPham sp) {
        boolean checkName = false;
        boolean checkGiaNhap = false;
        boolean checkGiaBan = false;
        boolean checkGiaSi = false;
        boolean checkSoLuong = false;
        boolean checkSoLuongToiThieu = false;
        boolean checkIDNCC = false;
        boolean checkIDDVT = false;
        boolean checkLoaiSP = false;
//        boolean checkIDNCC = false;
        if (sp.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Tên không để trống .", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (sp.getGiaBan()<0 &&  sp.getGiaBan() < sp.getGiaNhap() ) {
            JOptionPane.showMessageDialog(null, "Giá nhập không được hơn giá bán và phải lớn hơn 0", " lỗi", 1);

            return;
        } else {
            checkGiaBan = true;
            
        }
        if (sp.getGiaNhap()<0 &&  sp.getGiaBan() < sp.getGiaNhap() ) {
            JOptionPane.showMessageDialog(null, "Giá nhập không được hơn giá bán và phải lớn hơn 0", " lỗi", 1);

            return;
        } else {
            checkGiaBan = true;
            
        }

        if (sp.getIdDonViTinh() == " ") {
            JOptionPane.showMessageDialog(null, " Đơn vị tính không để trống", " lỗi", 1);

            return;
        } else {
            checkIDDVT = true;
        }

        if (sp.getIdLoaiSanPham() == " ") {
            JOptionPane.showMessageDialog(null, " Loại sản phẩm không để trống", " lỗi", 1);

            return;
        } else {
            checkLoaiSP = true;
        }

        if (sp.getIdNhaCungCap() == " ") {
            JOptionPane.showMessageDialog(null, " Nhà cung cấp ko để trống", " lỗi", 1);

            return;
        } else {
            checkIDNCC = true;
        }
        if (sp.getSoLuong() <= 0 && sp.getSoLuong() > sp.getSoLuongToiThieu()) {
            JOptionPane.showMessageDialog(null, " Số lượng không lớn hơn số lượng tối thiểu", " lỗi", 1);

            return;
        } else {
            checkIDDVT = true;
        }
        if (sp.getSoLuongToiThieu() <= 0 && sp.getSoLuongToiThieu() < sp.getSoLuong()) {
            JOptionPane.showMessageDialog(null, " Số lượng tối thiểu ko nhỏ hơn số lượng", " lỗi", 1);

            return;
        } else {
            checkSoLuongToiThieu = true;
        }

        if (checkName == true && checkGiaBan == true && checkGiaNhap == true && checkGiaSi == true
                && checkSoLuong == true && checkSoLuongToiThieu == true && checkLoaiSP == true && checkIDDVT == true
                && checkIDNCC == true) {
            MDSanPham.add(sp);
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } else {
            return;
        }
    }

    public static void checkUpdate(sanPham sp) {
        boolean checkName = false;
        boolean checkGiaNhap = false;
        boolean checkGiaBan = false;
        boolean checkGiaSi = false;
        boolean checkSoLuong = false;
        boolean checkSoLuongToiThieu = false;
        boolean checkIDNCC = false;
        boolean checkIDDVT = false;
        boolean checkLoaiSP = false;
        
        if (sp.getName() == " ") {
            JOptionPane.showMessageDialog(null, " Tên không để trống", " lỗi", 1);
            return;
        } else {
            checkName = true;
        }
        if (sp.getGiaBan()<0 &&  sp.getGiaBan() < sp.getGiaNhap() ) {
            JOptionPane.showMessageDialog(null, "Giá nhập không được hơn giá bán và phải lớn hơn 0", " lỗi", 1);

            return;
        } else {
            checkGiaBan = true;
            
        }
        if (sp.getGiaNhap()<0 &&  sp.getGiaBan() < sp.getGiaNhap() ) {
            JOptionPane.showMessageDialog(null, "Giá nhập không được hơn giá bán và phải lớn hơn 0", " lỗi", 1);

            return;
        } else {
            checkGiaBan = true;
            
        }

      if (sp.getIdDonViTinh() == " ") {
            JOptionPane.showMessageDialog(null, " Đơn vị tính không để trống", " lỗi", 1);

            return;
        } else {
            checkIDDVT = true;
        }

        if (sp.getIdLoaiSanPham() == " ") {
            JOptionPane.showMessageDialog(null, " Loại sản phẩm không để trống", " lỗi", 1);

            return;
        } else {
            checkLoaiSP = true;
        }

        if (sp.getIdNhaCungCap() == " ") {
            JOptionPane.showMessageDialog(null, " Nhà cung cấp không để trống", " lỗi", 1);

            return;
        } else {
            checkIDNCC = true;
        }
        if (sp.getSoLuong() <= 0 && sp.getSoLuong() > sp.getSoLuongToiThieu()) {
            JOptionPane.showMessageDialog(null, " Số lượng không lớn hơn số lượng tối thiểu", " lỗi", 1);

            return;
        } else {
            checkIDDVT = true;
        }
        if (sp.getSoLuongToiThieu() <= 0 && sp.getSoLuongToiThieu() < sp.getSoLuong()) {
            JOptionPane.showMessageDialog(null, " Số lượng tối thiểu không nhỏ hơn số lượng", " lỗi", 1);

            return;
        } else {
            checkSoLuongToiThieu = true;
        }

        if (checkName == true && checkGiaBan == true && checkGiaNhap == true && checkGiaSi == true
                && checkSoLuong == true && checkSoLuongToiThieu == true && checkLoaiSP == true && checkIDDVT == true
                && checkIDNCC == true) {
            MDSanPham.update(sp);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        } else {
            return;
        }

    }

}
