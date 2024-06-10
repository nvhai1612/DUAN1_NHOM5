/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class NhanVienVM {
<<<<<<< HEAD
    private UUID Id, IdCV;
    private String MaNV, TenNV, CCCD, DiaChi, SDT, Email;
=======
    private UUID Id, IdTK;
    private String MaNV, TenNV, CCCD, DiaChi, SDT, Email, VaiTro;
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
    private int GioiTinh, TrangThaiNV;
    private Date NgaySinh;

    public NhanVienVM() {
    }

<<<<<<< HEAD
    public NhanVienVM(UUID Id, UUID IdCV, String MaNV, String TenNV, String CCCD, String DiaChi, String SDT, String Email, int GioiTinh, int TrangThaiNV, Date NgaySinh) {
        this.Id = Id;
        this.IdCV = IdCV;
=======
    public NhanVienVM(UUID Id, UUID IdTK, String MaNV, String TenNV, String CCCD, String DiaChi, String SDT, String Email, String VaiTro, int GioiTinh, int TrangThaiNV, Date NgaySinh) {
        this.Id = Id;
        this.IdTK = IdTK;
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.CCCD = CCCD;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
<<<<<<< HEAD
=======
        this.VaiTro = VaiTro;
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
        this.GioiTinh = GioiTinh;
        this.TrangThaiNV = TrangThaiNV;
        this.NgaySinh = NgaySinh;
    }

<<<<<<< HEAD
    public NhanVienVM(UUID Id, String MaNV, String TenNV, String CCCD, String DiaChi, String SDT, String Email, int GioiTinh, int TrangThaiNV, Date NgaySinh) {
=======
    public NhanVienVM(UUID Id, String MaNV, String TenNV, String CCCD, String DiaChi, String SDT, String Email, String VaiTro, int GioiTinh, int TrangThaiNV, Date NgaySinh) {
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
        this.Id = Id;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.CCCD = CCCD;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
<<<<<<< HEAD
=======
        this.VaiTro = VaiTro;
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
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

<<<<<<< HEAD
    public UUID getIdCV() {
        return IdCV;
    }

    public void setIdCV(UUID IdCV) {
        this.IdCV = IdCV;
=======
    public UUID getIdTK() {
        return IdTK;
    }

    public void setIdTK(UUID IdTK) {
        this.IdTK = IdTK;
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
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

<<<<<<< HEAD
=======
    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
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
<<<<<<< HEAD

=======
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
    
    @Override
    public String toString() {
        return TenNV;
    }
}
