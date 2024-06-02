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
    public String update(NhanVien nv ,UUID ID) {
    return nvRepo.update(nv,ID);
    }

    @Override
    public ArrayList<NhanVien> search(String MaNV) {
    return  nvRepo.search(MaNV);
    }
    
}
