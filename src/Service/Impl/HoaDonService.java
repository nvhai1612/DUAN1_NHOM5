/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.HoaDon;
import DomainModel.SanPhamChiTiet;
import Repository.Impl.HDCTCTRepos;
import Repository.Impl.HoaDonRepos;
import Repository.Impl.khachhangfakeRes;
import Service.IHoaDonService;
import ViewModel.HoaDonVM;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService{
    private HoaDonRepos hoadonrepos = new HoaDonRepos();
    private HDCTCTRepos hdctrepos = new HDCTCTRepos();
    private khachhangfakeRes khachhngRespo = new khachhangfakeRes();
    
    @Override
    public ArrayList<HoaDonVM> getAll() {
        ArrayList<HoaDon> listHD = hoadonrepos.getListFormDB();
        ArrayList<HoaDonVM> listVM = new ArrayList<>();
        for (HoaDon hd : listHD) {
            HoaDonVM hdvm = new HoaDonVM(hd.getMaHD(), hd.getTenNV(), hd.getTenKH(), hd.getNgayTao(), hd.getTrangThaiHD());
            listVM.add(hdvm);
        }
        return listVM;
    }        
        public ArrayList<HoaDonVM> getAllHoaDon() {
        ArrayList<HoaDon> listHD = hoadonrepos.getListHoaDonFormDB();
        ArrayList<HoaDonVM> listVM = new ArrayList<>();
        for (HoaDon hd : listHD) {
            HoaDonVM hdvm = new HoaDonVM(hd.getMaHD(), hd.getTenNV(),hd.getNgayTao(), hd.getTrangThaiHD());
            listVM.add(hdvm);
        }
        return listVM;
    }

    @Override
    public ArrayList<HoaDon> getAllDomain() {
        return hoadonrepos.getListFormDB();
    }

    public void add(HoaDon hd, Map<String, Integer> maSPs) {
        HoaDon hd2 = hoadonrepos.findHoaDonByMa(hd.getMaHD());
        hd.setId(hd2.getId());
//        hd.setIdKH(khachhngRespo.SelectById(hd2.getTenKH()));
//        hd.setIdNV(nhanvienRespon.SelectByname(hd2.getTenNV()));
        hoadonrepos.update(hd2);
        hdctrepos.add(hd2, maSPs);
    }
    
    @Override
    public void add(HoaDon hd, Set<String> mapSps) {
//        HoaDon hd2 = hoadonrepos.findHoaDonByMa(hd.getMaHD());
//        hd.setId(hd2.getId());
//        hd.setIdKH(khachhngRespo.SelectById(hd2.getTenKH()));
////        hd.setIdNV(nhanvienRespon.SelectByname(hd2.getTenNV()));
//        hoadonrepos.update(hd2);
//        hdctrepos.add(hd2, maSps);
    }
    
    public void updateTrangThaiHoaDon(String maHDCT,Integer TrangThaiHD, Float TongTien, String mahd){
        hoadonrepos.updateTrangThaiHoaDon(maHDCT,TrangThaiHD, TongTien, mahd);
    }
    
    public ArrayList<SanPhamChiTiet> HoaDonCho(String MaHD){
        return hoadonrepos.HoaDonCho(MaHD);
    }
}
