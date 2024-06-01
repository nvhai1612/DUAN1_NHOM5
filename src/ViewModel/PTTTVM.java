/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.UUID;


/**
 *
 * @author Admin
 */
public class PTTTVM {
    private UUID id;
    private String MaPTTT;
    private String TenPTTT;

    public PTTTVM() {
    }

    public PTTTVM(UUID id, String MaPTTT, String TenPTTT) {
        this.id = id;
        this.MaPTTT = MaPTTT;
        this.TenPTTT = TenPTTT;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaPTTT() {
        return MaPTTT;
    }

    public void setMaPTTT(String MaPTTT) {
        this.MaPTTT = MaPTTT;
    }

    public String getTenPTTT() {
        return TenPTTT;
    }

    public void setTenPTTT(String TenPTTT) {
        this.TenPTTT = TenPTTT;
    }

    @Override
    public String toString() {
        return "PhuongThucThanhToan{" + "id=" + id + ", MaPTTT=" + MaPTTT + ", TenPTTT=" + TenPTTT + '}';
    }
}
