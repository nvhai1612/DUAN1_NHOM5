/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhuyenMai {
    private String  ID,IDSP,MAKM,TENKM;
    private float MUCGIAMGIA;
    private Date THOIGIANBATDAU;
    private Date THOIGIANKETTHUC;
    private int TRANGTHAI;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDSP() {
        return IDSP;
    }

    public void setIDSP(String IDSP) {
        this.IDSP = IDSP;
    }

    public String getMAKM() {
        return MAKM;
    }

    public void setMAKM(String MAKM) {
        this.MAKM = MAKM;
    }

    public String getTENKM() {
        return TENKM;
    }

    public void setTENKM(String TENKM) {
        this.TENKM = TENKM;
    }

    public float getMUCGIAMGIA() {
        return MUCGIAMGIA;
    }

    public void setMUCGIAMGIA(float MUCGIAMGIA) {
        this.MUCGIAMGIA = MUCGIAMGIA;
    }

    public Date getTHOIGIANBATDAU() {
        return THOIGIANBATDAU;
    }

    public void setTHOIGIANBATDAU(Date THOIGIANBATDAU) {
        this.THOIGIANBATDAU = THOIGIANBATDAU;
    }

    public Date getTHOIGIANKETTHUC() {
        return THOIGIANKETTHUC;
    }

    public void setTHOIGIANKETTHUC(Date THOIGIANKETTHUC) {
        this.THOIGIANKETTHUC = THOIGIANKETTHUC;
    }

    public int getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(int TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public KhuyenMai(String ID, String IDSP, String MAKM, String TENKM, float MUCGIAMGIA, Date THOIGIANBATDAU, Date THOIGIANKETTHUC, int TRANGTHAI) {
        this.ID = ID;
        this.IDSP = IDSP;
        this.MAKM = MAKM;
        this.TENKM = TENKM;
        this.MUCGIAMGIA = MUCGIAMGIA;
        this.THOIGIANBATDAU = THOIGIANBATDAU;
        this.THOIGIANKETTHUC = THOIGIANKETTHUC;
        this.TRANGTHAI = TRANGTHAI;
    }

    public KhuyenMai() {
    }

    public void setTRANGTHAI(String đang_hoạt_động) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
}
