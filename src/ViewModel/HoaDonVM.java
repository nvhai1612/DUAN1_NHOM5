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
public class HoaDonVM {
    private UUID Id, IdTK, IdKH;
    private String MaHD,TenTK,TenKH;
    private Date NgayTao;
    private int TrangThaiHD;

    public HoaDonVM() {
    }
    
    public HoaDonVM(String maHD, String tenTK, Date ngayTao, int trangThaiHD) {
        this.MaHD = maHD;
        this.TenTK = tenTK;
        this.NgayTao = ngayTao;
        this.TrangThaiHD = trangThaiHD;
    }
    
    public HoaDonVM(String MaHD, String TenTK, String TenKH, Date NgayTao, int TrangThaiHD) {
        this.MaHD = MaHD;
        this.TenTK = TenTK;
        this.TenKH = TenKH;
        this.NgayTao = NgayTao;
        this.TrangThaiHD = TrangThaiHD;
    }

    public HoaDonVM(UUID Id, UUID IdTK, UUID IdKH, String MaHD, String TenTK, String TenKH, Date NgayTao, int TrangThaiHD) {
        this.Id = Id;
        this.IdTK = IdTK;
        this.IdKH = IdKH;
        this.MaHD = MaHD;
        this.TenTK = TenTK;
        this.TenKH = TenKH;
        this.NgayTao = NgayTao;
        this.TrangThaiHD = TrangThaiHD;
    }
    
}
