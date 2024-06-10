/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Service.Impl.ChucVuService;
import Service.Impl.NhanVienService;
import ViewModel.ChucVuVM;
import ViewModel.NhanVienVM;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class NhanVienJ extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    List<NhanVien> list = new ArrayList<>();
    private NhanVienService nhanVienService = new NhanVienService();
    private ChucVuService chucVuService = new ChucVuService();
    private DefaultComboBoxModel dcbbm;

    /**
     * Creates new form NhanVienJ
     */
    public NhanVienJ() {
        initComponents();
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) tblNhanVien.getModel();
        dtm = (DefaultTableModel) tblChucVu.getModel();
        list = nhanVienService.getAllDoMain();
        dcbbm = (DefaultComboBoxModel) cbbChucVu.getModel();
        dcbbm.addAll(chucVuService.getAll());
        for (int i = 0; i < dcbbm.getSize(); i++) {
            System.out.println(dcbbm.getElementAt(i) instanceof ChucVuVM);
        }
        loadTable();
        loadTableCV();
    }

    private void loadTable() {
        ArrayList<NhanVienVM> list = nhanVienService.getAll();
        dtm.setRowCount(0);
        for (NhanVienVM nhanVien : list) {
            dtm.addRow(new Object[]{
                nhanVien.getMaNV(),
                nhanVien.getTenNV(),
                nhanVien.getGioiTinh() == 1 ? "Nam" : "Nữ",
                nhanVien.getNgaySinh(),
                nhanVien.getCCCD(),
                nhanVien.getDiaChi(),
                nhanVien.getSDT(),
                nhanVien.getEmail(),
                nhanVien.getTenCV(),
                nhanVien.getTrangThaiNV() == 1 ? "Đang Làm" : "Đã Nghỉ"
            });
        }
    }

    public void LamMoi() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        rdoNam.setSelected(true);
        txtNgaySinh.setText("");
        txtCCCD.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        cbbChucVu.setSelectedIndex(0);
        rdDangLam.setSelected(true);
        loadTable();
    }

    public void getData() {
        String MaNV = txtMaNV.getText();
        String TenNV = txtTenNV.getText();
        int GioiTinh = rdoNam.isSelected() ? 1 : 0;
        String NgaySinh = txtNgaySinh.getText();
        String CCCD = txtCCCD.getText();
        String DiaChi = txtDiaChi.getText();
        String SDT = txtSDT.getText();
        String Email = txtEmail.getText();
        UUID TenCV;
        try {
            TenCV = ((ChucVuVM) cbbChucVu.getSelectedItem()).getId();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ.");
            return;
        }
        int TrangThai = rdDangLam.isSelected() ? 1 : 0;

        NhanVien nv = new NhanVien();
        nv.setMaNV(MaNV);
        nv.setTenNV(TenNV);
        nv.setGioiTinh(GioiTinh);
        nv.setNgaySinh(NgaySinh(NgaySinh));
        nv.setCCCD(CCCD);
        nv.setDiaChi(DiaChi);
        nv.setSDT(SDT);
        nv.setEmail(Email);
        nv.setIdCV(TenCV);
        nv.setTrangThaiNV(TrangThai);

    }

    public boolean checkTrong() {
        if (txtMaNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Nhân Viên không để trống");
            txtMaNV.requestFocus();
            return false;
        }
        if (txtTenNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "tên Nhân Viên không được để trống");
            txtTenNV.requestFocus();
            return false;
        }
        if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Chọn Giới Tính");
            return false;
        }
        if (!rdDangLam.isSelected() && !rdDaNghi.isSelected()) {
            JOptionPane.showMessageDialog(this, "Chọn Trạng Thái");
            return false;
        }
