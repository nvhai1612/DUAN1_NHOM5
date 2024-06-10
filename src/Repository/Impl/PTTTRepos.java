/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.PTTT;
import Repository.IPTTTReops;
import Utiliti.DBConnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class PTTTRepos implements IPTTTReops{
    
    DBConnection connection;

    @Override
    public ArrayList<PTTT> getListFormDB() {
        ArrayList<PTTT> listPttt = new ArrayList<>();
        
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT ID,MAPTTT,TENPTTT FROM PHUONGTHUCTHANHTOAN")){
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PTTT pttt = new PTTT();
                pttt.setId(rs.getObject(1, UUID.class));
                pttt.setMaPTTT(rs.getString(2));
                pttt.setTenPTTT(rs.getString(3));
                listPttt.add(pttt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPttt;
    }
    
}
