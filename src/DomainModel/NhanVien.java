/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class NhanVien {
     private UUID Id, IdTK;
    private String MaNV, TenNV, CCCD, DiaChi, SDT, Email, VaiTro;
    private int GioiTinh, TrangThaiNV;
    private Date NgaySinh;

    public NhanVien() {
    }

    public NhanVien(UUID Id, UUID IdTK, String MaNV, String TenNV, String CCCD, String DiaChi, String SDT, String Email, String VaiTro, int GioiTinh, int TrangThaiNV, Date NgaySinh) {
        this.Id = Id;
        this.IdTK = IdTK;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.CCCD = CCCD;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.VaiTro = VaiTro;
        this.GioiTinh = GioiTinh;
        this.TrangThaiNV = TrangThaiNV;
        this.NgaySinh = NgaySinh;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public UUID getIdTK() {
        return IdTK;
    }

    public void setIdTK(UUID IdTK) {
        this.IdTK = IdTK;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getTrangThaiNV() {
        return TrangThaiNV;
    }

    public void setTrangThaiNV(int TrangThaiNV) {
        this.TrangThaiNV = TrangThaiNV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }


    
}
