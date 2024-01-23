/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NSX;
import ViewModel.NSXVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface INSXService {
    ArrayList<NSXVM> getAll();
    ArrayList<NSX> getAllDomain();
    void add(NSX nsx);
    void update(NSX nsx);
}
