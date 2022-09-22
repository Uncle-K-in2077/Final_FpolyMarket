
import CLASS.nhanVien;
import MODEL.MDNhanVien;
import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {

////        ArrayList<nhanVien> data = MDNhanVien.getAll();
//        for (nhanVien item : data) {
//            System.out.println(item.getName());
//        }
        ArrayList<nhanVien> data = MDNhanVien.getData();
        for (nhanVien item : data) {
            System.out.println(item.getName());
        }
    }

}
