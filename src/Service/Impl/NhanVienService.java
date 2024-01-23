/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NhanVien;
import Repository.Impl.NhanVienRepos;
import Service.INhanVienService;
import ViewModel.NhanVienVM;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class NhanVienService implements INhanVienService{
    private NhanVienRepos NhanVienRepos = new NhanVienRepos();

    public NhanVienService() {
    }

    @Override
    public ArrayList<NhanVienVM> getAll() {
        ArrayList<NhanVien> listNV = NhanVienRepos.getListFormDB();
        ArrayList<NhanVienVM> listNVVM = new ArrayList<>();
        for(NhanVien nv : listNV){
            NhanVienVM nvvm = new 
        NhanVienVM(nv.getId(), nv.getMaNV(), nv.getTenNV(), nv.getCCCD(), nv.getDiaChi(), 
                nv.getSDT(), nv.getEmail(), nv.getGioiTinh(), nv.getTrangThai(), nv.getNgaySinh());
            listNVVM.add(nvvm);
        }
        return listNVVM;
    }

    @Override
    public ArrayList<NhanVien> getAllDoMain() {
        return NhanVienRepos.getListFormDB();
    }

    @Override
    public void add(NhanVien nv) {
        NhanVienRepos.add(nv);
    }

    @Override
    public void update(NhanVien nv) {
        NhanVienRepos.update(nv);
    }

    @Override
    public void delete(String id) {
        NhanVienRepos.delete(id);
    }

    @Override
    public ArrayList<NhanVien> search(String MaNV) {
        return NhanVienRepos.search();
    }
    
}
