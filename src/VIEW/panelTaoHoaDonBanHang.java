package VIEW;

import MODEL.MDChiTietHoaDon;
import CLASS.Account;
import CLASS.chiTietHoaDon;
import CLASS.khachHang;
import CLASS.sanPham;
import COMPONENT.DetailedComboBox;
import HELPER.helper;
import MODEL.MDKhachHang;
import MODEL.MDLoaiSanPham;
import MODEL.MDSanPham;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class panelTaoHoaDonBanHang extends javax.swing.JPanel {

    private DetailedComboBox comboboxKhachHang;
    public static Account acc;
    private ArrayList<chiTietHoaDon> dataChiTietHoaDon = new ArrayList<>();
//    private ArrayList<sanPham> dataSanPham = MDSanPham.getAll();
    private ArrayList<String> listLoaiSanPham = MDLoaiSanPham.getNames();

    private String path = "src/IMAGE/";
    private ArrayList<khachHang> dataKhachHang = MDKhachHang.getDataToComboBox();
    private String idKhachHang = "KH01";

    public panelTaoHoaDonBanHang(Account account) {
        this.acc = account;
        initComponents();
        this.setName("Phiếu bán hàng");

        // load combobox thông tin khách hàng
        loadComboboxKhachHang();

        UIManager.put("Table.consistentHomeEndKeyBehavior", true);
        // load comboBox loại sản phẩm
        loadComboboxLoaiSanPham();
        // add icon search 
        helper.addIconSearch(txtTimKiemSanPham);
        // add key listener cho nút quét mã vạch
        setKeyPress();
        //set model table sản phẩm
        setModelTableSanPham();
        loadTableSanPham();
        txtBarcode.requestFocus();
    }

    public void themNhanhSanPham() {
        frmThemNhanhSanPham frm = new frmThemNhanhSanPham((Frame) this.getParent().getParent().getParent().getParent().getParent().getParent(), true);
        frm.setVisible(true);

    }

    public void loadComboboxLoaiSanPham() {
        cbLoaiSanPham.removeAllItems();
        cbLoaiSanPham.addItem("Tất cả");
        for (String name : listLoaiSanPham) {
            cbLoaiSanPham.addItem(name);
        }
        cbLoaiSanPham.setSelectedIndex(0);
    }

    public void setKeyPress() {
        // nút enter
        InputMap inputMap = btnEnter.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "KEY_ENTER");
        btnEnter.getActionMap().put("KEY_ENTER", new AbstractAction() {
            public void actionPerformed(ActionEvent evt) {

                if (txtBarcode.isFocusable()) {
                    btnEnter.doClick();
                }
            }
        });

        // nút F9
        InputMap f9 = btnThanhToan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        f9.put(KeyStroke.getKeyStroke("F9"), "VK_F9");
        btnThanhToan.getActionMap().put("VK_F9", new AbstractAction() {
            public void actionPerformed(ActionEvent evt) {

                btnThanhToan.doClick();

            }
        });

        //nút F10
        InputMap f10 = jButton5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        f10.put(KeyStroke.getKeyStroke("F10"), "VK_F10");
        jButton5.getActionMap().put("VK_F10", new AbstractAction() {
            public void actionPerformed(ActionEvent evt) {

                jButton5.doClick();

            }
        });
    }

    public void loadTableSanPhamKeyReleased(String keyword) {
        ArrayList<sanPham> dataSanPhamTable = MDSanPham.getDataToTable();
        cbLoaiSanPham.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);

        for (sanPham item : dataSanPhamTable) {
            if (item.getIdSanPham().toLowerCase().contains(keyword.toLowerCase())
                    || item.getName().toLowerCase().contains(keyword.toLowerCase())
                    || helper.removeAccent(item.getIdSanPham().toLowerCase()).contains(keyword.toLowerCase())
                    || helper.removeAccent(item.getName().toLowerCase()).contains(keyword.toLowerCase())) {

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(path + item.getHinhAnh()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                model.addRow(new Object[]{
                    imageIcon,
                    item.getIdSanPham(),
                    item.getName(),
                    item.getBarcode(),
                    item.getIdDonViTinh(),
                    item.getSoLuong(),
                    helper.LongToString(item.getGiaBan())
                });
            }
        }
        tableSanPham.setModel(model);
    }

    public void loadTableSanPham() {
        ArrayList<sanPham> dataSanPhamTable = MDSanPham.getDataToTable();
        DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        for (sanPham item : dataSanPhamTable) {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(path + item.getHinhAnh()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            model.addRow(new Object[]{
                imageIcon,
                item.getIdSanPham(),
                item.getName(),
                item.getBarcode(),
                item.getIdDonViTinh(),
                item.getSoLuong(),
                helper.LongToString(item.getGiaBan())
            });
        }
        tableSanPham.setModel(model);
    }

    public void setModelTableSanPham() {
        DefaultTableCellRenderer centerRendere = new DefaultTableCellRenderer();
        centerRendere.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tableGioHang.getColumnCount() - 1; i++) {
            tableGioHang.getColumnModel().getColumn(i).setCellRenderer(centerRendere);
        }
        tableGioHang.setFont(new Font("Arial", Font.CENTER_BASELINE, 13));
        tableGioHang.setRowHeight(40);

        String[] column = {"Hình ảnh", "Mã", "Sản phẩm", "Mã vạch", "ĐVT", "Tồn kho", "Giá"};
        Object[][] rows = {};
        DefaultTableModel model = new DefaultTableModel(rows, column) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return ImageIcon.class;

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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableSanPham.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tableSanPham.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tableSanPham.setFont(new Font("Arial", Font.CENTER_BASELINE, 13));
        tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(90);
        tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(90);
        tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(230);
        tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(30);
        tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(30);
        tableSanPham.getColumnModel().getColumn(6).setPreferredWidth(60);

    }

    public void loadComboboxKhachHang() {
        String[] columns = new String[]{"Mã khách hàng", "Tên", "Điện thoại", "Địa chỉ", "Công nợ"};
        int[] widths = new int[]{80, 300, 120, 360, 150};
        this.comboboxKhachHang = new DetailedComboBox(columns, widths, 1);

        List<List<?>> tableData = new ArrayList<List<?>>();
        tableData.add(new ArrayList<>(
                Arrays.asList("KH01", "KHÁCH MỚI", "", "", "")));
        for (khachHang kh : dataKhachHang) {
            tableData.add(new ArrayList<>(
                    Arrays.asList(kh.getIdKhachHang(), kh.getName(), kh.getSoDienThoai(), kh.getDiaChi(), helper.LongToString(kh.getNo()))));
        }
        comboboxKhachHang.setTableData(tableData);
        comboboxKhachHang.setFont(new Font("Arial", Font.ITALIC, 16));
        comboboxKhachHang.setSelectedIndex(0);
        comboboxKhachHang.setPopupAlignment(DetailedComboBox.Alignment.LEFT);
        comboboxKhachHang.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                List<?> rowData = comboboxKhachHang.getSelectedRow();
                idKhachHang = rowData.get(0) + "";
            }
        });
        comboboxKhachHang.setVisible(true);
        panelComBoKhachHang.add(comboboxKhachHang);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        txtTimKiemSanPham = new javax.swing.JTextField();
        cbLoaiSanPham = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelComBoKhachHang = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();

        setNextFocusableComponent(txtBarcode);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/scan-barcode.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        txtBarcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBarcode.setActionCommand("<Not Set>");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEnter.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new-item.png"))); // NOI18N
        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        txtTimKiemSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiemSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyReleased(evt);
            }
        });

        cbLoaiSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Bia", "Nước ngọt", "Bánh", "Sữa", "Gia vị", "Đồ gia dụng" }));
        cbLoaiSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiSanPhamItemStateChanged(evt);
            }
        });

        tableSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Hình ảnh", "Mã", "Sản phẩm", "Đơn vị tính", "Tồn kho", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSanPham.setFocusable(false);
        tableSanPham.setRowHeight(80);
        tableSanPham.setRowMargin(3);
        tableSanPham.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableSanPhamFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableSanPhamFocusLost(evt);
            }
        });
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableSanPhamMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tableSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 220, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnEnter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("GIỎ HÀNG");

        tableGioHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sản phẩm", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền", "Xóa ?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableGioHang.setRowHeight(30);
        tableGioHang.setRowMargin(3);
        tableGioHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableGioHangFocusLost(evt);
            }
        });
        tableGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tableGioHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableGioHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableGioHangMouseReleased(evt);
            }
        });
        tableGioHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableGioHangKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableGioHang);
        if (tableGioHang.getColumnModel().getColumnCount() > 0) {
            tableGioHang.getColumnModel().getColumn(0).setMinWidth(200);
            tableGioHang.getColumnModel().getColumn(0).setMaxWidth(200);
            tableGioHang.getColumnModel().getColumn(1).setMaxWidth(120);
            tableGioHang.getColumnModel().getColumn(2).setMaxWidth(80);
            tableGioHang.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Khách hàng :");

        panelComBoKhachHang.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Hình thức :");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Nợ" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Giảm giá (%) :");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Ghi chú :");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Tổng tiền :");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setFocusable(false);

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(0, 204, 0));
        btnThanhToan.setText("Thanh toán (F9)");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        btnThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnThanhToanKeyPressed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 204));
        jButton5.setText("Lưu & in (F10)");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 0, 51));
        jButton6.setText("Hủy (ESC)");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new-user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(panelComBoKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(jTextField3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 191, Short.MAX_VALUE)
                            .addComponent(jTextField4)))
                    .addComponent(jScrollPane4))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(panelComBoKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        themNhanhSanPham();
        loadTableSanPham();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void addGioHang(chiTietHoaDon sp) {
        boolean isTonTai = true;

        if (sp == null) {
            if (JOptionPane.showConfirmDialog(null, "Sản phẩm chưa có. Thêm mới sản phẩm ?") == 0) {
                themNhanhSanPham();
                loadTableSanPham();
            }
            System.out.println("null");
            txtBarcode.setText("");
            txtBarcode.requestFocus();
        }
        if (dataChiTietHoaDon.size() == 0) {
            dataChiTietHoaDon.add(sp);
            loadTableGioHang();

            return;
        } else {
            for (chiTietHoaDon item : dataChiTietHoaDon) {
                if (item.getIdSanPham().equals(sp.getIdSanPham())) {
                    // đã tồn tại
                    isTonTai = true;
                    break;
                } else {
                    //chưa tồn tại
                    isTonTai = false;

                }
            }
        }

        if (isTonTai == true) {
            for (chiTietHoaDon item : dataChiTietHoaDon) {
                if (item.getIdSanPham().equals(sp.getIdSanPham())) {
                    item.setSoLuong(item.getSoLuong() + 1);
                    break;
                }
            }
        } else {
            dataChiTietHoaDon.add(sp);
        }
        loadTableGioHang();
    }

    public void enterBarcode() {
        if (txtBarcode.isFocusable() == false) {
            return;
        }
        String barcode = txtBarcode.getText();
        chiTietHoaDon sp = MDChiTietHoaDon.getSanPhamChiTietHoaDon(barcode);
        if (sp == null) {
            if (JOptionPane.showConfirmDialog(null, "Sản phẩm chưa có. Thêm mới sản phẩm ?") == 0) {
                themNhanhSanPham();
            }
            txtBarcode.setText("");
            txtBarcode.requestFocus();
            return;
        }
        addGioHang(sp);
        txtBarcode.requestFocus();
    }

    public void loadTableGioHang() {
        DefaultTableModel model = (DefaultTableModel) tableGioHang.getModel();
        model.setRowCount(0);
        for (chiTietHoaDon item : dataChiTietHoaDon) {
            model.addRow(new Object[]{
                item.getTenSanPham(),
                item.getDonViTinh(),
                item.getSoLuong(),
                helper.LongToString(item.getDonGia()),
                helper.LongToString(item.getThanhTien()),
                item.isTrangThai()
            });
        }

        tableGioHang.setModel(model);
    }
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        enterBarcode();
        txtBarcode.setText("");
        txtBarcode.requestFocus();
    }//GEN-LAST:event_btnEnterActionPerformed

    private void tableSanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseExited

    }//GEN-LAST:event_tableSanPhamMouseExited

    private void tableGioHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGioHangMouseExited

    }//GEN-LAST:event_tableGioHangMouseExited

    private void tableSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseEntered

    }//GEN-LAST:event_tableSanPhamMouseEntered

    private void tableSanPhamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableSanPhamFocusGained

    }//GEN-LAST:event_tableSanPhamFocusGained

    private void tableSanPhamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableSanPhamFocusLost
        tableSanPham.clearSelection();
    }//GEN-LAST:event_tableSanPhamFocusLost

    private void tableGioHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableGioHangFocusLost
        tableGioHang.clearSelection();
    }//GEN-LAST:event_tableGioHangFocusLost

    private void btnThanhToanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnThanhToanKeyPressed

    }//GEN-LAST:event_btnThanhToanKeyPressed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        JOptionPane.showMessageDialog(this, "thanh toán f9");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        txtBarcode.requestFocus();
    }//GEN-LAST:event_jLabel2MouseClicked
    public void deleteGioHang() {
        DefaultTableModel model = (DefaultTableModel) tableGioHang.getModel();
        for (int i = 0; i < tableGioHang.getRowCount(); i++) {
            boolean check = (boolean) tableGioHang.getValueAt(i, 5);
            if (check == false) {
//                model.removeRow(i);
                dataChiTietHoaDon.remove(i);
            }
        }
        loadTableGioHang();
    }
    private void tableGioHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGioHangMousePressed
