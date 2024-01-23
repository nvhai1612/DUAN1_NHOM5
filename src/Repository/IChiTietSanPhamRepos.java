/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModel.ChiTietSanPham;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IChiTietSanPhamRepos {
    public ArrayList<ChiTietSanPham> getListFormDB();
    public Boolean add(ChiTietSanPham ctsp);
    public Boolean update(ChiTietSanPham ctsp);
    public Boolean delete(String id);
}
