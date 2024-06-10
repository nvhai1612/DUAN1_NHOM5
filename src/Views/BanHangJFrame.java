/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModel.HoaDon;
import DomainModel.SanPhamChiTiet;
import Repository.Impl.HoaDonRepos;
import Repository.Impl.SPCTRepos;
import Service.Impl.ChatLieuService;
import Service.Impl.HoaDonService;
import Service.Impl.KichCoService;
import Service.Impl.MauSacService;
import Service.Impl.SPCTService;
import Service.Impl.SanPhamService;
import Service.Impl.ThuongHieuService;
import ViewModel.HoaDonVM;
import ViewModel.SPCTVM;
import java.awt.CardLayout;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BanHangJFrame extends javax.swing.JFrame {

    private SPCTService SPCTService = new SPCTService();
    private MauSacService mauSacService = new MauSacService();
    private ChatLieuService chatLieuService = new ChatLieuService();
    private KichCoService kichCoService = new KichCoService();
    private ThuongHieuService nSXService = new ThuongHieuService();
    private SanPhamService sanPhamService = new SanPhamService();
    private HoaDonService hoaDonService = new HoaDonService();
    private ArrayList<SPCTVM> listSPCT = new ArrayList<>();
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
//    private ChiTietSanPhamJFrame ctspjp = new ChiTietSanPhamJFrame();

    CardLayout card;

    private DefaultComboBoxModel dcbbpttt;

    DefaultTableModel dtmsp = new DefaultTableModel();
    DefaultTableModel dtmgh = new DefaultTableModel();
    DefaultTableModel dtmhd = new DefaultTableModel();
    Map<String, Integer> Sps = new HashMap<>();

    HoaDonRepos hoaDonRes = new HoaDonRepos();

    /**
     * Creates new form BanHangJFrame
     */
    public BanHangJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        LoadTableHoaDon();
        LoadTableSanPham();
        LoadTableGioHang();
        
    }

    public BanHangJFrame(String MaNV) {
        initComponents();
        card = (CardLayout) pnlCards.getLayout();
        card.show(pnlCards, "pnlBanHang");
        setLocationRelativeTo(null);
        LoadTableHoaDon();
//        ctspjp.LoadTable();
        LoadTableSanPham();
        LoadTableGioHang();
        txtNguoiDung.setText(MaNV);
    }

    private void LoadTableSanPham() {
        dtmsp = (DefaultTableModel) tblDanhSachSP.getModel();
        dtmsp.setRowCount(0);

        ArrayList<SPCTVM> listCTSPVM = SPCTService.getAll();
        for (SPCTVM ctspvm : listCTSPVM) {
            dtmsp.addRow(new Object[]{
                ctspvm.getMaSPCT(),
                ctspvm.getTenSP(),
                ctspvm.getTenCL(),
                ctspvm.getTenKC(),
                ctspvm.getTenMS(),
                ctspvm.getTenTH(),
                ctspvm.getSoLuongTon(),
                ctspvm.getDonGia(),});
        }
    }

    private void LoadTableGioHang() {
        dtmgh = (DefaultTableModel) tblGioHang.getModel();
        dtmgh.setRowCount(0);

        ArrayList<SPCTVM> listSPCTVM = listSPCT;

        for (SPCTVM ctspvm : listSPCTVM) {
            dtmgh.addRow(new Object[]{
                ctspvm.getMaSPCT(),
                ctspvm.getTenSP(),
                ctspvm.getSoLuongTon(),
                ctspvm.getDonGia(),
                new BigDecimal(ctspvm.getSoLuongTon() * ctspvm.getDonGia()),});
        }
    }

    private void LoadTableHoaDon() {
        dtmhd = (DefaultTableModel) tblHoaDon.getModel();
        dtmhd.setRowCount(0);

        ArrayList<HoaDonVM> listHDVM = hoaDonService.getAll().isEmpty() ? hoaDonService.getAllHoaDon() : hoaDonService.getAll();
        for (HoaDonVM hdvm : listHDVM) {
            dtmhd.addRow(new Object[]{
                hdvm.getMaHD(),
                hdvm.getTenNV(),
                
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(hdvm.getNgayTao()),
                hdvm.getTrangThaiHD() == 1 ? "Chờ thanh toán" : "Đã thanh toán"
            });
        }
    }

    private void LoadHoaDonCho(String MaHD) {
        dtmgh = (DefaultTableModel) tblGioHang.getModel();
        dtmgh.setRowCount(0);

        ArrayList<SanPhamChiTiet> listHDC = hoaDonService.HoaDonCho(MaHD);
        for (SanPhamChiTiet spct : listHDC) {
            dtmgh.addRow(new Object[]{
                spct.getMaSPCT(),
                spct.getTenSP(),
                spct.getSoLuongTon(),
                spct.getDonGia(),
                new BigDecimal(spct.getDonGia() * spct.getSoLuongTon()),});
        }
        TinhTien();
    }
    
    //    private void updateTrangThaiHoaDon(String maHDCT, Integer TrangThaiHD, Double TongTien, String mahd) {
    //        dtmgh = (DefaultTableModel) tblGioHang.getModel();
    //        dtmgh.setRowCount(0);
    //
    //        ArrayList<HoaDon> listUpdateTTHD = hoaDonService.updateTrangThaiHoaDon(maHDCT, TrangThaiHD, TongTien, mahd);
    //        for (SanPhamChiTiet spct : listHDC) {
    //            dtmgh.addRow(new Object[]{
    //                spct.getMaSPCT(),
    //                spct.getTenSP(),
    //                spct.getSoLuongTon(),
    //                spct.getDonGia(),
    //                new BigDecimal(spct.getDonGia() * spct.getSoLuongTon()),});
    //        }
    //        TinhTien();
    //    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        txtTenKHTaiQuay4 = new javax.swing.JTextField();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        txtSDTTQ3 = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        txtTongTien4 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtDacQuyenTQ3 = new javax.swing.JLabel();
        txtCanThanhToanTQ3 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        cboTTTaiQuay3 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        txtTienKhachDuaTQ4 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtTienThua3 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        btnThanhToan4 = new javax.swing.JButton();
        btnTaoHoaDon4 = new javax.swing.JButton();
        btnHuy4 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTenKHDH = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtSDTDH = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtTongTienDH = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDacQuyenDH = new javax.swing.JLabel();
        txtCTTDH = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboTTDatHang = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtTKDDH = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtTienThuaDH = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        btnGiaoHang = new javax.swing.JButton();
        btnDaGiao = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txtDiaChiDH = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        btnThanhToan3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnlCards = new javax.swing.JPanel();
        pnlBanHang = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnSuaGH = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhSachSP = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jSeparator29 = new javax.swing.JSeparator();
        jLabel56 = new javax.swing.JLabel();
        txtSDTKH = new javax.swing.JTextField();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel57 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtKhuyenMai = new javax.swing.JLabel();
        txtCanThanhToan = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        cbbPTTT = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        jSeparator33 = new javax.swing.JSeparator();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnChonKH = new javax.swing.JButton();
        jSeparator34 = new javax.swing.JSeparator();
        btnThanhToan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBanHang = new javax.swing.JButton();
        btnLichSu = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtNguoiDung = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel14.setBackground(new java.awt.Color(222, 231, 227));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo hoá đơn"));

        jTabbedPane4.setBackground(new java.awt.Color(222, 231, 227));

        jPanel15.setBackground(new java.awt.Color(222, 231, 227));

        jLabel45.setText("Tên KH");

        txtTenKHTaiQuay4.setBackground(new java.awt.Color(222, 231, 227));
        txtTenKHTaiQuay4.setBorder(null);
        

        jLabel46.setText("SĐT");

        txtSDTTQ3.setBackground(new java.awt.Color(222, 231, 227));
        txtSDTTQ3.setBorder(null);
        

        jLabel47.setText("Tổng tiền: ");

        txtTongTien4.setText("0");

        jLabel48.setText("Đặc quyền KH (%):");

        txtDacQuyenTQ3.setText("0");

        txtCanThanhToanTQ3.setText("0");

        jLabel49.setText("Cần thanh toán:");

        jLabel50.setText("Hình thức");

        cboTTTaiQuay3.setBackground(new java.awt.Color(222, 231, 227));
        cboTTTaiQuay3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        

        jLabel51.setText("Tiền khách đưa");

        txtTienKhachDuaTQ4.setBackground(new java.awt.Color(222, 231, 227));
        txtTienKhachDuaTQ4.setBorder(null);
        

        jLabel52.setText("Tiền thừa");

        txtTienThua3.setText("0");

        btnThanhToan4.setText("Thanh toán");
        btnThanhToan4.setEnabled(false);
        

        btnTaoHoaDon4.setText("Tạo HD");
        

        btnHuy4.setText("Huỷ");
        

        jButton4.setText("Chọn KH");
        

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDTTQ3)
                                    .addComponent(jSeparator24)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator23)
                                    .addComponent(txtTenKHTaiQuay4)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator26)
                                    .addComponent(txtTienKhachDuaTQ4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienThua3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator27)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDacQuyenTQ3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboTTTaiQuay3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                            .addComponent(jLabel49)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCanThanhToanTQ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                            .addComponent(jLabel47)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton4)
                                                .addComponent(txtTongTien4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnThanhToan4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                            .addComponent(btnTaoHoaDon4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnHuy4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtTenKHTaiQuay4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtSDTTQ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtTongTien4))
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtDacQuyenTQ3))
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtCanThanhToanTQ3))
                .addGap(9, 9, 9)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(cboTTTaiQuay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(txtTienKhachDuaTQ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtTienThua3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Tại quầy", jPanel15);

        jPanel16.setBackground(new java.awt.Color(222, 231, 227));

        jLabel3.setText("Tên KH");

        txtTenKHDH.setBackground(new java.awt.Color(222, 231, 227));
        txtTenKHDH.setBorder(null);
        

        jLabel4.setText("SĐT");

        txtSDTDH.setBackground(new java.awt.Color(222, 231, 227));
        txtSDTDH.setBorder(null);
        

        jLabel5.setText("Tổng tiền: ");

        txtTongTienDH.setText("0");

        jLabel7.setText("Đặc quyền KH (%):");

        txtDacQuyenDH.setText("0");

        txtCTTDH.setText("0");

        jLabel10.setText("Cần thanh toán:");

        jLabel11.setText("Hình thức");

        cboTTDatHang.setBackground(new java.awt.Color(222, 231, 227));
        cboTTDatHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        

        jLabel12.setText("Tiền khách đưa");

        txtTKDDH.setBackground(new java.awt.Color(222, 231, 227));
        txtTKDDH.setBorder(null);
        

        jLabel53.setText("Tiền thừa");

        txtTienThuaDH.setText("0");

        jButton5.setText("Tạo hoá đơn");
        

        btnGiaoHang.setText("Giao hàng");
        btnGiaoHang.setEnabled(false);

        btnDaGiao.setText("Đã giao");
        

        jButton7.setText("Huỷ");
        

        txtDiaChiDH.setBackground(new java.awt.Color(222, 231, 227));
        txtDiaChiDH.setBorder(null);

        jLabel54.setText("Địa chỉ");

        jButton6.setText("Chọn KH");
        

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDTDH)
                                    .addComponent(jSeparator2)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(txtTenKHDH)))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCTTDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator4)
                                    .addComponent(txtTKDDH)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDacQuyenDH, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboTTDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTienThuaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                            .addComponent(btnGiaoHang)
                                            .addGap(9, 9, 9)
                                            .addComponent(btnDaGiao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jButton6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtTongTienDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChiDH)
                                    .addComponent(jSeparator28))))))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKHDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSDTDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtDiaChiDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTienDH))
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDacQuyenDH))
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCTTDH))
                .addGap(9, 9, 9)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboTTDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(txtTKDDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtTienThuaDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDaGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane4.addTab("Đặt hàng", jPanel16);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btnThanhToan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mua.png"))); // NOI18N
        btnThanhToan3.setText("Thanh toán");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 194, 211));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));

        pnlCards.setBackground(new java.awt.Color(222, 231, 227));
        pnlCards.setMaximumSize(new java.awt.Dimension(825, 520));
        pnlCards.setLayout(new java.awt.CardLayout());

        pnlBanHang.setBackground(new java.awt.Color(222, 231, 227));
        pnlBanHang.setMaximumSize(new java.awt.Dimension(825, 520));
        pnlBanHang.setMinimumSize(new java.awt.Dimension(825, 520));

        jPanel3.setBackground(new java.awt.Color(222, 231, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHang.setBackground(new java.awt.Color(222, 231, 227));
        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGioHang);

        btnSuaGH.setText("Sửa giỏ hàng");
        btnSuaGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaGHActionPerformed(evt);
            }
        });

        btnXoaSanPham.setText("Xoá sản phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaSanPham)
                .addGap(61, 61, 61)
                .addComponent(btnSuaGH)
                .addGap(160, 160, 160))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaGH)
                    .addComponent(btnXoaSanPham)))
        );

        jPanel4.setBackground(new java.awt.Color(222, 231, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá đơn"));

        tblHoaDon.setBackground(new java.awt.Color(222, 231, 227));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Tên NV", "Ngày tạo", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(222, 231, 227));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblDanhSachSP.setBackground(new java.awt.Color(222, 231, 227));
        tblDanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Chất liệu", "Kích cỡ", "Màu sắc", "Thương hiệu", "Số lượng", "Đơn giá"
            }
        ));
        tblDanhSachSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhSachSP);

        jLabel27.setText("Tìm theo mã");

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

        btnThem.setText("+");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(222, 231, 227));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo hoá đơn"));

        jPanel18.setBackground(new java.awt.Color(222, 231, 227));

        jLabel55.setText("Tên KH");

        txtTenKH.setBackground(new java.awt.Color(222, 231, 227));
        txtTenKH.setBorder(null);
        

        jLabel56.setText("SĐT");

        txtSDTKH.setBackground(new java.awt.Color(222, 231, 227));
        txtSDTKH.setBorder(null);
        

        jLabel57.setText("Tổng tiền: ");

        txtTongTien.setText("0");

        jLabel58.setText("Khuyến Mãi (%):");

        txtKhuyenMai.setText("0");

        txtCanThanhToan.setText("0");

        jLabel59.setText("Cần thanh toán:");

        jLabel60.setText("Hình thức");

        cbbPTTT.setBackground(new java.awt.Color(222, 231, 227));
        cbbPTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "chọn...", "Tiền mặt", "Quét mã" }));
        

        jLabel61.setText("Tiền khách đưa");

        txtTienKhachDua.setBackground(new java.awt.Color(222, 231, 227));
        txtTienKhachDua.setBorder(null);
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        

        jLabel62.setText("Tiền thừa");

        txtTienThua.setText("0");

        btnTaoHoaDon.setText("Tạo HD");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnChonKH.setText("Chọn KH");
        btnChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKHActionPerformed(evt);
            }
        });

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mua.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDTKH)
                                    .addComponent(jSeparator30)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator29)
                                    .addComponent(txtTenKH)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienKhachDua))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator33)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                            .addComponent(jLabel59)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCanThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                            .addComponent(jLabel57)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnChonKH)
                                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                            .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator34, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonKH)
                .addGap(12, 12, 12)
                .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtTongTien))
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtKhuyenMai))
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtCanThanhToan))
                .addGap(9, 9, 9)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(cbbPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txtTienThua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 15, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanHangLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCards.add(pnlBanHang, "pnlBanHang");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tên shop");

        btnBanHang.setBackground(new java.awt.Color(153, 194, 211));
        btnBanHang.setText("Bán hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnLichSu.setBackground(new java.awt.Color(153, 194, 211));
        btnLichSu.setText("Lịch sử");
        btnLichSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSuActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(153, 194, 211));
        btnSanPham.setText("Sản phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(153, 194, 211));
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnKhuyenMai.setBackground(new java.awt.Color(153, 194, 211));
        btnKhuyenMai.setText("Khuyến mại");
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(153, 194, 211));
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(153, 194, 211));
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setBackground(new java.awt.Color(153, 194, 211));
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(153, 194, 211));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        jLabel30.setText("Người dùng:");

        txtNguoiDung.setText("nv03");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shop.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlCards, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtNguoiDung))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCards, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnSuaGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaGHActionPerformed
        int selectedRow = tblGioHang.getSelectedRow();

        if (selectedRow != -1) {
            String MaSPCanUpdate = tblGioHang.getValueAt(selectedRow, 0).toString();
            UpdateSoLuongTrongGioHang(MaSPCanUpdate);
        } else {
            // Hiển thị thông báo nếu không có sản phẩm nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong giỏ hàng để sửa số lượng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaGHActionPerformed


    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        listSPCT.clear();
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            return;
        }

        String MaHD = tblHoaDon.getValueAt(row, 0).toString();

        hoaDonService.HoaDonCho(MaHD);
        LoadHoaDonCho(MaHD);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblDanhSachSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSPMouseClicked

    }//GEN-LAST:event_tblDanhSachSPMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        SPCTVM SPCTVM = new SPCTVM();
        String MaSPCT = tblDanhSachSP.getValueAt(tblDanhSachSP.getSelectedRow(), 0).toString();

        boolean check = false;
        int row = tblHoaDon.getSelectedRow();
        String MaHD = tblHoaDon.getValueAt(row, 0).toString();

        int selectedRow = tblDanhSachSP.getSelectedRow();
        int rowHD = tblHoaDon.getSelectedRow();
        if (rowHD < 0) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn hóa đơn để thêm sản phẩm!");
            return;
        }
        if (selectedRow != -1) {
            String TenSP = tblDanhSachSP.getValueAt(tblDanhSachSP.getSelectedRow(), 1).toString();
            float DonGia = Float.parseFloat(tblDanhSachSP.getValueAt(tblDanhSachSP.getSelectedRow(), 7).toString());
            // Hiển thị hộp thoại nhập số lượng
            String NhapSL = JOptionPane.showInputDialog(this, "Nhập số lượng:", "Nhập số lượng", JOptionPane.QUESTION_MESSAGE);
            System.out.println(NhapSL.length());
            if (NhapSL.trim().length() != 0) {
                try {
                    int soLuong = Integer.parseInt(NhapSL);
                    if (soLuong > 0) {
                        // Thực hiện thêm sản phẩm vào giỏ hàng
                        SPCTVM.setMaSPCT(MaSPCT);
                        SPCTVM.setTenSP(TenSP);
                        if (hoaDonRes.findMaaHDCtBySpct(MaSPCT, MaHD) != null) {
                            SPCTVM.setSoLuongTon(soLuong + hoaDonRes.findHdctByMaHdct(MaSPCT, MaHD));
                        } else {
                            SPCTVM.setSoLuongTon(soLuong);
                        }
                        SPCTVM.setDonGia(DonGia);
                        check = UpdateLaiGioHang(MaSPCT, TenSP, soLuong, DonGia, MaHD);
                        UpdateLaiSanpham(MaSPCT, soLuong);
                    } else {
                        JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là một số nguyên dương.");
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để thêm vào giỏ hàng.");
            return;
        }

        if (!check) {

            Sps.put(tblGioHang.getValueAt(tblGioHang.getRowCount() - 1, 0).toString(), Integer.parseInt(tblGioHang.getValueAt(tblGioHang.getRowCount() - 1, 2).toString()));
        }

        String TenNV = "hai";
        String TenKH = txtTenKH.getText();
        int TrangThaiHD = 0;

        HoaDon hd = new HoaDon();
        hd.setMaHD(MaHD);
        hd.setTenNV(TenNV);
        hd.setTenKH(TenKH);
        hd.setTrangThaiHD(TrangThaiHD);
        listSPCT.add(SPCTVM);

        if (!check) {
            hoaDonService.add(hd, Sps);
            LoadTableGioHang();
            Sps.clear();
        } else {
            LoadHoaDonCho(MaHD);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        try {
            pnlCards.removeAll();
            pnlCards.add(pnlBanHang);
            pnlCards.repaint();
            pnlCards.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnLichSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichSuActionPerformed
        try {
            pnlCards.removeAll();
            pnlCards.add(new LichSuJPanel());
            pnlCards.repaint();
            pnlCards.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnLichSuActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        try {
            pnlCards.removeAll();
            pnlCards.add(new SPCTJPanel());
            pnlCards.repaint();
            pnlCards.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        try {
            pnlCards.removeAll();
            pnlCards.add(new KhachHangJPanel());
            pnlCards.repaint();
            pnlCards.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        try {
            pnlCards.removeAll();
            pnlCards.add(new KhuyenMaiJPanel());
            pnlCards.repaint();
            pnlCards.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        try {
            pnlCards.removeAll();
            pnlCards.add(new NhanVienJPanel());
            pnlCards.repaint();
            pnlCards.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
//        try {
//            pnlCards.removeAll();
//            pnlCards.add(new ThongKeJPanel());
//            pnlCards.repaint();
//            pnlCards.revalidate();
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        try {
            pnlCards.removeAll();
            pnlCards.add(new DoiMatKhauJPanel());
            pnlCards.repaint();
            pnlCards.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            this.dispose();
            new LoginJFrame().setVisible(true);
        } catch (Exception e) {
        }
    }

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
//       1: trang thai cho, 0 trang thai thanh cong
        hoaDonRes.add(new HoaDon(new Random().nextInt(10000) + "", 1, new Date()));
        LoadTableHoaDon();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed

    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKHActionPerformed
//        new KhachHangJFrame().setVisible(true);
    }//GEN-LAST:event_btnChonKHActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        boolean check = false;
        int rowHD = tblHoaDon.getSelectedRow();
//        if (rowHD < 0) {
//            JOptionPane.showMessageDialog(this, "chọn hoá đơn bạn muốn thanh toán");
//            return;
//        }
//        
//        if (txtTenKH.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "chưa có thông tin khách hàng");
//            return;
//        }
//        
//        if (txtTienKhachDua.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "tiền khách đưa không được để trống");
//            return;
//        }
//        
//        try {
//            if (Double.parseDouble(txtTienKhachDua.getText()) < Double.parseDouble(txtCanThanhToan.getText())) {
//                JOptionPane.showMessageDialog(this, "tiền khách đưa chưa đủ");
//                return;
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Tiền khách đưa không hợp lệ");
//            return;
//        }

        int row = tblHoaDon.getSelectedRow();
        for (int j = 0; j < tblGioHang.getRowCount(); j++) {
            Sps.put(tblGioHang.getValueAt(j, 0).toString(), Integer.parseInt(tblGioHang.getValueAt(j, 2).toString()));
        }
        //        for (int i = 0; i < tblHoaDon.getRowCount(); i++) {

        String MaHD = tblHoaDon.getValueAt(row, 0).toString();
        String TenNV = "hai";
        String TenKH = txtTenKH.getText();
        int TrangThaiHD = 0;

        HoaDon hd = new HoaDon();
        hd.setMaHD(MaHD);
        hd.setTenKH(TenKH);
        hd.setTenNV(TenNV);
        hd.setTrangThaiHD(TrangThaiHD);
        if (!check) {
            hoaDonService.add(hd, Sps);
            LoadTableGioHang();
            Sps.clear();
        } else {
            
        }
        //        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        try {
            Double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText().trim());
            Double CanThanhToan = Double.parseDouble(txtCanThanhToan.getText());
            Double TienThua = tienKhachDua - CanThanhToan;
            DecimalFormat format = new DecimalFormat("#,###");
            txtTienThua.setText(String.valueOf(format.format(TienThua)));

        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        int selectedRow = tblGioHang.getSelectedRow();
        int rowHD = tblHoaDon.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "chọn 1 sản phẩm trong giỏ hàng để xoá");
            return;
        }
        if (rowHD < 0) {
            JOptionPane.showMessageDialog(this, "chọn hoá đơn bạn muốn xoá sản phẩm");
            return;
        }
        if (selectedRow != -1) {
            String MaSPCanXoa = tblGioHang.getValueAt(selectedRow, 0).toString();
            XoaSPGioHang(MaSPCanXoa);
            UpdateSoLuongTrongGioHang(MaSPCanXoa);
//            Updatekhixoa(MaSPCanXoa, tblDanhSachSP.getSelectedRow());
        } else {
            // Hiển thị thông báo nếu không có sản phẩm nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong giỏ hàng để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    public Boolean UpdateLaiGioHang(String MaSP, String TenSP, int SoLuong, float DonGia, String mahd) {
        if (tblGioHang.getRowCount() == 0) {
            dtmgh.addRow(new Object[]{
                MaSP,
                TenSP,
                SoLuong,
                DonGia,
                new BigDecimal(SoLuong * DonGia)
            });
            return false;
        }

        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            String MaSPGH = tblGioHang.getValueAt(i, 0).toString();
            if (MaSPGH.equals(MaSP)) {
                for (int j = 0; j < listSPCT.size(); j++) {
                    if (listSPCT.get(j).getMaSPCT().equals(MaSP)) {
                        listSPCT.remove(j);
                        break;
                    }
                }
                int SoLuongGH = Integer.parseInt(tblGioHang.getValueAt(i, 2).toString());
                dtmgh.setValueAt((SoLuongGH + SoLuong), i, 2);
                float donGia = Float.parseFloat(tblGioHang.getValueAt(i, 3).toString());
                dtmgh.setValueAt((SoLuongGH + SoLuong) * donGia, i, 4);
                hoaDonRes.updateSlHdCT(MaSPGH, Integer.parseInt(dtmgh.getValueAt(i, 2).toString()),
                        Double.parseDouble(dtmgh.getValueAt(i, 3).toString()), mahd);

                return true; // exit the method after updating the existing row
            }
        }

        // If the product is not found, add a new row
        dtmgh.addRow(new Object[]{
            MaSP,
            TenSP,
            SoLuong,
            DonGia,
            SoLuong * DonGia
        });
        return false;
    }

    public void UpdateLaiSanpham(String MaCTSP, int SoLuong) {
        for (int i = 0; i < tblDanhSachSP.getRowCount(); i++) {
            String MaSP = tblDanhSachSP.getValueAt(i, 0).toString();
            if (MaSP.equals(MaCTSP)) {
                int SoLuongSP = Integer.parseInt(tblDanhSachSP.getValueAt(i, 6).toString());
                tblDanhSachSP.setValueAt(SoLuongSP - SoLuong, i, 6);
                new SPCTRepos().updateSL(MaSP, SoLuongSP - SoLuong);
                break;
            }
        }
    }

    public void UpdateSoLuongTrongGioHang(String MaSP) {
        int SoLuongCu = 0; // Số lượng hiện tại của sản phẩm trong giỏ hàng

        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            String MaSPTrongGioHang = tblGioHang.getValueAt(i, 0).toString();
            if (MaSPTrongGioHang.equals(MaSP)) {
                SoLuongCu = Integer.parseInt(tblGioHang.getValueAt(i, 2).toString()); // Lấy số lượng hiện tại
                String NhapSLNew = JOptionPane.showInputDialog(this, "Nhập số lượng mới:");

                if (NhapSLNew != null && !NhapSLNew.isEmpty()) {
                    try {
                        int SoLuongMoi = Integer.parseInt(NhapSLNew);
                        if (SoLuongMoi > 0) {
                            // Cập nhật số lượng mới trong bảng giỏ hàng
                            tblGioHang.setValueAt(SoLuongMoi, i, 2);

                            // Gọi phương thức cập nhật lại bảng sản phẩm với mã và số lượng đã lưu trữ
                            UpdateSauSua(MaSP, SoLuongCu, SoLuongMoi);
                        } else {
                            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là một số nguyên dương.");
                    }
                }
                break; // Thoát sau khi sửa số lượng
            }
        }
    }

    public void UpdateSauSua(String MaCTSP, int SoLuongCu, int SoLuongMoi) {
        for (int i = 0; i < tblDanhSachSP.getRowCount(); i++) {
            String maSP = tblDanhSachSP.getValueAt(i, 0).toString();
            if (maSP.equals(MaCTSP)) {
                int SoLuongCon = Integer.parseInt(tblDanhSachSP.getValueAt(i, 6).toString());
                int SoLuongCapNhat = SoLuongCon + (SoLuongCu - SoLuongMoi);
                tblDanhSachSP.setValueAt(SoLuongCapNhat, i, 6);
                break;
            }
        }
    }

    public void XoaSPGioHang(String MaSP) {
        int SoLuongXoa = 0; // Số lượng sẽ được lưu trữ từ bảng giỏ hàng

        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            String MaSPTrongGioHang = tblGioHang.getValueAt(i, 0).toString();
            if (MaSPTrongGioHang.equals(MaSP)) {
                SoLuongXoa = Integer.parseInt(tblGioHang.getValueAt(i, 2).toString()); // Lưu trữ số lượng
                dtmgh.removeRow(i);
                break; // Thoát sau khi xóa hàng
            }
        }

        // Gọi phương thức cập nhật lại bảng sản phẩm với mã và số lượng đã lưu trữ
        Updatekhixoa(MaSP, SoLuongXoa);
    }

    public void Updatekhixoa(String MaCTSP, int SoLuongSP) {
        for (int i = 0; i < tblDanhSachSP.getRowCount(); i++) {
            String MaSP = tblDanhSachSP.getValueAt(i, 0).toString();
            if (MaSP.equals(MaCTSP)) {
                int SoLuongCon = Integer.parseInt(tblDanhSachSP.getValueAt(i, 6).toString());
                tblDanhSachSP.setValueAt(SoLuongSP + SoLuongCon, i, 6);
                break;
            }
        }

    }

//    public void TongTien() {
//
//        float ThanhTien = 0;
//        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
//            ThanhTien += Float.valueOf(tblGioHang.getValueAt(i, 4).toString());
//        }
//
//        txtTongTienn.setText(String.valueOf(ThanhTien));
//        System.out.println(ThanhTien);
//    }
    public void TinhTien() {
       
        float CanThanhToan = 0;
        float ThanhTien = 0;
        double Khuyenmai = 0.20f*100;
        int Tienkhachdua = 0;
        float Tienthua = 0;
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            ThanhTien += Float.valueOf(tblGioHang.getValueAt(i, 4).toString());
            CanThanhToan = (float) (ThanhTien - (ThanhTien*Khuyenmai/100));
            Tienthua = Tienkhachdua - CanThanhToan;
        }

        txtTongTien.setText(String.valueOf(ThanhTien));
        txtKhuyenMai.setText(String.valueOf(Khuyenmai));
        txtCanThanhToan.setText(String.valueOf(CanThanhToan));
        txtTienKhachDua.setText(String.valueOf(Tienkhachdua));
        txtTienThua.setText(String.valueOf(Tienthua));
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
            java.util.logging.Logger.getLogger(BanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnDaGiao;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnGiaoHang;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuy4;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnLichSu;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnSuaGH;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnTaoHoaDon4;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToan3;
    private javax.swing.JButton btnThanhToan4;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cbbPTTT;
    private javax.swing.JComboBox<String> cboTTDatHang;
    private javax.swing.JComboBox<String> cboTTTaiQuay3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JTable tblDanhSachSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JLabel txtCTTDH;
    private javax.swing.JLabel txtCanThanhToan;
    private javax.swing.JLabel txtCanThanhToanTQ3;
    private javax.swing.JLabel txtDacQuyenDH;
    private javax.swing.JLabel txtDacQuyenTQ3;
    private javax.swing.JTextField txtDiaChiDH;
    private javax.swing.JLabel txtKhuyenMai;
    private javax.swing.JLabel txtNguoiDung;
    private javax.swing.JTextField txtSDTDH;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtSDTTQ3;
    private javax.swing.JTextField txtTKDDH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenKHDH;
    private javax.swing.JTextField txtTenKHTaiQuay4;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienKhachDuaTQ4;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txtTienThua3;
    private javax.swing.JLabel txtTienThuaDH;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JLabel txtTongTien4;
    private javax.swing.JLabel txtTongTienDH;
    // End of variables declaration//GEN-END:variables

}
