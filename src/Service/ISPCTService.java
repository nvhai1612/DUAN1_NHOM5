/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.SanPhamChiTiet;
import ViewModel.SPCTVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ISPCTService {
    ArrayList<SPCTVM> getAll();
    ArrayList<SanPhamChiTiet>getAllDoMain();
    void add(SanPhamChiTiet ctsp);
    void update(SanPhamChiTiet ctsp);
    void delete(String MaCTSP);
    ArrayList<SanPhamChiTiet> search (String MaCTSP);
}
