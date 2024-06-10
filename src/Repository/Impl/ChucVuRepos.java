/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.ChucVu;
import Repository.IChucVuRepos;
import Utiliti.DBConnection;
import java.util.ArrayList;
import java.sql.*;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class ChucVuRepos implements IChucVuRepos{
    DBConnection connection;

    @Override
    public ArrayList<ChucVu> getListFormDB() {
        ArrayList<ChucVu> listCV = new ArrayList<>();
        
        try (Connection con = connection.getConnection(); 
                PreparedStatement ps = con.prepareStatement("SELECT ID,MACV,TENCV FROM CHUCVU")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setId(rs.getObject(1, UUID.class));
                cv.setMaCV(rs.getString(2));
                cv.setTenCV(rs.getString(3));
                listCV.add(cv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCV;
    }

    @Override
    public Boolean add(ChucVu cv) {
        int check;

        try (Connection con = connection.getConnection(); 
                PreparedStatement ps = con.prepareStatement("INSERT INTO CHUCVU(MACV,TENCV) Values(?,?)")) {

            ps.setObject(1, cv.getMaCV());
            ps.setObject(2, cv.getTenCV());
            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(ChucVu cv) {
        int check;

        try (Connection con = connection.getConnection(); 
                PreparedStatement ps = con.prepareStatement("UPDATE CHUCVU SET TENCV = ? WHERE MACV = ?")) {

            ps.setObject(1, cv.getTenCV());
            ps.setObject(2, cv.getMaCV());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<ChucVu> search() {
        ArrayList<ChucVu> listCV = new ArrayList<>();
        try (Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM CHUCVU WHERE MACV = ?");){
            ps.executeUpdate();
            
            ChucVu cv = new ChucVu();
            ps.setObject(1, cv.getMaCV());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cv.setId((UUID) rs.getObject(1));
                cv.setMaCV(rs.getString(2));
                listCV.add(cv);
            } 
        } catch (Exception e) {
            e.getMessage();
        }
        return listCV;
    }
    
}
