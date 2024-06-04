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
public class HoaDon {
    private UUID Id, IdTK, IdKH, IdPTTT;
    private String MaHD,TenTK,TenKH,TenPTTT;
    private Date NgayTao;
    private float TongTien;
    private int TrangThaiHD;

    public HoaDon() {
    }
    
    public HoaDon(String maHd, int TrangThaiHD, Date ngayTao) {
         this.MaHD = maHd;
         this.TrangThaiHD = TrangThaiHD;
         this.NgayTao = ngayTao;
    }
    
    public HoaDon(String maHd, String TenTK, String tenKH, Date ngayTao, int TrangThaiHD) {
        this.MaHD = maHd;
        this.TenTK = TenTK;
        this.TenKH = tenKH;
        this.NgayTao = ngayTao;
        this.TrangThaiHD = TrangThaiHD;
    }

    public HoaDon(UUID Id, UUID IdTK, UUID IdKH, UUID IdPTTT, String MaHD, String TenTK, String TenKH, String TenPTTT, Date NgayTao, float TongTien, int TrangThaiHD) {
        this.Id = Id;
        this.IdTK = IdTK;
        this.IdKH = IdKH;
        this.IdPTTT = IdPTTT;
        this.MaHD = MaHD;
        this.TenTK = TenTK;
        this.TenKH = TenKH;
        this.TenPTTT = TenPTTT;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.TrangThaiHD = TrangThaiHD;
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

    public UUID getIdKH() {
        return IdKH;
    }

    public void setIdKH(UUID IdKH) {
        this.IdKH = IdKH;
    }

    public UUID getIdPTTT() {
        return IdPTTT;
    }

    public void setIdPTTT(UUID IdPTTT) {
        this.IdPTTT = IdPTTT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTenPTTT() {
        return TenPTTT;
    }

    public void setTenPTTT(String TenPTTT) {
        this.TenPTTT = TenPTTT;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public int getTrangThaiHD() {
        return TrangThaiHD;
    }

    public void setTrangThaiHD(int TrangThaiHD) {
        this.TrangThaiHD = TrangThaiHD;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "Id=" + Id + ", IdTK=" + IdTK + ", IdKH=" + IdKH + ", IdPTTT=" + IdPTTT + ", MaHD=" + MaHD + ", TenTK=" + TenTK + ", TenKH=" + TenKH + ", TenPTTT=" + TenPTTT + ", NgayTao=" + NgayTao + ", TongTien=" + TongTien + ", TrangThaiHD=" + TrangThaiHD + '}';
    }
}
