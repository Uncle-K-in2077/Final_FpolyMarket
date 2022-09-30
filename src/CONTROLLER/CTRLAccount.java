package CONTROLLER;

import CLASS.Account;
import MODEL.MDAccount;
import javax.swing.JOptionPane;

public class CTRLAccount {

    public static void checkAddAccount(Account acc) {
        boolean checkuser = false;
        boolean checkpass = false;
        if (HELPER.helper.isUsername(acc.getUsername()) == true) {
            //username đúng
            checkuser = true;
        }
        if (HELPER.helper.isUsername(acc.getPassword()) == true) {
            // đúng 
            checkpass = true;
        }

        if (checkpass == true && checkuser == true) {
            MDAccount.add(acc);
            // thông báo thành công
            JOptionPane.showMessageDialog(null, "Tạo thành công");
        } else {
            if (checkuser == false) {
                // thông báo cú pháp username sai
                JOptionPane.showMessageDialog(null, "Tên đăng nhập sai cú pháp !");
                return;
            }
            if (checkpass == false) {
                // thông báo cú pháp pass  sai
                JOptionPane.showMessageDialog(null, "Mật khẩu sai cú pháp, cần 1 ký tự đặc biệt và 1 chữ cái viết hoa.");

                return;
            }
        }
    }

    public static void checkUpdate(Account acc) {
        boolean checkuser = false;
        boolean checkpass = false;
        if (HELPER.helper.isUsername(acc.getUsername()) == true) {
            //username đúng
            checkuser = true;
        }
        if (HELPER.helper.isUsername(acc.getPassword()) == true) {
            // đúng 
            checkpass = true;
        }

        if (checkpass == true && checkuser == true) {
            MDAccount.updateAccount(acc);
            // thông báo thành công
            JOptionPane.showMessageDialog(null, "Cập nhật  thành công");
        } else {
            if (checkuser == false) {
                // thông báo cú pháp username sai
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai vui lòng nhập lại");
                return;
            }
            if (checkpass == false) {
                // thông báo cú pháp pass  sai
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai vui lòng nhập lại");

                return;
            }
        }

    }
}
