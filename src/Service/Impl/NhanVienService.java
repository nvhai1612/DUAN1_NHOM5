/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NhanVien;
import Repository.Impl.NhanVienRepos;
import Service.INhanVienService;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class NhanVienService implements INhanVienService{
    private NhanVienRepos nvRepo = new NhanVienRepos();

    @Override
    public ArrayList<NhanVien> getListFormDB() {
    return  nvRepo.getListFormDB();
    }

    @Override
    public Boolean add(NhanVien nv) {
    return nvRepo.add(nv);
    }

    @Override
    public String update(NhanVien nv) {
    return nvRepo.update(nv);
    }

    @Override
    public ArrayList<NhanVien> search(String MaNV) {
    return  nvRepo.search(MaNV);
    }

    @Override
    public ArrayList<NhanVien> searchVaiTro(String vaiTro) {
    return  nvRepo.searchVaiTro(vaiTro);}
    
}
