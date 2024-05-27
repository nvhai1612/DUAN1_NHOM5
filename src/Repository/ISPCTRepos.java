/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModel.SanPhamChiTiet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ISPCTRepos {
    public ArrayList<SanPhamChiTiet> getListFormDB();
    public Boolean add(SanPhamChiTiet spct);
    public Boolean update(SanPhamChiTiet spct);
    public Boolean delete(String id);
    public ArrayList<SanPhamChiTiet> search();
}
