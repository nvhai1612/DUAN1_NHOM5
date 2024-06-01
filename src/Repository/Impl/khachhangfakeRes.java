/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import Utiliti.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class khachhangfakeRes {
    private DBConnection connection;

       
    public UUID SelectById(String id) {
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT id FROM khachhang WHERE tenkh = ?")){
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {                
                return UUID.fromString(rs.getString(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
