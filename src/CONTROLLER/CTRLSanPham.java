package CONTROLLER;

import CLASS.sanPham;
import MODEL.MDSanPham;
import javax.swing.JOptionPane;

public class CTRLSanPham {

    public static void add(sanPham sp) {
        if (sp.getName() == "") {
            JOptionPane.showMessageDialog(null, "thông báo lỗi");
            return;
        }

        // đủ điều kiện
        MDSanPham.add(sp);
        JOptionPane.showMessageDialog(null, "đã thêm thành công");
    }

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
}
