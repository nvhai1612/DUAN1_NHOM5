/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TaiKhoan;
import Repository.Impl.TaiKhoanRepo;
import Service.ITaiKhoanService;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TaiKhoanService implements ITaiKhoanService{
    private TaiKhoanRepo taiKhoanRepo = new  TaiKhoanRepo();
    @Override
    public ArrayList<TaiKhoan> getListFromDB() {
    
        return taiKhoanRepo.getListFromDB();
    
    }
    
}
