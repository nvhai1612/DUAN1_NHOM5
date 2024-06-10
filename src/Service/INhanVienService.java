/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhanVien;
import ViewModel.NhanVienVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface INhanVienService {
    ArrayList<NhanVienVM> getAll();
    ArrayList<NhanVien>getAllDoMain();
    void add(NhanVien nv);
    void update(NhanVien nv);
    ArrayList<NhanVien> search (String MaNV);
}
