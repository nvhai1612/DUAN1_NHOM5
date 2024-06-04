/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.KhuyenMai;

import Repository.Impl.KhuyenMaiRepons;
import Repository.Impl.SanPhamRepos;
import Service.IkhuyenMaiSeviec;
import ViewModel.khuyeMaiVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class khuyenmaiseviec implements IkhuyenMaiSeviec{
    KhuyenMaiRepons respon = new KhuyenMaiRepons();

    @Override
    public ArrayList<khuyeMaiVM> getAll() {
         ArrayList<KhuyenMai> listSP = respon.getListFormDB();
        ArrayList<khuyeMaiVM> listVM = new ArrayList<>();
        for (KhuyenMai sp : listSP) {
            khuyeMaiVM spvm = new khuyeMaiVM(sp.getIdKM(), sp.getIDSP(), sp.getMaKM(), sp.getTenKM(),sp.getMucGiamGia(),sp.getThoiGianBatDau(),sp.getThoiGianKetThuc(),sp.getTrangThai(),sp.getSoLuong());
            listVM.add(spvm);
        }
        return listVM;
    }

    @Override
    public ArrayList<KhuyenMai> getAllDomain() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    @Override
    public void update(KhuyenMai km) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer add(khuyeMaiVM km) {
//        KhuyenMai newkm=new KhuyenMai(
//                km.getIdKM(),
//                km.getIDSP()
//                
//        );
//        
//        return km.add(d);
//    }

    @Override
    public void add(KhuyenMai km) {
        respon.add(km);
    }

    
    
}
