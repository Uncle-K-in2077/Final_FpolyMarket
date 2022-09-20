/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HELPER;

import CLASS.config;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightContrastIJTheme;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class helper {

    public static void setConfig(config item) {
        try {
            FileOutputStream fo = new FileOutputStream("src/TEXT/config.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(item);
            fo.close();
            oos.close();
        } catch (Exception e) {
        }
    }

    public static void setTextFieldMoney(JTextField txt) {
        String txtGiaBan = txt.getText();
        long tienLuong = SoLong(txtGiaBan);
        txt.setText(SoString(tienLuong));
    }

    public static config getConfig() {
        config item = null;
        Object obj = null;
        try {
            FileInputStream fi = new FileInputStream("src/TEXT/config.txt");

            ObjectInputStream ois = new ObjectInputStream(fi);
            obj = ois.readObject();
            fi.close();
            ois.close();
        } catch (Exception e) {
        }
        item = (config) obj;
        return item;
    }

    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static void setTableTextCenter(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount() - 1; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public static void setTableTextCenterFullColumn(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public static String LayNgayString(Date date, String Format) {
        DateFormat dateFormat = new SimpleDateFormat(Format);
        return dateFormat.format(date);
    }

    //Hàm chuyển String -> Date
    public static Date LayNgayDate(String ngay, String Format) {
        DateFormat dateFormat = new SimpleDateFormat(Format);
        try {
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển ngày");
            return null;
        }
    }

    //Chuyển đổi số Double <-> String 10.000.000
    //Hàm chuyển Double -> String
    public static String LongToString(double so) {
        return NumberFormat.getNumberInstance().format(so);
    }

    //Hàm chuyển String -> Double
    public static double StringToLong(String so) {
        try {
            return NumberFormat.getNumberInstance().parse(so).doubleValue();
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển số");
            return 0;
        }
    }

    public static String SoString(long so) {
        return NumberFormat.getNumberInstance().format(so);
    }

    //Hàm chuyển String -> Double
    public static long SoLong(String so) {
        try {
            return NumberFormat.getNumberInstance().parse(so).longValue();
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển số");
            return 0;
        }
    }

    public static void updateTheme(int num) {
        config config = helper.getConfig();
        config.setTheme(num);
        helper.setConfig(config);

        JOptionPane.showMessageDialog(null, "Khởi động lại phần mềm để áp dụng giao diện mới");
    }

    public static void setupTheme(int userTheme) {
        switch (userTheme) {
            case 1:
                FlatLightLaf.setup();
                break;
            case 2:
                FlatHighContrastIJTheme.setup();
                break;

            case 3:
                FlatCarbonIJTheme.setup();
                break;
            case 4:
                FlatMonokaiProContrastIJTheme.setup();
                break;
            case 5:
                FlatArcDarkContrastIJTheme.setup();
                break;
            case 6:
                FlatSolarizedLightContrastIJTheme.setup();
                break;
            case 7:
                FlatArcOrangeIJTheme.setup();
                break;
            case 8:
                FlatMaterialOceanicContrastIJTheme.setup();
                break;
            case 9:
                FlatMaterialPalenightContrastIJTheme.setup();//
                break;
            case 10:
                FlatGitHubContrastIJTheme.setup();
                break;
            case 11:
                FlatAtomOneLightIJTheme.setup();//
                break;
            default:
                FlatLightLaf.setup();
                break;
        }

        UIManager.put("PasswordField.showRevealButton", true);
        UIManager.put("PasswordField.showCapsLock", true);
    }

    public static void showClearButton(JTextField txt) {
        txt.putClientProperty("JTextField.showClearButton", true);
        txt.putClientProperty("JTextField.clearCallback",
                (Runnable) () -> {
                    txt.setText("");
                });
    }

    public static void addIconSearch(JTextField txt) {
        Icon icon = new ImageIcon("src/ICON/search.png");
        txt.putClientProperty("JTextField.leadingIcon", icon);
        txt.putClientProperty("JTextField.showClearButton", true);
        txt.putClientProperty("JTextField.clearCallback",
                (Runnable) () -> {
                    txt.setText("");
                });
    }
}