//        deleteGioHang();

    }//GEN-LAST:event_tableGioHangMousePressed

    private void tableGioHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGioHangMouseReleased
        deleteGioHang();
    }//GEN-LAST:event_tableGioHangMouseReleased

    private void tableGioHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableGioHangKeyReleased
        int rowCount = tableGioHang.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            dataChiTietHoaDon.get(i).setDonGia(helper.SoLong(tableGioHang.getValueAt(i, 3) + ""));
            dataChiTietHoaDon.get(i).setSoLuong(Integer.parseInt(tableGioHang.getValueAt(i, 2) + ""));
            if (dataChiTietHoaDon.get(i).getSoLuong() < 1 || dataChiTietHoaDon.get(i).getDonGia() < 0) {
                dataChiTietHoaDon.remove(i);
            }
        }
        loadTableGioHang();
    }//GEN-LAST:event_tableGioHangKeyReleased

    private void tableSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMousePressed
        if (tableSanPham.getSelectedRows().length == 1 && evt.getClickCount() == 2) {
            int indexRow = tableSanPham.getSelectedRow();
            String barcode = tableSanPham.getValueAt(indexRow, 3) + "";
            chiTietHoaDon sp = MDChiTietHoaDon.getSanPhamChiTietHoaDon(barcode);
            addGioHang(sp);
        }
    }//GEN-LAST:event_tableSanPhamMousePressed
    public void loadTableSanPham(String loaiSanPham) {
        ArrayList<sanPham> dataSanPhamTable = MDSanPham.getDataToTable();
        DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        for (sanPham item : dataSanPhamTable) {

            if (loaiSanPham.equals("Tất cả") || item.getIdLoaiSanPham().equals(loaiSanPham)) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(path + item.getHinhAnh()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                model.addRow(new Object[]{
                    imageIcon,
                    item.getIdSanPham(),
                    item.getName(),
                    item.getBarcode(),
                    item.getIdDonViTinh(),
                    item.getSoLuong(),
                    helper.LongToString(item.getGiaBan())
                });
            }
        }
        tableSanPham.setModel(model);
    }
    private void cbLoaiSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiSanPhamItemStateChanged
        String loaSanPham = cbLoaiSanPham.getSelectedItem() + "";
        loadTableSanPham(loaSanPham);
    }//GEN-LAST:event_cbLoaiSanPhamItemStateChanged

    private void txtTimKiemSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyReleased
        loadTableSanPhamKeyReleased(txtTimKiemSanPham.getText());
    }//GEN-LAST:event_txtTimKiemSanPhamKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cbLoaiSanPham;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel panelComBoKhachHang;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JTable tableSanPham;
    public javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtTimKiemSanPham;
    // End of variables declaration//GEN-END:variables
}
