/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.HoaDon;
import Repository.IHoaDonRepos;
import Utiliti.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class HoaDonRepos implements IHoaDonRepos{
    private DBConnection connection;

    @Override
    public ArrayList<HoaDon> getListFormDB() {
        ArrayList<HoaDon> listCV = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT *\n" +
"FROM     HOADON INNER JOIN\n" +
"                  HOADONCT ON HOADON.ID = HOADONCT.IDHD INNER JOIN\n" +
"                  KHACHHANG ON HOADON.IDKH = KHACHHANG.ID \n" +
"				  INNER JOIN\n" +
"                  NHANVIEN ON HOADON.IDTK = NHANVIEN.ID")){
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(4));
                hd.setNgayTao(rs.getDate(8));
                hd.setTenTK(rs.getString(18));
                hd.setTrangThaiHD(rs.getInt(6));
                listCV.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCV;
}

    @Override
    public Boolean add(HoaDon hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
