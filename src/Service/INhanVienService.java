/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhanVien;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public interface INhanVienService {

    public ArrayList<NhanVien> getListFormDB();

    public Boolean add(NhanVien nv);

    public String update(NhanVien nv);

    public ArrayList<NhanVien> search(String MaNV);
    ArrayList<NhanVien> searchVaiTro(String vaiTro);

}
