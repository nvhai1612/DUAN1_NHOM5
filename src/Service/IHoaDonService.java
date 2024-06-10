/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.HoaDon;
import ViewModel.HoaDonVM;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Admin
 */
public interface IHoaDonService {
    ArrayList<HoaDonVM> getAll();
    ArrayList<HoaDon> getAllDomain();
    void add(HoaDon hd, Set<String >mapSps);
}
