/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModel.HoaDon;
import ViewModel.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IHDCTRepos {
    public ArrayList<HoaDonDTO> getListFormDB();
     public ArrayList<HoaDonDTO> search(String ma);
}
