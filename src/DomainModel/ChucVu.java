/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.UUID;

/**
 *
 * @author Admin
 */
public class ChucVu {
    private UUID id;
    private String MaCV;
    private String TenCV;
    private int TrangThai ;

    public ChucVu(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public ChucVu() {
    }

    public ChucVu(UUID id, String MaCV, String TenCV) {
        this.id = id;
        this.MaCV = MaCV;
        this.TenCV = TenCV;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "id=" + id + ", MaCV=" + MaCV + ", TenCV=" + TenCV + '}';
    }
    
}
