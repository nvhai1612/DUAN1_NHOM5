/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.PTTT;
import Repository.Impl.PTTTRepos;
import Service.IPTTTService;
import ViewModel.PTTTVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PTTTService implements IPTTTService{
    
    PTTTRepos PTTTRepos = new PTTTRepos();

    @Override
    public ArrayList<PTTTVM> getAll() {
        ArrayList<PTTT> listPTTT = PTTTRepos.getListFormDB();
        ArrayList<PTTTVM> ListVM = new ArrayList<>();
        for (PTTT pttt : listPTTT){
            PTTTVM ptttvm = new PTTTVM(pttt.getId(), pttt.getMaPTTT(), pttt.getTenPTTT());
            ListVM.add(ptttvm);
        }
        return ListVM;
    }

    @Override
    public ArrayList<PTTT> getAllDomain() {
        return PTTTRepos.getListFormDB();
    }
    
}
