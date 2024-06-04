/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModel.TaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface ITaiKhoanRepo {
    public ArrayList<TaiKhoan> getListFromDB();
   
}
