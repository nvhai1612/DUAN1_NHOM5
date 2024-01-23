/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModel.NSX;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface INSXRepos {
    public ArrayList<NSX> getListFormDB();
    public Boolean add(NSX nsx);
    public Boolean update(NSX nsx);
}
