/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.NSX;
import Repository.INSXRepos;
import java.util.ArrayList;
import java.sql.*;
import Utiliti.DBConnection;

/**
 *
 * @author Admin
 */
public class NSXRepos implements INSXRepos{

    private DBConnection connection;
    
    @Override
    public ArrayList<NSX> getListFormDB() {
        ArrayList<NSX> listNSX = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT ID,MANSX,TENNSX FROM NSX")){
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                NSX nsx = new NSX();
                nsx.setId(rs.getString(1));
                nsx.setMaNSX(rs.getString(2));
                nsx.setTenNSX(rs.getString(3));
                listNSX.add(nsx);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNSX;
    }

    @Override
    public Boolean add(NSX nsx) {
        int check;
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO NSX(MANSX,TENNSX) Values(?,?)")){
            
            ps.setObject(1, nsx.getMaNSX());
            ps.setObject(2, nsx.getTenNSX());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Boolean update(NSX nsx) {
        int check;
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("UPDATE NSX SET TENNSX = ? WHERE MANSX = ?")){

            ps.setObject(1, nsx.getTenNSX());
            ps.setObject(2, nsx.getMaNSX());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    
    }

}
