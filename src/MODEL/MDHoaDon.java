package MODEL;

import CLASS.hoaDon;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JTable;

public class MDHoaDon {

    public static String craeteID() {
        String id = "HD";
        String date = HELPER.helper.LayNgayString(new Date(), "yyyyMMdd");
        String sql = "select count(id) as 'count' from hoadon";
        int count = 0;
        ResultSet rs = HELPER.SQLhelper.executeQuery(sql);
        try {
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
        }

        return id + date + (++count);
    }

    public static void taoHoaDon(hoaDon hoadon, JTable tableGioHang) {
        // tạo hóa đơn : 
        
    }
}
