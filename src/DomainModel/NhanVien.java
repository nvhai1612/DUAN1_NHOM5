/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

<<<<<<< HEAD
import java.util.Date;
import java.util.UUID;

=======
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
/**
 *
 * @author Admin
 */
public class NhanVien {
<<<<<<< HEAD
    private UUID Id, IdCV;
    private String MaNV, TenNV, CCCD, DiaChi, SDT, Email;
    private int GioiTinh, TrangThaiNV;
    private Date NgaySinh;

    public NhanVien() {
    }

    public NhanVien(UUID Id, UUID IdCV, String MaNV, String TenNV, String CCCD, String DiaChi, String SDT, String Email, int GioiTinh, int TrangThaiNV, Date NgaySinh) {
        this.Id = Id;
        this.IdCV = IdCV;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.CCCD = CCCD;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
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

    public UUID getIdCV() {
        return IdCV;
    }

    public void setIdCV(UUID IdCV) {
        this.IdCV = IdCV;
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

    @Override
    public String toString() {
        return "NhanVien{" + "Id=" + Id + ", IdCV=" + IdCV + ", MaNV=" + MaNV + ", TenNV=" + TenNV + ", CCCD=" + CCCD + ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", Email=" + Email + ", GioiTinh=" + GioiTinh + ", TrangThaiNV=" + TrangThaiNV + ", NgaySinh=" + NgaySinh + '}';
    }
=======
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144
    
}
