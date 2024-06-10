/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import ViewModel.ChucVuVM;
import java.util.ArrayList;

public interface IChucVuService {

    ArrayList<ChucVuVM> getAll();

    ArrayList<ChucVu> getAllDoMain();

    void add(ChucVu cv);

    void update(ChucVu cv);

    ArrayList<ChucVu> search(String MaCV);

    public ArrayList<NhanVien> searchbyCV(String TenCV);
}
