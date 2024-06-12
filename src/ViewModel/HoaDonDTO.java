/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import oracle.sql.DATE;

/**
 *
 * @author Admin
 */
public class HoaDonDTO {
    private String MaHD, TenNV, TenKH, MaSP, TenSP,DiaChi,SDT;
    private int TrangThai, SoLuong;
    private float DonGia;
    private String ngayThanhToan;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String MaHD, String TenNV, String TenKH, String MaSP, String TenSP, String DiaChi, String SDT, String ngayThanhToan, int TrangThai, int SoLuong, float DonGia) {
        this.MaHD = MaHD;
        this.TenNV = TenNV;
        this.TenKH = TenKH;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.ngayThanhToan = ngayThanhToan;
        this.TrangThai = TrangThai;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

  

    
}
