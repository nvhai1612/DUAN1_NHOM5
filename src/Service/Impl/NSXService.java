/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NSX;
import Repository.Impl.NSXRepos;
import ViewModel.NSXVM;
import java.util.ArrayList;
import Service.INSXService;

/**
 *
 * @author Admin
 */
public class NSXService implements INSXService{
    
    private NSXRepos NSXRepos = new NSXRepos();

    public NSXService() {
    }

    @Override
    public ArrayList<NSXVM> getAll() {
        ArrayList<NSX> list = NSXRepos.getListFormDB();
        ArrayList<NSXVM> listVM = new ArrayList<>();
        for (NSX nsx : list) {
            NSXVM nsxvm = new NSXVM(nsx.getId(), nsx.getMaNSX(), nsx.getTenNSX());
            listVM.add(nsxvm);
        }
        return listVM;
    }

    @Override
    public ArrayList<NSX> getAllDomain() {
        return NSXRepos.getListFormDB();
    }

    @Override
    public void add(NSX nsx) {
        NSXRepos.add(nsx);
    }

    @Override
    public void update(NSX nsx) {
        NSXRepos.update(nsx);
    }
    
}
