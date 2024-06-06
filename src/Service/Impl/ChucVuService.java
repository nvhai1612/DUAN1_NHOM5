/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChucVu;
import Repository.Impl.ChucVuRepos;
import Service.IChucVuService;
import ViewModel.ChucVuVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ChucVuService implements IChucVuService{
    private ChucVuRepos ChucVuRepos = new ChucVuRepos();

    @Override
    public ArrayList<ChucVuVM> getAll() {
        ArrayList<ChucVu> listCV = ChucVuRepos.getListFormDB();
        ArrayList<ChucVuVM> listVM = new ArrayList<>();
        for (ChucVu cv : listCV) {
            ChucVuVM cvvm = new ChucVuVM(cv.getId(), cv.getMaCV(), cv.getTenCV());
            listVM.add(cvvm);
        }
        return listVM;
    }

    @Override
    public ArrayList<ChucVu> getAllDomain() {
        return ChucVuRepos.getListFormDB();
    }

    @Override
    public void add(ChucVu cv) {
        ChucVuRepos.add(cv);
    }

    @Override
    public void update(ChucVu cv) {
        ChucVuRepos.update(cv);
    }
    
}
