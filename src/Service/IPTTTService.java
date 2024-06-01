/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.PTTT;
import ViewModel.PTTTVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IPTTTService {
    ArrayList<PTTTVM> getAll();
    ArrayList<PTTT> getAllDomain();
}
