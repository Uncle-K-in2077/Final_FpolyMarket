package CLASS;

public class chiTietHoaDon {

    String idSanPham;
    String tenSanPham;
    String donViTinh;
    int soLuong;
    long donGia;
    long giaSi;
    boolean trangThai;

    public chiTietHoaDon(String idSanPham, String tenSanPham, String donViTinh, int soLuong, long donGia,long giaSi, boolean trangThai) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.giaSi=giaSi;
    }

    public long getGiaSi() {
        return giaSi;
    }

    public void setGiaSi(long giaSi) {
        this.giaSi = giaSi;
    }

    public long getThanhTien() {
        return soLuong * donGia;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
