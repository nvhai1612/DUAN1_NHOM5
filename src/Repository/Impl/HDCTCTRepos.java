/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.HoaDon;
import Repository.IHDCTRepos;
import Utiliti.DBConnection;
import ViewModel.HoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class HDCTCTRepos implements IHDCTRepos{
      private DBConnection connection;
         
      private SPCTRepos SPCTRepos = new SPCTRepos();

     public Boolean add(HoaDon hd, Map<String, Integer> ctsps) {
         ctsps.keySet().forEach((t) -> {
             System.out.println(t);
         });
         for (String maSp : ctsps.keySet()) {
                     try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(
                
                        "INSERT INTO hoadonct(idhd,idspct,mahdct,dongia,soluong) Values(?,?,?,?,?)")){

            ps.setObject(1, hd.getId());
            ps.setObject(2, SPCTRepos.searchbyMaSp(maSp).getId());
            ps.setObject(3, new Random().nextInt(10000));
            ps.setObject(4, SPCTRepos.searchbyMaSp(maSp).getDonGia());
            ps.setObject(5, ctsps.get(maSp));

            ps.executeUpdate();
//            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        
        return null;
    }

    @Override
    public ArrayList<HoaDonDTO> getListFormDB() {
        ArrayList<HoaDonDTO> ListHDDTO = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                
                PreparedStatement ps = con.prepareStatement("select MaHD,IDKH,IDTK,h.TRANGTHAIHD,MASP,TENSP,SOLUONG,hc.DONGIA from hoadonct hc join hoadon h on h.id = hc.IDHD join SANPHAMCHITIET sc on sc.id = hc.IDSPCT join sanpham s on s.id = sc.IDSP")){
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                HoaDonDTO hddto = new HoaDonDTO();
                hddto.setMaHD(rs.getString(1));
                hddto.setTenKH(rs.getString(2));
                hddto.setTenNV(rs.getString(3));
                hddto.setTrangThai(rs.getInt(4));
                hddto.setMaSP(rs.getString(5));
                hddto.setTenSP(rs.getString(6));
                hddto.setSoLuong(rs.getInt(7));
                hddto.setDonGia(rs.getFloat(8));
                ListHDDTO.add(hddto);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListHDDTO;
    }
}