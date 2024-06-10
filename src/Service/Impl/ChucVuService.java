/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Repository.Impl.ChucVuRepo;
import Service.IChucVuService;
import Utiliti.DBConnection;
import java.util.ArrayList;
import java.util.Collection;
import Utiliti.DBConnection;
import ViewModel.ChucVuVM;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class ChucVuService implements IChucVuService {
    private ChucVuRepo chucVuRepo = new ChucVuRepo();

    DBConnection connection;

    @Override
    public ArrayList<ChucVu> getAllDoMain() {

        return chucVuRepo.getListFormDB();

    }

    @Override
    public ArrayList<ChucVuVM> getAll() {
        ArrayList<ChucVu> listCV = chucVuRepo.getListFormDB();
        ArrayList<ChucVuVM> listCVVM = new ArrayList<>();
        for (ChucVu cv : listCV) {
            ChucVuVM cvvm = new ChucVuVM(cv.getId(), cv.getMaCV(), cv.getTenCV());
            listCVVM.add(cvvm);
        }
        return listCVVM;
    }

    @Override
    public void add(ChucVu cv) {
    chucVuRepo.add(cv);
    }

    @Override
    public void update(ChucVu cv) {
    chucVuRepo.update(cv);
    }
    
    @Override
    public ArrayList<ChucVu> search(String MaCV) {
    return chucVuRepo.search(MaCV);
    
    }

    @Override
    public ArrayList<NhanVien> searchbyCV(String TenCV) {
   return  chucVuRepo.searchbyCV(TenCV);
}

}
