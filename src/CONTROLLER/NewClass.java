/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import CLASS.Account;
import MODEL.MDAccount;

/**
 *
 * @author DELL
 */
public class NewClass {

    public static void checkAccount(Account acc) {
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
        } else {
            if (checkuser == false) {
                // thông báo cú pháp username sai
                return;
            }
            if (checkpass == false) {
                // thông báo cú pháp pass  sai
                return;
            }
        }
    }
    public static void checkUpdate(Account acc){
         
    }
}
