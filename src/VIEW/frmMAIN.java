package VIEW;

import CLASS.Account;
import CLASS.donViTinh;
import CLASS.khachHang;
import CLASS.loaiSanPham;
import CLASS.nhaCungCap;
import CLASS.nhanVien;
import CLASS.sanPham;
import HELPER.helper;
import MODEL.MDAccount;
import MODEL.MDCongNo;
import MODEL.MDDonViTinh;
import MODEL.MDKhachHang;
import MODEL.MDLoaiSanPham;
import MODEL.MDNhaCungCap;
import MODEL.MDNhanVien;
import MODEL.MDSanPham;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.IntConsumer;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmMAIN extends javax.swing.JFrame {

    public static Account acc;

    public frmMAIN(Account acount) {
        this.acc = acount;
        initComponents();
        // set Title cho phần mềm
        this.setTitle("FPOLY Market");

        // set logo Favicon
        ImageIcon img = new ImageIcon("src/ICON/favicon.jpg");
        this.setIconImage(img.getImage());

        // hiện nút close tabbed
        this.tabbed.putClientProperty("JTabbedPane.tabClosable", true);

        // hàm tắt tabbed
        showIconCloseTab();

        // set rộng bằng màn hình
        this.setExtendedState(this.MAXIMIZED_BOTH);

        // mở bảng thông kê ( home )
        panelMain.add(new PanelThongKeTongHop(acc));

        // thêm icon và nút clear vào các textField tìm kiếm
        setSearchTextField();

        //setup table sản phẩm
        setModelTableSanPham();

        //Load table các danh mục đối tượng
        loadTableAccount();
        loadTableKhachHang();
        loadTableNhaCungCap();
        loadTableNhanVien();
        loadTableDonViTinh();
        loadTableLoaiSanPham();
        loadTableSanPham();
        loadTableThuNoKhachHang();
        // thiết lập phân quyền theo account
        setModuleForAccount();

        // set table text center
        setTableTextCenter();
        addKeyEsc();
    }

    public void loadTableThuNoKhachHang() {
        MDCongNo.dataTableThuNoKhachHang(tableThuNoKhachHang);
    }

    public void addKeyEsc() {
        InputMap inputMap = tabbed.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "VK_ESCAPE");
        tabbed.getActionMap().put("VK_ESCAPE", new AbstractAction() {
            public void actionPerformed(ActionEvent evt) {
                if (tabbed.getTabCount() > 0) {
                    tabbed.remove(tabbed.getSelectedIndex());
                    if (tabbed.getTabCount() == 0) {
                        panelMain.removeAll();
                        panelMain.add(new PanelThongKeTongHop(acc));
                    }
                }
            }
        });
    }

    public void showIconCloseTab() {
        tabbed.putClientProperty("JTabbedPane.tabCloseCallback",
                (IntConsumer) tabIndex -> {
                    this.tabbed.remove(tabIndex);
                    if (tabbed.getTabCount() == 0) {
                        panelMain.removeAll();
                        panelMain.add(new PanelThongKeTongHop(acc));
                    }
                });
    }

    public void loadTableLoaiSanPham() {
        ArrayList<loaiSanPham> data = MDLoaiSanPham.getAll();
        DefaultTableModel model = (DefaultTableModel) tableLoaiSanPham.getModel();
        model.setRowCount(0);
        for (loaiSanPham item : data) {
            model.addRow(new Object[]{
                item.getIdLoaiSanPham(),
                item.getName(),
                item.getGhiChu(),
                item.isTrangThai()
            });
        }
        tableLoaiSanPham.setModel(model);
    }

    public void loadTableDonViTinh() {
        ArrayList<donViTinh> data = MDDonViTinh.getAll();
        DefaultTableModel model = (DefaultTableModel) tableDonViTinh.getModel();
        model.setRowCount(0);
        for (donViTinh item : data) {
            model.addRow(new Object[]{
                item.getIdDonViTinh(),
                item.getName(),
                item.getGhiChu(),
                item.isTrangThai()
            });
        }
        tableDonViTinh.setModel(model);
    }

    public void loadTableNhanVien() {
        ArrayList<nhanVien> data = MDNhanVien.getDataToTable();
        DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
        model.setRowCount(0);
        for (nhanVien item : data) {
            model.addRow(new Object[]{
                item.getIdNhanVien(),
                item.getName(),
                item.isGioiTinh() == true ? "Nam" : "Nữ",
                item.getDiaChi(),
                item.getSoDienthoai(),
                item.getNgaySinh(),
                helper.LongToString(item.getLuong()),
                item.getNgayVaoLam(),
                item.getGhiChu(),
                item.isTrangThai()
            });
        }
        tableNhanVien.setModel(model);
    }

    public void loadTableNhanVien(ArrayList<nhanVien> data) {
        DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
        model.setRowCount(0);
        for (nhanVien item : data) {
            model.addRow(new Object[]{
                item.getIdNhanVien(),
                item.getName(),
                item.isGioiTinh() == true ? "Nam" : "Nữ",
                item.getDiaChi(),
                item.getSoDienthoai(),
                item.getNgaySinh(),
                helper.LongToString(item.getLuong()),
                item.getNgayVaoLam(),
                item.getGhiChu(),
                item.isTrangThai()
            });
        }
        tableNhanVien.setModel(model);
    }

    public void loadTableNhaCungCap() {
        ArrayList<nhaCungCap> data = MDNhaCungCap.getAll();
        DefaultTableModel model = (DefaultTableModel) tableNhaCungCap.getModel();
        model.setRowCount(0);
        for (nhaCungCap item : data) {
            model.addRow(new Object[]{
                item.getIdNhaCungCap(),
                item.getName(),
                item.getDiaChi(),
                item.getSoDienThoai(),
                item.getGhiChu(),
                helper.LongToString(item.getCongNo()),
                item.isTrangThai()
            });
        }
        tableNhaCungCap.setModel(model);
    }

    public void loadTableKhachHang() {
        ArrayList<khachHang> data = MDKhachHang.getDataToTable();
        DefaultTableModel model = (DefaultTableModel) tableKhachHang.getModel();
        model.setRowCount(0);
        for (khachHang item : data) {
            model.addRow(new Object[]{
                item.getIdKhachHang(),
                item.getName(),
                item.getDiaChi(),
                item.getSoDienThoai(),
                item.getGhiChu(),
                helper.LongToString(item.getNo()),
                item.isTrangThai()
            });
        }
        tableKhachHang.setModel(model);
    }

    public void loadTableSanPham() {
        ArrayList<sanPham> data = MDSanPham.getDataToTable();
        DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        String path = "src/IMAGE/";
        for (sanPham item : data) {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(path + item.getHinhAnh()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            model.addRow(new Object[]{
                imageIcon,
                item.getIdSanPham(),
                item.getName(),
                item.getBarcode(),
                item.getIdDonViTinh(),
                item.getIdLoaiSanPham(),
                helper.LongToString(item.getGiaNhap()),
                helper.LongToString(item.getGiaBan()),
                item.getSoLuong(),
                item.getSoLuongToiThieu(),
                item.getGhiChu(),
                item.isTrangThai()

            });
        }
        tableSanPham.setModel(model);
    }

    public void loadTableAccount() {
        ArrayList<Account> data = MDAccount.getDataToTable();
        DefaultTableModel model = (DefaultTableModel) tableTaiKhoan.getModel();
        model.setRowCount(0);
        for (Account item : data) {
            model.addRow(new Object[]{
                item.getUsername(),
                item.getPassword(),
                item.getPassword(),
                item.isTrangThai(),
                item.isBanHang(),
                item.isNhapHang(),
                item.isTaiKhoan(),
                item.isHangHoa(),
                item.isNhanVien(),
                item.isKhachHang(),
                item.isNhaCungCap(),
                item.isPhieuChi(),
                item.isBaoCao()
            });
        }
        tableTaiKhoan.setModel(model);
    }

    public void setTableTextCenter() {
        // set table text center
        HELPER.helper.setTableTextCenter(tableNhaCungCap);
        HELPER.helper.setTableTextCenter(tableNhanVien);
        HELPER.helper.setTableTextCenter(tableDonViTinh);
        HELPER.helper.setTableTextCenter(tableKhachHang);
        HELPER.helper.setTableTextCenter(tableDanhSachHoaDonBanHang);
        HELPER.helper.setTableTextCenter(tableChiTietHoaDonBanHang);
        HELPER.helper.setTableTextCenter(tableLoaiSanPham);
        HELPER.helper.setTableTextCenterFullColumn(tableThuNoKhachHang);
        // set table text center table tài khoản
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 3; i++) {
            tableTaiKhoan.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void setModuleForAccount() {
        //bán hàng
        btnDanhSachHoaDonBanHang.setVisible(acc.isBanHang());
        btnTaoHoaDonBanHang.setVisible(acc.isBanHang());
        menuDanhSachHoaDonBanHang.setVisible(acc.isBanHang());
        menuTaoHoaDonBanHang.setVisible(acc.isBanHang());

        //nhập hàng
        btnNhapHang.setVisible(acc.isNhapHang());
        menuNhapHang.setVisible(acc.isNhapHang());
        menuNhatKyNhapHang.setVisible(acc.isNhapHang());
        btnThemSanPham.setVisible(acc.isNhapHang());

        //quản lý các tài khoản
        menuQuanLyTaiKhoan.setVisible(acc.isTaiKhoan());

        // quản lý hàng hóa
        btnNhapHang.setVisible(acc.isNhapHang());
        menuNhapHang.setVisible(acc.isNhapHang());
        menuNhatKyNhapHang.setVisible(acc.isNhapHang());
        btnThemSanPham.setVisible(acc.isNhapHang());

        //quản lý nhân viên
        menuQuanLyNhanVien.setVisible(acc.isNhanVien());

        //quản lý nhà cung cấp
        menuQuanLyNhaCungCap.setVisible(acc.isNhaCungCap());

        //quản lý khách hàng
        menuQuanLyKhachHang.setVisible(acc.isKhachHang());

        //báo cáo
        menubarBaoCao.setVisible(acc.isBaoCao());

        //phiếu chi
        menuTaoPhieuChi.setVisible(acc.isPhieuChi());
        menuDanhSachPhieuChi.setVisible(acc.isPhieuChi());
        btnTaoPhieuChi.setVisible(acc.isPhieuChi());

    }

    public void setModelTableSanPham() {

        String[] column = {"Hình ảnh", "Mã", "Sản phẩm", "Mã vạch", "Đơn vị tính", "Nhóm hàng", "Giá nhập", "Giá bán", "Tồn kho", "Số lượng tối thiểu", "Ghi chú", "Còn sử dụng?"};
        Object[][] rows = {};
        DefaultTableModel model = new DefaultTableModel(rows, column) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return ImageIcon.class;

                    case 11:
                        return Boolean.class;
                    default:
                        return Object.class;
                }
            }

            public boolean isCellEditable(int rowIndex,
                    int columnIndex) {
                return false;
            }
        };
        tableSanPham.setModel(model);
        tableSanPham.setRowHeight(120);
        tableSanPham.setRowMargin(7);

        tableSanPham.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tableSanPham.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);

        tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(70);
        tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(150);
        tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(60);
        tableSanPham.getColumnModel().getColumn(10).setPreferredWidth(110);
        tableSanPham.getColumnModel().getColumn(11).setPreferredWidth(90);
        tableSanPham.getColumnModel().getColumn(8).setPreferredWidth(60);
    }

    public void setSearchTextField() {
        helper.addIconSearch(txtTimKiemHoaDonBanHang);
        helper.addIconSearch(txtTimKiemKhachHang);
        helper.addIconSearch(txtTimKiemNhaCungCap);
        helper.addIconSearch(txtTimKiemNhanVien);
        helper.addIconSearch(txtTimKiemSanPham);
        helper.addIconSearch(txtTimKiemTaiKhoan);
        helper.addIconSearch(txtTimKiemThuNoKhachHang);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbed = new javax.swing.JTabbedPane();
        panelDanhSachHoaDonBanHang = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemHoaDonBanHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDanhSachHoaDonBanHang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChiTietHoaDonBanHang = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        panelQuanLyNhanVien = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiemNhanVien = new javax.swing.JTextField();
        btnTimKiemNhanVien = new javax.swing.JButton();
        btnThemNhanVien = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        panelQuanLyKhachHang = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiemKhachHang = new javax.swing.JTextField();
        btnTimKiemKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableKhachHang = new javax.swing.JTable();
        panelQuanLyNhaCungCap = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiemNhaCungCap = new javax.swing.JTextField();
        btnTimKiemNhaCungCap = new javax.swing.JButton();
        btnThemNhaCungCap = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableNhaCungCap = new javax.swing.JTable();
        panelQuanLyTaiKhoan = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableTaiKhoan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiemTaiKhoan = new javax.swing.JTextField();
        btnTimKiemTaiKhoan = new javax.swing.JButton();
        btnThemNhaCungCap1 = new javax.swing.JButton();
        panelQuanLyHangHoa = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiemSanPham = new javax.swing.JTextField();
        btnReloadTableSanPham = new javax.swing.JButton();
        btnThemSanPham = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        comboBoxNhomHang = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        btnXoaSanPham1 = new javax.swing.JButton();
        btnXoaSanPham2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableDonViTinh = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableLoaiSanPham = new javax.swing.JTable();
        popupTableNhanVien = new javax.swing.JPopupMenu();
        menuSuaNhanVien = new javax.swing.JMenuItem();
        menuXoaNhanVien = new javax.swing.JMenuItem();
        panelDanhSachPhieuThuNoKhachHang = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableThuNoKhachHang = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        txtTimKiemThuNoKhachHang = new javax.swing.JTextField();
        btnTimKiemNhanVien1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbFilterThuNo = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        btnTaoHoaDonBanHang = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnDanhSachHoaDonBanHang = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnTaoPhieuThu = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnTaoPhieuChi = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnNhapHang = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuQuanLyHangHoa = new javax.swing.JMenuItem();
        menuQuanLyNhanVien = new javax.swing.JMenuItem();
        menuQuanLyKhachHang = new javax.swing.JMenuItem();
        menuQuanLyNhaCungCap = new javax.swing.JMenuItem();
        menuQuanLyTaiKhoan = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        menuTaoPhieuChi = new javax.swing.JMenuItem();
        menuDanhSachPhieuChi = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuNhapHang = new javax.swing.JMenuItem();
        menuNhatKyNhapHang = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuTaoHoaDonBanHang = new javax.swing.JMenuItem();
        menuDanhSachHoaDonBanHang = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        menubarBaoCao = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();

        tabbed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabbed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabbedKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("TÌM HÓA ĐƠN :");

        txtTimKiemHoaDonBanHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiemHoaDonBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemHoaDonBanHangActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("TỪ NGÀY :");

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setDate(new Date());
        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jDateChooser1.setVerifyInputWhenFocusTarget(false);

        jDateChooser2.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setDate(new Date());
        jDateChooser2.setDateFormatString("dd-MM-yyyy");
        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jDateChooser2.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ĐẾN NGÀY :");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/check-hoa-don.png"))); // NOI18N
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTimKiemHoaDonBanHang))
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtTimKiemHoaDonBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("DANH SÁCH HÓA ĐƠN BÁN HÀNG");

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tableDanhSachHoaDonBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Khách hàng", "Nhân viên", "Giảm giá", "Tổng tiền", "Hình thức", "Thời gian", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDanhSachHoaDonBanHang.setRowHeight(35);
        tableDanhSachHoaDonBanHang.setRowMargin(3);
        tableDanhSachHoaDonBanHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableDanhSachHoaDonBanHangFocusLost(evt);
            }
        });
        tableDanhSachHoaDonBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDanhSachHoaDonBanHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableDanhSachHoaDonBanHangMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableDanhSachHoaDonBanHang);

        tableChiTietHoaDonBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sản phẩm", "Số lượng", "ĐVT", "Giá bán", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableChiTietHoaDonBanHang.setRowHeight(35);
        tableChiTietHoaDonBanHang.setRowMargin(3);
        tableChiTietHoaDonBanHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableChiTietHoaDonBanHangFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(tableChiTietHoaDonBanHang);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("CHI TIẾT HÓA ĐƠN");

        javax.swing.GroupLayout panelDanhSachHoaDonBanHangLayout = new javax.swing.GroupLayout(panelDanhSachHoaDonBanHang);
        panelDanhSachHoaDonBanHang.setLayout(panelDanhSachHoaDonBanHangLayout);
        panelDanhSachHoaDonBanHangLayout.setHorizontalGroup(
            panelDanhSachHoaDonBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelDanhSachHoaDonBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDanhSachHoaDonBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDanhSachHoaDonBanHangLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDanhSachHoaDonBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelDanhSachHoaDonBanHangLayout.setVerticalGroup(
            panelDanhSachHoaDonBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDanhSachHoaDonBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDanhSachHoaDonBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDanhSachHoaDonBanHangLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
                    .addGroup(panelDanhSachHoaDonBanHangLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelDanhSachHoaDonBanHangLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jSeparator11)
                .addGap(6, 6, 6))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Tìm nhân viên :");

        txtTimKiemNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemNhanVienKeyReleased(evt);
            }
        });

        btnTimKiemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reload.png"))); // NOI18N
        btnTimKiemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNhanVienActionPerformed(evt);
            }
        });

        btnThemNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNhanVien.setForeground(new java.awt.Color(0, 153, 255));
        btnThemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/add-user.png"))); // NOI18N
        btnThemNhanVien.setText("Thêm");
        btnThemNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemNhanVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnThemNhanVien)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(690, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemNhanVien)
                    .addComponent(btnThemNhanVien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Địa chỉ", "Số điện thoại", "Ngày sinh", "Lương cơ bản", "Ngày vào làm", "Ghi chú", "Đang làm việc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNhanVien.setComponentPopupMenu(popupTableNhanVien);
        tableNhanVien.setRowHeight(35);
        tableNhanVien.setRowMargin(3);
        tableNhanVien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableNhanVienFocusLost(evt);
            }
        });
        tableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableNhanVienMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tableNhanVien);
        if (tableNhanVien.getColumnModel().getColumnCount() > 0) {
            tableNhanVien.getColumnModel().getColumn(0).setMaxWidth(120);
            tableNhanVien.getColumnModel().getColumn(1).setMinWidth(150);
            tableNhanVien.getColumnModel().getColumn(2).setMaxWidth(80);
            tableNhanVien.getColumnModel().getColumn(3).setMinWidth(150);
            tableNhanVien.getColumnModel().getColumn(4).setMinWidth(120);
            tableNhanVien.getColumnModel().getColumn(4).setMaxWidth(120);
            tableNhanVien.getColumnModel().getColumn(9).setMinWidth(90);
            tableNhanVien.getColumnModel().getColumn(9).setMaxWidth(90);
        }

        javax.swing.GroupLayout panelQuanLyNhanVienLayout = new javax.swing.GroupLayout(panelQuanLyNhanVien);
        panelQuanLyNhanVien.setLayout(panelQuanLyNhanVienLayout);
        panelQuanLyNhanVienLayout.setHorizontalGroup(
            panelQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelQuanLyNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        panelQuanLyNhanVienLayout.setVerticalGroup(
            panelQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Tìm khách hàng :");

        btnTimKiemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/tim-nhan-vien.png"))); // NOI18N

        btnThemKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKhachHang.setForeground(new java.awt.Color(0, 153, 255));
        btnThemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/add-user.png"))); // NOI18N
        btnThemKhachHang.setText("Thêm");
        btnThemKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemKhachHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnThemKhachHang)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(665, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKhachHang)
                    .addComponent(btnThemKhachHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Địa chỉ", "Số điện thoại", "Ghi chú", "Công nợ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKhachHang.setRowHeight(35);
        tableKhachHang.setRowMargin(3);
        tableKhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableKhachHangFocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(tableKhachHang);
        if (tableKhachHang.getColumnModel().getColumnCount() > 0) {
            tableKhachHang.getColumnModel().getColumn(0).setMaxWidth(200);
            tableKhachHang.getColumnModel().getColumn(1).setMinWidth(150);
            tableKhachHang.getColumnModel().getColumn(2).setMinWidth(150);
            tableKhachHang.getColumnModel().getColumn(3).setMinWidth(120);
            tableKhachHang.getColumnModel().getColumn(3).setMaxWidth(120);
            tableKhachHang.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        javax.swing.GroupLayout panelQuanLyKhachHangLayout = new javax.swing.GroupLayout(panelQuanLyKhachHang);
        panelQuanLyKhachHang.setLayout(panelQuanLyKhachHangLayout);
        panelQuanLyKhachHangLayout.setHorizontalGroup(
            panelQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelQuanLyKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        panelQuanLyKhachHangLayout.setVerticalGroup(
            panelQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Tìm nhà cung cấp :");

        btnTimKiemNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/tim-nhan-vien.png"))); // NOI18N

        btnThemNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNhaCungCap.setForeground(new java.awt.Color(0, 153, 255));
        btnThemNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/add-user.png"))); // NOI18N
        btnThemNhaCungCap.setText("Thêm");
        btnThemNhaCungCap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemNhaCungCap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnThemNhaCungCap)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(647, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(txtTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemNhaCungCap)
                    .addComponent(btnThemNhaCungCap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Ghi chú", "Công nợ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNhaCungCap.setRowHeight(35);
        tableNhaCungCap.setRowMargin(3);
        tableNhaCungCap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableNhaCungCapFocusLost(evt);
            }
        });
        jScrollPane5.setViewportView(tableNhaCungCap);
        if (tableNhaCungCap.getColumnModel().getColumnCount() > 0) {
            tableNhaCungCap.getColumnModel().getColumn(0).setMaxWidth(200);
            tableNhaCungCap.getColumnModel().getColumn(1).setMinWidth(150);
            tableNhaCungCap.getColumnModel().getColumn(2).setMinWidth(150);
            tableNhaCungCap.getColumnModel().getColumn(3).setMinWidth(120);
            tableNhaCungCap.getColumnModel().getColumn(3).setMaxWidth(120);
            tableNhaCungCap.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        javax.swing.GroupLayout panelQuanLyNhaCungCapLayout = new javax.swing.GroupLayout(panelQuanLyNhaCungCap);
        panelQuanLyNhaCungCap.setLayout(panelQuanLyNhaCungCapLayout);
        panelQuanLyNhaCungCapLayout.setHorizontalGroup(
            panelQuanLyNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelQuanLyNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        panelQuanLyNhaCungCapLayout.setVerticalGroup(
            panelQuanLyNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Nhân viên", "Còn sử dụng ?", "Bán hàng", "Nhập hàng", "QL tài khoản", "QL hàng hóa", "QL nhân viên", "QL khách hàng", "QL nhà cung cấp", "QL phiếu chi", "Báo cáo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTaiKhoan.setRowHeight(35);
        tableTaiKhoan.setRowMargin(3);
        tableTaiKhoan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableTaiKhoanFocusLost(evt);
            }
        });
        jScrollPane6.setViewportView(tableTaiKhoan);
        if (tableTaiKhoan.getColumnModel().getColumnCount() > 0) {
            tableTaiKhoan.getColumnModel().getColumn(0).setMinWidth(150);
            tableTaiKhoan.getColumnModel().getColumn(1).setMinWidth(150);
            tableTaiKhoan.getColumnModel().getColumn(2).setMinWidth(200);
            tableTaiKhoan.getColumnModel().getColumn(3).setMinWidth(150);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Tìm tài khoản :");

        btnTimKiemTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/tim-nhan-vien.png"))); // NOI18N

        btnThemNhaCungCap1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNhaCungCap1.setForeground(new java.awt.Color(0, 153, 255));
        btnThemNhaCungCap1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/add-user.png"))); // NOI18N
        btnThemNhaCungCap1.setText("Thêm");
        btnThemNhaCungCap1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemNhaCungCap1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnThemNhaCungCap1)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(691, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(txtTimKiemTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemTaiKhoan)
                    .addComponent(btnThemNhaCungCap1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelQuanLyTaiKhoanLayout = new javax.swing.GroupLayout(panelQuanLyTaiKhoan);
        panelQuanLyTaiKhoan.setLayout(panelQuanLyTaiKhoanLayout);
        panelQuanLyTaiKhoanLayout.setHorizontalGroup(
            panelQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelQuanLyTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        panelQuanLyTaiKhoanLayout.setVerticalGroup(
            panelQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Tìm sản phẩm :");

        btnReloadTableSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reload.png"))); // NOI18N
        btnReloadTableSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTableSanPhamActionPerformed(evt);
            }
        });

        btnThemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSanPham.setForeground(new java.awt.Color(0, 153, 255));
        btnThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new-san-pham.png"))); // NOI18N
        btnThemSanPham.setText("Thêm");
        btnThemSanPham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemSanPham.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Nhóm hàng :");

        comboBoxNhomHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnXoaSanPham1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaSanPham1.setForeground(new java.awt.Color(0, 153, 255));
        btnXoaSanPham1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/nhom-hang.png"))); // NOI18N
        btnXoaSanPham1.setText("Thêm nhóm hàng");
        btnXoaSanPham1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoaSanPham1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnXoaSanPham2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaSanPham2.setForeground(new java.awt.Color(0, 153, 255));
        btnXoaSanPham2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/don-vi-tinh.png"))); // NOI18N
        btnXoaSanPham2.setText("Thêm ĐVT");
        btnXoaSanPham2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoaSanPham2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnXoaSanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoaSanPham1)
                    .addComponent(btnXoaSanPham2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnThemSanPham)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxNhomHang, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnReloadTableSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(comboBoxNhomHang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnReloadTableSanPham))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnThemSanPham)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ảnh", "Mã hàng", "Sản phẩm", "Barcode", "Đơn vị tính", "Giá nhập", "Giá bán", "Tồn kho", "Số lượng tối thiểu", "Nhà cung cấp", "Ghi chú", "Còn sử dụng ?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSanPham.setRowHeight(80);
        tableSanPham.setRowMargin(3);
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableSanPhamMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(tableSanPham);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1274, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel8);

        tableDonViTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Đơn vị tính", "Ghi chú", "Còn sử dụng?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDonViTinh.setRowHeight(30);
        tableDonViTinh.setRowMargin(4);
        jScrollPane7.setViewportView(tableDonViTinh);
        if (tableDonViTinh.getColumnModel().getColumnCount() > 0) {
            tableDonViTinh.getColumnModel().getColumn(0).setMinWidth(100);
            tableDonViTinh.getColumnModel().getColumn(0).setMaxWidth(100);
            tableDonViTinh.getColumnModel().getColumn(3).setMinWidth(120);
            tableDonViTinh.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Đơn vị tính", jPanel9);

        tableLoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Loại sản phẩm", "Ghi chú", "Còn sử dụng?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLoaiSanPham.setRowHeight(30);
        tableLoaiSanPham.setRowMargin(4);
        jScrollPane9.setViewportView(tableLoaiSanPham);
        if (tableLoaiSanPham.getColumnModel().getColumnCount() > 0) {
            tableLoaiSanPham.getColumnModel().getColumn(0).setMinWidth(100);
            tableLoaiSanPham.getColumnModel().getColumn(0).setMaxWidth(100);
            tableLoaiSanPham.getColumnModel().getColumn(3).setMinWidth(120);
            tableLoaiSanPham.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhóm hàng", jPanel10);

        javax.swing.GroupLayout panelQuanLyHangHoaLayout = new javax.swing.GroupLayout(panelQuanLyHangHoa);
        panelQuanLyHangHoa.setLayout(panelQuanLyHangHoaLayout);
        panelQuanLyHangHoaLayout.setHorizontalGroup(
            panelQuanLyHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelQuanLyHangHoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        panelQuanLyHangHoaLayout.setVerticalGroup(
            panelQuanLyHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyHangHoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        popupTableNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuSuaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuSuaNhanVien.setText("Sữa nhân viên");
        menuSuaNhanVien.setName("Sữa nhân viên"); // NOI18N
        menuSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSuaNhanVienActionPerformed(evt);
            }
        });
        popupTableNhanVien.add(menuSuaNhanVien);

        menuXoaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuXoaNhanVien.setText("Xóa nhân viên");
        menuXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuXoaNhanVienActionPerformed(evt);
            }
        });
        popupTableNhanVien.add(menuXoaNhanVien);

        tableThuNoKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableThuNoKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Thời gian", "Nhân viên thu tiền", "Khách hàng", "Số tiền thu", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableThuNoKhachHang.setComponentPopupMenu(popupTableNhanVien);
        tableThuNoKhachHang.setRowHeight(35);
        tableThuNoKhachHang.setRowMargin(3);
        tableThuNoKhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableThuNoKhachHangFocusLost(evt);
            }
        });
        tableThuNoKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableThuNoKhachHangMousePressed(evt);
            }
        });
        jScrollPane10.setViewportView(tableThuNoKhachHang);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiemThuNoKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemThuNoKhachHangKeyReleased(evt);
            }
        });

        btnTimKiemNhanVien1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reload.png"))); // NOI18N
        btnTimKiemNhanVien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNhanVien1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Tìm theo :");

        cbFilterThuNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nhân viên", "Khách hàng" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFilterThuNo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiemThuNoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(btnTimKiemNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(btnTimKiemNhanVien1)
                    .addComponent(txtTimKiemThuNoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFilterThuNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDanhSachPhieuThuNoKhachHangLayout = new javax.swing.GroupLayout(panelDanhSachPhieuThuNoKhachHang);
        panelDanhSachPhieuThuNoKhachHang.setLayout(panelDanhSachPhieuThuNoKhachHangLayout);
        panelDanhSachPhieuThuNoKhachHangLayout.setHorizontalGroup(
            panelDanhSachPhieuThuNoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelDanhSachPhieuThuNoKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        panelDanhSachPhieuThuNoKhachHangLayout.setVerticalGroup(
            panelDanhSachPhieuThuNoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDanhSachPhieuThuNoKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(100, 25));
        jToolBar1.setMinimumSize(new java.awt.Dimension(100, 25));

        btnTaoHoaDonBanHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnTaoHoaDonBanHang.setForeground(new java.awt.Color(51, 153, 255));
        btnTaoHoaDonBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/tao-hoa-don.png"))); // NOI18N
        btnTaoHoaDonBanHang.setText("Tạo đơn hàng");
        btnTaoHoaDonBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoHoaDonBanHang.setFocusable(false);
        btnTaoHoaDonBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaoHoaDonBanHang.setPreferredSize(new java.awt.Dimension(120, 120));
        btnTaoHoaDonBanHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTaoHoaDonBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonBanHangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTaoHoaDonBanHang);
        jToolBar1.add(jSeparator1);

        btnDanhSachHoaDonBanHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDanhSachHoaDonBanHang.setForeground(new java.awt.Color(51, 153, 255));
        btnDanhSachHoaDonBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/cac-hoa-don.png"))); // NOI18N
        btnDanhSachHoaDonBanHang.setText("Sổ hóa đơn");
        btnDanhSachHoaDonBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDanhSachHoaDonBanHang.setFocusable(false);
        btnDanhSachHoaDonBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDanhSachHoaDonBanHang.setPreferredSize(new java.awt.Dimension(120, 120));
        btnDanhSachHoaDonBanHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDanhSachHoaDonBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachHoaDonBanHangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDanhSachHoaDonBanHang);
        jToolBar1.add(jSeparator2);

        btnTaoPhieuThu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnTaoPhieuThu.setForeground(new java.awt.Color(51, 153, 255));
        btnTaoPhieuThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/tao-phieu-thu.png"))); // NOI18N
        btnTaoPhieuThu.setText("Tạo phiếu thu");
        btnTaoPhieuThu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoPhieuThu.setFocusable(false);
        btnTaoPhieuThu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaoPhieuThu.setPreferredSize(new java.awt.Dimension(120, 120));
        btnTaoPhieuThu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnTaoPhieuThu);
        jToolBar1.add(jSeparator3);

        btnTaoPhieuChi.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnTaoPhieuChi.setForeground(new java.awt.Color(51, 153, 255));
        btnTaoPhieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/tao-phieu-chi.png"))); // NOI18N
        btnTaoPhieuChi.setText("Tạo phiếu chi");
        btnTaoPhieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoPhieuChi.setFocusable(false);
        btnTaoPhieuChi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaoPhieuChi.setPreferredSize(new java.awt.Dimension(120, 120));
        btnTaoPhieuChi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnTaoPhieuChi);
        jToolBar1.add(jSeparator4);

        btnNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnNhapHang.setForeground(new java.awt.Color(51, 153, 255));
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/nhap-hang.png"))); // NOI18N
        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapHang.setFocusable(false);
        btnNhapHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhapHang.setPreferredSize(new java.awt.Dimension(120, 120));
        btnNhapHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNhapHang);
        jToolBar1.add(jSeparator5);

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 153, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/khach-tra-hang.png"))); // NOI18N
        jButton6.setText("Khách trả hàng");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setPreferredSize(new java.awt.Dimension(120, 120));
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator6);

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 153, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/tra-hang-ncc.png"))); // NOI18N
        jButton7.setText("Trả hàng NCC");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setPreferredSize(new java.awt.Dimension(120, 120));
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        panelMain.setLayout(new java.awt.BorderLayout());

        jMenu1.setText("Hệ thống");

        jMenu7.setText("Giao diện");
        jMenu7.setMargin(new java.awt.Insets(6, 6, 6, 6));

        jMenuItem1.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuItem5.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuItem6.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenuItem7.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem8.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem8);

        jMenuItem11.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenuItem12.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenuItem13.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuItem14.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem17.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem17);

        jMenuItem18.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem18);

        jMenu1.add(jMenu7);

        jMenuItem2.setText("Đổi mật khẩu");
        jMenuItem2.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Đăng xuất");
        jMenuItem3.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Thoát");
        jMenuItem4.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Danh mục");

        menuQuanLyHangHoa.setText("Hàng hóa");
        menuQuanLyHangHoa.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuQuanLyHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyHangHoaActionPerformed(evt);
            }
        });
        jMenu2.add(menuQuanLyHangHoa);

        menuQuanLyNhanVien.setText("Nhân viên");
        menuQuanLyNhanVien.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuQuanLyNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyNhanVienActionPerformed(evt);
            }
        });
        jMenu2.add(menuQuanLyNhanVien);

        menuQuanLyKhachHang.setText("Khách hàng");
        menuQuanLyKhachHang.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuQuanLyKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyKhachHangActionPerformed(evt);
            }
        });
        jMenu2.add(menuQuanLyKhachHang);

        menuQuanLyNhaCungCap.setText("Nhà cung cấp");
        menuQuanLyNhaCungCap.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuQuanLyNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyNhaCungCapActionPerformed(evt);
            }
        });
        jMenu2.add(menuQuanLyNhaCungCap);

        menuQuanLyTaiKhoan.setText("Tài khoản");
        menuQuanLyTaiKhoan.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuQuanLyTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyTaiKhoanActionPerformed(evt);
            }
        });
        jMenu2.add(menuQuanLyTaiKhoan);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Thu chi");

        jMenuItem9.setText("Tạo phiếu thu nợ");
        jMenuItem9.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Danh sách phiếu thu nợ");
        jMenuItem10.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);
        jMenu3.add(jSeparator7);

        jMenuItem28.setText("Trả nợ nhà cung cấp");
        jMenuItem28.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu3.add(jMenuItem28);

        jMenuItem29.setText("Nhật ký trả nợ NCC");
        jMenuItem29.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu3.add(jMenuItem29);
        jMenu3.add(jSeparator12);

        menuTaoPhieuChi.setText("Tạo phiếu chi");
        menuTaoPhieuChi.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuTaoPhieuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTaoPhieuChiActionPerformed(evt);
            }
        });
        jMenu3.add(menuTaoPhieuChi);

        menuDanhSachPhieuChi.setText("Danh sách phiếu chi");
        menuDanhSachPhieuChi.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu3.add(menuDanhSachPhieuChi);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Nhập kho");

        menuNhapHang.setText("Nhập thêm hàng hóa");
        menuNhapHang.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhapHangActionPerformed(evt);
            }
        });
        jMenu4.add(menuNhapHang);

        menuNhatKyNhapHang.setText("Nhật ký nhập hàng");
        menuNhatKyNhapHang.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu4.add(menuNhatKyNhapHang);
        jMenu4.add(jSeparator8);

        jMenuItem15.setText("Khách trả lại hàng");
        jMenuItem15.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu4.add(jMenuItem15);

        jMenuItem16.setText("Nhật ký hàng khách trả lại");
        jMenuItem16.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu4.add(jMenuItem16);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Xuất kho");

        menuTaoHoaDonBanHang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        menuTaoHoaDonBanHang.setText("Tạo đơn bán hàng");
        menuTaoHoaDonBanHang.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuTaoHoaDonBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTaoHoaDonBanHangActionPerformed(evt);
            }
        });
        jMenu5.add(menuTaoHoaDonBanHang);

        menuDanhSachHoaDonBanHang.setText("Danh sách hóa đơn bán hàng");
        menuDanhSachHoaDonBanHang.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu5.add(menuDanhSachHoaDonBanHang);
        jMenu5.add(jSeparator9);

        jMenuItem19.setText("Trả hàng lại NCC");
        jMenuItem19.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu5.add(jMenuItem19);

        jMenuItem20.setText("Nhật ký trả hàng cho NCC");
        jMenuItem20.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu5.add(jMenuItem20);
        jMenu5.add(jSeparator10);

        jMenuItem21.setText("Trích kho hàng hóa");
        jMenuItem21.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu5.add(jMenuItem21);

        jMenuItem22.setText("Nhật ký trích kho hàng hóa");
        jMenuItem22.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu5.add(jMenuItem22);

        jMenuBar1.add(jMenu5);

        menubarBaoCao.setText("Báo cáo");

        jMenuItem23.setText("Doanh thu, lợi nhuận");
        jMenuItem23.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menubarBaoCao.add(jMenuItem23);

        jMenuItem24.setText("Chi tiêu");
        jMenuItem24.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menubarBaoCao.add(jMenuItem24);

        jMenuItem25.setText("Công nợ khách hàng");
        jMenuItem25.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menubarBaoCao.add(jMenuItem25);

        jMenuItem26.setText("Công nợ nhà cung cấp");
        jMenuItem26.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menubarBaoCao.add(jMenuItem26);

        jMenuItem27.setText("Lương nhân viên");
        jMenuItem27.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menubarBaoCao.add(jMenuItem27);

        jMenuBar1.add(menubarBaoCao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuTaoPhieuChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTaoPhieuChiActionPerformed

    }//GEN-LAST:event_menuTaoPhieuChiActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed

    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnTaoHoaDonBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonBanHangActionPerformed
        taoPhieuBanHang();
    }//GEN-LAST:event_btnTaoHoaDonBanHangActionPerformed
    public void taoPhieuBanHang() {
        panelTaoHoaDonBanHang panel = new panelTaoHoaDonBanHang(acc);
        if (tabbed.getTabCount() == 0) {
            panelMain.removeAll();
            panelMain.add(tabbed);
            tabbed.add(panel);
        } else {
            tabbed.add(panel);
            tabbed.setSelectedIndex(tabbed.getTabCount() - 1);
        }
        panel.txtBarcode.requestFocus();
        panel.txtBarcode.requestFocus();
    }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Đăng xuất ?") == 0) {
            this.setVisible(false);
            new frmDangNhap().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Thoát phần mềm ?") == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnDanhSachHoaDonBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachHoaDonBanHangActionPerformed
        openTab(panelDanhSachHoaDonBanHang, "Danh sách hóa đơn");
    }//GEN-LAST:event_btnDanhSachHoaDonBanHangActionPerformed

    private void tableDanhSachHoaDonBanHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableDanhSachHoaDonBanHangFocusLost
        tableDanhSachHoaDonBanHang.clearSelection();
    }//GEN-LAST:event_tableDanhSachHoaDonBanHangFocusLost

    private void tableChiTietHoaDonBanHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableChiTietHoaDonBanHangFocusLost
        tableChiTietHoaDonBanHang.clearSelection();
    }//GEN-LAST:event_tableChiTietHoaDonBanHangFocusLost

    private void txtTimKiemHoaDonBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemHoaDonBanHangActionPerformed

    }//GEN-LAST:event_txtTimKiemHoaDonBanHangActionPerformed

    private void tableDanhSachHoaDonBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDanhSachHoaDonBanHangMouseClicked

    }//GEN-LAST:event_tableDanhSachHoaDonBanHangMouseClicked

    private void tableDanhSachHoaDonBanHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDanhSachHoaDonBanHangMousePressed
        if (tableDanhSachHoaDonBanHang.getSelectedRows().length == 1 && evt.getClickCount() == 2) {
            new frmXemHoaDon(this, true, acc).setVisible(true);
        }
    }//GEN-LAST:event_tableDanhSachHoaDonBanHangMousePressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new frmDoiMatKhau(this, true, acc).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuQuanLyNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyNhanVienActionPerformed
        openTab(panelQuanLyNhanVien, "Danh sách nhân viên");
    }//GEN-LAST:event_menuQuanLyNhanVienActionPerformed

    private void menuQuanLyKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyKhachHangActionPerformed
        openTab(panelQuanLyKhachHang, "Danh sách khách hàng");
    }//GEN-LAST:event_menuQuanLyKhachHangActionPerformed

    private void menuQuanLyNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyNhaCungCapActionPerformed
        openTab(panelQuanLyNhaCungCap, "Danh sách nhà cung cấp");
    }//GEN-LAST:event_menuQuanLyNhaCungCapActionPerformed

    private void menuQuanLyTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyTaiKhoanActionPerformed
        openTab(panelQuanLyTaiKhoan, "Quản lý tài khoản");
    }//GEN-LAST:event_menuQuanLyTaiKhoanActionPerformed

    private void menuQuanLyHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyHangHoaActionPerformed
        openTab(panelQuanLyHangHoa, "Kho hàng hóa");
    }//GEN-LAST:event_menuQuanLyHangHoaActionPerformed

    private void tableTaiKhoanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableTaiKhoanFocusLost
        tableTaiKhoan.clearSelection();
    }//GEN-LAST:event_tableTaiKhoanFocusLost

    private void tableNhaCungCapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableNhaCungCapFocusLost
        tableNhaCungCap.clearSelection();
    }//GEN-LAST:event_tableNhaCungCapFocusLost

    private void tableKhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableKhachHangFocusLost
        tableKhachHang.clearSelection();
    }//GEN-LAST:event_tableKhachHangFocusLost

    private void tableNhanVienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableNhanVienFocusLost
        tableNhanVien.clearSelection();
    }//GEN-LAST:event_tableNhanVienFocusLost

    private void menuTaoHoaDonBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTaoHoaDonBanHangActionPerformed
        taoPhieuBanHang();
    }//GEN-LAST:event_menuTaoHoaDonBanHangActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        helper.updateTheme(1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        helper.updateTheme(2);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        helper.updateTheme(3);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        helper.updateTheme(4);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        helper.updateTheme(5);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        helper.updateTheme(6);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        helper.updateTheme(11);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        helper.updateTheme(9);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        helper.updateTheme(10);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        helper.updateTheme(8);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        helper.updateTheme(7);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void tableNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhanVienMousePressed

        if (evt.getClickCount() == 2 && tableNhanVien.getSelectedRows().length == 1) {
            int indexRow = tableNhanVien.getSelectedRow();
            String idNhanVien = tableNhanVien.getValueAt(indexRow, 0) + "";
            frmEditorNhanVien frm = new frmEditorNhanVien((JFrame) this.getParent(), true, idNhanVien);
            frm.setVisible(true);
            MDNhanVien.arrayToTable(tableNhanVien);
        }
    }//GEN-LAST:event_tableNhanVienMousePressed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        frmEditorNhanVien frm = new frmEditorNhanVien((JFrame) this.getParent(), true);
        frm.setVisible(true);
        loadTableNhanVien();
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void menuSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSuaNhanVienActionPerformed
        // Sữa nhân viên
        int index = tableNhanVien.getSelectedRow();
        if (index != -1) {
            String id = tableNhanVien.getValueAt(index, 0) + "";
            frmEditorNhanVien frm = new frmEditorNhanVien((JFrame) this.getParent(), true, id);
            frm.setVisible(true);
            MDNhanVien.arrayToTable(tableNhanVien);
        }
    }//GEN-LAST:event_menuSuaNhanVienActionPerformed

    private void menuXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuXoaNhanVienActionPerformed
        // Xóa nhân viên
        int[] rows = tableNhanVien.getSelectedRows();
        if (rows.length > 0) {
            for (int i = 0; i < rows.length; i++) {
                String id = tableNhanVien.getValueAt(i, 0) + "";
                MDNhanVien.remove(id);
            }
            MDNhanVien.arrayToTable(tableNhanVien);
        }
    }//GEN-LAST:event_menuXoaNhanVienActionPerformed

    private void txtTimKiemNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNhanVienKeyReleased
        String text = txtTimKiemNhanVien.getText();
        ArrayList<nhanVien> data = MDNhanVien.getDataToTable();
        ArrayList<nhanVien> find = new ArrayList<nhanVien>();
        for (nhanVien item : data) {
            if (item.getIdNhanVien().toLowerCase().contains(text.toLowerCase())
                    || item.getSoDienthoai().contains(text)
                    || item.getName().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getIdNhanVien().toLowerCase()).contains(text.toLowerCase())
                    || helper.removeAccent(item.getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableNhanVien(find);
        } else {
            loadTableNhanVien(data);
        }
    }//GEN-LAST:event_txtTimKiemNhanVienKeyReleased

    private void btnTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVienActionPerformed
        loadTableNhanVien();
    }//GEN-LAST:event_btnTimKiemNhanVienActionPerformed

    private void btnReloadTableSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadTableSanPhamActionPerformed
        loadTableSanPham();
    }//GEN-LAST:event_btnReloadTableSanPhamActionPerformed

    private void tabbedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabbedKeyPressed

    }//GEN-LAST:event_tabbedKeyPressed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        frmEditorSanPham frm = new frmEditorSanPham(this, true, "add");
        frm.setVisible(true);
        loadTableSanPham();
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void tableSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMousePressed
        if (tableSanPham.getSelectedRows().length == 1 && evt.getClickCount() == 2) {
            String id = tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 1) + "";
            frmEditorSanPham frm = new frmEditorSanPham(this, true, id);
            frm.setVisible(true);
            loadTableSanPham();
        }
    }//GEN-LAST:event_tableSanPhamMousePressed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        openTab(panelDanhSachPhieuThuNoKhachHang, "Danh sách phiếu thu nợ");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        frmThuNoKhachHang panel = new frmThuNoKhachHang(this, true, acc);
        panel.setVisible(true);
        loadTableKhachHang();
        loadTableThuNoKhachHang();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void menuNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuNhapHangActionPerformed

    private void tableThuNoKhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableThuNoKhachHangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tableThuNoKhachHangFocusLost

    private void tableThuNoKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThuNoKhachHangMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableThuNoKhachHangMousePressed

    private void txtTimKiemThuNoKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemThuNoKhachHangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemThuNoKhachHangKeyReleased

    private void btnTimKiemNhanVien1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVien1ActionPerformed
        loadTableThuNoKhachHang();
    }//GEN-LAST:event_btnTimKiemNhanVien1ActionPerformed
    public void openTab(JPanel TypeOfPanel, String name) {
        JPanel tab = TypeOfPanel;
        tab.setName(name);
        if (tabbed.getTabCount() == 0) {
            panelMain.removeAll();
            panelMain.add(tabbed);
            tabbed.setVisible(true);
            tabbed.add(tab);
        } else {
            tabbed.add(tab);
            tabbed.setSelectedIndex(tabbed.getTabCount() - 1);
        }
    }

    public static void main(String args[]) {
//        5,8,
//sáng :10
        helper.setupTheme(8);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMAIN(acc).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhSachHoaDonBanHang;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnReloadTableSanPham;
    private javax.swing.JButton btnTaoHoaDonBanHang;
    private javax.swing.JButton btnTaoPhieuChi;
    private javax.swing.JButton btnTaoPhieuThu;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemNhaCungCap;
    private javax.swing.JButton btnThemNhaCungCap1;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnTimKiemKhachHang;
    private javax.swing.JButton btnTimKiemNhaCungCap;
    private javax.swing.JButton btnTimKiemNhanVien;
    private javax.swing.JButton btnTimKiemNhanVien1;
    private javax.swing.JButton btnTimKiemTaiKhoan;
    private javax.swing.JButton btnXoaSanPham1;
    private javax.swing.JButton btnXoaSanPham2;
    private javax.swing.JComboBox<String> cbFilterThuNo;
    private javax.swing.JComboBox<String> comboBoxNhomHang;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuDanhSachHoaDonBanHang;
    private javax.swing.JMenuItem menuDanhSachPhieuChi;
    private javax.swing.JMenuItem menuNhapHang;
    private javax.swing.JMenuItem menuNhatKyNhapHang;
    private javax.swing.JMenuItem menuQuanLyHangHoa;
    private javax.swing.JMenuItem menuQuanLyKhachHang;
    private javax.swing.JMenuItem menuQuanLyNhaCungCap;
    private javax.swing.JMenuItem menuQuanLyNhanVien;
    private javax.swing.JMenuItem menuQuanLyTaiKhoan;
    private javax.swing.JMenuItem menuSuaNhanVien;
    private javax.swing.JMenuItem menuTaoHoaDonBanHang;
    private javax.swing.JMenuItem menuTaoPhieuChi;
    private javax.swing.JMenuItem menuXoaNhanVien;
    private javax.swing.JMenu menubarBaoCao;
    private javax.swing.JPanel panelDanhSachHoaDonBanHang;
    private javax.swing.JPanel panelDanhSachPhieuThuNoKhachHang;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelQuanLyHangHoa;
    private javax.swing.JPanel panelQuanLyKhachHang;
    private javax.swing.JPanel panelQuanLyNhaCungCap;
    private javax.swing.JPanel panelQuanLyNhanVien;
    private javax.swing.JPanel panelQuanLyTaiKhoan;
    private javax.swing.JPopupMenu popupTableNhanVien;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JTable tableChiTietHoaDonBanHang;
    private javax.swing.JTable tableDanhSachHoaDonBanHang;
    private javax.swing.JTable tableDonViTinh;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTable tableLoaiSanPham;
    private javax.swing.JTable tableNhaCungCap;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTable tableTaiKhoan;
    private javax.swing.JTable tableThuNoKhachHang;
    private javax.swing.JTextField txtTimKiemHoaDonBanHang;
    private javax.swing.JTextField txtTimKiemKhachHang;
    private javax.swing.JTextField txtTimKiemNhaCungCap;
    private javax.swing.JTextField txtTimKiemNhanVien;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtTimKiemTaiKhoan;
    private javax.swing.JTextField txtTimKiemThuNoKhachHang;
    // End of variables declaration//GEN-END:variables
}