//        if (cbbChucVu.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "khong de chuc vu");
//            txtChucVu.requestFocus();
//            return false;
//        }
        if (txtSDT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số Điện Thoại không đụoec để trống");
            txtMaNV.requestFocus();
            return false;
        }
        if (txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            txtDiaChi.requestFocus();
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email không được để ");
            txtEmail.requestFocus();
            return false;
        }

        //
        return true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChucVujDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaCV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTenCV = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        SuaCv = new javax.swing.JButton();
        btnLamMoi1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblChucVu = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoDungHD = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdDangLam = new javax.swing.JRadioButton();
        rdDaNghi = new javax.swing.JRadioButton();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTimkiem1 = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtTimkiem = new javax.swing.JTextField();
        btnTimKiem2 = new javax.swing.JButton();
        btnChucVu = new javax.swing.JButton();

        ChucVujDialog.setMinimumSize(new java.awt.Dimension(500, 650));
        ChucVujDialog.setModal(true);

        jPanel2.setBackground(new java.awt.Color(222, 229, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(465, 335));
        jPanel2.setVerifyInputWhenFocusTarget(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Quản Lý Chức Vụ");

        jLabel12.setText("Mã CV :");

        jLabel13.setText("Tên CV :");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SuaCv.setText("Sửa");

        btnLamMoi1.setText("Làm mới");
        btnLamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoi1ActionPerformed(evt);
            }
        });

        tblChucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã CV", "Tên CV", "Trạng thái"
            }
        ));
        tblChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChucVuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblChucVu);

        jLabel14.setText("Trạng Thái :");

        rdoHoatDong.setText("Hoạt động");

        rdoDungHD.setText("Dừng hoạt động");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(154, 154, 154))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SuaCv)
                                .addGap(54, 54, 54)
                                .addComponent(btnLamMoi1)
                                .addGap(56, 56, 56))
                            .addComponent(txtMaCV)
                            .addComponent(txtTenCV, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoDungHD)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rdoHoatDong)
                    .addComponent(rdoDungHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(SuaCv)
                    .addComponent(btnLamMoi1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ChucVujDialogLayout = new javax.swing.GroupLayout(ChucVujDialog.getContentPane());
        ChucVujDialog.getContentPane().setLayout(ChucVujDialogLayout);
        ChucVujDialogLayout.setHorizontalGroup(
            ChucVujDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucVujDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ChucVujDialogLayout.setVerticalGroup(
            ChucVujDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucVujDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(222, 231, 227));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tblNhanVien.setBackground(new java.awt.Color(222, 231, 227));
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Họ tên ", "Giới tính", "Ngày sinh ", "CCCD", "Địa chỉ ", "SDT ", "Email", "Chức Vụ", "Trạng thái"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel1.setText("Mã :");

        jLabel2.setText("Họ tên :");

        jLabel3.setText("Giới Tính :");

        jLabel4.setText("Ngày Sinh :");

        jLabel5.setText("CCCD :");

        jLabel6.setText("Địa Chỉ :");

        jLabel7.setText("Trạng thái :");

        buttonGroup2.add(rdDangLam);
        rdDangLam.setText("Đang làm");

        buttonGroup2.add(rdDaNghi);
        rdDaNghi.setText("Đã nghỉ");

        btnLamMoi.setText("Làm mới ");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel8.setText("Chức vụ :");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn chức vụ..." }));
        cbbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucVuActionPerformed(evt);
            }
        });

        jLabel9.setText("SĐT :");

        jLabel10.setText("Email :");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(222, 231, 227));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo chức vụ"));

        txtTimkiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiem1KeyReleased(evt);
            }
        });

        btnTimKiem1.setText("Tìm");
        btnTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem1))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(222, 231, 227));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm nhân viên theo mã"));

        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        btnTimKiem2.setText("Tìm");
        btnTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem2))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        btnChucVu.setText("Chức Vụ");
        btnChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChucVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi)))
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNam)
                                .addGap(32, 32, 32)
                                .addComponent(rdoNu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnThem)
                                .addGap(33, 33, 33)
                                .addComponent(btnLamMoi)
                                .addGap(35, 35, 35)
                                .addComponent(btnSua)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(rdDangLam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdDaNghi))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnChucVu)
                                        .addGap(22, 22, 22)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(jLabel8)
                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChucVu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rdDangLam)
                    .addComponent(rdDaNghi))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnLamMoi)
                            .addComponent(btnSua))))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int row = tblNhanVien.getSelectedRow();
        if (row == -1) {
            return;
        }

        if (Optional.ofNullable(tblNhanVien.getValueAt(row, 4)).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được null");
            return;
        }

        String MaNV = tblNhanVien.getValueAt(row, 0).toString();
        String TenNV = tblNhanVien.getValueAt(row, 1).toString();
        String GioiTinh = tblNhanVien.getValueAt(row, 2).toString();
        String NgaySinh = tblNhanVien.getValueAt(row, 3).toString();
        String CCCD = tblNhanVien.getValueAt(row, 4).toString();
        String DiaChi = tblNhanVien.getValueAt(row, 5).toString();
        String SDT = tblNhanVien.getValueAt(row, 6).toString();
        String Email = tblNhanVien.getValueAt(row, 7).toString();
        String TenCV = tblNhanVien.getValueAt(row, 8).toString();
        String TrangThaiNV = tblNhanVien.getValueAt(row, 9).toString();

        txtMaNV.setText(MaNV);
        txtTenNV.setText(TenNV);
        if (GioiTinh.equals("Nam")) {
            this.rdoNam.setSelected(true);
        } else {
            this.rdoNu.setSelected(true);
        }
        txtNgaySinh.setText(NgaySinh);
        txtCCCD.setText(CCCD);
        txtDiaChi.setText(DiaChi);
        txtSDT.setText(SDT);
        txtEmail.setText(Email);
        dcbbm.setSelectedItem(chucVuService.getAll().stream().filter(i -> i.getTenCV().equals(TenCV)).findFirst().get());
        if (TrangThaiNV.equalsIgnoreCase("Đang Làm")) {
            this.rdDangLam.setSelected(true);
        } else if (TrangThaiNV.equalsIgnoreCase("Đã Nghỉ")) {
            this.rdDaNghi.setSelected(true);
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // Lấy dữ liệu từ UI
        String MaNV = txtMaNV.getText();
        String TenNV = txtTenNV.getText();
        int GioiTinh = rdoNam.isSelected() ? 1 : 0;
        String NgaySinh = txtNgaySinh.getText();
        String CCCD = txtCCCD.getText();
        String DiaChi = txtDiaChi.getText();
        String SDT = txtSDT.getText();
        String Email = txtEmail.getText();
        UUID TenCV;
        try {
            TenCV = ((ChucVuVM) cbbChucVu.getSelectedItem()).getId();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ.");
            return;
        }
        int TrangThai = rdDangLam.isSelected() ? 1 : 0;

        NhanVien nv = new NhanVien();
        nv.setMaNV(MaNV);
        nv.setTenNV(TenNV);
        nv.setGioiTinh(GioiTinh);
        nv.setNgaySinh(NgaySinh(NgaySinh));
        nv.setCCCD(CCCD);
        nv.setDiaChi(DiaChi);
        nv.setSDT(SDT);
        nv.setEmail(Email);
        nv.setIdCV(TenCV);
        nv.setTrangThaiNV(TrangThai);

        this.nhanVienService.update(nv);
        this.loadTable();


    }//GEN-LAST:event_btnSuaActionPerformed

    public Date NgaySinh(String ngaysinh) {

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(ngaysinh);
        } catch (ParseException ex) {
            ex.getMessage();
        }

        return d;
    }
    private void cbbChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChucVuActionPerformed

    }//GEN-LAST:event_cbbChucVuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "xac nhan them", "huy", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            if (checkTrong()) {
                String MaNV = txtMaNV.getText();
                String TenNV = txtTenNV.getText();
                int GioiTinh = rdoNam.isSelected() == true ? 1 : 0;
                String NgaySinh = txtNgaySinh.getText();
                String CCCD = txtCCCD.getText();
                String DiaChi = txtDiaChi.getText();
                String SDT = txtSDT.getText();
                String Email = txtEmail.getText();
                UUID TenCV = ((ChucVuVM) cbbChucVu.getSelectedItem()).getId();
                int TrangThai = rdDangLam.isSelected() == true ? 1 : 0;

                NhanVien nv = new NhanVien();
                nv.setMaNV(MaNV);
                nv.setTenNV(TenNV);
                nv.setGioiTinh(GioiTinh);
                nv.setNgaySinh(NgaySinh(NgaySinh));
                nv.setCCCD(CCCD);
                nv.setDiaChi(DiaChi);
                nv.setSDT(SDT);
                nv.setEmail(Email);
                nv.setIdCV(TenCV);
                nv.setTrangThaiNV(TrangThai);

                System.out.println(nv);

                this.nhanVienService.add(nv);
                LamMoi();
                this.loadTable();
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimkiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiem1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiem1KeyReleased

    private void btnTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem1ActionPerformed
        String TenCV = txtTimkiem1.getText(); // Lấy vai trò được chọn từ combobox
        ArrayList<NhanVien> filteredList = filterByTenCV(TenCV);
        loadTable(filteredList);
    }//GEN-LAST:event_btnTimKiem1ActionPerformed
    private ArrayList<NhanVien> filterByTenCV(String TenCV) {
        ArrayList<NhanVien> filteredList = new ArrayList<>();
        for (NhanVien nhanVien : nhanVienService.getAllDoMain()) {
            if (nhanVien.getTenCV().equals(TenCV)) {
                filteredList.add(nhanVien);
            }
        }
        return filteredList;
    }

    private void loadTable(ArrayList<NhanVien> dataList) {
        dtm.setRowCount(0);
        for (NhanVien nhanVien : dataList) {
            dtm.addRow(new Object[]{
                nhanVien.getMaNV(),
                nhanVien.getTenNV(),
                nhanVien.getGioiTinh() == 1 ? "Nam" : "Nữ",
                nhanVien.getNgaySinh(),
                nhanVien.getCCCD(),
                nhanVien.getDiaChi(),
                nhanVien.getSDT(),
                nhanVien.getEmail(),
                nhanVien.getTenCV(),
                nhanVien.getTrangThaiNV() == 1 ? "Đang Làm" : "Đã Nghỉ"
            });
        }
    }
    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemKeyReleased

    private void btnTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem2ActionPerformed
        ArrayList<NhanVienVM> listNVVM = nhanVienService.getAll();
        String TimKiem = this.txtTimkiem.getText();
        int index = -1;
        for (NhanVienVM nvvm : listNVVM) {
            if (TimKiem.equalsIgnoreCase(nvvm.getMaNV())) {
                index = listNVVM.indexOf(nvvm);
            }
        }

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy !");
            return;
        }
        txtMaNV.setText(listNVVM.get(index).getMaNV());
        txtTenNV.setText(listNVVM.get(index).getTenNV());
        rdoNam.setSelected(true);
        txtNgaySinh.setText(String.valueOf(listNVVM.get(index).getNgaySinh()));
        txtCCCD.setText(String.valueOf(listNVVM.get(index).getCCCD()));
        txtDiaChi.setText(String.valueOf(listNVVM.get(index).getDiaChi()));
        txtSDT.setText(String.valueOf(listNVVM.get(index).getSDT()));
        cbbChucVu.setSelectedItem(ABORT);
        txtEmail.setText(String.valueOf(listNVVM.get(index).getEmail()));
        rdDangLam.setSelected(true);
        loadTable();
    }//GEN-LAST:event_btnTimKiem2ActionPerformed

    private void btnChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChucVuActionPerformed
        ChucVujDialog.setVisible(true);
        ChucVujDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnChucVuActionPerformed

    private void btnLamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoi1ActionPerformed
        LamMoicv();
    }//GEN-LAST:event_btnLamMoi1ActionPerformed

    private void tblChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChucVuMouseClicked
        int row = tblChucVu.getSelectedRow();
        if (row == -1) {
            return;
        }

        String MaCV = tblChucVu.getValueAt(row, 1).toString();
        String TenCV = tblChucVu.getValueAt(row, 2).toString();
        String TrangThai = tblChucVu.getValueAt(row, 3).toString();

        txtMaCV.setText(MaCV);
        txtTenCV.setText(TenCV);
        if (TrangThai.equalsIgnoreCase("Hoạt động")) {
            rdoHoatDong.setSelected(true);
        } else {
            rdoDungHD.setSelected(true);
        }
    }//GEN-LAST:event_tblChucVuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String MaCV = txtMaCV.getText();
        String TenCV = txtTenCV.getText();
        int TrangThai = rdoHoatDong.isSelected() ? 1 : 0;

        ChucVu cv = new ChucVu();
        cv.setMaCV(MaCV);
        cv.setTenCV(TenCV);
        cv.setTrangThai(TrangThai);

        chucVuService.add(cv);
        this.loadTableCV();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadTableCV() {
        ArrayList<ChucVuVM> list = chucVuService.getAll();
        dtm.setRowCount(0);
        for (ChucVuVM cv : list) {
            dtm.addRow(new Object[]{
                cv.getId(),
                cv.getMaCV(),
                cv.getTenCV(),
                cv.getTrangThaiCV() == 1 ? "Hoạt Động" : "Dừng Hoạt Động"

            }
            );
        }
    }

    private void LamMoicv() {
        txtMaCV.setText("");
        txtTenCV.setText("");
        rdoDungHD.setSelected(true);
        loadTableCV();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVienJ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienJ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienJ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienJ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienJ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ChucVujDialog;
    private javax.swing.JButton SuaCv;
    private javax.swing.JButton btnChucVu;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoi1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnTimKiem2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rdDaNghi;
    private javax.swing.JRadioButton rdDangLam;
    private javax.swing.JRadioButton rdoDungHD;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblChucVu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaCV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenCV;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtTimkiem1;
    // End of variables declaration//GEN-END:variables
}
