/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChucVu;
import ViewModel.ChucVuVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IChucVuService {
    ArrayList<ChucVuVM> getAll();
    ArrayList<ChucVu> getAllDomain();
    void add(ChucVu cv);
    void update(ChucVu cv);
    ArrayList<ChucVu> search (String MaCV);
}
