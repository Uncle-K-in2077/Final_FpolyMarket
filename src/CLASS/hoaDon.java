/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASS;

public class hoaDon {

    String idNhanVien;
    String idKhachHang;
    int hinhThucThanhToan;
    long giamGia;
    long tongTienThanhToan;
    String ghiChu;
    boolean trangThai;

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public long getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(long giamGia) {
        this.giamGia = giamGia;
    }

    public long getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(long tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public hoaDon() {
    }

    public hoaDon(String idNhanVien, String idKhachHang, int hinhThucThanhToan, long giamGia, long tongTienThanhToan, String ghiChu, boolean trangThai) {
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.giamGia = giamGia;
        this.tongTienThanhToan = tongTienThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

}
