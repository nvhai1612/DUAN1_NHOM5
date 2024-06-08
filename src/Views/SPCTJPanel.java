/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModel.ChatLieu;
import DomainModel.KichCo;
import DomainModel.MauSac;
import DomainModel.SanPham;
import DomainModel.SanPhamChiTiet;
import DomainModel.ThuongHieu;
import Repository.Impl.SPCTRepos;
import Service.Impl.ChatLieuService;
import Service.Impl.KichCoService;
import Service.Impl.MauSacService;
import Service.Impl.SPCTService;
import Service.Impl.SanPhamService;
import Service.Impl.ThuongHieuService;

import ViewModel.ChatLieuVM;
import ViewModel.KichCoVM;
import ViewModel.MauSacVM;
import ViewModel.SPCTVM;
import ViewModel.SanPhamVM;
import ViewModel.ThuongHieuVM;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SPCTJPanel extends javax.swing.JPanel {

    private SPCTService SPCTService = new SPCTService();
    private MauSacService mauSacService = new MauSacService();
    private ChatLieuService chatLieuService = new ChatLieuService();
    private KichCoService kichCoService = new KichCoService();
    private ThuongHieuService thuongHieuService = new ThuongHieuService();
    private SanPhamService sanPhamService = new SanPhamService();
    private SPCTRepos spctrp = new SPCTRepos();

    /**
     * Creates new form SanPhamJFrame
     */
    
    private DefaultComboBoxModel dcbbtsp;

    private DefaultComboBoxModel dcbbmsp;
    private DefaultComboBoxModel dcbbmcl;
    private DefaultComboBoxModel dcbbmkc;
    private DefaultComboBoxModel dcbbmms;
    private DefaultComboBoxModel dcbbmth;

    public SPCTJPanel() {
        initComponents();
        dcbbmcl = (DefaultComboBoxModel) cbbChatLieu.getModel();
        dcbbmcl.addAll(chatLieuService.getAll());
        for (int i = 0; i < dcbbmcl.getSize(); i++) {
//            System.out.println(dcbbmcl.getElementAt(i)instanceof ChatLieuVM);
        }

        dcbbmkc = (DefaultComboBoxModel) cbbKichCo.getModel();
        dcbbmkc.addAll(kichCoService.getAll());
        for (int i = 0; i < dcbbmkc.getSize(); i++) {
//            System.out.println(dcbbmkc.getElementAt(i)instanceof KichCoVM);
        }

        dcbbmms = (DefaultComboBoxModel) cbbMauSac.getModel();
        dcbbmms.addAll(mauSacService.getAll());
        for (int i = 0; i < dcbbmms.getSize(); i++) {
//            System.out.println(dcbbmms.getElementAt(i)instanceof MauSacVM);
        }

        dcbbmth = (DefaultComboBoxModel) cbbTH.getModel();
        dcbbmth.addAll(thuongHieuService.getAll());
        for (int i = 0; i < dcbbmth.getSize(); i++) {
//            System.out.println(dcbbmnsx.getElementAt(i)instanceof ChucVuVM);
        }
        
        dcbbtsp = (DefaultComboBoxModel) cbbTenSP.getModel();
        dcbbtsp.addAll(sanPhamService.getAll());
        for (int i = 0; i < dcbbtsp.getSize(); i++) {
//            System.out.println(dcbbmnsx.getElementAt(i)instanceof ChucVuVM);
        }

        LoadTableSPCT();
        LoadTableSP();
        LoadTableCL();
        LoadTableKC();
        LoadTableMS();
        LoadTableTH();
    }

    private void LoadTableSP() {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);

        ArrayList<SanPhamVM> listSPVM = sanPhamService.getAll();

        for (SanPhamVM spvm : listSPVM) {
            dtm.addRow(new Object[]{
                spvm.getId(),
                spvm.getMaSP(),
                spvm.getTenSP(),
                spvm.getTrangThaiSP() == 1 ? "Hoạt động" : "Dừng Hoạt động",});
        }
    }

    private void LoadTableSPCT() {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPhamChiTiet.getModel();
        dtm.setRowCount(0);

        ArrayList<SPCTVM> listSPCTVM = SPCTService.getAll();

        for (SPCTVM spctvm : listSPCTVM) {
            dtm.addRow(new Object[]{
                spctvm.getMaSPCT(),
                spctvm.getTenSP(),
                spctvm.getSoLuongTon(),
                spctvm.getNguoiTao(),
                spctvm.getTrangThaiSPCT() == 1 ? "Đang Hoạt động" : "Dừng Hoạt động",
                spctvm.getTenKC(),
                spctvm.getTenMS(),
                spctvm.getTenTH(),
                spctvm.getTenCL(),
                spctvm.getDonGia(),
            });

            System.out.println(spctvm);
        }
    }
    
    public void LoadTableCL(){
        DefaultTableModel dtm = (DefaultTableModel) tblChatLieu.getModel();
        dtm.setRowCount(0);
        ArrayList<ChatLieuVM> ListSP = chatLieuService.getAll();
        
        for(ChatLieuVM clvm : ListSP){
            dtm.addRow(new Object[]{
            clvm.getId(),
            clvm.getMaCL(),
            clvm.getTenCL(),
            clvm.getTrangThaiCL()== 1 ? "Đang hoạt động" : "Dừng hoạt động"
            });
        }
    }
     
    public void LoadTableKC(){
         DefaultTableModel dtm = (DefaultTableModel) tblKichCo.getModel();
        dtm.setRowCount(0);
         ArrayList<KichCoVM> Listkc = kichCoService.getAll();
        
        for(KichCoVM kcvm : Listkc){
            dtm.addRow(new Object[]{
            kcvm.getId(),
            kcvm.getMaKC(),
            kcvm.getTenKC(),
            kcvm.getTrangThai()== 1 ? "Đang hoạt động" : "Dừng hoạt động"
            });
        }
    }
    
    public void LoadTableMS(){
         DefaultTableModel dtm = (DefaultTableModel) tblMauSac.getModel();
        dtm.setRowCount(0);
         ArrayList<MauSacVM> Listms = mauSacService.getAll();
        
        for(MauSacVM msvm : Listms){
            dtm.addRow(new Object[]{
            msvm.getId(),
            msvm.getMaMS(),
            msvm.getTenMS(),
            msvm.getTrangThai()== 1 ? "Đang hoạt động" : "Dừng hoạt động"
            });
        }
    }
    
    public void LoadTableTH(){
         DefaultTableModel dtm = (DefaultTableModel) tblThuongHieu.getModel();
        dtm.setRowCount(0);
         ArrayList<ThuongHieuVM> Listth = thuongHieuService.getAll();
        
        for(ThuongHieuVM thvm : Listth){
            dtm.addRow(new Object[]{
            thvm.getId(),
            thvm.getMaTH(),
            thvm.getTenTH(),
            thvm.getTrangThaiTH()== 1 ? "Đang hoạt động" : "Dừng hoạt động"
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ChatLieujDialog = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMaCL = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTenCL = new javax.swing.JTextField();
        btnThemCL = new javax.swing.JButton();
        btnSuaCL = new javax.swing.JButton();
        btnLamMoiCL = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        rdoHoatDongCL = new javax.swing.JRadioButton();
        rdoDHoatDongCL = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();
        txtTimCL = new javax.swing.JTextField();
        btnTimCL = new javax.swing.JButton();
        rdohd = new javax.swing.JRadioButton();
        rdodhd = new javax.swing.JRadioButton();
        btnMoiCL = new javax.swing.JButton();
        KichCojDialog = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtMaKC = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTenKC = new javax.swing.JTextField();
        btnThemKC = new javax.swing.JButton();
        btnSuaKC = new javax.swing.JButton();
        btnLamMoiKC = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        rdoHoatDongKC = new javax.swing.JRadioButton();
        rdoDHoatDongKC = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblKichCo = new javax.swing.JTable();
        txtTimKC = new javax.swing.JTextField();
        btnTimKC = new javax.swing.JButton();
        LOCHDKC = new javax.swing.JRadioButton();
        LocDHDKC = new javax.swing.JRadioButton();
        MoiKC = new javax.swing.JButton();
        MauSacjDialog = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtMaMS = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTenMS = new javax.swing.JTextField();
        btnThemMS = new javax.swing.JButton();
        btnSuaMS = new javax.swing.JButton();
        btnLamMoiMS = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        rdoHDMS = new javax.swing.JRadioButton();
        rdoDHDMS = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        txtTimMS = new javax.swing.JTextField();
        btnTimMS = new javax.swing.JButton();
        rdoLocHDMS = new javax.swing.JRadioButton();
        rdoLocDHDMS = new javax.swing.JRadioButton();
        btnMoiMS = new javax.swing.JButton();
        ThuongHieujDialog = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtMaTH = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtTenTH = new javax.swing.JTextField();
        btnThemTH = new javax.swing.JButton();
        btnSuaTH = new javax.swing.JButton();
        btnLamMoiTH = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        rdoHoatDongTH = new javax.swing.JRadioButton();
        rdoDHoatDongTH = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblThuongHieu = new javax.swing.JTable();
        txtTimTH = new javax.swing.JTextField();
        tbnTimTH2 = new javax.swing.JButton();
        rdoHDTH2 = new javax.swing.JRadioButton();
        rdoDHDTH2 = new javax.swing.JRadioButton();
        btnMoiTH = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTenSP1 = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        rdoCon = new javax.swing.JRadioButton();
        rdoHet = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaCTSP = new javax.swing.JTextField();
        txtSoLuongTon = new javax.swing.JTextField();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbKichCo = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbTH = new javax.swing.JComboBox<>();
        btnChatLieu = new javax.swing.JButton();
        btnKichCo = new javax.swing.JButton();
        btnMauSac = new javax.swing.JButton();
        btnTH = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        rdoconspct = new javax.swing.JRadioButton();
        rdohetspct = new javax.swing.JRadioButton();
        cbbTenSP = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamChiTiet = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();

        ChatLieujDialog.setMinimumSize(new java.awt.Dimension(500, 630));
        ChatLieujDialog.setModal(true);

        jPanel6.setBackground(new java.awt.Color(222, 229, 226));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Quản Lý Chất Liệu");

        jLabel18.setText("Mã CL :");

        jLabel19.setText("Tên CL :");

        btnThemCL.setText("Thêm");
        btnThemCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCLActionPerformed(evt);
            }
        });

        btnSuaCL.setText("Sửa");
        btnSuaCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCLActionPerformed(evt);
            }
        });

        btnLamMoiCL.setText("Làm mới");
        btnLamMoiCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiCLActionPerformed(evt);
            }
        });

        jLabel20.setText("Trạng thái :");

        rdoHoatDongCL.setText("Hoạt động");

        rdoDHoatDongCL.setText("Dừng hoạt động");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaCL)
                    .addComponent(txtTenCL))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHoatDongCL))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnThemCL)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rdoDHoatDongCL)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnSuaCL)
                        .addGap(40, 40, 40)
                        .addComponent(btnLamMoiCL)
                        .addContainerGap(37, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMaCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(rdoHoatDongCL)
                    .addComponent(rdoDHoatDongCL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCL)
                    .addComponent(btnSuaCL)
                    .addComponent(btnLamMoiCL))
                .addGap(151, 151, 151))
        );

        jPanel7.setBackground(new java.awt.Color(222, 229, 226));

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã CL", "Tên CL", "Trạng thái"
            }
        ));
        tblChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblChatLieu);

        btnTimCL.setText("Tìm");
        btnTimCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimCLActionPerformed(evt);
            }
        });

        rdohd.setText("Đang hoạt động");

        rdodhd.setText("Dừng hoạt động");

        btnMoiCL.setText("Mới");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimCL, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(rdohd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdodhd)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoiCL, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimCL))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimCL))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdohd)
                    .addComponent(rdodhd)
                    .addComponent(btnMoiCL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ChatLieujDialogLayout = new javax.swing.GroupLayout(ChatLieujDialog.getContentPane());
        ChatLieujDialog.getContentPane().setLayout(ChatLieujDialogLayout);
        ChatLieujDialogLayout.setHorizontalGroup(
            ChatLieujDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ChatLieujDialogLayout.setVerticalGroup(
            ChatLieujDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChatLieujDialogLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        KichCojDialog.setMinimumSize(new java.awt.Dimension(500, 625));
        KichCojDialog.setModal(true);

        jPanel8.setBackground(new java.awt.Color(222, 229, 226));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Quản Lý Kích Cỡ");

        jLabel22.setText("Mã KC :");

        jLabel23.setText("Tên KC :");

        btnThemKC.setText("Thêm");
        btnThemKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKCActionPerformed(evt);
            }
        });

        btnSuaKC.setText("Sửa");
        btnSuaKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKCActionPerformed(evt);
            }
        });

        btnLamMoiKC.setText("Làm mới");
        btnLamMoiKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiKCActionPerformed(evt);
            }
        });

        jLabel24.setText("Trạng thái :");

        rdoHoatDongKC.setText("Hoạt động");

        rdoDHoatDongKC.setText("Dừng hoạt động");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaKC)
                    .addComponent(txtTenKC))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnThemKC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaKC)
                .addGap(55, 55, 55)
                .addComponent(btnLamMoiKC)
                .addGap(30, 30, 30))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHoatDongKC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoDHoatDongKC))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMaKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTenKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(rdoHoatDongKC)
                    .addComponent(rdoDHoatDongKC))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKC)
                    .addComponent(btnSuaKC)
                    .addComponent(btnLamMoiKC))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(222, 229, 226));

        tblKichCo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã CL", "Tên CL", "Trạng thái"
            }
        ));
        tblKichCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKichCoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblKichCo);

        btnTimKC.setText("Tìm");
        btnTimKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKCActionPerformed(evt);
            }
        });

        LOCHDKC.setText("Đang hoạt động");

        LocDHDKC.setText("Dừng hoạt động");

        MoiKC.setText("Mới");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKC, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(LOCHDKC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LocDHDKC)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MoiKC, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKC))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKC))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LOCHDKC)
                    .addComponent(LocDHDKC)
                    .addComponent(MoiKC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout KichCojDialogLayout = new javax.swing.GroupLayout(KichCojDialog.getContentPane());
        KichCojDialog.getContentPane().setLayout(KichCojDialogLayout);
        KichCojDialogLayout.setHorizontalGroup(
            KichCojDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        KichCojDialogLayout.setVerticalGroup(
            KichCojDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KichCojDialogLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MauSacjDialog.setMinimumSize(new java.awt.Dimension(500, 625));
        MauSacjDialog.setModal(true);

        jPanel10.setBackground(new java.awt.Color(222, 229, 226));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("Quản Lý Màu Sắc");

        jLabel26.setText("Mã MS :");

        jLabel27.setText("Tên MS :");

        btnThemMS.setText("Thêm");
        btnThemMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMSActionPerformed(evt);
            }
        });

        btnSuaMS.setText("Sửa");
        btnSuaMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMSActionPerformed(evt);
            }
        });

        btnLamMoiMS.setText("Làm mới");
        btnLamMoiMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiMSActionPerformed(evt);
            }
        });

        jLabel28.setText("Trạng thái :");

        rdoHDMS.setText("Hoạt động");

        rdoDHDMS.setText("Dừng hoạt động");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaMS)
                    .addComponent(txtTenMS))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHDMS))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnThemMS)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rdoDHDMS)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnSuaMS)
                        .addGap(46, 46, 46)
                        .addComponent(btnLamMoiMS)
                        .addContainerGap(31, Short.MAX_VALUE))))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtMaMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtTenMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(rdoHDMS)
                    .addComponent(rdoDHDMS))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMS)
                    .addComponent(btnSuaMS)
                    .addComponent(btnLamMoiMS))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(222, 229, 226));

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã MS", "Tên MS", "Trạng thái"
            }
        ));
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblMauSac);

        btnTimMS.setText("Tìm");
        btnTimMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimMSActionPerformed(evt);
            }
        });

        rdoLocHDMS.setText("Đang hoạt động");

        rdoLocDHDMS.setText("Dừng hoạt động");

        btnMoiMS.setText("Mới");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimMS, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(rdoLocHDMS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoLocDHDMS)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoiMS, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimMS))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimMS))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoLocHDMS)
                    .addComponent(rdoLocDHDMS)
                    .addComponent(btnMoiMS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MauSacjDialogLayout = new javax.swing.GroupLayout(MauSacjDialog.getContentPane());
        MauSacjDialog.getContentPane().setLayout(MauSacjDialogLayout);
        MauSacjDialogLayout.setHorizontalGroup(
            MauSacjDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MauSacjDialogLayout.setVerticalGroup(
            MauSacjDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MauSacjDialogLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThuongHieujDialog.setMinimumSize(new java.awt.Dimension(500, 625));
        ThuongHieujDialog.setModal(true);

        jPanel12.setBackground(new java.awt.Color(222, 229, 226));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("Quản Lý Thương Hiệu");

        jLabel30.setText("Mã TH :");

        jLabel31.setText("Tên TH :");

        btnThemTH.setText("Thêm");
        btnThemTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTHActionPerformed(evt);
            }
        });

        btnSuaTH.setText("Sửa");
        btnSuaTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTHActionPerformed(evt);
            }
        });

        btnLamMoiTH.setText("Làm mới");
        btnLamMoiTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiTHActionPerformed(evt);
            }
        });

        jLabel32.setText("Trạng thái :");

        rdoHoatDongTH.setText("Hoạt động");

        rdoDHoatDongTH.setText("Dừng hoạt động");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaTH)
                    .addComponent(txtTenTH))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHoatDongTH))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnThemTH)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(rdoDHoatDongTH)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnSuaTH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(btnLamMoiTH)
                        .addGap(56, 56, 56))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(99, 99, 99))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtTenTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(rdoHoatDongTH)
                    .addComponent(rdoDHoatDongTH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTH)
                    .addComponent(btnSuaTH)
                    .addComponent(btnLamMoiTH))
                .addGap(151, 151, 151))
        );

        jPanel15.setBackground(new java.awt.Color(222, 229, 226));

        tblThuongHieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã TH", "Tên TH", "Trạng thái"
            }
        ));
        tblThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuongHieuMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblThuongHieu);

        tbnTimTH2.setText("Tìm");
        tbnTimTH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnTimTH2ActionPerformed(evt);
            }
        });

        rdoHDTH2.setText("Đang hoạt động");

        rdoDHDTH2.setText("Dừng hoạt động");

        btnMoiTH.setText("Mới");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimTH, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(rdoHDTH2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoDHDTH2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoiTH, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnTimTH2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnTimTH2))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHDTH2)
                    .addComponent(rdoDHDTH2)
                    .addComponent(btnMoiTH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ThuongHieujDialogLayout = new javax.swing.GroupLayout(ThuongHieujDialog.getContentPane());
        ThuongHieujDialog.getContentPane().setLayout(ThuongHieujDialogLayout);
        ThuongHieujDialogLayout.setHorizontalGroup(
            ThuongHieujDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ThuongHieujDialogLayout.setVerticalGroup(
            ThuongHieujDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThuongHieujDialogLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(222, 231, 227));

        jPanel5.setBackground(new java.awt.Color(222, 229, 226));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Quản Lý Sản Phẩm");

        jLabel9.setText("Mã SP :");

        jLabel10.setText("Tên SP :");

        btnThemSP.setText("Thêm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnSuaSP.setText("Sửa");

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        tblSanPham.setBackground(new java.awt.Color(222, 229, 226));
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Trạng thái"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSanPham);

        jLabel13.setText("Trạng thái :");

        jLabel14.setText("Tìm theo mã sản phẩm :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("Tìm");

        rdoCon.setText("Còn hàng");

        rdoHet.setText("Hết hàng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoCon)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoHet)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnThemSP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSuaSP)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnLamMoi)
                                        .addGap(16, 16, 16))
                                    .addComponent(txtTenSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnThemSP)
                    .addComponent(btnSuaSP)
                    .addComponent(btnLamMoi)
                    .addComponent(rdoCon)
                    .addComponent(rdoHet))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thông Tin Sản Phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(222, 231, 227));

        jPanel3.setBackground(new java.awt.Color(222, 231, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý thông tin"));

        jLabel1.setText("Mã sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel4.setText("Số lượng Tồn");

        jLabel5.setText("Chất liệu");

        jLabel6.setText("Kích cỡ");

        jLabel7.setText("Màu sắc");

        jLabel8.setText("Thương Hiệu");

        txtMaCTSP.setEditable(false);

        txtSoLuongTon.setText("0");
        txtSoLuongTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongTonActionPerformed(evt);
            }
        });

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn chất liệu..." }));

        cbbKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn kích cỡ..." }));

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn màu sắc..." }));

        cbbTH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn TH..." }));
        cbbTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTHActionPerformed(evt);
            }
        });

        btnChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tshirt.png"))); // NOI18N
        btnChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChatLieuMouseClicked(evt);
            }
        });
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        btnKichCo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/measurement.png"))); // NOI18N
        btnKichCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKichCoMouseClicked(evt);
            }
        });
        btnKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichCoActionPerformed(evt);
            }
        });

        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wheel.png"))); // NOI18N
        btnMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMauSacMouseClicked(evt);
            }
        });
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        btnTH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        btnTH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTHMouseClicked(evt);
            }
        });
        btnTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTHActionPerformed(evt);
            }
        });

        jLabel12.setText("Đơn giá");

        txtDonGia.setText("0");

        jLabel15.setText("Người tạo");

        jLabel16.setText("Trạng thái");

        buttonGroup1.add(rdoconspct);
        rdoconspct.setText("Còn hàng");

        buttonGroup1.add(rdohetspct);
        rdohetspct.setText("Hết hàng");

        cbbTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn sản phẩm..." }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(cbbTenSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel16))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSoLuongTon, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(txtNguoiTao)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(rdoconspct)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdohetspct)))))
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbTH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChatLieu, 0, 174, Short.MAX_VALUE)
                            .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbKichCo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnMauSac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(btnTH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKichCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnKichCo))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMauSac)))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTH)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbbTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnChatLieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(rdoconspct)
                    .addComponent(rdohetspct)
                    .addComponent(jLabel12)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(222, 231, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        tblSanPhamChiTiet.setBackground(new java.awt.Color(222, 231, 227));
        tblSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SPCT", "Tên SP", "SL Tồn", "Người tạo", "Trạng thái", "Kích cỡ", "Màu sắc", "Thương hiệu", "Chất liệu", "Đơn giá"
            }
        ));
        tblSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamChiTiet);

        jLabel11.setText("Tìm kiếm sản phẩm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setText("Làm Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(40, 40, 40)
                        .addComponent(btnSua)
                        .addGap(45, 45, 45)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnMoi))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Chi Tiết Sản Phẩm", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String MaSPCT = txtMaCTSP.getText();
        UUID TenSP = spctrp.SelectSPByTen(txtTenSP1.getText());
        String SoLuongTon = txtSoLuongTon.getText();
        String NguoiTao = txtNguoiTao.getText();
        int TrangThai = rdoCon.isSelected()== true ? 1 : 0;
        UUID TenCL = ((ChatLieuVM) cbbChatLieu.getSelectedItem()).getId();
        UUID TenKC = ((KichCoVM) cbbKichCo.getSelectedItem()).getId();
        UUID TenMS = ((MauSacVM) cbbMauSac.getSelectedItem()).getId();
        UUID TenTH = ((ThuongHieuVM) cbbTH.getSelectedItem()).getId();
        String DonGia = txtDonGia.getText();

        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setMaSPCT(MaSPCT);
        spct.setIdSP(TenSP);
        spct.setSoLuongTon(Integer.valueOf(SoLuongTon));
        spct.setNguoiTao(NguoiTao);
        spct.setTrangThaiSPCT(TrangThai);
        spct.setIdCL(TenCL);
        spct.setIdKC(TenKC);
        spct.setIdMS(TenMS);
        spct.setIdTH(TenTH);
        spct.setDonGia(Float.valueOf(DonGia));

        this.SPCTService.add(spct);
        LamMoi();
        this.LoadTableSPCT();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        ArrayList<SPCTVM> listSPCTVM = SPCTService.getAll();
        String TimKiem = this.txtTimKiem.getText();
        int index = -1;
        for (SPCTVM nvvm : listSPCTVM) {
            if (TimKiem.equalsIgnoreCase(nvvm.getMaSPCT())) {
                index = listSPCTVM.indexOf(nvvm);
            }
        }

        if(index==-1){
            JOptionPane.showMessageDialog(this, "Không tìm thấy !");
            return;
        }
        txtMaCTSP.setText(listSPCTVM.get(index).getMaSPCT());
        cbbTenSP.setSelectedItem(listSPCTVM.get(index).getTenSP());
        txtSoLuongTon.setText(String.valueOf(listSPCTVM.get(index).getSoLuongTon()));
        txtNguoiTao.setText(listSPCTVM.get(index).getNguoiTao());
        rdoconspct.setSelected(true);
        cbbKichCo.setSelectedItem(listSPCTVM.get(index).getTenKC());
        cbbMauSac.setSelectedItem(listSPCTVM.get(index).getTenMS());
        cbbTH.setSelectedItem(listSPCTVM.get(index).getTenTH());
        cbbChatLieu.setSelectedItem(listSPCTVM.get(index).getTenCL());
        txtDonGia.setText(String.valueOf(listSPCTVM.get(index).getDonGia()));
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamChiTietMouseClicked
        int row = tblSanPhamChiTiet.getSelectedRow();
        if (row == -1) {
            return;
        }

        if (Optional.ofNullable(tblSanPhamChiTiet.getValueAt(row, 4)).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được null");
            return;
        }

        String MaCTSP = tblSanPhamChiTiet.getValueAt(row, 0).toString();
        String TenSP = tblSanPhamChiTiet.getValueAt(row, 1).toString();
        String SoLuongTon = tblSanPhamChiTiet.getValueAt(row, 2).toString();
        String NguoiTao = tblSanPhamChiTiet.getValueAt(row, 3).toString();
        String TrangThaiSPCT = tblSanPhamChiTiet.getValueAt(row, 4).toString();

        String TenKC = tblSanPhamChiTiet.getValueAt(row, 5).toString();
        String TenMS = tblSanPhamChiTiet.getValueAt(row, 6).toString();
        String TenTH = tblSanPhamChiTiet.getValueAt(row, 7).toString();
        String TenCL = tblSanPhamChiTiet.getValueAt(row, 8).toString();
        String DonGia = tblSanPhamChiTiet.getValueAt(row, 9).toString();

        txtMaCTSP.setText(MaCTSP);
        dcbbtsp.setSelectedItem(sanPhamService.getAll().stream().filter(i -> i.getTenSP().equalsIgnoreCase(TenSP)).findFirst().get());
        txtSoLuongTon.setText(SoLuongTon);
        txtNguoiTao.setText(NguoiTao);
        if (TrangThaiSPCT.equalsIgnoreCase("Đang hoạt động")) {
            this.rdoconspct.setSelected(true);
        } else {
            this.rdohetspct.setSelected(true);
        }
        dcbbmcl.setSelectedItem(chatLieuService.getAll().stream().filter(i -> i.getTenCL().equalsIgnoreCase(TenCL)).findFirst().get());
        dcbbmkc.setSelectedItem(kichCoService.getAll().stream().filter(i -> i.getTenKC().equals(TenKC)).findFirst().get());
        dcbbmms.setSelectedItem(mauSacService.getAll().stream().filter(i -> i.getTenMS().equals(TenMS)).findFirst().get());
        dcbbmth.setSelectedItem(thuongHieuService.getAll().stream().filter(i -> i.getTenTH().equals(TenTH)).findFirst().get());
        txtDonGia.setText(DonGia);
    }//GEN-LAST:event_tblSanPhamChiTietMouseClicked

    private void btnTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTHActionPerformed
        ThuongHieujDialog.setLocationRelativeTo(this);
        ThuongHieujDialog.setVisible(true);
    }//GEN-LAST:event_btnTHActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        MauSacjDialog.setVisible(true);
        MauSacjDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichCoActionPerformed
        KichCojDialog.setVisible(true);
        KichCojDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnKichCoActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        ChatLieujDialog.setVisible(true);
        ChatLieujDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP1.getText();
        int TrangThai = rdoCon.isSelected() == true ? 1 : 0;

        SanPham sp = new SanPham();
        sp.setMaSP(MaSP);
        sp.setTenSP(TenSP);
        sp.setTrangThaiSP(TrangThai);

        this.sanPhamService.add(sp);
        MoiSP();
        this.LoadTableSP();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnKichCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKichCoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKichCoMouseClicked

    private void btnMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMauSacMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMauSacMouseClicked

    private void btnTHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTHMouseClicked

    private void btnChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChatLieuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChatLieuMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String MaSPCT = txtMaCTSP.getText();
        UUID TenSP = ((SanPhamVM) cbbTenSP.getSelectedItem()).getId();
        String SoLuongTon = txtSoLuongTon.getText();
        String NguoiTao = txtNguoiTao.getText();
        int TrangThai = rdoCon.isSelected()== true ? 1 : 0;
        UUID TenCL = ((ChatLieuVM) cbbChatLieu.getSelectedItem()).getId();
        UUID TenKC = ((KichCoVM) cbbKichCo.getSelectedItem()).getId();
        UUID TenMS = ((MauSacVM) cbbMauSac.getSelectedItem()).getId();
        UUID TenTH = ((ThuongHieuVM) cbbTH.getSelectedItem()).getId();
        String DonGia = txtDonGia.getText();

        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setMaSPCT(MaSPCT);
        spct.setIdSP(TenSP);
        spct.setSoLuongTon(Integer.valueOf(SoLuongTon));
        spct.setNguoiTao(NguoiTao);
        spct.setTrangThaiSPCT(TrangThai);
        spct.setIdCL(TenCL);
        spct.setIdKC(TenKC);
        spct.setIdMS(TenMS);
        spct.setIdTH(TenTH);
        spct.setDonGia(Float.valueOf(DonGia));

        this.SPCTService.update(spct);
        LamMoi();
        this.LoadTableSPCT();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCLActionPerformed
        String MaCL = txtMaCL.getText();
        String TenCL = txtMaCL.getText();

        ChatLieu cl = new ChatLieu();
        cl.setMaCL(MaCL);
        cl.setTenCL(TenCL);

        chatLieuService.add(cl);
        LamMoi();
        LoadTableCL();
    }//GEN-LAST:event_btnThemCLActionPerformed

    private void btnSuaCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCLActionPerformed
        String MaCL = txtMaCL.getText();
        String TenCL = txtMaCL.getText();

        ChatLieu cl = new ChatLieu();
        cl.setMaCL(MaCL);
        cl.setTenCL(TenCL);

        chatLieuService.update(cl);
        LamMoi();
        LoadTableCL();
    }//GEN-LAST:event_btnSuaCLActionPerformed

    private void btnLamMoiCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiCLActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnLamMoiCLActionPerformed

    private void tblChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuMouseClicked
        int row = tblChatLieu.getSelectedRow();
        if(row == -1){
            return;
        }

        String MaSP = tblChatLieu.getValueAt(row, 1).toString();
        String TenSP = tblChatLieu.getValueAt(row, 2).toString();
        String TrangThai = tblChatLieu.getValueAt(row, 3).toString();

        txtMaCL.setText(MaSP);
        txtTenCL.setText(TenSP);
        if(TrangThai.equalsIgnoreCase("Đang Hoạt Động")){
            this.rdoHoatDongCL.setSelected(true);
        }else{
            this.rdoDHoatDongCL.setSelected(true);
        }
    }//GEN-LAST:event_tblChatLieuMouseClicked

    private void btnTimCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimCLActionPerformed
        ArrayList<ChatLieuVM> listCLVM = chatLieuService.getAll();
        String TimKiem = this.txtTimCL.getText();
        int index = -1;
        for (ChatLieuVM clvm : listCLVM) {
            if (TimKiem.equalsIgnoreCase(clvm.getMaCL())) {
                index = listCLVM.indexOf(clvm);
            }
        }

        if(index==-1){
            JOptionPane.showMessageDialog(this, "Không tìm thấy !");
            return;
        }
        txtMaCL.setText(listCLVM.get(index).getMaCL());
        txtTenCL.setText(listCLVM.get(index).getTenCL());
        rdoHoatDongCL.setSelected(true);
    }//GEN-LAST:event_btnTimCLActionPerformed

    private void btnThemKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKCActionPerformed
        String MaKC = txtMaKC.getText();
        String TenKC = txtMaKC.getText();

        KichCo kc = new KichCo();
        kc.setMaKC(MaKC);
        kc.setTenKC(TenKC);

        kichCoService.add(kc);
        LamMoi();
        LoadTableKC();
    }//GEN-LAST:event_btnThemKCActionPerformed

    private void btnSuaKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKCActionPerformed
        String MaKC = txtMaKC.getText();
        String TenKC = txtMaKC.getText();

        KichCo kc = new KichCo();
        kc.setMaKC(MaKC);
        kc.setTenKC(TenKC);

        kichCoService.update(kc);
        LamMoi();
        LoadTableKC();
    }//GEN-LAST:event_btnSuaKCActionPerformed

    private void btnLamMoiKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiKCActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnLamMoiKCActionPerformed

    private void tblKichCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKichCoMouseClicked
        int row = tblKichCo.getSelectedRow();
        if(row == -1){
            return;
        }

        String MaSP = tblKichCo.getValueAt(row, 1).toString();
        String TenSP = tblKichCo.getValueAt(row, 2).toString();
        String TrangThai = tblKichCo.getValueAt(row, 3).toString();

        txtMaKC.setText(MaSP);
        txtTenKC.setText(TenSP);
        if(TrangThai.equalsIgnoreCase("Đang Hoạt Động")){
            this.rdoHoatDongCL.setSelected(true);
        }else{
            this.rdoDHoatDongCL.setSelected(true);
        }
    }//GEN-LAST:event_tblKichCoMouseClicked

    private void btnTimKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKCActionPerformed
        ArrayList<KichCoVM> listKCVM = kichCoService.getAll();
        String TimKiem = this.txtTimCL.getText();
        int index = -1;
        for (KichCoVM clvm : listKCVM) {
            if (TimKiem.equalsIgnoreCase(clvm.getMaKC())) {
                index = listKCVM.indexOf(clvm);
            }
        }

        if(index==-1){
            JOptionPane.showMessageDialog(this, "Không tìm thấy !");
            return;
        }
        txtMaKC.setText(listKCVM.get(index).getMaKC());
        txtTenKC.setText(listKCVM.get(index).getTenKC());
        rdoHoatDongCL.setSelected(true);
    }//GEN-LAST:event_btnTimKCActionPerformed

    private void btnThemMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMSActionPerformed
        String MaMS = txtMaMS.getText();
        String TenMS = txtTenMS.getText();

        MauSac ms = new MauSac();
        ms.setMaMS(MaMS);
        ms.setTenMS(TenMS);

        mauSacService.add(ms);
        LamMoi();
        LoadTableMS();
    }//GEN-LAST:event_btnThemMSActionPerformed

    private void btnSuaMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMSActionPerformed
        String MaMS = txtMaMS.getText();
        String TenMS = txtTenMS.getText();

        MauSac ms = new MauSac();
        ms.setMaMS(MaMS);
        ms.setTenMS(TenMS);

        mauSacService.update(ms);
        LamMoi();
        LoadTableMS();
    }//GEN-LAST:event_btnSuaMSActionPerformed

    private void btnLamMoiMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiMSActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnLamMoiMSActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        int row = tblMauSac.getSelectedRow();
        if(row == -1){
            return;
        }

        String MaSP = tblMauSac.getValueAt(row, 1).toString();
        String TenSP = tblMauSac.getValueAt(row, 2).toString();
        String TrangThai = tblMauSac.getValueAt(row, 3).toString();

        txtMaMS.setText(MaSP);
        txtTenMS.setText(TenSP);
        if(TrangThai.equalsIgnoreCase("Đang Hoạt Động")){
            this.rdoHDMS.setSelected(true);
        }else{
            this.rdoDHDMS.setSelected(true);
        }
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void btnTimMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimMSActionPerformed
        ArrayList<MauSacVM> listMSVM = mauSacService.getAll();
        String TimKiem = this.txtTimCL.getText();
        int index = -1;
        for (MauSacVM msvm : listMSVM) {
            if (TimKiem.equalsIgnoreCase(msvm.getMaMS())) {
                index = listMSVM.indexOf(msvm);
            }
        }

        if(index==-1){
            JOptionPane.showMessageDialog(this, "Không tìm thấy !");
            return;
        }
        txtMaMS.setText(listMSVM.get(index).getMaMS());
        txtTenMS.setText(listMSVM.get(index).getTenMS());
        rdoHDMS.setSelected(true);
    }//GEN-LAST:event_btnTimMSActionPerformed

    private void btnThemTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTHActionPerformed
        String MaTH = txtMaTH.getText();
        String TenTH = txtTenTH.getText();

        ThuongHieu th = new ThuongHieu();
        th.setMaTH(MaTH);
        th.setTenTH(TenTH);

        thuongHieuService.add(th);
        LamMoi();
        LoadTableTH();
    }//GEN-LAST:event_btnThemTHActionPerformed

    private void btnSuaTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTHActionPerformed
        String MaTH = txtMaTH.getText();
        String TenTH = txtTenTH.getText();

        ThuongHieu th = new ThuongHieu();
        th.setMaTH(MaTH);
        th.setTenTH(TenTH);

        thuongHieuService.update(th);
        LamMoi();
        LoadTableTH();
    }//GEN-LAST:event_btnSuaTHActionPerformed

    private void btnLamMoiTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiTHActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnLamMoiTHActionPerformed

    private void tblThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuongHieuMouseClicked
        int row = tblThuongHieu.getSelectedRow();
        if(row == -1){
            return;
        }

        String MaTH = tblThuongHieu.getValueAt(row, 1).toString();
        String TenTH = tblThuongHieu.getValueAt(row, 2).toString();
        String TrangThai = tblThuongHieu.getValueAt(row, 3).toString();

        txtMaTH.setText(MaTH);
        txtTenTH.setText(TenTH);
        if(TrangThai.equalsIgnoreCase("Đang Hoạt Động")){
            this.rdoHoatDongCL.setSelected(true);
        }else{
            this.rdoDHoatDongCL.setSelected(true);
        }
    }//GEN-LAST:event_tblThuongHieuMouseClicked

    private void tbnTimTH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnTimTH2ActionPerformed
        ArrayList<ThuongHieuVM> listTHVM = thuongHieuService.getAll();
        String TimKiem = this.txtTimCL.getText();
        int index = -1;
        for (ThuongHieuVM msvm : listTHVM) {
            if (TimKiem.equalsIgnoreCase(msvm.getMaTH())) {
                index = listTHVM.indexOf(msvm);
            }
        }

        if(index==-1){
            JOptionPane.showMessageDialog(this, "Không tìm thấy !");
            return;
        }
        txtMaTH.setText(listTHVM.get(index).getMaTH());
        txtTenTH.setText(listTHVM.get(index).getTenTH());
        rdoHoatDongCL.setSelected(true);
    }//GEN-LAST:event_tbnTimTH2ActionPerformed
    
    public void LamMoi() {
        txtMaCTSP.setText("");
        cbbTenSP.setSelectedIndex(0);
        txtSoLuongTon.setText("0");
        cbbChatLieu.setSelectedIndex(0);
        cbbKichCo.setSelectedIndex(0);
        cbbMauSac.setSelectedIndex(0);
        txtNguoiTao.setText("0");
        cbbTH.setSelectedIndex(0);
        rdoconspct.setSelected(true);
        txtDonGia.setText("0");
    }
    
    public void MoiSP(){
        txtMaSP.setText("");
        txtTenSP1.setText("");
        rdoCon.setSelected(true);
    }
    
    public void LamMoiCL(){
        txtMaCL.setText("");
        txtTenCL.setText("");
        rdoHoatDongCL.setSelected(true);
    }
    
    public void LamMoiKC(){
        txtMaKC.setText("");
        txtTenKC.setText("");
        rdoHoatDongKC.setSelected(true);
    }
    
    public void LamMoiMS(){
        txtMaMS.setText("");
        txtTenMS.setText("");
        rdoHDMS.setSelected(true);
    }
    
    public void LamMoiTH(){
        txtMaTH.setText("");
        txtTenTH.setText("");
        rdoHoatDongTH.setSelected(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ChatLieujDialog;
    private javax.swing.JDialog KichCojDialog;
    private javax.swing.JRadioButton LOCHDKC;
    private javax.swing.JRadioButton LocDHDKC;
    private javax.swing.JDialog MauSacjDialog;
    private javax.swing.JButton MoiKC;
    private javax.swing.JDialog ThuongHieujDialog;
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnKichCo;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiCL;
    private javax.swing.JButton btnLamMoiKC;
    private javax.swing.JButton btnLamMoiMS;
    private javax.swing.JButton btnLamMoiTH;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnMoiCL;
    private javax.swing.JButton btnMoiMS;
    private javax.swing.JButton btnMoiTH;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaCL;
    private javax.swing.JButton btnSuaKC;
    private javax.swing.JButton btnSuaMS;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnSuaTH;
    private javax.swing.JButton btnTH;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemCL;
    private javax.swing.JButton btnThemKC;
    private javax.swing.JButton btnThemMS;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnThemTH;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTimCL;
    private javax.swing.JButton btnTimKC;
    private javax.swing.JButton btnTimMS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbKichCo;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbTH;
    private javax.swing.JComboBox<String> cbbTenSP;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoDHDMS;
    private javax.swing.JRadioButton rdoDHDTH2;
    private javax.swing.JRadioButton rdoDHoatDongCL;
    private javax.swing.JRadioButton rdoDHoatDongKC;
    private javax.swing.JRadioButton rdoDHoatDongTH;
    private javax.swing.JRadioButton rdoHDMS;
    private javax.swing.JRadioButton rdoHDTH2;
    private javax.swing.JRadioButton rdoHet;
    private javax.swing.JRadioButton rdoHoatDongCL;
    private javax.swing.JRadioButton rdoHoatDongKC;
    private javax.swing.JRadioButton rdoHoatDongTH;
    private javax.swing.JRadioButton rdoLocDHDMS;
    private javax.swing.JRadioButton rdoLocHDMS;
    private javax.swing.JRadioButton rdoconspct;
    private javax.swing.JRadioButton rdodhd;
    private javax.swing.JRadioButton rdohd;
    private javax.swing.JRadioButton rdohetspct;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTable tblKichCo;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPhamChiTiet;
    private javax.swing.JTable tblThuongHieu;
    private javax.swing.JButton tbnTimTH2;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaCL;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaKC;
    private javax.swing.JTextField txtMaMS;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaTH;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenCL;
    private javax.swing.JTextField txtTenKC;
    private javax.swing.JTextField txtTenMS;
    private javax.swing.JTextField txtTenSP1;
    private javax.swing.JTextField txtTenTH;
    private javax.swing.JTextField txtTimCL;
    private javax.swing.JTextField txtTimKC;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimMS;
    private javax.swing.JTextField txtTimTH;
    // End of variables declaration//GEN-END:variables
}
